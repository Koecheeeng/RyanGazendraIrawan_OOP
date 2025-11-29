package com.ryan.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ryan.frontend.Background;
import com.ryan.frontend.Coin;
import com.ryan.frontend.GameManager;
import com.ryan.frontend.Ground;
import com.ryan.frontend.Player;
import com.ryan.frontend.factories.CoinFactory;
import static javax.swing.text.StyleConstants.Background;


public class PlayingState implements GameState {
    private GameStateManager gsm;
    private Player player;
    private Ground ground;
    private Background background;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    // Part 5: Coin Integration
    private final CoinFactory coinFactory;
    private float coinSpawnTimer = 0f;

    public PlayingState(GameStateManager gsm) {
        this.gsm = gsm;
        player = new Player(new Vector2(100, 100));
        ground = new Ground();
        background = new Background();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer = new ShapeRenderer();

        coinFactory = new CoinFactory();

        GameManager.getInstance().startGame();
    }

    @Override
    public void update(float delta) {
        if (!player.isDead()) {
            player.update(delta, Gdx.input.isTouched());
            player.checkBoundaries(ground, camera.viewportHeight);

            camera.position.x = player.getPosition().x + 200;
            camera.update();

            ground.update(camera.position.x);
            background.update(camera.position.x);

            updateCoins(delta);
            checkCoinCollisions();

            GameManager.getInstance().setScore((int) player.getDistanceTraveled());

        } else {
            GameManager.getInstance().endGame();

            gsm.set(new MenuState(gsm));
        }
    }

    private void updateCoins(float delta) {
        coinSpawnTimer += delta;
        if (coinSpawnTimer > 0.5f) {
            float spawnX = camera.position.x + camera.viewportWidth / 2f;

            coinFactory.createCoinPattern(spawnX, ground.getTopY());

            coinSpawnTimer = 0f;
        }

        float cameraLeft = camera.position.x - camera.viewportWidth / 2f;

        for (Coin coin : coinFactory.getActiveCoins()) {
            coin.update(delta);

            if (coin.isOffScreenCamera(cameraLeft)) {
                coinFactory.releaseCoin(coin);
            }
        }
    }

    private void checkCoinCollisions() {
        Rectangle playerCollider = player.getCollider();

        for (Coin coin : coinFactory.getActiveCoins()) {
            if (coin.isColliding(playerCollider)) {
                GameManager.getInstance().addCoin();

                coinFactory.releaseCoin(coin);
            }
        }
    }


    @Override
    public void render(SpriteBatch batch) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        background.render(batch);
        batch.end();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        player.renderShape(shapeRenderer);

        ground.renderShape(shapeRenderer);

        for (Coin coin : coinFactory.getActiveCoins()) {
            coin.renderShape(shapeRenderer);
        }

        shapeRenderer.end();

        int currentScore = GameManager.getInstance().getScore();
        int currentCoins = GameManager.getInstance().getCoins();
    }

    @Override
    public void dispose() {
        coinFactory.releaseAll();

        shapeRenderer.dispose();
        background.dispose();
    }

    @Override
    public void handleInput() {}

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}
}
