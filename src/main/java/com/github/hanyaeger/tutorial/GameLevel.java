package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene {

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

        var healthText = new HealthText(
                new Coordinate2D(0, 0)
        );
        addEntity(healthText);

        Hanny hanny = new Hanny(
                new Coordinate2D(getWidth() - 20, 0), healthText
        );
        addEntity(hanny);


    }
}
