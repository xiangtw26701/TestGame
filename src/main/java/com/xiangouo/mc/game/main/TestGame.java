package com.xiangouo.mc.game.main;

import com.ericlam.mc.minigames.core.main.MinigamesCore;
import com.ericlam.mc.minigames.core.registable.Compulsory;
import com.hypernite.mc.hnmc.core.main.HyperNiteMC;
import com.hypernite.mc.hnmc.core.managers.YamlManager;
import com.xiangouo.mc.game.config.TestConfig;
import com.xiangouo.mc.game.implement.TestArenaConfig;
import com.xiangouo.mc.game.implement.TestArenaMechanic;
import com.xiangouo.mc.game.implement.TestGamePlayerHandler;
import com.xiangouo.mc.game.stats.TestGameStatsHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class TestGame extends JavaPlugin {

    private static YamlManager yamlManager;

    @Override
    public void onEnable() {
        yamlManager = HyperNiteMC.getAPI().getFactory().getConfigFactory(this)
                .register("config.yml", TestConfig.class)
                .dump();
        final TestConfig testConfig = yamlManager.getConfigAs(TestConfig.class);
        Compulsory compulsory = MinigamesCore.getRegistration().getCompulsory();
        compulsory.registerArenaConfig(new TestArenaConfig(testConfig, this));
        compulsory.registerArenaMechanic(new TestArenaMechanic());
        compulsory.registerGamePlayerHandler(new TestGamePlayerHandler());
        compulsory.registerGameStatsHandler(new TestGameStatsHandler());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static YamlManager getYamlManager() {
        return yamlManager;
    }
}
