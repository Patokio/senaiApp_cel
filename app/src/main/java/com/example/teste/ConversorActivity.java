package com.example.teste;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConversorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversor);

        Button btnConverter = findViewById(R.id.btnConverter);
        EditText txtValor = findViewById(R.id.txtValor);
        Spinner spnTipo = findViewById(R.id.spnTipo);
        TextView txtResult = findViewById(R.id.txtResult);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);

        String[] tipo = {"Dólar Americano", "Dólar Canadence", "Euro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTipo.setAdapter(adapter);

        btnConverter.setOnClickListener(v -> {
            /*double valor = Double.parseDouble(String.valueOf(txtValor.getText()));
            double result = valor / 5.38;
            txtResult.setText(String.format("%.2f ",result));*/
            String moeda = spnTipo.getSelectedItem().toString();
            double valor = Double.parseDouble(String.valueOf(txtValor.getText()));
            double result = 0;
            if (moeda.equals("Dólar Americano")) {
                result = valor / 5.38;
            } else if (moeda.equals("Dólar Canadence")) {
                result = valor / 3.84;
            } else if (moeda.equals("Euro")) {
                result = valor / 6.20;
            }
            txtResult.setText(String.format("%.2f ",result));
        });
    }
}
