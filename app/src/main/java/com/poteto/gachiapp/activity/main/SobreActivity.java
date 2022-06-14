package com.poteto.gachiapp.activity.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;

import com.poteto.gachiapp.databinding.ActivitySobreBinding;

public class SobreActivity extends AppCompatActivity {

    ActivitySobreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySobreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Sobre o App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textUff.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}