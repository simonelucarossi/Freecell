package com.mygdx.objects;

public class Button {
	String name;
	float positionX, positionY, width, height;
	
	public Button() {
		
	}
	
	public Button(String name, float positionX, float positionY, float width, float height) {
		this.height = height;
		this.width = width;
		this.positionX = positionX;
		this.positionY = positionY;
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	
	
}
