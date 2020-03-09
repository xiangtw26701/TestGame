package com.xiangouo.mc.game.config;

import com.hypernite.mc.hnmc.core.config.yaml.Configuration;
import com.hypernite.mc.hnmc.core.config.yaml.Resource;
import org.bukkit.Location;

@Resource(locate = "config.yml")
public class TestConfig extends Configuration {

    public int maxLoadArenas;

    public Location lobbyLocation;

    public String fallbackServer;

    public int requiredPlayers;

}
