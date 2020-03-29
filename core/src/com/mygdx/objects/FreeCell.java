package com.mygdx.objects;

import java.util.ArrayList;

public class FreeCell {
	int positionX, positionY;
	int width, height, column;
	private ArrayList<Card> freeCells;
	
	public FreeCell() {
	
	}
	
	public FreeCell(int posX, int posY, int width, int height, int column) {
		positionX = posX;
		positionY = posY;
		this.width = width;
		this.height = height;
		freeCells = new ArrayList<Card>();
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
	 * @return the freeCells
	 */
	public ArrayList<Card> getFreeCells() {
		return freeCells;
	}

	/**
	 * @param freeCells the freeCells to set
	 */
	public void setFreeCells(ArrayList<Card> freeCells) {
		this.freeCells = freeCells;
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
	
	
}
