package com.example.lab3;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // =============== Déclaration des champs de saisie =====================
    private EditText nom, email, phone, adresse, ville;

    //  ============================= Déclaration du bouton =========================
    private Button btnEnvoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ======================= Récupération des vues par leurs IDs =====================
        nom     = findViewById(R.id.nom);
        email   = findViewById(R.id.email);
        phone   = findViewById(R.id.phone);
        adresse = findViewById(R.id.adresse);
        ville   = findViewById(R.id.ville);
        btnEnvoyer = findViewById(R.id.btnEnvoyer);

        btnEnvoyer.setOnClickListener(v -> {

            String sNom     = nom.getText().toString().trim();
            String sEmail   = email.getText().toString().trim();
            String sPhone   = phone.getText().toString().trim();
            String sAdresse = adresse.getText().toString().trim();
            String sVille   = ville.getText().toString().trim();

            // ====================== Vérification du remplissage des champs ===================
            if (sNom.isEmpty() || sEmail.isEmpty()) {
                Toast.makeText(this, "Les champs Nom et Email sont obligatoires.", Toast.LENGTH_SHORT).show();
                return; // stoppe l'envoi
            }

            Intent i = new Intent(MainActivity.this, Fenetre2Activity.class);

            i.putExtra("nom", sNom);
            i.putExtra("email", sEmail);
            i.putExtra("phone", sPhone);
            i.putExtra("adresse", sAdresse);
            i.putExtra("ville", sVille);

            startActivity(i);
        });
    }
}