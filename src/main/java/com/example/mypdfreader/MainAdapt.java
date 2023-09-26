package com.example.mypdfreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class MainAdapt extends RecyclerView.Adapter<MainView> {

    private Context context;
    private List<File> pdffiles;
    private OnPdfSelect listener;

    public MainAdapt(Context context, List<File> pdffiles, OnPdfSelect listener) {
        this.context = context;
        this.pdffiles = pdffiles;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MainView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainView(LayoutInflater.from(context).inflate(R.layout.view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainView holder, int position) {
        holder.txtName.setText(pdffiles.get(position).getName());
        holder.txtName.setSelected(true);
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listener.onPdfSelected(pdffiles.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return pdffiles.size();
    }
}
