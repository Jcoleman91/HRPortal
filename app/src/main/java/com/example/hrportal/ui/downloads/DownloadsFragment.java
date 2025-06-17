package com.example.hrportal.ui.downloads;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.example.hrportal.R;
import com.example.hrportal.databinding.FragmentDownloadsBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DownloadsFragment extends Fragment {

    private FragmentDownloadsBinding binding;

    private final String suggestionForm = "http://172.27.5.15/HRPortal/Downloads/SuggestionForm2.pdf";
    private final String directDepositForm = "http://172.27.5.15/HRPortal/Downloads/DirectDepositForm.pdf";
    private final String stateTaxForm = "http://172.27.5.15/HRPortal/Downloads/TSD_Employees_Withholding_Allowance_Certificate_G4.pdf";
    private final String jobTransferForm = "http://172.27.5.15/HRPortal/Downloads/G4HR008RevBJobTransferForm.pdf";
    private final String accidentClaimForm = "http://172.27.5.15/HRPortal/Downloads/AccidentClaimForm67715.pdf";
    private final String employeeHandbook = "http://172.27.5.15/HRPortal/Associate_Handbook_Rev_K_2025.pdf";
    private final String payrollChange = "http://172.27.5.15/HRPortal/Downloads/G4HR013RevDPayrollChangeNotice.pdf";
    private final String beneficiaryForm = "http://172.27.5.15/HRPortal/Downloads/AnthemBeneficiary.pdf";
    private final String federalTaxForm = "http://172.27.5.15/HRPortal/Downloads/W42014.pdf";
    private final String wellnessClaimForm = "http://172.27.5.15/HRPortal/Downloads/CurrentWellnessClaimForm.pdf";
    private final String illnessClaimForm = "http://172.27.5.15/HRPortal/Downloads/CriticalIllnessClaimForm65017.pdf";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDownloadsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupButton(binding.suggestionForm, "SuggestionForm.pdf", suggestionForm);
        setupButton(binding.directDepositForm, "DirectDepositForm.pdf", directDepositForm);
        setupButton(binding.stateTaxForm, "stateTaxForm.pdf", stateTaxForm);
        setupButton(binding.jobTransferForm, "jobTransferForm.pdf", jobTransferForm);
        setupButton(binding.accidentClaimForm, "AccidentClaimForm.pdf", accidentClaimForm);
        setupButton(binding.employeeHandbook, "Associate_Handbook.pdf", employeeHandbook);
        setupButton(binding.payrollChange, "PayrollChangeNotice.pdf", payrollChange);
        setupButton(binding.beneficiaryForm, "AnthemBeneficiary.pdf", beneficiaryForm); //TODO: GET ACTUAL PDF ADD TO ASSETS
        setupButton(binding.federalTaxForm, "FederalTaxForm.pdf", federalTaxForm);
        setupButton(binding.wellnessClaimForm, "WellnessClaimForm.pdf", wellnessClaimForm);
        setupButton(binding.illnessClaimForm, "CriticalIllnessClaimForm.pdf", illnessClaimForm);



        return root;
    }

    private void setupButton(Button button, String assetFileName, String url) {
        button.setOnClickListener(v -> showOptionDialog(assetFileName, url));
    }



    private void showOptionDialog(String assetFileName, String url) {
        new android.app.AlertDialog.Builder(requireContext())
                .setTitle("Select an Option")
                .setMessage("Would you like to preview or download this file?")
                .setPositiveButton("Preview", (dialog, which) -> openUrlInBrowser(url))
                .setNegativeButton("Download", (dialog, which) -> downloadPdfFromAssets(assetFileName))
                .setNeutralButton("Cancel", null)
                .show();
    }



    private void openUrlInBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }



    private void downloadPDF(String url) {
        String fileName = Uri.parse(url).getLastPathSegment();
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle("Downloading PDF");
        request.setDescription("Saving to Downloads...");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(requireContext(), Environment.DIRECTORY_DOWNLOADS, fileName);

        DownloadManager manager = (DownloadManager) requireContext().getSystemService(Context.DOWNLOAD_SERVICE);
        if (manager != null) manager.enqueue(request);
    }

    private void downloadPdfFromAssets(String assetFileName) {
        try {
            File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (!downloadsDir.exists()) downloadsDir.mkdirs();

            File outFile = new File(downloadsDir, assetFileName);
            InputStream input = requireContext().getAssets().open(assetFileName);
            OutputStream output = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            input.close();
            output.close();

            Toast.makeText(getContext(), "Saved to Downloads", Toast.LENGTH_SHORT).show();

            // Auto open
            Uri uri = FileProvider.getUriForFile(
                    requireContext(),
                    "com.example.hrportal.fileprovider",
                    outFile
            );

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Download failed", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
