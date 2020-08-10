package com.example.ivan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edit_text_nombres_para_lista;
    private ImageView agregar, quitar;
    private TextView textViewListaDeUsuarios;
    private ArrayList<String> listaDeNombres;
    //private int index =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewListaDeUsuarios = findViewById(R.id.textView);
        edit_text_nombres_para_lista = findViewById(R.id.editText);
        agregar = findViewById(R.id.imagen_agregar);
        quitar = findViewById(R.id.imagen_quitar);

        String nombre1 = "Juan";

        listaDeNombres = new ArrayList<>();
        listaDeNombres.add(nombre1);
        listaDeNombres.add("Pedro");
        listaDeNombres.add("Leiva");
        listaDeNombres.add("Rolando");
        /*listaDeNombres.remove(nombre1);
        //listaDeNombres.remove("Juan"); No funciona porque la bariable la crea la computadora*/
    }

    public void mostrar (View view){
        /*final int intervalo = 1000;
        int timepo = 0;*/
        String nombre2 = edit_text_nombres_para_lista.getText().toString();
        listaDeNombres.add(nombre2);
        edit_text_nombres_para_lista.setText("");

        String totalNombre = "" ;

        for (String item : listaDeNombres){
/* new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    textViewListaDeUsuarios.setText(listaDeNombres.get(index));
                    index++;
                }
            }, timepo);

            timepo += intervalo;*/      totalNombre += "\n" + item;
        }
        textViewListaDeUsuarios.setText(totalNombre);
    }
    public void retirar(View view){
        String nombre = edit_text_nombres_para_lista.getText().toString();
        listaDeNombres.remove(nombre);
        edit_text_nombres_para_lista.setText("");

        String totalNombre = "" ;

        for (String item : listaDeNombres){
            totalNombre += "\n" + item;
        }
        textViewListaDeUsuarios.setText(totalNombre);
    }
}