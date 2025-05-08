package com.example.fooddude.meal.view.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.fooddude.R;
import com.example.fooddude.meal.data.model.Category;
import com.example.fooddude.meal.view.activity.SearchActivity;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>
{
    private List<Category> categoryList;

    private final OnCategoryClickListener listener;

    public interface OnCategoryClickListener
    {
        void onCategoryClick(String categoryName);
    }

    public CategoryAdapter(List<Category> categoryList, OnCategoryClickListener listener)
    {
        this.categoryList = categoryList == null ? new ArrayList<>() : categoryList;
        this.listener = listener;
    }

    public void setCategoryList(List<Category> categoryList)
    {
        this.categoryList = categoryList != null ? categoryList : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position)
    {
        Category category = categoryList.get(position);
        holder.bind(category);
        holder.itemView.setOnClickListener(v ->
        {
            listener.onCategoryClick(category.getStrCategory());
            Intent intent = new Intent(holder.itemView.getContext(), SearchActivity.class);
            intent.putExtra("FILTER_TYPE", "category");
            intent.putExtra("FILTER_VALUE", category.getStrCategory());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount()
    {
        return categoryList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView ivCategoryThumb;
        private final TextView tvCategoryName;

        CategoryViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ivCategoryThumb = itemView.findViewById(R.id.ivCategoryThumb);
            tvCategoryName = itemView.findViewById(R.id.tvCategoryName);
        }

        void bind(Category category)
        {
            tvCategoryName.setText(category.getStrCategory());
            Glide.with(itemView.getContext()).load(category.getStrCategoryThumb()).into(ivCategoryThumb);
        }
    }
}