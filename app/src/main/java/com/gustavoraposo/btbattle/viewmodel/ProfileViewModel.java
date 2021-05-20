package com.gustavoraposo.btbattle.viewmodel;

import androidx.lifecycle.ViewModel;

import com.gustavoraposo.btbattle.R;
import com.gustavoraposo.btbattle.model.Facade;

public class ProfileViewModel extends ViewModel {
    private Facade facade;

    public ProfileViewModel(){
        facade = Facade.getInstance();
    }

    public int getPlayerClass(){
        int i =0;

        switch (facade.getPlayer().getPlayerClass()){
            case 0:
                return R.drawable.ic_fire;
            case 1:
                return R.drawable.ic_water;
            case 2:
                return R.drawable.ic_earth;
            default:
                return 0;
        }
    }

    public String getPlayerName(){
        return facade.getPlayer().getName();
    }

    public String getPlayerHealthPoints(){
        return String.valueOf(facade.getPlayer().getHealthPoints());
    }

    public String getPlayerMagicPoints(){
        return String.valueOf(facade.getPlayer().getMagicPoints());
    }

    public String getPlayerDefensePoints(){
        return String.valueOf(facade.getPlayer().getDefensePoints());
    }

    public String getPlayerSpeed(){
        return String.valueOf(facade.getPlayer().getSpeed());
    }

    public String getPlayerLevel(){
        return String.valueOf(facade.getPlayer().getLevel());
    }

    public int getExpProgress(){
        return (int) ((facade.getPlayer().getExp()/facade.getPlayer().getExpToLevelUp()) * 100);
    }
}
