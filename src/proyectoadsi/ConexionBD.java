/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoadsi;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionBD {
    Connection con;
    Statement st;
    public ConexionBD(){
          try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/adsi62_proy", "root", "usbw");
            st = con.createStatement();
            
        } catch (Exception ex) { 
              System.out.println("Error " + ex);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificaBD(String sql){
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet consultaBD(String sql){
        ResultSet rsTemp=null;
        
        try {
            rsTemp=st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsTemp;
    }
    
    
}
