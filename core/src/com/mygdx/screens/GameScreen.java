package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.gameboard.GameBoard;
import com.mygdx.gameboard.GameRenderer;

/**
 * Created by jorgegil on 8/4/15.
 */
public class GameScreen implements Screen {

    private GameBoard board;
    private GameRenderer renderer;
    public float runTime = 0;

    public GameScreen() {

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 160;
        float gameHeight = screenHeight / (screenWidth / gameWidth);


        board = new GameBoard();
        renderer = new GameRenderer(board);

    }

    @Override
    public void render(float delta) {
        runTime += delta;

        board.update(delta);
        renderer.render(delta);
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
