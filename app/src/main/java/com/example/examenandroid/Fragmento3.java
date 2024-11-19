package com.example.examenandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment; // Necesario para extender Fragment

public class Fragmento3 extends Fragment { // Extiende Fragment

    private SeekBar seekBarRed, seekBarGreen, seekBarBlue;
    private Button buttonChangeColor;

    public Fragmento3() {
        // Constructor vacío necesario
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout de este fragmento
        View rootView = inflater.inflate(R.layout.fragmento3, container, false);

        // Inicializar los SeekBars y el botón
        seekBarRed = rootView.findViewById(R.id.seekBarRed);
        seekBarGreen = rootView.findViewById(R.id.seekBarGreen);
        seekBarBlue = rootView.findViewById(R.id.seekBarBlue);
        buttonChangeColor = rootView.findViewById(R.id.buttonChangeColor);

        // Configurar el botón para cambiar el color
        buttonChangeColor.setOnClickListener(v -> {
            // Obtener el color RGB seleccionado de los SeekBars
            int red = seekBarRed.getProgress();
            int green = seekBarGreen.getProgress();
            int blue = seekBarBlue.getProgress();

            // Llamar al método en la actividad para cambiar el color del texto
            ((MainActivity) getActivity()).changeTextColor(red, green, blue);
        });

        return rootView;
    }
}
