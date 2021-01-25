package serv;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DbConnect {
        public Connection senData()
                throws Exception {
           return DriverManager.
                    getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        }

    public void insertDB(String name, String pass) throws Exception {

        //senData();

        //Class.forName("org.h2.Driver");
        Class.forName("com.mysql.jdbc.Driver");

        //Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");

        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO TEST.PUBLIC.USERS (NAME , PASSWORD) Values (?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pass);

        preparedStatement.executeUpdate();
    }

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from TEST.PUBLIC.USERS");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Name"));
            System.out.println(resultSet.getString("Password"));
        }

     /*   PreparedStatement prepar = conn.prepareStatement("INSERT INTO TEST.PUBLIC.USERS (NAME , PASSWORD) Values (?, ?)");
        prepar.setString(1, "Val");
        prepar.setString(2, "1234");

        prepar.executeUpdate();*/
    }
}



