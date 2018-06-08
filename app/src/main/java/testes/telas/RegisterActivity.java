package testes.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btSend = (Button) findViewById(R.id.btSend);
        final Intent map = new Intent (this, MapActivity.class);
        btSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                TextView tUsuario = (TextView) findViewById(R.id.tUsuario);
                TextView tEmail = (TextView) findViewById(R.id.tEmail);
                TextView confEmail = (TextView) findViewById(R.id.confEmail);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);
                TextView confSenha = (TextView) findViewById(R.id.confSenha);

                String nome = tUsuario.getText().toString();
                String email = tEmail.getText().toString();
                String confE = confEmail.getText().toString();
                String senha = tSenha.getText().toString();
                String confS = confSenha.getText().toString();
                //Strings para envio para o BD

                // Verificação de informações
                if (email.equals(confE)){
                    if (senha.equals(confS)){
                        alert("Sucesso! Confirme sua conta atráves do email de Verificação");
                        startActivity(map);
                        finish();
                    }else{
                        alert("Senhas não correspondem");
                    }
                }else{
                    alert("Emails não correspondem");
                }
            }
        });
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }


}
