package com.xiangouo.mc.game.implement;

import com.ericlam.mc.minigames.core.arena.CreateArena;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.*;
import java.util.stream.Collectors;

public class TestArena implements CreateArena {

    private String author;
    private String arenaName;
    private String displayName;
    private Map<String, List<Location>> warpMap;
    private boolean changed;
    private World world;
    private List<String> description;

    public TestArena(String author, String arenaName, String displayName, Map<String, List<Location>> warpMap, World world, List<String> description) {
        this.author = author;
        this.arenaName = arenaName;
        this.displayName = displayName;
        this.warpMap = warpMap;
        this.changed = false;
        this.world = world;
        this.description = description;
    }

    public TestArena(String author, String arenaName, World world) {
        this(author, arenaName, arenaName, new HashMap<>(), world, new ArrayList<>());
    }

    @Override
    public void setAuthor(String s) {
        this.author = s;
    }

    @Override
    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public void setArenaName(String s) {
        this.arenaName = s;
    }

    @Override
    public void setDisplayName(String s) {
        this.displayName = s;
    }

    @Override
    public void setLocationMap(Map<String, List<Location>> map) {
        this.warpMap = map;
    }

    @Override
    public boolean isChanged() {
        return changed;
    }

    @Override
    public void setChanged(Boolean aBoolean) {
        this.changed = aBoolean;
    }

    @Override
    public boolean isSetupCompleted() {
        boolean warps = this.warpMap.size() >= 3;
        boolean locations = true;
        for (String s : this.warpMap.keySet()) {
            locations = locations && this.warpMap.get(s).size() > 0;
        }
        boolean authorName = getAuthor() != null;
        boolean displayName = getDisplayName() != null;
        boolean world = getWorld() != null;
        return warps && locations && authorName && displayName && world;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public String getArenaName() {
        return arenaName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public Map<String, List<Location>> getLocationsMap() {
        return warpMap;
    }

    @Override
    public List<String> getDescription() {
        return description;
    }

    @Override
    public String[] getInfo() {
        String[] info = new String[]{
                "arena: "+getArenaName(),
                "author: "+getAuthor(),
                "display: "+getDisplayName(),
                "world: "+getWorld().getName(),
                "warps: "+warpMap.keySet().stream().map(l->l.concat("("+warpMap.get(l).size()+")")).collect(Collectors.joining(", ")),
        };
        String[] story = this.getDescription().toArray(String[]::new);
        return (String[]) ArrayUtils.addAll(info, story);
    }
}
