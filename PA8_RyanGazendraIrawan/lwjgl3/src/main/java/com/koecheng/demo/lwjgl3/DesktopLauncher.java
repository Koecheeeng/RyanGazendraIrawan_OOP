package com.koecheng.demo.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.koecheng.demo.Main;

public class DesktopLauncher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Koecheng Ganteng");
        config.setWindowedMode(800, 600);
        new Lwjgl3Application(new Main(), config);
    }
}
