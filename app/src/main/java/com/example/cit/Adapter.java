package com.example.cit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private ArrayList nameP, surnameP, patronymicP, id;


    Adapter(Context context, ArrayList nameP, ArrayList surnameP, ArrayList patronymicP, ArrayList id){

        this.context = context;
        this.nameP = nameP;
        this.surnameP = surnameP;
        this.patronymicP = patronymicP;
        this.id = id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.for_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText(String.valueOf(nameP.get(position)));
        holder.tv_surname.setText(String.valueOf(surnameP.get(position)));
        holder.tv_patronymic.setText(String.valueOf(patronymicP.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_surname, tv_patronymic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.name_teach);
            tv_surname = itemView.findViewById(R.id.surname_teach);
            tv_patronymic = itemView.findViewById(R.id.patronymic_teach);
        }
    }
}
