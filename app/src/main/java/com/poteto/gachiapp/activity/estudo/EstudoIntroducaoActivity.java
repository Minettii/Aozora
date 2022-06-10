package com.poteto.gachiapp.activity.estudo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.poteto.gachiapp.R;
import com.poteto.gachiapp.databinding.ActivityEstudoIntroducaoBinding;
import com.poteto.gachiapp.databinding.ActivityHiraganaBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoIntroducaoActivity extends AppCompatActivity {

    ActivityEstudoIntroducaoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoIntroducaoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}