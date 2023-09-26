package com.example.mypdfreader;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MainView extends RecyclerView.ViewHolder {

    public TextView txtName;
    public CardView cardView;

    public MainView(@NonNull View itemView){
        super(itemView);

        txtName=itemView.findViewById(R.id.pdf_txt);
        cardView=itemView.findViewById((R.id.pdf_cardView));
    }


}
