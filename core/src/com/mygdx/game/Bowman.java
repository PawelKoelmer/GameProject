package com.mygdx.game;


import Screens.BowmanGame.GameScreen.GameScreen;
import com.badlogic.gdx.Game;

public class Bowman extends Game {

	public Bowman(){

	}

	@Override
	public void create() {
		setScreen(new GameScreen());
	}
	@Override
	public void dispose(){
		super.dispose();
	}
}
