package com.example.appmotivacional.service;

import com.example.appmotivacional.model.Frases;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Android on 20/04/2018.
 */

public interface ApiService {

    @GET("/")
    Call<Frases> getFrases();
}

