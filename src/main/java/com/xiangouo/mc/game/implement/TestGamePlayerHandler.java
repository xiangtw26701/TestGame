package com.xiangouo.mc.game.implement;

import com.ericlam.mc.minigames.core.character.GamePlayer;
import com.ericlam.mc.minigames.core.character.GamePlayerHandler;
import com.xiangouo.mc.game.config.TestConfig;
import com.xiangouo.mc.game.main.TestGame;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class TestGamePlayerHandler implements GamePlayerHandler {

    @Override
    public void onPlayerStatusChange(GamePlayer gamePlayer, GamePlayer.Status status) {
        Bukkit.broadcastMessage(gamePlayer.getPlayer().getName()+" is now "+status.toString());
        if (status == GamePlayer.Status.SPECTATING) gamePlayer.getPlayer().setGameMode(GameMode.SPECTATOR);
    }

    @Override
    public void onPlayerRemove(GamePlayer gamePlayer) {

    }

    @Override
    public GamePlayer createGamePlayer(Player player) {
        return new TestGamePlayer(player, null);
    }

    @Override
    public int requireStart() {
        return TestGame.getYamlManager().getConfigAs(TestConfig.class).requiredPlayers;
    }
}
