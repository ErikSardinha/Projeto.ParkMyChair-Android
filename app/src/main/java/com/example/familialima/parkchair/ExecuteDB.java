package com.example.familialima.parkchair;

public class ExecuteDB extends AsyncTask<String, Void, ResultSet>{

    private Connection connection;
    private String query;

    public ExecuteDB(Connection connection, String query){

        this.connection = connection;
        this.query = query;
    }

    @Override
    protected ResultSet do inBackground(String...params){
        ResultSet resultSet = null;

        try{
            resultSet = connection.prepareStatemente(query).executeQuery();
        }catch (Exception e){

        }finally {
            try{
                connection.close();
            }catch (Exception e){

            }
        }

        return resultSet;
    }
}