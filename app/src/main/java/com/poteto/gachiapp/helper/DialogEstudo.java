package com.poteto.gachiapp.helper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.poteto.gachiapp.R;
import com.poteto.gachiapp.databinding.ActivityDialogEstudoBinding;
import com.poteto.gachiapp.databinding.DialogTreinoBinding;
import com.poteto.gachiapp.model.Deck;


public class DialogEstudo extends AppCompatDialogFragment {
    TextView textTeste, originalText;
    RadioGroup radioGroupColors;
    RadioButton radioGray, radioBlack, radioMain, radioStrongBlue, radioGreen, radioRed;

    ActivityDialogEstudoBinding binding;
    PreferencesHelper preferences;


    public DialogEstudo(TextView originalText, PreferencesHelper preferences) {
        this.originalText = originalText;
        this.preferences = preferences;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        binding = ActivityDialogEstudoBinding.inflate(getLayoutInflater());

        textTeste = binding.textTeste;
        radioGroupColors = binding.radioGroupColors;
        radioGray = binding.radioGray;
        radioBlack = binding.radioBlack;
        radioMain = binding.radioMain;
        radioStrongBlue = binding.radioStrongBlue;
        radioGreen = binding.radioGreen;
        radioRed = binding.radioRed;

        View view = (View) binding.getRoot();

        radioGroupColors.check(radioGray.getId());
        textTeste.setText(originalText.getText());
        textTeste.setTextColor(getResources().getColor(R.color.gray));

        radioGroupColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == binding.radioGray.getId()) {
                    textTeste.setTextColor(getResources().getColor(R.color.gray));
                } else if (checkedId == binding.radioBlack.getId()) {
                    textTeste.setTextColor(getResources().getColor(R.color.black));
                } else if (checkedId == binding.radioMain.getId()) {
                    textTeste.setTextColor(getResources().getColor(R.color.mainBlue));
                } else if (checkedId == binding.radioStrongBlue.getId()) {
                    textTeste.setTextColor(getResources().getColor(R.color.strongBlue));
                } else if (checkedId == binding.radioGreen.getId()) {
                    textTeste.setTextColor(getResources().getColor(R.color.green));
                } else if (checkedId == binding.radioRed.getId()) {
                    textTeste.setTextColor(getResources().getColor(com.tsuryo.swipeablerv.R.color.red));
                }
            }
        });

        builder.setView(view).setNegativeButton("Cancelar", null)
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String originalId = String.valueOf(originalText.getId());
                        if (radioGroupColors.getCheckedRadioButtonId() == radioGray.getId()) {
                            originalText.setTextColor(getResources().getColor(R.color.gray));
                            preferences.savePref(originalId, getResources().getColor(R.color.gray));
                            dismiss();
                        } else if (radioGroupColors.getCheckedRadioButtonId() == radioBlack.getId()) {
                            originalText.setTextColor(getResources().getColor(R.color.black));
                            preferences.savePref(originalId, getResources().getColor(R.color.black));
                            dismiss();
                        } else if (radioGroupColors.getCheckedRadioButtonId() == radioMain.getId()) {
                            originalText.setTextColor(getResources().getColor(R.color.mainBlue));
                            preferences.savePref(originalId, getResources().getColor(R.color.mainBlue));
                            dismiss();
                        } else if (radioGroupColors.getCheckedRadioButtonId() == radioStrongBlue.getId()) {
                            originalText.setTextColor(getResources().getColor(R.color.strongBlue));
                            preferences.savePref(originalId, getResources().getColor(R.color.strongBlue));
                            dismiss();
                        } else if (radioGroupColors.getCheckedRadioButtonId() == radioGreen.getId()) {
                            originalText.setTextColor(getResources().getColor(R.color.green));
                            preferences.savePref(originalId, getResources().getColor(R.color.green));
                            dismiss();
                        } else if (radioGroupColors.getCheckedRadioButtonId() == radioRed.getId()) {
                            originalText.setTextColor(getResources().getColor(com.tsuryo.swipeablerv.R.color.red));
                            preferences.savePref(originalId, getResources().getColor(com.tsuryo.swipeablerv.R.color.red));
                            dismiss();
                        }
                    }
                });
        return builder.create();
    }
}
