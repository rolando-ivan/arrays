package com.example.ivan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edit_text_nombres_para_lista, edit_text_retirar_nombre_lista;
    private TextView textViewListaDeUsuarios;
    private ArrayList<String> listaDeNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout menu = findViewById(R.id.menu);
        final ImageView menu1 = findViewById(R.id.menu1);
        textViewListaDeUsuarios = findViewById(R.id.textView);
        edit_text_nombres_para_lista = findViewById(R.id.editTextAgregar);
        edit_text_retirar_nombre_lista = findViewById(R.id.editTextRetirar);
        final ConstraintLayout contenedor = findViewById(R.id.contenedor);
        Button agregar = findViewById(R.id.imagen_agregar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animacionX = ObjectAnimator.ofFloat(contenedor, "x", 0f);
                animacionX.setDuration(2000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animacionX);
                animatorSet.start();
            }
        });
        Button quitar = findViewById(R.id.imagen_quitar);
        quitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animacionX = ObjectAnimator.ofFloat(contenedor, "x", -716f);
                animacionX.setDuration(2000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animacionX);
                animatorSet.start();
            }
        });
        ImageView imagen_menu = findViewById(R.id.foto_menu);
        imagen_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu1.setVisibility(View.VISIBLE);
                ObjectAnimator animacionA = ObjectAnimator.ofFloat(menu1, "alpha", 0f, 1f);
                ObjectAnimator animacionX = ObjectAnimator.ofFloat(menu, "x", 0f);
                animacionA.setDuration(2500);
                animacionX.setDuration(1000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animacionX, animacionA);
                animatorSet.start();
            }
        });
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animacionA = ObjectAnimator.ofFloat(menu1, "alpha", 1f, 0f);
                ObjectAnimator animacionX = ObjectAnimator.ofFloat(menu, "x", -500f);
                animacionA.setDuration(500);
                animacionX.setDuration(1500);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animacionX, animacionA);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        menu1.setVisibility(View.GONE);
                    }
                });
                animatorSet.start();
            }
        });
        listaDeNombres = new ArrayList<>();
    }
    public void mostrar (View view){
        String nombre2 = edit_text_nombres_para_lista.getText().toString();
        listaDeNombres.add(nombre2);
        edit_text_nombres_para_lista.setText("");
        StringBuilder totalNombre = new StringBuilder();
        for (String item : listaDeNombres){
            totalNombre.append("\n").append(item);
        }
        textViewListaDeUsuarios.setText(totalNombre.toString());
    }
    public void retirar(View view){
        String nombre = edit_text_retirar_nombre_lista.getText().toString();
        listaDeNombres.remove(nombre);
        edit_text_retirar_nombre_lista.setText("");
        StringBuilder totalNombre = new StringBuilder();
        for (String item : listaDeNombres){
            totalNombre.append("\n").append(item);
        }
        textViewListaDeUsuarios.setText(totalNombre.toString());
    }
}