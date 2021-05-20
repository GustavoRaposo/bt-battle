package com.gustavoraposo.btbattle.model;

import com.gustavoraposo.btbattle.model.data.Player;

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
}
