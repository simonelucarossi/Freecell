package com.mygdx.objects;

public class Card {
	private float width;
	private float height;
	private float number;
	private String color;
	private String suit;
	private boolean moving, selected;
	
	public Card() {
		width = 35;
		height = 65;
		number = 1;
		color = "Red";
		suit = "Flowers";
		this.moving = false;
		this.selected = false;
	}
	
	public Card(float number_, String color_, String suit_) {
		this.width = 35;
		this.height = 65;
		this.number = number_;
		this.color = color_;
		this.suit = suit_;
		this.moving = false;
		this.selected = false;
	}

	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(float height) {
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
	public void setNumber(float number) {
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
	
	
	
}
