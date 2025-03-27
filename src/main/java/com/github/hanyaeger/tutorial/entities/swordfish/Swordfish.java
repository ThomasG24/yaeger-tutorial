package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Swordfish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {
    public Swordfish(final Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(2, 270d);
    }

    @Override
    public void setupEntities() {
        SwordFishSprite swordfishSprite = new SwordFishSprite(new Coordinate2D(0, 0));
        addEntity(swordfishSprite);

        HitBox hitBox = new HitBox(new Coordinate2D(0, 40));
        addEntity(hitBox);

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));

    }
}
