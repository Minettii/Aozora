package com.poteto.gachiapp.activity.flashcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.poteto.gachiapp.activity.card.CardDetailActivity;
import com.poteto.gachiapp.databinding.ActivityTreinoStatisticsBinding;
import com.poteto.gachiapp.helper.AdapterCard;
import com.poteto.gachiapp.helper.RecyclerItemClickListener;
import com.poteto.gachiapp.model.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreinoStatisticsActivity extends AppCompatActivity {

    ActivityTreinoStatisticsBinding binding;
    List<Card> listCorrectCards, listIncorrectCards;
    AdapterCard adapterCardCorrect, adapterCardIncorrect;

    TextView textTitleTreinoStat, textCorrectTreinoStat, textIncorrectTreinoStat;
    RecyclerView rvCorrectTreinoStat, rvIncorrectTreinoStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTreinoStatisticsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Treino");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);

        listCorrectCards = (List<Card>) getIntent().getSerializableExtra(TreinoSessionActivity.KEY_CORRECT_CARDS);
        listIncorrectCards = (List<Card>) getIntent().getSerializableExtra(TreinoSessionActivity.KEY_INCORRECT_CARDS);

        textTitleTreinoStat = binding.textTitleTreinoStat;
        textCorrectTreinoStat = binding.textCorrectTreinoStat;
        textIncorrectTreinoStat = binding.textIncorrectTreinoStat;
        //switched to show misses first
        rvCorrectTreinoStat = binding.rvIncorrectTreinoStat;
        rvIncorrectTreinoStat = binding.rvCorrectTreinoStat;

        adapterCardCorrect = new AdapterCard(listCorrectCards);
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

        adapterCardIncorrect = new AdapterCard(listIncorrectCards);
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

        textTitleTreinoStat.setText("Estatísticas da Sessão");
        textIncorrectTreinoStat.setText("Cartões Corretos: "+listCorrectCards.size());
        textCorrectTreinoStat.setText("Cartões Incorretos: "+listIncorrectCards.size());

        if (listIncorrectCards.size()==0){
            textCorrectTreinoStat.setVisibility(View.GONE);
            binding.dividerCorrect.setVisibility(View.GONE);
            binding.view2.setVisibility(View.GONE);
            binding.rvCorrectTreinoStat.setVisibility(View.GONE);
        } else if (listCorrectCards.size()==0) {
            textIncorrectTreinoStat.setVisibility(View.GONE);
            binding.dividerIncorrect.setVisibility(View.GONE);
            binding.dividerIncorrect2.setVisibility(View.GONE);
            binding.rvIncorrectTreinoStat.setVisibility(View.GONE);
        }


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}