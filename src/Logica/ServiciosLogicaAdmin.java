package Logica;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiciosLogicaAdmin {

    // Listar clientes con sus servicios
    public ResultSet listarClientesServicios() {

    String sql = """
        SELECT 
            s.IdServicio,
            CONCAT(c.Nombre, ' ', c.APaterno) AS Cliente,
            s.TipoServicio,
            s.Costo,
            cs.FechaInstalacion
        FROM Cliente_Servicio cs
        INNER JOIN Cliente c ON cs.IdCliente = c.IdCliente
        INNER JOIN Servicio s ON cs.IdServicio = s.IdServicio
    """;

    try {
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        return ps.executeQuery();
    } catch (SQLException e) {
        System.out.println("Error SQL: " + e.getMessage());
        return null;
    }
}


    // Actualizar costo del servicio
    public boolean actualizarPrecio(int idServicio, double nuevoPrecio) {

    String sql = "UPDATE Servicio SET Costo = ? WHERE IdServicio = ?";

    try {
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, nuevoPrecio);
        ps.setInt(2, idServicio);

        int filas = ps.executeUpdate();

        System.out.println("Actualizado ID: " + idServicio + 
                           " Filas afectadas: " + filas);

        return filas > 0;

    } catch (Exception e) {
        System.out.println("Error al actualizar: " + e.getMessage());
        return false;
    }
}
}



