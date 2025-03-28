package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.swordfish.HitBox;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {
    private HealthText healthText;
    private int health = 10;
    private Waterworld waterworld;

    public Hanny(Coordinate2D location, HealthText healthText, Waterworld waterworld) {
        super("sprites/hanny.png", location, new Size(20, 40), 1, 2);

        this.healthText = healthText;
        this.waterworld = waterworld;

        healthText.setHealthText(health);

        setGravityConstant(0.005);
        setFrictionConstant(0.004);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(3, 270d);
            setCurrentFrameIndex(0);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(3, 90d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(3, 180d);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(3, 0d);
        }
    }

    @Override
    public void setCurrentFrameIndex(int index) {
        super.setCurrentFrameIndex(index);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(List<Collider> colliderObject) {

        for (Collider collider : colliderObject) {
            if (collider instanceof HitBox) {
                health--;
                healthText.setHealthText(health);
            }
            if (collider instanceof Sharky) {
                health = health - 2;
                healthText.setHealthText(health);
            }
        }

        if (health <= 0) {
            waterworld.setActiveScene(2);
        }

        setAnchorLocation(
                new Coordinate2D(new Random().nextInt((int) (getSceneWidth() - getWidth())), new Random().nextInt((int) (getSceneHeight() - getHeight())))
        );
    }
}
