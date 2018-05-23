package com.example.familialima.parkchair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void registrar(String nome, String email, String confE, String senha, String confS){
        String nomeUsuario = nome;
        String email = email;
        String confEmail = confE;
        String senha = senha;
        String confSenha = confS;

        if(email == confEmail){
            if(senha == confSenha){
                //enviar cadastro para banco
            }
            else{
                //senhas diferentes
            }
        }
        else{
            //Pop-Up avisando que o email está invalido
        }
    };
}
