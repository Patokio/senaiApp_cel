package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button btnTocar = findViewById(R.id.btnTocar);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        Button btnPato = findViewById(R.id.btnPato);

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

        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);
        /*btnVoltar.setOnClickListener(v -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
        });*/
    }
}
