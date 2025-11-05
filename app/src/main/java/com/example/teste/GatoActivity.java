package com.example.teste;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gato);

        Button btnNovoGato = findViewById(R.id.btnNovoGato);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);

        String urlGato = "https://api.thecatapi.com/v1/images/search";
        btnNovoGato.setOnClickListener(v -> {
            new CarregarRandomGato().execute();
            /*Glide.with(this)
                    .load(urlGato)
                    .error(R.drawable.erro)
                    .into(imgGato);*/
        });

        //https://api.thecatapi.com/v1/images/search
    }
    private class CarregarRandomGato extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://api.thecatapi.com/v1/images/search");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();

                InputStream inputStream = conn.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                scanner.useDelimiter("\\A");
                String response = scanner.hasNext() ? scanner.next() : "";

                JSONArray jsonArray = new JSONArray(response);
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                return jsonObject.getString("url");// pega a URL da imagem
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        @Override
        protected void onPostExecute(String imageUrl) {
            ImageView imgGato = findViewById(R.id.imgGato);
            super.onPostExecute(imageUrl);
            if (imageUrl != null) {
                Glide.with(GatoActivity.this)
                        .load(imageUrl)
                        .error(R.drawable.erro)
                        .centerCrop()
                        .into(imgGato);
            }
        }
    }
}
