package com.app.myportfolio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeFragment extends Fragment {

Button btnmoreme;
BottomNavigationView bottomNavigationView;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        btnmoreme = view.findViewById(R.id.idbtnmoreabout);


        btnmoreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment NewFragment=new ProfileFragment();
                FragmentManager manager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction= manager.beginTransaction();
                fragmentTransaction.replace(R.id.container,NewFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}