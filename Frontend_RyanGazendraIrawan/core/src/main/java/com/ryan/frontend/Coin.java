package com.ryan.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static java.awt.Color.yellow;
import static java.lang.Boolean.TRUE;

public class Coin {
    private Vector2 position;
    private Rectangle collider;
    private float radius = 15f;
    private boolean active;
    private float bobOffset;
    private float bobSpeed;

    public Coin {
        Vector2 startPosition;
    }

    public update (float delta) {
        bobOffset = bobSpeed * delta;
    }

    public renderShape(ShapeRenderer shapeRenderer) {
        drawY = position.y + (float)(Math.sin(bobOffset) * 5f);
        shapeRenderer.circle(yellow);
        shapeRenderer.setColor(1f, 1f, 0f, 1f);
        if (circle(position.x, drawY, radius) = 0) {
            return;
        }
    }

    public void isColliding(Rectangle playerCollider) {
        if (active = TRUE) {
            return TRUE;
        }
    }
}
