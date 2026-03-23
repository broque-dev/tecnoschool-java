
package Controlador;

import Controlador.Propiedades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class C_Admin_Cursos extends DAO.Conexion{
    private Propiedades propiedades;
    private int idCursoActual;
    

//MOSTRAR CURSOS
public void mostrarCursos(DefaultTableModel tabla) {
    String query = "SELECT * FROM curso";
    try (Connection con = conectar();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet resultado = ps.executeQuery()) {
        while (resultado.next()) {
            String idCurso = resultado.getString("ID_Curso");
            String Nombres = resultado.getString("Nombre");
            String Descripcion = resultado.getString("Descripción");
            tabla.addRow(new Object[]{idCurso, Nombres, Descripcion});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener cursos: " + e.getMessage());
    }}


//REGISTRAR CURSOS
public void registrarCurso(JTextField nombreCurso, JTextArea descripcionCurso) {
        this.propiedades = new Propiedades();
        Connection con = conectar();
        if (nombreCurso.getText().trim().isEmpty() || descripcionCurso.getText().trim().isEmpty()) {
            this.propiedades.mostrarMensajeError("Por favor, completa todos los campos antes de continuar", "/imagenes/emojiTriste.png", "ALERTA");
            return;
        }
        if (con != null) {
            String SQL = "INSERT INTO curso (Nombre, Descripción) values (?, ?)";
            try {
                PreparedStatement obtener = con.prepareStatement(SQL);
                obtener.setString(1, nombreCurso.getText());
                obtener.setString(2, descripcionCurso.getText());
                obtener.executeUpdate();
                this.propiedades.mostrarMensajeError("Registro Exitoso", "/imagenes/emojiFeliz.png", "ALERTA");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de registro: " + e.getMessage());
            }}}

//EDITAR CURSOS
public void editarCurso(JTextField nombreCurso, JTextArea descripcionCurso) {
        this.propiedades = new Propiedades();
        Connection con = conectar();
        if (nombreCurso.getText().trim().isEmpty() || descripcionCurso.getText().trim().isEmpty()) {
        this.propiedades.mostrarMensajeError("Por favor, completa todos los campos antes de continuar", "/imagenes/emojiTriste.png", "ALERTA");
            return;
        }
        if (con != null) {
            try {
                String SQLUpdate = "UPDATE curso SET Nombre = ?, Descripción = ? WHERE ID_Curso = ?";
                PreparedStatement actualizar = con.prepareStatement(SQLUpdate);
                actualizar.setString(1, nombreCurso.getText());
                actualizar.setString(2, descripcionCurso.getText());
                actualizar.setInt(3, idCursoActual);
                actualizar.executeUpdate();
                this.propiedades.mostrarMensajeError("Edición exitosa", "/imagenes/emojiFeliz.png", "ALERTA");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de edición: " + e.getMessage());
            }}}

//CONSULTAR CURSOS
public void consultarCurso(JTextField nombreCurso, JTextArea descripcionCurso, DefaultTableModel tabla) {
        this.propiedades = new Propiedades();
        Connection con = conectar();
        String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el ID del Curso","/imagenes/emojiFeliz.png", "CONSULTAR");
        if (valor != null && !valor.isEmpty()) {
            try {
                String SQL = "SELECT * FROM curso WHERE ID_Curso = ?";
                PreparedStatement obtener = con.prepareStatement(SQL);
                obtener.setInt(1, Integer.parseInt(valor));
                ResultSet resultado = obtener.executeQuery();
                tabla.setRowCount(0);
                if (resultado.next()) {
                    String idCurso = resultado.getString("ID_Curso");
                    String nombreActual = resultado.getString("Nombre");
                    String descripcionActual = resultado.getString("Descripción");
                    tabla.addRow(new Object[]{idCurso, nombreActual, descripcionActual});
                    nombreCurso.setText(nombreActual);
                    descripcionCurso.setText(descripcionActual);
                    idCursoActual = Integer.parseInt(valor);
                } else {
                    this.propiedades.mostrarMensajeError("No se encontró un curso con el ID proporcionado", "/imagenes/emojiTriste.png", "ALERTA");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al obtener el curso: " + e.getMessage());
            }}}

//ELIMINAR CURSO
public void eliminarCurso() {
        this.propiedades = new Propiedades();
        Connection con = conectar();
        String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el ID del Curso","/imagenes/emojiTriste.png", "ELIMINAR");
        if (valor != null && !valor.isEmpty()) {
            try {
                int idCurso = Integer.parseInt(valor);
                String SQL = "DELETE FROM curso WHERE ID_Curso = ?";
                PreparedStatement eliminar = con.prepareStatement(SQL);
                eliminar.setInt(1, idCurso);
                int resultado = eliminar.executeUpdate();
                if (resultado > 0) {
                    this.propiedades.mostrarMensajeError("Curso eliminado exitosamente", "/imagenes/emojiFeliz.png", "ALERTA");
                } else {
                    this.propiedades.mostrarMensajeError("No se encontró un curso con el ID proporcionado", "/imagenes/emojiTriste.png", "ALERTA");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el curso: " + e.getMessage());
            }}}

}
