package com.poteto.gachiapp.helper;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poteto.gachiapp.databinding.ListConsultaBinding;
import com.poteto.gachiapp.model.Card;

import java.util.ArrayList;
import java.util.List;

public class AdapterConsulta extends RecyclerView.Adapter<AdapterConsulta.MyViewHolder> implements Filterable {

    private ListConsultaBinding binding;
    private List<Card> cardList;
    private List<Card> cardListFull;
    private DeckDAO deckDAO;

    public AdapterConsulta(List<Card> cardList) {
        this.cardList = cardList;
        cardListFull = new ArrayList<>(cardList);
    }

    @NonNull
    @Override
    public AdapterConsulta.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        deckDAO = new DeckDAO(parent.getContext());
        return new AdapterConsulta.MyViewHolder(ListConsultaBinding.inflate
                (LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Card card = cardList.get(position);
        String cardFront = card.getFront();
        String cardBack = card.getBack();
        String cardReading = card.getReading();
        String deckText = deckDAO.getDeckName(card.getDeck());

        String frontText = cardFront;
        if (cardReading!= null && !cardReading.isEmpty()) {
            frontText += " 「"+cardReading+"」";
        }

        holder.textFront.setText(frontText);
        holder.textBack.setText(cardBack);
        holder.textDeck.setText("Deck: "+deckText);
    }

    @Override
    public int getItemCount() {
        return cardList != null ? cardList.size() : 0;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Card> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0 ) {
                filteredList.addAll(cardListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Card item : cardListFull) {
                    String front = item.getFront();
                    String back = item.getBack();
                    String reading = item.getReading();

                    if (front!=null && !front.isEmpty()) {
                        if (front.toLowerCase().contains(filterPattern)){
                            filteredList.add(item);
                            continue;
                        }
                    }
                    if (back!=null && !back.isEmpty()) {
                        if (back.toLowerCase().contains(filterPattern)){
                            filteredList.add(item);
                            continue;
                        }
                    }
                    if (reading!=null && !reading.isEmpty()) {
                        if (reading.toLowerCase().contains(filterPattern)){
                            filteredList.add(item);
                            continue;
                        }
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            cardList.clear();
            cardList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textFront, textBack, textDeck;

        public MyViewHolder(@NonNull ListConsultaBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

            textFront = binding.textFrontConsulta;
            textBack = binding.textBackConsulta;
            textDeck = binding.textDeckConsulta;
        }
    }
}
