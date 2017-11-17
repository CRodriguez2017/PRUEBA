
package proyectoadsi;

import java.sql.*;
import java.util.logging.*;
import javax.swing.table.*;
import javax.swing.*;


public class Matriculas extends javax.swing.JInternalFrame {
    ConexionBD cone = new ConexionBD();
    DefaultTableModel modelo = new DefaultTableModel();
    
           ConexionBD cone2 , cone3, cone5, conn; 
    public Matriculas() {
        initComponents();
        cone = new ConexionBD();
        cone2 = new ConexionBD();
        cone3 = new ConexionBD();
        cone5 = new ConexionBD();
        conn = new ConexionBD();
        
        modelo = new DefaultTableModel();
        consultar("");
        estudiante();
        curso();
    }
    
    public void consultar(String busqueda){
        String titulos [] ={"CODIGO","ESTUDIANTE","CODIGO","CURSO"};
         
         modelo = new DefaultTableModel (null,titulos);
         
         String filas [] = new String [4];
        try{
            ResultSet rs = cone.consultaBD("SELECT matri.codEst, estu.Nombre, matri.codCurso,curso.nombCurso FROM Matriculas as matri"
             + " inner join Estudiantes as estu on matri.codEst = estu.Codigo INNER JOIN Cursos as curso\n" +
              " on matri.codCurso = curso.codCurso where estu.Nombre LIKE '%"+busqueda+"%'");
         
            while (rs.next()){
             
                filas[0]=rs.getString("matri.codEst");
                filas[1]=rs.getString("estu.Nombre");
                filas[2]=rs.getString("matri.codCurso");
                filas[3]=rs.getString("curso.nombCurso");
                 modelo.addRow(filas);
            }
            
            tabla.setModel(modelo);
        
        }  catch (SQLException ex) {
           Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }
    
     public void estudiante(){
        try{
            ConexionBD con=new ConexionBD();
            ResultSet rs2 = con.consultaBD("SELECT * FROM Estudiantes");
         
            while (rs2.next()){
                JAlumno.addItem(rs2.getString("Codigo"));
            }
        }  catch (SQLException ex) {
           Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     
      public void curso(){
        try{
            ConexionBD co=new ConexionBD();
            DefaultListModel mode = new DefaultListModel();
            DefaultListModel mode1 = new DefaultListModel();
            ResultSet rs4 = co.consultaBD("SELECT * FROM Cursos");
         
            while (rs4.next()){
                    mode1.addElement(rs4.getString("codCurso"));
                    mode.addElement(rs4.getString("nombCurso"));
                    LCurso.setModel(mode1);
                    LCurso2.setModel(mode);
                    
            }
        }  catch (SQLException ex) {
           Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Modificar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JAlumno = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        lblEstudiante = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LCurso = new javax.swing.JList<String>();
        btnAgregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        LCurso2 = new javax.swing.JList<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Modificar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        setBackground(new java.awt.Color(0, 0, 0));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Matricula");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Codigo del Alumno");

        JAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JAlumnoItemStateChanged(evt);
            }
        });
        JAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre del Alumno");

        jLabel5.setText("Curso");

        LCurso.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LCursoValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(LCurso);

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel6.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        LCurso2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LCurso2ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(LCurso2);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(lblEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnAgregar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(lblEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
         try {
            
            String cod=(String)modelo.getValueAt(tabla.getSelectedRow(),0);
            ConexionBD cone2=new ConexionBD();
            ResultSet rs5 = cone2.consultaBD("SELECT * FROM matricula WHERE codEst = " + cod);
                
            if (rs5.next()){
                    JAlumno.setSelectedItem(rs5.getString("codEst"));
                    LCurso.setSelectedValue(rs5.getString("codCurso"),true);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane,"Ese codigo no existe");
                }
        }  catch (SQLException ex) {
           Logger.getLogger(Matriculas.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_ModificarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        if (tabla.getSelectedRow()== -1) {
                JOptionPane.showConfirmDialog(rootPane,"Debe seleccionar una registro de la tabla");
            }else{
                int confirm=JOptionPane.showConfirmDialog(rootPane,"Desea eliminar el regristro");
                    if (confirm==0) {
                        String cod=(String)modelo.getValueAt(tabla.getSelectedRow(),0);
                        cone5.modificaBD("DELETE FROM matricula WHERE codEst= "+ cod);
                        consultar("");
                    }
            }
    }//GEN-LAST:event_EliminarActionPerformed

    private void LCurso2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LCurso2ValueChanged
        int indice = LCurso2.getSelectedIndex();
        LCurso.setSelectedIndex(indice);
    }//GEN-LAST:event_LCurso2ValueChanged

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        consultar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String codCurso =(String)LCurso.getSelectedValue() ;
        String codAlumno = (String)JAlumno.getSelectedItem();
        cone3.modificaBD("INSERT INTO matriculas(codEst,codCurso) VALUES ("+codAlumno+","+codCurso+")");
        consultar("");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void LCursoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LCursoValueChanged
        int indice = LCurso.getSelectedIndex();
        LCurso2.setSelectedIndex(indice);
    }//GEN-LAST:event_LCursoValueChanged

    private void JAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAlumnoActionPerformed

    }//GEN-LAST:event_JAlumnoActionPerformed

    private void JAlumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JAlumnoItemStateChanged
        try{
            ResultSet rs3 = conn.consultaBD("SELECT Nombre FROM estudiantes WHERE Codigo="+JAlumno.getSelectedItem()+"");

            while (rs3.next()){
                lblEstudiante.setText(rs3.getString("Nombre"));
            }
        }  catch (SQLException ex) {
            Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JAlumnoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JComboBox<String> JAlumno;
    private javax.swing.JList<String> LCurso;
    private javax.swing.JList<String> LCurso2;
    private javax.swing.JMenuItem Modificar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
