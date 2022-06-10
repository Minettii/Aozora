package com.poteto.gachiapp.activity.flashcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.poteto.gachiapp.activity.main.FlashcardsActivity;
import com.poteto.gachiapp.databinding.ActivityFlashcardSessionBinding;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.helper.DbHelper;
import com.poteto.gachiapp.model.Card;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlashcardSessionActivity extends AppCompatActivity {

    ActivityFlashcardSessionBinding binding;

    public static int CORRECT_ANSWER = 1;
    public static int INCORRECT_ANSWER = 0;

    public static double SMALL_SCORE = 0.1;
    public static double BIG_SCORE = 0.2;
    public static double MINUS_SCORE = 0.1;
    public static double MINIMUM_SCORE = 1;
    public static double MAXIMUM_SCORE = 2;

    public static double CORRECT_FACTOR = 1.5;
    public static double EASY_FACTOR = 2.5;

    public static String KEY_CORRECT_CARDS = "sessionCorrectCards";
    public static String KEY_INCORRECT_CARDS = "sessionInorrectCards";
    public static String KEY_NEW_CARDS = "sessionInorrectCards";

    boolean newSession = false;

    List<Card> listCardsSession = new ArrayList<>();
    List<Card> listCorrectCards = new ArrayList<>();
    List<Card> listIncorrectCards = new ArrayList<>();
    List<Card> listRepetition = new ArrayList<>();
    List<Card> studiedCards = new ArrayList<>();

    boolean repetition = false;

    TextView textFront, cardNumber, textBack, textExample,
            textExFurigana, textExTranslation;
    Button incorrectButton, correctButton, checkAnswerButton, difficultButton, easyButton;
    View viewDividerFrontBack;

    Map<Integer, Integer> answers = new HashMap<Integer, Integer>();

    int actualCardNumber, remainingCards;
    int deckId;
    int newQuantity;
    Card actualCard;
    CardDAO cardDAO;

    LocalDate nextDate;
    LocalDateTime nextDateTime;
    long nextMillis;

    long reviewCorrect, reviewEasy;

    long differenceDaysLastReview;

    LocalDate todayDate = LocalDate.now();
    ZoneId zoneId = ZoneId.systemDefault();
    long todayMillis = todayDate.atStartOfDay(zoneId).toInstant().toEpochMilli();

    LocalDate nextLocalDate = Instant.ofEpochMilli(todayMillis).atZone(ZoneId.systemDefault()).toLocalDate();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String stringDate = nextLocalDate.format(formatter);

    LocalDate againDate = Instant.ofEpochMilli(todayMillis).atZone(ZoneId.systemDefault()).toLocalDateTime().toLocalDate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = todayDate.format(formatters);
        Log.d("Flash_date", "todayMillis: " + todayMillis);
        Log.d("Flash_date", "todayDate: " + todayDate);
        Log.d("Flash_date", "stringDate: " + stringDate);
        Log.d("Flash_date", "againDate: " + againDate);

        super.onCreate(savedInstanceState);
        binding = ActivityFlashcardSessionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Estudo com Flashcard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cardDAO = new CardDAO(getApplicationContext());

        binding.buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishButton();
            }
        });

        Bundle bundles = getIntent().getExtras();
        this.deckId = bundles.getInt(FlashcardsActivity.KEY_ID);
        if (bundles.containsKey(FlashcardsActivity.KEY_NEW)) {
            this.newQuantity = bundles.getInt(FlashcardsActivity.KEY_NEW);
            listCardsSession = cardDAO.listNewFlashcard(deckId, newQuantity);
            newSession = true;
        } else {
            listCardsSession = cardDAO.listReviewFlashcard(deckId);
        }

        for (Card flash : listCardsSession) {
            if (flash.getNext_date() == -1) {
                flash.setRepetitions(2);
            }
        }

        actualCardNumber = 0;
        remainingCards = listCardsSession.size();

        textFront = binding.textFrontReadingTraining;
        cardNumber = binding.textCardNumber;

        textBack = binding.textBackTraining;
        textExample = binding.textExampleTraining;
        textExFurigana = binding.textExFuriganaTraining;
        textExTranslation = binding.textExTranslationTraining;

        checkAnswerButton = binding.buttonCheckTraining;
        incorrectButton = binding.buttonIncorrect;
        difficultButton = binding.buttonDifficult;
        correctButton = binding.buttonCorrect;
        easyButton = binding.buttonEasy;

        viewDividerFrontBack = binding.viewDividerFrontBack;

        showFront();

        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBack();
            }
        });

        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answers.containsKey(actualCard.getId())) {
                    answers.put(actualCard.getId(), CORRECT_ANSWER);
                }

                if (actualCard.getRepetitions() == 2) {
                    nextDate = todayDate.plusDays(3);
                    nextDateTime = nextDate.atTime(0, 0);
                    nextMillis = nextDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    actualCard.setActive(1);
                    if (actualCard.getScore() + SMALL_SCORE <= MAXIMUM_SCORE) {
                        actualCard.setScore(actualCard.getScore() + SMALL_SCORE);
                    }
                    Log.d("flashcard", "card: " + actualCard.getFront() + "; today/next: " +
                            todayMillis + " / " + nextMillis);
                    actualCard.setNext_date(nextMillis);
                    actualCard.setLast_date(todayMillis);
                    actualCard.setActive(DbHelper.ACTIVE_TRUE);
                    cardDAO.update(actualCard);
                    studiedCards.add(actualCard);
                    remainingCards--;

                } else if (actualCard.getRepetitions() == 1) {
                    nextDate = todayDate.plusDays(3);
                    nextDateTime = nextDate.atTime(0, 0);
                    nextMillis = nextDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    if (actualCard.getScore() + SMALL_SCORE <= MAXIMUM_SCORE) {
                        actualCard.setScore(actualCard.getScore() + SMALL_SCORE);
                    }
                    actualCard.setNext_date(nextMillis);
                    actualCard.setLast_date(todayMillis);
                    actualCard.setActive(DbHelper.ACTIVE_TRUE);
                    cardDAO.update(actualCard);
                    studiedCards.add(actualCard);
                    remainingCards--;

                } else {
                    nextDate = todayDate.plusDays(reviewEasy);
                    nextDateTime = nextDate.atTime(0, 0);
                    nextMillis = nextDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    if (actualCard.getScore() + BIG_SCORE <= MAXIMUM_SCORE) {
                        actualCard.setScore(actualCard.getScore() + BIG_SCORE);
                    } else {
                        actualCard.setScore(MAXIMUM_SCORE);
                    }
                    actualCard.setNext_date(nextMillis);
                    actualCard.setLast_date(todayMillis);
                    actualCard.setActive(DbHelper.ACTIVE_TRUE);
                    cardDAO.update(actualCard);
                    studiedCards.add(actualCard);
                    remainingCards--;

                }

                if ((!repetition && (actualCardNumber == listCardsSession.size())) ||
                        (repetition && (actualCardNumber == listRepetition.size()))) {
                    finishSession();
                } else {
                    showFront();
                }
            }
        });

        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answers.containsKey(actualCard.getId())) {
                    answers.put(actualCard.getId(), CORRECT_ANSWER);
                }

                if (actualCard.getRepetitions() == 2) {
                    actualCard.setRepetitions(1);
                    if (!repetition) {
                        listRepetition.add(actualCard);
                    } else {
                        listCardsSession.add(actualCard);
                    }

                } else if (actualCard.getRepetitions() == 1) {
                    nextDate = todayDate.plusDays(1);
                    nextDateTime = nextDate.atTime(0, 0);
                    nextMillis = nextDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    if (actualCard.getScore() + SMALL_SCORE <= MAXIMUM_SCORE) {
                        actualCard.setScore(actualCard.getScore() + SMALL_SCORE);
                    }
                    actualCard.setNext_date(nextMillis);
                    actualCard.setLast_date(todayMillis);
                    actualCard.setActive(DbHelper.ACTIVE_TRUE);
                    cardDAO.update(actualCard);
                    studiedCards.add(actualCard);
                    remainingCards--;

                } else {
                    nextDate = todayDate.plusDays(reviewCorrect);
                    nextDateTime = nextDate.atTime(0, 0);
                    nextMillis = nextDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    if (actualCard.getScore() + SMALL_SCORE <= MAXIMUM_SCORE) {
                        actualCard.setScore(actualCard.getScore() + SMALL_SCORE);
                    }
                    actualCard.setNext_date(nextMillis);
                    actualCard.setLast_date(todayMillis);
                    actualCard.setActive(DbHelper.ACTIVE_TRUE);
                    cardDAO.update(actualCard);
                    studiedCards.add(actualCard);
                    remainingCards--;

                }

                if ((!repetition && (actualCardNumber == listCardsSession.size())) ||
                        (repetition && (actualCardNumber == listRepetition.size()))) {
                    finishSession();
                } else {
                    showFront();
                }
            }
        });

        difficultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answers.containsKey(actualCard.getId())) {
                    answers.put(actualCard.getId(), CORRECT_ANSWER);
                }

                nextDate = todayDate.plusDays(differenceDaysLastReview);
                nextDateTime = nextDate.atTime(0, 0);
                nextMillis = nextDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                if (actualCard.getScore() - MINUS_SCORE >= MINIMUM_SCORE) {
                    actualCard.setScore((actualCard.getScore() - MINUS_SCORE));
                }
                actualCard.setNext_date(nextMillis);
                actualCard.setLast_date(todayMillis);
                actualCard.setActive(DbHelper.ACTIVE_TRUE);
                cardDAO.update(actualCard);
                studiedCards.add(actualCard);
                remainingCards--;

                if ((!repetition && (actualCardNumber == listCardsSession.size())) ||
                        (repetition && (actualCardNumber == listRepetition.size()))) {
                    finishSession();
                } else {
                    showFront();
                }
            }
        });

        incorrectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answers.containsKey(actualCard.getId())) {
                    answers.put(actualCard.getId(), INCORRECT_ANSWER);
                }

                if (actualCard.getRepetitions() == 2) {
                    if (!repetition) {
                        listRepetition.add(actualCard);
                    } else {
                        listCardsSession.add(actualCard);
                    }

                } else if (actualCard.getRepetitions() == 1) {
                    if (!repetition) {
                        listRepetition.add(actualCard);
                    } else {
                        listCardsSession.add(actualCard);
                    }

                } else {
                    actualCard.setRepetitions(1);
                    if (!repetition) {
                        listRepetition.add(actualCard);
                    } else {
                        listCardsSession.add(actualCard);
                    }

                }

                if ((!repetition && (actualCardNumber == listCardsSession.size())) ||
                        (repetition && (actualCardNumber == listRepetition.size()))) {
                    finishSession();
                } else {
                    showFront();
                }
            }
        });
    }

    private void showFront() {
        if (!repetition) {
            this.actualCard = this.listCardsSession.get(actualCardNumber);
        } else {
            this.actualCard = this.listRepetition.get(actualCardNumber);
        }
        this.actualCardNumber++;
        textFront.setText(actualCard.getFront());
        cardNumber.setText("Cartões restantes : " + remainingCards);
        checkAnswerButton.setVisibility(View.VISIBLE);

        viewDividerFrontBack.setVisibility(View.INVISIBLE);
        textBack.setVisibility(View.INVISIBLE);
        textExample.setVisibility(View.INVISIBLE);
        textExFurigana.setVisibility(View.INVISIBLE);
        textExTranslation.setVisibility(View.INVISIBLE);

        incorrectButton.setVisibility(View.GONE);
        difficultButton.setVisibility(View.GONE);
        correctButton.setVisibility(View.GONE);
        easyButton.setVisibility(View.GONE);
    }

    private void showBack() {
        String FrontReading = actualCard.getFront();

        if (actualCard.getReading() != null && !actualCard.getReading().isEmpty()) {
            FrontReading += " 「" + actualCard.getReading() + "」";
        }
        textFront.setText(FrontReading);
        cardNumber.setText("Cartões restantes : " + remainingCards);
        checkAnswerButton.setVisibility(View.INVISIBLE);

        viewDividerFrontBack.setVisibility(View.VISIBLE);
        textBack.setVisibility(View.VISIBLE);
        textBack.setText(actualCard.getBack());

        if (actualCard.getExample() != null && !actualCard.getExample().isEmpty()) {
            textExample.setVisibility(View.VISIBLE);
            textExample.setText("Ex.: " + actualCard.getExample());
        }
        if (actualCard.getExFurigana() != null && !actualCard.getExFurigana().isEmpty()) {
            textExFurigana.setVisibility(View.VISIBLE);
            textExFurigana.setText(actualCard.getExFurigana());
        }
        if (actualCard.getExTranslation() != null && !actualCard.getExTranslation().isEmpty()) {
            textExTranslation.setVisibility(View.VISIBLE);
            textExTranslation.setText(actualCard.getExTranslation());
        }


        incorrectButton.setVisibility(View.VISIBLE);
        correctButton.setVisibility(View.VISIBLE);
        easyButton.setVisibility(View.VISIBLE);

        if (actualCard.getRepetitions() == 2) {
            difficultButton.setVisibility(View.GONE);
            incorrectButton.setText("DIFÍCIL\n+2 Repetições");
            correctButton.setText("CORRETA\n+1 Repetição");
            easyButton.setText("FÁCIL\n3 Dias");
        } else if (actualCard.getRepetitions() == 1) {
            difficultButton.setVisibility(View.GONE);
            incorrectButton.setText("INCORRETA\n+1 Repetição");
            correctButton.setText("CORRETA\n1 Dia");
            easyButton.setText("FÁCIL\n3 Dias");
        } else {
            difficultButton.setVisibility(View.VISIBLE);

            LocalDate lastReviewDate = Instant.ofEpochMilli(actualCard.getLast_date()).atZone(ZoneId.systemDefault()).toLocalDateTime().toLocalDate();
            differenceDaysLastReview = -todayDate.until(lastReviewDate, ChronoUnit.DAYS);

            reviewCorrect = Math.round(differenceDaysLastReview * actualCard.getScore() * CORRECT_FACTOR);
            reviewEasy = Math.round(differenceDaysLastReview * actualCard.getScore() * EASY_FACTOR);

            incorrectButton.setText("INCORRETA\n+1 Repetição");

            correctButton.setText("CORRETA\n" + reviewCorrect + " Dias");

            easyButton.setText("FÁCIL\n" + reviewEasy + " Dias");

            difficultButton.setText("DIFÍCIL\n" + differenceDaysLastReview + " Dias");
        }


    }

    private void finishButton() {
        if (studiedCards.size() == 0) {
            Toast.makeText(getApplicationContext(), "Não foi concluído o estudo de nenhum cartão durante a sessão de estudo com flashcard"
                    , Toast.LENGTH_LONG).show();
            finish();
        } else {
            Intent intent = new Intent(getApplicationContext(), FlashcardStatisticsActivity.class);
            if (newSession) {
                intent.putExtra(KEY_NEW_CARDS, (Serializable) studiedCards);
                Log.d("flashcard", "new");
                startActivity(intent);
                finish();
            } else if (!newSession){
                for (int i = 0; i < studiedCards.size(); i++) {
                    Card card = studiedCards.get(i);
                    int cardAnswer = answers.get(card.getId());
                    if (cardAnswer == FlashcardSessionActivity.CORRECT_ANSWER) {
                        listCorrectCards.add(card);
                    } else if (cardAnswer == FlashcardSessionActivity.INCORRECT_ANSWER) {
                        listIncorrectCards.add(card);
                    }
                }
                intent.putExtra(KEY_CORRECT_CARDS, (Serializable) listCorrectCards);
                intent.putExtra(KEY_INCORRECT_CARDS, (Serializable) listIncorrectCards);
                Log.d("flashcard", "old");
                startActivity(intent);
                finish();
            }
        }
    }

    private void finishSession() {
        if (!repetition && listRepetition.size() != 0) {
            actualCardNumber = 0;
            listCardsSession.clear();
            Collections.shuffle(listRepetition);
            repetition = true;
            showFront();
        } else if (repetition && listCardsSession.size() != 0) {
            actualCardNumber = 0;
            listRepetition.clear();
            Collections.shuffle(listCardsSession);
            repetition = false;
            showFront();
        } else {

            Intent intent = new Intent(getApplicationContext(), FlashcardStatisticsActivity.class);

            Log.d("flashcard", String.valueOf(newSession));

            if (newSession) {
                intent.putExtra(KEY_NEW_CARDS, (Serializable) studiedCards);
                Log.d("flashcard", "new");
                startActivity(intent);
                finish();
            } else if (!newSession){
                for (int i = 0; i < studiedCards.size(); i++) {
                    Card card = studiedCards.get(i);
                    int cardAnswer = answers.get(card.getId());
                    if (cardAnswer == FlashcardSessionActivity.CORRECT_ANSWER) {
                        listCorrectCards.add(card);
                    } else if (cardAnswer == FlashcardSessionActivity.INCORRECT_ANSWER) {
                        listIncorrectCards.add(card);
                    }
                }
                intent.putExtra(KEY_CORRECT_CARDS, (Serializable) listCorrectCards);
                intent.putExtra(KEY_INCORRECT_CARDS, (Serializable) listIncorrectCards);
                Log.d("flashcard", "old");
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}