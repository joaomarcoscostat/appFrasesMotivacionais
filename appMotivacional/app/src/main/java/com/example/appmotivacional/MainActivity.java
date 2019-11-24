package com.example.appmotivacional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmotivacional.model.Frases;
import com.example.appmotivacional.service.ApiService;
import com.example.appmotivacional.service.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;
    private Frases Frase;
    private Button btnMudar;
    private ImageView btnShare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFrases();
        btnMudar = findViewById(R.id.btnMudar);
        btnMudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFrases();
            }
        });
        btnShare=findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=Frase.toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });


    }



    public void getFrases() {
        apiService = RetrofitBuilder.getRetrofit().create(ApiService.class);
        //call = apiService.getPostagems();
        Call<Frases> listCall = apiService.getFrases();
        listCall.enqueue(new Callback<Frases>() {

            @Override
            public void onResponse(Call<Frases> call, Response<Frases> response) {
                if (response.body() != null) {
                    Log.i("Ap", response.body().toString());
                    Frase = new Frases();
                    Frase.setAutor(response.body().getAutor());
                    Frase.setConteudo(response.body().getConteudo());

                    TextView Resultado = findViewById(R.id.caixaFrase);
                    Resultado.setText(Frase.toString());
                }
            }

            @Override
            public void onFailure(Call<Frases> call, Throwable t) {

            }

        });
    }


}


