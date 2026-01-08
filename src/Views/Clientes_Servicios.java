package Views;

import conexion.Conexion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class Clientes_Servicios extends javax.swing.JFrame {

   public Clientes_Servicios() {
        initComponents();
        cargarTablaClientesCompleta();
    }
    private void cargarTablaClientesCompleta() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Cliente");
    modelo.addColumn("Teléfono");
    modelo.addColumn("Servicio");
    modelo.addColumn("Costo");
    modelo.addColumn("Estado Cliente");
    modelo.addColumn("Estado Servicio");
    modelo.addColumn("Estado Historial");
    modelo.addColumn("Estado Ticket");

    tblclientes.setModel(modelo);

  try (Connection conn = Conexion.conectar()) {


          String sql =
            "SELECT " +
            "c.IdCliente, " +
            "CONCAT(c.Nombre,' ',c.APaterno,' ',c.AMaterno) AS Cliente, " +
            "c.Telefono, " +
            "s.TipoServicio, " +
            "s.Costo, " +
            "ec.NombreEstado AS EstadoCliente, " +
            "'Activo' AS EstadoServicio, " +
            "IF(h.IdHistorial IS NULL, 'Sin movimientos', 'Con historial') AS EstadoHistorial, " +
            "IF(t.IdTickets IS NULL, 'Sin ticket', 'Con ticket') AS EstadoTicket " +
            "FROM Cliente c " +
            "INNER JOIN Estado ec ON c.IdEstado = ec.IdEstado AND ec.TipoEntidad = 'Cliente' " +
            "INNER JOIN Cliente_Servicio cs ON c.IdCliente = cs.IdCliente " +
            "INNER JOIN Servicio s ON cs.IdServicio = s.IdServicio " +
            "LEFT JOIN Tickets t ON cs.IdCliente_Servicio = t.IdCliente_Servicio " +
            "LEFT JOIN Historial h ON h.Tabla_Afectada = 'Pagos' " +
            "AND h.Descripcion LIKE CONCAT('%', cs.IdCliente_Servicio, '%')";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

 while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("IdCliente"),
                rs.getString("Cliente"),
                rs.getString("Telefono"),
                rs.getString("TipoServicio"),
                rs.getDouble("Costo"),
                rs.getString("EstadoCliente"),
                rs.getString("EstadoServicio"),
                rs.getString("EstadoHistorial"),
                rs.getString("EstadoTicket")
            });
  }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
            "Error al cargar tabla: " + e.getMessage());
    }
  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblclientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        EditarCli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Clientes y Servicios");

        tblclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Clientes", "Telefono", "Servicio", "precio", "Estado Cliente", "Estado Servicio", "Historial", "Tiket"
            }
        ));
        jScrollPane1.setViewportView(tblclientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        EditarCli.setText("Editar Cliente");
        EditarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(EditarCli))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(EditarCli)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
            
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       MenuUsuario menu = new MenuUsuario();
    menu.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EditarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarCliActionPerformed
             int fila = tblclientes.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un cliente");
            return;
        }

       int idClienteSeleccionado = Integer.parseInt(
               tblclientes.getValueAt(fila, 0).toString()
       );

        try (Connection conn = Conexion.conectar()) {

            String sql =
                "SELECT c.Nombre, c.APaterno, c.AMaterno, c.Telefono, c.Correo, d.NombreCalle " +
                "FROM Cliente c " +
                "INNER JOIN Direccion d ON c.IdDireccion = d.IdDireccion " +
                "WHERE c.IdCliente = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idClienteSeleccionado);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtNombre.setText(rs.getString("Nombre"));
                txtAPaterno.setText(rs.getString("APaterno"));
                txtAMaterno.setText(rs.getString("AMaterno"));
                txtTelefono.setText(rs.getString("Telefono"));
                txtCorreo.setText(rs.getString("Correo"));
                txtDireccion.setText(rs.getString("NombreCalle"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error cargar cliente: " + e.getMessage());
        }
    }//GEN-LAST:event_EditarCliActionPerformed
 public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Clientes_Servicios().setVisible(true);
        }
    });
}

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditarCli;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblclientes;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtAPaterno;
    private javax.swing.JTextField txtAMaterno;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
}
