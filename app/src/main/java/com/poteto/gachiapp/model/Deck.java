package com.poteto.gachiapp.model;

import com.poteto.gachiapp.helper.DbHelper;

import java.io.Serializable;

public class Deck implements Serializable {

    public Deck() {
        setCustom(DbHelper.DEFAULT_CUSTOM_TRUE);
    }

    public static String KEY_DECK = "deck";


    //INT: Primary Key: Auto increment
    private int id;
    //TEXT: Non nullable, Unique
    private String name;
    //INT: Default 1 (true)
    private int custom;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public int getCustom() {
        return custom;
    }

    public void setCustom(int custom) {
        this.custom = custom;
    }
}
