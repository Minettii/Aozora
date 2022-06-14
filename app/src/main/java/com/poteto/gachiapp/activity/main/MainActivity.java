package com.poteto.gachiapp.activity.main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.poteto.gachiapp.databinding.ActivityMainBinding;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.helper.PreCreateDB;
import com.poteto.gachiapp.helper.PreferencesHelper;

public class MainActivity extends AppCompatActivity {

    PreferencesHelper preferences;
    ActivityMainBinding binding;

    @Override
    protected void onStart() {
        super.onStart();
        CardDAO cardDAO = new CardDAO(this);
        int todayCards = cardDAO.getQuantityTodayFlashcards();
        if (todayCards>0) {
            binding.textTodayFlash.setText("Revisões agendadas para hoje: " + todayCards);
        } else {
            binding.textTodayFlash.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        preferences = new PreferencesHelper(getApplicationContext());

        //Copy Pre-Defined DataBase if (First use of APP)
        if  (preferences.getBoolean(preferences.KEY_FIRST_TIME)) {
            PreCreateDB.createDB(getApplicationContext());
            preferences.savePref(preferences.KEY_FIRST_TIME, false);
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Seja bem vindo!");
            alert.setMessage("Caso seja sua primeira vez usando o aplicativo é recomendado que você visite a seção \"Tutorial\"");
            alert.setPositiveButton("OK", null).show();
        }
    }

    public void clickButton(View v) {
        int id = v.getId();

        if (id==binding.buttonTutorial.getId()) {
            Intent intent = new Intent(this, TutorialActivity.class);
            startActivity(intent);
        }
        if (id==binding.buttonEstudo.getId()) {
            Intent intent = new Intent(this, EstudoActivity.class);
            startActivity(intent);
        }
        if (id==binding.buttonDecks.getId()) {
            Intent intent = new Intent(this, ShowDecksActivity.class);
            startActivity(intent);
        }
        if (id==binding.buttonConsulta.getId()) {
            Intent intent = new Intent(this, ConsultaActivity.class);
            startActivity(intent);
        }
        if (id==binding.buttonTreino.getId()) {
            Intent intent = new Intent(this, TreinoActivity.class);
            startActivity(intent);
        }
        if (id==binding.buttonFlashcards.getId()) {
            Intent intent = new Intent(this, FlashcardsActivity.class);
            startActivity(intent);
        }
        if (id==binding.buttonSobre.getId()) {
            Intent intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
        }
    }
}