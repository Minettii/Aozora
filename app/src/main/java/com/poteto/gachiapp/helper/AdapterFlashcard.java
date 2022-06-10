package com.poteto.gachiapp.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poteto.gachiapp.databinding.ListFlashcardBinding;
import com.poteto.gachiapp.model.Deck;

import java.util.List;

public class AdapterFlashcard extends RecyclerView.Adapter<AdapterFlashcard.MyViewHolder> {

    private ListFlashcardBinding binding;
    private List<Deck> cardDeck;
    private CardDAO cardDAO;

    public AdapterFlashcard(List<Deck> cardDeck, CardDAO cardDAO) {
        this.cardDeck = cardDeck;
        this.cardDAO = cardDAO;
    }

    @NonNull
    @Override
    public AdapterFlashcard.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterFlashcard.MyViewHolder(ListFlashcardBinding.inflate
                (LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFlashcard.MyViewHolder holder, int position) {
        Deck deck = cardDeck.get(position);
        String deckName = deck.getName();
        int todayCards = cardDAO.getQuantityTodayFlashcards(deck.getId());
        holder.textName.setText(deckName);
        if (todayCards == 0) {
            holder.textShowQuantity.setText("Nenhum cartão agendado para hoje");
        } else if (todayCards == 1){
            holder.textShowQuantity.setText(todayCards + " cartão agendado para hoje");
        }else {
            holder.textShowQuantity.setText(todayCards + " cartões agendados para hoje");
        }
    }

    @Override
    public int getItemCount() {
        return cardDeck != null ? cardDeck.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textName, textShowQuantity;

        public MyViewHolder(@NonNull ListFlashcardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

            textName = binding.textName;
            textShowQuantity = binding.textShowQuantity;
        }
    }
}
