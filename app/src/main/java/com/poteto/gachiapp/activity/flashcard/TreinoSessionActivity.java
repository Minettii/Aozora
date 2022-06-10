package com.poteto.gachiapp.activity.flashcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.poteto.gachiapp.activity.main.TreinoActivity;
import com.poteto.gachiapp.databinding.ActivityTreinoSessionBinding;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.model.Card;
import com.poteto.gachiapp.model.Deck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreinoSessionActivity extends AppCompatActivity {

    public static int CORRECT_ANSWER = 1;
    public static int INCORRECT_ANSWER = 0;

    public static String KEY_CORRECT_CARDS = "sessionCorrectCards";
    public static String KEY_INCORRECT_CARDS = "sessionInorrectCards";

    ActivityTreinoSessionBinding binding;
    List<Card> listCardsSession;
    TextView textFront, cardNumber, textBackTraining, textExampleTraining,
            textExFuriganaTraining, textExTranslationTraining;
    Button incorrectButton, correctButton, checkAnswerButton;
    View viewDividerFrontBack;
    List<Integer> answers = new ArrayList<>();
    int actualCardNumber;
    Card actualCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTreinoSessionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Sessão de Treino");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listCardsSession = new ArrayList<>();
        listCardsSession = (List<Card>) getIntent().getSerializableExtra(TreinoActivity.KEY_CARDS_SESSION);
        answers = new ArrayList<>();
        actualCardNumber = 0;

        textFront = binding.textFrontReadingTraining;
        cardNumber = binding.textCardNumberTraining;

        textBackTraining = binding.textBackTraining;
        textExampleTraining = binding.textExampleTraining;
        textExFuriganaTraining = binding.textExFuriganaTraining;
        textExTranslationTraining = binding.textExTranslationTraining;

        checkAnswerButton = binding.buttonCheckTraining;
        incorrectButton = binding.buttonIncorrectTraining;
        correctButton = binding.buttonCorrectTraining;

        viewDividerFrontBack = binding.viewDividerFrontBack;



        showFront();

        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBack();
            }
        });

        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answers.add(CORRECT_ANSWER);
                if (actualCardNumber==listCardsSession.size()) {
                    finishSession();
                }else {
                    showFront();
                }
            }
        });

        incorrectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answers.add(INCORRECT_ANSWER);
                if (actualCardNumber==listCardsSession.size()) {
                    finishSession();
                }else {
                    showFront();
                }
            }
        });
    }

    private void showFront() {
        this.actualCard = this.listCardsSession.get(actualCardNumber);
        this.actualCardNumber++;
        textFront.setText(actualCard.getFront());
        cardNumber.setText("Cartão atual: "+actualCardNumber+"/"+listCardsSession.size());
        checkAnswerButton.setVisibility(View.VISIBLE);

        viewDividerFrontBack.setVisibility(View.INVISIBLE);
        textBackTraining.setVisibility(View.INVISIBLE);
        textExampleTraining.setVisibility(View.INVISIBLE);
        textExFuriganaTraining.setVisibility(View.INVISIBLE);
        textExTranslationTraining.setVisibility(View.INVISIBLE);

        incorrectButton.setVisibility(View.INVISIBLE);
        correctButton.setVisibility(View.INVISIBLE);
    }

    private void showBack() {
        String FrontReading = actualCard.getFront();
        if (actualCard.getReading()!=null && !actualCard.getReading().isEmpty()) {
            FrontReading += " 「"+actualCard.getReading()+"」";
        }
        textFront.setText(FrontReading);
        cardNumber.setText("Cartão atual: "+actualCardNumber+"/"+listCardsSession.size());
        checkAnswerButton.setVisibility(View.INVISIBLE);

        viewDividerFrontBack.setVisibility(View.VISIBLE);
        textBackTraining.setVisibility(View.VISIBLE);
        textBackTraining.setText(actualCard.getBack());

        if (actualCard.getExample()!=null && !actualCard.getExample().isEmpty()) {
            textExampleTraining.setVisibility(View.VISIBLE);
            textExampleTraining.setText("Ex.: "+actualCard.getExample());
        }
        if (actualCard.getExFurigana()!=null && !actualCard.getExFurigana().isEmpty()) {
            textExFuriganaTraining.setVisibility(View.VISIBLE);
            textExFuriganaTraining.setText(actualCard.getExFurigana());
        }
        if (actualCard.getExTranslation()!=null && !actualCard.getExTranslation().isEmpty()) {
            textExTranslationTraining.setVisibility(View.VISIBLE);
            textExTranslationTraining.setText(actualCard.getExTranslation());
        }

        incorrectButton.setVisibility(View.VISIBLE);
        correctButton.setVisibility(View.VISIBLE);
    }

    private void finishSession() {
        Intent intent = new Intent(getApplicationContext(), TreinoStatisticsActivity.class);
        List<Card> listCorrectCards = new ArrayList<>();
        List<Card> listIncorrectCards = new ArrayList<>();

        for (int i=0; i<listCardsSession.size(); i++) {
            Card card = listCardsSession.get(i);
            int cardAnswer = answers.get(i);
            if (cardAnswer==TreinoSessionActivity.CORRECT_ANSWER){
                listCorrectCards.add(card);
            }else if (cardAnswer==TreinoSessionActivity.INCORRECT_ANSWER){
                listIncorrectCards.add(card);
            }
        }

        intent.putExtra(KEY_CORRECT_CARDS, (Serializable) listCorrectCards);
        intent.putExtra(KEY_INCORRECT_CARDS, (Serializable) listIncorrectCards);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}