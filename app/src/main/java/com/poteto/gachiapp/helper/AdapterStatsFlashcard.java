package com.poteto.gachiapp.helper;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poteto.gachiapp.databinding.ListCardBinding;
import com.poteto.gachiapp.databinding.ListFlashcardBinding;
import com.poteto.gachiapp.databinding.ListStatsFlashcardBinding;
import com.poteto.gachiapp.model.Card;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AdapterStatsFlashcard extends RecyclerView.Adapter<AdapterStatsFlashcard.MyViewHolder> {

    private ListStatsFlashcardBinding binding;
    private List<Card> cardList;

    public AdapterStatsFlashcard (List<Card> cardList) {
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public AdapterStatsFlashcard.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterStatsFlashcard.MyViewHolder(ListStatsFlashcardBinding.inflate
                (LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterStatsFlashcard.MyViewHolder holder, int position) {
        Card card = cardList.get(position);
        String cardFront = card.getFront();
        String cardBack = card.getBack();
        String cardReading = card.getReading();

        long nextMillis = card.getNext_date();
        LocalDate nextLocalDate = Instant.ofEpochMilli(nextMillis).atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = nextLocalDate.format(formatter);

        String textFront = cardFront;
        if (cardReading!= null && !cardReading.isEmpty()) {
            textFront += " 「"+cardReading+"」";
        }

        holder.textCardFront.setText(textFront);
        holder.textCardBack.setText(cardBack);
        holder.textNext.setText("A próxima revisão deste cartão foi agendada para: "+date);
    }

    @Override
    public int getItemCount() {
        return cardList != null ? cardList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textCardFront, textCardBack, textNext;

        public MyViewHolder(@NonNull ListStatsFlashcardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

            textCardFront = binding.textCardFront;
            textCardBack = binding.textCardBack;
            textNext = binding.textNext;
        }
    }
}
