package com.android.example.retrofitdemo.rest;

import com.android.example.retrofitdemo.model.Country;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryAPI {

    String BASE_URL = "https://restcountries.eu/rest/v2/";
    @GET("all/?fields=name;capital")
    Call<ArrayList<Country>> getCountries();

}
