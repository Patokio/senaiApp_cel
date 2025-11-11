package com.example.teste;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MercadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mercado);

        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        Button btnRemover = findViewById(R.id.btnRemover);
        ListView listMercado = findViewById(R.id.listMercado);
        EditText edtPesquisar = findViewById(R.id.edtPesquisar);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        TextView txtItem = findViewById(R.id.txtItem);
        ButoesIguaisActivity.configurarBotaoVoltar(this, btnVoltar);

        ArrayList<String> itens = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, itens);
        listMercado.setAdapter(adapter);
        listMercado.setOnItemClickListener((parent, view, position, id) -> {
            TextView textView = (TextView) view;
            textView.setTextColor(Color.BLACK);
        });

        btnAdicionar.setOnClickListener(v -> {
            String item = edtPesquisar.getText().toString().trim();

            if (!item.isEmpty()) {
                itens.add(item);
                adapter.notifyDataSetChanged();
                edtPesquisar.setText("");
            } else {
                Toast.makeText(this, "Digite um item!", Toast.LENGTH_SHORT).show();
            }
        });

        btnRemover.setOnClickListener(v -> {
            String item = edtPesquisar.getText().toString().trim();

            if(!item.isEmpty()){
                itens.remove(item);
                adapter.notifyDataSetChanged();
                edtPesquisar.setText("");
                Toast.makeText(this, "Item removido!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Item não encontrado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
