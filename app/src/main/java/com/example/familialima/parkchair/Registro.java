package com.example.familialima.parkchair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void registrar(String nome, String mail, String confE, String pass, String confS){
        String nomeUsuario = nome;
        String email = mail;
        String confEmail = confE;
        String senha = pass;
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
    public void clickCancelar(){
        Intent login = new Intent(this, Login.class);
        startActivity(login);
    }
    public void clickConfirmar(){
        Intent confirm = new Intent(this, MapaLocais.class);
        startActivity(confirm);
    }
}
