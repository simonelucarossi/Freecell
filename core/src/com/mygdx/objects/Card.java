package com.mygdx.objects;

import java.awt.Dimension;

import com.badlogic.gdx.Gdx;

public class Card {
	private int width;
	private int height;
	private int number;
	private float positionX, positionY;
	private String color;
	private String suit;
	private boolean moving, selected;
	private int column;
	private int screen_width, screen_height;
	Dimension dimensions;
	
	public Card() {
		dimensions = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.screen_width = dimensions.width;
		this.screen_height = dimensions.height;
//		
		System.out.println(this.screen_width);
		width = 100;
		height = 100;
		number = 1;
		color = "Red";
		suit = "Flowers";
		this.moving = false;
		this.selected = false;
		this.column = 0;
		this.positionX = 0;
		this.positionY = 0; 
	}
	
	public Card(int number_, String color_, String suit_, int column_, float positionX_, float positionY_) {
		dimensions = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.screen_width = dimensions.width;
		this.screen_height = dimensions.height;
		
		
		width = screen_width/18;
		height = screen_height/7 - 6;
		this.number = number_;
		this.color = color_;
		this.suit = suit_;
		this.moving = false;
		this.selected = false;
		this.column = column_;
		this.positionX = positionX_;
		this.positionY = positionY_;
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
	 * @return the number
	 */
	public float getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * @param suit the suit to set
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * @return the moving
	 */
	public boolean isMoving() {
		return moving;
	}

	/**
	 * @param moving the moving to set
	 */
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
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