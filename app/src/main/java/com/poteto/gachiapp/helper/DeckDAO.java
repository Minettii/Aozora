package com.poteto.gachiapp.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.poteto.gachiapp.model.Deck;

import java.util.ArrayList;
import java.util.List;

public class DeckDAO {

    private SQLiteDatabase writer;
    private SQLiteDatabase reader;

    public DeckDAO(Context context) {
        DbHelper db = new DbHelper( context );
        writer = db.getWritableDatabase();
        reader = db.getReadableDatabase();
    }

    public boolean save(Deck deck) {

        ContentValues cv = new ContentValues();

        String nome = deck.getName();
        int custom = deck.getCustom();

        cv.put(DbHelper.DECK_NAME, nome );
        cv.put(DbHelper.DECK_CUSTOM, custom );

        try {
            writer.insert(DbHelper.TABLE_DECK, null, cv );
            Log.i("INFO", "Deck successfully saved!");
        }catch (Exception e){
            Log.e("INFO", "Error while trying to save deck " + e.getMessage() );
            return false;
        }
        return true;
    }

    public boolean update(Deck deck) {

        ContentValues cv = new ContentValues();

        long id = deck.getId();
        String nome = deck.getName();
        int custom = deck.getCustom();

        cv.put(DbHelper.DECK_NAME, nome );
        cv.put(DbHelper.DECK_CUSTOM, custom );
        try {
            String[] args = { String.valueOf(id)};
            writer.update(DbHelper.TABLE_DECK, cv, "id=?", args );
            Log.i("INFO", "Deck updated successfully!");
        }catch (Exception e){
            Log.e("INFO", "Erro while trying to update deck " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean delete(Deck deck) {

        long id = deck.getId();

        try {
            String[] args = { String.valueOf(id) };
            writer.delete(DbHelper.TABLE_DECK, "id=?", args );
            Log.i("INFO", "Deck deleted successfully!");
        }catch (Exception e){
            Log.e("INFO", "Erro while trying to remove deck " + e.getMessage() );
            return false;
        }

        return true;
    }

    public List<Deck> listDecks() {

        List<Deck> decks = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABLE_DECK + " ORDER BY "+DbHelper.DECK_NAME;
        Cursor c = reader.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Deck deck = new Deck();

            int id = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_ID) );
            String name = c.getString( c.getColumnIndexOrThrow(DbHelper.DECK_NAME) );
            int custom = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_CUSTOM) );

            deck.setId( id );
            deck.setName( name );
            deck.setCustom( custom );

            decks.add( deck );
            Log.i("deckDao", "id: "+deck.getId()+"; front: "+deck.getName() );
        }
        c.close();
        return decks;
    }

    public List<Deck> listDecksId() {

        List<Deck> decks = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABLE_DECK + " ORDER BY " + DbHelper.DECK_CUSTOM +
                ", " + DbHelper.DECK_NAME;
        Cursor c = reader.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Deck deck = new Deck();

            int id = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_ID) );
            String name = c.getString( c.getColumnIndexOrThrow(DbHelper.DECK_NAME) );
            int custom = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_CUSTOM) );

            deck.setId( id );
            deck.setName( name );
            deck.setCustom( custom );

            decks.add( deck );
            Log.i("deckDao", "id: "+deck.getId()+"; front: "+deck.getName() );
        }
        c.close();
        return decks;
    }

    public List<Deck> listDecksToAdd(long deckId) {
        List<Deck> decks = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABLE_DECK + " WHERE "+DbHelper.DECK_ID+" != "+deckId+
        " AND "+DbHelper.DECK_CUSTOM+ " = "+DbHelper.DEFAULT_CUSTOM_TRUE+ " ORDER BY "+DbHelper.DECK_NAME;
        Cursor c = reader.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Deck deck = new Deck();

            int id = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_ID) );
            String name = c.getString( c.getColumnIndexOrThrow(DbHelper.DECK_NAME) );
            int custom = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_CUSTOM) );

            deck.setId( id );
            deck.setName( name );
            deck.setCustom( custom );

            decks.add( deck );
            Log.i("deckDao", "id: "+deck.getId()+"; front: "+deck.getName() );
        }
        c.close();
        return decks;
    }

    public Deck getDeck(int deckId) {
        String sql = "SELECT * FROM " + DbHelper.TABLE_DECK + " WHERE "+DbHelper.DECK_ID+" = "+deckId;
        Cursor c = reader.rawQuery(sql, null);
        c.moveToNext();
        Deck deck = new Deck();
        int id = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_ID) );
        String name = c.getString( c.getColumnIndexOrThrow(DbHelper.DECK_NAME) );
        int custom = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_CUSTOM) );
        deck.setId( id );
        deck.setName( name );
        deck.setCustom( custom );
        return deck;
    }

    public String getDeckName(long deckId) {
        String sql = "SELECT "+DbHelper.DECK_NAME+" FROM " + DbHelper.TABLE_DECK + " WHERE "+DbHelper.DECK_ID+" = " + deckId;
        Cursor c = reader.rawQuery(sql, null);
        c.moveToNext();
        String res = c.getString(c.getColumnIndexOrThrow(DbHelper.DECK_NAME));
        c.close();
        return res;
    }

    public int getDeckSize(int deckId) {
        String sql = "SELECT COUNT(*) FROM " + DbHelper.TABLE_CARD + " WHERE " + DbHelper.CARD_DECK+" =?";
        String[] args = {String.valueOf(deckId)};
        Cursor c = reader.rawQuery(sql, args);
        c.moveToFirst();
        int size = c.getInt(c.getColumnIndexOrThrow("COUNT(*)"));
        c.close();
        return size;
    }

    public int getDeckLearnedSize(int deckId) {
        String sql = "SELECT COUNT(*) FROM " + DbHelper.TABLE_CARD + " WHERE " + DbHelper.CARD_DECK+" = "+deckId+" AND "+
                DbHelper.CARD_ACTIVE+" = "+DbHelper.ACTIVE_TRUE;
        Cursor c = reader.rawQuery(sql, null);
        c.moveToFirst();
        int size = c.getInt(c.getColumnIndexOrThrow("COUNT(*)"));
        c.close();
        return size;
    }

    public List<Deck> listCustomDecksAdd() {

        List<Deck> decks = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABLE_DECK + " WHERE "+DbHelper.DECK_CUSTOM+
                " = "+DbHelper.DEFAULT_CUSTOM_TRUE;
        Cursor c = reader.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Deck deck = new Deck();

            int id = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_ID) );
            String name = c.getString( c.getColumnIndexOrThrow(DbHelper.DECK_NAME) );
            int custom = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_CUSTOM) );

            deck.setId( id );
            deck.setName( name );
            deck.setCustom( custom );

            decks.add( deck );
            Log.i("deckDao", "id: "+deck.getId()+"; front: "+deck.getName() );
        }
        c.close();
        return decks;
    }

    public List<Deck> listCustomDecks() {

        List<Deck> decks = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABLE_DECK + " WHERE "+DbHelper.DECK_CUSTOM+
                " = "+DbHelper.DEFAULT_CUSTOM_TRUE;
        Cursor c = reader.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Deck deck = new Deck();

            int id = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_ID) );
            String name = c.getString( c.getColumnIndexOrThrow(DbHelper.DECK_NAME) );
            int custom = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_CUSTOM) );

            deck.setId( id );
            deck.setName( name );
            deck.setCustom( custom );

            int deckSize = getDeckSize(id);
            if (deckSize!=0) {
                decks.add( deck );
                Log.i("deckDao", "id: "+deck.getId()+"; front: "+deck.getName() );
            }
        }
        c.close();
        return decks;
    }

    public List<Deck> listDefaultDecks() {

        List<Deck> decks = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABLE_DECK + " WHERE "+DbHelper.DECK_CUSTOM+
                " = "+DbHelper.CUSTOM_FALSE;
        Cursor c = reader.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Deck deck = new Deck();

            int id = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_ID) );
            String name = c.getString( c.getColumnIndexOrThrow(DbHelper.DECK_NAME) );
            int custom = c.getInt( c.getColumnIndexOrThrow(DbHelper.DECK_CUSTOM) );

            deck.setId( id );
            deck.setName( name );
            deck.setCustom( custom );

            int deckSize = getDeckSize(id);
            if (deckSize!=0) {
                decks.add( deck );
                Log.i("deckDao", "id: "+deck.getId()+"; front: "+deck.getName() );
            }
        }
        c.close();
        return decks;
    }
}
