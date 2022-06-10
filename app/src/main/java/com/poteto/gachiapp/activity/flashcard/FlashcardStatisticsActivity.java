package com.poteto.gachiapp.activity.flashcard;

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
import android.widget.TextView;

import com.poteto.gachiapp.activity.card.CardDetailActivity;
import com.poteto.gachiapp.databinding.ActivityFlashcardStatisticsBinding;
import com.poteto.gachiapp.helper.AdapterCard;
import com.poteto.gachiapp.helper.AdapterFlashcard;
import com.poteto.gachiapp.helper.AdapterStatsFlashcard;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.helper.RecyclerItemClickListener;
import com.poteto.gachiapp.model.Card;

import java.util.ArrayList;
import java.util.List;

public class FlashcardStatisticsActivity extends AppCompatActivity {

    ActivityFlashcardStatisticsBinding binding;

    List<Card> listCorrectCards = new ArrayList<>();
    List<Card> listIncorrectCards = new ArrayList<>();
    List<Card> listNewCards = new ArrayList<>();
    AdapterStatsFlashcard adapterCardCorrect, adapterCardIncorrect, adapterNewFlashcard;

    TextView textTitleTreinoStat, textCorrectTreinoStat, textIncorrectTreinoStat;
    RecyclerView rvCorrectTreinoStat, rvIncorrectTreinoStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlashcardStatisticsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Flashcards");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);

        textTitleTreinoStat = binding.textTitleTreinoStat;
        textCorrectTreinoStat = binding.textCorrectTreinoStat;
        textIncorrectTreinoStat = binding.textIncorrectTreinoStat;
        //Switched to show misses first
        rvCorrectTreinoStat = binding.rvIncorrectTreinoStat;
        rvIncorrectTreinoStat = binding.rvCorrectTreinoStat;

        Bundle extras = getIntent().getExtras();

        textTitleTreinoStat.setText("Estatísticas da Sessão");

        CardDAO cardDAO = new CardDAO(this);
        Log.d("stats", String.valueOf(extras.containsKey(FlashcardSessionActivity.KEY_NEW_CARDS)));
        listCorrectCards = (List<Card>) getIntent().getSerializableExtra(FlashcardSessionActivity.KEY_CORRECT_CARDS);
        listIncorrectCards = (List<Card>) getIntent().getSerializableExtra(FlashcardSessionActivity.KEY_INCORRECT_CARDS);
        if (listCorrectCards!=null && listCorrectCards.size()!=0){
            Log.d("stats", "old");
            showOld();
        }
        else{
            Log.d("stats", "new");
            listNewCards = (List<Card>) getIntent().getSerializableExtra(FlashcardSessionActivity.KEY_NEW_CARDS);
            showNew();
        }
    }

    public void showNew() {
        adapterNewFlashcard = new AdapterStatsFlashcard(listNewCards);
        rvCorrectTreinoStat.setLayoutManager(new LinearLayoutManager(this));
        rvCorrectTreinoStat.setHasFixedSize(true);
        rvCorrectTreinoStat.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rvCorrectTreinoStat.setAdapter(adapterNewFlashcard);

        rvCorrectTreinoStat.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvCorrectTreinoStat,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Card card = listNewCards.get(position);
                                Intent intent = new Intent(getApplicationContext(), CardDetailActivity.class);
                                intent.putExtra(Card.KEY_CARD, card);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        })
        );

        textCorrectTreinoStat.setText("Cartões Novos: "+listNewCards.size());

        textIncorrectTreinoStat.setVisibility(View.GONE);
        binding.dividerIncorrect.setVisibility(View.GONE);
        binding.dividerIncorrect3.setVisibility(View.GONE);
    }

    public void showOld() {
        adapterCardCorrect = new AdapterStatsFlashcard(listCorrectCards);
        rvCorrectTreinoStat.setLayoutManager(new LinearLayoutManager(this));
        rvCorrectTreinoStat.setHasFixedSize(true);
        rvCorrectTreinoStat.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rvCorrectTreinoStat.setAdapter(adapterCardCorrect);

        rvCorrectTreinoStat.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvCorrectTreinoStat,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Card card = listCorrectCards.get(position);
                                Intent intent = new Intent(getApplicationContext(), CardDetailActivity.class);
                                intent.putExtra(Card.KEY_CARD, card);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        })
        );

        adapterCardIncorrect = new AdapterStatsFlashcard(listIncorrectCards);
        rvIncorrectTreinoStat.setLayoutManager(new LinearLayoutManager(this));
        rvIncorrectTreinoStat.setHasFixedSize(true);
        rvIncorrectTreinoStat.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rvIncorrectTreinoStat.setAdapter(adapterCardIncorrect);

        rvIncorrectTreinoStat.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvIncorrectTreinoStat,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Card card = listIncorrectCards.get(position);
                                Intent intent = new Intent(getApplicationContext(), CardDetailActivity.class);
                                intent.putExtra(Card.KEY_CARD, card);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        })
        );

        textIncorrectTreinoStat.setVisibility(View.VISIBLE);
        binding.dividerIncorrect.setVisibility(View.VISIBLE);
        binding.dividerIncorrect3.setVisibility(View.VISIBLE);

        textIncorrectTreinoStat.setText("Cartões Lembrados: "+listCorrectCards.size());
        textCorrectTreinoStat.setText("Cartões Esquecidos: "+listIncorrectCards.size());

        if (listIncorrectCards.size()==0){
            textCorrectTreinoStat.setVisibility(View.GONE);
            binding.dividerCorrect.setVisibility(View.GONE);
            binding.view2.setVisibility(View.GONE);
            binding.rvCorrectTreinoStat.setVisibility(View.GONE);
        } else if (listCorrectCards.size()==0) {
            textIncorrectTreinoStat.setVisibility(View.GONE);
            binding.dividerIncorrect.setVisibility(View.GONE);
            binding.dividerIncorrect3.setVisibility(View.GONE);
            binding.rvIncorrectTreinoStat.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}