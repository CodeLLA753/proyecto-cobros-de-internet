package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection conectar() {

        try {
            String url = "jdbc:mysql://localhost:3306/Internet?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String pass = "";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado correctamente");
            return cn;

        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return null;
        }
    }
}
