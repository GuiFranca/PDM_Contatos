package com.example.contatos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contatos.dao.ContatoDAO;
import com.example.contatos.model.Contato;

public class AdicionaContato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adiciona_contato);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btSalvarContato = findViewById(R.id.btSalvarContato);
        btSalvarContato.setOnClickListener(v -> {
            salvaContato();
            navegaHome();
        });
    }

    private void navegaHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void salvaContato() {
        EditText etNome = findViewById(R.id.etNome);
        ContatoDAO contatoDAO = new ContatoDAO(this);

        Contato contato = new Contato(1, etNome.getText().toString());

        contatoDAO.inserirContato(contato);

    }
}