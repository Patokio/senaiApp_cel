package com.example.teste;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CEPActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cep);

        EditText edtCEP = findViewById(R.id.edtCEP);
        TextView txvResult = findViewById(R.id.txvResult);
        Button btnConsultar = findViewById(R.id.btnConsultar);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);

        btnConsultar.setOnClickListener(v -> {
                String cep = edtCEP.getText().toString();
                if (!cep.isEmpty()) {
                    buscarEndereco(cep,txvResult);
                } else {
                    txvResult.setText("Digite um CEP válido.");
                }
            });
    }
    private void buscarEndereco(String cep, TextView txvResult){
        new Thread(() -> {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";
            try {
                URL apiUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder resultado = new StringBuilder();
                String linha;

                while ((linha = reader.readLine()) != null) {
                    resultado.append(linha);
                }

                reader.close();

                JSONObject jsonObject = new JSONObject(resultado.toString());

                String logradouro = jsonObject.optString("logradouro", ""); // optString evita exceções
                String bairro = jsonObject.optString("bairro", "");
                String localidade = jsonObject.optString("localidade", "");
                String uf = jsonObject.optString("uf", "");

                String endereco = logradouro + ", " + bairro + "\n" + localidade + " - " + uf;

                runOnUiThread(() -> txvResult.setText(endereco));

            } catch (Exception e) {
                runOnUiThread(() -> txvResult.setText("Erro ao buscar endereço."));
                e.printStackTrace();
            }
        }).start();
    }
}
