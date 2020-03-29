package com.mygdx.game;

import java.awt.Dimension;
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
		}

		for (int q = 4; q < 8; q++) {
			batch.draw(loaderTexture.textureScales, 264 + (q * this.pile_margin - 2), (screen_height - 220), screen_width/16, screen_height/7);
		}

		

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

		batch.draw(loaderTexture.textureMenuGameBackground, 470, -10, screen_width/2, screen_height/9);
		batch.draw(loaderTexture.textureCardsGameMenu, 295, 23, 25, 30);
		batch.draw(loaderTexture.texturePauseButton, 218, 25, 16, 22);
		batch.draw(loaderTexture.textureUndoButton, 379, 27, 14, 18);

		font.getData().setScale(fontSizeX, fontSizeY);
		font.draw(batch, "Pause Game", 205, 19);
		font.draw(batch, "Play", 303, 19);
		font.draw(batch, "Undo", 379, 19);

		batch.end();
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public void dispose() {
		this.batch.dispose();
	}
}

				// if(card.getColor().equals("Black")) {
				// if(card.getSuit().equals("Flowers")) {
				// if(card.getNumber() == 1) {
				// System.out.println("POSIZIONE: " + card.getPositionX() + " " +
				// card.getPositionY());
				// if(!card.isSelected()) {
				// batch.draw(loaderTexture.textureAceFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// else {
				// batch.draw(loaderTexture.textureFourFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// }
				// if(card.getNumber() == 2) {
				// batch.draw(loaderTexture.textureTwoFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 3) {
				// batch.draw(loaderTexture.textureThreeFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 4) {
				// batch.draw(loaderTexture.textureFourFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 5) {
				// batch.draw(loaderTexture.textureFiveFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 6) {
				// batch.draw(loaderTexture.textureSixFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 7) {
				// batch.draw(loaderTexture.textureSevenFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 8) {
				// batch.draw(loaderTexture.textureEightFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 9) {
				// batch.draw(loaderTexture.textureNineFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 10) {
				// batch.draw(loaderTexture.textureTenFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 11) {
				// batch.draw(loaderTexture.textureKnightFlowers, card_positionX,
				// card_positionY, card_width, card_height);
				// }
				// if(card.getNumber() == 12) {
				// batch.draw(loaderTexture.textureQueenFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 13) {
				// batch.draw(loaderTexture.textureKingFlowers, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// }
				// else {
				// if(card.getNumber() == 1) {
				// batch.draw(loaderTexture.textureAceSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 2) {
				// batch.draw(loaderTexture.textureTwoSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 3) {
				// batch.draw(loaderTexture.textureThreeSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 4) {
				// batch.draw(loaderTexture.textureFourSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 5) {
				// batch.draw(loaderTexture.textureFiveSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 6) {
				// batch.draw(loaderTexture.textureSixSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 7) {
				// batch.draw(loaderTexture.textureSevenSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 8) {
				// batch.draw(loaderTexture.textureEightSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 9) {
				// batch.draw(loaderTexture.textureNineSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 10) {
				// batch.draw(loaderTexture.textureTenSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 11) {
				// batch.draw(loaderTexture.textureKnightSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 12) {
				// batch.draw(loaderTexture.textureQueenSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 13) {
				// batch.draw(loaderTexture.textureKingSpades, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// }
				// }

				// else {
				// if(card.getSuit().equals("Hearts")) {
				// if(card.getNumber() == 1) {
				// batch.draw(loaderTexture.textureAceHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 2) {
				// batch.draw(loaderTexture.textureTwoHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 3) {
				// batch.draw(loaderTexture.textureThreeHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 4) {
				// batch.draw(loaderTexture.textureFourHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 5) {
				// batch.draw(loaderTexture.textureFiveHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 6) {
				// batch.draw(loaderTexture.textureSixHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 7) {
				// batch.draw(loaderTexture.textureSevenHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 8) {
				// batch.draw(loaderTexture.textureEightHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 9) {
				// batch.draw(loaderTexture.textureNineHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 10) {
				// batch.draw(loaderTexture.textureTenHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 11) {
				// batch.draw(loaderTexture.textureKnightHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 12) {
				// batch.draw(loaderTexture.textureQueenHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 13) {
				// batch.draw(loaderTexture.textureKingHearts, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// }
				// else {
				// if(card.getNumber() == 1) {
				// batch.draw(loaderTexture.textureAceSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 2) {
				// batch.draw(loaderTexture.textureTwoSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 3) {
				// batch.draw(loaderTexture.textureThreeSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 4) {
				// batch.draw(loaderTexture.textureFourSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 5) {
				// batch.draw(loaderTexture.textureFiveSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 6) {
				// batch.draw(loaderTexture.textureSixSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 7) {
				// batch.draw(loaderTexture.textureSevenSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 8) {
				// batch.draw(loaderTexture.textureEightSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 9) {
				// batch.draw(loaderTexture.textureNineSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 10) {
				// batch.draw(loaderTexture.textureTenSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 11) {
				// batch.draw(loaderTexture.textureKnightSquares, card_positionX,
				// card_positionY, card_width, card_height);
				// }
				// if(card.getNumber() == 12) {
				// batch.draw(loaderTexture.textureQueenSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// if(card.getNumber() == 13) {
				// batch.draw(loaderTexture.textureKingSquares, card_positionX, card_positionY,
				// card_width, card_height);
				// }
				// }
				// }				i++;