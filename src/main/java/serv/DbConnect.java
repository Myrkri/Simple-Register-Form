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

     boolean insertDB(String name, String pass) throws Exception {
            boolean check = true;

        PreparedStatement preparedStatement = senData().prepareStatement("INSERT INTO TEST.PUBLIC.USERS (NAME , PASSWORD) Values (?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pass);

        try {
            preparedStatement.executeUpdate();
            senData().close();
        }catch (JdbcSQLIntegrityConstraintViolationException ex){

            System.out.println("Username already exists!");
            check = false;
        }
        return check;
    }

    ResultSet selectData(String name) throws Exception {

        PreparedStatement preparedStatement = senData().prepareStatement("SELECT * from TEST.PUBLIC.USERS where NAME=?");
        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();

        senData().close();

        return resultSet;
    }
}



