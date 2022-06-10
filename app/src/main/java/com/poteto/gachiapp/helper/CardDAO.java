package com.poteto.gachiapp.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.poteto.gachiapp.model.Card;
import com.poteto.gachiapp.model.Deck;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class CardDAO {

    private SQLiteDatabase writer;
    private SQLiteDatabase reader;

    public CardDAO(Context context) {
        DbHelper db = new DbHelper(context);
        writer = db.getWritableDatabase();
        reader = db.getReadableDatabase();
    }

    public boolean save(Card card) {
        ContentValues cv = new ContentValues();
        String front = card.getFront();
        String back = card.getBack();
        String reading = card.getReading();
        String example = card.getExample();
        String exFurigana = card.getExFurigana();
        String exTranslation = card.getExTranslation();
        int deck = card.getDeck();

        cv.put(DbHelper.CARD_FRONT, front);
        cv.put(DbHelper.CARD_BACK, back);
        cv.put(DbHelper.CARD_READING, reading);
        cv.put(DbHelper.CARD_EXAMPLE, example);
        cv.put(DbHelper.CARD_EX_FURIGANA, exFurigana);
        cv.put(DbHelper.CARD_EX_TRANSLATION, exTranslation);
        cv.put(DbHelper.CARD_SCORE, 1);
        cv.put(DbHelper.CARD_NEXT_DATE, -1);
        cv.put(DbHelper.CARD_LAST_DATE, -1);
        cv.put(DbHelper.CARD_DECK, deck);
        cv.put(DbHelper.CARD_ACTIVE, 0);

        try {
            writer.insert(DbHelper.TABLE_CARD, null, cv);
            Log.i("INFO", "Card successfully saved!");
        } catch (Exception e) {
            Log.e("INFO", "Error while trying to save card " + e.getMessage());
            return false;
        }
        return true;
    }


    public boolean update(Card card) {

        ContentValues cv = new ContentValues();

        int id = card.getId();
        String front = card.getFront();
        String back = card.getBack();
        String reading = card.getReading();
        String example = card.getExample();
        String exFurigana = card.getExFurigana();
        String exTranslation = card.getExTranslation();
        double score = card.getScore();
        long next_date = card.getNext_date();
        long last_date = card.getLast_date();
        int active = card.getActive();

        cv.put(DbHelper.CARD_FRONT, front);
        cv.put(DbHelper.CARD_BACK, back);
        cv.put(DbHelper.CARD_READING, reading);
        cv.put(DbHelper.CARD_EXAMPLE, example);
        cv.put(DbHelper.CARD_EX_FURIGANA, exFurigana);
        cv.put(DbHelper.CARD_EX_TRANSLATION, exTranslation);
        cv.put(DbHelper.CARD_SCORE, score);
        cv.put(DbHelper.CARD_NEXT_DATE, next_date);
        cv.put(DbHelper.CARD_LAST_DATE, last_date);
        cv.put(DbHelper.CARD_ACTIVE, active);

        try {
            String[] args = {String.valueOf(id)};
            writer.update(DbHelper.TABLE_CARD, cv, "id=?", args);
            Log.i("INFO", "Card updated successfully!");
        } catch (Exception e) {
            Log.e("INFO", "Erro while trying to update card " + e.getMessage());
            return false;
        }

        return true;
    }


    public boolean delete(Card card) {

        int id = card.getId();

        try {
            String[] args = {String.valueOf(id)};
            writer.delete(DbHelper.TABLE_CARD, "id=?", args);
            Log.i("INFO", "Card deleted successfully!");
        } catch (Exception e) {
            Log.e("INFO", "Erro while trying to remove card " + e.getMessage());
            return false;
        }
        return true;
    }


    public int getDeckLearnedSize(int deckId) {
        String sql = "SELECT COUNT(*) FROM " + DbHelper.TABLE_CARD + " WHERE " + DbHelper.CARD_DECK + " = " + deckId + " AND " +
                DbHelper.CARD_ACTIVE + " = " + DbHelper.ACTIVE_TRUE;
        Cursor c = reader.rawQuery(sql, null);
        c.moveToFirst();
        int size = c.getInt(c.getColumnIndexOrThrow("COUNT(*)"));
        c.close();
        return size;
    }


    public List<Card> listCards(int deckId) {

        List<Card> cards = new ArrayList<>();

        String selection = DbHelper.CARD_DECK + "=?";
        String[] selectionArgs = {String.valueOf(deckId)};

        Cursor c = reader.query(DbHelper.TABLE_CARD, null, selection, selectionArgs, null, null, null);

        while (c.moveToNext()) {

            Card card = new Card();

            int id = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_ID));
            String front = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_FRONT));
            String back = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_BACK));
            String reading = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_READING));
            String example = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EXAMPLE));
            String exFurigana = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EX_FURIGANA));
            String exTranslation = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EX_TRANSLATION));
            double score = c.getDouble(c.getColumnIndexOrThrow(DbHelper.CARD_SCORE));
            long next_date = c.getLong(c.getColumnIndexOrThrow(DbHelper.CARD_NEXT_DATE));
            long last_date = c.getLong(c.getColumnIndexOrThrow(DbHelper.CARD_LAST_DATE));
            int deck = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_DECK));
            int active = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_ACTIVE));

            card.setId(id);
            card.setFront(front);
            card.setBack(back);
            card.setReading(reading);
            card.setExample(example);
            card.setExFurigana(exFurigana);
            card.setExTranslation(exTranslation);
            card.setScore(score);
            card.setNext_date(next_date);
            card.setLast_date(last_date);
            card.setDeck(deck);
            card.setActive(active);

            cards.add(card);
            Log.i("cardDao", "id: " + card.getId() + "; front: " + card.getFront());
        }
        c.close();
        return cards;
    }

    public List<Card> listNewFlashcard(int deckId, int quantity) {
        List<Card> cards = new ArrayList<>();

        String selection = "SELECT * FROM " + DbHelper.TABLE_CARD + " WHERE " + DbHelper.CARD_DECK +
                " = " + deckId + " AND " + DbHelper.CARD_ACTIVE + " = " + DbHelper.DEFAULT_ACTIVE_FALSE + " LIMIT " + quantity;

        Cursor c = reader.rawQuery(selection, null);

        while (c.moveToNext()) {

            Card card = new Card();

            int id = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_ID));
            String front = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_FRONT));
            String back = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_BACK));
            String reading = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_READING));
            String example = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EXAMPLE));
            String exFurigana = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EX_FURIGANA));
            String exTranslation = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EX_TRANSLATION));
            double score = c.getDouble(c.getColumnIndexOrThrow(DbHelper.CARD_SCORE));
            long next_date = c.getLong(c.getColumnIndexOrThrow(DbHelper.CARD_NEXT_DATE));
            long last_date = c.getLong(c.getColumnIndexOrThrow(DbHelper.CARD_LAST_DATE));
            int deck = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_DECK));
            int active = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_ACTIVE));

            card.setId(id);
            card.setFront(front);
            card.setBack(back);
            card.setReading(reading);
            card.setExample(example);
            card.setExFurigana(exFurigana);
            card.setExTranslation(exTranslation);
            card.setScore(score);
            card.setNext_date(next_date);
            card.setLast_date(last_date);
            card.setDeck(deck);
            card.setActive(active);

            cards.add(card);
            Log.i("cardDao", "id: " + card.getId() + "; front: " + card.getFront());
        }
        c.close();
        return cards;
    }

    public Deck getDeck(int deckId) {
        String sql = "SELECT * FROM " + DbHelper.TABLE_DECK + " WHERE " + DbHelper.DECK_ID + " = " + deckId;
        Cursor c = reader.rawQuery(sql, null);
        c.moveToNext();
        Deck deck = new Deck();
        int id = c.getInt(c.getColumnIndexOrThrow(DbHelper.DECK_ID));
        String name = c.getString(c.getColumnIndexOrThrow(DbHelper.DECK_NAME));
        int custom = c.getInt(c.getColumnIndexOrThrow(DbHelper.DECK_CUSTOM));
        deck.setId(id);
        deck.setName(name);
        deck.setCustom(custom);
        c.close();
        return deck;
    }

    public List<Card> listReviewFlashcard(int deckId) {
        List<Card> cards = new ArrayList<>();
        LocalDate todayDate = LocalDate.now();
        long todayMillis = todayDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        List<Card> deckCards = this.listCards(deckId);
        for (int i = 0; i < deckCards.size(); i++) {
            Card actualCard = deckCards.get(i);
            long nextDateMillis = actualCard.getNext_date();
            int active = actualCard.getActive();
            if ((nextDateMillis != -1) &&
                    (nextDateMillis <= todayMillis) &&
                    (active == DbHelper.ACTIVE_TRUE)) {
                cards.add(actualCard);
                Log.i("review", "front: " + actualCard.getFront() + " now / next: " +
                        todayMillis + " / " + nextDateMillis);
            }
        }
        return cards;
    }

    public List<Card> listAllCards() {
        List<Card> cards = new ArrayList<>();

        Cursor c = reader.rawQuery("SELECT * FROM " + DbHelper.TABLE_CARD + " ORDER BY " + DbHelper.CARD_FRONT, null);

        while (c.moveToNext()) {

            Card card = new Card();

            int id = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_ID));
            String front = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_FRONT));
            String back = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_BACK));
            String reading = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_READING));
            String example = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EXAMPLE));
            String exFurigana = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EX_FURIGANA));
            String exTranslation = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EX_TRANSLATION));
            double score = c.getDouble(c.getColumnIndexOrThrow(DbHelper.CARD_SCORE));
            long next_date = c.getLong(c.getColumnIndexOrThrow(DbHelper.CARD_NEXT_DATE));
            long last_date = c.getLong(c.getColumnIndexOrThrow(DbHelper.CARD_LAST_DATE));
            int deck = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_DECK));
            int active = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_ACTIVE));

            card.setId(id);
            card.setFront(front);
            card.setBack(back);
            card.setReading(reading);
            card.setExample(example);
            card.setExFurigana(exFurigana);
            card.setExTranslation(exTranslation);
            card.setScore(score);
            card.setNext_date(next_date);
            card.setLast_date(last_date);
            card.setDeck(deck);
            card.setActive(active);

            cards.add(card);
            Log.i("cardDao", "id: " + card.getId() + "; front: " + card.getFront());
        }
        c.close();
        return cards;
    }

    public int getDeckSize(int deckId) {
        String sql = "SELECT COUNT(*) FROM " + DbHelper.TABLE_CARD + " WHERE " + DbHelper.CARD_DECK + " =?";
        String[] args = {String.valueOf(deckId)};
        Cursor c = reader.rawQuery(sql, args);
        c.moveToFirst();
        int size = c.getInt(c.getColumnIndexOrThrow("COUNT(*)"));
        c.close();
        return size;
    }

    public String getDeckName(int deck) {
        String sql = "SELECT deck." + DbHelper.DECK_NAME + " FROM " + DbHelper.TABLE_CARD +
                " AS card, " + DbHelper.TABLE_DECK + " AS deck WHERE card." + DbHelper.CARD_DECK + " = " +
                "deck." + DbHelper.DECK_ID + " AND card." + DbHelper.CARD_DECK + " = ?";
        String[] args = {String.valueOf(deck)};
        Cursor c = reader.rawQuery(sql, args);
        c.moveToFirst();
        String res = c.getString(c.getColumnIndexOrThrow(DbHelper.DECK_NAME));
        c.close();
        return res;
    }

    public int getQuantityTomorrowFlashcards() {
        int quantity = 0;
        LocalDate todayDate = LocalDate.now();
        long tomorrowMillis = todayDate.plusDays(1).atTime(0, 0).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        List<Card> deckCards = listAllCards();
        for (int i = 0; i < deckCards.size(); i++) {
            Card actualCard = deckCards.get(i);
            long nextDateMillis = actualCard.getNext_date();
            if (nextDateMillis == tomorrowMillis) {
                quantity++;
            }
        }

        return quantity;
    }

    public int getQuantityTodayFlashcards() {
        int quantity = 0;
        LocalDate todayDate = LocalDate.now();
        long todayMillis = todayDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        List<Card> deckCards = listAllCards();
        for (int i = 0; i < deckCards.size(); i++) {
            Card actualCard = deckCards.get(i);
            long nextDateMillis = actualCard.getNext_date();
            int active = actualCard.getActive();
            if ((nextDateMillis != -1) &&
                    (nextDateMillis <= todayMillis) &&
                    (active == DbHelper.ACTIVE_TRUE)) {
                quantity++;
            }
        }
        return quantity;
    }

    ////
    public int getQuantityTodayFlashcards(int deckIdm) {
        int quantity = 0;
        LocalDate todayDate = LocalDate.now();
        long todayMillis = todayDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        List<Card> deckCards = listCards(deckIdm);
        Log.d("qtts", "deckSize: " + deckCards.size());
        for (int i = 0; i < deckCards.size(); i++) {
            Card actualCard = deckCards.get(i);
            long nextDateMillis = actualCard.getNext_date();
            if (nextDateMillis != -1 && nextDateMillis <= todayMillis) {
                Log.d("qtts", "card: " + actualCard.getFront());
                Log.d("qtts", "card: " + actualCard.getNext_date());
                Log.d("qtts", "todayMillis: " + todayMillis);
                Log.d("qtts", "nextDateMillis: " + nextDateMillis);
                quantity++;
            }
        }
        return quantity;
    }

    public List<Card> listLearnedCards(int deckId) {

        List<Card> cards = new ArrayList<>();

        Cursor c = reader.rawQuery("SELECT * FROM " + DbHelper.TABLE_CARD +
                " WHERE " + DbHelper.CARD_DECK + " = " + deckId + " AND " +
                DbHelper.CARD_ACTIVE + " = " + DbHelper.ACTIVE_TRUE, null);

        while (c.moveToNext()) {

            Card card = new Card();

            int id = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_ID));
            String front = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_FRONT));
            String back = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_BACK));
            String reading = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_READING));
            String example = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EXAMPLE));
            String exFurigana = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EX_FURIGANA));
            String exTranslation = c.getString(c.getColumnIndexOrThrow(DbHelper.CARD_EX_TRANSLATION));
            double score = c.getDouble(c.getColumnIndexOrThrow(DbHelper.CARD_SCORE));
            long next_date = c.getLong(c.getColumnIndexOrThrow(DbHelper.CARD_NEXT_DATE));
            long last_date = c.getLong(c.getColumnIndexOrThrow(DbHelper.CARD_LAST_DATE));
            int deck = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_DECK));
            int active = c.getInt(c.getColumnIndexOrThrow(DbHelper.CARD_ACTIVE));

            card.setId(id);
            card.setFront(front);
            card.setBack(back);
            card.setReading(reading);
            card.setExample(example);
            card.setExFurigana(exFurigana);
            card.setExTranslation(exTranslation);
            card.setScore(score);
            card.setNext_date(next_date);
            card.setLast_date(last_date);
            card.setDeck(deck);
            card.setActive(active);

            cards.add(card);
            Log.i("cardDao", "id: " + card.getId() + "; front: " + card.getFront());
        }
        c.close();
        return cards;
    }
}