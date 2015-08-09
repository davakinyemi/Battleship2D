package com.mygdx.boardobjects;

import com.mygdx.extraclasses.Point;

import java.util.ArrayList;

/**
 * Created by jorgegil on 8/4/15.
 */
public class Battleship {

    // Instance variables
    private int size, x, y, width, height;
    private String name;
    private ArrayList<Point> coords;
    private boolean destroyed;
    private ArrayList<String> ship_coords;

    // Constructor
    public Battleship(int size, String name, int x, int y, int width, int height){
        this.size = size;
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        destroyed = false;
        ship_coords = new ArrayList<>(size);
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

    public void set_coords(String coords){
        ship_coords.add(coords);
    }

    public ArrayList<String> get_coords(){
        return ship_coords;
    }
}
