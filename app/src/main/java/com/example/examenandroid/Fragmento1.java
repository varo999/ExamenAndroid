package com.example.examenandroid;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragmento1 extends Fragment {

    private EditText editText;
    private SeekBar seekBar;
    private Button buttonChangeText;

    public Fragmento1() {
        // Constructor vacío necesario
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout de este fragmento
        View rootView = inflater.inflate(R.layout.fragmento1, container, false);

        editText = rootView.findViewById(R.id.editText);
        seekBar = rootView.findViewById(R.id.seekBarSize);
        buttonChangeText = rootView.findViewById(R.id.buttonChangeText);

        buttonChangeText.setOnClickListener(v -> {
            // Código que se ejecuta cuando el botón es presionado
            int textSize = seekBar.getProgress();
            String text = editText.getText().toString();

            // Llamar al método de la actividad (MainActivity)
            ((MainActivity) getActivity()).changeTextSize(textSize, text);
        });


        return rootView;
    }
}