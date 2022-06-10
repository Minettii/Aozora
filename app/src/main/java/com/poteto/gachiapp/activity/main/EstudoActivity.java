package com.poteto.gachiapp.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.poteto.gachiapp.activity.estudo.EstudoAdjetivosActivity;
import com.poteto.gachiapp.activity.estudo.EstudoAdverbiosActivity;
import com.poteto.gachiapp.activity.estudo.EstudoAntesComecarActivity;
import com.poteto.gachiapp.activity.estudo.EstudoEstadoSerActivity;
import com.poteto.gachiapp.activity.estudo.EstudoHiraganaActivity;
import com.poteto.gachiapp.activity.estudo.EstudoIntroducaoActivity;
import com.poteto.gachiapp.activity.estudo.EstudoKanjiActivity;
import com.poteto.gachiapp.activity.estudo.EstudoKatakanaActivity;
import com.poteto.gachiapp.activity.estudo.EstudoOracoesRelativasActivity;
import com.poteto.gachiapp.activity.estudo.EstudoOrdemSentencaActivity;
import com.poteto.gachiapp.activity.estudo.EstudoParticulasFirstActivity;
import com.poteto.gachiapp.activity.estudo.EstudoParticulasForthActivity;
import com.poteto.gachiapp.activity.estudo.EstudoParticulasSecondActivity;
import com.poteto.gachiapp.activity.estudo.EstudoParticulasThirdActivity;
import com.poteto.gachiapp.activity.estudo.EstudoRecursosActivity;
import com.poteto.gachiapp.activity.estudo.EstudoSistemaEscritaActivity;
import com.poteto.gachiapp.activity.estudo.EstudoVerbosBasicoActivity;
import com.poteto.gachiapp.activity.estudo.EstudoVerbosNegativoActivity;
import com.poteto.gachiapp.activity.estudo.EstudoVerbosPassadoActivity;
import com.poteto.gachiapp.activity.estudo.EstudoVerbosTransitivoActivity;
import com.poteto.gachiapp.databinding.ActivityEstudoAdjetivosBinding;
import com.poteto.gachiapp.databinding.ActivityEstudoBinding;
import com.poteto.gachiapp.databinding.ActivityMainBinding;
import com.poteto.gachiapp.helper.DialogEstudo;
import com.poteto.gachiapp.helper.PreferencesHelper;
import com.poteto.gachiapp.helper.TreinoDialog;
import com.poteto.gachiapp.model.Deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EstudoActivity extends AppCompatActivity {

    ActivityEstudoBinding binding;
    PreferencesHelper preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textCredits.setMovementMethod(LinkMovementMethod.getInstance());

        preferences = new PreferencesHelper(getApplicationContext());

        setTitle("Estudo");

        List<TextView> textViews = new ArrayList<>(Arrays.asList(binding.estudo1, binding.estudo2, binding.estudo3,
                binding.estudo4, binding.estudo5, binding.estudo6, binding.estudo7, binding.estudo8,
                binding.estudo9, binding.estudo10, binding.estudo11, binding.estudo12, binding.estudo13,
                binding.estudo14, binding.estudo15, binding.estudo16, binding.estudo17, binding.estudo18));

        for (TextView tv : textViews) {
            String id = String.valueOf(tv.getId());
            if (preferences.contains(id)) {
                int color = preferences.getInt(id);
                tv.setTextColor(color);
            }

            tv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    openDialog(tv);
                    return true;
                }
            });
        }

    }

    public void selectTopic(View v) {
        int topicId = v.getId();
        if (topicId == binding.estudo1.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoIntroducaoActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo2.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoRecursosActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo3.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoAntesComecarActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo4.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoSistemaEscritaActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo5.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoHiraganaActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo6.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoKatakanaActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo7.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoKanjiActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo8.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoEstadoSerActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo9.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoParticulasFirstActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo10.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoAdjetivosActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo11.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoVerbosBasicoActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo12.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoVerbosNegativoActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo13.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoVerbosPassadoActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo14.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoParticulasSecondActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo15.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoVerbosTransitivoActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo16.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoOracoesRelativasActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo17.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoOrdemSentencaActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo18.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoParticulasThirdActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo19.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoAdverbiosActivity.class);
            startActivity(intent);
        } else if (topicId == binding.estudo20.getId()) {
            Intent intent = new Intent(getApplicationContext(), EstudoParticulasForthActivity.class);
            startActivity(intent);
        }
    }

    private void openDialog(TextView textView) {
        DialogEstudo dialog = new DialogEstudo(textView, preferences);
        dialog.show(getSupportFragmentManager(), "estudoDialog");
    }
}