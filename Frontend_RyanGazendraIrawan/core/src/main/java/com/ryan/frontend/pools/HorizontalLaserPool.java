package com.ryan.frontend.pools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.ryan.frontend.obstacles.HorizontalLaser;

public class HorizontalLaserPool extends ObjectPool<HorizontalLaser> {

    @Override
    protected HorizontalLaser createObject() {
        return new HorizontalLaser(new Vector2(Gdx.graphics.getWidth(), 0), 100);
    }

    @Override
    protected void resetObject(HorizontalLaser object) {
        object.setPosition(Gdx.graphics.getWidth(), 0);
        object.setActive(false);
    }

    public HorizontalLaser obtain(Vector2 position, int length) {
        HorizontalLaser obj = super.obtain();
        obj.initialize(position, length);
        obj.setActive(true);
        return obj;
    }
}
