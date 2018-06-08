package testes.telas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import testes.telas.modelos.Cliente;
import testes.telas.modelos.Vaga;

public class VagaDao extends SQLiteOpenHelper{

    private static final String NOME_BD = "ParkChair.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "vaga";
    private static final String ID = "id";
    private static final String LUGAR = "lugar";
    private static final String CEP = "cep";
    private static final String RUA = "rua";
    private static final String BAIRRO = "bairro";
    private static final String ZONA = "zona";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";

    public VagaDao(Context context) {
        super(context, NOME_BD , null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ TABELA+" ( "+
                " " +ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " " +LUGAR+" TEXT, "+CEP+" INTEGER, "+RUA+" TEXT, "+
                " " +BAIRRO+" TEXT, "+ZONA+" TEXT, "+LATITUDE+" FLOAT, "+
                " " +LONGITUDE+ " FLOAT );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    public long savePark(Vaga v){
        ContentValues values = new ContentValues();
        long retorno;

        values.put(LUGAR, v.getPlace());
        values.put(CEP,v.getCep());
        values.put(RUA,v.getStreet());
        values.put(BAIRRO,v.getNbhood());
        values.put(ZONA,v.getZone());
        values.put(LATITUDE,v.getLat());
        values.put(LONGITUDE,v.getLon());

        retorno = getWritableDatabase().insert(TABELA,null,values);
        return retorno;

    }

    public ArrayList<Vaga> selectAllVaga(){
        String[] coluns = {ID,LUGAR,CEP,RUA,BAIRRO,ZONA,LATITUDE,LONGITUDE};

        Cursor cursor = getWritableDatabase().query(TABELA,coluns,null,null,null,null,null,null);

        ArrayList<Vaga> vagas = new ArrayList<Vaga>();

        while (cursor.moveToNext()){
            Vaga v = new Vaga();

            v.setId(cursor.getInt(0));
            v.setPlace(cursor.getString(1));
            v.setCep(cursor.getInt(2));
            v.setStreet(cursor.getString(3));
            v.setNbhood(cursor.getString(4));
            v.setZone(cursor.getString(5));
            v.setLat(cursor.getFloat(6));
            v.setLon(cursor.getFloat(7));

            vagas.add(v);

        }
        return vagas;

    }

}
