package proyectoadsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperCompileManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author unicuces
 */
public class ListadosEstudiantes extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    ConexionBD cone;
    ConexionBD conn;
    int hour, minutes;
    public ListadosEstudiantes() {
        
        initComponents();
        cone = new ConexionBD();
        conn = new ConexionBD();
        cargarEstudiantes();
        
        GregorianCalendar fecha= new GregorianCalendar();
        
        int day= fecha.getTime() .getDate();
        int month= fecha.getTime() .getMonth()+1;
        int year= fecha.getTime() . getYear()+1900;
        
         hour= fecha.getTime() .getHours();
         minutes= fecha.getTime() .getMinutes();
        int seconds= fecha.getTime() .getSeconds();
        
        jLabel2.setText(day+"-"+month+"-"+year);
        jLabel4.setText(hour+":"+minutes+":"+seconds);
    }

   public void cargarEstudiantes(){
        String columnNames[]={"Codigo", "Nombre"}; 
        modelo = new DefaultTableModel(null, columnNames); 
        try{
            ResultSet rs = cone.consultaBD("SELECT * FROM Estudiantes");
            String fila[]= new String[2];
            while (rs.next()){
                fila[0]=rs.getString("Codigo");
                fila[1]=rs.getString("Nombre");
                
                modelo.addRow(fila);
            }
            jTable1.setModel(modelo);
        }
        catch(SQLException ex){
            Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de Estudiantes");

        jLabel1.setText("Fecha:");

        jLabel3.setText("Hora:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Generar PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/adsi62_proy", "root", "usbw");
            //coneccion de otro tipo
            JasperReport report = JasperCompileManager.compileReport("src/Reportes/ListadosEstudiantes.jrxml");
            //lo compila y genera desde librerias
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), conn);
            //toma jasper ripor y lo llena con datos despues debido a una consulta
            JasperExportManager.exportReportToPdfFile(print,"Reportes/Generales/Listado "
                    + "de Estudiantes "+jLabel2.getText()+
                    "_"+hour+"."+minutes+".pdf");
            //toma el archivo y lo convierte en pdf // sino se quiere guardar se quita esta linea
            
            JasperViewer jviewer= new JasperViewer(print,false);
            jviewer.setTitle("Reporte de Estudiantes");
            jviewer.setVisible(true);
            // con estas 3 ultimas lineas se muestra se en una vista previa 
        } catch (Exception ex) {
            Logger.getLogger(ListadosEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
               
       
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
