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
		int columnWhereInsert = 0;
		float positionXWhereInsert, positionYWhereInsert;
		Card generatedCard = null;
		
		int generatedNumber = (int) ((Math.random()*((5-0)+1))+0);
		
		while(generatedNumber == 0) {
			generatedNumber = (int) ((Math.random()*((5-0)+1))+0);
		}
		
		this.reader = new BufferReader(generatedNumber);
		
		this.reader.readLine();
		while(this.reader.hasLine()) {
			columnWhereInsert = 0;
			
			for (String a : this.reader.getLineReaded().split(" ")) {
				
				//// GENERATES CARDS
				positionXWhereInsert = this.pilesOfCards.get(columnWhereInsert).getPositionX(); 
				positionYWhereInsert = this.pilesOfCards.get(columnWhereInsert).getPositionY() - (h/31 * this.pilesOfCards.get(columnWhereInsert).getSize());
				
				//// HEARTS
				if(a.equals("AH")) {
					generatedCard = new Card(1, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				} 
				else if(a.equals("2H")) {
					generatedCard = new Card(2, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("3H")) {
					generatedCard = new Card(3, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("4H")) {
					generatedCard = new Card(4, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("5H")) {
					generatedCard = new Card(5, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("6H")) {
					generatedCard = new Card(6, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("7H")) {
					generatedCard = new Card(7, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("8H")) {
					generatedCard = new Card(8, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("9H")) {
					generatedCard = new Card(9, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("10H")) {
					generatedCard = new Card(10, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("JH")) {
					generatedCard = new Card(11, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("QH")) {
					generatedCard = new Card(12, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("KH")) {
					generatedCard = new Card(13, "Red", "Hearts", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				
				//// FLOWERS
				
				if(a.equals("AF")) {
					generatedCard = new Card(1, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				} 
				else if(a.equals("2F")) {
					generatedCard = new Card(2, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("3F")) {
					generatedCard = new Card(3, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("4F")) {
					generatedCard = new Card(4, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("5F")) {
					generatedCard = new Card(5, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("6F")) {
					generatedCard = new Card(6, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("7F")) {
					generatedCard = new Card(7, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("8F")) {
					generatedCard = new Card(8, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("9F")) {
					generatedCard = new Card(9, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("10F")) {
					generatedCard = new Card(10, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("JF")) {
					generatedCard = new Card(11, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("QF")) {
					generatedCard = new Card(12, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("KF")) {
					generatedCard = new Card(13, "Black", "Flowers", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				
				//// SPADES
				
				if(a.equals("ASP")) {
					generatedCard = new Card(1, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				} 
				else if(a.equals("2SP")) {
					generatedCard = new Card(2, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("3SP")) {
					generatedCard = new Card(3, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("4SP")) {
					generatedCard = new Card(4, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("5SP")) {
					generatedCard = new Card(5, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("6SP")) {
					generatedCard = new Card(6, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("7SP")) {
					generatedCard = new Card(7, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("8SP")) {
					generatedCard = new Card(8, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("9SP")) {
					generatedCard = new Card(9, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("10SP")) {
					generatedCard = new Card(10, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("JSP")) {
					generatedCard = new Card(11, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("QSP")) {
					generatedCard = new Card(12, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("KSP")) {
					generatedCard = new Card(13, "Black", "Spades", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				
				
				//// SQUARES
				
				if(a.equals("ASQ")) {
					generatedCard = new Card(1, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				} 
				else if(a.equals("2SQ")) {
					generatedCard = new Card(2, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("3SQ")) {
					generatedCard = new Card(3, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("4SQ")) {
					generatedCard = new Card(4, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("5SQ")) {
					generatedCard = new Card(5, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("6SQ")) {
					generatedCard = new Card(6, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("7SQ")) {
					generatedCard = new Card(7, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("8SQ")) {
					generatedCard = new Card(8, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("9SQ")) {
					generatedCard = new Card(9, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("10SQ")) {
					generatedCard = new Card(10, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("JSQ")) {
					generatedCard = new Card(11, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("QSQ")) {
					generatedCard = new Card(12, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				else if(a.equals("KSQ")) {
					generatedCard = new Card(13, "Red", "Squares", columnWhereInsert, positionXWhereInsert, positionYWhereInsert);
				}
				
				this.pilesOfCards.get(generatedCard.getColumn()).insertCard(generatedCard);
				///////
	            columnWhereInsert++;
			}
			this.reader.readLine();
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
