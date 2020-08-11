package com.example.ivan;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edit_text_nombres_para_lista, edit_text_retirar_nombre_lista;
    private Button agregar, quitar;
    private Button agregar_lista, retirar_lista;
    private ImageView barra;
    private TextView textViewListaDeUsuarios;
    private ArrayList<String> listaDeNombres;
    long AnimationDuration = 1500;
    //private int index =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregar_lista = findViewById(R.id.agregar_lista);
        retirar_lista = findViewById(R.id.retirar_lista);
        textViewListaDeUsuarios = findViewById(R.id.textView);
        edit_text_nombres_para_lista = findViewById(R.id.editTextAgregar);
        edit_text_retirar_nombre_lista = findViewById(R.id.editTextRetirar);
        barra =findViewById(R.id.barra);
        agregar = findViewById(R.id.imagen_agregar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animacionXA = ObjectAnimator.ofFloat(agregar, "x", 735f);
                ObjectAnimator animacionXQ = ObjectAnimator.ofFloat(quitar, "x", 630f);
                ObjectAnimator animacionXB = ObjectAnimator.ofFloat(barra, "x", 710f);
                ObjectAnimator animacionXEditTextQuitar = ObjectAnimator.ofFloat(edit_text_retirar_nombre_lista, "x", 800f);
                ObjectAnimator animacionXEditTextAgregar = ObjectAnimator.ofFloat(edit_text_nombres_para_lista, "x", 100f);
                ObjectAnimator animacionXBotonQuitar = ObjectAnimator.ofFloat(retirar_lista, "x", 950f);
                ObjectAnimator animacionXBotonAgregar = ObjectAnimator.ofFloat(agregar_lista, "x", 255f);
                animacionXA.setDuration(AnimationDuration);
                animacionXQ.setDuration(AnimationDuration);
                animacionXB.setDuration(AnimationDuration);
                animacionXBotonQuitar.setDuration(AnimationDuration);
                animacionXEditTextQuitar.setDuration(AnimationDuration);
                animacionXEditTextAgregar.setDuration(AnimationDuration);
                animacionXBotonAgregar.setDuration(AnimationDuration);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animacionXA, animacionXQ, animacionXB, animacionXBotonQuitar, animacionXEditTextQuitar,
                        animacionXEditTextAgregar, animacionXBotonAgregar);
                animatorSet.start();
            }
        });
        quitar = findViewById(R.id.imagen_quitar);
        quitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animacionXQ = ObjectAnimator.ofFloat(quitar, "x", -80f);
                ObjectAnimator animacionXA = ObjectAnimator.ofFloat(agregar, "x", 20f);
                ObjectAnimator animacionXB = ObjectAnimator.ofFloat(barra, "x", 0f);
                ObjectAnimator animacionXEditTextQuitar = ObjectAnimator.ofFloat(edit_text_retirar_nombre_lista, "x", 100f);
                ObjectAnimator animacionXEditTextAgregar = ObjectAnimator.ofFloat(edit_text_nombres_para_lista, "x", -600f);
                ObjectAnimator animacionXBotonQuitar = ObjectAnimator.ofFloat(retirar_lista, "x", 255f);
                ObjectAnimator animacionXBotonAgregar = ObjectAnimator.ofFloat(agregar_lista, "x", -450f);
                animacionXQ.setDuration(AnimationDuration);
                animacionXA.setDuration(AnimationDuration);
                animacionXB.setDuration(AnimationDuration);
                animacionXBotonQuitar.setDuration(AnimationDuration);
                animacionXEditTextQuitar.setDuration(AnimationDuration);
                animacionXEditTextAgregar.setDuration(AnimationDuration);
                animacionXBotonAgregar.setDuration(AnimationDuration);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animacionXQ, animacionXA, animacionXB, animacionXBotonQuitar, animacionXEditTextQuitar,
                        animacionXEditTextAgregar, animacionXBotonAgregar);
                animatorSet.start();
            }
        });

        //String nombre1 = "Juan";

        listaDeNombres = new ArrayList<>();
        /*listaDeNombres.add(nombre1);
        listaDeNombres.add("Pedro");
        listaDeNombres.add("Leiva");
        listaDeNombres.add("Rolando");
        listaDeNombres.remove(nombre1);
        //listaDeNombres.remove("Juan"); No funciona porque la bariable la crea la computadora*/
    }

    public void mostrar (View view){
        /*final int intervalo = 1000;
        int timepo = 0;*/
        String nombre2 = edit_text_nombres_para_lista.getText().toString();
        listaDeNombres.add(nombre2);
        edit_text_nombres_para_lista.setText("");

        StringBuilder totalNombre = new StringBuilder();

        for (String item : listaDeNombres){
/* new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    textViewListaDeUsuarios.setText(listaDeNombres.get(index));
                    index++;
                }
            }, timepo);

            timepo += intervalo;*/      totalNombre.append("\n").append(item);
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