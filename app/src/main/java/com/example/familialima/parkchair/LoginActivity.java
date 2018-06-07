package testes.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btRegister = (Button) findViewById(R.id.btRegister);
        Button btLogar = (Button) findViewById(R.id.btLogar);
        final Intent register = new Intent(this,RegisterActivity.class);
        //final Intent map = new Intent(this, MapActivity);
        btRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(register);
            }
        });
        btLogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();
                //Teste de Logar
                if (login.equals("teste")&&senha.equals("teste")){
                    alert("Login Realizado com Sucesso");

                    //startActivity(map);
                   //finish();
                }else{
                    alert("Usuário ou Senha incorretos");
                }
            }
        });
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
