package factory;

import java.sql.*;

public class Conector {

    //ele é estatico
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String banco = "bikeshop2";
            String usuario = "root";
            String senha = "";

            return DriverManager.getConnection(url + banco, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }

    }

}
