package Views;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Pagos extends javax.swing.JFrame {
    
public Pagos() {
    initComponents();
    cargarClientes();
    cargarServicios();
    cargarMeses();
    cargarMetodos();
    cargarEstadosPago();
    cargarPersonal();
}


    //CARGAR CLIENTES
private void cargarClientes() {
    try (Connection conn = Conexion.conectar()) {

        PreparedStatement pst = conn.prepareStatement("SELECT IdCliente, Nombre FROM Cliente");
        ResultSet rs = pst.executeQuery();

        cmbCliente.removeAllItems();

        while (rs.next()) {
            cmbCliente.addItem(rs.getInt("IdCliente") + " - " + rs.getString("Nombre"));
        }

    } catch (SQLException e) {
        System.out.println("Error cargar clientes: " + e);
    }
}


//CARGAR SERVICIO POR CLIENTE
private void cargarServicios() {
    try (Connection conn = Conexion.conectar()) {

        PreparedStatement pst = conn.prepareStatement("SELECT IdServicio, TipoServicio FROM Servicio");
        ResultSet rs = pst.executeQuery();

        cmbServicio.removeAllItems();

        while (rs.next()) {
            cmbServicio.addItem(rs.getInt("IdServicio") + " - " + rs.getString("TipoServicio"));
        }

    } catch (SQLException e) {
        System.out.println("Error cargar servicios: " + e);
    }
}


//CARGAR MESES
private void cargarMeses() {
    try (Connection conn = Conexion.conectar()) {

        PreparedStatement pst = conn.prepareStatement("SELECT IdMes, NombreMes FROM Mes");
        ResultSet rs = pst.executeQuery();

        cmbMes.removeAllItems();

        while (rs.next()) {
            cmbMes.addItem(rs.getInt("IdMes") + " - " + rs.getString("NombreMes"));
        }

    } catch (SQLException e) {
        System.out.println("Error meses: " + e);
    }
}


// CARGAR METODO DE PAGO
private void cargarMetodos() {
    try (Connection conn = Conexion.conectar()) {

        PreparedStatement pst = conn.prepareStatement("SELECT IdMetodoPago, MetodoPago FROM MetodoPago");
        ResultSet rs = pst.executeQuery();

        cmbMetodoPago.removeAllItems();

        while (rs.next()) {
            cmbMetodoPago.addItem(rs.getInt("IdMetodoPago") + " - " + rs.getString("MetodoPago"));
        }

    } catch (SQLException e) {
        System.out.println("Error metodo de pago: " + e);
    }
}


// CARGAR ESTADO
private void cargarEstadosPago() {
    try (Connection conn = Conexion.conectar()) {

        PreparedStatement pst = conn.prepareStatement(
            "SELECT IdEstado, NombreEstado FROM Estado WHERE TipoEntidad='Pago'"
        );
        ResultSet rs = pst.executeQuery();

        cmbEstadoPago.removeAllItems();

        while (rs.next()) {
            cmbEstadoPago.addItem(rs.getInt("IdEstado") + " - " + rs.getString("NombreEstado"));
        }

    } catch (SQLException e) {
        System.out.println("Error cargar estado pago: " + e);
    }
}


// CARGAR PERSONAL
private void cargarPersonal() {
    try (Connection conn = Conexion.conectar()) {

        PreparedStatement pst = conn.prepareStatement("SELECT IdPersonal, Nombre FROM Personal");
        ResultSet rs = pst.executeQuery();

        cmbPersonal.removeAllItems();

        while (rs.next()) {
            cmbPersonal.addItem(rs.getInt("IdPersonal") + " - " + rs.getString("Nombre"));
        }

    } catch (SQLException e) {
        System.out.println("Error cargar personal: " + e);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbPersonal = new javax.swing.JComboBox<>();
        cmbCliente = new javax.swing.JComboBox<>();
        cmbServicio = new javax.swing.JComboBox<>();
        cmbMetodoPago = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        cmbEstadoPago = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PAGOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 18, 104, -1));

        jLabel2.setText("Personal que atendio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 120, 20));

        jLabel3.setText("Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 100, 20));

        jLabel4.setText("Servicio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 100, 20));

        jLabel5.setText("Metodo de pago");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 100, 20));

        jLabel7.setText("Estado de pago");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 100, 20));

        jLabel8.setText("Mes pagado");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 100, 20));

        jLabel9.setText("Fecha de pago");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 100, 20));

        cmbPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 150, -1));

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 150, -1));

        cmbServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 150, -1));

        cmbMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 150, -1));

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 150, -1));

        cmbEstadoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbEstadoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 150, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 150, -1));

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, 30));

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 90, 30));

        jLabel6.setText("colocar Año/Mes/Dia");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                 
        if (cmbCliente.getSelectedIndex() == -1 ||
        cmbServicio.getSelectedIndex() == -1 ||
        cmbMetodoPago.getSelectedIndex() == -1 ||
        cmbMes.getSelectedIndex() == -1 ||
        cmbEstadoPago.getSelectedIndex() == -1 ||
        cmbPersonal.getSelectedIndex() == -1 ||
        jTextField1.getText().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
        return;
    }

    int idCliente = Integer.parseInt(
        cmbCliente.getSelectedItem().toString().split(" - ")[0]
    );

    int idServicio = Integer.parseInt(
        cmbServicio.getSelectedItem().toString().split(" - ")[0]
    );

    int idEstadoPago = Integer.parseInt(
        cmbEstadoPago.getSelectedItem().toString().split(" - ")[0]
    );


    String metodoPago = cmbMetodoPago.getSelectedItem().toString();
    String mesPagado = cmbMes.getSelectedItem().toString();
    String personal = cmbPersonal.getSelectedItem().toString();
    String fechaPago = jTextField1.getText();

   try (Connection conn = Conexion.conectar()) {

      int idClienteServicio = 0;

    String sqlCS =
        "SELECT IdCliente_Servicio " +
        "FROM cliente_servicio " +
        "WHERE IdCliente = ? AND IdServicio = ?";

    PreparedStatement pstCS = conn.prepareStatement(sqlCS);
    pstCS.setInt(1, idCliente);
    pstCS.setInt(2, idServicio);

    ResultSet rs = pstCS.executeQuery();

    if (rs.next()) {
        idClienteServicio = rs.getInt("IdCliente_Servicio");
    } else {
        JOptionPane.showMessageDialog(this,
            "❌ El cliente no tiene asignado ese servicio");
        return;
    }

      //  INSERTAR TICKET
    String sqlTICKETS =
        "INSERT INTO tickets (IdCliente_Servicio, FechaPago, IdEstado) " +
        "VALUES (?, ?, ?)";

    PreparedStatement pst = conn.prepareStatement(sqlTICKETS);
    pst.setInt(1, idClienteServicio);
    pst.setString(2, fechaPago);
    pst.setInt(3, idEstadoPago);
    pst.executeUpdate();

    // INSERTAR HISTORIAL 
    String sqlHistorial =
        "INSERT INTO historial (IdPersonal, Accion, Tabla_Afectada, Descripcion, Fecha) " +
        "VALUES (?, ?, ?, ?, NOW())";

    PreparedStatement pstH = conn.prepareStatement(sqlHistorial);
    pstH.setInt(1,
        Integer.parseInt(cmbPersonal.getSelectedItem().toString().split(" - ")[0])
    );
    pstH.setString(2, "INSERT");
    pstH.setString(3, "tickets");
    pstH.setString(4,
        "Pago registrado | Cliente ID: " + idCliente +
        " | Servicio ID: " + idServicio
    );
    pstH.executeUpdate();

    JOptionPane.showMessageDialog(this, "Pago registrado correctamente");

} catch (SQLException e) {
    JOptionPane.showMessageDialog(this,
        "Error al guardar pago: " + e.getMessage());
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
      MenuUsuario menu = new MenuUsuario();
        menu.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagos().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbEstadoPago;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox<String> cmbMetodoPago;
    private javax.swing.JComboBox<String> cmbPersonal;
    private javax.swing.JComboBox<String> cmbServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
