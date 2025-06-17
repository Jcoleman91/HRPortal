package com.example.hrportal.ui.home;

import com.example.hrportal.R;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hrportal.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        NavController navController = NavHostFragment.findNavController(this);

        Button announcementsBtn = view.findViewById(R.id.home_announcements);
        Button linksBtn = view.findViewById(R.id.home_links);
        Button downloadsBtn = view.findViewById(R.id.home_downloads);

        announcementsBtn.setOnClickListener(v ->
                navController.navigate(R.id.action_nav_home_to_nav_announcements)
        );

        linksBtn.setOnClickListener(v ->
                navController.navigate(R.id.action_nav_home_to_nav_links)
        );

        downloadsBtn.setOnClickListener(v ->
                navController.navigate(R.id.action_nav_home_to_nav_downloads)
        );

        return view;
    }
}
