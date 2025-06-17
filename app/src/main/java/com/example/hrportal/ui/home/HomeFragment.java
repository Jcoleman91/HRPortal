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

import com.example.hrportal.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Button edwardNoticeBtn = root.findViewById(R.id.edward_notice);
        edwardNoticeBtn.setOnClickListener(v -> {
            String url = "http://172.27.5.15/HRPortal/Downloads/FINALAnthemEdWardMemberNotice.pdf";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button anthemFactsBtn = root.findViewById(R.id.athem_facts);
        anthemFactsBtn.setOnClickListener(v -> {
            String url = "https://www.anthemfacts.com/";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}