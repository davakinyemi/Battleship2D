package com.mygdx.bsHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

/**
 * Created by jorgegil on 8/4/15.
 */
public class AssetLoader {

    public static Texture aircraft;
    public static TextureRegion aircraft1, aircraft2, aircraft3, aircraft4, aircraft5;
    public static ArrayList<TextureRegion> ships;

    public static void load() {
        
        aircraft = new Texture(Gdx.files.internal("ships/aircraft.png"));
        aircraft.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        aircraft1 = new TextureRegion(aircraft, 0, 0, 25, 25);
        aircraft2 = new TextureRegion(aircraft, 25, 0, 25, 25);
        aircraft3 = new TextureRegion(aircraft, 50, 0, 25, 25);
        aircraft4 = new TextureRegion(aircraft, 75, 0, 25, 25);
        aircraft5 = new TextureRegion(aircraft, 100, 0, 25, 25);

        ships = new ArrayList<TextureRegion>();
        ships.add(aircraft1);
        ships.add(aircraft2);
        ships.add(aircraft3);
        ships.add(aircraft4);
        ships.add(aircraft5);

    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        aircraft.dispose();
    }

}
