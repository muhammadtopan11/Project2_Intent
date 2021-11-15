package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Menangkap nilai dari Intent
        Intent intent = getIntent();
        binding.etNama.setText(intent.getStringExtra("nilai_nama"));
        binding.etUsia.setText(intent.getStringExtra("nilai_usia"));
    }
}