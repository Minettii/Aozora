package com.poteto.gachiapp.helper;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.poteto.gachiapp.databinding.DialogTreinoBinding;
import com.poteto.gachiapp.model.Deck;

public class TreinoDialog extends AppCompatDialogFragment {
    EditText editQuantity;
    TextView textQuantity;
    TreinoDialogListener listener;
    Deck deck;
    DialogTreinoBinding binding;
    CardDAO cardDAO;

    public TreinoDialog(Deck deck, CardDAO cardDAO) {
        this.deck = deck;
        this.cardDAO = cardDAO;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        binding = DialogTreinoBinding.inflate(getLayoutInflater());

        editQuantity = binding.editQuantity;
        textQuantity = binding.textQuantity;

        int deckSize = cardDAO.getDeckSize(deck.getId());
        int learnedSize = cardDAO.getDeckLearnedSize(deck.getId());
        String deckName = deck.getName();

        View view = (View) binding.getRoot();

        binding.radioGroup.check(binding.radioAll.getId());
        textQuantity.setText("Quantidade máxima :" + deckSize);
        binding.text111.setText("(Número de cartões no deck)");

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == binding.radioAll.getId()) {
                    textQuantity.setText("Quantidade máxima :" + deckSize);
                    binding.text111.setText("(Número de cartões no deck)");
                } else if (checkedId == binding.radioLearned.getId()) {
                    textQuantity.setText("Quantidade máxima :" + learnedSize);
                    binding.text111.setText("(Nº de cartões do deck aprendidos)");
                }
            }
        });


        builder.setView(view).setTitle("Deck: " + deckName).setNegativeButton("Cancelar", null)
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String strQuantity = editQuantity.getText().toString();
                        if (strQuantity == null || strQuantity.isEmpty()) {
                            Toast.makeText(getActivity().getApplicationContext(),
                                    "A quantidade de cartões não foi informada",
                                    Toast.LENGTH_LONG).show();
                            return;
                        } else {
                            if (binding.radioGroup.getCheckedRadioButtonId() == binding.radioAll.getId()) {
                                int intQuantity = Integer.parseInt(strQuantity);
                                if (intQuantity > 0 && intQuantity <= deckSize) {
                                    listener.startAllTrainingSession(intQuantity);
                                } else if (deckSize == 1) {
                                    Toast.makeText(getActivity().getApplicationContext(),
                                            "Este deck possui apenas 1 cartão",
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getActivity().getApplicationContext(),
                                            "A quantidade deve estar entre '1' e '" + deckSize + "'.",
                                            Toast.LENGTH_LONG).show();
                                }
                            } else if (binding.radioGroup.getCheckedRadioButtonId() == binding.radioLearned.getId()) {
                                int intQuantity = Integer.parseInt(strQuantity);
                                if (intQuantity > 0 && intQuantity <= learnedSize) {
                                    listener.startLearnedTrainingSession(intQuantity);
                                } else if (learnedSize == 1) {
                                    Toast.makeText(getActivity().getApplicationContext(),
                                            "Este deck possui apenas 1 cartão aprendido",
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getActivity().getApplicationContext(),
                                            "A quantidade deve estar entre '1' e '" + learnedSize + "'.",
                                            Toast.LENGTH_LONG).show();
                                }
                            }

                        }
                    }
                });

        return builder.create();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (TreinoDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException((context.toString()) + "must implement CustomDialogListener");
        }
    }

    public interface TreinoDialogListener {
        void startAllTrainingSession(int quantity);

        void startLearnedTrainingSession(int quantity);
    }
}

