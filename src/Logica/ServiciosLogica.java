package Logica;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiciosLogica {

    public ResultSet listarClientesServicios() {

        String sql = """
            SELECT 
                c.nombre AS cliente,
                s.nombre_servicio AS servicio,
                s.precio
            FROM clientes c
            INNER JOIN servicios s ON c.id_cliente = s.id_cliente
        """;

        try {
            Connection conn = Conexion.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            return null;
        }
    }
}
