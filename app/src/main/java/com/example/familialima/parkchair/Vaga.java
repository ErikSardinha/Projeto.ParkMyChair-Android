package com.example.familialima.parkchair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Vaga extends AppCompatActivity, Localizacao {

    String endereco;
    String tipo;

    public Vaga(String, endereco, String tipo, int Lat, int Long){
        this.endereco = endereco;
        this.tipo = tipo;
        super(Lat, Long);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaga);
    }
}
