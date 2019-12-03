package com.example.appmotivacional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
<<<<<<< HEAD
=======
import androidx.core.app.NotificationManagerCompat;
>>>>>>> 46907c739a5c311cd54f1937760c54ee9de2db0d

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
<<<<<<< HEAD
import android.content.Intent;
=======
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
>>>>>>> 46907c739a5c311cd54f1937760c54ee9de2db0d
import android.os.Build;
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
import com.example.appmotivacional.NotificationHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private ApiService apiService;
    private Frases Frase;
    private Button btnMudar;
    private ImageView btnShare;
<<<<<<< HEAD

    private NotificationHelper mNotificationHelper;




=======
    private ProgressBar progressBar;
    private  TextView Resultado;
    public static int id=880;
>>>>>>> 46907c739a5c311cd54f1937760c54ee9de2db0d
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

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

=======
        btnMudar = findViewById(R.id.btnMudar);
        progressBar=findViewById(R.id.progressBar);
        btnShare=findViewById(R.id.btnShare);
         Resultado= findViewById(R.id.caixaFrase);

        progressBar.setVisibility(View.GONE);


>>>>>>> 46907c739a5c311cd54f1937760c54ee9de2db0d

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


<<<<<<< HEAD

    }
=======




    }

    public void sendNotification(View view) {
try {
    NotificationCompat.Builder mBuilder =
            new NotificationCompat.Builder(this);

    //Create the intent that’ll fire when the user taps the notification//

    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.androidauthority.com/"));
    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
>>>>>>> 46907c739a5c311cd54f1937760c54ee9de2db0d

    mBuilder.setContentIntent(pendingIntent);

    mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
    mBuilder.setContentTitle("My notification");
    mBuilder.setContentText(Resultado.getText());

    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    mNotificationManager.notify(001, mBuilder.build());

    Log.i("Not", "deu bom");

}catch (Exception e){
    e.printStackTrace();
    Log.i("Not", "deu ruim");
}

    }

    public void getFrases() {
        progressBar.setVisibility(View.VISIBLE);
        apiService = RetrofitBuilder.getRetrofit().create(ApiService.class);
        Call<Frases> listCall = apiService.getFrases();
        listCall.enqueue(new Callback<Frases>() {

            @Override
            public void onResponse(Call<Frases> call, Response<Frases> response) {
                if (response.body() != null) {
                    Log.i("Ap", response.body().toString());
                    Frase = new Frases();
                    Frase.setAutor(response.body().getAutor());
                    Frase.setConteudo(response.body().getConteudo());

                    Resultado.setText(Frase.toString());
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<Frases> call, Throwable t) {

            }

        });

    }

<<<<<<< HEAD
    public void sendOnChannel1(String title,String message){

        NotificationCompat.Builder nb = mNotificationHelper.getChannel1Notification(title,message);
        mNotificationHelper.getManager().notify(0,nb.build());
=======
    private void createNotificationChannel() {
        string c;
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.app_name);
            String description = getString(R.string.app_name);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(chanel, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }




>>>>>>> 46907c739a5c311cd54f1937760c54ee9de2db0d


    }

<<<<<<< HEAD
=======







>>>>>>> 46907c739a5c311cd54f1937760c54ee9de2db0d



