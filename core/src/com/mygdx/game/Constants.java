package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Constants {
    //Background Texture
    public static final String BACKGROUND_TEXTURE="Forest.png";
    //App resolution
    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 600;
    //Camera
    public static final float CAMERA_WIDTH = 20f;
    public static final float CAMERA_HEIGHT = 13f;
    //Gravity Force
    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);
    //Ground Parameters
    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 25f;
    public static final float GROUND_HEIGHT = 1f;

    public static final float GROUND_DENSITY = 0f;
    //Player Parameters
    public static final float PLAYER_TEXTURE_DIMENSION = 150;
    public static final float PLAYER_WIDTH =1.5f;
    public static final float PLAYER_HEIGHT =1.5f;
    public static final float PLAYER_X =2f;
    public static final float PLAYER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float PLAYER_DENSITY =0.5f;
    public static final float PLAYER_GRAVITY_SCALE =3f;

    //Actions
    public static final Vector2 JUMP=new Vector2(0,75f);
    public static final Vector2 WALK_AND_JUMP = new Vector2(5f,75f);
    public static final Vector2 WALK_AND_JUMP_LEFT = new Vector2(-5f,75f);
    public static final float PLAYER_VELOCITY = 300f;
    public static final float WORLD_TO_SCREEN = 32;
    //Enemy
    public static final float ENEMY_TEXTURE_DIMENSION = 150;
    public static final float ENEMY_WIDTH =1.5f;
    public static final float ENEMY_HEIGHT =1.5f;
    public static final float ENEMY_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float ENEMY_X = CAMERA_WIDTH;
    public static final float ENEMY_DENSITY = 0.5f;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-1f,0);
}
