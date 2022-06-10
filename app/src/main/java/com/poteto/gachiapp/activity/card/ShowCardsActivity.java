package com.poteto.gachiapp.activity.card;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.poteto.gachiapp.activity.card.CardCreateEditActivity;
import com.poteto.gachiapp.activity.card.CardDetailActivity;
import com.poteto.gachiapp.databinding.ActivityShowCardsBinding;
import com.poteto.gachiapp.helper.AdapterCard;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.helper.DbHelper;
import com.poteto.gachiapp.helper.RecyclerItemClickListener;
import com.poteto.gachiapp.model.Card;
import com.poteto.gachiapp.model.Deck;
import com.tsuryo.swipeablerv.SwipeLeftRightCallback;
import com.tsuryo.swipeablerv.SwipeableRecyclerView;

import java.util.List;

public class ShowCardsActivity extends AppCompatActivity {

    ActivityShowCardsBinding binding;
    SwipeableRecyclerView rv;
    List<Card> listCards;
    CardDAO cardDAO;
    AdapterCard adapterCard;
    Deck deck;
    int deckId;
    Context context = this;

    @Override
    protected void onStart() {
        loadCardsList();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowCardsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rv = binding.rvCard;
        deck = (Deck) getIntent().getSerializableExtra(Deck.KEY_DECK);
        deckId = deck.getId();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Cartões do deck: '"+deck.getName()+"'");

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rv,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Card card = listCards.get(position);
                                Log.e("showCard", "card.getId: "+card.getId());
                                Log.e("showCard", "card.getDeck: "+card.getDeck());
                                Log.e("showCard", "cdeck.getId(): "+deck.getId());
                                Deck deck = cardDAO.getDeck(card.getDeck());

                                Log.e("showCard", "deckname: "+deck.getName());
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

        if (deck.getCustom()== DbHelper.CUSTOM_FALSE) {
            binding.fabCard.setVisibility(View.GONE);
        }

        rv.setListener(new SwipeLeftRightCallback.Listener() {
            @Override
            public void onSwipedLeft(int position) {
                Card card = listCards.get(position);
                if (deck.getCustom()== DbHelper.CUSTOM_FALSE) {
                    Toast.makeText(getApplicationContext(), "O conteúdo de um deck original não pode ser excluído", Toast.LENGTH_LONG).show();
                    adapterCard.notifyItemChanged(position);
                    return;
                }
                AlertDialog.Builder dialogDelete = new AlertDialog.Builder(context);
                dialogDelete.setTitle("Excluir Cartão");
                dialogDelete.setMessage("Você tem certeza que deseja excluir o cartão: '"+card.getFront()+"'?");
                dialogDelete.setNegativeButton("Cancelar", null);
                dialogDelete.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cardDAO.delete(card);
                        onStart();
                        Toast.makeText(getApplicationContext(), "Cartão: '"+card.getFront()+"' excluído com sucesso.", Toast.LENGTH_LONG).show();
                    }
                });
                dialogDelete.show();
                loadCardsList();
            }

            @Override
            public void onSwipedRight(int position) {
                Card card = listCards.get(position);
                if (deck.getCustom()== DbHelper.CUSTOM_FALSE) {
                    Toast.makeText(getApplicationContext(), "O conteúdo de um deck original não pode ser editado", Toast.LENGTH_LONG).show();
                    adapterCard.notifyItemChanged(position);
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), CardCreateEditActivity.class);
                intent.putExtra(Card.KEY_CARD, card);
                startActivity(intent);
            }
        });

        binding.fabCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CardCreateEditActivity.class);
                intent.putExtra(Deck.KEY_DECK, deckId);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void loadCardsList() {
        cardDAO = new CardDAO(this);
        listCards = cardDAO.listCards(deckId);
        if (listCards.size()==0) {
            rv.setVisibility(View.GONE);
            binding.imageEmpty.setVisibility(View.VISIBLE);
            binding.textEmpty.setVisibility(View.VISIBLE);
        }else {
            binding.imageEmpty.setVisibility(View.GONE);
            binding.textEmpty.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);


            adapterCard = new AdapterCard(listCards);

            rv.setLayoutManager(new LinearLayoutManager(this));

            rv.setHasFixedSize(true);
            rv.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

            rv.setAdapter(adapterCard);
        }

    }
}