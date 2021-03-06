package com.example.schedulemessenger;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.schedulemessenger.databinding.FragmentDashBoardBinding;

public class DashBoardFragment extends Fragment {

    private FragmentDashBoardBinding fragmentDashBoardBinding;

    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment, using ViewBinding
        fragmentDashBoardBinding = FragmentDashBoardBinding.inflate(inflater, container, false);
        View rootView = fragmentDashBoardBinding.getRoot();
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //To avoid memory leaks
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentDashBoardBinding = null;
    }

}