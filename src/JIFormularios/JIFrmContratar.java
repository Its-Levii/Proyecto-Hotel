/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package JIFormularios;

import javax.swing.JOptionPane;
import proyectohotel.Usuario;

import java.time.YearMonth;
/**
 *
 * @author Usuario
 */
public class JIFrmContratar extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFrmContratar
     */
    boolean completo = false;
    String[] ComboMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    String[] ComboGenero = {"Masculino", "Femenino", "Otro"};
    public JIFrmContratar() {
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        initComponents();
        try {
           setMaximum(true);
        } catch (Exception e) {
            System.out.println("No se maximizo correctamente, ERROR:" + e);
        }
        llenarItems();
    }
    public void llenarItems(){
        completo = false;
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtDocumento.setText("");
        txtDepartamento.setText("");
        txtCiudad.setText("");
        
        cbMes.removeAllItems();
        cbAño.removeAllItems();
        cbGenero.removeAllItems();
        
        cbMes.addItem("Mes");
        cbAño.addItem("Año");
        cbGenero.addItem("Seleccione...");
        
        for (int i = 0; i < ComboMeses.length; i++) {
            String item = ComboMeses[i];
            cbMes.addItem(item);
        }
        
        for (int i = 2025; i >= 1985; i--) {
            cbAño.addItem(Integer.toString(i));
        }
        for (int i = 0; i < ComboGenero.length; i++) {
            String item = ComboGenero[i];
            cbGenero.addItem(item);
        }
        completo = true;
    }
    private void actualizarDias(){
        cbDia.removeAllItems();
        cbDia.addItem("Dia");
        if (completo){
            if (cbAño.getSelectedIndex() != 0 && cbMes.getSelectedIndex() != 0){
                int Año = Integer.parseInt((String)cbAño.getSelectedItem());
                int Mes = cbMes.getSelectedIndex();
                int Dia = YearMonth.of(Año, Mes).lengthOfMonth();
                for (int i = 1; i <= Dia; i++) {
                cbDia.addItem(Integer.toString(i));
                }
            }
        }
    }
    public void Registrar(){
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String genero = (String) cbGenero.getSelectedItem();
        String correo = txtCorreo.getText();
        String obtener_documento = txtDocumento.getText();
        int documento;
        String fechaDeNacimiento = "";
        String departamento = (String) txtDepartamento.getText();
        String ciudad = (String) txtCiudad.getText();
        String rol = "empleado";
        boolean todo_bien_puesto = false;
        try {
            if (nombre.isEmpty() || apellido.isEmpty() || cbGenero.getSelectedIndex()== 0 || correo.isEmpty() || obtener_documento.isEmpty() ||
                    cbDia.getSelectedIndex()== 0 || cbMes.getSelectedIndex()== 0 || cbAño.getSelectedIndex()== 0 || departamento.isEmpty() || ciudad.isEmpty()){
                JOptionPane.showMessageDialog(null, "Faltan campos por completar");
                
                System.out.println("Todos los parametros deben estar llenos");
            }
            else{
                if (correo.endsWith("@gmail.com")) {
                    try {
                        documento = Integer.parseInt(obtener_documento);
                        todo_bien_puesto = true;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "❌ El documento solo debe contener numeros");
                    }
                    try {
                    String Dia = String.format("%02d", Integer.parseInt((String)cbDia.getSelectedItem()));
                    String Mes =  String.format("%02d", cbMes.getSelectedIndex());
                    String Año = (String) cbAño.getSelectedItem();          
                    fechaDeNacimiento = String.format("%s/%s/%s", Año, Mes, Dia);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Fecha Mal Puesta");
                    }
                    if (todo_bien_puesto){
                        Usuario usuario = new Usuario(nombre, apellido, genero, correo, obtener_documento, fechaDeNacimiento, departamento, ciudad, rol);
                        System.out.println("Enviado correctamente a Usuario");
                        boolean registrado = usuario.Registrar();
                        if (registrado){
                            llenarItems();
                        }
                    }else{
                        System.out.println("algo esta mal puesto y no se va a poder enviar a Usuario");
                    }
                } else {
                        JOptionPane.showMessageDialog(null, "El correo debe terminar en @gmail.com");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al enviar a Usuario");
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

        jLabel6 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtDepartamento = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbDia = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAño = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();

        jLabel6.setText("Documento");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Registrar Empleado");

        txtDocumento.setText("jTextField1");

        txtDepartamento.setText("jTextField2");

        txtCiudad.setText("jTextField3");

        jLabel7.setText("Nombre");

        jLabel11.setText("Apellido");

        jLabel12.setText("Genero");

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Correo Electronico");

        txtCorreo.setText("jTextField1");

        jLabel3.setText("Fecha de nacimiento");

        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesActionPerformed(evt);
            }
        });

        cbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAñoActionPerformed(evt);
            }
        });

        jLabel4.setText("Departamento");

        jLabel5.setText("Ciudad");

        txtNombre.setText("jTextField1");

        txtApellido.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDocumento)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(cbDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAño, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDepartamento)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(94, 94, 94))
                            .addComponent(txtCiudad)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(61, 61, 61))
                            .addComponent(cbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        Registrar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesActionPerformed
        // TODO add your handling code here:
        actualizarDias();
    }//GEN-LAST:event_cbMesActionPerformed

    private void cbAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAñoActionPerformed
        // TODO add your handling code here:
        actualizarDias();
    }//GEN-LAST:event_cbAñoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbAño;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
