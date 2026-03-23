
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class C_Admin_Aulas extends DAO.Conexion{
    private Propiedades propiedades;
    private int idAulaActual;
    
    
//MOSTRAR SALONES
public void mostrarSalones(DefaultTableModel tabla) {
    String query = "SELECT * FROM aulas";
    try (Connection con = conectar();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet resultado = ps.executeQuery()) {
        while (resultado.next()) {
            String idAula = resultado.getString("ID_Aula");
            String Grado = resultado.getString("Grado");
            String Seccion = resultado.getString("Sección");
            String Horas = resultado.getString("Horas");
            String disponible = resultado.getString("Disponibilidad");
            tabla.addRow(new Object[]{idAula, Grado, Seccion, Horas, disponible});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener aulas: " + e.getMessage());
    }}

//REGISTRAR AULA
public void registrarAula(JTextField grado, JTextField seccion, JTextField horas) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    if (grado.getText().trim().isEmpty() || seccion.getText().trim().isEmpty() || horas.getText().trim().isEmpty()) {
        this.propiedades.mostrarMensajeError("Por favor, completa todos los campos antes de continuar", "/imagenes/emojiTriste.png", "ALERTA");
        return;
    }
    if (con != null) {
        String SQL = "INSERT INTO aulas (Grado, Sección, Horas, Disponibilidad) values (?, ?, ?, 'S')";
        try {
            PreparedStatement obtener = con.prepareStatement(SQL);
            obtener.setString(1, grado.getText());
            obtener.setString(2, seccion.getText());
            obtener.setString(3, horas.getText());
            obtener.executeUpdate();
            this.propiedades.mostrarMensajeError("Registro Exitoso", "/imagenes/emojiFeliz.png", "ALERTA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro: " + e.getMessage());
        }}}

//EDITAR AULA
public void editarAula(JTextField aulaGrado, JTextField aulaSeccion, JTextField aulaHoras) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    if (aulaGrado.getText().trim().isEmpty() || aulaSeccion.getText().trim().isEmpty() || aulaHoras.getText().trim().isEmpty()) {
        this.propiedades.mostrarMensajeError("Por favor, completa todos los campos antes de continuar", "/imagenes/emojiTriste.png", "ALERTA");
        return;
    }
    if (con != null) {
        try {
            String SQLUpdate = "UPDATE aulas SET Grado = ?, Sección = ?, Horas = ? WHERE ID_Aula = ?";
            PreparedStatement actualizar = con.prepareStatement(SQLUpdate);
            actualizar.setString(1, aulaGrado.getText());
            actualizar.setString(2, aulaSeccion.getText());
            actualizar.setString(3, aulaHoras.getText());
            actualizar.setInt(4, idAulaActual);
            actualizar.executeUpdate();
            this.propiedades.mostrarMensajeError("Edición exitosa", "/imagenes/emojiFeliz.png", "ALERTA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de edición: " + e.getMessage());
        }}}

// CONSULTAR AULA
public void consultarAula(JTextField AulaGrado, JTextField AulaSeccion, JTextField AulaHoras, DefaultTableModel tabla) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el ID del Aula","/imagenes/emojiFeliz.png", "CONSULTAR");
    if (valor != null && !valor.isEmpty()) {
        try {
            String SQL = "SELECT * FROM aulas WHERE ID_Aula = ?";
            PreparedStatement obtener = con.prepareStatement(SQL);
            obtener.setInt(1, Integer.parseInt(valor));
            ResultSet resultado = obtener.executeQuery();
            tabla.setRowCount(0);
            if (resultado.next()) {
                String idAula = resultado.getString("ID_Aula");
                String grado = resultado.getString("Grado");
                String seccion = resultado.getString("Sección");
                String horas = resultado.getString("Horas");
                String disponible = resultado.getString("Disponibilidad");
                tabla.addRow(new Object[]{idAula, grado, seccion, horas, disponible});
                AulaGrado.setText(grado);
                AulaSeccion.setText(seccion);
                AulaHoras.setText(horas);
                idAulaActual = Integer.parseInt(valor);
            } else {
                this.propiedades.mostrarMensajeError("No se encontró un aula con el ID proporcionado", "/imagenes/emojiTriste.png", "ALERTA");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el aula: " + e.getMessage());
        }}}


// ELIMINAR AULA
public void eliminarAula() {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el ID del Aula", "/imagenes/emojiTriste.png", "ELIMINAR");
    if (valor != null && !valor.isEmpty()) {
        try {
            int idAula = Integer.parseInt(valor);
            String SQL = "DELETE FROM aulas WHERE ID_Aula = ?";
            PreparedStatement eliminar = con.prepareStatement(SQL);
            eliminar.setInt(1, idAula);
            int resultado = eliminar.executeUpdate();
            if (resultado > 0) {
                this.propiedades.mostrarMensajeError("Aula eliminada exitosamente", "/imagenes/emojiFeliz.png", "ALERTA");
            } else {
                this.propiedades.mostrarMensajeError("No se encontró un aula con la ID proporcionada", "/imagenes/emojiTriste.png", "ALERTA");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el aula: " + e.getMessage());
        }}}
}
