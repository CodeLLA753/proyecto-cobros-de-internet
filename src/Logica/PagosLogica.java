package Logica;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class PagosLogica {

    Conexion cn = new Conexion();

    public DefaultTableModel listarPagos() {

    DefaultTableModel modelo = new DefaultTableModel();

    modelo.addColumn("ID Pago");
    modelo.addColumn("Cliente");
    modelo.addColumn("Servicio");
    modelo.addColumn("Monto");
    modelo.addColumn("Fecha");
    modelo.addColumn("Metodo");
    modelo.addColumn("Mes");
    modelo.addColumn("Estado");

    String sql = """
        SELECT 
            p.IdPago,
            CONCAT(c.Nombre, ' ', c.APaterno) AS Cliente,
            s.TipoServicio,
            p.MontoPagado,
            p.FechaPago,
            mp.MetodoPago,
            m.NombreMes,
            e.NombreEstado
        FROM Pagos p
        JOIN Cliente_Servicio cs ON p.IdCliente_Servicio = cs.IdCliente_Servicio
        JOIN Cliente c ON cs.IdCliente = c.IdCliente
        JOIN Servicio s ON cs.IdServicio = s.IdServicio
        JOIN MetodoPago mp ON p.IdMetodoPago = mp.IdMetodoPago
        JOIN Mes m ON p.IdMes = m.IdMes
        JOIN Estado e ON p.IdEstado = e.IdEstado
    """;

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Object[] fila = {
                rs.getInt("IdPago"),
                rs.getString("Cliente"),
                rs.getString("TipoServicio"),
                rs.getDouble("MontoPagado"),
                rs.getDate("FechaPago"),
                rs.getString("MetodoPago"),
                rs.getString("NombreMes"),
                rs.getString("NombreEstado")
            };
            modelo.addRow(fila);
        }

    } catch (Exception e) {
        System.out.println("Error al listar pagos: " + e.getMessage());
    }

    return modelo;
}
    public boolean registrarPago(int idClienteServicio,
                             double monto,
                             String fecha,
                             int idMetodoPago,
                             int idMes,
                             int idEstado,
                             int idPersonal) {

    String sql = """
        INSERT INTO Pagos
        (IdCliente_Servicio, MontoPagado, FechaPago,
         IdMetodoPago, IdMes, IdEstado, IdPersonal)
        VALUES (?, ?, ?, ?, ?, ?, ?)
    """;

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idClienteServicio);
        ps.setDouble(2, monto);
        ps.setString(3, fecha);
        ps.setInt(4, idMetodoPago);
        ps.setInt(5, idMes);
        ps.setInt(6, idEstado);
        ps.setInt(7, idPersonal);

        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Pago registrado correctamente");
            return true;
        }

    } catch (Exception e) {
        System.out.println("Error al guardar pago: " + e.getMessage());
    }

    return false;
}

}
