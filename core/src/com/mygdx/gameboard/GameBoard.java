package com.mygdx.gameboard;

import com.mygdx.boardobjects.Battleship;
import com.mygdx.boardobjects.BattleshipGrid;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jorgegil on 8/4/15.
 */
public class GameBoard {

    public enum GameState {
        READY, RUNNING, PAUSE, GAMEOVER
    }

    public GameState currentState;

    private static String[] fleet = {"Destroyer", "Submarine", "Carrier", "Assault-ship", "Patrol-boat"};
    private static int shipSize;
    private static int numOfShips = 5;

    private static int difficulty;
    private static int easy                               = 0;
    private static int normal                             = 1;

    private static boolean gameComplete                  = false;

    private static int gridSize                          = 11;
    private static int label_size                         = gridSize - 1;

    private static Random r = new Random();

    private static BattleshipGrid AIGrid = new BattleshipGrid(gridSize);
    private static BattleshipGrid playerGrid = new BattleshipGrid(gridSize);

    private static ArrayList<String> gameShips;
    private static ArrayList<Battleship> playerShips, AIShips;

    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static char[] ch = alphabet.toCharArray();

    public GameBoard() {

        currentState = GameState.READY;

    }

    public void update(float delta) {
        switch (currentState) {
            case READY:
                updateReady(delta);
                break;
            case PAUSE:
                updateReady(delta);
                break;
            case GAMEOVER:
                updateReady(delta);
                break;
            case RUNNING:
                updateRunning(delta);
                break;
        }
    }

    public void updateRunning(float delta) {

    }

    public void updateReady(float delta) {

    }
}
