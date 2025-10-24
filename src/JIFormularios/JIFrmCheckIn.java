/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package JIFormularios;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;
import proyectohotel.Checkin;
import proyectohotel.Habitacion;
import proyectohotel.Huesped;
import proyectohotel.Reserva;

/**
 *
 * @author Usuario
 */
public class JIFrmCheckIn extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFrmCheckIn
     */
    Huesped huesped;
    Reserva reserva;
    Habitacion habitacion;
    boolean completo = false;
    public JIFrmCheckIn() {
        initComponents();
        huesped  = new Huesped();
        reserva = new Reserva();
        habitacion = new Habitacion();
        llenarItems();
    }
    public void llenarItems(){
        completo = false;
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        try {
           setMaximum(true);
        } catch (Exception e) {
            System.out.println("No se maximizo correctamente, ERROR:" + e);
        }
        txtNombre.setText("");
        txtApellido.setText("");
        txtDocumento.setText("");
        txtNumero.setText("");
        txtEstado.setText("");
        txtTarifa.setText("");
        cbHabitaciones.removeAllItems();
        cbHabitaciones.addItem("Seleccione");
        for (String[] fila : habitacion.mostrarHabitaciones()) {
            cbHabitaciones.addItem(fila[0]+ "   " +fila[1] + "         " + fila[4]);
        }
        lbNumero.setEnabled(false);
        lbEstado.setEnabled(false);
        lbTarifa.setEnabled(false);
        txtTarifa.setEnabled(false);
        txtNumero.setEnabled(false);
        txtEstado.setEnabled(false);
        
        lbNombre.setEnabled(false);
        txtNombre.setEnabled(false);
        lbApellido.setEnabled(false);
        txtApellido.setEnabled(false);
        lbDocumento.setEnabled(false);
        txtDocumento.setEnabled(false);
        btnBuscarReserva.setVisible(false);
        lbHabitaciones.setEnabled(false);
        cbHabitaciones.setEnabled(false);
        btnRegistrarIngreso.setEnabled(false);
        completo = true;
        actualizarEstadosReservas();
    }
    public void actualizarEstadosReservas(){
        reserva.ModificarReservas();
        for (String[] fila : reserva.ReservasDeUsuario(0)) {
            LocalDate fechaHuesped = null, fechaSalida = null, fechaActual = null;
            int id_habitacion = Integer.parseInt(fila[4]);
            try {
                String fechaActualString = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                fechaActual = LocalDate.parse(fechaActualString);
                System.out.println(fechaActualString);

                String fechaString = fila[5];
                fechaHuesped = LocalDate.parse(fechaString);
                System.out.println("Fecha convertida: " + fechaHuesped);
                
                String fechaSalidaString = fila[6];
                fechaSalida = LocalDate.parse(fechaSalidaString);
                System.out.println("Fecha convertida: " + fechaHuesped);

                } catch (Exception e) {
                    System.out.println("Error al convertir la fecha: " + e.getMessage());
                }
            if(fechaHuesped.isEqual(fechaActual) && fila[7].equals("Pendiente")){
                habitacion.ModificarEstadoHabitacion("Reservada", id_habitacion);
            }else if(fechaHuesped.isBefore(fechaActual) && fechaSalida.isAfter(fechaActual) || fechaSalida.isEqual(fechaActual) && fila[7].equals("Pendiente")){
                habitacion.ModificarEstadoHabitacion("Reservada", id_habitacion);
            }
            else if (fechaSalida.isBefore(fechaActual) && fila[7].equals("Expirada") && habitacion.mostrarHabitaciones().get(id_habitacion-1)[4].equals("Reservada")){
                habitacion.ModificarEstadoHabitacion("Disponible", id_habitacion);
            }
        }
        
    }
    public void llenarSinReserva(){
        lbNombre.setEnabled(true);
        txtNombre.setEnabled(true);
        lbApellido.setEnabled(true);
        txtApellido.setEnabled(true);
        lbDocumento.setEnabled(true);
        txtDocumento.setEnabled(true);
        btnBuscarReserva.setVisible(false);
        lbHabitaciones.setVisible(true);
        cbHabitaciones.setVisible(true);
        lbHabitaciones.setEnabled(true);
        cbHabitaciones.setEnabled(true);
        btnRegistrarIngreso.setEnabled(true);
        btnRegistrarIngreso.setText("Registrar Ingreso");
    }
    public void llenarReservado(){
        lbNombre.setEnabled(false);
        txtNombre.setEnabled(false);
        lbApellido.setEnabled(false);
        txtApellido.setEnabled(false);
        lbDocumento.setEnabled(true);
        txtDocumento.setEnabled(true);
        btnBuscarReserva.setVisible(true);
        lbHabitaciones.setVisible(false);
        cbHabitaciones.setVisible(false);
        
        txtNombre.setText("");
        txtApellido.setText("");
        txtNumero.setText("");
        txtEstado.setText("");
        txtTarifa.setText("");
        btnRegistrarIngreso.setEnabled(false);
        btnRegistrarIngreso.setText("Ingresar huesped");
    }
    public void llenarNombres(){
        if (completo){
            for (int i = 0; i < habitacion.mostrarHabitaciones().size(); i++) {
                if(cbHabitaciones.getSelectedIndex() == Integer.parseInt(habitacion.mostrarHabitaciones().get(i)[0])){
                    System.out.println(habitacion.mostrarHabitaciones().get(i)[0]);
                    txtNumero.setText(habitacion.mostrarHabitaciones().get(i)[0]);
                    txtEstado.setText(habitacion.mostrarHabitaciones().get(i)[4]);
                    txtTarifa.setText(habitacion.mostrarHabitaciones().get(i)[3]);
                }else if(cbHabitaciones.getSelectedIndex() == 0){
                    txtNumero.setText("");
                    txtEstado.setText("");                
                    txtTarifa.setText("");                
            }
        }
        }
    }
    public void RegistrarIngreso(){
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String obtener_documento = txtDocumento.getText();
        int documento = 0;
        boolean todo_lleno = false;
        if (txtNombre.getText().trim().isEmpty() || txtApellido.getText().trim().isEmpty() || txtDocumento.getText().trim().isEmpty() || cbHabitaciones.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Faltan campos por completar");
        }else{
            try {
                documento = Integer.parseInt(txtDocumento.getText());
                todo_lleno = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El documento solo debe contener numeros");
            }
            if (todo_lleno){
                int id_habitacion = cbHabitaciones.getSelectedIndex();
                Checkin checkin = new Checkin(documento, id_habitacion);
                if (checkin.BuscarHuesped(documento)){
                    JOptionPane.showMessageDialog(null, "Esta persona ya se encuentra dentro del hotel");
                }else{
                    if (txtEstado.getText().equals("Disponible")){
                        huesped = new Huesped(nombre, apellido, documento);
                        if (huesped.AgregarHuesped() != null){
                           if (reserva.buscarreserva(documento, "Pendiente")){
                               try {
                                String fechaString = reserva.DatosReserva(documento)[3];
                                LocalDate fecha = LocalDate.parse(fechaString);
                                System.out.println("Fecha convertida: " + fecha);
                                } catch (Exception e) {
                                    System.out.println("Error al convertir la fecha: " + e.getMessage());
                                }
                                JOptionPane.showMessageDialog(null, "Esta persona ya tiene reserva \n puedes revisar el estado de su reserva en reservas");
                                System.out.println(reserva.DatosReserva(documento)[3]);
                                System.out.println(reserva.DatosReserva(documento)[4]);
                           }
                           else if (checkin.hacerCheck_in()){
                               habitacion.ModificarEstadoHabitacion("Ocupada", id_habitacion);
                               JOptionPane.showMessageDialog(null, "Ingresado correctamente al hotel");
                               llenarItems();
                               llenarSinReserva();
                           }else{
                               JOptionPane.showMessageDialog(null, "Error al ingresar al hotel");
                           }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error al ingresar al hotel");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Esta habitacion esta " + txtEstado.getText());
                    }
                }
            }
        }
    }
    public void BuscarReserva(){
        String obtener_documento = txtDocumento.getText();
        int documento = 0;
        boolean todo_lleno = false;
        if (txtDocumento.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese el documento para buscar la reserva");
        }else{
            try {
                documento = Integer.parseInt(txtDocumento.getText());
                todo_lleno = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El documento solo debe contener numeros");
            }
            if (todo_lleno){
                if (reserva.buscarreserva(documento, "Pendiente")){
                    LocalDate fechaHuesped = null, fechaActual = null;
                    try {
                        String fechaActualString = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                        fechaActual = LocalDate.parse(fechaActualString);
                        System.out.println(fechaActualString);

                        String fechaString = reserva.DatosReserva(documento)[3];
                        fechaHuesped = LocalDate.parse(fechaString);
                        System.out.println("Fecha convertida: " + fechaHuesped);

                    } catch (Exception e) {
                        System.out.println("Error al convertir la fecha: " + e.getMessage());
                    }
                    txtNombre.setText(huesped.datosHuesped(documento)[0]);
                    txtApellido.setText(huesped.datosHuesped(documento)[1]);
                    txtNumero.setText(reserva.DatosReserva(documento)[2]);
                    txtEstado.setText(habitacion.mostrarHabitaciones().get(Integer.parseInt(reserva.DatosReserva(documento)[2])-1)[4]);
                    txtTarifa.setText(habitacion.mostrarHabitaciones().get(Integer.parseInt(reserva.DatosReserva(documento)[2])-1)[3]);
                    if (fechaHuesped.isAfter(fechaActual)){
                        JOptionPane.showMessageDialog(null, "La reserva esta programada para la fecha: " + fechaHuesped);
                    }else{
                        btnRegistrarIngreso.setEnabled(true);
                    }
                }
                else if (reserva.buscarreserva(documento, "Expirada")){
                    JOptionPane.showMessageDialog(null, "Ya la reserva expiro");
                }
                else{
                    if (reserva.buscarreserva(documento, "Confirmada")){
                        JOptionPane.showMessageDialog(null, "Ya la persona ingreso al hotel");
                    }else{
                        JOptionPane.showMessageDialog(null, "Esta persona NO tiene reservacion");
                    }
                }
            }
        }
    }
    public void IngresarHuesped(){
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        int documento = Integer.parseInt(txtDocumento.getText());
        int id_habitacion = Integer.parseInt(reserva.DatosReserva(documento)[2]);
        Checkin checkin = new Checkin(documento, id_habitacion);
        if (checkin.BuscarHuesped(documento)){
            JOptionPane.showMessageDialog(null, "Esta persona ya se encuentra dentro del hotel");
        }else{
            if (txtEstado.getText().equals("Reservada")){
                huesped = new Huesped(nombre, apellido, documento);
                if (huesped.AgregarHuesped() != null){
                   if (checkin.hacerCheck_in()){
                       habitacion.ModificarEstadoHabitacion("Ocupada", id_habitacion);
                       reserva.ModificarEstadoReserva("Confirmada", documento);
                       JOptionPane.showMessageDialog(null, "Ingresado correctamente al hotel");
                       llenarReservado();
                   }else{
                       JOptionPane.showMessageDialog(null, "Error al ingresar al hotel");
                   }
                }else{
                    JOptionPane.showMessageDialog(null, "Error al ingresar al hotel");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Esta habitacion esta " + txtEstado.getText());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgIngreso = new javax.swing.ButtonGroup();
        lbNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lbDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        lbHabitaciones = new javax.swing.JLabel();
        cbHabitaciones = new javax.swing.JComboBox<>();
        btnRegistrarIngreso = new javax.swing.JButton();
        lbEstado = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        lbTarifa = new javax.swing.JLabel();
        txtTarifa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbSinReserva = new javax.swing.JRadioButton();
        rbReservado = new javax.swing.JRadioButton();
        btnBuscarReserva = new javax.swing.JButton();

        lbNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNombre.setText("Nombre");

        txtNombre.setText("jTextField2");

        lbApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbApellido.setText("Apellido");

        txtApellido.setText("jTextField3");

        lbDocumento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDocumento.setText("NOº Documento");

        txtDocumento.setText("jTextField4");
        txtDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDocumentoMouseClicked(evt);
            }
        });

        lbHabitaciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHabitaciones.setText("Habitaciones");

        cbHabitaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHabitacionesActionPerformed(evt);
            }
        });

        btnRegistrarIngreso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrarIngreso.setText("Registrar Ingreso");
        btnRegistrarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarIngresoActionPerformed(evt);
            }
        });

        lbEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbEstado.setText("Estado de habitacion");

        lbNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNumero.setText("NOº de habitacion");

        txtNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumero.setText("jTextField1");

        txtEstado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstado.setText("jTextField2");

        lbTarifa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTarifa.setText("Tarifa");

        txtTarifa.setText("jTextField1");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tipo de ingreso");

        bgIngreso.add(rbSinReserva);
        rbSinReserva.setText("Sin reserva");
        rbSinReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSinReservaActionPerformed(evt);
            }
        });

        bgIngreso.add(rbReservado);
        rbReservado.setText("Reservado");
        rbReservado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbReservadoActionPerformed(evt);
            }
        });

        btnBuscarReserva.setText("Buscar Reserva");
        btnBuscarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cbHabitaciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(462, 462, 462))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(75, 75, 75)
                                .addComponent(lbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(48, 48, 48)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTarifa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(124, 124, 124))
                            .addComponent(txtTarifa)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnRegistrarIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNombre)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addGap(110, 110, 110)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(111, 111, 111))
                                    .addComponent(txtApellido))
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbSinReserva)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbReservado)))
                                .addGap(200, 200, 200)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(57, 57, 57))
                            .addComponent(txtDocumento)
                            .addComponent(btnBuscarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSinReserva)
                    .addComponent(rbReservado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(lbApellido)
                    .addComponent(lbDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDocumento)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarReserva)
                .addGap(10, 10, 10)
                .addComponent(lbHabitaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstado)
                    .addComponent(lbNumero)
                    .addComponent(lbTarifa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnRegistrarIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHabitacionesActionPerformed
        // TODO add your handling code here:
        llenarNombres();
    }//GEN-LAST:event_cbHabitacionesActionPerformed

    private void btnRegistrarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarIngresoActionPerformed
        // TODO add your handling code here:
        if (btnRegistrarIngreso.getText().equals("Registrar Ingreso")){
            RegistrarIngreso();
        }else{
            IngresarHuesped();
        }
    }//GEN-LAST:event_btnRegistrarIngresoActionPerformed

    private void rbSinReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSinReservaActionPerformed
        // TODO add your handling code here:
        llenarItems();
        llenarSinReserva();
    }//GEN-LAST:event_rbSinReservaActionPerformed

    private void rbReservadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbReservadoActionPerformed
        // TODO add your handling code here:
        llenarReservado();
    }//GEN-LAST:event_rbReservadoActionPerformed

    private void btnBuscarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarReservaActionPerformed
        // TODO add your handling code here:
        BuscarReserva();
    }//GEN-LAST:event_btnBuscarReservaActionPerformed

    private void txtDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDocumentoMouseClicked
        // TODO add your handling code here:
        if (btnRegistrarIngreso.getText().equals("Ingresar huesped")){
            btnRegistrarIngreso.setEnabled(false);
        }
        
    }//GEN-LAST:event_txtDocumentoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgIngreso;
    private javax.swing.JButton btnBuscarReserva;
    private javax.swing.JButton btnRegistrarIngreso;
    private javax.swing.JComboBox<String> cbHabitaciones;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbDocumento;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbHabitaciones;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbTarifa;
    private javax.swing.JRadioButton rbReservado;
    private javax.swing.JRadioButton rbSinReserva;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTarifa;
    // End of variables declaration//GEN-END:variables
}
