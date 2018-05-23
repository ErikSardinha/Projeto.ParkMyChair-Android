package com.example.familialima.parkchair;

public class DB implements Runnable {

    private Connection conn;
    private String host = "";
    private String db ="android";
    private int port = 2345;
    private String user = "android";
    private String senha = "android";
    private String url = "jdbc";

    public DB(){

        this.url = String.format(this.url, this.host, this.port, this.db);

        this.conecta();
        this.desconecta();
    }

    @Override
    public void run(){
        try {
            Class.forNmae("com.example.familialima.parkchair.Driver");
            this.conn = DriverManager.getConnection(this.url, this.host, this.port, this.db, this.senha);

        }catch (Exception e){

        }
    }

    private void conecta(){
        Thread thread =  new Thread(this);
        thread.start();
        try{
            thread.join();

        }catch (Exception e){

        }

    }

    private void desconecta(){
        if(this.conn != null){
            try{
                conn.close();
            }catch (Exception e){

            }finally {
                this.conn = null
            }
        }
    }

    public ResultSet execute(String query){
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        }catch (Exception e){

        }

        return resultSet;
    }

}