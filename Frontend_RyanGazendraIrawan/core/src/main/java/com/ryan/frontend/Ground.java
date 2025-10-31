package com.ryan.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Ground {
    private static final float ground_height = 50f;
    private Rectangle collider;

    public Ground() {
        collider = new Rectangle (x=0, y=0, width= Gdx.graphics.getWidth() * 2f, ground_height)
    }

    public void update(float cameraX) {
        collider.x = cameraX - Gdx.graphics.getWidth() / 2f - 500;
        collider.y = 0;
        collider.width = Gdx.graphics.getWidth() * 2f;
    }

    public boolean isColliding(Rectangle playerCollider) return overlap();
    public float getTopY() return ground_height;
    public void renderShape(ShapeRenderer shapeRenderer)
}
