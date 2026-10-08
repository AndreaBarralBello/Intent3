package com.example.intent1;

import android.content.Intent;
import android.media.Image;
import android.widget.ImageView;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TerceraActivity extends AppCompatActivity {

    ImageView ivFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tercera);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });


        ivFoto = findViewById(R.id.ivFoto);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        // 2. Validar que sea una acción de envío y tipo imagen
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if (type.startsWith("image/")) {
                handleReceivedImage(intent);
            }
        }

    }

    private void handleReceivedImage(Intent intent) {
        // 3. Extraer la URI usando Intent.EXTRA_STREAM
        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);

        if (imageUri != null) {
            // 4. Utilizar la URI (por ejemplo, mostrarla en un ImageView)

            ivFoto.setImageURI(imageUri);
        }
    }
}