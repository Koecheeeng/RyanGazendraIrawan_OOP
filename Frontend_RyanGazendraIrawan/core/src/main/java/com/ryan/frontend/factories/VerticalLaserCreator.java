package com.ryan.frontend.factories;

import java.util.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.ryan.frontend.obstacles.BaseObstacle;
import com.ryan.frontend.obstacles.VerticalLaser;
import com.ryan.frontend.pools.VerticalLaserPool;

public class VerticalLaserCreator implements ObstacleFactory.ObstacleCreator {

    private final VerticalLaserPool pool = new VerticalLaserPool();
    private static final float MIN_HEIGHT = 100f;
    private static final float MAX_HEIGHT = 300f;

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float height = MIN_HEIGHT + rng.nextFloat() * (MAX_HEIGHT - MIN_HEIGHT);
        float randomY = groundTopY;
        return pool.obtain(new Vector2(spawnX, randomY), (int) height);
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if (obstacle instanceof VerticalLaser) pool.release((VerticalLaser) obstacle);
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<VerticalLaser> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof VerticalLaser;
    }

    @Override
    public String getName() {
        return "VerticalLaser";
    }
}
