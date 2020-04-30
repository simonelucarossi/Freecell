package com.mygdx.game.desktop;

import java.awt.Dimension;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.GameManager;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		cfg.width = (int) dimension.getWidth();
		cfg.height = (int) dimension.getHeight();
		cfg.fullscreen = true;
		cfg.forceExit = true;
		new LwjglApplication(new GameManager(), cfg);
		
		
	}
}
