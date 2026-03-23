
package Controlador;

import Controlador.C_Login_TecnoSchool.DatosCompartidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class C_Docente_Asistencia extends DAO.Conexion{
    private Propiedades propiedades;

// CARGAR COMBOBOX
public void cargarDatosEnComboBox(JComboBox<String> comboBox) {
    Connection con = conectar();
    String usuarioGuardado = DatosCompartidos.getUsuario();
    String contraseñaGuardada = DatosCompartidos.getContraseña();
    String aulaDocente = null;
    String gradoDocente = null;

    try {
        // Obtener el Aula del docente
        PreparedStatement stmtDocente = con.prepareStatement(
            "SELECT Aula FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?");
        stmtDocente.setString(1, usuarioGuardado);
        stmtDocente.setString(2, contraseñaGuardada);
        ResultSet rsDocente = stmtDocente.executeQuery();
        if (rsDocente.next()) {
            aulaDocente = rsDocente.getString("Aula");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún docente con esos datos.");
            return;}

        // Obtener el Grado y ID_Aula correspondiente a ese Aula
        PreparedStatement stmtAula = con.prepareStatement(
            "SELECT ID_Aula, Grado FROM aulas WHERE ID_Aula = ?");
        stmtAula.setString(1, aulaDocente);
        ResultSet rsAula = stmtAula.executeQuery();
        if (rsAula.next()) {
            gradoDocente = rsAula.getString("Grado");
            aulaDocente = rsAula.getString("ID_Aula");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún aula con ese ID.");
            return;}

        // Construir la consulta SQL según el grado del docente
        String query;
        if ("ALL".equals(gradoDocente)) {
            query = "SELECT Grado, Sección FROM aulas WHERE Disponibilidad = 'N' AND Grado != 'ALL'";
        } else {
            query = "SELECT Grado, Sección FROM aulas WHERE Disponibilidad = 'N' AND ID_Aula = ?";}

        // Ejecutar la consulta SQL
        PreparedStatement stmtAulas = con.prepareStatement(query);
        if (!"ALL".equals(gradoDocente)) {
            stmtAulas.setString(1, aulaDocente);}
        ResultSet rsAulas = stmtAulas.executeQuery();

        // Limpiar el comboBox antes de agregar los nuevos datos
        comboBox.removeAllItems();

        // Agregar los datos al comboBox
        while (rsAulas.next()) {
            String grado = rsAulas.getString("Grado");
            String seccion = rsAulas.getString("Sección");
            String concatenado = grado + " - " + seccion;
            comboBox.addItem(concatenado);}
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos de las aulas: " + e.getMessage());
    }}


//MOSTRAR ASISTENCIA
public void mostrarAsistencia(DefaultTableModel asistencia, JTable jtbl_Asistencia) {
    Connection con = conectar();
    String contraseñaGuardada = DatosCompartidos.getContraseña();
    String usuarioGuardado = DatosCompartidos.getUsuario();

    String aula = null;
    String idAula = null;
    String grado = null;
    //System.out.println("Usuario: " + usuarioGuardado + ", Contraseña: " + contraseñaGuardada);
    try {
        // Obtener el Aula del docente
        PreparedStatement leer = con.prepareStatement(
            "SELECT Aula FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?");
        leer.setString(1, usuarioGuardado);
        leer.setString(2, contraseñaGuardada);
        ResultSet resultado = leer.executeQuery();
        if (resultado.next()) {
            aula = resultado.getString("Aula");

            // Obtener el ID_Aula y Grado de la tabla aulas
            PreparedStatement leerAula = con.prepareStatement(
                "SELECT ID_Aula, Grado FROM aulas WHERE ID_Aula = ?");
            leerAula.setString(1, aula);
            ResultSet resultadoAula = leerAula.executeQuery();
            if (resultadoAula.next()) {
                idAula = resultadoAula.getString("ID_Aula");
                grado = resultadoAula.getString("Grado");
            } else {
                System.out.println("No se encontró ningún aula con esos datos.");
                return;
            }
        } else {
            System.out.println("No se encontró ningún docente con esos datos.");
            return;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
        return;
    }
    
    // Limpiar la tabla
    asistencia.setRowCount(0);

    // Mostrar datos en la tabla de alumnos
    JComboBox<String> comboBox = new JComboBox<>();
    comboBox.addItem("Presente");
    comboBox.addItem("Tardanza");
    comboBox.addItem("Ausente");

    try {
        PreparedStatement leerEstudiantes;
        if ("ALL".equals(grado)) {
            // Seleccionar a todos los estudiantes del año actual
            leerEstudiantes = con.prepareStatement(
                "SELECT * FROM administrar_estudiante WHERE SUBSTRING(Periodo, 1, 4) = YEAR(NOW())");
        } else {
            // Seleccionar estudiantes del aula del docente del año actual
            leerEstudiantes = con.prepareStatement(
                "SELECT * FROM administrar_estudiante WHERE Aula = ? AND SUBSTRING(Periodo, 1, 4) = YEAR(NOW())");
            leerEstudiantes.setString(1, aula);
        }
        
        ResultSet resultadoEstudiantes = leerEstudiantes.executeQuery();
        while (resultadoEstudiantes.next()) {
            asistencia.addRow(new Object[]{
                    resultadoEstudiantes.getString("ID_Estudiante"),
                    resultadoEstudiantes.getString("Nombre"),
                    resultadoEstudiantes.getString("Periodo"),
                    "" // Deja el estado en blanco para que se muestre el combobox
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
    }
    // Configurar el editor de celdas para la columna del combobox
    jtbl_Asistencia.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBox));}


//MOSTRAR POR AULAS
public void mostrarEspecifico(DefaultTableModel asistencia, JTable jtbl_Asistencia, JComboBox<String> comboBox) {
    Connection con = conectar();
    String seleccion = (String) comboBox.getSelectedItem();
    if (seleccion == null || seleccion.isEmpty()) {
        return;
    }

    String[] partes = seleccion.split(" - ");
    String gradoSeleccionado = partes[0];
    String seccionSeleccionada = partes[1];

    String idAula = null;

    // Obtener el ID_Aula correspondiente al Grado y Sección seleccionados
    try {
        PreparedStatement leerAula = con.prepareStatement(
            "SELECT ID_Aula FROM aulas WHERE Grado = ? AND Sección = ?");
        leerAula.setString(1, gradoSeleccionado);
        leerAula.setString(2, seccionSeleccionada);
        ResultSet resultadoAula = leerAula.executeQuery();
        if (resultadoAula.next()) {
            idAula = resultadoAula.getString("ID_Aula");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el aula correspondiente al grado y sección seleccionados.");
            return;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el ID_Aula: " + e.getMessage());
        return;
    }

    // Limpiar la tabla
    asistencia.setRowCount(0);

    // Mostrar datos en la tabla de alumnos
    JComboBox<String> estadoComboBox = new JComboBox<>();
    estadoComboBox.addItem("Presente");
    estadoComboBox.addItem("Tardanza");
    estadoComboBox.addItem("Ausente");

    try {
        PreparedStatement leerEstudiantes = con.prepareStatement(
            "SELECT * FROM administrar_estudiante WHERE Aula = ? AND SUBSTRING(Periodo, 1, 4) = YEAR(NOW())");
        leerEstudiantes.setString(1, idAula);

        ResultSet resultadoEstudiantes = leerEstudiantes.executeQuery();
        while (resultadoEstudiantes.next()) {
            asistencia.addRow(new Object[]{
                resultadoEstudiantes.getString("ID_Estudiante"),
                resultadoEstudiantes.getString("Nombre"),
                resultadoEstudiantes.getString("Periodo"),
                "" // Deja el estado en blanco para que se muestre el combobox
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
    }
    // Configurar el editor de celdas para la columna del combobox
    jtbl_Asistencia.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(estadoComboBox));
}

//CONSULTAR ASISTENCIA
public void consultarAsistencia(JTable jtbl_Asistencia) {
    this.propiedades = new Propiedades();
    String fecha = this.propiedades.mostrarMensajeEntrada("Ingresa la fecha (YYYY-MM-DD)","/imagenes/emojiFeliz.png", "CONSULTAR");
    if (fecha != null && !fecha.isEmpty()) {
        String contraseñaGuardada = DatosCompartidos.getContraseña();
        String usuarioGuardado = DatosCompartidos.getUsuario();
        String aula = null;
        try {
            Connection con = conectar();
            PreparedStatement leer = con.prepareStatement(
                "SELECT Aula FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?"
            );
            leer.setString(1, usuarioGuardado);
            leer.setString(2, contraseñaGuardada);
            ResultSet resultado = leer.executeQuery();
            if (resultado.next()) {
                aula = resultado.getString("Aula");
                System.out.println("Docente encontrado:");
                System.out.println("Aula: " + aula);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún docente con esos datos.");
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
            return;
        }

        // Realizar la consulta de asistencias
        try {
            Connection con = conectar();
            String SQL = "SELECT * FROM asistencia WHERE Aula = ? AND Fecha = ?";
            PreparedStatement obtener = con.prepareStatement(SQL);
            obtener.setString(1, aula);
            obtener.setString(2, fecha);
            ResultSet resultado = obtener.executeQuery();
            DefaultTableModel asistencia = new DefaultTableModel();
            asistencia.addColumn("ID");
            asistencia.addColumn("Nombres");
            asistencia.addColumn("Periodo");
            asistencia.addColumn("Estado");
            asistencia.addColumn("Fecha");

            jtbl_Asistencia.setModel(asistencia);
            while (resultado.next()) {
                asistencia.addRow(new Object[]{
                    resultado.getString("ID_Estudiante"),
                    resultado.getString("Nombre"),
                    resultado.getString("Periodo"),
                    resultado.getString("Estado"),
                    resultado.getString("Fecha")
                });
            }
            if (asistencia.getRowCount() == 0) {
                this.propiedades.mostrarMensajeError("No se encontraron asistencias para la fecha proporcionada.", "/imagenes/emojiTriste.png", "ALERTA");
            }

            // Configurar el editor de celdas para la columna del combobox
            JComboBox<String> comboBox = new JComboBox<>();
            comboBox.addItem("Presente");
            comboBox.addItem("Tardanza");
            comboBox.addItem("Ausente");
            jtbl_Asistencia.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBox));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener las asistencias: " + e.getMessage());
        }}}

//GUARDAR ASISTENCIA
public void guardarAsistencia(JTable tablaAsistencia) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    String contraseñaGuardada = DatosCompartidos.getContraseña();
    String usuarioGuardado = DatosCompartidos.getUsuario();
    String aula = null;
    int contadorExitosos = 0; // Contador de registros exitosos
    
    try {
        PreparedStatement leer = con.prepareStatement(
            "SELECT Aula FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?"
        );
        leer.setString(1, usuarioGuardado);
        leer.setString(2, contraseñaGuardada);
        ResultSet resultado = leer.executeQuery();
        if (resultado.next()) {
            aula = resultado.getString("Aula");
            System.out.println("Docente encontrado:");
            System.out.println("Aula: " + aula);
        } else {
            System.out.println("No se encontró ningún docente con esos datos.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
    }

    // Obtener los valores seleccionados de los combobox y guardarlos en la base de datos
    for (int fila = 0; fila < tablaAsistencia.getRowCount(); fila++) {
        String nombre = (String) tablaAsistencia.getValueAt(fila, 1);
        String periodo = (String) tablaAsistencia.getValueAt(fila, 2);
        String estado = (String) tablaAsistencia.getValueAt(fila, 3);
        if (con != null) {
            String SQL = "INSERT INTO asistencia (Nombre, Aula, Periodo, Estado) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement obtener = con.prepareStatement(SQL);
                obtener.setString(1, nombre);
                obtener.setString(2, aula);
                obtener.setString(3, periodo);
                obtener.setString(4, estado);

                int resultadoUpdate = obtener.executeUpdate();
                if (resultadoUpdate > 0) {
                    contadorExitosos++; // Incrementar contador si el registro fue exitoso
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error de registro: " + e.getMessage());
            }}}

    // Mostrar mensaje con el contador de registros exitosos
    if (contadorExitosos > 0) {
        String mensaje = "Se realizaron " + contadorExitosos + " registros exitosos.";
        this.propiedades.mostrarMensajeError(mensaje, "/imagenes/emojiFeliz.png", "ALERTA");
    }}

//EDITAR ASISTENCIA
public void editarAsistencia(JTable tablaAsistencia) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    int filaSeleccionada = tablaAsistencia.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.", "Editar Asistencia", JOptionPane.WARNING_MESSAGE);
        return;
    }
    DefaultTableModel modelo = (DefaultTableModel) tablaAsistencia.getModel();
    String idEstudiante = (String) modelo.getValueAt(filaSeleccionada, 0);
    String nombre = (String) modelo.getValueAt(filaSeleccionada, 1);
    String periodo = (String) modelo.getValueAt(filaSeleccionada, 2);
    String estadoActual = (String) modelo.getValueAt(filaSeleccionada, 3);
    String fecha = (String) modelo.getValueAt(filaSeleccionada, 4);

    JComboBox<String> comboBox = new JComboBox<>();
    comboBox.addItem("Presente");
    comboBox.addItem("Tardanza");
    comboBox.addItem("Ausente");
    comboBox.setSelectedItem(estadoActual);
    int opcion = JOptionPane.showConfirmDialog(null, comboBox, "Editar Estado de Asistencia", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (opcion == JOptionPane.OK_OPTION) {
        String nuevoEstado = (String) comboBox.getSelectedItem();
        modelo.setValueAt(nuevoEstado, filaSeleccionada, 3);
        try {
            String SQL = "UPDATE asistencia SET Estado = ? WHERE ID_Estudiante = ? AND Nombre = ? AND Periodo = ? AND Fecha = ?";
            PreparedStatement actualizar = con.prepareStatement(SQL);
            actualizar.setString(1, nuevoEstado);
            actualizar.setString(2, idEstudiante);
            actualizar.setString(3, nombre);
            actualizar.setString(4, periodo);
            actualizar.setString(5, fecha);
            actualizar.executeUpdate();
            this.propiedades.mostrarMensajeError("Edición exitosa", "/imagenes/emojiFeliz.png", "ALERTA");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la asistencia: " + e.getMessage());
        }}}

//ACCION DEL COMBO BOX
public void agregarListenerComboBox(JComboBox<String> comboBox, DefaultTableModel asistencia, JTable jtbl_Asistencia) {
    comboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarEspecifico(asistencia, jtbl_Asistencia, comboBox);
        }
    });}

}

