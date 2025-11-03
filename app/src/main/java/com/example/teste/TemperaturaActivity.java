package com.example.teste;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TemperaturaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperatura);

        Button btnTemp = findViewById(R.id.btnTemp);
        EditText txtTempAtual = findViewById(R.id.txtTempAtual);
        Spinner spnTemp = findViewById(R.id.spnTemp);
        Spinner spnTemp2 = findViewById(R.id.spnTemp2);
        TextView txtResultTemp = findViewById(R.id.txtResultTemp);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);

        String[] temp = {"Temperatura atual", "Celsius", "Fahrenheit", "Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTemp.setAdapter(adapter);

        String[] temp2 = {"Temperatura para conversão", "Celsius", "Fahrenheit", "Kelvin"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTemp2.setAdapter(adapter2);

        btnTemp.setOnClickListener(v -> {
            String tempe = spnTemp.getSelectedItem().toString();
            String tempe2 = spnTemp2.getSelectedItem().toString();

            double tempAtual = Double.parseDouble(String.valueOf(txtTempAtual.getText()));
            double result = 0;
            if (tempe.equals("Celsius") && tempe2.equals("Fahrenheit")){
                result = (1.8 * tempAtual) + 32;
                txtResultTemp.setText(String.format("Fahrenheit: %.2f",result));
            } else if (tempe.equals("Celsius") && tempe2.equals("Kelvin")){
                result = tempAtual + 273.15;
                txtResultTemp.setText(String.format("Kelvin: %.2f",result));
            } else if (tempe.equals("Fahrenheit") && tempe2.equals("Celsius")){
                result = (tempAtual - 32) / 1.8;
                txtResultTemp.setText(String.format("Celsius: %.2f",result));
            } else if (tempe.equals("Fahrenheit") && tempe2.equals("Kelvin")){
                result = (tempAtual - 32) / 1.8;
                result = result + 273.15;
                txtResultTemp.setText(String.format("Kelvin: %.2f",result));
            } else if (tempe.equals("Kelvin") && tempe2.equals("Fahrenheit")){
                result = (tempAtual - 273.15) * 9/5 + 32;
                txtResultTemp.setText(String.format("Fahrenheit: %.2f",result));
            } else if (tempe.equals("Kelvin") && tempe2.equals("Celsius")){
                result = tempAtual - 273.15;
                txtResultTemp.setText(String.format("Celsius: %.2f",result));
            } else if (tempe.equals("Temperatura atual") || tempe2.equals("Temperatura para conversão")){
                txtResultTemp.setText("Informe de qual para qual tipo de temperatura deseja.");
            }
        });
    }
}
