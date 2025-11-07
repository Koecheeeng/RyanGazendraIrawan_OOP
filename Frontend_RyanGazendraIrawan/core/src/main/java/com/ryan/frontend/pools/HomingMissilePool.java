package com.ryan.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.ryan.frontend.obstacles.HomingMissile;

public class HomingMissilePool extends ObjectPool<HomingMissile> {

    @Override
    protected HomingMissile createObject() {
        return new HomingMissile(new Vector2(0, 0));
    }

    @Override
    protected void resetObject(HomingMissile object) {
        object.setPosition(0, 0);
        object.setActive(false);
        object.setTarget(null);
    }

    public HomingMissile obtain(Vector2 position) {
        HomingMissile obj = super.obtain();
        obj.initialize(position, 0);
        obj.setActive(true);
        return obj;
    }
}
