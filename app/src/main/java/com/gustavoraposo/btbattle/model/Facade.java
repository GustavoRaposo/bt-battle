package com.gustavoraposo.btbattle.model;

import com.gustavoraposo.btbattle.model.data.Battle;
import com.gustavoraposo.btbattle.model.data.DungeonFloor;
import com.gustavoraposo.btbattle.model.data.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Facade {
    private static Facade instance;
    private String playerName;
    private List<Player> monsters;

    public static synchronized Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    private Player player;

    public static void setInstance(Facade instance) {
        Facade.instance = instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<DungeonFloor> getFloors() {
        List<DungeonFloor> floors = new ArrayList<>();
        floors.add(new DungeonFloor("1st Floor", 3, 1, 5));
        floors.add(new DungeonFloor("2nd Floor", 5, 3, 7));
        floors.add(new DungeonFloor("3rd Floor", 7, 5, 10));
        floors.add(new DungeonFloor("4th Floor", 10, 7, 15));
        floors.add(new DungeonFloor("5th Floor", 15, 10, 20));
        floors.add(new DungeonFloor("6th Floor", 20, 15, 25));
        return floors;
    }

    public void loadMonsters(int size, int minLevel, int maxLevel) {
        List<Player> monsters = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            Random random = new Random();
            monsters.add(
                    new Player(
                            "minion",
                            random.nextInt((6 - 3)) + 3,
                            random.nextInt((maxLevel - minLevel) + 1) + minLevel
                    )
            );
        }
        Random random = new Random();
        monsters.add(new Player("Boss", random.nextInt((6 - 3)) + 3, maxLevel + 2));
        monsters.get(monsters.size() - 1).setExp(monsters.get(monsters.size() - 1).getExp() * 2);
        this.monsters = monsters;
    }

    public List<Player> getMonsters() {
        return monsters;
    }

    public boolean battle(Player monster){
        return new Battle(player, monster).battle();
    }

    public void sleep(){
        player.restoreHealth();
    }
}
