package com.ryan.frontend.factories;

import java.util.*;
import com.badlogic.gdx.math.Vector2;
import com.ryan.frontend.obstacles.BaseObstacle;
import com.ryan.frontend.obstacles.HomingMissile;
import com.ryan.frontend.pools.HomingMissilePool;

public class HomingMissileCreator implements ObstacleFactory.ObstacleCreator {

    private final HomingMissilePool pool = new HomingMissilePool();

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float randomY = groundTopY + rng.nextFloat() * 400f;
        return pool.obtain(new Vector2(spawnX, randomY));
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if (obstacle instanceof HomingMissile) pool.release((HomingMissile) obstacle);
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<HomingMissile> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof HomingMissile;
    }

    @Override
    public String getName() {
        return "HomingMissile";
    }
}
