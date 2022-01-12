package school.studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaselink;

    public Connection getConnection(){
        String databaseUser = "root";
        String databaseName = "institution_database";
        String databasePassword = "willywillywils";
        String database_port = "3308";
        String url = "jdbc:mysql://localhost:"+database_port+ "/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("There is an error");

        }
        return  databaselink;
    }
}
