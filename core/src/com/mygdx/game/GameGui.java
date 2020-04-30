package com.mygdx.game;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.objects.Button;
import com.mygdx.objects.Card;
import com.mygdx.objects.Pile;

public class GameGui {
	private LoaderTexture loaderTexture;
	private SpriteBatch batch;
	private int card_height, card_width, card_padding, pile_margin, screen_width, screen_height;
	private BitmapFont font;
	private float fontSizeX, fontSizeY;
	private GameOfCards game;
	OrthographicCamera camera;
	Dimension dimensions;
	HashMap<String, Texture[]> texturesHashMap, selectedTexturesHashMap; 



	public GameGui(GameOfCards _game) {
		dimensions = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		screen_width = (int)dimensions.getWidth();
		screen_height = (int)dimensions.getHeight();

		this.game = _game;
		this.batch = new SpriteBatch();
		this.loaderTexture = new LoaderTexture();
		this.font = new BitmapFont();

		this.card_height = (int) this.game.getLevel().getPilesOfCards().get(0).getCards().getLast().getHeight();
		this.card_width = (int) game.getLevel().getPilesOfCards().get(0).getCards().getLast().getWidth();


		fontSizeX = (float) 0.5;
		fontSizeY = (float) 0.5;

		camera = new OrthographicCamera((float)dimensions.getWidth(), (float)dimensions.getHeight());
		camera.position.set((float)dimensions.getWidth()/2.0f,(float)dimensions.getHeight()/2.0f, 0.0f);

		this.pile_margin = screen_width/11;
		this.card_padding = screen_height/10;

		initTexturesHashMaps();
	}

	public void drawLevel() {



		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();


		batch.draw(loaderTexture.textureBackgroundTable, 0, 0, screen_width, screen_height);

		for(int q = 0; q < 4; q++) {
			batch.draw(loaderTexture.textureEmptyBoxe, this.game.getLevel().getFreeCells().get(q).getPositionX(), this.game.getLevel().getFreeCells().get(q).getPositionY(), this.game.getLevel().getFreeCells().get(q).getWidth(), this.game.getLevel().getFreeCells().get(q).getHeight());
			batch.draw(loaderTexture.textureScales, this.game.getLevel().getScales().get(q).getPositionX(), this.game.getLevel().getScales().get(q).getPositionY(), this.game.getLevel().getScales().get(q).getWidth(), this.game.getLevel().getScales().get(q).getHeight());
		}



		////
		// DRAW PILES OF CARDS

		if(!(this.game.isWin())) {
			for (int j = 0; j < this.game.getLevel().getPilesOfCards().size(); j++) {
				Pile pileInspected = this.game.getLevel().getPilesOfCards().get(j);
				float card_positionX, card_positionY;
				Texture cardTexture;
				int i = 0;

				batch.draw(loaderTexture.textureEmptyBoxePiles, pileInspected.getPositionX() - 10, pileInspected.getPositionY() + card_height - 65, card_width + 20, card_height/2);

				for (Card card : pileInspected.getCards()) {
					card_positionX = card.getPositionX();
					card_positionY = card.getPositionY();
					if(card.isSelected()) {
						cardTexture = selectedTexturesHashMap.get(card.getSuit())[(int) (card.getNumber() - 1)];
					} else {
						cardTexture = texturesHashMap.get(card.getSuit())[(int) (card.getNumber() - 1)];
					}

					batch.draw(cardTexture, card_positionX, card_positionY, card_width, card_height);
					font.getData().setScale(1.0f, 1.0f);

					i++;
				}
			}
		}



		////
		// DRAW CARDS IN FREE CELLS
		for (int j = 0; j < this.game.getLevel().getFreeCells().size(); j++) {
			ArrayList<Card> arrayInspected = this.game.getLevel().getFreeCells().get(j).getFreeCells();
			if(!arrayInspected.isEmpty()) {
				float card_positionX, card_positionY;
				Texture cardTexture;
				Card card = arrayInspected.get(0); 
				card_positionX = card.getPositionX();
				card_positionY = card.getPositionY();
				if(card.isSelected()) {
					cardTexture = selectedTexturesHashMap.get(card.getSuit())[(int) (card.getNumber() - 1)];
				} else {
					cardTexture = texturesHashMap.get(card.getSuit())[(int) (card.getNumber() - 1)];
				}

				batch.draw(cardTexture, card_positionX, card_positionY, card_width, card_height);
				font.getData().setScale(1.0f, 1.0f);
				font.draw(batch, String.valueOf(card_positionX), card_positionX, card_positionY);
				font.draw(batch, String.valueOf(card_positionY), card_positionX+40, card_positionY);
			}
		}



		////
		// DRAW CARDS OF SCALES
		for (int j = 0; j < this.game.getLevel().getScales().size(); j++) {
			ArrayList<Card> arrayInspected = this.game.getLevel().getScales().get(j).getScale();
			if(!arrayInspected.isEmpty()) {
				float card_positionX, card_positionY;
				Texture cardTexture;
				Card card = arrayInspected.get(arrayInspected.size() - 1); 
				card_positionX = card.getPositionX();
				card_positionY = card.getPositionY();
				cardTexture = texturesHashMap.get(card.getSuit())[(int) (card.getNumber() - 1)];

				batch.draw(cardTexture, card_positionX, card_positionY, card_width, card_height);
				font.getData().setScale(1.0f, 1.0f);
			}
		}


		drawMenuDuringGame();

		batch.draw(loaderTexture.textureScoreButton, screen_width/2 + 570, 45, screen_width/26, screen_height/17);
		batch.draw(loaderTexture.textureTimeButton, screen_width/3 - 480, 45, screen_width/24, screen_height/15);


		drawInfo();

		if(this.game.isPaused()) {
			drawPausedGameMenu();
		}

		if((this.game.isWin())) {
			drawVictory();
		}

		if(this.game.emptySpaces.size() > 0) {
			for(int i = 0; i < this.game.emptySpaces.size();i++) {
				batch.draw(loaderTexture.iaTexture, this.game.emptySpaces.get(i).x, this.game.emptySpaces.get(i).y, screen_width/17, screen_height/6 - 25);
			}
		}

		if(this.game.cardsToMove.size() > 0) {
			for(int i = 0; i < this.game.cardsToMove.size();i++) {
				if(i == 0) {
					batch.draw(loaderTexture.iaTexture, this.game.cardsToMove.get(i).x, this.game.cardsToMove.get(i).y, screen_width/17, screen_height/6 - 25);
				}
				else {
					batch.draw(loaderTexture.iaTexture2, this.game.cardsToMove.get(i).x, this.game.cardsToMove.get(i).y, screen_width/17, screen_height/6 - 25);
				}
			}
		}
		
		if(!(this.game.canMove)) {
			font.draw(batch, "NO CARDS TO MOVE", screen_width/2 - 90, 143);
		}


		batch.end();
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public void dispose() {
		this.batch.dispose();
	}



	///////////
	///// INIT METHODS

	public void initTexturesHashMaps() {
		this.texturesHashMap = new HashMap<String, Texture[]>() {
			{
				put("Flowers",
						new Texture[] { loaderTexture.textureAceFlowers, loaderTexture.textureTwoFlowers,
								loaderTexture.textureThreeFlowers, loaderTexture.textureFourFlowers, loaderTexture.textureFiveFlowers,
								loaderTexture.textureSixFlowers, loaderTexture.textureSevenFlowers, loaderTexture.textureEightFlowers,
								loaderTexture.textureNineFlowers, loaderTexture.textureTenFlowers, loaderTexture.textureKnightFlowers,
								loaderTexture.textureQueenFlowers, loaderTexture.textureKingFlowers });
				put("Spades",
						new Texture[] { loaderTexture.textureAceSpades, loaderTexture.textureTwoSpades,
								loaderTexture.textureThreeSpades, loaderTexture.textureFourSpades, loaderTexture.textureFiveSpades,
								loaderTexture.textureSixSpades, loaderTexture.textureSevenSpades, loaderTexture.textureEightSpades,
								loaderTexture.textureNineSpades, loaderTexture.textureTenSpades, loaderTexture.textureKnightSpades,
								loaderTexture.textureQueenSpades, loaderTexture.textureKingSpades });
				put("Hearts",
						new Texture[] { loaderTexture.textureAceHearts, loaderTexture.textureTwoHearts,
								loaderTexture.textureThreeHearts, loaderTexture.textureFourHearts, loaderTexture.textureFiveHearts,
								loaderTexture.textureSixHearts, loaderTexture.textureSevenHearts, loaderTexture.textureEightHearts,
								loaderTexture.textureNineHearts, loaderTexture.textureTenHearts, loaderTexture.textureKnightHearts,
								loaderTexture.textureQueenHearts, loaderTexture.textureKingHearts });
				put("Squares",
						new Texture[] { loaderTexture.textureAceSquares, loaderTexture.textureTwoSquares,
								loaderTexture.textureThreeSquares, loaderTexture.textureFourSquares, loaderTexture.textureFiveSquares,
								loaderTexture.textureSixSquares, loaderTexture.textureSevenSquares, loaderTexture.textureEightSquares,
								loaderTexture.textureNineSquares, loaderTexture.textureTenSquares, loaderTexture.textureKnightSquares,
								loaderTexture.textureQueenSquares, loaderTexture.textureKingSquares });
			}
		};

		this.selectedTexturesHashMap = new HashMap<String, Texture[]>() {
			{
				put("Flowers",
						new Texture[] { loaderTexture.textureAceFlowersSelected, loaderTexture.textureTwoFlowersSelected,
								loaderTexture.textureThreeFlowersSelected, loaderTexture.textureFourFlowersSelected, loaderTexture.textureFiveFlowersSelected,
								loaderTexture.textureSixFlowersSelected, loaderTexture.textureSevenFlowersSelected, loaderTexture.textureEightFlowersSelected,
								loaderTexture.textureNineFlowersSelected, loaderTexture.textureTenFlowersSelected, loaderTexture.textureKnightFlowersSelected,
								loaderTexture.textureQueenFlowersSelected, loaderTexture.textureKingFlowersSelected });
				put("Spades",
						new Texture[] { loaderTexture.textureAceSpadesSelected, loaderTexture.textureTwoSpadesSelected,
								loaderTexture.textureThreeSpadesSelected, loaderTexture.textureFourSpadesSelected, loaderTexture.textureFiveSpadesSelected,
								loaderTexture.textureSixSpadesSelected, loaderTexture.textureSevenSpadesSelected, loaderTexture.textureEightSpadesSelected,
								loaderTexture.textureNineSpadesSelected, loaderTexture.textureTenSpadesSelected, loaderTexture.textureKnightSpadesSelected,
								loaderTexture.textureQueenSpadesSelected, loaderTexture.textureKingSpadesSelected });
				put("Hearts",
						new Texture[] { loaderTexture.textureAceHeartsSelected, loaderTexture.textureTwoHeartsSelected,
								loaderTexture.textureThreeHeartsSelected, loaderTexture.textureFourHeartsSelected, loaderTexture.textureFiveHeartsSelected,
								loaderTexture.textureSixHeartsSelected, loaderTexture.textureSevenHeartsSelected, loaderTexture.textureEightHeartsSelected,
								loaderTexture.textureNineHeartsSelected, loaderTexture.textureTenHeartsSelected, loaderTexture.textureKnightHeartsSelected,
								loaderTexture.textureQueenHeartsSelected, loaderTexture.textureKingHeartsSelected });
				put("Squares",
						new Texture[] { loaderTexture.textureAceSquaresSelected, loaderTexture.textureTwoSquaresSelected,
								loaderTexture.textureThreeSquaresSelected, loaderTexture.textureFourSquaresSelected, loaderTexture.textureFiveSquaresSelected,
								loaderTexture.textureSixSquaresSelected, loaderTexture.textureSevenSquaresSelected, loaderTexture.textureEightSquaresSelected,
								loaderTexture.textureNineSquaresSelected, loaderTexture.textureTenSquaresSelected, loaderTexture.textureKnightSquaresSelected,
								loaderTexture.textureQueenSquaresSelected, loaderTexture.textureKingSquaresSelected });
			}
		};
	}

	///////////
	/////  DRAW METHODS

	public void drawPausedGameMenu() {
		batch.draw(loaderTexture.textureBackgroundTransparent, 0, 0, screen_width, screen_height);

		if(this.game.getMenuPausedGame().getName().equals("Paused Game Menu")) {
			batch.draw(loaderTexture.textureMenuBackground, this.game.getMenuPausedGame().getPositionX(), this.game.getMenuPausedGame().getPositionY(), this.game.getMenuPausedGame().getWidth(), this.game.getMenuPausedGame().getHeight());

			for(int i = 0; i < this.game.getMenuPausedGame().getButtons().size(); i++) {
				for(Button button : this.game.getMenuPausedGame().getButtons()) {
					if(button.getName().equals("Restart Game")) {
						batch.draw(loaderTexture.textureRandomGameButton, button.getPositionX(), button.getPositionY(), button.getWidth(), button.getHeight());
					} else if(button.getName().equals("New Game")) {
						batch.draw(loaderTexture.textureNumberedGameButton, button.getPositionX(), button.getPositionY(), button.getWidth(), button.getHeight());
					} else if(button.getName().equals("Back To Game")) {
						batch.draw(loaderTexture.textureBackGameButton, button.getPositionX(), button.getPositionY(), button.getWidth(), button.getHeight());
					}
				}
			}
		}
	}



	public void drawMenuDuringGame() {
		for(int i = 0; i < this.game.getMenuDuringGameButtons().size(); i++) {
			for(Button button : this.game.getMenuDuringGameButtons()) {
				if(button.getName().equals("Exit")) {
					batch.draw(loaderTexture.texturePauseButton, button.getPositionX(), button.getPositionY(), button.getWidth(), button.getHeight());
				} else if(button.getName().equals("Menu")) {
					batch.draw(loaderTexture.textureCardsGameMenu, button.getPositionX(), button.getPositionY(), button.getWidth(), button.getHeight());
				} else if(button.getName().equals("Hint")) {
					batch.draw(loaderTexture.textureUndoButton, button.getPositionX(), button.getPositionY(), button.getWidth(), button.getHeight());
				}
			}
		}
	}


	public void drawInfo() {
		font.getData().setScale(fontSizeX * 3, fontSizeY * 3);
		font.draw(batch, "Menu", screen_width/2 - 58, 33);
		font.draw(batch, "Exit", screen_width/2 - 268, 33);
		font.draw(batch, "Hint", screen_width/2 + 172, 33);

		font.getData().setScale(fontSizeX * 4, fontSizeY * 4);
		font.draw(batch, String.valueOf(this.game.getMovement()), screen_width/3 - 380, 90);
		font.draw(batch, String.valueOf(this.game.getScore()), screen_width/2 + 670, 90);
	}

	public void drawVictory() {
		batch.draw(loaderTexture.textureVictory, screen_width/4, 280, screen_width/2, screen_height/2 + 150);
	}
}

