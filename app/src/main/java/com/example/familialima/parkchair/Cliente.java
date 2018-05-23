package com.example.familialima.parkchair;

public class Cliente extends Localizacao{
    String nome;
    String email;
    String senha;

    public Cliente(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


}