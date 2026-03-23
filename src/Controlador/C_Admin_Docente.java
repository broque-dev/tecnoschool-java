
package Controlador;

import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class C_Admin_Docente extends DAO.Conexion{
    private Propiedades propiedades;
    
//CARGAR COMBOBOX
public void cargarDatosEnComboBox(JComboBox Combo) {
    Connection con = conectar();
    try {
        Statement stmt = con.createStatement();
        String query = "SELECT Grado, Sección FROM aulas WHERE Disponibilidad = 'S'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String grado = rs.getString("Grado");
            String seccion = rs.getString("Sección");
            String concatenado = grado + " - " + seccion;
            Combo.addItem(concatenado);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos de las aulas: " + e.getMessage());
    }}


//MOSTRAR DOCENTES
public void mostrarDocentes(DefaultTableModel tabla) {
        String query = "SELECT * FROM administrar_docente";
        try (Connection con = conectar();
             Statement leer = con.createStatement();
             ResultSet resultado = leer.executeQuery(query)) {
            while (resultado.next()) {
                String idDocente = resultado.getString("ID_Docente");
                String nombre = resultado.getString("Nombre_Docente");
                String telefono = resultado.getString("Telefono_Docente");
                String dni = resultado.getString("DNI_Docente");
                String direccion = resultado.getString("Dirección_Docente");
                String fechaN = resultado.getString("FechaN_Docente");
                String aula = resultado.getString("Aula");
                String usuario = resultado.getString("Usuario");
                String contraseña = resultado.getString("Contraseña");
                tabla.addRow(new Object[]{idDocente, nombre, telefono, dni, direccion, fechaN, aula, usuario, contraseña});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener docentes: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }}

//REGISTRAR DOCENTE
public void registrarDocente(JTextField nombreDocente, JTextField telefonoDocente, JTextField dniDocente, JTextField direccionDocente,
                             JTextField usuarioDocente, JPasswordField contraseñaDocente, JComboBox<String> aulaDocente, JDateChooser fechaNacimiento) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    String nombre = nombreDocente.getText().trim();
    String telefono = telefonoDocente.getText().trim();
    String dni = dniDocente.getText().trim();
    String direccion = direccionDocente.getText().trim();
    String usuario = usuarioDocente.getText().trim();
    String contraseña = new String(contraseñaDocente.getPassword()).trim();
    String aula = obtenerIdAulaDesdeComboBox(aulaDocente.getSelectedItem().toString());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fechaNacimientoStr = sdf.format(fechaNacimiento.getDate());
    
    if (nombre.isEmpty() || telefono.isEmpty() || dni.isEmpty() || direccion.isEmpty() || usuario.isEmpty() || contraseña.isEmpty() || aula == null || fechaNacimiento.getDate() == null) {
        this.propiedades.mostrarMensajeError("Por favor, completa todos los campos antes de continuar", "/imagenes/emojiTriste.png", "ALERTA");
        return;
    }

    try (con) {
        con.setAutoCommit(false);
        String SQL = "INSERT INTO administrar_docente (Nombre_Docente, Telefono_Docente, DNI_Docente, Dirección_Docente, FechaN_Docente, Aula, Usuario, Contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertar = con.prepareStatement(SQL);
        insertar.setString(1, nombre);
        insertar.setString(2, telefono);
        insertar.setString(3, dni);
        insertar.setString(4, direccion);
        insertar.setString(5, fechaNacimientoStr);
        insertar.setString(6, aula);
        insertar.setString(7, usuario);
        insertar.setString(8, contraseña);
        int resultado = insertar.executeUpdate();

        if (resultado > 0) {
            String SQLUpdate = "UPDATE aulas SET Disponibilidad = 'N' WHERE ID_Aula = ?";
            PreparedStatement actualizarAula = con.prepareStatement(SQLUpdate);
            actualizarAula.setString(1, aula);
            int resultadoUpdate = actualizarAula.executeUpdate();

            if (resultadoUpdate > 0) {
                con.commit();
                this.propiedades.mostrarMensajeError("Docente registrado exitosamente", "/imagenes/emojiFeliz.png", "ALERTA");
            } else {
                con.rollback();
                this.propiedades.mostrarMensajeError("Error al actualizar la disponibilidad del aula", "/imagenes/emojiTriste.png", "ALERTA");
            }
        } else {
            con.rollback();
            this.propiedades.mostrarMensajeError("Error al registrar el docente", "/imagenes/emojiTriste.png", "ALERTA");
        }
    } catch (Exception e) {
        try {
            con.rollback();
        } catch (SQLException ex) {
            this.propiedades.mostrarMensajeError("Error al revertir la transacción: " + ex.getMessage(), "/imagenes/emojiTriste.png", "ERROR");
        }
        this.propiedades.mostrarMensajeError("Error al registrar el docente: " + e.getMessage(), "/imagenes/emojiTriste.png", "ERROR");
    } finally {
        try {
            con.setAutoCommit(true);
        } catch (SQLException e) {
            this.propiedades.mostrarMensajeError("Error al habilitar el autocommit: " + e.getMessage(), "/imagenes/emojiTriste.png", "ERROR");
        }}}

private String obtenerIdAulaDesdeComboBox(String aulaSeleccionada) {
    String[] partes = aulaSeleccionada.split(" - ");
    if (partes.length == 2) {
        String grado = partes[0];
        String seccion = partes[1];
        try (Connection con = conectar()) {
            String SQL = "SELECT ID_Aula FROM aulas WHERE Grado = ? AND Sección = ?";
            PreparedStatement obtener = con.prepareStatement(SQL);
            obtener.setString(1, grado);
            obtener.setString(2, seccion);
            ResultSet resultado = obtener.executeQuery();
            if (resultado.next()) {
                return resultado.getString("ID_Aula");
            } else {
                this.propiedades.mostrarMensajeError("No se encontró un aula con el Grado y Sección proporcionados.", "/imagenes/emojiTriste.png", "ERROR");
                return null;
            }
        } catch (SQLException e) {
            this.propiedades.mostrarMensajeError("Error al obtener el ID del aula: " + e.getMessage(), "/imagenes/emojiTriste.png", "ERROR");
            return null;
        }
    } else {
        this.propiedades.mostrarMensajeError("Formato de aula seleccionado no válido.", "/imagenes/emojiTriste.png", "ERROR");
        return null;
    }}

// EDITAR DOCENTE
public void editarDocente(JTextField jtxt_NombreDocente, JTextField jtxt_TelefonoDocente, JTextField jtxt_DNIDocente, 
                          JTextField jtxt_DireccionDocente, JTextField jtxt_UsuarioDocente, JPasswordField jtxt_AgregarContraseña, 
                          JComboBox<String> jcbx_AulaDocente, JDateChooser jDateFechaN) {
    Connection con = conectar();
    try {
        char[] contraseñaChars = jtxt_AgregarContraseña.getPassword();
        String nombre = jtxt_NombreDocente.getText();
        String telefono = jtxt_TelefonoDocente.getText();
        String dni = jtxt_DNIDocente.getText();
        String direccion = jtxt_DireccionDocente.getText();
        String usuario = jtxt_UsuarioDocente.getText();
        String contraseña = new String(contraseñaChars);
        String nuevaAula = obtenerIdAulaDesdeComboBox(jcbx_AulaDocente.getSelectedItem().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNacimiento = sdf.format(jDateFechaN.getDate());
        String aulaActual = obtenerAulaActual(con, dni);
        
        if (aulaActual == null) {
            this.propiedades.mostrarMensajeError("No se encontró el aula actual del docente", "/imagenes/emojiTriste.png", "ALERTA");
            return;
        }

        con.setAutoCommit(false);

        String SQL = "UPDATE administrar_docente SET Nombre_Docente = ?, Telefono_Docente = ?, DNI_Docente = ?, Dirección_Docente = ?, FechaN_Docente = ?, Aula = ?, Usuario = ?, Contraseña = ? WHERE DNI_Docente = ?";
        PreparedStatement actualizar = con.prepareStatement(SQL);
        actualizar.setString(1, nombre);
        actualizar.setString(2, telefono);
        actualizar.setString(3, dni);
        actualizar.setString(4, direccion);
        actualizar.setString(5, fechaNacimiento);
        actualizar.setString(6, nuevaAula);
        actualizar.setString(7, usuario);
        actualizar.setString(8, contraseña);
        actualizar.setString(9, dni);

        int resultado = actualizar.executeUpdate();
        if (resultado > 0) {
            // Actualizar la disponibilidad de las aulas
            if (!aulaActual.equals(nuevaAula)) {
                actualizarDisponibilidadAulas(con, aulaActual, nuevaAula);
            }
            con.commit();
            this.propiedades.mostrarMensajeError("Docente editado exitosamente", "/imagenes/emojiFeliz.png", "ALERTA");
        } else {
            con.rollback();
            this.propiedades.mostrarMensajeError("Error al editar el docente", "/imagenes/emojiTriste.png", "ALERTA");
        }
    } catch (Exception e) {
        manejarExcepcion(con, e, "Error al editar el docente");
    } finally {
        habilitarAutoCommit(con);
    }
}

private String obtenerAulaActual(Connection con, String dni) {
    try {
        String SQL = "SELECT Aula FROM administrar_docente WHERE DNI_Docente = ?";
        PreparedStatement obtener = con.prepareStatement(SQL);
        obtener.setString(1, dni);
        ResultSet resultado = obtener.executeQuery();
        if (resultado.next()) {
            return resultado.getString("Aula");
        } else {
            JOptionPane.showMessageDialog(null,"No se encontró un aula actual para el DNI proporcionado.");
            return null;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"Error al obtener el aula actual: " + e.getMessage());
        return null;
    }
}

private void actualizarDisponibilidadAulas(Connection con, String aulaActual, String nuevaAula) throws SQLException {
    // Poner disponibilidad del aula anterior en 'S'
    String SQLUpdateAnterior = "UPDATE aulas SET Disponibilidad = 'S' WHERE ID_Aula = ?";
    PreparedStatement actualizarAulaAnterior = con.prepareStatement(SQLUpdateAnterior);
    actualizarAulaAnterior.setString(1, aulaActual);
    int resultadoUpdateAnterior = actualizarAulaAnterior.executeUpdate();

    // Poner disponibilidad de la nueva aula en 'N'
    String SQLUpdateNueva = "UPDATE aulas SET Disponibilidad = 'N' WHERE ID_Aula = ?";
    PreparedStatement actualizarAulaNueva = con.prepareStatement(SQLUpdateNueva);
    actualizarAulaNueva.setString(1, nuevaAula);
    int resultadoUpdateNueva = actualizarAulaNueva.executeUpdate();

    if (resultadoUpdateAnterior <= 0 || resultadoUpdateNueva <= 0) {
        con.rollback();
        throw new SQLException("Error al actualizar la disponibilidad de las aulas");
    }
}

private void manejarExcepcion(Connection con, Exception e, String mensaje) {
    try {
        con.rollback();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al revertir la transacción: " + ex.getMessage());
    }
    JOptionPane.showMessageDialog(null, mensaje + ": " + e.getMessage());
}

private void habilitarAutoCommit(Connection con) {
    try {
        con.setAutoCommit(true);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al habilitar el autocommit: " + e.getMessage());
    }
}



//CONSULTAR DOCENTE POR DNI
public void consultarDNI(DefaultTableModel tabla, JTextField jtxt_NombreDocente, JTextField jtxt_TelefonoDocente,
                         JTextField jtxt_DNIDocente, JTextField jtxt_DireccionDocente, JTextField jtxt_UsuarioDocente,
                         JPasswordField jtxt_AgregarContraseña, JDateChooser jDateFechaN, JComboBox<String> jcbx_AulaDocente) {
    this.propiedades = new Propiedades();
    String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el DNI del Docente", "/imagenes/emojiFeliz.png", "CONSULTAR POR DNI");
    if (valor != null && !valor.isEmpty()) {
        try (Connection con = conectar()) {
            String SQL = "SELECT * FROM administrar_docente WHERE DNI_Docente = ?";
            PreparedStatement obtener = con.prepareStatement(SQL);
            obtener.setString(1, valor);
            ResultSet resultado = obtener.executeQuery();
            tabla.setRowCount(0);
            if (resultado.next()) {
                String idDocente = resultado.getString("ID_Docente");
                String nombre = resultado.getString("Nombre_Docente");
                String telefono = resultado.getString("Telefono_Docente");
                String dni = resultado.getString("DNI_Docente");
                String direccion = resultado.getString("Dirección_Docente");
                String fechaN = resultado.getString("FechaN_Docente");
                String aula = resultado.getString("Aula");
                String usuario = resultado.getString("Usuario");
                String contraseña = resultado.getString("Contraseña");
                tabla.addRow(new Object[]{idDocente, nombre, telefono, dni, direccion, fechaN, aula, usuario, contraseña});

                jtxt_NombreDocente.setText(nombre);
                jtxt_TelefonoDocente.setText(telefono);
                jtxt_DNIDocente.setText(dni);
                jtxt_DireccionDocente.setText(direccion);
                jtxt_UsuarioDocente.setText(usuario);
                jtxt_AgregarContraseña.setText(contraseña);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    jDateFechaN.setDate(sdf.parse(fechaN));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                cargarAulaEnComboBox(jcbx_AulaDocente, aula);
            } else {
                this.propiedades.mostrarMensajeError("No se encontró un docente con el DNI proporcionado", "/imagenes/emojiTriste.png", "ALERTA");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el docente: " + e.getMessage());
        }}}

private void cargarAulaEnComboBox(JComboBox<String> jcbx_AulaDocente, String aulaID) {
    try (Connection con = conectar()) {
        String SQL = "SELECT Grado, Sección FROM aulas WHERE ID_Aula = ?";
        PreparedStatement obtenerAula = con.prepareStatement(SQL);
        obtenerAula.setString(1, aulaID);
        ResultSet rs = obtenerAula.executeQuery();
        if (rs.next()) {
            String grado = rs.getString("Grado").trim();
            String seccion = rs.getString("Sección").trim();
            String concatenado = grado + " - " + seccion;
            boolean exists = false;
            for (int i = 0; i < jcbx_AulaDocente.getItemCount(); i++) {
                if (jcbx_AulaDocente.getItemAt(i).equals(concatenado)) {
                    exists = true;
                    break;
                }}
            if (!exists) {
                jcbx_AulaDocente.addItem(concatenado);
            }
            jcbx_AulaDocente.setSelectedItem(concatenado);
        } else {
            System.out.println("No se encontró el aula con el ID proporcionado: " + aulaID);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos del aula: " + e.getMessage());
    }}

//ELIMINAR DOCENTE
public void eliminarDocente() {
    this.propiedades = new Propiedades();
    String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el DNI del Docente", "/imagenes/emojiTriste.png", "ELIMINAR");
    if (valor != null && !valor.isEmpty()) {
        try (Connection con = conectar()) {
            String SQL = "DELETE FROM administrar_docente WHERE DNI_Docente = ?";
            PreparedStatement eliminar = con.prepareStatement(SQL);
            eliminar.setString(1, valor);
            int resultado = eliminar.executeUpdate();
            if (resultado > 0) {
                this.propiedades.mostrarMensajeError("Docente eliminado exitosamente", "/imagenes/emojiFeliz.png", "ALERTA");
            } else {
                this.propiedades.mostrarMensajeError("No se encontró un docente con el DNI proporcionado", "/imagenes/emojiTriste.png", "ALERTA");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el docente: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }}}
}