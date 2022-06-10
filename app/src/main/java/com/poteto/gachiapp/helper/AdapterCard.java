package com.poteto.gachiapp.helper;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poteto.gachiapp.databinding.ListCardBinding;
import com.poteto.gachiapp.model.Card;

import java.util.List;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.MyViewHolder> {

    private ListCardBinding binding;
    private List<Card> cardList;

    public AdapterCard(List<Card> cardList) {
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ListCardBinding.inflate
                (LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Card card = cardList.get(position);
        String cardFront = card.getFront();
        String cardBack = card.getBack();
        String cardReading = card.getReading();

        String textFront = cardFront;
        if (cardReading!= null && !cardReading.isEmpty()) {
            textFront += " 「"+cardReading+"」";
        }

        holder.textCardFront.setText(textFront);
        holder.textCardBack.setText(cardBack);
    }

    @Override
    public int getItemCount() {
        return cardList != null ? cardList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textCardFront, textCardBack;

        public MyViewHolder(@NonNull ListCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

            textCardFront = binding.textCardFront;
            textCardBack = binding.textCardBack;
        }
    }
}
