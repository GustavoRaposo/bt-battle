package com.gustavoraposo.btbattle.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gustavoraposo.btbattle.R;
import com.gustavoraposo.btbattle.model.Facade;
import com.gustavoraposo.btbattle.model.data.Player;

import java.util.regex.Pattern;

public class SetUpViewModel extends ViewModel {
    private Facade facade;
    private int playerClass;

    public SetUpViewModel(){
        facade = Facade.getInstance();
    }


    public Boolean setPlayerName(String playerName) {
        if (Pattern.matches("[a-zA-Z0-9]{1,10}", playerName)){
            facade.setPlayerName(playerName);
            return true;
        }else return false;
    }

    public void setPlayerClass(int playerClass) {
        this.playerClass = playerClass;
    }

    public void setPlayer(){
        facade.setPlayer(new Player(facade.getPlayerName(), playerClass));
    }

    public void hideSystemUi(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
