
package Controlador;

import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class C_Admin_Estudiante extends DAO.Conexion{
    private Propiedades propiedades;
    
//CARGAR COMBOBOX
public void cargarDatosEnComboBox(JComboBox Combo) {
    Connection con = conectar();
    try {
        Statement stmt = con.createStatement();
        String query = "SELECT Grado, Sección FROM aulas WHERE Disponibilidad = 'N' AND Grado != 'ALL'";
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

//MOSTRAR ESTUDIANTES
public void mostrarEstudiantes(DefaultTableModel tabla) {
        String query = "SELECT * FROM administrar_estudiante";
        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet resultado = ps.executeQuery()) {
            while (resultado.next()) {
                String idEstudiante = resultado.getString("ID_Estudiante");
                String name = resultado.getString("Nombre");
                String nacimiento = resultado.getString("Fecha_N");
                String dniEs = resultado.getString("DNI_Estu");
                String salon = resultado.getString("Aula");
                String perio = resultado.getString("Periodo");
                String direc = resultado.getString("Dirección");
                String apo = resultado.getString("Apoderado");
                String dniApo = resultado.getString("DNI_Apo");
                String telefono = resultado.getString("Teléfono");
                String registro = resultado.getString("Registro");
                tabla.addRow(new Object[]{idEstudiante, name, nacimiento, dniEs, salon, perio, direc, apo, dniApo, telefono, registro});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener estudiantes: " + e.getMessage());
        }}

//EDITAR ESTUDIANTE
public void editarEstudiante(JTextField nombreEstudiante, JTextField dniEstudiante, JTextField periodoEstudiante, JTextField direccionEstudiante,
                                 JTextField apoderadoEstudiante, JTextField dniApoderadoEstudiante, JTextField telefonoApoderado, JComboBox<String> aulaEstudiante,
                                 JDateChooser fechaNacimiento) {
        this.propiedades = new Propiedades();
        String nombre = nombreEstudiante.getText().trim();
        String dni = dniEstudiante.getText().trim();
        String periodo = periodoEstudiante.getText().trim();
        String direccion = direccionEstudiante.getText().trim();
        String apoderado = apoderadoEstudiante.getText().trim();
        String dniApoderado = dniApoderadoEstudiante.getText().trim();
        String telefono = telefonoApoderado.getText().trim();
        String aula = obtenerIdAulaDesdeComboBox(aulaEstudiante.getSelectedItem().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNStr = sdf.format(fechaNacimiento.getDate());

        if (nombre.isEmpty() || dni.isEmpty() || periodo.isEmpty() || direccion.isEmpty() || apoderado.isEmpty() || dniApoderado.isEmpty() || telefono.isEmpty()) {
            this.propiedades.mostrarMensajeError("Por favor, completa todos los campos antes de continuar", "/imagenes/emojiTriste.png", "ALERTA");
            return;}

        try (Connection con = conectar()) {
            String SQL = "UPDATE administrar_estudiante SET Nombre = ?, Fecha_N = ?, Aula = ?, Periodo = ?, Dirección = ?, Apoderado = ?, DNI_Apo = ?, Teléfono = ? WHERE DNI_Estu = ?";
            PreparedStatement editar = con.prepareStatement(SQL);
            editar.setString(1, nombre);
            editar.setString(2, fechaNStr);
            editar.setString(3, aula);
            editar.setString(4, periodo);
            editar.setString(5, direccion);
            editar.setString(6, apoderado);
            editar.setString(7, dniApoderado);
            editar.setString(8, telefono);
            editar.setString(9, dni);
            editar.executeUpdate();
            this.propiedades.mostrarMensajeError("Estudiante editado exitosamente", "/imagenes/emojiFeliz.png", "INFO");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar el estudiante: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }}


//REGISTRAR ESTUDIANTE
public void registrarEstudiante(JTextField nombreEstudiante, JTextField dniEstudiante, JTextField periodoEstudiante, JTextField direccionEstudiante,
                                    JTextField apoderadoEstudiante, JTextField dniApoderadoEstudiante, JTextField telefonoApoderado, JComboBox<String> aulaEstudiante,
                                    JDateChooser fechaNacimiento) {
        this.propiedades = new Propiedades();
        String nombre = nombreEstudiante.getText().trim();
        String dni = dniEstudiante.getText().trim();
        String periodo = periodoEstudiante.getText().trim();
        String direccion = direccionEstudiante.getText().trim();
        String apoderado = apoderadoEstudiante.getText().trim();
        String dniApoderado = dniApoderadoEstudiante.getText().trim();
        String telefono = telefonoApoderado.getText().trim();
        String aula = obtenerIdAulaDesdeComboBox(aulaEstudiante.getSelectedItem().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNStr = sdf.format(fechaNacimiento.getDate());
        java.util.Date fechaN = fechaNacimiento.getDate(); // Usar java.util.Date para la validación

        if (nombre.isEmpty() || dni.isEmpty() || periodo.isEmpty() || direccion.isEmpty() || apoderado.isEmpty() || dniApoderado.isEmpty() || telefono.isEmpty()) {
            this.propiedades.mostrarMensajeError("Por favor, completa todos los campos antes de continuar", "/imagenes/emojiTriste.png", "ALERTA");
            return;
        }
        // Obtener el grado de la opción seleccionada en el comboBox
        String grado = aulaEstudiante.getSelectedItem().toString().split(" - ")[0];
        // Verificar la edad del estudiante
        Calendar fechaNacimientoCal = Calendar.getInstance();
        fechaNacimientoCal.setTime(fechaN);
        Calendar fechaCorte = Calendar.getInstance();
        fechaCorte.set(fechaCorte.get(Calendar.YEAR), Calendar.JULY, 1);

        int edad = fechaCorte.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);
        if (fechaNacimientoCal.get(Calendar.MONTH) > Calendar.JULY ||
            (fechaNacimientoCal.get(Calendar.MONTH) == Calendar.JULY && fechaNacimientoCal.get(Calendar.DAY_OF_MONTH) > 1)) {
            edad--;
        }
        if (grado.equals("1ro") && edad < 6) {
            this.propiedades.mostrarMensajeError("El estudiante debe tener 6 años o cumplir 6 años hasta el mes de julio para inscribirse en 1ro.", "/imagenes/emojiTriste.png", "Edad no válida");
            return;
        }
        try (Connection con = conectar()) {
            String SQL = "INSERT INTO administrar_estudiante (Nombre, Fecha_N, DNI_Estu, Aula, Periodo, Dirección, Apoderado, DNI_Apo, Teléfono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertar = con.prepareStatement(SQL);
            insertar.setString(1, nombre);
            insertar.setString(2, fechaNStr); // Usar la fecha como string formateada
            insertar.setString(3, dni);
            insertar.setString(4, aula); 
            insertar.setString(5, periodo);
            insertar.setString(6, direccion);
            insertar.setString(7, apoderado);
            insertar.setString(8, dniApoderado);
            insertar.setString(9, telefono);
            insertar.executeUpdate();
            this.propiedades.mostrarMensajeError("Estudiante registrado exitosamente", "/imagenes/emojiFeliz.png", "INFO");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el estudiante: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

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
                    JOptionPane.showMessageDialog(null, "No se encontró un aula con el Grado y Sección proporcionados.", "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID del aula: " + e.getMessage());
                return null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Formato de aula seleccionado no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }}
    
//CONSULTA POR DNI
public void consultarDNI(DefaultTableModel tabla, JTextField jtxt_NombreEstudiante, JTextField jtxt_DNIEstudiante,
                             JTextField jtxt_PediodoEstudiante, JTextField jtxt_DireccionEstudiante, JTextField jtxt_ApoderadoEstudiante,
                             JTextField jtxt_DNIApoderado, JTextField jtxt_TelefonoApoderado, JTextField jtxt_RegistroEstudiante,
                             JDateChooser jDateFechaN, JComboBox<String> jcbx_AulaEstudiante) {
        this.propiedades = new Propiedades();
        String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el DNI del Estudiante", "/imagenes/emojiFeliz.png", "CONSULTAR POR DNI");
        if (valor != null && !valor.isEmpty()) {
            try (Connection con = conectar()) {
                String SQL = "SELECT * FROM administrar_estudiante WHERE DNI_Estu = ?";
                PreparedStatement obtener = con.prepareStatement(SQL);
                obtener.setString(1, valor);
                ResultSet resultado = obtener.executeQuery();
                tabla.setRowCount(0);
                if (resultado.next()) {
                    String idEstudiante = resultado.getString("ID_Estudiante");
                    String nombre = resultado.getString("Nombre");
                    String nacimiento = resultado.getString("Fecha_N");
                    String dniEs = resultado.getString("DNI_Estu");
                    String salon = resultado.getString("Aula");
                    String periodo = resultado.getString("Periodo");
                    String direccion = resultado.getString("Dirección");
                    String apoderado = resultado.getString("Apoderado");
                    String dniApo = resultado.getString("DNI_Apo");
                    String telefono = resultado.getString("Teléfono");
                    String registro = resultado.getString("Registro");
                    tabla.addRow(new Object[]{idEstudiante, nombre, nacimiento, dniEs, salon, periodo, direccion, apoderado, dniApo, telefono, registro});

                    jtxt_NombreEstudiante.setText(nombre);
                    jtxt_DNIEstudiante.setText(dniEs);
                    jtxt_PediodoEstudiante.setText(periodo);
                    jtxt_DireccionEstudiante.setText(direccion);
                    jtxt_ApoderadoEstudiante.setText(apoderado);
                    jtxt_DNIApoderado.setText(dniApo);
                    jtxt_TelefonoApoderado.setText(telefono);
                    jtxt_RegistroEstudiante.setText(registro);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        jDateFechaN.setDate(sdf.parse(nacimiento));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    cargarAulaEnComboBox(jcbx_AulaEstudiante, salon);
                } else {
                    this.propiedades.mostrarMensajeError("No se encontró un estudiante con el DNI proporcionado", "/imagenes/emojiTriste.png", "ALERTA");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener el estudiante: " + e.getMessage());
            }}}

    private void cargarAulaEnComboBox(JComboBox<String> jcbx_AulaEstudiante, String aulaID) {
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
                for (int i = 0; i < jcbx_AulaEstudiante.getItemCount(); i++) {
                    if (jcbx_AulaEstudiante.getItemAt(i).equals(concatenado)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    jcbx_AulaEstudiante.addItem(concatenado);
                }
                jcbx_AulaEstudiante.setSelectedItem(concatenado);
            } else {
                System.out.println("No se encontró el aula con el ID proporcionado: " + aulaID);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del aula: " + e.getMessage());
        }}

//CONSULTA POR AÑO DE REGISTRO
public void consultarAño(DefaultTableModel tabla) {
        this.propiedades = new Propiedades();
        String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el año de registro del Estudiante", "/imagenes/emojiFeliz.png", "CONSULTAR POR AÑO DE REGISTRO");
        if (valor != null && !valor.isEmpty()) {
            try (Connection con = conectar()) {
                String SQL = "SELECT * FROM administrar_estudiante WHERE YEAR(Registro) = ?";
                PreparedStatement obtener = con.prepareStatement(SQL);
                obtener.setInt(1, Integer.parseInt(valor));
                ResultSet resultado = obtener.executeQuery();
                tabla.setRowCount(0);
                while (resultado.next()) {
                    String idEstudiante = resultado.getString("ID_Estudiante");
                    String nombre = resultado.getString("Nombre");
                    String nacimiento = resultado.getString("Fecha_N");
                    String dniEstudiante = resultado.getString("DNI_Estu");
                    String aula = resultado.getString("Aula");
                    String periodo = resultado.getString("Periodo");
                    String direccion = resultado.getString("Dirección");
                    String apoderado = resultado.getString("Apoderado");
                    String dniApoderado = resultado.getString("DNI_Apo");
                    String telefono = resultado.getString("Teléfono");
                    String registro = resultado.getString("Registro");
                    tabla.addRow(new Object[]{idEstudiante, nombre, nacimiento, dniEstudiante, aula, periodo, direccion, apoderado, dniApoderado, telefono, registro});
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener los estudiantes: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un año válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }}}

//CONSULTA POR PERIODO
public void consultarPeriodo(DefaultTableModel tabla) {
        this.propiedades = new Propiedades();
        String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el periodo del Estudiante", "/imagenes/emojiFeliz.png", "CONSULTAR POR PERIODO");
        if (valor != null && !valor.isEmpty()) {
            try (Connection con = conectar()) {
                String SQL = "SELECT * FROM administrar_estudiante WHERE Periodo = ?";
                PreparedStatement obtener = con.prepareStatement(SQL);
                obtener.setString(1, valor);
                ResultSet resultado = obtener.executeQuery();
                tabla.setRowCount(0);
                while (resultado.next()) {
                    String idEstudiante = resultado.getString("ID_Estudiante");
                    String Name = resultado.getString("Nombre");
                    String Nacimiento = resultado.getString("Fecha_N");
                    String DNIEs = resultado.getString("DNI_Estu");
                    String Salon = resultado.getString("Aula");
                    String Perio = resultado.getString("Periodo");
                    String Direc = resultado.getString("Dirección");
                    String Apo = resultado.getString("Apoderado");
                    String DNIApo = resultado.getString("DNI_Apo");
                    String Telefono = resultado.getString("Teléfono");
                    String Registro = resultado.getString("Registro");
                    tabla.addRow(new Object[]{idEstudiante, Name, Nacimiento, DNIEs, Salon, Perio, Direc, Apo, DNIApo, Telefono, Registro});
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener los estudiantes: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }}}

//ELIMINAR ESTUDIANTE
public void eliminarEstudiante() {
        this.propiedades = new Propiedades();
        String valor = this.propiedades.mostrarMensajeEntrada("Ingresa el DNI del Estudiante", "/imagenes/emojiTriste.png", "ELIMINAR");
        if (valor != null && !valor.isEmpty()) {
            try (Connection con = conectar()) {
                String SQL = "DELETE FROM administrar_estudiante WHERE DNI_Estu = ?";
                PreparedStatement eliminar = con.prepareStatement(SQL);
                eliminar.setString(1, valor);
                int resultado = eliminar.executeUpdate();
                if (resultado > 0) {
                    this.propiedades.mostrarMensajeError("Estudiante eliminado exitosamente", "/imagenes/emojiFeliz.png", "ALERTA");
                } else {
                    this.propiedades.mostrarMensajeError("No se encontró un estudiante con el DNI proporcionado", "/imagenes/emojiTriste.png", "ALERTA");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el estudiante: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }}}
}
