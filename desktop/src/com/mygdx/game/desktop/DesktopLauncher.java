package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Bowman;
import com.mygdx.game.Constans;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= Constans.APP_WIDTH;
		config.height=Constans.APP_HEIGHT;
		config.title = "Bowman";
		config.foregroundFPS=60;
		new LwjglApplication(new Bowman(), config);
	}
}
