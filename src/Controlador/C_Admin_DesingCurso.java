
package Controlador;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class C_Admin_DesingCurso extends DAO.Conexion{
    private Propiedades propiedades;
    
    
//CARGAR COMBOBOX
public void cargarDatosEnComboBox(JComboBox Combo) {
    Connection con = conectar();
    try {
        Statement stmt = con.createStatement();
        String query = "SELECT nombre FROM curso";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String nombreCur = rs.getString("nombre");
            Combo.addItem(nombreCur);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos de los cursos: " + e.getMessage());
    }}
    
//MOSTRAR DESIGNACION  
public void mostrarDocenteCurso(DefaultTableModel tabla) {
    String query = "SELECT dc.ID_DocenteCurso, d.Nombre_Docente, c.Nombre AS Nombre_Curso " +
                   "FROM docente_curso dc " +
                   "JOIN administrar_docente d ON dc.ID_Docente = d.ID_Docente " +
                   "JOIN curso c ON dc.ID_Curso = c.ID_Curso";
    try (Connection con = conectar();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            int idDocenteCurso = rs.getInt("ID_DocenteCurso");
            String nombreDocente = rs.getString("Nombre_Docente");
            String nombreCurso = rs.getString("Nombre_Curso");
            tabla.addRow(new Object[]{idDocenteCurso, nombreDocente, nombreCurso});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }}

//CONSULTAR1 DESIGNACION
public void consultarDesignacion(DefaultTableModel tabla) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el DNI del Docente","/imagenes/emojiFeliz.png", "CONSULTAR");
    if (valor != null && !valor.isEmpty()) {
        try {
            // Consulta para obtener el ID_Docente
            String obtenerIdDocenteSQL = "SELECT ID_Docente FROM administrar_docente WHERE DNI_Docente = ?";
            PreparedStatement obtenerIdDocente = con.prepareStatement(obtenerIdDocenteSQL);
            obtenerIdDocente.setString(1, valor);
            ResultSet rsIdDocente = obtenerIdDocente.executeQuery();

            // Verificar si se encontró el ID_Docente
            if (rsIdDocente.next()) {
                int idDocente = rsIdDocente.getInt("ID_Docente");

                // Consulta para obtener los cursos del docente
                String obtenerCursosSQL = "SELECT dc.ID_DocenteCurso, d.Nombre_Docente, c.Nombre AS Nombre_Curso " +
                                          "FROM docente_curso dc " +
                                          "JOIN administrar_docente d ON dc.ID_Docente = d.ID_Docente " +
                                          "JOIN curso c ON dc.ID_Curso = c.ID_Curso " +
                                          "WHERE dc.ID_Docente = ?";
                PreparedStatement obtenerCursos = con.prepareStatement(obtenerCursosSQL);
                obtenerCursos.setInt(1, idDocente);
                ResultSet rsCursos = obtenerCursos.executeQuery();

                // Limpiar tabla y agregar resultados
                tabla.setRowCount(0);
                while (rsCursos.next()) {
                    int idDocenteCurso = rsCursos.getInt("ID_DocenteCurso");
                    String nombreDocente = rsCursos.getString("Nombre_Docente");
                    String nombreCurso = rsCursos.getString("Nombre_Curso");
                    tabla.addRow(new Object[]{idDocenteCurso, nombreDocente, nombreCurso});
                }
            } else {
                this.propiedades.mostrarMensajeError("No se encontró Designaciones con el DNI proporcionado", "/imagenes/emojiTriste.png", "ALERTA");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el curso: " + e.getMessage());}}
}

//REGISTRAR DESIGNACION
public void registrarDesignacion(JTextField DocenteDNI, JComboBox nombreCurso) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    if (DocenteDNI.getText().trim().isEmpty()) {
        this.propiedades.mostrarMensajeError("Por favor, completa todos los campos antes de continuar", "/imagenes/emojiTriste.png", "ALERTA");
        return;
    }
    if (con != null) {
        try {
            // Obtener ID_Docente a partir del DNI
            String obtenerIdDocenteSQL = "SELECT ID_Docente FROM administrar_docente WHERE DNI_Docente = ?";
            PreparedStatement obtenerIdDocente = con.prepareStatement(obtenerIdDocenteSQL);
            obtenerIdDocente.setString(1, DocenteDNI.getText());
            ResultSet rsIdDocente = obtenerIdDocente.executeQuery();
            if (rsIdDocente.next()) {
                int idDocente = rsIdDocente.getInt("ID_Docente");

                // Obtener ID_Curso a partir del nombre del curso seleccionado en el JComboBox
                String nombreCursoSeleccionado = nombreCurso.getSelectedItem().toString();
                String obtenerIdCursoSQL = "SELECT ID_Curso FROM curso WHERE nombre = ?";
                PreparedStatement obtenerIdCurso = con.prepareStatement(obtenerIdCursoSQL);
                obtenerIdCurso.setString(1, nombreCursoSeleccionado);
                ResultSet rsIdCurso = obtenerIdCurso.executeQuery();
                if (rsIdCurso.next()) {
                    int idCurso = rsIdCurso.getInt("ID_Curso");

                    // Insertar la designación en la tabla docente_curso
                    String insertDesignacionSQL = "INSERT INTO docente_curso (ID_Docente, ID_Curso) VALUES (?, ?)";
                    PreparedStatement insertDesignacion = con.prepareStatement(insertDesignacionSQL);
                    insertDesignacion.setInt(1, idDocente);
                    insertDesignacion.setInt(2, idCurso);
                    insertDesignacion.executeUpdate();

                    this.propiedades.mostrarMensajeError("Registro Exitoso", "/imagenes/emojiFeliz.png", "ALERTA");
                } else {
                    this.propiedades.mostrarMensajeError("No se encontró el ID_Curso correspondiente al nombre seleccionado", "/imagenes/emojiTriste.png", "ALERTA");
                }
            } else {
                this.propiedades.mostrarMensajeError("No se encontró el ID_Docente correspondiente al DNI ingresado", "/imagenes/emojiTriste.png", "ALERTA");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de registro: " + e.getMessage());
        }}}


//CONSULTA 2 CARGAR DATOS PARA EDITAR
public void cargarDatosSeleccionados(JTable tabla, JTextField DocenteDNI, JComboBox nombreCursoCombo) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    int filaSeleccionada = tabla.getSelectedRow();
    if (filaSeleccionada == -1) {
        this.propiedades.mostrarMensajeError("Por favor, selecciona una fila antes de editar", "/imagenes/emojiTriste.png", "ALERTA");
        return;
    }
    int idDocenteCurso = (int) tabla.getValueAt(filaSeleccionada, 0); // Suponiendo que la columna 0 es ID_DocenteCurso
    try {
        // Obtener ID_Docente y ID_Curso a partir de ID_DocenteCurso
        String obtenerDesignacionSQL = "SELECT ID_Docente, ID_Curso FROM docente_curso WHERE ID_DocenteCurso = ?";
        PreparedStatement obtenerDesignacion = con.prepareStatement(obtenerDesignacionSQL);
        obtenerDesignacion.setInt(1, idDocenteCurso);
        ResultSet rsDesignacion = obtenerDesignacion.executeQuery();
        if (rsDesignacion.next()) {
            int idDocente = rsDesignacion.getInt("ID_Docente");
            int idCurso = rsDesignacion.getInt("ID_Curso");

            // Obtener DNI del Docente a partir del ID_Docente
            String obtenerDniDocenteSQL = "SELECT DNI_Docente FROM administrar_docente WHERE ID_Docente = ?";
            PreparedStatement obtenerDniDocente = con.prepareStatement(obtenerDniDocenteSQL);
            obtenerDniDocente.setInt(1, idDocente);
            ResultSet rsDniDocente = obtenerDniDocente.executeQuery();
            if (rsDniDocente.next()) {
                String dniDocente = rsDniDocente.getString("DNI_Docente");
                DocenteDNI.setText(dniDocente);
            }

            // Obtener nombre del Curso a partir del ID_Curso
            String obtenerNombreCursoSQL = "SELECT nombre FROM curso WHERE ID_Curso = ?";
            PreparedStatement obtenerNombreCurso = con.prepareStatement(obtenerNombreCursoSQL);
            obtenerNombreCurso.setInt(1, idCurso);
            ResultSet rsNombreCurso = obtenerNombreCurso.executeQuery();
            if (rsNombreCurso.next()) {
                String nombreCurso = rsNombreCurso.getString("nombre");
                nombreCursoCombo.setSelectedItem(nombreCurso);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos de la designación: " + e.getMessage());
    }}


//GUARDAR EDICION
public void guardarEdicion(JTable tabla, JTextField DocenteDNI, JComboBox nombreCursoCombo) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    int filaSeleccionada = tabla.getSelectedRow();
    if (filaSeleccionada == -1) {
        this.propiedades.mostrarMensajeError("Por favor, selecciona una fila antes de guardar", "/imagenes/emojiTriste.png", "ALERTA");
        return;
    }
    int idDocenteCurso = (int) tabla.getValueAt(filaSeleccionada, 0); // Suponiendo que la columna 0 es ID_DocenteCurso
    try {
        // Obtener nuevo ID_Docente a partir del nuevo DNI
        String nuevoDniDocente = DocenteDNI.getText();
        String obtenerNuevoIdDocenteSQL = "SELECT ID_Docente FROM administrar_docente WHERE DNI_Docente = ?";
        PreparedStatement obtenerNuevoIdDocente = con.prepareStatement(obtenerNuevoIdDocenteSQL);
        obtenerNuevoIdDocente.setString(1, nuevoDniDocente);
        ResultSet rsNuevoIdDocente = obtenerNuevoIdDocente.executeQuery();
        if (rsNuevoIdDocente.next()) {
            int nuevoIdDocente = rsNuevoIdDocente.getInt("ID_Docente");

            // Obtener nuevo ID_Curso a partir del nuevo nombre del curso
            String nuevoNombreCurso = nombreCursoCombo.getSelectedItem().toString();
            String obtenerNuevoIdCursoSQL = "SELECT ID_Curso FROM curso WHERE nombre = ?";
            PreparedStatement obtenerNuevoIdCurso = con.prepareStatement(obtenerNuevoIdCursoSQL);
            obtenerNuevoIdCurso.setString(1, nuevoNombreCurso);
            ResultSet rsNuevoIdCurso = obtenerNuevoIdCurso.executeQuery();
            if (rsNuevoIdCurso.next()) {
                int nuevoIdCurso = rsNuevoIdCurso.getInt("ID_Curso");

                // Actualizar la tabla docente_curso con los nuevos valores
                String actualizarDesignacionSQL = "UPDATE docente_curso SET ID_Docente = ?, ID_Curso = ? WHERE ID_DocenteCurso = ?";
                PreparedStatement actualizarDesignacion = con.prepareStatement(actualizarDesignacionSQL);
                actualizarDesignacion.setInt(1, nuevoIdDocente);
                actualizarDesignacion.setInt(2, nuevoIdCurso);
                actualizarDesignacion.setInt(3, idDocenteCurso);
                actualizarDesignacion.executeUpdate();

                this.propiedades.mostrarMensajeError("Edición Exitosa", "/imagenes/emojiFeliz.png", "ALERTA");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al guardar los datos de la designación: " + e.getMessage());
    }}

//ELIMINAR DESIGNACION
public void eliminarDesignacion(JTable tabla) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    int filaSeleccionada = tabla.getSelectedRow();
    if (filaSeleccionada == -1) {
        this.propiedades.mostrarMensajeError("Por favor, selecciona una fila antes de eliminar", "/imagenes/emojiTriste.png", "ALERTA");
        return;
    }
    int idDocenteCurso = (int) tabla.getValueAt(filaSeleccionada, 0); // Suponiendo que la columna 0 es ID_DocenteCurso
    try {
        // Confirmar la eliminación
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar esta designación?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Eliminar el registro de la base de datos
            String eliminarDesignacionSQL = "DELETE FROM docente_curso WHERE ID_DocenteCurso = ?";
            PreparedStatement eliminarDesignacion = con.prepareStatement(eliminarDesignacionSQL);
            eliminarDesignacion.setInt(1, idDocenteCurso);
            eliminarDesignacion.executeUpdate();

            // Eliminar la fila de la tabla en la interfaz
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.removeRow(filaSeleccionada);

            this.propiedades.mostrarMensajeError("Eliminación Exitosa", "/imagenes/emojiFeliz.png", "ALERTA");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar la designación: " + e.getMessage());
    }}

}
