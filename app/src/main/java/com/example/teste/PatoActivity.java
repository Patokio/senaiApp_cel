package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;

public class PatoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pato);

        Button btnNovoPato = findViewById(R.id.btnNovoPato);
        ImageView imgPato = findViewById(R.id.imgPato);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnNovoPato.setOnClickListener(v -> {
            //imgPato.setImageURI();
        });

        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);
        /*btnVoltar.setOnClickListener(v ->{
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            finish();
        });*/
    }
}
