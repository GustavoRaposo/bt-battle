package com.gustavoraposo.btbattle.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gustavoraposo.btbattle.model.Facade;
import com.gustavoraposo.btbattle.model.data.DungeonFloor;

import java.util.List;

public class DungeonViewModel extends ViewModel {
    private Facade facade;
    private List<DungeonFloor> floors;

    public DungeonViewModel (){
        facade = Facade.getInstance();
        floors = facade.getFloors();
    }

    public List<DungeonFloor> getFloors(){
        return floors;
    }
}
