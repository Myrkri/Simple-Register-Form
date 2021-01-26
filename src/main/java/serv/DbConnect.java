package serv;


import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public  class DbConnect {

        private Connection senData()
                throws Exception {
            Class.forName("org.h2.Driver");
           return DriverManager.
                    getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        }

     void insertDB(String name, String pass) throws Exception {

        PreparedStatement preparedStatement = senData().prepareStatement("INSERT INTO TEST.PUBLIC.USERS (NAME , PASSWORD) Values (?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pass);

        try {
            preparedStatement.executeUpdate();
            senData().close();
        }catch (JdbcSQLIntegrityConstraintViolationException ex){

            System.out.println("Username already exists!");                //TODO спросить про способ вывода всплывающего сообщения в браузере

        }
    }

    void selectData(String name) throws Exception {

        PreparedStatement preparedStatement = senData().prepareStatement("SELECT * from TEST.PUBLIC.USERS");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Name"));
            System.out.println(resultSet.getString("Password"));
        }
        senData().close();

    }
}



