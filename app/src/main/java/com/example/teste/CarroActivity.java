package com.example.teste;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CarroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carros);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);

        Spinner spnCarro = findViewById(R.id.spnCarro);
        TextView txtNome = findViewById(R.id.txtNome);
        TextView txtMarca = findViewById(R.id.txtMarca);
        TextView txtAno = findViewById(R.id.txtAno);
        TextView txtCor = findViewById(R.id.txtCor);
        TextView txtMotor = findViewById(R.id.txtMotor);
        TextView txtModelo = findViewById(R.id.txtModelo);
        ImageView imgCarro = findViewById(R.id.imgCarro);

        String[] tipo = {"Selecione uma Marca", "Chevrolet", "Fiat", "Hyundai", "Renault", "Volkswagen"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCarro.setAdapter(adapter);

        spnCarro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        imgCarro.setImageResource(R.drawable.erro);
                        txtNome.setText("");
                        txtMarca.setText("Selecione uma Marca");
                        txtAno.setText("");
                        txtCor.setText("");
                        txtMotor.setText("");
                        txtModelo.setText("");
                        break;

                    case 1:
                        imgCarro.setImageResource(R.drawable.chevrolet_onix);
                        txtNome.setText("Onix");
                        txtMarca.setText("Chevrolet");
                        txtAno.setText("2017");
                        txtCor.setText("Branco");
                        txtMotor.setText("1.0 - 4 cilindros");
                        txtModelo.setText("MPFI Joy 8v Flex 4p Manual");
                        break;

                    case 2:
                        imgCarro.setImageResource(R.drawable.fiat_strada);
                        txtNome.setText("Strada");
                        txtMarca.setText("Fiat");
                        txtAno.setText("2022");
                        txtCor.setText("Branco");
                        txtMotor.setText("1.3 Firefly Flex");
                        txtModelo.setText("Freedom CD 1.3 Flex 8V Manual");
                        break;

                    case 3:
                        imgCarro.setImageResource(R.drawable.hyundai_hb20);
                        txtNome.setText("HB20");
                        txtMarca.setText("Hyundai");
                        txtAno.setText("2021");
                        txtCor.setText("Prata");
                        txtMotor.setText("1.0 Turbo GDI");
                        txtModelo.setText("Comfort Plus 1.0 TGDI Flex Automático");
                        break;

                    case 4:
                        imgCarro.setImageResource(R.drawable.renaul_kwid);
                        txtNome.setText("Kwid");
                        txtMarca.setText("Renault");
                        txtAno.setText("2023");
                        txtCor.setText("Cinza");
                        txtMotor.setText("1.0 SCe 12V");
                        txtModelo.setText("Outsider 1.0 Flex 12V 5p Manual");
                        break;

                    case 5:
                        imgCarro.setImageResource(R.drawable.volkswagen_polo);
                        txtNome.setText("Polo");
                        txtMarca.setText("Volkswagen");
                        txtAno.setText("2020");
                        txtCor.setText("Azul");
                        txtMotor.setText("1.0 TSI");
                        txtModelo.setText("Comfortline 200 TSI 1.0 Flex 5p Automático");
                        break;

                    default:
                        imgCarro.setImageResource(R.drawable.erro);
                        txtNome.setText("");
                        txtMarca.setText("");
                        txtAno.setText("");
                        txtCor.setText("");
                        txtMotor.setText("");
                        txtModelo.setText("");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }
}