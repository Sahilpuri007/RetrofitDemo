package com.android.example.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

public class Country {


    @SerializedName("name")
    private String countryName;
    @SerializedName("capital")
    private String countryCapital;


    public Country(String countryName, String countryCapital) {
        this.countryName = countryName;
        this.countryCapital = countryCapital;
    }

    public String getCountryName() {
        return countryName;
    }


    public String getCountryCapital() {
        return countryCapital;
    }

}
