package com.mygdx.game;


import Screens.BowmanGame.GameScreen.GameScreen;
import Screens.MainMenu.MainMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bowman extends Game {

	private SpriteBatch batch;
	private boolean paused;
	private boolean isStarted;


	@Override
	public void create() {
		batch = new SpriteBatch();
		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render() {
		super.render();
		if (isStarted ) {
			this.setScreen(new GameScreen(this));
		}
	}

	@Override
	public void dispose() {

		batch.dispose();

	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean started) {
		isStarted = started;
	}
}
