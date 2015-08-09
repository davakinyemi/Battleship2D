package com.mygdx.boardobjects;

/**
 * Created by jorgegil on 8/4/15.
 */
public class Battleship {

    // Instance variables
    private int size, x, y, width, height;
    private String name;
    private boolean destroyed;

    // Constructor
    public Battleship(int size, String name, int x, int y, int width, int height){
        this.size = size;
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        destroyed = false;
    }

    //Update methods
    public void set_destroyed(boolean condition){
        destroyed = condition;
    }

    // Accessor methods
    public int get_size(){
        return size;
    }

    public String get_name(){
        return name;
    }

    public boolean get_destroyed(){
        return destroyed;
    }
}
