package com.ryan.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Vector2 position;
    private Vector2 velocity;
    private float gravity = 2000f;
    private float jetpackForce = 1400f;
    private float maxVerticalSpeed = 700f;

    private Rectangle collider;
    private float width = 64f;
    private float height = 64f;

    private float baseSpeed = 300f;
    private float distanceTraveled = 0f;

    private boolean isDead = false;
    private Vector2 startPosition;

    public Player(Vector2 startPosition) {
        this.startPosition = new Vector2(startPosition);
        this.position = new Vector2(startPosition);

        this.collider = new Rectangle(
            position.x,
            position.y,
            width,
            height
        );

        this.velocity = new Vector2(baseSpeed, 0);
    }

    public void update(float delta, boolean isFlying) {
        if (!isDead) {
            updateDistance(delta);
            applyGravity(delta);
            if (isFlying) {
                fly();
            }
            updatePosition(delta);
        }
        updateCollider();
    }

    private void updateDistance(float delta) {
        distanceTraveled += velocity.x * delta;
    }

    private void updatePosition(float delta) {
        position.x += velocity.x * delta;
        position.y += velocity.y * delta;
    }

    private void applyGravity(float delta) {
        velocity.y -= gravity * delta;
        velocity.x = baseSpeed;

        if (velocity.y < -maxVerticalSpeed) velocity.y = -maxVerticalSpeed;
        if (velocity.y > maxVerticalSpeed) velocity.y = maxVerticalSpeed;
    }

    public void fly() {
        velocity.y += jetpackForce;
        if (velocity.y > maxVerticalSpeed) velocity.y = maxVerticalSpeed;
    }

    private void updateCollider() {
        collider.setPosition(position.x, position.y);
    }

    public void checkBoundaries(Ground ground, float ceilingY) {
        if (ground.isColliding(collider)) {
            position.y = ground.getTopY();
            velocity.y = 0;
        }

        if (position.y + height > ceilingY) {
            position.y = ceilingY - height;
            velocity.y = 0;
        }
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(0f, 1f, 0f, 1f);
        shapeRenderer.rect(position.x, position.y, width, height);
    }

    public void die() {
        isDead = true;
        velocity.x = 0;
        velocity.y = 0;
    }

    public void reset() {
        isDead = false;
        position.set(startPosition);
        velocity.set(baseSpeed, 0);
        distanceTraveled = 0f;
    }

    public Vector2 getPosition() { return position; }
    public float getWidth() { return width; }
    public float getHeight() { return height; }
    public Rectangle getCollider() { return collider; }
    public boolean isDead() { return isDead; }

    public float getDistanceTraveled() {
        return distanceTraveled / 10f;
    }
}
