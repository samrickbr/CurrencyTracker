package com.example.cryptocurrencytracker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    String URL_BASE = "https://api.coingecko.com/api/v3/coins/";

    @GET("markets")
    Call<List<CurrencyTracker>> getCurrency();//@Query("vs_currency") String vs_currency);//, @Query("order") String order);
}
