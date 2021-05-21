package com.gustavoraposo.btbattle.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.material.textview.MaterialTextView;
import com.gustavoraposo.btbattle.R;
import com.gustavoraposo.btbattle.viewmodel.ProfileViewModel;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private ProfileViewModel viewModel;
    private MaterialTextView mTextViewPlayerName;
    private MaterialTextView mTextViewHealthPoints;
    private MaterialTextView mTextViewMagicPoints;
    private MaterialTextView mTextViewDefencePoints;
    private MaterialTextView mTextViewSpeedPoints;
    private MaterialTextView mTextViewLevel;
    private ProgressBar mProgressBarExp;
    private ImageView mImageViewPlayerClass;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        mImageViewPlayerClass = view.findViewById(R.id.imageViewProfilePlayerClass);
        mTextViewPlayerName = view.findViewById(R.id.textViewProfilePlayerName);
        mTextViewHealthPoints = view.findViewById(R.id.textViewProfileHealthPoints);
        mTextViewMagicPoints = view.findViewById(R.id.textViewProfileMagicPoints);
        mTextViewDefencePoints = view.findViewById(R.id.textViewProfileDefencePoints);
        mTextViewSpeedPoints= view.findViewById(R.id.textViewProfileSpeed);
        mTextViewLevel = view.findViewById(R.id.textViewProfileLevel);
        mProgressBarExp = view.findViewById(R.id.progressBarProfileExp);
        view.findViewById(R.id.buttonProfileBack).setOnClickListener(this);
        view.findViewById(R.id.buttonProfileSleep).setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        mImageViewPlayerClass.setImageResource(viewModel.getPlayerClass());
        mTextViewPlayerName.setText(viewModel.getPlayerName());
        mTextViewHealthPoints.setText(viewModel.getPlayerHealthPoints());
        mTextViewMagicPoints.setText(viewModel.getPlayerMagicPoints());
        mTextViewDefencePoints.setText(viewModel.getPlayerDefensePoints());
        mTextViewSpeedPoints.setText(viewModel.getPlayerSpeed());
        mTextViewLevel.setText(viewModel.getPlayerLevel());
        mProgressBarExp.setProgress(viewModel.getExpProgress());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonProfileBack){
            requireActivity().onBackPressed();
        }if (v.getId() == R.id.buttonProfileSleep){
            viewModel.sleep();
            mTextViewHealthPoints.setText(viewModel.getPlayerHealthPoints());
        }
    }
}