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
		cfg.width = dimension.width;
		cfg.height = dimension.height;
		cfg.forceExit = true;
		new LwjglApplication(new GameManager(), cfg);
		
		
	}
}
