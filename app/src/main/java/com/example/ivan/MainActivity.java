package com.example.ivan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textViewListaDeUsuarios;
    private ArrayList<String> listaDeNombres;
    private int index =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewListaDeUsuarios = findViewById(R.id.textView);

        String nombre1 = "Juan";

        listaDeNombres = new ArrayList<String>();
        listaDeNombres.add(nombre1);
        listaDeNombres.add("Juan");
        listaDeNombres.add("Pedro");
        listaDeNombres.add("Leiva");
        listaDeNombres.add("Rolando");
        listaDeNombres.add("Rolando1");
        listaDeNombres.remove(nombre1);
        listaDeNombres.remove("Juan");//No funciona porque la bariable la crea la computadora
    }

    public void mostrar (View view){
        final int intervalo = 1000;
        int timepo = 0;

        String totalNombre="";

        for (String item : listaDeNombres){

           /* new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    textViewListaDeUsuarios.setText(listaDeNombres.get(index));
                    index++;
                }
            }, timepo);

            timepo += intervalo;*/

           totalNombre += "\n"+ item;
        }

        textViewListaDeUsuarios.setText(totalNombre);

    }
}