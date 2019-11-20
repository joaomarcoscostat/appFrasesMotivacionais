package com.example.appmotivacional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mudarTexto(View view)
    {
        Random randomico= new Random();
        int numeroAleatorio= randomico.nextInt(frases.length);
        TextView caixaFrase= findViewById(R.id.caixaFrase);
        caixaFrase.setText(frases[numeroAleatorio]);

    }

    private String[] frases={

            "Sua luta não termina quando sentir cansaço, mas sim quando atingir o sucesso tão merecido.",
            "Você não só tem o direito de ser feliz como também tem a obrigação de lutar para alcançar a felicidade.",
            "Encare o que fez de errado com motivação, pois é isso que o ajudará a fazer certo da próxima vez.",
            "As pessoas dizem frequentemente que a motivação não dura. Bem, nem o banho - e é por isso que ele é recomendado diariamente.",
            "Há dias que você tem que ir para a frente só com o que você tem na mão, não dá para esperar pela motivação.",
            "A motivação não acontece por acaso, como tudo na vida você tem de batalhar para a alcançar.",
            "Toda ação humana, quer se torne positiva ou negativa, precisa depender de motivação.",
            "Arrisque, vá em frente e sem medo! Não há motivação maior do que descobrir quão corajosos conseguimos ser.",
            "Assim como os pássaros, precisamos aprender a superar os desafios que nos são apresentados, para alçarmos voos mais altos.",
            "Já experimentou acreditar em você? Tente! Você não faz ideia do que é capaz.",
            "A vida tanto lhe pode dar o melhor como o pior, mas é você quem escolhe aquilo que vai permanecer ou ficar para trás.",
            "Sonhos existem para serem realizados, por isso não olhe para trás nem escute palavras de desânimo!",
            "Se ao enfrentar os problemas da vida lhe parecer que está escalando uma montanha impossível, lembre-se que a paisagem que avistará no topo compensará qualquer esforço seu.",
            "O poder está dentro de você, na sua mente, pois se acreditar que consegue não haverá obstáculo capaz de impedir o seu sucesso.",
            "Quando fazemos da união nossa principal arma na luta por um objetivo comum, vencer é uma tarefa que se torna bem mais fácil.",

    };
}


