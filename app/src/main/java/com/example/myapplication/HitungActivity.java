package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityHitungBinding;
import com.example.myapplication.databinding.ActivityMainBinding;

public class HitungActivity extends AppCompatActivity {

    private ActivityHitungBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHitungBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Hitung");

        binding.btTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etNilai1.getText().toString().isEmpty() || binding.etNilai2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Nilai harus diisi",Toast.LENGTH_SHORT);
                } else {
                    int nilai_1 = Integer.parseInt(binding.etNilai1.getText().toString());
                    int nilai_2 = Integer.parseInt(binding.etNilai2.getText().toString());
                    int hasil = nilai_1 + nilai_2;

                    binding.etHasil.setText(String.valueOf(hasil));
                }
            }
        });

        binding.btKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etNilai1.getText().toString().isEmpty() || binding.etNilai2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Nilai harus diisi",Toast.LENGTH_SHORT);
                } else {
                    int nilai_1 = Integer.parseInt(binding.etNilai1.getText().toString());
                    int nilai_2 = Integer.parseInt(binding.etNilai2.getText().toString());
                    int hasil = nilai_1 - nilai_2;

                    binding.etHasil.setText(String.valueOf(hasil));
                }
            }
        });

        binding.btKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etNilai1.getText().toString().isEmpty() || binding.etNilai2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Nilai harus diisi",Toast.LENGTH_SHORT);
                } else {
                    int nilai_1 = Integer.parseInt(binding.etNilai1.getText().toString());
                    int nilai_2 = Integer.parseInt(binding.etNilai2.getText().toString());
                    int hasil = nilai_1 * nilai_2;

                    binding.etHasil.setText(String.valueOf(hasil));
                }
            }
        });

        binding.btBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etNilai1.getText().toString().isEmpty() || binding.etNilai2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Nilai harus diisi",Toast.LENGTH_SHORT);
                } else {
                    int nilai_1 = Integer.parseInt(binding.etNilai1.getText().toString());
                    int nilai_2 = Integer.parseInt(binding.etNilai2.getText().toString());
                    int hasil = nilai_1 / nilai_2;

                    binding.etHasil.setText(String.valueOf(hasil));
                }
            }
        });

        binding.btSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etHasil.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Buat perhitungan dulu", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("nilai_hasil", binding.etHasil.getText().toString());
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
