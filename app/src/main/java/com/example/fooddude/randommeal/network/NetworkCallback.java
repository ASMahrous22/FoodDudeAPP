package com.example.fooddude.randommeal.network;

public interface NetworkCallback<T>
{
    void onSuccess(T data);
    void onFailure(String message);
}

