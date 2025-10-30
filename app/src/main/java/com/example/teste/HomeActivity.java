package com.example.teste;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> ef87e62174180a97c6cf415999410c4c43d20406
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

<<<<<<< HEAD
        Button btnTocado = findViewById(R.id.btnTocado);
        TextView txtTocar = findViewById(R.id.txtTocar);
        ImageView imgVisto = findViewById(R.id.imgVisto);
        Button btnVoltar = findViewById(R.id.btnVoltar);
=======
        Button btnTocar = findViewById(R.id.btnTocar);
        TextView txtTocar = findViewById(R.id.txtTocar);
        ImageView imgVisto = findViewById(R.id.imgVisto);
>>>>>>> ef87e62174180a97c6cf415999410c4c43d20406

        AtomicInteger tocado = new AtomicInteger();

        //String [] frases = {"Acredite em você!", "Nunca desista!", "Você é capaz"};
        int [] img_muitas = {
                R.drawable.igaem,
                R.drawable.atari_game,
                R.drawable.redentor_rio
        };

<<<<<<< HEAD
        btnTocado.setOnClickListener(v -> {
=======
        btnTocar.setOnClickListener(v -> {
>>>>>>> ef87e62174180a97c6cf415999410c4c43d20406
            int numero = new Random().nextInt(img_muitas.length);
            //txtTocar.setText(frases[numero]);

            tocado.getAndIncrement();
            txtTocar.setText(String.valueOf(tocado.get()));
            imgVisto.setImageResource(img_muitas[numero]);

        });
<<<<<<< HEAD

        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);
        /*btnVoltar.setOnClickListener(v ->{
            //finish();
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            finish();
        });*/
=======
>>>>>>> ef87e62174180a97c6cf415999410c4c43d20406
    }
}
