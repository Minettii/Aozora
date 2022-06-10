package com.poteto.gachiapp.activity.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.poteto.gachiapp.R;
import com.poteto.gachiapp.activity.card.CardCreateEditActivity;
import com.poteto.gachiapp.activity.card.CardDetailActivity;
import com.poteto.gachiapp.databinding.ActivityConsultaBinding;
import com.poteto.gachiapp.helper.AdapterConsulta;
import com.poteto.gachiapp.helper.AdapterDeck;
import com.poteto.gachiapp.helper.CardDAO;
import com.poteto.gachiapp.helper.DbHelper;
import com.poteto.gachiapp.helper.DeckDAO;
import com.poteto.gachiapp.helper.RecyclerItemClickListener;
import com.poteto.gachiapp.model.Card;
import com.poteto.gachiapp.model.Deck;
import com.tsuryo.swipeablerv.SwipeLeftRightCallback;
import com.tsuryo.swipeablerv.SwipeableRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ConsultaActivity extends AppCompatActivity {

    ActivityConsultaBinding binding;
    CardDAO cardDAO;
    List<Card> listCards = new ArrayList<>();
    AdapterConsulta adapterDeck;
    SwipeableRecyclerView rv;
    Activity context = this;

    @Override
    protected void onStart() {
        super.onStart();
        loadList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConsultaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Consulta");
        cardDAO = new CardDAO(getApplicationContext());

        rv = binding.rvConsulta;

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rv,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Card card = listCards.get(position);
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

        rv.setListener(new SwipeLeftRightCallback.Listener() {

            @Override
            public void onSwipedLeft(int position) {
                Card card = listCards.get(position);
                Deck cardDeck = cardDAO.getDeck(card.getDeck());
                if (cardDeck.getCustom()== DbHelper.CUSTOM_FALSE) {
                    Toast.makeText(getApplicationContext(), "O conteúdo de um deck original não pode ser excluído", Toast.LENGTH_LONG).show();
                    loadList();
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
                        Toast.makeText(getApplicationContext(), "Cartão: '"+card.getFront()+"' excluído com sucesso.", Toast.LENGTH_LONG).show();
                    }
                });
                dialogDelete.show();
                loadList();
            }

            @Override
            public void onSwipedRight(int position) {
                Card card = listCards.get(position);
                Deck cardDeck = cardDAO.getDeck(card.getDeck());
                if (cardDeck.getCustom()== DbHelper.CUSTOM_FALSE) {
                    Toast.makeText(getApplicationContext(), "O conteúdo de um deck original não pode ser editado", Toast.LENGTH_LONG).show();
                    loadList();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), CardCreateEditActivity.class);
                intent.putExtra(Card.KEY_CARD, card);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.searchButton);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapterDeck.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

    public void loadList() {
        listCards = cardDAO.listAllCards();
        adapterDeck = new AdapterConsulta(listCards);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rv.setAdapter(adapterDeck);
        rv.setHasFixedSize(true);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}