package testes.telas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import testes.telas.modelos.Cliente;
import testes.telas.modelos.Vaga;

public class ClienteDao extends SQLiteOpenHelper{

    private static final String NOME_BD = "ParkChair.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "cliente";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String EMAIL = "email";
    private static final String SENHA = "senha";

    public ClienteDao(Context context) {
        super(context, NOME_BD , null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ TABELA+" ( "+
                " " +ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " " +NOME+" TEXT, "+EMAIL+" TEXT, "+SENHA+" TEXT );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    public long saveClient(Cliente c){
        ContentValues values = new ContentValues();
        long retorno;

        values.put(NOME, c.getUsername());
        values.put(EMAIL,c.getMail());
        values.put(SENHA,c.getPassword());

        retorno = getWritableDatabase().insert(TABELA,null,values);
        return retorno;

    }

    public ArrayList<Cliente> selectAllCliente(){
        String[] coluns = {ID,NOME,EMAIL,SENHA};

        Cursor cursor = getWritableDatabase().query(TABELA,coluns,null,null,null,null,null,null);

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        while (cursor.moveToNext()){
            Cliente c = new Cliente();

            c.setId(cursor.getInt(0));
            c.setUsername(cursor.getString(1));
            c.setMail(cursor.getString(2));
            c.setPassword(cursor.getString(3));

            clientes.add(c);

        }
        return clientes;

    }

}
