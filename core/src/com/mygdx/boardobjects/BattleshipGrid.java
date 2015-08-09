package com.mygdx.boardobjects;

import com.mygdx.gameboard.GameBoard;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by jorgegil on 8/4/15.
 */
public class BattleshipGrid {

    private String water_symbol = "~";
    private String ship_body_symbol = "0";
    private String miss_symbol = "X";
    private String hit_symbol = "*";

    private String name;

    public String[] alphabets = {"A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z"};

    private String[][] grid;

    public BattleshipGrid(int size, String name){
        this.name = name;
        grid = new String[size][size];

        // fills board with letters, numbers, and "water"
        for(int y = 0; y < grid.length; y++){
            for(int x = 0; x < grid.length; x++){
                if(y == 0 && x == 0){
                    grid[y][x] = " ";
                }else if(y == 0 && x > 0){
                    grid[y][x] = String.valueOf(x);
                }else if(x == 0 && y > 0){
                    grid[y][x] = alphabets[y - 1];
                }else{
                    grid[y][x] = water_symbol;
                }
            }
        }
    }

    public String[][] get_grid(){
        return grid;
    }

    // prints the current state of the grid
    public void print_grid(){
        out.println("-----------------------------------" + name + "-----------------------------------");
        for (String[] grid1 : grid) {
            for (int x = 0; x < grid.length; x++) {
                out.print(grid1[x]);
                out.print("   ");
            }
            out.println();
            out.println();
        }
        out.println("----------------------------------------------------------------------------------");
    }

    // returns the string value (symbol) at the position in array
    public String get_symbol(int x, int y){
        return grid[y][x];
    }

    // updates the string value at position in array
    public void set_symbol(int x, int y, String symbol){
        grid[y][x] = symbol;
    }

    // adds ship to grid
    public void add_ship(int x, int y, int width, int height, int ship_Size, String type, String name){
        String Y, X;

        for(int i = 0; i < ship_Size; i++){
            Y = GameBoard.get_Player_grid().get_symbol(0, y);
            X = GameBoard.get_Player_grid().get_symbol(x, 0);

            grid[y][x] = ship_body_symbol;
            //
            switch (type) {
                case "player":
                    add_coords(X, Y, name, GameBoard.get_player_ships());
                    break;
                case "ai":
                    add_coords(X, Y, name, GameBoard.get_AI_ships());
                    break;
            }
            //
            if(width == 1){
                y++;
            } else if(width > 1){
                x++;
            }
        }
    }

    // used by add_ship() to add the ships coordinates to their respective arraylist
    public void add_coords(String x, String y, String name, ArrayList<Battleship> ship){
        for(Battleship s : ship){
            if(s.get_name().equals(name)){
                s.set_coords(y + x);
            }
        }
    }
}
