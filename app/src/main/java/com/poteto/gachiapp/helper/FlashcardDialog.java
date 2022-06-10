package com.poteto.gachiapp.helper;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.poteto.gachiapp.databinding.DialogFlashcardBinding;
import com.poteto.gachiapp.databinding.DialogTreinoBinding;
import com.poteto.gachiapp.model.Deck;

public class FlashcardDialog extends AppCompatDialogFragment {

    EditText editQuantity;
    TextView textQuantity;
    FlashcardDialog.FlashcardDialogListener listener;
    Deck deck;
    DialogFlashcardBinding binding;
    CardDAO cardDAO;

    public FlashcardDialog(Deck deck, CardDAO cardDAO) {
        this.deck = deck;
        this.cardDAO = cardDAO;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        binding = DialogFlashcardBinding.inflate(getLayoutInflater());

        editQuantity = binding.editQuantity;
        textQuantity = binding.textQuantity;

        int deckSize = cardDAO.getDeckSize(deck.getId());
        int learnedSize = cardDAO.getDeckLearnedSize(deck.getId());
        int newCards = deckSize-learnedSize;
        String deckName = deck.getName();

        View view = (View) binding.getRoot();

        builder.setView(view).setTitle("Deck: "+deckName).setNegativeButton("Cancelar", null)
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String strQuantity = editQuantity.getText().toString();
                        if (strQuantity==null || strQuantity.isEmpty()) {
                            Toast.makeText(getActivity().getApplicationContext(),
                                    "A quantidade de cartões não foi informada",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }else {
                            int quantity = Integer.parseInt(editQuantity.getText().toString());
                            if (quantity>0 && quantity<=newCards) {
                                listener.startNewFlashcardSession(quantity, deck.getId());
                            } else if(newCards==1){
                                Toast.makeText(getActivity().getApplicationContext(),
                                        "Este deck possui apenas 1 cartão novo",
                                        Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(getActivity().getApplicationContext(),
                                        "A quantidade deve estar entre '1' e '"+newCards+"'.",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });

        textQuantity.setText("Quantidade máxima :"+newCards);
        binding.text111.setText("(Número de novos cartões no deck)");

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener= (FlashcardDialog.FlashcardDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException((context.toString()) + "must implement CustomDialogListener");
        }
    }

    public interface FlashcardDialogListener{
        void startNewFlashcardSession(int quantity, int deckId);
    }
}
