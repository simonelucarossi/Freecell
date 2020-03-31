package com.mygdx.game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.objects.Card;
import com.mygdx.objects.FreeCell;
import com.mygdx.objects.Pile;
import com.mygdx.objects.Scale;

public class GameManager implements ApplicationListener {
	private GameOfCards game;
	private GameGui gameGui;
	private ArrayList<Card> selectedCards;
	long firstClick;
	boolean pause;


	@Override
	public void create () {
		this.game = new GameOfCards();
		this.gameGui = new GameGui(game);
		this.firstClick = 0;
		this.pause = true;
		
		this.selectedCards = new ArrayList<Card>();
	}

	@Override
	public void render () {
		gameGui.drawLevel();

		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			long secondClick = System.currentTimeMillis();
			if(secondClick - firstClick > 20000) {
				Vector3 tp = new Vector3();
				Vector3 mousePosition = gameGui.getCamera().unproject(tp.set(Gdx.input.getX(), Gdx.input.getY(), 0));
				System.out.println("CLICK DEL MOUSE! " + mousePosition.x + " " + mousePosition.y);


				checkMouseClick(mousePosition);
			}
		}
	}

	@Override
	public void dispose () {
		gameGui.dispose();
	}

	@Override
	public void resize(int width, int height) {
		gameGui.getCamera().viewportWidth = 1800; // Viewport of 30 units!
		gameGui.getCamera().viewportHeight = 900; // Lets keep things in proportion.
		gameGui.getCamera().update();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	public void checkMouseClick(Vector3 mousePosition) {

		if(this.selectedCards.isEmpty()) {
			tryCardSelection(mousePosition);
			tryFreeCellSelection(mousePosition);
			tryClickButton(mousePosition);
		} else {
			if(tryCardMovement(mousePosition)) {

			}

			else {
				deselectCards();
			}
		}
	}

	public void tryCardSelection(Vector3 mousePosition) {
		Pile listOfCards; 
		int topBorderOfCard = 30;
		ArrayList<Pile> listOfPiles = this.game.getLevel().getPilesOfCards(); 
		ArrayList<Card> tmpArray = new ArrayList<>();


		////
		// CHECK PILES OF CARDS
		for(int i = 0; i < listOfPiles.size(); i++) {

			listOfCards = listOfPiles.get(i);
			int cardPosition = 0;
			for(Card cardInspection : listOfCards.getCards()) {
				if(listOfCards.getLast().equals(cardInspection) &&
						mousePosition.x >= cardInspection.getPositionX() &&
						mousePosition.x  <= (cardInspection.getPositionX() + cardInspection.getWidth()) &&
						mousePosition.y >= cardInspection.getPositionY() &&
						mousePosition.y  <= (cardInspection.getPositionY() + cardInspection.getHeight())
						) {

					tmpArray.add(cardInspection);
					selectCards(tmpArray);
				} else if(mousePosition.x >= cardInspection.getPositionX() &&
						mousePosition.x  <= (cardInspection.getPositionX() + cardInspection.getWidth()) &&
						mousePosition.y >= cardInspection.getPositionY() + cardInspection.getHeight() - topBorderOfCard &&
						mousePosition.y  <= (cardInspection.getPositionY() + cardInspection.getHeight())
						) {
					System.out.println("HELLO");
					selectCards(calculateSelectedCards(listOfCards, cardInspection, cardPosition));
				}
				cardPosition++;
			}
		}



	}




	public void tryFreeCellSelection(Vector3 mousePosition) {
		int topBorderOfCard = 30;
		ArrayList<Card> tmpArray = new ArrayList<>();
		Card cardInspection;


		for(int i = 0; i < this.game.getLevel().getFreeCells().size(); i++) {
			if(!(this.game.getLevel().getFreeCells().get(i).getFreeCells().isEmpty())){
				cardInspection = this.game.getLevel().getFreeCells().get(i).getFreeCells().get(0);
				if(mousePosition.x >= cardInspection.getPositionX() &&
						mousePosition.x  <= (cardInspection.getPositionX() + cardInspection.getWidth()) &&
						mousePosition.y >= cardInspection.getPositionY() &&
						mousePosition.y  <= (cardInspection.getPositionY() + cardInspection.getHeight())
						) {

					tmpArray.add(cardInspection);
					selectCards(tmpArray);
				} 
			}
		}



	}



	public void selectCards(ArrayList<Card> _selectedCards) {
		this.selectedCards = _selectedCards;
		for(Card selectedCard : this.selectedCards) {
			selectedCard.setSelected(true);
		}
	}

	public ArrayList<Card> calculateSelectedCards(Pile listOfCards, Card selectedCard, int cardPosition) {
		ArrayList<Card> selectedCards = new ArrayList<Card>();

		if((numberBottomCards(listOfCards, cardPosition) + 1) > availableToMove()) {
			return selectedCards;
		} 

		int currentCardIndex = -1;
		Card previousCard = selectedCard;
		for(Card currentCard : listOfCards.getCards()) {
			currentCardIndex++;
			if(currentCardIndex <= cardPosition) {
				continue;
			}

			if(currentCard.getColor() == previousCard.getColor()) {
				selectedCards.clear();
				return selectedCards;
			}

			selectedCards.add(currentCard);
			previousCard = currentCard;
		}

		selectedCards.add(selectedCard);
		return selectedCards;
	}

	public int numberBottomCards(Pile listOfCards, int cardPosition) {
		return listOfCards.getSize() - cardPosition; 
	}

	public int availableToMove() {
		int counter = 1;
		for(int i = 0; i < this.game.getLevel().getFreeCells().size(); i++) {
			if(this.game.getLevel().getFreeCells().get(i).getFreeCells().isEmpty()) {
				counter++;
			}

		}

		for(int i = 0; i < this.game.getLevel().getPilesOfCards().size(); i++) {
			if(this.game.getLevel().getPilesOfCards().get(i).getSize() == 0) {
				counter++;
			}
		}
		return counter;
	}


	public boolean tryCardMovement(Vector3 mousePosition) {
		Pile listOfCards; 
		ArrayList<Pile> listOfPiles = this.game.getLevel().getPilesOfCards(); 
		Card cardInspection;
		FreeCell cellInspected;	
		Scale scaleInspected;
		ArrayList<Card> arrayCellInspected, arrayScaleInspected;
		Card cardCellInspected, cardScaleInspected;


		/* CHECK CARDS */

		for(int i = 0; i < listOfPiles.size(); i++) {

			listOfCards = listOfPiles.get(i);
			cardInspection = listOfCards.getLast();

			if(!(this.selectedCards.isEmpty()) && cardInspection.getColumn() != selectedCards.get(this.selectedCards.size() - 1).getColumn() &&
					mousePosition.x >= cardInspection.getPositionX() &&
					mousePosition.x  <= (cardInspection.getPositionX() + cardInspection.getWidth()) &&
					mousePosition.y >= cardInspection.getPositionY() &&
					mousePosition.y  <= (cardInspection.getPositionY() + cardInspection.getHeight()) &&
					!(cardInspection.getColor().equals(selectedCards.get(this.selectedCards.size() - 1).getColor())))
			{
				if(movingCardsFromPilesOfCards(selectedCards)) {
					moveSelectedCards(cardInspection);
				}
				else {
					moveSelectedCardsFromFreeCellToPilesOfCards(cardInspection);
				}
			} 
		}

		/* CHECK FREE CELLS */

		for(int i = 0; i < this.game.getLevel().getFreeCells().size(); i++) {
			cellInspected = this.game.getLevel().getFreeCells().get(i);	
			// System.out.println("Cella controllata SOPRA: " + cellInspected.getColumn()); 
			arrayCellInspected = this.game.getLevel().getFreeCells().get(i).getFreeCells();
			if((cellInspected.getFreeCells().isEmpty()) && !(this.selectedCards.isEmpty()) && (this.selectedCards.size() < 2) && cellInspected.getColumn() != selectedCards.get(this.selectedCards.size() - 1).getColumn() &&
					mousePosition.x >= cellInspected.getPositionX() &&
					mousePosition.x  <= (cellInspected.getPositionX() + cellInspected.getWidth()) &&
					mousePosition.y >= cellInspected.getPositionY() &&
					mousePosition.y  <= (cellInspected.getPositionY() + cellInspected.getHeight()))
			{
				//				System.out.println("Cella controllata: " + cellInspected.getColumn());
				//				System.out.println("Oggetti: " + cellInspected.getFreeCells().toString());
				cardCellInspected = new Card(0,"R","R", cellInspected.getColumn(), cellInspected.getPositionX(), cellInspected.getPositionY());
				if(movingCardsFromPilesOfCards(selectedCards)) {
					moveSelectedCardsToCells(cardCellInspected);
				}
			} 
		}


		/* CHECK SCALES */

		for(int i = 0; i < this.game.getLevel().getScales().size(); i++) {
			scaleInspected = this.game.getLevel().getScales().get(i);	
			arrayScaleInspected = this.game.getLevel().getScales().get(i).getScale();
			if((this.selectedCards.size() < 2) && !(this.selectedCards.isEmpty()) && isScaleSon(arrayScaleInspected, this.selectedCards.get(0)) && scaleInspected.getColumn() != selectedCards.get(this.selectedCards.size() - 1).getColumn() &&
					mousePosition.x >= scaleInspected.getPositionX() &&
					mousePosition.x  <= (scaleInspected.getPositionX() + scaleInspected.getWidth()) &&
					mousePosition.y >= scaleInspected.getPositionY() &&
					mousePosition.y  <= (scaleInspected.getPositionY() + scaleInspected.getHeight()))
			{
				cardScaleInspected = new Card(0,"R","R", scaleInspected.getColumn(), scaleInspected.getPositionX(), scaleInspected.getPositionY());
				if(movingCardsFromPilesOfCards(selectedCards)) {
					moveSelectedCardsToScale(cardScaleInspected);
				}
				else {
					moveSelectedCardsFromFreeCellToScale(cardScaleInspected);
				}
			} 
		}


		return false;
	}


	public void deselectCards() {
		for(int i = 0; i < this.selectedCards.size(); i ++)  {
			this.selectedCards.get(i).setSelected(false);
			this.selectedCards.remove(i);
		}
	}

	public void moveSelectedCards(Card cardPassed) {
		Card cardInspection = this.selectedCards.get(this.selectedCards.size() - 1);
		int columnWhereInsert = cardPassed.getColumn();
		float positionXWhereMove = cardPassed.getPositionX();
		float positionYWhereMove = this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getPositionY() - (this.game.getLevel().getH()/31 * this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getSize());

		cardInspection.setSelected(false);
		this.game.getLevel().getPilesOfCards().get(cardInspection.getColumn()).removeCard(cardInspection);
		cardInspection.setColumn(columnWhereInsert);
		cardInspection.setPositionX(positionXWhereMove);
		cardInspection.setPositionY(positionYWhereMove);
		this.game.getLevel().getPilesOfCards().get(cardPassed.getColumn()).insertCard(cardInspection);
		this.selectedCards.remove(this.selectedCards.remove(this.selectedCards.size() - 1));

		for(int i = 0; i < this.selectedCards.size(); i++) {
			positionYWhereMove = this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getPositionY() - (this.game.getLevel().getH()/31 * this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getSize());
			cardInspection = this.selectedCards.get(i);
			cardInspection.setSelected(false);
			this.game.getLevel().getPilesOfCards().get(cardInspection.getColumn()).removeCard(cardInspection);
			cardInspection.setColumn(columnWhereInsert);
			cardInspection.setPositionX(positionXWhereMove);
			cardInspection.setPositionY(positionYWhereMove);
			this.game.getLevel().getPilesOfCards().get(cardPassed.getColumn()).insertCard(cardInspection);
			this.selectedCards.remove(this.selectedCards.remove(i));
		}
	}


	public void moveSelectedCardsToCells(Card cardPassed) {
		Card cardInspection = this.selectedCards.get(this.selectedCards.size() - 1);
		int columnWhereInsert = cardPassed.getColumn();
		float positionXWhereMove = cardPassed.getPositionX();
		float positionYWhereMove = cardPassed.getPositionY();

		cardInspection.setSelected(false);
		this.game.getLevel().getPilesOfCards().get(cardInspection.getColumn()).removeCard(cardInspection);
		cardInspection.setColumn(columnWhereInsert);
		cardInspection.setPositionX(positionXWhereMove + 3);
		cardInspection.setPositionY(positionYWhereMove + 3);
		this.game.getLevel().getFreeCells().get(cardPassed.getColumn() - 8).insertCard(cardInspection);

		this.selectedCards.clear();
	}

	public void moveSelectedCardsToScale(Card cardPassed) {
		Card cardInspection = this.selectedCards.get(this.selectedCards.size() - 1);
		int columnWhereInsert = cardPassed.getColumn();
		float positionXWhereMove = cardPassed.getPositionX();
		float positionYWhereMove = cardPassed.getPositionY();

		cardInspection.setSelected(false);
		this.game.getLevel().getPilesOfCards().get(cardInspection.getColumn()).removeCard(cardInspection);
		cardInspection.setColumn(columnWhereInsert);
		cardInspection.setPositionX(positionXWhereMove + 3);
		cardInspection.setPositionY(positionYWhereMove + 3);
		this.game.getLevel().getScales().get(cardPassed.getColumn() - 12).insertCard(cardInspection);

		this.selectedCards.clear();
	}

	public boolean isScaleSon(ArrayList<Card> scalePassed, Card cardPassed) {

		if(!(scalePassed.isEmpty()) && !(scalePassed.get(0).getSuit().equals(cardPassed.getSuit()))) {
			return false;
		}

		if(!(scalePassed.isEmpty()) && (scalePassed.get(scalePassed.size()-1).getNumber() != (cardPassed.getNumber() - 1))) {
			return false;
		}

		if((scalePassed.isEmpty()) && (cardPassed.getNumber() > 1)) {
			return false;
		}

		return true;
	}


	public boolean movingCardsFromPilesOfCards(ArrayList<Card> selectedCards) {
		return (selectedCards.get(0).getColumn() < 8);
	}
	
	public void moveSelectedCardsFromFreeCellToPilesOfCards(Card cardPassed) {
		Card cardInspection = this.selectedCards.get(this.selectedCards.size() - 1);
		int columnWhereInsert = cardPassed.getColumn();
		float positionXWhereMove = cardPassed.getPositionX();
		float positionYWhereMove = this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getPositionY() - (this.game.getLevel().getH()/31 * this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getSize());

		cardInspection.setSelected(false);
		this.game.getLevel().getFreeCells().get(cardInspection.getColumn() - 8).removeCard(cardInspection);
		cardInspection.setColumn(columnWhereInsert);
		cardInspection.setPositionX(positionXWhereMove);
		cardInspection.setPositionY(positionYWhereMove);
		this.game.getLevel().getPilesOfCards().get(cardPassed.getColumn()).insertCard(cardInspection);

		this.selectedCards.clear();
	}

	
	public void moveSelectedCardsFromFreeCellToScale(Card cardPassed) {
		Card cardInspection = this.selectedCards.get(this.selectedCards.size() - 1);
		int columnWhereInsert = cardPassed.getColumn();
		float positionXWhereMove = cardPassed.getPositionX();
		float positionYWhereMove = cardPassed.getPositionY();

		cardInspection.setSelected(false);
		this.game.getLevel().getFreeCells().get(cardInspection.getColumn() - 8).removeCard(cardInspection);
		cardInspection.setColumn(columnWhereInsert);
		cardInspection.setPositionX(positionXWhereMove + 3);
		cardInspection.setPositionY(positionYWhereMove + 3);
		this.game.getLevel().getScales().get(cardPassed.getColumn() - 12).insertCard(cardInspection);

		this.selectedCards.clear();
	}
	
	public void tryClickButton(Vector3 mousePosition) {
		
	}
}
