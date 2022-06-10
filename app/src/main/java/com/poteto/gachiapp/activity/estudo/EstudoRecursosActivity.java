package com.poteto.gachiapp.activity.estudo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;

import com.poteto.gachiapp.R;
import com.poteto.gachiapp.databinding.ActivityEstudoBinding;
import com.poteto.gachiapp.databinding.ActivityEstudoRecursosBinding;

public class EstudoRecursosActivity extends AppCompatActivity {

    ActivityEstudoRecursosBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoRecursosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.intro.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}