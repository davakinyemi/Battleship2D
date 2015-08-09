package com.mygdx.gameboard;

import com.mygdx.boardobjects.AI;
import com.mygdx.boardobjects.Battleship;
import com.mygdx.boardobjects.BattleshipGrid;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jorgegil on 8/4/15.
 */
public class GameBoard {

    public enum GameState {
        READY, RUNNING, GAMEOVER
    }

    public GameState currentState;

    private static String[] fleet = {"Destroyer", "Submarine", "Carrier", "Assault-ship", "Patrol-boat"};
    private static int shipSize;
    private static int numOfShips = 5;



    private static int difficulty;
    private static int easy                               = 0;
    private static int normal                             = 1;

    private static boolean gameComplete                  = false;

    private static int adjustedGridSize                  = 10
    private static int gridSize                          = adjustedGridSize + 1;

    private static Random r                              = new Random();

    private static BattleshipGrid AIGrid                 = new BattleshipGrid(gridSize, "AI Grid");
    private static BattleshipGrid AIGridForPlayer        = new BattleshipGrid(gridSize, "AI Grid (Player)");
    private static AI ai                                 = new AI();

    private static BattleshipGrid playerGrid             = new BattleshipGrid(gridSize, "Player Grid");

    private static ArrayList<String> fleetList;
    private static ArrayList<Battleship> playerShips     = new ArrayList<>();
    private static ArrayList<Battleship> AIShips         = new ArrayList<>();

    private static int orientation = 0, width = 0, height = 0, x, y = 0, numOfOrients = 3;

    // Constructor
    public GameBoard() {
        currentState = GameState.READY;

        // MAIN method should go here, except for run_game()


    }

    public void update(float delta) {
        switch (currentState) {
            case READY:
                updateReady(delta);
                break;
            case GAMEOVER:
                updateGameOver(delta);
                break;
            case RUNNING:
                updateRunning(delta);
                break;
        }
    }

    public void updateRunning(float delta) {
        // Here goes what happens when the game is loading, most of the previous run_game() method will go here.
    }

    public void updateReady(float delta) {

    }

    public void updateGameOver(float delta) {

    }
}
