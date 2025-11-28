package com.ryan.frontend.pools;

import com.ryan.frontend.Coin;

public class CoinPool extends ObjectPool<Coin> {

    @Override
    protected Coin createObject() {
        return null;
    }

    @Override
    protected void resetObject(Coin object) {
    }

    public obtain(float x, float y) {
        super.obtain();
    }
}
