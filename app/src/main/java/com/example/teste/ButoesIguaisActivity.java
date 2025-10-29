package com.example.teste;

import android.app.Activity;
import android.widget.Button;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;

public class ButoesIguaisActivity {

    public static void configurarBotaoVoltar(Activity activity, Button btnVoltar) {
        btnVoltar.setOnClickListener(v -> activity.finish());
    }

    /*public static void configurarBotaoAbrirSite(Button btnSite, String url, Context context) {
        btnSite.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        });
    }*/

}

