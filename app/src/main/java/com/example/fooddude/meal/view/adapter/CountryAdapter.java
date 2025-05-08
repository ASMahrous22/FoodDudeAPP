package com.example.fooddude.meal.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fooddude.R;
import com.example.fooddude.meal.data.model.Country;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>
{
    private List<Country> countryList;

    private OnCountryClickListener listener;

    public interface OnCountryClickListener
    {
        void onCountryClick(Country country);
    }

    public CountryAdapter(List<Country> countryList, OnCountryClickListener listener)
    {
        this.countryList = countryList;
        this.listener = listener;
    }

    public void setCountries(List<Country> countries)
    {
        this.countryList = countries;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position)
    {
        holder.bind(countryList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return countryList != null ? countryList.size() : 0;
    }

    class CountryViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView countryName;

        public CountryViewHolder(@NonNull View itemView)
        {
            super(itemView);
            countryName = itemView.findViewById(R.id.tvCountryName);
        }

        public void bind(Country country)
        {
            countryName.setText(country.getStrArea());
            itemView.setOnClickListener(v ->
            {
                if (listener != null)
                {
                    listener.onCountryClick(country);
                }
            });
        }
    }

}