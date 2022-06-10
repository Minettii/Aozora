package com.poteto.gachiapp.model;

import com.poteto.gachiapp.helper.DbHelper;

import java.io.Serializable;

public class Card implements Serializable {

    public Card() {
        setRepetitions(0);
    }

    public static String KEY_CARD = "card";


    //INT: Primary Key: Auto increment
    private int id;
    //TEXT: Non nullable
    private String front;
    //TEXT: Non nullable
    private String back;
    //TEXT:
    private String reading;
    //TEXT
    private String example;
    //TEXT
    private String exFurigana;
    //TEXT
    private String exTranslation;
    //REAL: Default 1
    private double score;
    //INT: Default -1
    private long next_date;
    //INT: Default -1
    private long last_date;
    //INT: Foreign Key: References card(id)
    private int deck;
    //INT: Default 0 (false)
    private int active;


    //Not present in Database, used during Flashcard session
    private int repetitions;


    public static String getKeyCard() {
        return KEY_CARD;
    }

    public static void setKeyCard(String keyCard) {
        KEY_CARD = keyCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExFurigana() {
        return exFurigana;
    }

    public void setExFurigana(String ex_furigana) {
        this.exFurigana = ex_furigana;
    }

    public String getExTranslation() {
        return exTranslation;
    }

    public void setExTranslation(String ex_translation) {
        this.exTranslation = ex_translation;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public long getNext_date() {
        return next_date;
    }

    public void setNext_date(long next_date) {
        this.next_date = next_date;
    }

    public long getLast_date() {
        return last_date;
    }

    public void setLast_date(long last_date) {
        this.last_date = last_date;
    }

    public int getDeck() {
        return deck;
    }

    public void setDeck(int deck) {
        this.deck = deck;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
}
