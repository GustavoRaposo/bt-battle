package com.gustavoraposo.btbattle.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gustavoraposo.btbattle.R;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private NavController mNavController;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        view.findViewById(R.id.buttonHomeBattle).setOnClickListener(this);
        view.findViewById(R.id.buttonHomeDungeon).setOnClickListener(this);
        view.findViewById(R.id.buttonHomeProfile).setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mNavController = Navigation.findNavController(requireView());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonHomeBattle:
                mNavController.navigate(R.id.connectionFragment);
                break;
            case R.id.buttonHomeDungeon:
                mNavController.navigate(R.id.dungeonFragment);
                break;
            case R.id.buttonHomeProfile:
                mNavController.navigate(R.id.profileFragment);
                break;
        }
    }


}