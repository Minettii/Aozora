package com.poteto.gachiapp.activity.card;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.poteto.gachiapp.databinding.ActivityCardDetailBinding;
import com.poteto.gachiapp.databinding.ActivityTreinoBinding;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.helper.DbHelper;
import com.poteto.gachiapp.helper.DeckDAO;
import com.poteto.gachiapp.model.Card;
import com.poteto.gachiapp.model.Deck;

public class CardDetailActivity extends AppCompatActivity {

    ActivityCardDetailBinding binding;

    String front, back, reading, example, exFurigana, exTranslation, deckName;
    Card card;
    CardDAO cardDAO;
    DeckDAO deckDAO;

    @Override
    protected void onStart() {
        super.onStart();

        int id = card.getDeck();
        Deck deck = deckDAO.getDeck(id);
        if (deck.getCustom()== DbHelper.CUSTOM_FALSE){
            binding.buttonEdit.setVisibility(View.GONE);
            if (deckDAO.listCustomDecksAdd().size()==0){
                binding.buttonDetail.setVisibility(View.GONE);
            }
        }else {
            if (deckDAO.listCustomDecksAdd().size()==1){
                binding.buttonDetail.setVisibility(View.GONE);
            }
        }


        front = card.getFront();
        back = card.getBack();
        reading = card.getReading();
        example = card.getExample();
        exFurigana = card.getExFurigana();
        exTranslation = card.getExTranslation();
        deckName = cardDAO.getDeckName(card.getDeck());

        String textFrontReading = front;
        if (reading!= null && !reading.isEmpty()) {
            textFrontReading += " 「"+reading+"」";
        }
        String textExample = "";
        if (example!= null && !example.isEmpty()) {
            textExample += "Ex.: "+example;
        }
        String textFurigana = "";
        if (exFurigana!= null && !exFurigana.isEmpty()) {
            textFurigana += exFurigana;
        }
        String textTranslation = "";
        if (exTranslation!= null && !exTranslation.isEmpty()) {
            textTranslation += exTranslation;
        }

        binding.textFrontReadingDetail.setText(textFrontReading);
        binding.textBackDetail.setText(back);
        binding.textExampleDetail.setText(textExample);
        binding.textExFurigana.setText(textFurigana);
        binding.textExTranslation.setText(textTranslation);
        binding.textDeckDetail.setText("Deck: "+deckName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCardDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cardDAO = new CardDAO(getApplicationContext());
        deckDAO = new DeckDAO(getApplicationContext());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        card = (Card) getIntent().getSerializableExtra(Card.KEY_CARD);
        setTitle("Detalhes do Cartão");

        binding.buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CardAddDeckActivity.class);
                intent.putExtra(Card.KEY_CARD, card);
                startActivity(intent);
            }
        });

        binding.buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CardCreateEditActivity.class);
                intent.putExtra(Card.KEY_CARD, card);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}