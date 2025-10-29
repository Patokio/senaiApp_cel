package com.example.teste;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button btnTocar = findViewById(R.id.btnTocar);
        TextView txtTocar = findViewById(R.id.txtTocar);
        ImageView imgVisto = findViewById(R.id.imgVisto);

        AtomicInteger tocado = new AtomicInteger();

        //String [] frases = {"Acredite em você!", "Nunca desista!", "Você é capaz"};
        int [] img_muitas = {
                R.drawable.igaem,
                R.drawable.atari_game,
                R.drawable.redentor_rio
        };

        btnTocar.setOnClickListener(v -> {
            int numero = new Random().nextInt(img_muitas.length);
            //txtTocar.setText(frases[numero]);

            tocado.getAndIncrement();
            txtTocar.setText(String.valueOf(tocado.get()));
            imgVisto.setImageResource(img_muitas[numero]);

        });
    }
}
