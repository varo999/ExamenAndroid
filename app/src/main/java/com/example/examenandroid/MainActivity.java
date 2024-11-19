package com.example.examenandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Fragmento2 fragmento2; // Referencia a Fragmento2
    private ImageView emojiMoon; // Para referenciar el emoticono de la luna

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa el ImageView del emoticono de la luna
        emojiMoon = findViewById(R.id.emoji_moon);

        // Si no se ha guardado el estado, inflamos los fragmentos
        if (savedInstanceState == null) {
            // Inflar y agregar Fragmento1
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentFirstContainer, new Fragmento1())
                    .commit();

            // Inflar y agregar Fragmento2
            fragmento2 = new Fragmento2();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentSecondContainer, fragmento2)
                    .commit();

            // Inflar y agregar Fragmento3
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentThirdContainer, new Fragmento3())
                    .commit();
        }

        // Agregar el OnClickListener para emojiMoon
        emojiMoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad PuestaDeSolActivity
                Intent intent = new Intent(MainActivity.this, PuestaDeSolActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método para cambiar el tamaño y el texto de Fragmento2
    public void changeTextSize(int size, String text) {
        if (fragmento2 != null) {
            // Pasamos el tamaño como float
            fragmento2.updateText(text, (float) size);
        }
    }

    // Método para cambiar el color del texto en Fragmento2
    public void changeTextColor(int red, int green, int blue) {
        if (fragmento2 != null) {
            fragmento2.updateColor(red, green, blue);
        }
    }
}
