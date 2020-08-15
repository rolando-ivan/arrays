package com.example.ivan;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edit_text_nombres_para_lista, edit_text_retirar_nombre_lista;
    private TextView textViewListaDeUsuarios, textViewListaDeUsuarios1;
    private ArrayList<String> listaDeNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeNombres = new ArrayList<>();

        textViewListaDeUsuarios = findViewById(R.id.textView);
        textViewListaDeUsuarios1 = findViewById(R.id.textView1);
        edit_text_nombres_para_lista = findViewById(R.id.editTextAgregar);
        edit_text_retirar_nombre_lista = findViewById(R.id.editTextRetirar);

        final RelativeLayout contenedor = findViewById(R.id.contenedor);
        final ImageView imagen_menu = findViewById(R.id.foto_menu);

        final RelativeLayout tapa_filtrar = findViewById(R.id.tapa_filtrar);
        final ImageView barra_filtrado = findViewById(R.id.mostrar_barra_filtrado);
        barra_filtrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animacionX = ObjectAnimator.ofFloat(tapa_filtrar, "x", -720f);
                animacionX.setDuration(1500);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animacionX);
                animatorSet.start();
            }
        });

        Button agregar = findViewById(R.id.imagen_agregar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animacionX = ObjectAnimator.ofFloat(contenedor, "x", 0f);
                animacionX.setDuration(1000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animacionX);
                animatorSet.start();
            }
        });

        Button quitar = findViewById(R.id.imagen_quitar);
        quitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animacionX = ObjectAnimator.ofFloat(contenedor, "x", -720f);
                animacionX.setDuration(1000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animacionX);
                animatorSet.start();
            }
        });

        imagen_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CuadroMenu(MainActivity.this);
            }
        });
    }


    @SuppressLint("SetTextI18n")
    public void mostrar (View view){
        String nombre2 = edit_text_nombres_para_lista.getText().toString();
        listaDeNombres.add(nombre2);
        edit_text_nombres_para_lista.setText("");
        StringBuilder totalNombre = new StringBuilder();
        for (String item : listaDeNombres){
            totalNombre.append(item).append("\n");
        }
        textViewListaDeUsuarios.setText("Lista de Usuarios" + "\n" + totalNombre.toString());
    }


    @SuppressLint("SetTextI18n")
    public void retirar(View view){
        String nombre = edit_text_retirar_nombre_lista.getText().toString();
        listaDeNombres.remove(nombre);
        edit_text_retirar_nombre_lista.setText("");
        StringBuilder totalNombre = new StringBuilder();
        for (String item : listaDeNombres){
            totalNombre.append(item).append("\n");
        }
        textViewListaDeUsuarios1.setText("Lista Modificada" + "\n" + totalNombre.toString());
    }
}