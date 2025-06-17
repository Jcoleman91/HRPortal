package com.example.hrportal.ui.links;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hrportal.R;
import com.example.hrportal.databinding.FragmentLinksBinding;

public class LinksFragment extends Fragment {

    private FragmentLinksBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LinksViewModel linksViewModel =
                new ViewModelProvider(this).get(LinksViewModel.class);

        binding = FragmentLinksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button adpBtn = root.findViewById(R.id.adp_work_force_pay_stub);
        adpBtn.setOnClickListener(v -> {
            String url = "https://online.adp.com/signin/v1/?APPID=WFNPortal&productId=80e309c3-7085-bae1-e053-3505430b5495&returnURL=https://workforcenow.adp.com/&callingAppId=WFN";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button payrollBtn = root.findViewById(R.id.payroll_self_service);
        payrollBtn.setOnClickListener(v -> {
            String url = "http://172.30.5.1/selfservice/";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button wellnessNomBtn = root.findViewById(R.id.wellness_warrior_nomination);
        wellnessNomBtn.setOnClickListener(v -> {
            String url = "https://fandpwellnesswarrior.questionpro.com/";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button blueCrossBtn = root.findViewById(R.id.bluecross_blueshield);
        blueCrossBtn.setOnClickListener(v -> {
            String url = "https://www.anthem.com/?redirected=bcbsga";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button fidelityBtn = root.findViewById(R.id.fidelity_netbenefits);
        fidelityBtn.setOnClickListener(v -> {
            String url = "https://nb.fidelity.com/static/mybenefits/netbenefitslogin/#/login";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button infinisourceBtn = root.findViewById(R.id.infinisource);
        infinisourceBtn.setOnClickListener(v -> {
            String url = "https://infinconsumer.lh1ondemand.com/Login.aspx?ReturnUrl=%2f";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button employeeBenefitsBtn = root.findViewById(R.id.employee_benefits_open_enrollment);
        employeeBenefitsBtn.setOnClickListener(v -> {
            String url = "https://mybensite.com/fandpgeorgia/";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button myCignaBtn = root.findViewById(R.id.mycigna);
        myCignaBtn.setOnClickListener(v -> {
            String url = "https://my.cigna.com/web/public/guest";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button angioscreenBtn = root.findViewById(R.id.angioscreen_signup);
        angioscreenBtn.setOnClickListener(v -> {
            String url = "https://bit.ly/FandPAngio";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        Button wellnessTriviaBtn = root.findViewById(R.id.wellness_trivia);
        wellnessTriviaBtn.setOnClickListener(v -> {
            String url = "https://octoberwellnesstrivia.questionpro.com/";
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
