package com.example.teste;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FuncionarioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.funcionario);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        EditText edtNome = findViewById(R.id.edtNome);
        EditText edtSalario = findViewById(R.id.edtSalario);
        TextView txtResulta = findViewById(R.id.txtResulta);
        EditText edtImposto = findViewById(R.id.edtImposto);
        EditText edtPorcentagem = findViewById(R.id.edtPorcentagem);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);

        btnCalcular.setOnClickListener(v -> {
            FuncionarioDominio funcionarioDominio = new FuncionarioDominio(edtNome.getText().toString(), Double.valueOf(edtSalario.getText().toString()),
                    Double.valueOf(edtImposto.getText().toString()), Double.valueOf(edtPorcentagem.getText().toString()));
            double saL = funcionarioDominio.salarioLiquido();
            double saAu = funcionarioDominio.aumento(funcionarioDominio.getPorcentagem());
            String nomeFunc = funcionarioDominio.getNome();
            String textSalarioAumento = "\nSalário Aumentado: " + saAu;
            String textSalarioLiquido = "\nSalário Liquido: " + saL;
            txtResulta.setText((nomeFunc + textSalarioLiquido + textSalarioAumento));
        });
    }
}
