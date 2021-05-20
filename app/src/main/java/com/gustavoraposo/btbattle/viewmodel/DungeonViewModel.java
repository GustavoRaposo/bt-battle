package com.gustavoraposo.btbattle.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gustavoraposo.btbattle.model.Facade;
import com.gustavoraposo.btbattle.model.data.DungeonFloor;
import com.gustavoraposo.btbattle.model.data.Monster;
import com.gustavoraposo.btbattle.model.data.Player;

import java.util.List;

public class DungeonViewModel extends ViewModel {
    private Facade facade;
    private List<DungeonFloor> floors;
    private List<Monster> monsters;

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

    public List<Monster> getMonsters(){
        return facade.getMonsters();
    }

    public Player getPlayer(){
        return facade.getPlayer();
    }

    public int getExpProgress(){
        return (int) ((facade.getPlayer().getExp()/facade.getPlayer().getExpToLevelUp()) * 100);
    }
}
