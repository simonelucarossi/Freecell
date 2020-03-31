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



	public GameGui(GameOfCards _game) {
		dimensions = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		screen_width = dimensions.width;
		screen_height = dimensions.height;

		this.game = _game;
		this.batch = new SpriteBatch();
		this.loaderTexture = new LoaderTexture();
		this.font = new BitmapFont();

		this.card_height = (int) this.game.getLevel().getPilesOfCards().get(0).getCards().getLast().getHeight();
		this.card_width = (int) game.getLevel().getPilesOfCards().get(0).getCards().getLast().getWidth();


		fontSizeX = (float) 0.5;
		fontSizeY = (float) 0.5;

		camera = new OrthographicCamera(dimensions.width, dimensions.height);
		camera.position.set((float)dimensions.getWidth()/2.0f,(float)dimensions.getHeight()/2.0f, 0.0f);
	}

	public void drawLevel() {



		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.begin();


		this.pile_margin = screen_width/11;
		this.card_padding = screen_height/10;



		batch.draw(loaderTexture.textureBackgroundTable, 0, 0, screen_width, screen_height);

		for(int q = 0; q < 4; q++) {
			batch.draw(loaderTexture.textureEmptyBoxe, this.game.getLevel().getFreeCells().get(q).getPositionX(), this.game.getLevel().getFreeCells().get(q).getPositionY(), this.game.getLevel().getFreeCells().get(q).getWidth(), this.game.getLevel().getFreeCells().get(q).getHeight());
			batch.draw(loaderTexture.textureScales, this.game.getLevel().getScales().get(q).getPositionX(), this.game.getLevel().getScales().get(q).getPositionY(), this.game.getLevel().getScales().get(q).getWidth(), this.game.getLevel().getScales().get(q).getHeight());
		}

		/*for (int q = 0; q < 4; q++) {
			batch.draw(loaderTexture.textureScales, (screen_width - 150), (screen_height - (220 * q)), screen_width/17, screen_height/7);
		}*/



		HashMap<String, Texture[]> textures = new HashMap<String, Texture[]>() {
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

		HashMap<String, Texture[]> selectedTextures = new HashMap<String, Texture[]>() {
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

		////
		// DRAW PILES OF CARDS

		for (int j = 0; j < this.game.getLevel().getPilesOfCards().size(); j++) {
			Pile pileInspected = this.game.getLevel().getPilesOfCards().get(j);
			float card_positionX, card_positionY;
			Texture cardTexture;
			int i = 0;
			for (Card card : pileInspected.getCards()) {
				card_positionX = card.getPositionX();
				card_positionY = card.getPositionY();
				if(card.isSelected()) {
					cardTexture = selectedTextures.get(card.getSuit())[(int) (card.getNumber() - 1)];
				} else {
					cardTexture = textures.get(card.getSuit())[(int) (card.getNumber() - 1)];
				}

				batch.draw(cardTexture, card_positionX, card_positionY, card_width, card_height);
				font.getData().setScale(1.0f, 1.0f);
				font.draw(batch, String.valueOf(card_positionX), card_positionX, card_positionY);
				font.draw(batch, String.valueOf(card_positionY), card_positionX+40, card_positionY);

				i++;
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
					cardTexture = selectedTextures.get(card.getSuit())[(int) (card.getNumber() - 1)];
				} else {
					cardTexture = textures.get(card.getSuit())[(int) (card.getNumber() - 1)];
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
				cardTexture = textures.get(card.getSuit())[(int) (card.getNumber() - 1)];
				
				batch.draw(cardTexture, card_positionX, card_positionY, card_width, card_height);
				font.getData().setScale(1.0f, 1.0f);
				font.draw(batch, String.valueOf(card_positionX), card_positionX, card_positionY);
				font.draw(batch, String.valueOf(card_positionY), card_positionX+40, card_positionY);
			}
		}

		//
		batch.draw(loaderTexture.textureCardsGameMenu, screen_width/2 - 70, 45, screen_width/24, screen_height/16);
		batch.draw(loaderTexture.texturePauseButton, screen_width/2 - 289, 45, screen_width/25, screen_height/16);
		batch.draw(loaderTexture.textureUndoButton, screen_width/2 + 152, 45, screen_width/24, screen_height/16);
		batch.draw(loaderTexture.textureScoreButton, screen_width/2 + 570, 45, screen_width/26, screen_height/17);
		batch.draw(loaderTexture.textureTimeButton, screen_width/3 - 480, 45, screen_width/24, screen_height/15);

		font.getData().setScale(fontSizeX * 3, fontSizeY * 3);
		font.draw(batch, "Menu", screen_width/2 - 58, 33);
		font.draw(batch, "Exit", screen_width/2 - 268, 33);
		font.draw(batch, "Hint", screen_width/2 + 172, 33);
		
		font.getData().setScale(fontSizeX * 4, fontSizeY * 4);
		font.draw(batch, "01:00", screen_width/3 - 380, 90);
		font.draw(batch, "100", screen_width/2 + 670, 90);
		
		batch.draw(loaderTexture.textureBackgroundTransparent, 0, 0, screen_width, screen_height);
		batch.draw(loaderTexture.textureMenuBackground, screen_width/3 + 100, screen_height/4, screen_width/4, screen_height/3 + 200);
		batch.draw(loaderTexture.textureBackGameButton, screen_width/3 + 165, screen_height/4 + 80, 350, 110);
		batch.draw(loaderTexture.textureNumberedGameButton, screen_width/3 + 165, screen_height/4 + 190, 350, 110);
		batch.draw(loaderTexture.textureRandomGameButton, screen_width/3 + 165, screen_height/4 + 300, 350, 110);

		batch.end();
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public void dispose() {
		this.batch.dispose();
	}
}

