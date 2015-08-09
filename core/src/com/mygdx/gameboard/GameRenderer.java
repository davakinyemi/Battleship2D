package com.mygdx.gameboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.bsHelpers.AssetLoader;

/**
 * Created by jorgegil on 8/4/15.
 */
public class GameRenderer {

    private GameBoard myBoard;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batch;

    public GameRenderer(GameBoard board) {
        myBoard = board;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 200, 160);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render(float runTime) {

        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(com.badlogic.gdx.graphics.Color.BLUE);
        shapeRenderer.rect(10, 10, 100, 100);
        shapeRenderer.rect(120, 10, 100, 100);

        shapeRenderer.rect(10, 120, 100, 50);
        shapeRenderer.rect(120, 120, 100, 50);

        // End ShapeRenderer
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        shapeRenderer.setColor(Color.BLACK);

        for (int i = 1; i <= 11; i++) {
            for (int j = 1; j <= 11; j++) {
                shapeRenderer.rect(j * 10, i * 10, 10, 10);
            }
        }

        shapeRenderer.end();

        batch.begin();

        for (int i = 0; i < 5; i++) {
            batch.draw(AssetLoader.ships.get(i), i * 10 + 30, 30, 10, 10);
        }

        batch.end();
    }
}
