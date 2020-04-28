package com.mygdx.objects;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Level {
	private ArrayList<Pile> pilesOfCards;
	private ArrayList<FreeCell> freeCells;
	private ArrayList<Scale> scales;
	private BufferReader reader;
	Dimension dimensions;
	private int w,h;
	
	
	public Level() throws IOException {
		dimensions = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		
		
		
		w = dimensions.width;
		h = dimensions.height;
		create();
	}
	
	public Level(Level l) {
		dimensions = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		freeCells = new ArrayList<FreeCell>();
		scales = new ArrayList<Scale>();
		pilesOfCards = new ArrayList<Pile>();
		
		/* 
		freeCells.add(new FreeCell(264 + (0 * w/11 - 2), (h - 220), w/16, h/7, 8));
		freeCells.add(new FreeCell(264 + (1 * w/11 - 2), (h - 220), w/16, h/7, 9));
		freeCells.add(new FreeCell(264 + (2 * w/11 - 2), (h - 220), w/16, h/7, 10));
		freeCells.add(new FreeCell(264 + (3 * w/11 - 2), (h - 220), w/16, h/7, 11));
		*/
		
		freeCells.add(new FreeCell(20, (h - 1 * 220), w/17, h/7, 8));
		freeCells.add(new FreeCell(20, (h - 2 * 220), w/17, h/7, 9));
		freeCells.add(new FreeCell(20, (h - 3 * 220), w/17, h/7, 10));
		freeCells.add(new FreeCell(20, (h - 4 * 220), w/17, h/7, 11));
		
		
		

		scales.add(new Scale((w - 150), (h - 1 * 220), w/17, h/7, 12));
		scales.add(new Scale((w - 150), (h - 2 * 220), w/17, h/7, 13));
		scales.add(new Scale((w - 150), (h - 3 * 220), w/17, h/7, 14));
		scales.add(new Scale((w - 150), (h - 4 * 220), w/17, h/7, 15));

		generatePilesOfCards();
		
		w = dimensions.width;
		h = dimensions.height;
		cloneLevel(l);
	}
	
	
	
	
	//////
	// CREATE THE LEVEL
	
	public void create() throws IOException {

		freeCells = new ArrayList<FreeCell>();
		scales = new ArrayList<Scale>();
		pilesOfCards = new ArrayList<Pile>();
		
		/* 
		freeCells.add(new FreeCell(264 + (0 * w/11 - 2), (h - 220), w/16, h/7, 8));
		freeCells.add(new FreeCell(264 + (1 * w/11 - 2), (h - 220), w/16, h/7, 9));
		freeCells.add(new FreeCell(264 + (2 * w/11 - 2), (h - 220), w/16, h/7, 10));
		freeCells.add(new FreeCell(264 + (3 * w/11 - 2), (h - 220), w/16, h/7, 11));
		*/
		
		freeCells.add(new FreeCell(20, (h - 1 * 220), w/17, h/7, 8));
		freeCells.add(new FreeCell(20, (h - 2 * 220), w/17, h/7, 9));
		freeCells.add(new FreeCell(20, (h - 3 * 220), w/17, h/7, 10));
		freeCells.add(new FreeCell(20, (h - 4 * 220), w/17, h/7, 11));
		
		
		

		scales.add(new Scale((w - 150), (h - 1 * 220), w/17, h/7, 12));
		scales.add(new Scale((w - 150), (h - 2 * 220), w/17, h/7, 13));
		scales.add(new Scale((w - 150), (h - 3 * 220), w/17, h/7, 14));
		scales.add(new Scale((w - 150), (h - 4 * 220), w/17, h/7, 15));
		
		generatePilesOfCards();
		generateCards();
	}
	
	
	//////
	// GENERATE 8 EMPTY PILES OF CARDS
	public void generatePilesOfCards() {
		for(int i = 0; i < 8; i++) {
			this.pilesOfCards.add(new Pile(270 + (i * w/11), h - 220));
		}
	}
	
	//////
	// GENERATE CARDS TO INSERT IN THE 8 PILES
	
	public void generateCards() throws IOException {
		this.reader = new BufferReader(1);
		
		this.reader.readLine();
		while(this.reader.hasLine()) {
			System.out.println(this.reader.getLineReaded());
			this.reader.readLine();
		}
		
		int numberPile, generatedNumber = 0, columnWhereInsert = 0;
		float positionXWhereInsert, positionYWhereInsert;
		Card generatedCard;


		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			
			columnWhereInsert = generateColumnWhereInsertCard(numberPile, generatedNumber);
			positionXWhereInsert = this.pilesOfCards.get(columnWhereInsert).getPositionX(); 
			positionYWhereInsert = this.pilesOfCards.get(columnWhereInsert).getPositionY() - (h/31 * this.pilesOfCards.get(columnWhereInsert).getSize());
			
			generatedCard = new Card(i, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
			this.pilesOfCards.get(generatedCard.getColumn()).insertCard(generatedCard);
		}

		
		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			
			columnWhereInsert = generateColumnWhereInsertCard(numberPile, generatedNumber);
			positionXWhereInsert = this.pilesOfCards.get(columnWhereInsert).getPositionX(); 
			positionYWhereInsert = this.pilesOfCards.get(columnWhereInsert).getPositionY() - (h/31 * this.pilesOfCards.get(columnWhereInsert).getSize());
			
			generatedCard = new Card(i, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
			this.pilesOfCards.get(generatedCard.getColumn()).insertCard(generatedCard);
		}

		
		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			
			columnWhereInsert = generateColumnWhereInsertCard(numberPile, generatedNumber);
			positionXWhereInsert = this.pilesOfCards.get(columnWhereInsert).getPositionX(); 
			positionYWhereInsert = this.pilesOfCards.get(columnWhereInsert).getPositionY() - (h/31 * this.pilesOfCards.get(columnWhereInsert).getSize());
			
			generatedCard = new Card(i, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
			this.pilesOfCards.get(generatedCard.getColumn()).insertCard(generatedCard);
		}

		
		for(int i = 1; i < 14; i++) {
			numberPile = 9;
			
			columnWhereInsert = generateColumnWhereInsertCard(numberPile, generatedNumber);
			positionXWhereInsert = this.pilesOfCards.get(columnWhereInsert).getPositionX(); 
			positionYWhereInsert = this.pilesOfCards.get(columnWhereInsert).getPositionY() - (h/31 * this.pilesOfCards.get(columnWhereInsert).getSize());
			
			generatedCard = new Card(i, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
			this.pilesOfCards.get(generatedCard.getColumn()).insertCard(generatedCard);
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
	
	
	//////
	// COPY ANOTHER LEVEL
	
	public void cloneLevel(Level lPassed) {
		
		clearLevel();
		
		for(int i = 0; i < lPassed.getPilesOfCards().size(); i++) {
			for(Card cardM : lPassed.getPilesOfCards().get(i).getCards()) {
				this.pilesOfCards.get(i).insertCard(new Card(cardM.getNumber(), cardM.getColor(), cardM.getSuit(), cardM.getColumn(), cardM.getPositionX(), cardM.getPositionY()));
			}
		}
		
		
	}
	
	
	//////
	// CLEAN ALL ARRAY OF THE LEVEL
	
	public void clearLevel() {
		for(int i = 0; i < this.freeCells.size(); i++) {
			this.freeCells.get(i).getFreeCells().clear();;
		}
		
		for(int i = 0; i < scales.size(); i++) {
			this.scales.get(i).getScale().clear();
		}
		
		for(int i = 0; i < this.pilesOfCards.size(); i++) {
			this.pilesOfCards.get(i).getStackOfCards().clear();
		}
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

	/**
	 * @return the scales
	 */
	public ArrayList<Scale> getScales() {
		return scales;
	}

	/**
	 * @param scales the scales to set
	 */
	public void setScales(ArrayList<Scale> scales) {
		this.scales = scales;
	}

	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}

	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}

	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}

	public ArrayList<FreeCell> getFreeCells() {
		return freeCells;
	}

	public void setFreeCells(ArrayList<FreeCell> freeCells) {
		this.freeCells = freeCells;
	}

	
	

	
}
