package com.poteto.gachiapp.helper;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poteto.gachiapp.databinding.ListDeckBinding;
import com.poteto.gachiapp.model.Deck;

import java.util.List;

public class AdapterDeck extends RecyclerView.Adapter<AdapterDeck.MyViewHolder> {

    private ListDeckBinding binding;
    private List<Deck> cardDeck;

    public AdapterDeck(List<Deck> cardDeck) {
        this.cardDeck = cardDeck;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ListDeckBinding.inflate
                (LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Deck deck = cardDeck.get(position);
        String deckName = deck.getName();

        holder.textNameDeck.setText(deckName);
    }

    @Override
    public int getItemCount() {
        return cardDeck != null ? cardDeck.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textNameDeck;

        public MyViewHolder(@NonNull ListDeckBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

            textNameDeck = binding.textDeckName;
        }
    }
}