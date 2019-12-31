package com.mygdx.game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.objects.Card;
import com.mygdx.objects.LoaderTexture;
import com.mygdx.objects.Pile;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	LoaderTexture loaderTexture;
	Pile primaFila;
	Dimension screenSize;
	int screen_width;
	int screen_height;
	ArrayList<Pile> pilesOfCards;
	int card_height, card_width, card_padding, pile_margin;


	@Override
	public void create () {
		loaderTexture = new LoaderTexture();
		pilesOfCards = new ArrayList<Pile>();

		for(int i = 0; i < 8; i++) {
			pilesOfCards.add(new Pile());
		}

		generateCards();

		this.card_height = (int) this.pilesOfCards.get(0).getCards().getLast().getHeight();
		this.card_width = (int) this.pilesOfCards.get(0).getCards().getLast().getWidth();
		this.pile_margin = 70;
		this.card_padding = 16;

		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screen_width = (int)screenSize.getWidth();
		screen_height = (int)screenSize.getHeight();

		batch = new SpriteBatch();

	}

	@Override
	public void render () {



		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		batch.begin();

		batch.draw(loaderTexture.textureBackgroundTable, 0, 0, 640, 480);
		
		for(int q = 0; q < 8; q++) {
			batch.draw(loaderTexture.textureEmptyBoxe, 50 + (q * this.pile_margin - 2), 390, card_width + 4, card_height + 6);
		}
		
		for(int q = 0; q < 4; q++) {
			batch.draw(loaderTexture.textureAces, 80 + (q * this.pile_margin - 2), 350, 30, 30);
		}
		
		for(int j = 0; j < pilesOfCards.size(); j++) {
			int i = 0;
			for(Card card : pilesOfCards.get(j).getCards()) {
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

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}


	public void generateCards() {
		int numberPile, generatedNumber;
		Card generatedCard;


		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			generatedCard = new Card(i, "Black", "Flowers");
			while(numberPile == 9) {
				generatedNumber = (int) ((Math.random()*((7-0)+1))+0);
				if(checkPileIsNotCompleted(generatedNumber)) {
					numberPile = generatedNumber;
				}
			}
			pilesOfCards.get(numberPile).insertCard(generatedCard);
		}

		
		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			generatedCard = new Card(i, "Red", "Hearts");
			while(numberPile == 9) {
				generatedNumber = (int) ((Math.random()*((7-0)+1))+0);
				if(checkPileIsNotCompleted(generatedNumber)) {
					numberPile = generatedNumber;
				}
			}
			pilesOfCards.get(numberPile).insertCard(generatedCard);
		}

		
		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			generatedCard = new Card(i, "Black", "Spades");
			while(numberPile == 9) {
				generatedNumber = (int) ((Math.random()*((7-0)+1))+0);
				if(checkPileIsNotCompleted(generatedNumber)) {
					numberPile = generatedNumber;
				}
			}
			pilesOfCards.get(numberPile).insertCard(generatedCard);
		}

		
		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			generatedCard = new Card(i, "Red", "Squares");
			while(numberPile == 9) {
				generatedNumber = (int) ((Math.random()*((7-0)+1))+0);
				if(checkPileIsNotCompleted(generatedNumber)) {
					numberPile = generatedNumber;
				}
			}
			pilesOfCards.get(numberPile).insertCard(generatedCard);
		}

	}
	
	public boolean checkPileIsNotCompleted(int index) {
		if(index <= 3 && this.pilesOfCards.get(index).getSize() == 7) {
			return false;
		}
		else if(index > 3 && this.pilesOfCards.get(index).getSize() == 6) {
			return false;
		}
		
		return true;
	}
}
