package com.poteto.gachiapp.activity.card;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import com.poteto.gachiapp.R;
import com.poteto.gachiapp.databinding.ActivityCardCreateEditBinding;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.model.Card;
import com.poteto.gachiapp.model.Deck;


public class CardCreateEditActivity extends AppCompatActivity {

    Card card;
    int deckId;
    Bundle extras;
    CardDAO cardDAO;

    String front, back, reading, example, exFurigana, exTranslation;

    ActivityCardCreateEditBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCardCreateEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cardDAO = new CardDAO(getApplicationContext());
        extras = getIntent().getExtras();
        card = new Card();

        if (extras.containsKey(Card.KEY_CARD)) {
            card = (Card) getIntent().getSerializableExtra(Card.KEY_CARD);
            deckId = card.getDeck();
            binding.textInputFront.setText(card.getFront());
            binding.textInputBack.setText(card.getBack());
            binding.textInputReading.setText(card.getReading());
            binding.textInputExample.setText(card.getExample());
            binding.textInputExFurigana.setText(card.getExFurigana());
            binding.textInputExTranslation.setText(card.getExTranslation());
        }

        if (extras.containsKey(Deck.KEY_DECK)) {
            setTitle("Criação de Cartão");
            deckId = extras.getInt(Deck.KEY_DECK);
        }else {
            setTitle("Edição de Cartão");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit_card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.okButton) {
            saveCard();
            return true;
        }
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void saveCard() {
        front = binding.textInputFront.getText().toString();
        back = binding.textInputBack.getText().toString();
        reading = binding.textInputReading.getText().toString();
        example = binding.textInputExample.getText().toString();
        exFurigana = binding.textInputExFurigana.getText().toString();
        exTranslation = binding.textInputExTranslation.getText().toString();

        if (front.isEmpty() || back.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Os campos obrigatórios devem ser preenchidos.",
                    Toast.LENGTH_LONG).show();
            return;
        }
        card.setFront(front);
        card.setBack(back);
        card.setReading(reading);
        card.setExample(example);
        card.setExFurigana(exFurigana);
        card.setExTranslation(exTranslation);
        card.setDeck(deckId);

        if (extras.containsKey(Card.KEY_CARD)) {
            cardDAO.update(card);
            Toast.makeText(getApplicationContext(), "Cartão: '"+card.getFront()+"' editado com sucesso.", Toast.LENGTH_LONG).show();
        }else if (extras.containsKey(Deck.KEY_DECK)) {
            cardDAO.save(card);
            Toast.makeText(getApplicationContext(), "Cartão: '"+card.getFront()+"' criado com sucesso.", Toast.LENGTH_LONG).show();
        }
        finish();
    }
}