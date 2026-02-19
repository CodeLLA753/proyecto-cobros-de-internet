package Logica;

import Dto.ClienteDto;
import Dto.EstadosDto;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteLogica {

    public boolean RegistrarCliente(ClienteDto clienteNuevo, EstadosDto estadoObj) {
        try (Connection conn = Conexion.conectar()) {

            // Insertar DIRECCION
            String sqlDir = "INSERT INTO Direccion (NombreCalle) VALUES (?)";
            PreparedStatement pstDir = conn.prepareStatement(sqlDir, PreparedStatement.RETURN_GENERATED_KEYS);
            pstDir.setString(1, clienteNuevo.Direccion);
            pstDir.executeUpdate();

            ResultSet rsDir = pstDir.getGeneratedKeys();
            rsDir.next();
            int idDireccion = rsDir.getInt(1);

            String sqlCli
                    = "INSERT INTO Cliente (Nombre, APaterno, AMaterno, Telefono, Correo, IdDireccion, IdEstado) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstCli = conn.prepareStatement(
                    sqlCli,
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            pstCli.setString(1, clienteNuevo.Nombre);
            pstCli.setString(2, clienteNuevo.APaterno);
            pstCli.setString(3,  clienteNuevo.AMaterno);
            pstCli.setString(4,  clienteNuevo.Telefono);
            pstCli.setString(5, clienteNuevo.Correo);
            pstCli.setInt(6, idDireccion);
            pstCli.setInt(7, estadoObj.IdEstado);
// INSERTAR CLIENTE
            pstCli.executeUpdate();
            ResultSet rsCli = pstCli.getGeneratedKeys();
            rsCli.next();
            int idCliente = rsCli.getInt(1);

            int idServicio = 1;

            String sqlCS
                    = "INSERT INTO Cliente_Servicio (IdCliente, IdServicio) VALUES (?, ?)";

            PreparedStatement pstCS = conn.prepareStatement(sqlCS);
            pstCS.setInt(1, idCliente);
            pstCS.setInt(2, idServicio);
            pstCS.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
         
        }
        return true;
    }
}
