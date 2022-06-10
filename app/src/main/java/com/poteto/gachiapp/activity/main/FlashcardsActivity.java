package com.poteto.gachiapp.activity.main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.poteto.gachiapp.activity.flashcard.FlashcardSessionActivity;
import com.poteto.gachiapp.activity.flashcard.TreinoSessionActivity;
import com.poteto.gachiapp.databinding.ActivityFlashcardsBinding;
import com.poteto.gachiapp.helper.AdapterFlashcard;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.helper.DeckDAO;
import com.poteto.gachiapp.helper.FlashcardDialog;
import com.poteto.gachiapp.helper.RecyclerItemClickListener;
import com.poteto.gachiapp.model.Deck;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlashcardsActivity extends AppCompatActivity implements FlashcardDialog.FlashcardDialogListener {

    public static String KEY_NEW = "new";
    public static String KEY_ID = "id";


    ActivityFlashcardsBinding binding;

    List<Deck> listCustomDecks = new ArrayList<>();
    List<Deck> listDefaultDecks = new ArrayList<>();
    DeckDAO deckDAO;
    CardDAO cardDAO;
    AdapterFlashcard adapterDefaultFlashcard, adapterCustomFlashcard;
    RecyclerView rvDefault, rvCustom;

    LocalDate todayDate = LocalDate.now();
    LocalDate nextDate = todayDate.plusDays(3);
    LocalDateTime nextDateTime = nextDate.atTime(0, 0);
    long nextMillis = nextDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

    @Override
    protected void onStart() {
        Log.d("fff", "todayDate: "+todayDate);
        Log.d("fff", "nextDate: "+nextDate);
        Log.d("fff", "nextDateTime: "+nextDateTime);
        Log.d("fff", "nextMillis: "+nextMillis);
        super.onStart();
        listDecks();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlashcardsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Flashcards Agendados");
        Objects.requireNonNull(getSupportActionBar()).setElevation(0);

        cardDAO = new CardDAO(this);
        deckDAO = new DeckDAO(this);

        rvCustom = binding.rvCustom;
        rvDefault = binding.rvFlashcard;

        rvCustom.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvCustom,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Deck deck = listCustomDecks.get(position);
                                if (cardDAO.getQuantityTodayFlashcards(deck.getId()) != 0) {
                                    openDialogReview(deck);
                                } else {
                                    int deckSize = cardDAO.getDeckSize(deck.getId());
                                    int learnedSize = cardDAO.getDeckLearnedSize(deck.getId());
                                    int newCards = deckSize - learnedSize;
                                    if (newCards == 0) {
                                        Toast.makeText(getApplicationContext(),
                                                "Não há novos cartões para serem estudados neste deck",
                                                Toast.LENGTH_LONG).show();
                                    } else {
                                        openDialogNew(deck);
                                    }
                                }
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        })
        );

        rvDefault.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvDefault,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Deck deck = listDefaultDecks.get(position);
                                if (cardDAO.getQuantityTodayFlashcards(deck.getId()) != 0) {
                                    openDialogReview(deck);
                                } else {
                                    int deckSize = cardDAO.getDeckSize(deck.getId());
                                    int learnedSize = cardDAO.getDeckLearnedSize(deck.getId());
                                    int newCards = deckSize - learnedSize;
                                    if (newCards == 0) {
                                        Toast.makeText(getApplicationContext(),
                                                "Não há novos cartões para serem estudados neste deck",
                                                Toast.LENGTH_LONG).show();
                                    } else {
                                        openDialogNew(deck);
                                    }
                                }
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

    private void openDialogReview(Deck deck) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Deck: " + deck.getName()).setMessage("Deseja estudar agora os cartões desse deck agendados para hoje?")
                .setNegativeButton("Cancelar", null)
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), FlashcardSessionActivity.class);
                        intent.putExtra(KEY_ID, deck.getId());
                        startActivity(intent);
                    }
                });
        builder.show();
    }

    private void listDecks() {
        listDefaultDecks = deckDAO.listDefaultDecks();
        listCustomDecks = deckDAO.listCustomDecks();

        int todayCards = cardDAO.getQuantityTodayFlashcards();
        int tomorrowCards = cardDAO.getQuantityTomorrowFlashcards();
        binding.textTodayReviews.setText("Cartões agendados para hoje: " + todayCards);
        binding.textTomorrowReviews.setText("Cartões agendados para amanhã: " + tomorrowCards);

        if (listCustomDecks.size() == 0) {
            binding.rvCustom.setVisibility(View.GONE);
            binding.dividerFlashCustom.setVisibility(View.GONE);
            binding.textFlashCustom.setVisibility(View.GONE);
        } else {
            adapterCustomFlashcard = new AdapterFlashcard(listCustomDecks, cardDAO);

            rvCustom.setLayoutManager(new LinearLayoutManager(this));
            rvCustom.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
            rvCustom.setAdapter(adapterCustomFlashcard);
        }

        adapterDefaultFlashcard = new AdapterFlashcard(listDefaultDecks, cardDAO);

        rvDefault.setLayoutManager(new LinearLayoutManager(this));
        rvDefault.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rvDefault.setAdapter(adapterDefaultFlashcard);
    }

    private void openDialogNew(Deck deck) {
        FlashcardDialog dialog = new FlashcardDialog(deck, cardDAO);
        dialog.show(getSupportFragmentManager(), "flashcardDialog");
    }

    @Override
    public void startNewFlashcardSession(int quantity, int deckId) {
        Intent intent = new Intent(getApplicationContext(), FlashcardSessionActivity.class);
        intent.putExtra(KEY_NEW, quantity);
        intent.putExtra(KEY_ID, deckId);
        startActivity(intent);
    }
}