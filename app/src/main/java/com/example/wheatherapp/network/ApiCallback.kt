package com.example.wheatherapp.network

interface ApiCallback<T> {
    fun onSuccess(data: T?)
    fun onError(error: String?)
}