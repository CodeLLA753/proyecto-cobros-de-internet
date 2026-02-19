package Logica;

import Dto.EstadosDto;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstadoLogica {
    public ArrayList<EstadosDto> listarEstados(){
        ArrayList<EstadosDto> listarEstados;
        EstadosDto estado;
        listarEstados = new ArrayList<EstadosDto>();
            try (Connection conn = Conexion.conectar()) {

            String sql = "SELECT IdEstado, NombreEstado FROM Estado WHERE TipoEntidad='Cliente'";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
          

            while (rs.next()) {
                estado = new EstadosDto();
                estado.IdEstado = rs.getInt("IdEstado");
                estado.NombreEstado = rs.getString("NombreEstado");
                listarEstados.add(estado);
            }
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
            return listarEstados;
    } 
}
