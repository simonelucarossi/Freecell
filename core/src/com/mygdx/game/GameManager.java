package com.mygdx.game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.objects.Card;
import com.mygdx.objects.Pile;

public class GameManager extends ApplicationAdapter {
	private GameOfCards game;
	private GameGui gameGui;
	

	@Override
	public void create () {
		game = new GameOfCards();
		gameGui = new GameGui(game);
	}

	@Override
	public void render () {
		gameGui.drawLevel();
	}

	@Override
	public void dispose () {
		gameGui.dispose();
	}


}
