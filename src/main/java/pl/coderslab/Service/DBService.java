package pl.coderslab.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBService {

    public static Connection getConnection(String database) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + database +"?useUnicode=yes&characterEncoding=UTF-8" +
                        "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root",
                "coderslab");
    }


    // for update and delete
    public static void executeUpdate(String database, String query, List<String> parameters) throws SQLException{
        try(Connection connection = getConnection(database)){
            // prepare a query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // set parameters for query
            if(parameters != null){
                for (int i =0; i<parameters.size(); i++){
                    preparedStatement.setString(i+1, parameters.get(i));
                }
            }
            // execute query
            preparedStatement.executeUpdate();
            System.out.println("Query completed");

        }catch (SQLException e){
            System.out.println(e);
        }
    }


    // adding to the db (this method returns the primary key of the added object)
    public static Integer executeInsert(String database, String query, List<String> parameters) throws SQLException{
        Integer generatedId = null;
        try(Connection connection = getConnection(database)){
            // prepare a query and get generated key
            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            // set parameters for the query
            if(parameters != null){
                for(int i=0; i<parameters.size(); i++){
                    preparedStatement.setString(i+1, parameters.get(i));
                }
            }
            // execute query
            preparedStatement.executeUpdate();
            System.out.println("Insert completed");
            // get new id
            try(ResultSet generatedKey = preparedStatement.getGeneratedKeys()){
                generatedId = generatedKey.getInt(1);
            }catch(SQLException e){
                System.out.println("Creating user failed, no id obtained");
                System.out.println(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return generatedId;
    }


    // get by id or find all and return as a List of Maps
    public static List<Map<String, String>> executeSelect(String database, String query, List<String> parameters) throws  SQLException {
        List<Map<String, String>> dbSelect = new ArrayList<>();
        try(Connection connection = getConnection(database)) {
            // prepare query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // set parameters for query
            if (parameters != null) {
                for (int i = 0; i < parameters.size(); i++) {
                    preparedStatement.setString(i + 1, parameters.get(i));
                }
            }
            // execute query and get results
            preparedStatement.executeQuery();
            // get db results from query
            ResultSet resultSet = preparedStatement.getResultSet();
            // get metadata (number of columns, names, etc.) from resultSet
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            // build result for function
            if(resultSet != null){
                // get each row from executed query
                while(resultSet.next()){
                    // create Map for data in row
                    Map<String, String> rowResult = new HashMap<>();
                    // get column name and value and put into map
                    for(int i=1; i<+columns; i++){
                        rowResult.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
                    }
                    // add results to global list
                    dbSelect.add(rowResult);
                }
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return dbSelect;
    }


}
