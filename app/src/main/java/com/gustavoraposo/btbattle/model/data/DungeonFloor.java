package com.gustavoraposo.btbattle.model.data;

public class DungeonFloor {

    private String floorName;
    private int monsters;
    private int minLevel;
    private int maxLevel;

    public DungeonFloor(String floorName, int monsters, int minLevel, int maxLevel) {
        this.floorName = floorName;
        this.monsters = monsters;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public int getMonsters() {
        return monsters;
    }

    public void setMonsters(int monsters) {
        this.monsters = monsters;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
}
