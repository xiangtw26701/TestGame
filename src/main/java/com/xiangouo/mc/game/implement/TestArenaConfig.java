package com.xiangouo.mc.game.implement;

import com.ericlam.mc.minigames.core.arena.ArenaConfig;
import com.google.common.collect.ImmutableMap;
import com.xiangouo.mc.game.config.TestConfig;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class TestArenaConfig implements ArenaConfig {

    private final TestConfig testConfig;
    private final Plugin plugin;

    public TestArenaConfig(TestConfig testConfig, Plugin plugin) {
        this.testConfig = testConfig;
        this.plugin = plugin;
    }

    public File getArenaFolder() {
        return new File(plugin.getDataFolder(), "Areas");
    }

    public int getMaxLoadArena() {
        return testConfig.maxLoadArenas;
    }

    public void setExtraWorldSetting(@Nonnull World world) {

    }

    public ImmutableMap<String, Integer> getAllowWarps() {
        return ImmutableMap.<String, Integer>builder().put("deathmatch", 5).put("game", 24).build();
    }

    public Location getLobbyLocation() {
        return testConfig.lobbyLocation;
    }

    public String getFallBackServer() {
        return testConfig.fallbackServer;
    }

    public String getGamePrefix() {
        return null;
    }

    public CompletableFuture<Boolean> setLobbyLocation(Location location) {
        return CompletableFuture.supplyAsync(() -> {
            testConfig.lobbyLocation = location;
            try {
                testConfig.save();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        });
    }
}
