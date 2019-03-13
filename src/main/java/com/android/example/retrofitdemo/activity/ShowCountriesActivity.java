package com.android.example.retrofitdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.example.retrofitdemo.R;
import com.android.example.retrofitdemo.adapter.CountryAdapter;
import com.android.example.retrofitdemo.model.Country;
import com.android.example.retrofitdemo.rest.CountryAPI;

import java.util.ArrayList;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowCountriesActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<Country> saveCountryArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_countries);

        initRecyclerView();
        createRetrofit();
        getData();


    }



    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private CountryAPI createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CountryAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CountryAPI countryAPI=retrofit.create(CountryAPI.class);

        return countryAPI;
    }

    private void getData() {
        Call<ArrayList<Country>> call = createRetrofit().getCountries();
        saveCountryArrayList = Paper.book().read("countries");
        if(!Paper.book().contains("countries")) {
            call.enqueue(new Callback<ArrayList<Country>>() {
                @Override
                public void onResponse(Call<ArrayList<Country>> call, Response<ArrayList<Country>> response) {
                    if(!response.body().isEmpty()) {
                        ArrayList<Country> countryArrayList = response.body();
                        Paper.book().write("countries", countryArrayList);
                        recyclerView.setAdapter(new CountryAdapter(countryArrayList));
                    }
                    else {
                        Log.d("Response Failure", response.errorBody().toString());
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Country>> call, Throwable t) {
                    Log.d("Failure", t.getMessage());
                }
            });
        }
        else{
            Log.d("else","here");
            recyclerView.setAdapter(new CountryAdapter(saveCountryArrayList));
        }
    }



}