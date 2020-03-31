package com.mygdx.objects;

import java.util.ArrayList;

public class Scale {
	int positionX, positionY;
	int width, height, column;
	private ArrayList<Card> scale;

	public Scale() {

	}

	public Scale(int posX, int posY, int width, int height, int column) {
		positionX = posX;
		positionY = posY;
		this.width = width;
		this.height = height;
		scale = new ArrayList<Card>();
		this.column = column;
	}

	/**
	 * @return the positionX
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * @param positionX the positionX to set
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	/**
	 * @return the positionY
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * @param positionY the positionY to set
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @return the scale
	 */
	public ArrayList<Card> getScale() {
		return scale;
	}

	/**
	 * @param scale the scale to set
	 */
	public void setScale(ArrayList<Card> scale) {
		this.scale = scale;
	}
	
	public void insertCard(Card cardPassed) {
		this.scale.add(cardPassed);
	}
	
	public void removeCard(Card c) {
		this.scale.remove(c);
	}
}
