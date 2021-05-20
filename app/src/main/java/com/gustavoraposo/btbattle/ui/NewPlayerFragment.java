package com.gustavoraposo.btbattle.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;
import com.gustavoraposo.btbattle.R;
import com.gustavoraposo.btbattle.viewmodel.GameViewModel;

public class NewPlayerFragment extends Fragment implements View.OnClickListener {

    private GameViewModel viewModel;
    private NavController mNavController;
    private MaterialButton mButtonConfirm;
    private MaterialButton mButtonCancel;
    private EditText mEditTextPlayerName;

    public static NewPlayerFragment newInstance() {
        return new NewPlayerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_player_fragment, container, false);

        mButtonConfirm = view.findViewById(R.id.buttonNewPlayerConfirm);
        mButtonCancel = view.findViewById(R.id.buttonNewPlayerCancel);
        mEditTextPlayerName = view.findViewById(R.id.editTextNewPlayerName);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(GameViewModel.class);
        mNavController = Navigation.findNavController(requireView());
        mButtonConfirm.setOnClickListener(this);
        mButtonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonNewPlayerConfirm:
                if (viewModel.setPlayerName(mEditTextPlayerName.getText().toString())) {
                    mNavController.navigate(R.id.newCharacterFragment);
                } else Toast.makeText(getContext(), "invalid name", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonNewPlayerCancel:
                mEditTextPlayerName.setText("");
                break;
        }
    }
}