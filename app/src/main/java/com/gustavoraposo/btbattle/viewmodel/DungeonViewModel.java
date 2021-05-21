package com.gustavoraposo.btbattle.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gustavoraposo.btbattle.model.Facade;
import com.gustavoraposo.btbattle.model.data.DungeonFloor;
import com.gustavoraposo.btbattle.model.data.Player;

import java.util.List;

public class DungeonViewModel extends ViewModel {
    private Facade facade;
    private List<DungeonFloor> floors;
    private List<Player> monsters;

    public DungeonViewModel (){
        facade = Facade.getInstance();
        floors = facade.getFloors();
    }

    public List<DungeonFloor> getFloors(){
        return floors;
    }

    public void loadMonsters(int size, int minLevel, int maxLevel){
        facade.loadMonsters(size, minLevel, maxLevel);
    }

    public List<Player> getMonsters(){
        return facade.getMonsters();
    }

    public Player getPlayer(){
        return facade.getPlayer();
    }

    public int getExpProgress(){
        return (int) ((facade.getPlayer().getExp()/facade.getPlayer().getExpToLevelUp()) * 100);
    }

    public boolean battle(Player monster){
        return facade.battle(monster);
    }
}
