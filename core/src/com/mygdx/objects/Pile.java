package com.mygdx.objects;

import java.util.Deque;
import java.util.LinkedList;

public class Pile {
	// This is the stack of cards on the table
	Deque<Card> stackOfCards;
	float positionX, positionY; 

	
	public Pile() {
		this.stackOfCards = new LinkedList<Card>();
		this.positionX = 0;
		this.positionY = 0;
	}
	
	public Pile(float posX, float posY) {
		this.stackOfCards = new LinkedList<Card>();
		this.positionX = posX;
		this.positionY = posY;
	}
	
	public void insertCard(Card c) {
		this.stackOfCards.add(c);
	}
	
	public void removeCard(Card c) {
		this.stackOfCards.removeLast();
	}
	
	public Deque<Card> getCards() {
		return this.stackOfCards;
	}
	
	public int getSize() {
		return this.stackOfCards.size();
	}
	
	public Card getLast() {
		return this.stackOfCards.getLast();
	}

	/**
	 * @return the stackOfCards
	 */
	public Deque<Card> getStackOfCards() {
		return stackOfCards;
	}

	/**
	 * @param stackOfCards the stackOfCards to set
	 */
	public void setStackOfCards(Deque<Card> stackOfCards) {
		this.stackOfCards = stackOfCards;
	}

	/**
	 * @return the positionX
	 */
	public float getPositionX() {
		return positionX;
	}

	/**
	 * @param positionX the positionX to set
	 */
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	/**
	 * @return the positionY
	 */
	public float getPositionY() {
		return positionY;
	}

	/**
	 * @param positionY the positionY to set
	 */
	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}
	
	
	
}
