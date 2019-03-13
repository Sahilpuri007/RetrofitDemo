package com.android.example.retrofitdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.example.retrofitdemo.R;
import com.android.example.retrofitdemo.model.Country;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Country> countryArrayList;

    public CountryAdapter(ArrayList<Country> countryArrayList) {
        this.countryArrayList = countryArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_country,
                viewGroup,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CountryViewHolder countryViewHolder = (CountryViewHolder) viewHolder;
        countryViewHolder.textViewName.setText(countryArrayList.get(i).getCountryName());
        countryViewHolder.textViewCapital.setText(countryArrayList.get(i).getCountryCapital());

    }

    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName,textViewCapital;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.countryName);
            textViewCapital = itemView.findViewById(R.id.countryCapital);

        }
    }
}
