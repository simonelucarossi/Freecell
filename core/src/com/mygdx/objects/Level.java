package com.mygdx.objects;

import java.util.ArrayList;

public class Level {
	private ArrayList<Pile> pilesOfCards;
	
	
	public Level() {
		create();
	}
	
	//////
	// CREATE THE LEVEL
	
	public void create() {
		
		pilesOfCards = new ArrayList<Pile>();
		
		generatePilesOfCards();
		generateCards();
	}
	
	
	//////
	// GENERATE 8 EMPTY PILES OF CARDS
	public void generatePilesOfCards() {
		for(int i = 0; i < 8; i++) {
			this.pilesOfCards.add(new Pile());
		}
	}
	
	//////
	// GENERATE CARDS TO INSERT IN THE 8 PILES
	
	public void generateCards() {
		int numberPile, generatedNumber = 0;
		Card generatedCard;


		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			generatedCard = new Card(i, "Black", "Flowers");
			this.pilesOfCards.get(generateColumnWhereInsertCard(numberPile, generatedNumber)).insertCard(generatedCard);
		}

		
		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			generatedCard = new Card(i, "Red", "Hearts");
			this.pilesOfCards.get(generateColumnWhereInsertCard(numberPile, generatedNumber)).insertCard(generatedCard);
		}

		
		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			generatedCard = new Card(i, "Black", "Spades");
			this.pilesOfCards.get(generateColumnWhereInsertCard(numberPile, generatedNumber)).insertCard(generatedCard);
		}

		
		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			generatedCard = new Card(i, "Red", "Squares");
			this.pilesOfCards.get(generateColumnWhereInsertCard(numberPile, generatedNumber)).insertCard(generatedCard);
		}

	}
	
	//////
	// CHECK IF A PILE IS COMPLETED, IF THAT'S TRUE, 
	// SELECT ANOTHER PILE WHERE I INSERT MY GENERATED CARD
	
	public boolean checkPileIsNotCompleted(int index) {
		if(index <= 3 && this.pilesOfCards.get(index).getSize() == 7) {
			return false;
		}
		else if(index > 3 && this.pilesOfCards.get(index).getSize() == 6) {
			return false;
		}
		
		return true;
	}

	
	
	//////
	// SELECT THE WRIGHT COLUMN WHERE ADD CARDS
	
	public int generateColumnWhereInsertCard(int numberPile, int generatedNumber) {
		while(numberPile == 9) {
			generatedNumber = (int) ((Math.random()*((7-0)+1))+0);
			if(checkPileIsNotCompleted(generatedNumber)) {
				numberPile = generatedNumber;
			}
		}
		
		return numberPile;
	}
	
	
	
	/**
	 * @return the pilesOfCards
	 */
	public ArrayList<Pile> getPilesOfCards() {
		return this.pilesOfCards;
	}

	/**
	 * @param pilesOfCards the pilesOfCards to set
	 */
	public void setPilesOfCards(ArrayList<Pile> pilesOfCards) {
		this.pilesOfCards = pilesOfCards;
	}
	
	
}