package com.example.lab3;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Fenetre2Activity extends AppCompatActivity {

    private TextView recap;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre2);

        recap = findViewById(R.id.recap);
        btnRetour = findViewById(R.id.btnRetour);


        Intent intent = getIntent();

        // ======================= Extraction des données envoyées depuis MainActivity =================
        String nom     = intent.getStringExtra("nom");
        String email   = intent.getStringExtra("email");
        String phone   = intent.getStringExtra("phone");
        String adresse = intent.getStringExtra("adresse");
        String ville   = intent.getStringExtra("ville");

        // ======================== affichage multi-lignes ================================================
        String resume = "Nom : " + safe(nom) +
                "\nEmail : " + safe(email) +
                "\nPhone : " + safe(phone) +
                "\nAdresse : " + safe(adresse) +
                "\nVille : " + safe(ville);


        recap.setText(resume);

        // ======================== Bouton Retour  ========================================================
        btnRetour.setOnClickListener(v -> finish());
    }

    private String safe(String s) {
        return (s == null || s.trim().isEmpty()) ? "—" : s.trim();
    }
}
