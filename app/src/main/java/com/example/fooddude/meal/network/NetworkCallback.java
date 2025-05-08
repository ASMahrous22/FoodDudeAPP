package com.example.fooddude.meal.network;

public interface NetworkCallback<T>
{
    void onSuccess(T data);
    void onFailure(String message);
}

