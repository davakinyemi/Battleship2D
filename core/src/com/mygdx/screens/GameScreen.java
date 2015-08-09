package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.bsHelpers.InputHandler;
import com.mygdx.bsHelpers.TouchHandler;
import com.mygdx.gameboard.GameBoard;
import com.mygdx.gameboard.GameRenderer;

/**
 * Created by jorgegil on 8/4/15.
 */
public class GameScreen implements Screen {

    // Game basic aspect ratio. Will scale from here.
    private static final float MIN_SCENE_WIDTH = 200.0f;
    private static final float MIN_SCENE_HEIGHT = 160.0f;

    // Viewport and camera used to maintain aspect ratio on different window sizes.
    private Viewport viewport;
    private Camera camera;

    // Board contains most of the game, renderer is use to draw it.
    private GameBoard board;
    private GameRenderer renderer;

    // User input handlers
    InputHandler inputHandler; // For keyboard
    TouchHandler touchHandler; // For touch screens
    InputMultiplexer inputMultiplexer; // To use both keyboard and touch controls

    public float runTime = 0;

    public GameScreen() {

        // Set up FIT viewport, see https://github.com/libgdx/libgdx/wiki/Viewports for more info on viewports
        camera = new PerspectiveCamera();
        viewport = new FitViewport(MIN_SCENE_WIDTH, MIN_SCENE_HEIGHT, camera);

        // Initialize board and renderer
        board = new GameBoard();
        renderer = new GameRenderer(board);

        // Initialize input handlers
        inputHandler = new InputHandler(board);
        touchHandler = new TouchHandler(board);

        // Adds both handlers to a multiplexer to allow both keyboard and touch detection
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(inputHandler);
        inputMultiplexer.addProcessor(new GestureDetector(touchHandler));

        // Sets the inputMultiplexer as our input processor
        Gdx.input.setInputProcessor(inputMultiplexer);

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
