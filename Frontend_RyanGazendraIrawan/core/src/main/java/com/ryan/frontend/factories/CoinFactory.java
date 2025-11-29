package com.ryan.frontend.factories;

import com.ryan.frontend.Coin;
import com.ryan.frontend.pools.CoinPool;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class CoinFactory {
    private CoinPool coinPool;
    private Random random;

    public CoinFactory() {
        this.coinPool = new CoinPool();
        this.random = new Random();
    }

    public void createCoinPattern(float spawnX, float groundTopY) {
        if (random.nextInt(100) < 70) { // 70% chance to NOT spawn
            return;
        }

        float baseY = groundTopY + 100f + random.nextInt(500);

        for (int i = 0; i < 3; i++) {
            float coinX = spawnX + (i * 40f);
            coinPool.obtain(coinX, baseY);
        }
    }

    public List<Coin> getActiveCoins() {
        List<Coin> activeCoins = new ArrayList<>();
        for (Coin coin : coinPool.getPool()) {
            if (coin.isActive()) {
                activeCoins.add(coin);
            }
        }
        return activeCoins;
    }

    public void releaseCoin(Coin coin) {
        coinPool.free(coin);
    }

    public void releaseAll() {
        for (Coin coin : getActiveCoins()) {
            coinPool.free(coin);
        }
    }
}
