package com.xiangouo.mc.game.implement;

import com.ericlam.mc.minigames.core.arena.Arena;
import com.ericlam.mc.minigames.core.arena.ArenaMechanic;
import com.ericlam.mc.minigames.core.arena.CreateArena;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class TestArenaMechanic implements ArenaMechanic {
    @Override
    public CreateArena loadCreateArena(FileConfiguration fileConfiguration, Arena arena) {
        return new TestArena(arena.getAuthor(), arena.getArenaName(), arena.getDisplayName(), arena.getLocationsMap(), arena.getWorld(), arena.getDescription());
    }

    @Override
    public CreateArena createArena(@Nonnull String s, @Nonnull Player player) {
        return new TestArena(player.getName(), s, player.getWorld());
    }

    @Override
    public void saveExtraArenaSetting(FileConfiguration fileConfiguration, Arena arena) {
        //
    }
}
