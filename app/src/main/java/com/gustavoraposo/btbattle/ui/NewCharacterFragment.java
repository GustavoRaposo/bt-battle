package com.gustavoraposo.btbattle.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.textview.MaterialTextView;
import com.gustavoraposo.btbattle.R;
import com.gustavoraposo.btbattle.viewmodel.GameViewModel;

public class NewCharacterFragment extends Fragment implements View.OnClickListener {

    private GameViewModel viewModel;
    private NavController mNavController;
    private ImageView mImageClassSelected;
    private MaterialTextView mTextViewHealthPoints;
    private MaterialTextView mTextViewMagicPoints;
    private MaterialTextView mTextViewDefencePoints;
    private int playerClass = 0;
    private int[][] classValues = {{75, 125, 100},{100,100,100},{120,60,120}};

    public static NewCharacterFragment newInstance() {
        return new NewCharacterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_character_fragment, container, false);

        view.findViewById(R.id.buttonNewCharacterClassFire).setOnClickListener(this);
        view.findViewById(R.id.buttonNewCharacterClassWater).setOnClickListener(this);
        view.findViewById(R.id.buttonNewCharacterClassEarth).setOnClickListener(this);
        view.findViewById(R.id.buttonNewCharacterConfirm).setOnClickListener(this);

        mImageClassSelected = view.findViewById(R.id.imageViewNewCharacterSelected);
        mTextViewHealthPoints = view.findViewById(R.id.textViewNewCharacterHealthPoints);
        mTextViewMagicPoints = view.findViewById(R.id.textViewNewCharacterMagicPoints);
        mTextViewDefencePoints = view.findViewById(R.id.textViewNewCharacterDefensePoints);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(GameViewModel.class);
        mNavController = Navigation.findNavController(requireView());
        selectClass(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonNewCharacterClassFire:
                selectClass(0);
                break;
            case R.id.buttonNewCharacterClassWater:
                selectClass(1);
                break;
            case R.id.buttonNewCharacterClassEarth:
                selectClass(2);
                break;
            case R.id.buttonNewCharacterConfirm:
                viewModel.setPlayerClass(playerClass);
                viewModel.setPlayer();
                mNavController.navigate(R.id.homeFragment);
                break;
        }
    }

    private void selectClass(int option){
        playerClass = option;
        switch (option){
            case 0:
                mImageClassSelected.setImageResource(R.drawable.ic_fire);
                mTextViewHealthPoints.setText(String.valueOf(classValues[0][0]));
                mTextViewMagicPoints.setText(String.valueOf(classValues[0][1]));
                mTextViewDefencePoints.setText(String.valueOf(classValues[0][2]));
                break;
            case 1:
                mImageClassSelected.setImageResource(R.drawable.ic_water);
                mTextViewHealthPoints.setText(String.valueOf(classValues[1][0]));
                mTextViewMagicPoints.setText(String.valueOf(classValues[1][1]));
                mTextViewDefencePoints.setText(String.valueOf(classValues[1][2]));
                break;
            case 2:
                mImageClassSelected.setImageResource(R.drawable.ic_earth);
                mTextViewHealthPoints.setText(String.valueOf(classValues[2][0]));
                mTextViewMagicPoints.setText(String.valueOf(classValues[2][1]));
                mTextViewDefencePoints.setText(String.valueOf(classValues[2][2]));
                break;
        }
    }
}