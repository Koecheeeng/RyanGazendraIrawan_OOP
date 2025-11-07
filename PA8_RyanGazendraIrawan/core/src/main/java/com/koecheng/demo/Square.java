package com.koecheng.demo;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Square extends Shape {
    public Square() {
        super("Square");
    }

    @Override
    public void render(ShapeRenderer renderer) {
        renderer.rect(position.x - size / 2f, position.y - size / 2f, size, size);
    }
}
