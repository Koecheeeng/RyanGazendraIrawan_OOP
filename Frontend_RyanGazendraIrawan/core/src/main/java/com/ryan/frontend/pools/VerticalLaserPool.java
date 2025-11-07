package com.ryan.frontend.pools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.ryan.frontend.obstacles.VerticalLaser;

public class VerticalLaserPool extends ObjectPool<VerticalLaser> {

    @Override
    protected VerticalLaser createObject() {
        return new VerticalLaser(new Vector2(Gdx.graphics.getWidth(), 0), 100);
    }

    @Override
    protected void resetObject(VerticalLaser object) {
        object.setPosition(Gdx.graphics.getWidth(), 0);
        object.setActive(false);
    }

    public VerticalLaser obtain(Vector2 position, int length) {
        VerticalLaser obj = super.obtain();
        obj.initialize(position, length);
        obj.setActive(true);
        return obj;
    }
}
