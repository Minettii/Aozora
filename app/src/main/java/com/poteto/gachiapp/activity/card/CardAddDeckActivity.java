package com.poteto.gachiapp.activity.card;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.poteto.gachiapp.databinding.ActivityCardAddDeckBinding;
import com.poteto.gachiapp.databinding.ActivityMainBinding;
import com.poteto.gachiapp.helper.AdapterDeck;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.helper.DeckDAO;
import com.poteto.gachiapp.helper.RecyclerItemClickListener;
import com.poteto.gachiapp.model.Card;
import com.poteto.gachiapp.model.Deck;

import java.util.ArrayList;
import java.util.List;

public class CardAddDeckActivity extends AppCompatActivity {

    ActivityCardAddDeckBinding binding;
    List<Deck> decks = new ArrayList<>();
    Card card;
    int deckId;
    DeckDAO deckDAO;
    CardDAO cardDAO;
    AdapterDeck adapterDeck;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCardAddDeckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Adicionar Cartão ao Deck");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        card = (Card) getIntent().getSerializableExtra(Card.KEY_CARD);
        deckId = card.getDeck();

        cardDAO = new CardDAO(getApplicationContext());
        deckDAO = new DeckDAO(getApplicationContext());
        decks = deckDAO.listDecksToAdd(deckId);

        adapterDeck = new AdapterDeck(decks);
        rv = binding.rvAddToDeck;
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rv.setAdapter(adapterDeck);

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rv,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Deck deck = decks.get(position);
                                int currentDeck = deck.getId();

                                Card newCard = new Card();

                                newCard.setDeck(currentDeck);

                                newCard.setFront(card.getFront());
                                newCard.setBack(card.getBack());
                                newCard.setReading(card.getReading());
                                newCard.setExample(card.getExample());
                                newCard.setExFurigana(card.getExFurigana());
                                newCard.setExTranslation(card.getExTranslation());
                                cardDAO.save(newCard);

                                Toast.makeText(getApplicationContext(), "Cartão: '"+
                                        card.getFront()+"' adicionado com sucesso ao deck: '"+
                                        deck.getName()+"'.", Toast.LENGTH_LONG).show();
                                finish();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        })
        );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}