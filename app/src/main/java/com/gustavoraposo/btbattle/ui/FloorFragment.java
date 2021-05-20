package com.gustavoraposo.btbattle.ui;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.textview.MaterialTextView;
import com.gustavoraposo.btbattle.R;
import com.gustavoraposo.btbattle.adapter.MonsterAdapter;
import com.gustavoraposo.btbattle.adapter.RecyclerViewClickInterface;
import com.gustavoraposo.btbattle.model.data.DungeonFloor;
import com.gustavoraposo.btbattle.model.data.Monster;
import com.gustavoraposo.btbattle.viewmodel.DungeonViewModel;

import java.util.ArrayList;
import java.util.List;

public class FloorFragment extends Fragment implements RecyclerViewClickInterface, View.OnClickListener {

    private DungeonViewModel viewModel;
    private NavController mNavController;
    private RecyclerView mRecyclerViewFloors;
    private MonsterAdapter mMonsterAdapter;
    private MaterialTextView mTextViewFloorPlayerName;
    private MaterialTextView mTextViewFloorPlayerHealth;
    private MaterialTextView mTextViewFloorPlayerLevel;
    private ProgressBar mProgressBarFloorPlayerExp;
    private List<Monster> mMonsters;

    public static FloorFragment newInstance() {
        return new FloorFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.floor_fragment, container, false);

        view.findViewById(R.id.buttonFloorBack).setOnClickListener(this);
        mTextViewFloorPlayerName = view.findViewById(R.id.textViewFloorPlayerName);
        mTextViewFloorPlayerHealth = view.findViewById(R.id.textViewFloorPlayerHealth);
        mTextViewFloorPlayerLevel = view.findViewById(R.id.textViewFloorPlayerLevel);
        mProgressBarFloorPlayerExp = view.findViewById(R.id.progressBarPlayerExp);
        mRecyclerViewFloors = view.findViewById(R.id.recyclerViewFloorMonsters);
        mRecyclerViewFloors.setLayoutManager(new LinearLayoutManager(requireActivity()));
        mRecyclerViewFloors.setHasFixedSize(true);
        mMonsterAdapter = new MonsterAdapter(this);
        mRecyclerViewFloors.setAdapter(mMonsterAdapter);
        return view;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DungeonViewModel.class);
        mNavController = Navigation.findNavController(requireView());
        mMonsters = viewModel.getMonsters();
        mMonsterAdapter.setList(mMonsters);
        mTextViewFloorPlayerName.setText(viewModel.getPlayer().getName());
        mTextViewFloorPlayerHealth.setText(
                String.format(
                        "%d / %d",
                        viewModel.getPlayer().getHealthPoints(),
                        viewModel.getPlayer().getBaseHealthPoints()
                )
        );
        mTextViewFloorPlayerLevel.setText(String.valueOf(viewModel.getPlayer().getLevel()));
        mProgressBarFloorPlayerExp.setProgress(viewModel.getExpProgress());
    }

    @Override
    public void onItemClick(int position) {
        //todo: viewModel.battle(position)
    }

    @Override
    public void onLongItemClick(int position) {

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonFloorBack){
            requireActivity().onBackPressed();
        }
    }
}