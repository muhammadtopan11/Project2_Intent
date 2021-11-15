package com.example.myapplication;



import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ActivityResultLauncher<Intent> intentLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    binding.etHasil.setText(result.getData().getStringExtra("nilai_hasil"));
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Main");

        binding.btProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), ProfileActivity.class));
            }
        });

        binding.btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.etNama.getText().toString().isEmpty() || binding.etUsia.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Nama atau Usia harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    //Kirimkan data ke Detail Activity
                    Intent intent = new Intent(view.getContext(), DetailActivity.class);
                    intent.putExtra("nilai_nama", binding.etNama.getText().toString());
                    intent.putExtra("nilai_usia", binding.etUsia.getText().toString());
                    startActivity(intent);
                }
            }
        });

        binding.btUlangi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Kosongkan et_nama dan et_usia
                binding.etNama.setText(null);
                binding.etUsia.setText(null);
            }
        });

        binding.btHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),HitungActivity.class);
                intentLauncher.launch(intent);
            }
        });
    }
}