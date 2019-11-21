package com.example.appmotivacional.service;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.example.appmotivacional.model.Frases;

public class HTTP extends AsyncTask<Void,Void,Frases> {

    @Override
    protected Frases doInBackground(Void... voids) {
        StringBuilder resposta= new StringBuilder();
        try {
            URL url = new URL("https://apimotivacional.000webhostapp.com/");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");
            connection.setConnectTimeout(5000);
            connection.connect();
            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                resposta.append(scanner.next());
            };
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(resposta.toString(),Frases.class);
    }
}
