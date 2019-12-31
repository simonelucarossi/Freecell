package com.mygdx.objects;

import java.util.Deque;
import java.util.LinkedList;

public class Pile {
	// This is the stack of cards on the table
	Deque<Card> stackOfCards;
	
	public Pile() {
		this.stackOfCards = new LinkedList<Card>();
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
	
}
