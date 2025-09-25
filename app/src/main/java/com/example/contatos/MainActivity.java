package com.example.contatos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contatos.adapter.ContatoAdapter;
import com.example.contatos.dao.ContatoDAO;
import com.example.contatos.model.Contato;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FloatingActionButton fbAdicionar = findViewById(R.id.fbAdicionar);
        fbAdicionar.setOnClickListener( v -> {
            Intent intent = new Intent(this, AdicionaContato.class);
            startActivity(intent);
            finish();
        });

        loadContatos();
    }

    private void loadContatos() {
        ContatoDAO contatoDAO = new ContatoDAO(this);

//        Contato c1 = new Contato(1, "Contato 01");
//        Contato c2 = new Contato(2, "Contato 02");
//        Contato c3 = new Contato(3, "Contato 03");

//        contatoDAO.inserirContato(c1);
//        contatoDAO.inserirContato(c2);
//        contatoDAO.inserirContato(c3);

        List<Contato> contatos = contatoDAO.listarContatos();

        ContatoAdapter contatoAdapter = new ContatoAdapter(contatos, this);

        ListView lvContatos = findViewById(R.id.lvContatos);
        lvContatos.setAdapter(contatoAdapter);
    }


}