package com.example.ivan;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

public class CuadroMenu {

    public CuadroMenu(final Context context){
        final Dialog dialogo = new Dialog(context);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogo.setCancelable(true);
        dialogo.setContentView(R.layout.menu);
        dialogo.show();

        final LinearLayout filtrar_nombre = dialogo.findViewById(R.id.filtrar_nombre);
        filtrar_nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialogo = new Dialog(context);
                dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogo.setCancelable(false);
                dialogo.setContentView(R.layout.filtrar_nombres);
                dialogo.show();

                final ConstraintLayout fondo_dialogo = dialogo.findViewById(R.id.fondo_dialogo);
                Animation animacion = AnimationUtils.loadAnimation(context, R.anim.animacion_menu);
                fondo_dialogo.startAnimation(animacion);

                Button cerrar_dialogo = dialogo.findViewById(R.id.cerrar_dialogo);
                cerrar_dialogo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogo.dismiss();
                    }
                });
            }
        });
        final LinearLayout libre = dialogo.findViewById(R.id.libre);


        final ConstraintLayout menudespegable = dialogo.findViewById(R.id.menu_desplegable);
        Animation animacion = AnimationUtils.loadAnimation(context, R.anim.animacion_menu);
        menudespegable.startAnimation(animacion);
    }
}
