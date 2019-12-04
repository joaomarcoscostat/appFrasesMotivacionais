package com.example.appmotivacional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
    private ProgressBar progressBar;

    private NotificationHelper mNotificationHelper;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        btnMudar = findViewById(R.id.btnMudar); /*Referencia com id do mesmo no Layout*/
        btnShare=findViewById(R.id.btnShare);


        mNotificationHelper = new NotificationHelper(this); /*Estancia objeto da classe de Notificacao*/

        /*sendOnChannel1(getTitle().toString(),Frase.toString()); Chamar notificacao*/


        getFrases();




        btnMudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFrases(); /*Chama função da API de Frases*/

            }
        });


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=Frase.toString();  /*String para receber o texto da função que retorna frases da API*/
                Intent sendIntent = new Intent(); /*Estancia intet que chamará o shareIntent(Compartilhamento)*/
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text); /*Especifica tamanho do dado e a variável que armazena o mesmo*/
                sendIntent.setType("text/plain");/*Tipo de dado que irá compartilhar*/

                Intent shareIntent = Intent.createChooser(sendIntent, "Compartilhar Frase");
                startActivity(shareIntent); /*Chama  a Activity com a o menu de compartilhamento*/
            }
        });



    }


    public void getFrases() {
        apiService = RetrofitBuilder.getRetrofit().create(ApiService.class);

        exibirProgress(true);

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
                    exibirProgress(false);
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

    private void exibirProgress(boolean exibir) {
        progressBar.setVisibility(exibir ? View.VISIBLE : View.GONE);
    } /*Exibir ProgressBar*/



}


