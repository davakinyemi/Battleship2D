package com.mygdx.boardobjects;

/**
 * Created by jorgegil on 8/4/15.
 */
public class BattleshipGrid {

    public String water_symbol = "~";
    public String ship_body_symbol = "0";
    public String miss_symbol = "X";
    public String hit_symbol = "*";

    public String[] alphabets = {"A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z"};

    private String[][] grid;

    public BattleshipGrid(int size){

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

    // prints board
    public void print_grid(){

        for (String[] grid1 : grid) {
            for (int x = 0; x < grid.length; x++) {
                System.out.print(grid1[x]);
                System.out.print("   ");
            }
            System.out.println();
            System.out.println();
        }
    }

    // puts a * or X in the board where a hit or miss occurred
    public void reset_grid_hit(int alphabet, int number, int hit){

        if(hit == 1){
            if(grid[alphabet][number].equals(ship_body_symbol)){
                grid[alphabet][number] = hit_symbol;
            } else {
                grid[alphabet][number] = ship_body_symbol;
            }
        }else if(hit == 0){
            grid[alphabet][number] = miss_symbol;
        }else{
            throw new IllegalArgumentException("Hit must be 1 or 0");
        }
    }

    public char getSymbol(int x, int y) {
        return grid[y][x].charAt(0);
    }

    public void setSymbol(int x, int y, String symbol) {
        grid[y][x] = symbol;
    }

    public void addShip(int x, int y, int width, int height, int shipSize) {
        for (int i = 0; i < shipSize; i++) {
            grid[y][x] = "0";
            if (width == 1) {
                y++;
            } else {
                x++;
            }
        }
    }
}
