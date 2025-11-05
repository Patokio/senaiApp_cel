package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button btnTocar = findViewById(R.id.btnTocar);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        Button btnPato = findViewById(R.id.btnPato);
        Button btnMoeda = findViewById(R.id.btnMoeda);
        Button btnTemperatura = findViewById(R.id.btnTemperatura);
        Button btnGato = findViewById(R.id.btnGato);
        Button btnCEP = findViewById(R.id.btnCEP);
        Button btnCarro = findViewById(R.id.btnCarro);
        /*public static void configurarBotaoVoltar(Activity activity, Button btnVoltar) {
            btnVoltar.setOnClickListener(v -> {
                activity.finish(); // Fecha a activity atual
            });*/

        btnPato.setOnClickListener(v -> {
            Intent intent = new Intent(this, PatoActivity.class);
            startActivity(intent);
            //finish();
        });

        btnTocar.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            //finish();
        });

        btnMoeda.setOnClickListener(v -> {
            Intent intent = new Intent(this, ConversorActivity.class);
            startActivity(intent);
        });

        btnTemperatura.setOnClickListener(v -> {
            Intent intent = new Intent(this, TemperaturaActivity.class);
            startActivity(intent);
        });

        btnCEP.setOnClickListener(v -> {
            Intent intent = new Intent(this, CEPActivity.class);
            startActivity(intent);
        });

        btnGato.setOnClickListener(v -> {
            Intent intent = new Intent(this, GatoActivity.class);
            startActivity(intent);
        });

        btnCarro.setOnClickListener(v -> {
            Intent intent = new Intent(this, CarroActivity.class);
            startActivity(intent);
        });

        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);
        /*btnVoltar.setOnClickListener(v -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
        });*/
    }
}
