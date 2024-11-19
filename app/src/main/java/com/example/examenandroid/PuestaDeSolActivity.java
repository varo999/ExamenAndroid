package com.example.examenandroid;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.FrameLayout; // Importar FrameLayout
import androidx.appcompat.app.AppCompatActivity;

public class PuestaDeSolActivity extends AppCompatActivity { // Extiende correctamente AppCompatActivity

    private ImageView sun;
    private FrameLayout cielo;
    private ImageView emojiFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puesta_de_sol); // Asegúrate de que el archivo XML sea el correcto

        // Inicializa las vistas
        sun = findViewById(R.id.sun); // Asegúrate de que el ID de la imagen del sol esté correcto
        cielo = findViewById(R.id.cielo); // Asegúrate de que el ID del FrameLayout del cielo esté correcto
        emojiFace = findViewById(R.id.emoji_face);

        // Configura el clic sobre el cielo
        cielo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSunsetAnimation();
            }
        });
        // Configura el clic sobre el emoticono de la cara
        emojiFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para ir a MainActivity
                Intent intent = new Intent(PuestaDeSolActivity.this, MainActivity.class);
                startActivity(intent); // Inicia la actividad MainActivity
            }
        });
    }

    // Método para iniciar la animación del atardecer
    private void startSunsetAnimation() {
        // Mover el sol hacia abajo (fuera de la pantalla)
        ObjectAnimator sunAnimator = ObjectAnimator.ofFloat(sun, "translationY", 0f, 1000f); // Mueve el sol más abajo (ajusta 1000f según el tamaño de la pantalla)
        sunAnimator.setDuration(6000); // Duración de la animación del sol (3 segundos)

        // Hacer que el sol se desvanezca mientras se mueve hacia abajo (opacidad)
        ObjectAnimator sunAlphaAnimator = ObjectAnimator.ofFloat(sun, "alpha", 1f, 0f); // De 100% opaco a 0% (invisible)
        sunAlphaAnimator.setDuration(6000); // Duración de la animación de la opacidad (3 segundos)

        // Cambiar el color del cielo (de azul claro a naranja y luego a oscuro)
        ObjectAnimator cieloColorAnimator = ObjectAnimator.ofArgb(
                cielo,
                "backgroundColor",
                getResources().getColor(R.color.sky_blue),   // Color inicial: cielo azul
                getResources().getColor(R.color.sky_orange), // Color intermedio: atardecer naranja
                getResources().getColor(R.color.sky_dark)    // Color final: cielo oscuro
        );
        cieloColorAnimator.setDuration(4500); // Duración de la animación del cielo (4.5 segundos)

        // Combinamos las animaciones
        sunAnimator.start();
        sunAlphaAnimator.start(); // Esta animación hace que el sol se desvanezca
        cieloColorAnimator.start();
    }

}
