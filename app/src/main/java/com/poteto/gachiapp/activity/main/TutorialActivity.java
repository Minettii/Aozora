package com.poteto.gachiapp.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.poteto.gachiapp.R;
import com.poteto.gachiapp.databinding.ActivityTutorialBinding;

public class TutorialActivity extends AppCompatActivity {

    ActivityTutorialBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTutorialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Tutorial");
    }
}