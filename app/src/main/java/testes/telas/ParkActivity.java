package testes.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import testes.telas.dao.VagaDao;
import testes.telas.modelos.Vaga;

public class ParkActivity extends AppCompatActivity {

    private RadioGroup zonas;
    private RadioButton zona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        zonas = (RadioGroup) findViewById(R.id.zonas);
        Button btSend = (Button) findViewById(R.id.btSend);
        final Intent map = new Intent (this, MapActivity.class);
        btSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tLugar = (TextView) findViewById(R.id.tLugar);
                TextView CEP = (TextView) findViewById(R.id.tCEP);
                TextView tRua = (TextView) findViewById(R.id.tRua);
                TextView tBairro = (TextView) findViewById(R.id.tBairro);
                String nome = tLugar.getText().toString();
                String cepStr = CEP.getText().toString();
                Integer cep = Integer.parseInt(cepStr);
                String rua = tRua.getText().toString();
                String bairro = tBairro.getText().toString();
                int selectedId = zonas.getCheckedRadioButtonId();
                zona = (RadioButton) findViewById(selectedId);
                String zone = String.valueOf(zona.getText());

                //Iniciando classes
                Vaga vaga =  new Vaga();
                VagaDao vagaDao = new VagaDao(ParkActivity.this);

                //Definindo Atributos
                vaga.setPlace(nome);
                vaga.setCep(cep);
                vaga.setStreet(rua);
                vaga.setNbhood(bairro);
                vaga.setZone(zone);
                vaga.setLatLong(cep);

                //Enviar para o Banco
                vagaDao.savePark(vaga);
                alert("Vaga enviada para votação");
                startActivity(map);
                finish();
            }
        });
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
