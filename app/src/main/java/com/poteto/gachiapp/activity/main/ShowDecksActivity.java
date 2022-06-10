package com.poteto.gachiapp.activity.main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.poteto.gachiapp.activity.card.ShowCardsActivity;
import com.poteto.gachiapp.databinding.ActivityShowCardsBinding;
import com.poteto.gachiapp.databinding.ActivityShowDecksBinding;
import com.poteto.gachiapp.helper.AdapterDeck;
import com.poteto.gachiapp.helper.DbHelper;
import com.poteto.gachiapp.helper.DeckDAO;
import com.poteto.gachiapp.helper.DeckDialog;
import com.poteto.gachiapp.helper.RecyclerItemClickListener;
import com.poteto.gachiapp.model.Deck;
import com.tsuryo.swipeablerv.SwipeLeftRightCallback;
import com.tsuryo.swipeablerv.SwipeableRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShowDecksActivity extends AppCompatActivity implements DeckDialog.DeckDialogListener {

    ActivityShowCardsBinding binding;
    SwipeableRecyclerView rv;
    List<Deck> listDecks = new ArrayList<>();
    DeckDAO deckDAO;
    AdapterDeck adapterDeck;
    Activity context = this;

    @Override
    protected void onStart() {
        super.onStart();
        listDecks();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowCardsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Decks");

        deckDAO = new DeckDAO(this);
        listDecks = deckDAO.listDecksId();
        rv = binding.rvCard;

        rv.setListener(new SwipeLeftRightCallback.Listener() {
            @Override
            public void onSwipedLeft(int position) {
                Deck deck = listDecks.get(position);
                if (deck.getCustom()== DbHelper.CUSTOM_FALSE) {
                    Toast.makeText(getApplicationContext(), "Decks originais não podem ser excluídos", Toast.LENGTH_LONG).show();
                    listDecks();
                    return;
                }
                AlertDialog.Builder dialogDelete = new AlertDialog.Builder(context);
                dialogDelete.setTitle("Excluir Deck");
                dialogDelete.setMessage("Você tem certeza que deseja excluir o deck: '"+deck.getName()+"'?");
                dialogDelete.setNegativeButton("Cancelar", null);
                dialogDelete.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deckDAO.delete(deck);
                        listDecks.remove(position);
                        listDecks();
                        Toast.makeText(getApplicationContext(), "Deck: '"+deck.getName()+"' excluído com sucesso.", Toast.LENGTH_LONG).show();
                    }
                }).show();
                listDecks();
            }

            @Override
            public void onSwipedRight(int position) {
                Deck deck = listDecks.get(position);
                if (deck.getCustom()== DbHelper.CUSTOM_FALSE) {
                    Toast.makeText(getApplicationContext(), "Decks originais não podem ser editados", Toast.LENGTH_LONG).show();
                    listDecks();
                    return;
                }
                editDialog(deck, position);
                listDecks();
            }
        });

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rv,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Deck deck = listDecks.get(position);
                                Intent intent = new Intent(getApplicationContext(), ShowCardsActivity.class);
                                intent.putExtra(Deck.KEY_DECK, deck);
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

        binding.fabCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog();
            }
        });
    }

    public void editDialog(Deck deck, int position) {
        DeckDialog dialog = new DeckDialog(deck, position);
        dialog.show(getSupportFragmentManager(), "editDialog");
    }

    public void createDialog(){
        DeckDialog dialog = new DeckDialog();
        dialog.show(getSupportFragmentManager(), "createDialog");
    }

    @Override
    public void createDeck(Deck deck) {
        deckDAO.save(deck);
        listDecks.add(deck);
        listDecks();
        Toast.makeText(this, "Deck: '"+deck.getName()+"' criado com sucesso.", Toast.LENGTH_LONG).show();
        recreate();
    }

    @Override
    public void editDeckName(Deck deck, int position) {
        deckDAO.update(deck);
        listDecks.set(position, deck);
        listDecks();
        Toast.makeText(this, "Deck: '"+deck.getName()+"' editado com sucesso.", Toast.LENGTH_LONG).show();
    }

    public void listDecks() {
        adapterDeck = new AdapterDeck(listDecks);
        rv = binding.rvCard;
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rv.setAdapter(adapterDeck);
    }
}