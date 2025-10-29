package com.example.teste;

import android.app.Activity;
import android.content.Intent;
import android.hardware.biometrics.PromptContentItemPlainText;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//private boolean helloWorld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtUsuario = findViewById(R.id.txtUsuario);
        EditText txtSenha = findViewById(R.id.txtSenha);
        Button btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(v -> {
            String usuario = txtUsuario.getText().toString();
            String senha = txtSenha.getText().toString();

            if(usuario.equals("") && senha.equals("")){
                //txtUsuario.getScene().getWindow().hide();
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                //finish();
                //setContentView(R.layout.home);
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show();
            }
        });

        /*Referenciando os elementos da interface
        //TextView txvOla = findViewById(R.id.txvOla);
        //Button btnApp = findViewById(R.id.btnEntrar);

        //Definindo ação ao clicar no botão
        //btnApp.setOnClickListener(v -> {
            //helloWorld = txvOla.equals("Hello World!");
            if (txvOla.equals("Hello World!")){
                helloWorld = true;
            } else {
                helloWorld = false;
            }
            //helloWorld = txvOla.getText() == "Hello World!";
            if (!helloWorld) {
                txvOla.setText("Olá Mundo!");
                helloWorld = true;
            } else {
                txvOla.setText("Hello World!");
                helloWorld = false;
            }
        });*/
    }
}