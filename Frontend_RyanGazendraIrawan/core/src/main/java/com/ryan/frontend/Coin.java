package com.ryan.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;

public class Coin {
    private Vector2 position;
    private Rectangle collider;
    private float radius = 15f;
    private boolean active;
    private float bobOffset;
    private float bobSpeed = 6f;

    public Coin(Vector2 startPosition) {
        this.position = new Vector2(startPosition);
        this.collider = new Rectangle(
            position.x - radius,
            position.y - radius,
            2 * radius,
            2 * radius
        );
        this.active = true;
        this.bobOffset = 0f;
    }

    public void update(float delta) {
        if (!active) return;
        bobOffset += bobSpeed * delta;

        // Update collider position to follow the visual Y
        float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);
        collider.setPosition(position.x - radius, drawY - radius);
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        if (!active) return;

        float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);

        shapeRenderer.setColor(1f, 1f, 0f, 1f); // Yellow color
        shapeRenderer.circle(position.x, drawY, radius);
    }

    public boolean isColliding(Rectangle playerCollider) {
        if (!active) {
            return false;
        }

        if (collider.overlaps(playerCollider)) {
            this.active = false;
            return true;
        }
        return false;
    }

    public boolean isOffScreenCamera(float cameraLeft) {
        return position.x + radius < cameraLeft;
    }

    public void setPosition(float x, float y) {
        this.position.set(x, y);
        this.collider.setPosition(x - radius, y - radius);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Getter
    public boolean isActive() {
        return active;
    }
}
