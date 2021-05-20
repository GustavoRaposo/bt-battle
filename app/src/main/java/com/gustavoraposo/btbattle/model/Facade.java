package com.gustavoraposo.btbattle.model;

import com.gustavoraposo.btbattle.model.data.DungeonFloor;
import com.gustavoraposo.btbattle.model.data.Player;

import java.util.ArrayList;
import java.util.List;

public class Facade {
    private static Facade instance;
    private String playerName;

    public static synchronized Facade getInstance(){
        if(instance == null){
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

    public List<DungeonFloor> getFloors(){
        List<DungeonFloor> floors = new ArrayList<>();
        floors.add(new DungeonFloor("1st Floor", 3, 1, 5));
        floors.add(new DungeonFloor("2nd Floor", 5, 3, 7));
        floors.add(new DungeonFloor("3rd Floor", 7, 5, 10));
        floors.add(new DungeonFloor("4th Floor", 10, 7, 15));
        floors.add(new DungeonFloor("5th Floor", 15, 10, 20));
        floors.add(new DungeonFloor("6th Floor", 20, 15, 25));
        return floors;
    }
}
