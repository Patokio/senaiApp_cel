package com.example.teste;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class PatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pato);

        Button btnNovoPato = findViewById(R.id.btnNovoPato);
        ImageView imgPato = findViewById(R.id.imgPato);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);
        String imgURL = "https://random-d.uk/api/randomimg";

        btnNovoPato.setOnClickListener(v -> {
            //imgPato.setImageResource(imgURL);
            Glide.with(this)
                    .load(imgURL)
                    .error(R.drawable.erro)              // opcional: caso dê erro
                    .into(imgPato);
        });

    /*    btnNovoPato.setOnClickListener(v -> {
            new LoadRandomDuck().execute();
        });
    }

    private class LoadRandomDuck extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://random-d.uk/api/random");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();

                InputStream inputStream = conn.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                scanner.useDelimiter("\\A");
                String response = scanner.hasNext() ? scanner.next() : "";

                JSONObject jsonObject = new JSONObject(response);
                return jsonObject.getString("url"); // pega a URL da imagem
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String imageUrl) {
            ImageView imgPato = findViewById(R.id.imgPato);
            if (imageUrl != null) {
                Glide.with(PatoActivity.this)
                        .load(imageUrl)
                        .error(R.drawable.erro)
                        .into(imgPato);
            } else {
                imgPato.setImageResource(R.drawable.erro);
            }
        }*/

        /*btnVoltar.setOnClickListener(v ->{
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            finish();
        });*/
    }
}
