package com.example.examenandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;  // Necesario para extender Fragment

public class Fragmento2 extends Fragment {  // Debe extender Fragment

    private TextView textView;

    public Fragmento2() {
        // Constructor vacío necesario
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout de este fragmento
        View rootView = inflater.inflate(R.layout.fragmento2, container, false);

        // Encontrar el TextView en el layout
        textView = rootView.findViewById(R.id.textView);

        return rootView;
    }

    // Método que recibe el texto y el tamaño, para actualizar el TextView
    public void updateText(String text, float textSize) {
        textView.setText(text);
        textView.setTextSize(textSize);
    }
    // Método para cambiar el color del texto en el TextView
    public void updateColor(int red, int green, int blue) {
        if (textView != null) {
            // Convertir los valores RGB a un solo color hexadecimal
            int color = (0xFF << 24) | (red << 16) | (green << 8) | blue;
            textView.setTextColor(color); // Establecer el color en el TextView
        }
    }
}

