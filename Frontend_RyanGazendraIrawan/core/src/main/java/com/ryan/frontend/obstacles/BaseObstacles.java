package com.ryan.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseObstacles {
   public Vector2 position;
   public Rectangle collider;
   public float length;
   public final float WIDTH = 10f;
   public boolean active = false;


   public void Vector2 startPosition (int length) {
       updateCollider();
    }
   public void ShapeRenderer (shapeRenderer) {
       drawShape(shapeRenderer);
   }
   public static class isColliding (Rectangle playerCollider) {
       if(this.collider = playerCollider) return boolean = true;
   }
   public boolean isActive() {
       return boolean isActive = true;
   }
   public boolean isOffScreenCamera () {
       boolean getRenderWidth = true;
       return getRenderWidth;
   }
   private abstract void updateCollider();
   private abstract void drawShape (ShapeRenderer shapeRenderer);
   private abstract float getRenderWidth();
}
