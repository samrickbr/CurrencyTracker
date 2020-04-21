package com.example.cryptocurrencytracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<CurrencyTracker> currencyTrackers;

    public RecyclerAdapter(ArrayList<CurrencyTracker> currencyTrackers) {
        this.currencyTrackers = currencyTrackers;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CurrencyTracker currencyTracker = currencyTrackers.get(position);

        holder.name.setText("Name: " + currencyTracker.getName());

        holder.symbol.setText("Symbol: " + currencyTracker.getSymbol());

        holder.currentPrice.setText("Price: $ " + currencyTracker.getCurrentPrice());

    }

    @Override
    public int getItemCount() {
        return currencyTrackers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.symbol)
        TextView symbol;

        @BindView(R.id.currentPrice)
        TextView currentPrice;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
