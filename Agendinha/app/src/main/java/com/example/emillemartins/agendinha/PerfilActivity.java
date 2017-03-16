package com.example.emillemartins.agendinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.emillemartins.agendinha.core.Controller;

public class PerfilActivity extends AppCompatActivity {

    private EditText etPerfil;
    private String nomePerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        etPerfil = (EditText) findViewById(R.id.etPerfil);



    }
        public void voltar(View view){

            nomePerfil = etPerfil.getText().toString();
            Controller.getInstance().setValue(nomePerfil);
            Intent intent = new Intent(PerfilActivity.this, MainActivity.class);
            startActivity(intent);
            finish();


    }




    }

