package com.ryan.frontend.commands;

import com.ryan.frontend.GameManager;
import com.ryan.frontend.Player;

import static jdk.javadoc.internal.tool.Main.execute;

class RestartCommand (private val player:Player, gameManager: ) : command {
    private val gameManager:GameManager

        init {
        this.gameManager = gameManager
    }

    override fun execute() {
        player.reset()
            gameManager.setScore(0)
    }
}
