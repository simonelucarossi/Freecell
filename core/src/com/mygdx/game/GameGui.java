package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.objects.Card;

public class GameGui {
	private LoaderTexture loaderTexture;
	private SpriteBatch batch;
	private int card_height, card_width, card_padding, pile_margin;
	private BitmapFont font;
	private float fontSizeX, fontSizeY;
	private GameOfCards game;
	
	
	public GameGui(GameOfCards _game) {
		this.game = _game;
		this.batch = new SpriteBatch();
		this.loaderTexture = new LoaderTexture();
		this.font = new BitmapFont();
		
		this.card_height = (int) this.game.getLevel().getPilesOfCards().get(0).getCards().getLast().getHeight();
		this.card_width = (int) game.getLevel().getPilesOfCards().get(0).getCards().getLast().getWidth();
		this.pile_margin = 70;
		this.card_padding = 14;
		
		fontSizeX = (float) 0.5;
		fontSizeY = (float) 0.5;
	}
	
	public void drawLevel() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		batch.begin();

		batch.draw(loaderTexture.textureBackgroundTable, 0, 0, 640, 480);
		
		for(int q = 0; q < 8; q++) {
			batch.draw(loaderTexture.textureEmptyBoxe, 50 + (q * this.pile_margin - 2), 390, card_width + 4, card_height + 6);
		}
		
		for(int q = 0; q < 4; q++) {
			batch.draw(loaderTexture.textureAces, 57 + (q * this.pile_margin - 2), 411, 25, 30);
		}
		
		for(int j = 0; j < this.game.getLevel().getPilesOfCards().size(); j++) {
			int i = 0;
			for(Card card : this.game.getLevel().getPilesOfCards().get(j).getCards()) {
				if(card.getColor().equals("Black")) {
					if(card.getSuit().equals("Flowers")) {
						if(card.getNumber() == 1) {
							batch.draw(loaderTexture.textureAceFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 2) {	
							batch.draw(loaderTexture.textureTwoFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 3) {
							batch.draw(loaderTexture.textureThreeFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 4) {
							batch.draw(loaderTexture.textureFourFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 5) {	
							batch.draw(loaderTexture.textureFiveFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 6) {
							batch.draw(loaderTexture.textureSixFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 7) {
							batch.draw(loaderTexture.textureSevenFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 8) {	
							batch.draw(loaderTexture.textureEightFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 9) {
							batch.draw(loaderTexture.textureNineFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 10) {
							batch.draw(loaderTexture.textureTenFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 11) {	
							batch.draw(loaderTexture.textureKnightFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 12) {
							batch.draw(loaderTexture.textureQueenFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 13) {
							batch.draw(loaderTexture.textureKingFlowers, 50 + (j * this.pile_margin), 300 - (this.card_padding * i), card_width, card_height);
						}
					} 
					else {
						if(card.getNumber() == 1) {
							batch.draw(loaderTexture.textureAceSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 2) {	
							batch.draw(loaderTexture.textureTwoSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 3) {
							batch.draw(loaderTexture.textureThreeSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 4) {
							batch.draw(loaderTexture.textureFourSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 5) {	
							batch.draw(loaderTexture.textureFiveSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 6) {
							batch.draw(loaderTexture.textureSixSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 7) {
							batch.draw(loaderTexture.textureSevenSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 8) {	
							batch.draw(loaderTexture.textureEightSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 9) {
							batch.draw(loaderTexture.textureNineSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 10) {
							batch.draw(loaderTexture.textureTenSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 11) {	
							batch.draw(loaderTexture.textureKnightSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 12) {
							batch.draw(loaderTexture.textureQueenSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 13) {
							batch.draw(loaderTexture.textureKingSpades, 50 + (j * this.pile_margin), 300 - (this.card_padding * i), card_width, card_height);
						}
					}
				}

				else {
					if(card.getSuit().equals("Hearts")) {
						if(card.getNumber() == 1) {
							batch.draw(loaderTexture.textureAceHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 2) {	
							batch.draw(loaderTexture.textureTwoHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 3) {
							batch.draw(loaderTexture.textureThreeHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 4) {
							batch.draw(loaderTexture.textureFourHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 5) {	
							batch.draw(loaderTexture.textureFiveHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 6) {
							batch.draw(loaderTexture.textureSixHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 7) {
							batch.draw(loaderTexture.textureSevenHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 8) {	
							batch.draw(loaderTexture.textureEightHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 9) {
							batch.draw(loaderTexture.textureNineHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 10) {
							batch.draw(loaderTexture.textureTenHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 11) {	
							batch.draw(loaderTexture.textureKnightHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 12) {
							batch.draw(loaderTexture.textureQueenHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 13) {
							batch.draw(loaderTexture.textureKingHearts, 50 + (j * this.pile_margin), 300 - (this.card_padding * i), card_width, card_height);
						}
					} 
					else {
						if(card.getNumber() == 1) {
							batch.draw(loaderTexture.textureAceSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 2) {	
							batch.draw(loaderTexture.textureTwoSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 3) {
							batch.draw(loaderTexture.textureThreeSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 4) {
							batch.draw(loaderTexture.textureFourSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 5) {	
							batch.draw(loaderTexture.textureFiveSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 6) {
							batch.draw(loaderTexture.textureSixSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 7) {
							batch.draw(loaderTexture.textureSevenSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 8) {	
							batch.draw(loaderTexture.textureEightSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 9) {
							batch.draw(loaderTexture.textureNineSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 10) {
							batch.draw(loaderTexture.textureTenSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 11) {	
							batch.draw(loaderTexture.textureKnightSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height);
						}
						if(card.getNumber() == 12) {
							batch.draw(loaderTexture.textureQueenSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i),  card_width, card_height); 
						}
						if(card.getNumber() == 13) {
							batch.draw(loaderTexture.textureKingSquares, 50 + (j * this.pile_margin), 300 - (this.card_padding * i), card_width, card_height);
						}
					}
				}

				i++;
			}
		}

		
		
		batch.draw(loaderTexture.textureMenuGameBackground, 170 , 0, 270, 63);
		batch.draw(loaderTexture.textureCardsGameMenu, 295, 23, 25, 30);
		batch.draw(loaderTexture.texturePauseButton, 218, 25, 16, 22);
		batch.draw(loaderTexture.textureUndoButton, 379, 27, 14,18);
		
		font.getData().setScale(fontSizeX, fontSizeY);
		font.draw(batch, "Pause Game", 205, 19);
		font.draw(batch, "Play", 303, 19);
		font.draw(batch, "Undo", 379, 19);
		
		
		batch.end();
	}
	
	public void dispose() {
		this.batch.dispose();
	}
}
