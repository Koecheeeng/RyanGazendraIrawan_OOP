package com.ryan.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;

    private float boxSize = 100f;
    private float boxX, boxY;
    private Color boxColor;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false);

        boxX = Gdx.graphics.getWidth() / 2f - boxSize / 2f;
        boxY = Gdx.graphics.getHeight() / 2f - boxSize / 2f;
        boxColor = Color.RED;
    }

    @Override
    public void render() {
        handleInput();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(boxColor);
        shapeRenderer.rect(boxX, boxY, boxSize, boxSize);
        shapeRenderer.end();
    }

    private void handleInput() {
        float speed = 200 * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) boxX -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) boxX += speed;
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) boxY += speed;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) boxY -= speed;

        boxX = Math.max(0, Math.min(boxX, Gdx.graphics.getWidth() - boxSize));
        boxY = Math.max(0, Math.min(boxY, Gdx.graphics.getHeight() - boxSize));

        if (Gdx.input.justTouched()) {
            if (boxColor.equals(Color.RED)) boxColor = Color.YELLOW;
            else if (boxColor.equals(Color.YELLOW)) boxColor = Color.BLUE;
            else boxColor = Color.RED;

            System.out.println("Box color changed to: " + colorName(boxColor));
        }
    }

    private String colorName(Color c) {
        if (c.equals(Color.RED)) return "Red";
        if (c.equals(Color.YELLOW)) return "Yellow";
        if (c.equals(Color.BLUE)) return "Blue";
        return "Unknown";
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
