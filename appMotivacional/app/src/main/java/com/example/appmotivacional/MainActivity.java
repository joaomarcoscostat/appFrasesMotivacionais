package com.example.appmotivacional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmotivacional.model.Frases;
import com.example.appmotivacional.service.ApiService;
import com.example.appmotivacional.service.RetrofitBuilder;
import com.example.appmotivacional.NotificationHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private ApiService apiService;
    private Frases Frase;
    private Button btnMudar;
    private ImageView btnShare;

    private NotificationHelper mNotificationHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMudar = findViewById(R.id.btnMudar);
        btnShare=findViewById(R.id.btnShare);
        mNotificationHelper = new NotificationHelper(this);
        getFrases();



        btnMudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendOnChannel1(getTitle().toString(),Frase.toString());

            }
        });


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

    public void sendOnChannel1(String title,String message){

        NotificationCompat.Builder nb = mNotificationHelper.getChannel1Notification(title,message);
        mNotificationHelper.getManager().notify(0,nb.build());


    }


}


