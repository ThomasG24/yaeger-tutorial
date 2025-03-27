package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.entities.map.CoralTileMap;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;

public class GameLevel extends DynamicScene implements TileMapContainer {
    Waterworld waterworld;

    public GameLevel(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        Swordfish swordfish = new Swordfish(
                new Coordinate2D(getWidth(), getHeight() / 2)
        );
        addEntity(swordfish);

        Sharky sharky = new Sharky(
                new Coordinate2D(0, getHeight() / 3)
        );
        addEntity(sharky);

        var healthText = new HealthText(
                new Coordinate2D(0, 0)
        );
        addEntity(healthText);

        Hanny hanny = new Hanny(
                new Coordinate2D(getWidth() - 20, 0), healthText, waterworld);
        addEntity(hanny);


    }

    @Override
    public void setupTileMaps() {
        addTileMap(new CoralTileMap());
    }
}
