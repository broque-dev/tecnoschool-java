package DAO;

import Modelo.M_Login_TecnoSchool;
import Vista.Admin_Menu;
import Vista.Docente_Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAO_Login_TecnoSchool extends Conexion {

    public boolean validarusuario(M_Login_TecnoSchool MLogin) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conectar();

        String SQL1 = "SELECT * FROM administrador WHERE Usuario = ? AND Contraseña = ?";
        String SQL2 = "SELECT * FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?";

        try {
            // Intentar con la tabla administrador
            ps = con.prepareStatement(SQL1);
            ps.setString(1, MLogin.getUsuario());
            ps.setString(2, MLogin.getContraseña());
            rs = ps.executeQuery();
            if (rs.next()) {
                Admin_Menu form = new Admin_Menu();
                form.setVisible(true);
                return true;}

            // Intentar con la tabla administrar_docente si no se encontró en administrador
            ps = con.prepareStatement(SQL2);
            ps.setString(1, MLogin.getUsuario());
            ps.setString(2, MLogin.getContraseña());
            rs = ps.executeQuery();
            if (rs.next()) {
                Docente_Menu form = new Docente_Menu();
                form.setVisible(true);
                return true;}

            // Si no se encuentra en ninguna de las tablas
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }}}}
