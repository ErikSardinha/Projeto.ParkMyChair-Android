package testes.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class ParkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
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
                String cep = CEP.getText().toString();
                String rua = tRua.getText().toString();
                String bairro = tBairro.getText().toString();
                //String zona;
                // O Checkbox ira alterar zona (ex: zona = "Sul")
                // Essas variaveis serão usadas para envio dos dados para o banco
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
