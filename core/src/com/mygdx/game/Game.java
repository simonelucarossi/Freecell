package com.mygdx.game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.objects.Card;
import com.mygdx.objects.Pile;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Pile primaFila;
	Card carta_uno, carta_due, carta_tre;
	Dimension screenSize;
	int screen_width;
	int screen_height;
	
	@Override
	public void create () {
		primaFila = new Pile();
		carta_uno = new Card();
		carta_due = new Card();
		carta_tre = new Card();
		primaFila.insertCard(carta_uno);
		primaFila.insertCard(carta_due);
		primaFila.insertCard(carta_tre);
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screen_width = (int)screenSize.getWidth();
		screen_height = (int)screenSize.getHeight();
		
		batch = new SpriteBatch();
		img = new Texture("3_fiori.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		batch.begin();
		for(int i = 0; i < primaFila.getCards().size(); i++) {
			System.out.println(i);
			batch.draw(img, 50, 270 - (30 * i),  this.primaFila.getCards().getLast().getWidth(), this.primaFila.getCards().getLast().getHeight());
		}
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
