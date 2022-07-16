/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Negocio.NMecanico;
import Negocio.NReparacion;
import Negocio.NVehiculo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JeTf
 */
public class PReparacion extends javax.swing.JFrame {
    private NReparacion nReparacion;
    private NMecanico   nMecanico;    
    
    private int idReparacion;
    private Date fecha;
    private String observacion;
    private float costoTotal;
    private int idVehiculo;    
    
    
    private NVehiculo nVehiculo;
    private ArrayList<Object[]> detalle;
    private int idMecanico;
    float suma;
    public PReparacion() {
        this.setTitle("Registro Reparación");
        initComponents();
        this.nReparacion = new NReparacion();
        this.nMecanico   = new NMecanico();
        this.nVehiculo   = new NVehiculo();
        
        this.listar();
        this.listarMecanicos();
        this.listarVehiculos();
        
        this.detalle= new ArrayList<>();
        suma = 0;
        
        
        
            DateTimeFormatter dtF = DateTimeFormatter.ofPattern("yyyy/MM/dd");        
            DateTimeFormatter dtH = DateTimeFormatter.ofPattern("HH:mm:ss");
            String fechar = dtF.format(LocalDateTime.now());
            String hora  = dtH.format(LocalDateTime.now());
            jTextField2.setText(fechar);
    }
    //====================
    public void agregar(){
        try {//String[] aux = jTextField2.getText().split("/");
             
            this.fecha        = new java.sql.Date(Calendar.getInstance().getTimeInMillis());//(Integer.valueOf( aux[0]),Integer.valueOf( aux[1]),Integer.valueOf( aux[2])) ;//new java.sql.Date(2022, 07, 05);
            this.observacion  = jTextField3.getText();
            this.costoTotal  = Float.valueOf(jTextField4.getText());            
            this.idVehiculo    = Integer.valueOf(jTextField5.getText());            
            
            nReparacion.agregar(
                    new java.sql.Date(this.fecha.getTime()),
                    this.observacion,
                    this.costoTotal,
                    this.idVehiculo,
                    this.detalle                    
            );
        } catch (Exception e) {
            System.out.println("Presentacion Agregar Error...");
        }
    }
    public void modificar(){
        try {
            this.idReparacion    = Integer.valueOf(jTextField1.getText());
            this.fecha        = new java.sql.Date(Calendar.getInstance().getTimeInMillis());//(Integer.valueOf( aux[0]),Integer.valueOf( aux[1]),Integer.valueOf( aux[2])) ;//new java.sql.Date(2022, 07, 05);
            this.observacion  = jTextField3.getText();
            this.costoTotal  = Float.valueOf(jTextField4.getText());            
            this.idVehiculo    = Integer.valueOf(jTextField5.getText());            
            
            nReparacion.modificar(
                    this.idReparacion,
                    new java.sql.Date(this.fecha.getTime()),
                    this.observacion,
                    this.costoTotal,
                    this.idVehiculo,
                    this.detalle                    
            );
            
            
        } catch (Exception e) {
            System.out.println("Presentacion Modificar error.. ");
        }
    }
    public void listar(){
        try {
            ArrayList<Object[]> reparaciones = new ArrayList<>();
            reparaciones    = nReparacion.listar();
            String[] col    = {"ID","FECHA","OBSERVACION","COSTO TOTAL","ID VEHICULO"};
            String data[][] = new String[reparaciones.size()][reparaciones.get(0).length];
            
            for (int i = 0; i < reparaciones.size(); i++) {
                data[i][0] = String.valueOf(reparaciones.get(i)[0]);//id
                data[i][1] = String.valueOf(reparaciones.get(i)[1]);
                data[i][2] = String.valueOf(reparaciones.get(i)[2]);//obs
                data[i][3] = String.valueOf(reparaciones.get(i)[3]);
                data[i][4] = String.valueOf(reparaciones.get(i)[4]);                
            }
            jTable1.setModel( new DefaultTableModel(data, col));
        } catch (Exception e) {
            System.out.println("Presentacion Listar Error...");
        }
    }
    public void eliminar(){
        try {
            this.idReparacion = Integer.valueOf(jTextField1.getText());
            this.nReparacion.eliminar(this.idReparacion);
        } catch (Exception e) {
            System.out.println("Presentacion Eliminar error.. ");
        }
    }
    private void listarMecanicos(){
        try{
        ArrayList<Object[]> mecanicos= new ArrayList<>();
            mecanicos= nMecanico.listar();           
            String data[][] = new String[mecanicos.size()][mecanicos.get(0).length];
            
            for (int i = 0; i < mecanicos.size(); i++) {
                jComboBox2.addItem(String.valueOf(mecanicos.get(i)[0])+" "+String.valueOf(mecanicos.get(i)[1]));                
            }         
        } catch (Exception e) {
            System.out.println("error al listar Especialidad...");
        }
    }
    
    private void listarVehiculos(){
        try{
        ArrayList<Object[]> vehiculos= new ArrayList<>();
            vehiculos= nVehiculo.listar();           
            String data[][] = new String[vehiculos.size()][vehiculos.get(0).length];
            
            for (int i = 0; i < vehiculos.size(); i++) {
                jComboBox1.addItem(String.valueOf(vehiculos.get(i)[0])+" "+String.valueOf(vehiculos.get(i)[1])+" "+String.valueOf(vehiculos.get(i)[4]));                
            }         
        } catch (Exception e) {
            System.out.println("error al listar Vehiculos...");
        }
    }
    
    //=====================
    
    private void Clear_Table1(){
        int rows = jTable2.getRowCount();
        for(int i=0;i<rows;i++)
        ((DefaultTableModel)jTable2.getModel()).removeRow(i);
    }
    private void listarDetalleReparacion(String idReparacion) {
         try {
            ArrayList<Object[]> detallerepacion = new ArrayList<>();
            detallerepacion = nReparacion.listarDetallePorId(Integer.parseInt( idReparacion));
            String[] col    = {"IdMecanico","Observacion","Precio"};
            String data[][] = new String[detallerepacion.size()][detallerepacion.get(0).length];
            
            for (int i = 0; i < detallerepacion.size(); i++) {                
                data[i][0] = String.valueOf(detallerepacion.get(i)[2]);//idvechiculo
                data[i][1] = String.valueOf(detallerepacion.get(i)[3]);//obs
                data[i][2] = String.valueOf(detallerepacion.get(i)[4]);//precio
            
            }
            jTable2.setModel(new DefaultTableModel(data, col));
        } catch (Exception e) {
            System.out.println("error al listar DetalleReparacion...");
        }      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextCantidad = new javax.swing.JTextField();
        jTextPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REPARACION");

        jButton1.setText("AgregarDetalle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("IdReparacion:");

        jLabel3.setText("Fecha:");

        jLabel4.setText("Observacion:");

        jLabel5.setText("CostoTotal:");

        jLabel6.setText("IdVehiculo:");

        jLabel7.setText("Detalle");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("IdMecanico:");

        jLabel9.setText("Observacion:");

        jLabel10.setText("Precio:");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                            .addComponent(jTextField2))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(222, 222, 222)
                                                .addComponent(jLabel7))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(146, 146, 146)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton1)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel8)
                                                            .addComponent(jLabel9))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jTextPrecio)
                                                            .addComponent(jTextCantidad)
                                                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jTextPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String opt = (String)jComboBox1.getSelectedItem();       
        jTextField5.setText(String.valueOf(Character.getNumericValue(opt.charAt(0))));
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.agregar();
        this.listar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String[] col = {"IdMecanico","Observacion","Precio"};
            String observacion = jTextCantidad.getText();
            float precio = Float.valueOf(jTextPrecio.getText());
            
            detalle.add( new Object[] {
                            idMecanico,
                            observacion,
                            precio
                       });
            
            suma            = suma +(float) precio ;
            String data[][] = new String[detalle.size()][detalle.get(0).length];
            
            for (int i = 0; i < detalle.size(); i++) {
                data[i][0] = String.valueOf(detalle.get(i)[0]);//idvechiculo
                data[i][1] = String.valueOf(detalle.get(i)[1]);//obs
                data[i][2] = String.valueOf(detalle.get(i)[2]);//precio
                System.out.println("detat : "+String.valueOf(detalle.get(i)[0])+" : "+String.valueOf(detalle.get(i)[1])+" : "+String.valueOf(detalle.get(i)[2]) );
               // suma = suma +(float) detalle.get(i)[2] ;                               
            }
            jTextField4.setText(String.valueOf(suma));            
            jTable2.setModel(new DefaultTableModel(data, col));
        } catch (Exception e) {
            System.out.println("error al listar Detalle...");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String opt  =  (String)jComboBox2.getSelectedItem();        
        int valor   =  Character.getNumericValue(opt.charAt(0));
        idMecanico  =  valor;// para el carrito;
        System.out.println("idMecannico: "+ String.valueOf(this.idMecanico));
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //this.Clear_Table1();
        this.eliminar();
        this.listar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int nfila= jTable1.getSelectedRow();
        if(nfila >= 0){
            
            String idNotaAlquiler= jTable1.getValueAt(nfila,0).toString();
            jTextField1.setText(idNotaAlquiler);
            jTextField2.setText(jTable1.getValueAt(nfila,1).toString());
            jTextField3.setText(jTable1.getValueAt(nfila,2).toString());
            jTextField4.setText(jTable1.getValueAt(nfila,3).toString());
            System.out.println("id "+idNotaAlquiler);
            listarDetalleReparacion( idNotaAlquiler);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.modificar();
        this.listar();
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PReparacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<Object> jComboBox1;
    private javax.swing.JComboBox<Object> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextPrecio;
    // End of variables declaration//GEN-END:variables
}
