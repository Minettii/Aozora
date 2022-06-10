package com.poteto.gachiapp.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.poteto.gachiapp.R;
import com.poteto.gachiapp.model.Deck;

public class DeckDialog extends AppCompatDialogFragment {

    EditText editNomeDeck;
    DeckDialogListener listener;
    Deck deck;
    int position;

    public DeckDialog(Deck deck, int position) {
        this.deck = deck;
        this.position = position;
    }

    public DeckDialog() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_deck, null);

        editNomeDeck = view.findViewById(R.id.editDeckName);


        builder.setView(view).setNegativeButton("Cancelar", null)
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String deckName = editNomeDeck.getText().toString();
                        if (deckName.isEmpty()) {
                            Toast.makeText(getActivity().getApplicationContext(),
                                    "O nome do deck não pode ser vazio",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (deck!=null) {
                            deck.setName(deckName);
                            listener.editDeckName(deck, position);
                        } else {
                            deck = new Deck();
                            deck.setName(deckName);
                            dismiss();
                            listener.createDeck(deck);
                        }
                    }
                });
        if (deck!=null) {
            builder.setTitle("Editar deck: "+deck.getName());
            editNomeDeck.setText(deck.getName());
        }else {
            builder.setTitle("Criar deck");
        }
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener= (DeckDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException((context.toString()) + "must implement DeckDialogListener");
        }
    }

    public interface DeckDialogListener{
        void createDeck (Deck deck);
        void editDeckName (Deck deck, int position);
    }
}
