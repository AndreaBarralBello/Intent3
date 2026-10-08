package com.example.intent1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.etMensaje);
        Button button = findViewById(R.id.btnEnviar);

        button.setOnClickListener(v -> {
            String mensaje = editText.getText().toString();

            // Crear Intent explícito
            Intent intent = new Intent(this, SegundaActivity.class);
            intent.putExtra("MENSAJE", mensaje);

            startActivity(intent);
        });
    }
}