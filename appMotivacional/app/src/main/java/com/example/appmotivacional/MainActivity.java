package com.example.appmotivacional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mudarTexto(View view)
    {
        TextView caixaFrase= findViewById(R.id.caixaFrase);
        caixaFrase.setText("Seja Bem vindo");

    }

}


