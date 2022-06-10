package com.poteto.gachiapp.activity.estudo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;

import com.poteto.gachiapp.R;
import com.poteto.gachiapp.databinding.ActivityEstudoAntesComecarBinding;

public class EstudoAntesComecarActivity extends AppCompatActivity {

    ActivityEstudoAntesComecarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoAntesComecarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}