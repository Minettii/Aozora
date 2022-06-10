package com.poteto.gachiapp.activity.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.poteto.gachiapp.activity.flashcard.TreinoSessionActivity;
import com.poteto.gachiapp.databinding.ActivityTreinoBinding;
import com.poteto.gachiapp.helper.AdapterDeck;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.helper.DeckDAO;
import com.poteto.gachiapp.helper.RecyclerItemClickListener;
import com.poteto.gachiapp.helper.TreinoDialog;
import com.poteto.gachiapp.model.Card;
import com.poteto.gachiapp.model.Deck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreinoActivity extends AppCompatActivity implements TreinoDialog.TreinoDialogListener{

    public static String KEY_CARDS_SESSION = "trainingCards";

    ActivityTreinoBinding binding;
    List<Deck> listCustomDecks = new ArrayList<>();
    List<Deck> listDefaultDecks = new ArrayList<>();
    DeckDAO deckDAO;
    CardDAO cardDAO;
    AdapterDeck adapterCustomDeck;
    AdapterDeck adapterDefaultDeck;
    RecyclerView rvDefault, rvCustom;
    Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTreinoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setElevation(0);
        setTitle("Treino com Flashcards");

        cardDAO = new CardDAO(this);
        deckDAO = new DeckDAO(this);
        listCustomDecks = deckDAO.listCustomDecks();
        if (listCustomDecks.size()==0) {
            binding.rvCustom.setVisibility(View.GONE);
            binding.dividerCustom.setVisibility(View.GONE);
            binding.dividerCustom2.setVisibility(View.GONE);
            binding.textDeckCustomTreino.setVisibility(View.GONE);
        }else {
            adapterCustomDeck = new AdapterDeck(listCustomDecks);
            rvCustom = binding.rvCustom;
            rvCustom.setLayoutManager(new LinearLayoutManager(this));
            rvCustom.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
            rvCustom.setAdapter(adapterCustomDeck);
            rvCustom.setHasFixedSize(true);

            rvCustom.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), rvCustom,
                            new RecyclerItemClickListener.OnItemClickListener() {

                                @Override
                                public void onItemClick(View view, int position) {
                                    deck = listCustomDecks.get(position);
                                    openDialog(deck);
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


        listDefaultDecks = deckDAO.listDefaultDecks();

        adapterDefaultDeck = new AdapterDeck(listDefaultDecks);
        rvDefault = binding.rvDefault;
        rvDefault.setLayoutManager(new LinearLayoutManager(this));
        rvDefault.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rvDefault.setAdapter(adapterDefaultDeck);
        rvDefault.setHasFixedSize(true);

        rvDefault.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvDefault,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                deck = listDefaultDecks.get(position);
                                openDialog(deck);
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

    private void openDialog(Deck deck) {
        TreinoDialog dialog = new TreinoDialog(deck, cardDAO);
        dialog.show(getSupportFragmentManager(), "treinoDialog");
    }

    @Override
    public void startAllTrainingSession(int quantity) {
        Intent intent = new Intent(getApplicationContext(), TreinoSessionActivity.class);
        cardDAO = new CardDAO(getApplicationContext());
        List<Card> listCards;
        listCards = cardDAO.listCards(deck.getId());
        Collections.shuffle(listCards);
        List<Card> randomList = new ArrayList<>();
        for (int i=0; i<quantity; i++) {
            randomList.add(listCards.get(i));
        }
        intent.putExtra(KEY_CARDS_SESSION, (Serializable) randomList);
        startActivity(intent);

    }@Override
    public void startLearnedTrainingSession(int quantity) {
        Intent intent = new Intent(getApplicationContext(), TreinoSessionActivity.class);
        cardDAO = new CardDAO(getApplicationContext());
        List<Card> listCards;
        listCards = cardDAO.listLearnedCards(deck.getId());
        Collections.shuffle(listCards);
        List<Card> randomList = new ArrayList<>();
        for (int i=0; i<quantity; i++) {
            randomList.add(listCards.get(i));
        }
        intent.putExtra(KEY_CARDS_SESSION, (Serializable) randomList);
        startActivity(intent);

    }
}