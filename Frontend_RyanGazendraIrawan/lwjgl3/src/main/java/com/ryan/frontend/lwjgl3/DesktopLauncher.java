package com.ryan.frontend;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Case Study Modul 7 - LibGDX");
        config.setWindowedMode(1280, 720);
        config.useVsync(true);
        new Lwjgl3Application(new Main(), config);
    }
}
