package com.mygdx.game;

import com.mygdx.objects.Level;

public class GameOfCards {
	private Level level;
	private long score, time;
	
	public GameOfCards() {
		
		this.level = new Level();
		System.out.println("CAZZAROLA 1");
		this.score = 0;
		this.time = 0;
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
