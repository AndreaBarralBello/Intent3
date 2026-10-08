package com.example.intent1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        TextView textView = findViewById(R.id.tvResultado);
        Intent intent = getIntent(); // El intent que inició esta actividad

        String mensajeRecibido = null;

        // 1. Verificar si fue un intento implícito (Compartir desde otra app)
        if (Intent.ACTION_SEND.equals(intent.getAction()) && intent.getType() != null && intent.getType().startsWith("text/")) {
            mensajeRecibido = intent.getStringExtra(Intent.EXTRA_TEXT);
        }
        // 2. Si no, verificar si fue un intento explícito (Desde nuestra MainActivity)
        else {
            mensajeRecibido = intent.getStringExtra("MENSAJE");
        }

        // Mostrar el resultado o un mensaje por defecto
        if (mensajeRecibido != null && !mensajeRecibido.isEmpty()) {
            textView.setText(mensajeRecibido);
        } else {
            textView.setText("No se recibió ningún mensaje válido.");
        }
    }
}