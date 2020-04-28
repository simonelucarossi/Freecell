package com.mygdx.game;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.mygdx.objects.Button;
import com.mygdx.objects.Level;
import com.mygdx.objects.Menu;

public class GameOfCards {
	private Level level, levelBackup;
	private long score, movement;
	private Dimension dimension;
	private int screen_width, screen_height;
	private ArrayList<Button> menuDuringGameButtons, buttonsMenuPausedGame;
	private Menu menuPausedGame;
	private boolean paused, win;
	
	Dimension dimensions;
	
	public GameOfCards() throws IOException {
		
		dimensions = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.screen_width = dimensions.width;
		this.screen_height = dimensions.height;
				
		this.score = 0;
		this.movement = 0;
		this.level = new Level();
		
		this.levelBackup = new Level(this.level);
		
		this.buttonsMenuPausedGame = new ArrayList<Button>();
		this.buttonsMenuPausedGame.add(new Button("New Game",  screen_width/3 + 100, screen_height/4 + 300, 388, 100));
		this.buttonsMenuPausedGame.add(new Button("Restart Game",  screen_width/3 + 100, screen_height/4 + 190, 388, 100));
		this.buttonsMenuPausedGame.add(new Button("Back To Game", screen_width/3 + 100, screen_height/4 + 80, 388, 100));
		this.menuPausedGame = new Menu("Paused Game Menu", screen_width/3 - 6, screen_height/4, screen_width/4 + 100, screen_height/3 + 200, buttonsMenuPausedGame);
		this.menuDuringGameButtons = new ArrayList<Button>();
		this.menuDuringGameButtons.add(new Button("Exit", screen_width/2 - 289, 45, screen_width/24, screen_height/16));
		this.menuDuringGameButtons.add(new Button("Menu", screen_width/2 - 70, 45, screen_width/25, screen_height/16));
		this.menuDuringGameButtons.add(new Button("Hint", screen_width/2 + 152, 45, screen_width/24, screen_height/16));
	
		this.paused = false;
		this.win = true;
	}
	
	public void newGame() throws IOException {
		this.level.clearLevel();
		this.level.generateCards();
		this.score = 0;
		this.movement = 0;
		this.levelBackup.cloneLevel(this.level);
		this.win = false;
	}
	
	public void restart() {
			this.level.cloneLevel(levelBackup);
			this.score = 0;
			this.movement = 0;
			this.win = false;
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
	public long getMovement() {
		return movement;
	}

	/**
	 * @param time the time to set
	 */
	public void setMovement(long time) {
		this.movement = time;
	}

	/**
	 * @return the dimension
	 */
	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	/**
	 * @return the screen_width
	 */
	public int getScreen_width() {
		return screen_width;
	}

	/**
	 * @param screen_width the screen_width to set
	 */
	public void setScreen_width(int screen_width) {
		this.screen_width = screen_width;
	}

	/**
	 * @return the screen_height
	 */
	public int getScreen_height() {
		return screen_height;
	}

	/**
	 * @param screen_height the screen_height to set
	 */
	public void setScreen_height(int screen_height) {
		this.screen_height = screen_height;
	}

	/**
	 * @return the menuDuringGameButtons
	 */
	public ArrayList<Button> getMenuDuringGameButtons() {
		return menuDuringGameButtons;
	}

	/**
	 * @param menuDuringGameButtons the menuDuringGameButtons to set
	 */
	public void setMenuDuringGameButtons(ArrayList<Button> menuDuringGameButtons) {
		this.menuDuringGameButtons = menuDuringGameButtons;
	}

	/**
	 * @return the dimensions
	 */
	public Dimension getDimensions() {
		return dimensions;
	}

	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimensions(Dimension dimensions) {
		this.dimensions = dimensions;
	}

	/**
	 * @return the buttonsMenuPausedGame
	 */
	public ArrayList<Button> getButtonsMenuPausedGame() {
		return buttonsMenuPausedGame;
	}

	/**
	 * @param buttonsMenuPausedGame the buttonsMenuPausedGame to set
	 */
	public void setButtonsMenuPausedGame(ArrayList<Button> buttonsMenuPausedGame) {
		this.buttonsMenuPausedGame = buttonsMenuPausedGame;
	}

	/**
	 * @return the menuPausedGame
	 */
	public Menu getMenuPausedGame() {
		return menuPausedGame;
	}

	/**
	 * @param menuPausedGame the menuPausedGame to set
	 */
	public void setMenuPausedGame(Menu menuPausedGame) {
		this.menuPausedGame = menuPausedGame;
	}

	/**
	 * @return the paused
	 */
	public boolean isPaused() {
		return paused;
	}

	/**
	 * @param paused the paused to set
	 */
	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	/**
	 * @return the levelBackup
	 */
	public Level getLevelBackup() {
		return levelBackup;
	}

	/**
	 * @param levelBackup the levelBackup to set
	 */
	public void setLevelBackup(Level levelBackup) {
		this.levelBackup = levelBackup;
	}

	/**
	 * @return the win
	 */
	public boolean isWin() {
		return win;
	}

	/**
	 * @param win the win to set
	 */
	public void setWin(boolean win) {
		this.win = win;
	}
	
	

	
}
