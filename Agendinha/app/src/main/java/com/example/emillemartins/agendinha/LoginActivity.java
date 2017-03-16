package com.example.emillemartins.agendinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btEntrar = (Button) findViewById(R.id.btEntrar);
        btEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText etLogin = (EditText) findViewById(R.id.etLogin);
                EditText etSenha = (EditText) findViewById(R.id.etSenha);

                String login = etLogin.getText().toString();
                String senha = etSenha.getText().toString();

                if(login.equals("emille")&&senha.equals("123")){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    alert("Ok");
                }else{
                    alert("Deu ruim");

                }

            }
        }
        );

    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }
}
