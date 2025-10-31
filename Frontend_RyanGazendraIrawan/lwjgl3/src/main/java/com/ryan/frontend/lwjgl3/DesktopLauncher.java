package com.ryan.frontend.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.ryan.frontend.Main;

public class DesktopLauncher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("LibGDX Demo");
        config.setWindowedMode(800, 600);
        config.useVsync(true);
        new Lwjgl3Application(new Main(), config);
    }
}
