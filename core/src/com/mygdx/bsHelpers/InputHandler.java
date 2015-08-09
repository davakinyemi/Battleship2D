package com.mygdx.bsHelpers;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.gameboard.GameBoard;

/**
 * Created by jorgegil on 8/8/15.
 */
public class InputHandler implements InputProcessor {

    private GameBoard myBoard;

    // Constructor
    public InputHandler (GameBoard board) {
        myBoard = board;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
