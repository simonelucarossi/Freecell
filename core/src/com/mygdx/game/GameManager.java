package com.mygdx.game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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
import com.mygdx.objects.Button;
import com.mygdx.objects.Card;
import com.mygdx.objects.DlvRunner;
import com.mygdx.objects.FreeCell;
import com.mygdx.objects.IAwriter;
import com.mygdx.objects.Pile;
import com.mygdx.objects.Scale;

public class GameManager implements ApplicationListener {
	private GameOfCards game;
	private GameGui gameGui;
	private ArrayList<Card> selectedCards;
	private Vector3 tp, mousePosition;
	private IAwriter iaWriter;

	long firstClick;


	@Override
	public void create () {
		try {
			this.game = new GameOfCards();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.gameGui = new GameGui(game);
		this.firstClick = 0;
		this.tp = new Vector3();

		this.selectedCards = new ArrayList<Card>();
	}

	@Override
	public void render () {
		gameGui.drawLevel();

		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			long secondClick = System.currentTimeMillis();
			if(secondClick - firstClick > 500) {
				this.game.emptySpaces = new ArrayList<Vector2d>();
				this.game.cardsToMove = new ArrayList<Vector2d>();
				
				this.mousePosition = gameGui.getCamera().unproject(tp.set(Gdx.input.getX(), Gdx.input.getY(), 0));
				


				try {
					checkMouseClick(mousePosition);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				firstClick = secondClick;
			}
			
		}

		checkGameVictory();

	}

	@Override
	public void dispose () {
		gameGui.dispose();
	}

	@Override
	public void resize(int width, int height) {
		Dimension dimensions = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		gameGui.getCamera().viewportWidth = (float)dimensions.getWidth(); // Viewport of 30 units!
		gameGui.getCamera().viewportHeight = (float)dimensions.getHeight(); // Lets keep things in proportion.
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

	public void checkMouseClick(Vector3 mousePosition) throws IOException {
		if(!(this.game.isPaused())) {
			if(this.selectedCards.isEmpty()) {
				tryCardSelection(mousePosition);
				tryFreeCellSelection(mousePosition);
				tryClickButton(mousePosition);
			} else {
				if(tryCardMovement(mousePosition)) {
					this.game.setScore(this.game.getScore() + 10);
					this.game.setMovement(this.game.getMovement() + 1);
				}

				else {
					deselectCards();
					tryClickButton(mousePosition);
				}
			}
		} else {
			tryClickMenuPausedGameButton(mousePosition);
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



	public void tryClickButton(Vector3 mousePosition) throws IOException {


		for(int i = 0; i < this.game.getMenuDuringGameButtons().size(); i++) {
			for(Button button : this.game.getMenuDuringGameButtons()) {
				if(mousePosition.x >= button.getPositionX() &&
						mousePosition.x  <= (button.getPositionX() + button.getWidth()) &&
						mousePosition.y >= button.getPositionY() &&
						mousePosition.y  <= (button.getPositionY() + button.getHeight())
						) {
					startButtonAction(button);
				}
			}
		}
	}
	
	public void tryClickMenuPausedGameButton(Vector3 mousePosition) throws IOException {

		for(int i = 0; i < this.game.getMenuPausedGame().getButtons().size(); i++) {
			for(Button button : this.game.getMenuPausedGame().getButtons()) {
				if(mousePosition.x >= button.getPositionX() &&
						mousePosition.x  <= (button.getPositionX() + button.getWidth()) &&
						mousePosition.y >= button.getPositionY() &&
						mousePosition.y  <= (button.getPositionY() + button.getHeight())
						) {
					startButtonAction(button);
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

		if((numberBottomCards(listOfCards, cardPosition) + 1) > this.game.availableToMove()) {
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
			try {
				cardInspection = listOfCards.getLast();
			} catch(NoSuchElementException e) {
				continue;
			}


			if(!(this.selectedCards.isEmpty()) && cardInspection.getColumn() != selectedCards.get(this.selectedCards.size() - 1).getColumn() &&
					mousePosition.x >= cardInspection.getPositionX() &&
					mousePosition.x  <= (cardInspection.getPositionX() + cardInspection.getWidth()) &&
					mousePosition.y >= cardInspection.getPositionY() &&
					mousePosition.y  <= (cardInspection.getPositionY() + cardInspection.getHeight()) &&
					!(cardInspection.getColor().equals(selectedCards.get(this.selectedCards.size() - 1).getColor())) &&
					(cardInspection.getNumber() == (selectedCards.get(this.selectedCards.size() - 1).getNumber() + 1)))
			{
				if(movingCardsFromPilesOfCards(selectedCards)) {
					moveSelectedCards(cardInspection);
					return true;
				}
				else {
					moveSelectedCardsFromFreeCellToPilesOfCards(cardInspection);
					return true;
				}
			} 
		}
		
		
		/* CKECK EMPTY COLUMNS*/
		for(int i = 0; i < listOfPiles.size(); i++) {
			
			if(listOfPiles.get(i).getCards().isEmpty()) {
				if(!(this.selectedCards.isEmpty()) && i != selectedCards.get(this.selectedCards.size() - 1).getColumn() &&
						mousePosition.x >= listOfPiles.get(i).getPositionX() &&
						mousePosition.x  <= (listOfPiles.get(i).getPositionX() + listOfPiles.get(i).getWidth()) &&
						mousePosition.y >= listOfPiles.get(i).getPositionY() &&
						mousePosition.y  <= (listOfPiles.get(i).getPositionY() + listOfPiles.get(i).getHeight())
						) {
					
					if(movingCardsFromPilesOfCards(selectedCards)) {
						moveSelectedCardsToEmpty(i, listOfPiles.get(i).getPositionX(), listOfPiles.get(i).getPositionY());
						return true;
					}
					else {
						moveSelectedCardsFromFreeCellToEmpty(i, listOfPiles.get(i).getPositionX(), listOfPiles.get(i).getPositionY());
						return true;
					}

				}	
			}
		}
		

		/* CHECK FREE CELLS */

		for(int i = 0; i < this.game.getLevel().getFreeCells().size(); i++) {
			cellInspected = this.game.getLevel().getFreeCells().get(i);	
			arrayCellInspected = this.game.getLevel().getFreeCells().get(i).getFreeCells();
			if((cellInspected.getFreeCells().isEmpty()) && !(this.selectedCards.isEmpty()) && (this.selectedCards.size() < 2) && cellInspected.getColumn() != selectedCards.get(this.selectedCards.size() - 1).getColumn() &&
					mousePosition.x >= cellInspected.getPositionX() &&
					mousePosition.x  <= (cellInspected.getPositionX() + cellInspected.getWidth()) &&
					mousePosition.y >= cellInspected.getPositionY() &&
					mousePosition.y  <= (cellInspected.getPositionY() + cellInspected.getHeight()))
			{
				cardCellInspected = new Card(0,"R","R", cellInspected.getColumn(), cellInspected.getPositionX(), cellInspected.getPositionY());
				if(movingCardsFromPilesOfCards(selectedCards)) {
					moveSelectedCardsToCells(cardCellInspected);
					return true;
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
					return true;
				}
				else {
					moveSelectedCardsFromFreeCellToScale(cardScaleInspected);
					return true;
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
	
	
	public void moveSelectedCardsToEmpty(int column, float f, float g) {
		Card cardInspection = this.selectedCards.get(this.selectedCards.size() - 1);
		int columnWhereInsert =	column;
		float positionXWhereMove = f;
		float positionYWhereMove = this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getPositionY() - (this.game.getLevel().getH()/31 * this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getSize());

		cardInspection.setSelected(false);
		this.game.getLevel().getPilesOfCards().get(cardInspection.getColumn()).removeCard(cardInspection);
		cardInspection.setColumn(columnWhereInsert);
		cardInspection.setPositionX(positionXWhereMove);
		cardInspection.setPositionY(positionYWhereMove);
		this.game.getLevel().getPilesOfCards().get(columnWhereInsert).insertCard(cardInspection);
		this.selectedCards.remove(this.selectedCards.remove(this.selectedCards.size() - 1));

		for(int i = 0; i < this.selectedCards.size(); i++) {
			positionYWhereMove = this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getPositionY() - (this.game.getLevel().getH()/31 * this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getSize());
			cardInspection = this.selectedCards.get(i);
			cardInspection.setSelected(false);
			this.game.getLevel().getPilesOfCards().get(cardInspection.getColumn()).removeCard(cardInspection);
			cardInspection.setColumn(columnWhereInsert);
			cardInspection.setPositionX(positionXWhereMove);
			cardInspection.setPositionY(positionYWhereMove);
			this.game.getLevel().getPilesOfCards().get(column).insertCard(cardInspection);
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
	
	
	public void moveSelectedCardsFromFreeCellToEmpty(int column,  float positionX, float positionY) {
		Card cardInspection = this.selectedCards.get(this.selectedCards.size() - 1);
		int columnWhereInsert = column;
		float positionXWhereMove = positionX;
		float positionYWhereMove = this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getPositionY() - (this.game.getLevel().getH()/31 * this.game.getLevel().getPilesOfCards().get(columnWhereInsert).getSize());

		cardInspection.setSelected(false);
		this.game.getLevel().getFreeCells().get(cardInspection.getColumn() - 8).removeCard(cardInspection);
		cardInspection.setColumn(columnWhereInsert);
		cardInspection.setPositionX(positionXWhereMove);
		cardInspection.setPositionY(positionYWhereMove);
		this.game.getLevel().getPilesOfCards().get(column).insertCard(cardInspection);

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


	public void startButtonAction(Button button) throws IOException {

		if(button.getName().equals("Exit")) {
			Gdx.app.exit();
			System.exit(0);
		} else if(button.getName().equals("Menu")) {
			this.game.setPaused(!(this.game.isPaused()));
		} else if(button.getName().equals("Hint")) {
			String resultCommandLine = null;
			iaWriter = new IAwriter();
			iaWriter.writeOnFile(this.game);
			DlvRunner dlvRunner = new DlvRunner();
			
			resultCommandLine = dlvRunner.readedLine;
			int resultPos = 0;
			if(resultCommandLine == null) {
				createEmptySpace();
			} else {
				
				
				resultCommandLine = resultCommandLine.replace("{move(","Card:");
				resultCommandLine = resultCommandLine.replace("), move(", "Card:");
				resultCommandLine = resultCommandLine.replace(")}", "");
				
				
				String[] str = resultCommandLine.split("Card:");
				
				for(String a : str) { 
					if(resultPos != 0) {
						String[] card = a.split(",");
						int column = Integer.valueOf(card[1]);
						int position = Integer.valueOf(card[4]); 
						createCardsToMove(column, position);
					}
					resultPos++;
				}
				
			}
			
			
			
			
		} else if(button.getName().equals("New Game")) {
			this.game.newGame();
			this.game.setPaused(!(this.game.isPaused()));
		} else if(button.getName().equals("Restart Game")) {
			this.game.restart();
			this.game.setPaused(!(this.game.isPaused()));
		} else if(button.getName().equals("Back To Game")) {
			this.game.setPaused(!(this.game.isPaused()));
		}

	}
	
	public void checkGameVictory() {
		if(this.game.getLevel().getScales().get(0).getScale().size() + 
				this.game.getLevel().getScales().get(1).getScale().size() + 
				this.game.getLevel().getScales().get(2).getScale().size() + 
				this.game.getLevel().getScales().get(3).getScale().size() == 52) {
			this.game.setWin(true);
		}
	}
	
	public void createEmptySpace() {
		for(int i = 0; i < this.game.getLevel().getFreeCells().size(); i++) {
			if(this.game.getLevel().getFreeCells().get(i).getFreeCells().isEmpty()) {
				this.game.emptySpaces.add(new Vector2d(this.game.getLevel().getFreeCells().get(i).getPositionX(), this.game.getLevel().getFreeCells().get(i).getPositionY()));
			}
		}
		
		for(int i = 0; i < this.game.getLevel().getPilesOfCards().size(); i++) {
			if(this.game.getLevel().getPilesOfCards().get(i).getSize() == 0) {
				this.game.emptySpaces.add(new Vector2d((int)this.game.getLevel().getPilesOfCards().get(i).getPositionX(),(int) this.game.getLevel().getPilesOfCards().get(i).getPositionY()));
			}
		}
	}

	
	public void createCardsToMove(int column, int position) {
		Dimension dimensions = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		if (column < 8) {
			this.game.cardsToMove.add(
				new Vector2d(
					(int) this.game.getLevel().getPilesOfCards().get(column).getPositionX() - 2,
					(int) (this.game.getLevel().getPilesOfCards().get(column).getPositionY() - dimensions.height/31 * position + 30)
				)
			);
		} else {
			this.game.cardsToMove.add(
				new Vector2d(
					(int) this.game.getLevel().getFreeCells().get(0).getPositionX(),
					(int) (this.game.getLevel().getFreeCells().get(column-8).getPositionY())
				)
			);
		}
	}
}
