package com.gustavoraposo.btbattle.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.gustavoraposo.btbattle.R;
import com.gustavoraposo.btbattle.adapter.DungeonAdapter;
import com.gustavoraposo.btbattle.adapter.RecyclerViewClickInterface;
import com.gustavoraposo.btbattle.model.data.DungeonFloor;
import com.gustavoraposo.btbattle.viewmodel.DungeonViewModel;

import java.util.List;

public class DungeonFragment extends Fragment implements View.OnClickListener, RecyclerViewClickInterface {

    private DungeonViewModel viewModel;
    private NavController mNavController;
    private RecyclerView mRecyclerViewFloors;
    private DungeonAdapter mDungeonAdapter;
    private MaterialTextView mTextViewDungeonFloorName;
    private List<DungeonFloor> mFloors;
    private int floorSelected = 1;

    public static DungeonFragment newInstance() {
        return new DungeonFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dungeon_fragment, container, false);

        view.findViewById(R.id.buttonDungeonConfirm).setOnClickListener(this);
        view.findViewById(R.id.buttonDungeonBack).setOnClickListener(this);
        mTextViewDungeonFloorName = view.findViewById(R.id.textViewDungeonFloor);
        mRecyclerViewFloors = view.findViewById(R.id.recyclerViewDungeonFloors);
        mRecyclerViewFloors.setLayoutManager(new LinearLayoutManager(requireActivity()));
        mRecyclerViewFloors.setHasFixedSize(true);
        mDungeonAdapter = new DungeonAdapter(this);
        mRecyclerViewFloors.setAdapter(mDungeonAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DungeonViewModel.class);
        mNavController = Navigation.findNavController(requireView());
        mFloors = viewModel.getFloors();
        mDungeonAdapter.setList(mFloors);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonDungeonConfirm:
                viewModel.loadMonsters(
                        mFloors.get(floorSelected).getMonsters(),
                        mFloors.get(floorSelected).getMinLevel(),
                        mFloors.get(floorSelected).getMaxLevel()
                );
                mNavController.navigate(R.id.floorFragment);
                break;
            case R.id.buttonDungeonBack:
                requireActivity().onBackPressed();
                break;
        }
    }

    @Override
    public void onItemClick(int position) {
        mTextViewDungeonFloorName.setText(mFloors.get(position).getFloorName());
        floorSelected = position;
    }

    @Override
    public void onLongItemClick(int position) {

    }
}