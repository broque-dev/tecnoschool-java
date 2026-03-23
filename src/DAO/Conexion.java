
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
        Connection enlazar = null;
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            enlazar = DriverManager.getConnection("jdbc:mysql://localhost/tecnoschool2","root","");
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return enlazar;
    }
}
