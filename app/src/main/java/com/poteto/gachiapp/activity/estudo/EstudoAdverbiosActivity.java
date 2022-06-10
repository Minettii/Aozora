package com.poteto.gachiapp.activity.estudo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.poteto.gachiapp.R;
import com.poteto.gachiapp.databinding.ActivityEstudoAdjetivosBinding;
import com.poteto.gachiapp.databinding.ActivityEstudoAdverbiosBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoAdverbiosActivity extends AppCompatActivity {

    ActivityEstudoAdverbiosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoAdverbiosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo19);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}