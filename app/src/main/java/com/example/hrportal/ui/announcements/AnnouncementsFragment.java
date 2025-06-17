package com.example.hrportal.ui.announcements;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hrportal.R;
import com.example.hrportal.databinding.FragmentAnnouncementsBinding;

public class AnnouncementsFragment extends Fragment {

    public AnnouncementsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentAnnouncementsBinding binding = FragmentAnnouncementsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button adpBtn = root.findViewById(R.id.anthem_notice);
        adpBtn.setOnClickListener(v -> {
            String url = "http://172.27.5.15/HRPortal/Downloads/FINALAnthemEdWardMemberNotice.pdf";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button payrollBtn = root.findViewById(R.id.anthem_facts);
        payrollBtn.setOnClickListener(v -> {
            String url = "https://www.anthemfacts.com/";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        return root;
    }
}
