package com.mygdx.game;

import java.awt.Dimension;

import com.badlogic.gdx.Gdx;
import com.mygdx.objects.Level;

public class GameOfCards {
	private Level level;
	private long score, time;
	private Dimension dimension;
	private int w,h;
	Dimension dimensions;
	
	public GameOfCards() {
		
		dimensions = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		w = dimensions.width;
		h = dimensions.height;
		
		System.out.println(w + " " + h);
		
		this.score = 0;
		this.time = 0;
		this.level = new Level();
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * @return the score
	 */
	public long getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(long score) {
		this.score = score;
	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}

	
}
