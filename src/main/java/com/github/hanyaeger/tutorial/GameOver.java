package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends StaticScene {
    Waterworld waterworld;

    public GameOver(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var gameOver = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game Over"
        );
        gameOver.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOver.setFill(Color.DARKBLUE);
        gameOver.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameOver);

        var playAgain = new StartButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 3 * 2), this.waterworld
        );
        playAgain.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(playAgain);
    }
}
