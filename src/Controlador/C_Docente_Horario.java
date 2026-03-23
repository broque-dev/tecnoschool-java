
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class C_Docente_Horario extends DAO.Conexion{
    private Propiedades propiedades;
    
//MOSTRAR CURSOS
public void mostrarCursos(JComboBox<String> comboBoxCurso) {
    Connection con = conectar();
    String contraseñaGuardada = C_Login_TecnoSchool.DatosCompartidos.getContraseña();
    String usuarioGuardado = C_Login_TecnoSchool.DatosCompartidos.getUsuario();
    
    String aula = null;
    String idAula = null;
    String grado = null;

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

    // Insertar "Vacío" en el ComboBox
    comboBoxCurso.addItem("Vacío");

    // Obtener datos seleccionados a través de diálogos de entrada
    try {
        PreparedStatement leerDocente = con.prepareStatement("SELECT ID_Docente FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?");
        leerDocente.setString(1, usuarioGuardado);
        leerDocente.setString(2, contraseñaGuardada);
        ResultSet resultadoDocente = leerDocente.executeQuery();
        if (resultadoDocente.next()) {
            String idDocente = resultadoDocente.getString("ID_Docente");
            PreparedStatement leerCursos = con.prepareStatement("SELECT ID_Curso FROM docente_curso WHERE ID_Docente = ?");
            leerCursos.setString(1, idDocente);
            ResultSet resultadoCursos = leerCursos.executeQuery();
            while (resultadoCursos.next()) {
                PreparedStatement leerNombreCurso = con.prepareStatement(
                    "SELECT Nombre FROM curso WHERE ID_Curso = ?");
                leerNombreCurso.setString(1, resultadoCursos.getString("ID_Curso"));
                ResultSet resultadoNombreCurso = leerNombreCurso.executeQuery();
                if (resultadoNombreCurso.next()) {
                    comboBoxCurso.addItem(resultadoNombreCurso.getString("Nombre"));
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
    }}

// MOSTRAR AULAS
public void mostrarAulas(JComboBox<String> comboBox) {
    Connection con = conectar();
    String usuarioGuardado = C_Login_TecnoSchool.DatosCompartidos.getUsuario();
    String contraseñaGuardada = C_Login_TecnoSchool.DatosCompartidos.getContraseña();
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
            return;
        }

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
            return;
        }

        // Construir la consulta SQL según el grado del docente
        String query;
        if ("ALL".equals(gradoDocente)) {
            query = "SELECT Grado, Sección FROM aulas WHERE Disponibilidad = 'N' AND Grado != 'ALL'";
        } else {
            query = "SELECT Grado, Sección FROM aulas WHERE Disponibilidad = 'N' AND ID_Aula = ?";
        }

        // Ejecutar la consulta SQL
        PreparedStatement stmtAulas = con.prepareStatement(query);
        if (!"ALL".equals(gradoDocente)) {
            stmtAulas.setString(1, aulaDocente);
        }
        ResultSet rsAulas = stmtAulas.executeQuery();

        // Limpiar el comboBox antes de agregar los nuevos datos
        comboBox.removeAllItems();

        // Insertar "Vacío" en el ComboBox
        comboBox.addItem("Vacío");

        // Agregar los datos al comboBox
        while (rsAulas.next()) {
            String grado = rsAulas.getString("Grado");
            String seccion = rsAulas.getString("Sección");
            String concatenado = grado + " - " + seccion;
            comboBox.addItem(concatenado);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos de las aulas: " + e.getMessage());
    }}

// GUARDAR HORARIO
public void GuardarHorario(JTextField hotario) {
    Connection con = conectar();
    String contraseñaGuardada = C_Login_TecnoSchool.DatosCompartidos.getContraseña();
    String usuarioGuardado = C_Login_TecnoSchool.DatosCompartidos.getUsuario();
    int contadorExitosos = 0;
    String idDocente = null;
    String hora = hotario.getText();

    try {
        // Obtener el ID del docente
        PreparedStatement leerDocente = con.prepareStatement(
            "SELECT ID_Docente FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?");
        leerDocente.setString(1, usuarioGuardado);
        leerDocente.setString(2, contraseñaGuardada);
        ResultSet resultadoDocente = leerDocente.executeQuery();
        if (resultadoDocente.next()) {
            idDocente = resultadoDocente.getString("ID_Docente");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el docente correspondiente");
            return;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
        return;
    }

    // Variables para almacenar los datos de los días
    String[] cursos = new String[5];
    String[] aulas = new String[5];
    String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

    // Mostrar diálogos para seleccionar curso y aula para cada día
    for (int i = 0; i < dias.length; i++) {
        JComboBox<String> comboBoxCurso = new JComboBox<>();
        mostrarCursos(comboBoxCurso);

        JComboBox<String> comboBoxAula = new JComboBox<>();
        mostrarAulas(comboBoxAula);

        Object[] message = {
            "Día: " + dias[i],
            "Curso:", comboBoxCurso,
            "Aula:", comboBoxAula
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Registrar horario para " + dias[i], JOptionPane.OK_CANCEL_OPTION);
        if (option != JOptionPane.OK_OPTION) {
            return; // Cancelar la consulta si se presiona Cancelar
        }

        cursos[i] = (String) comboBoxCurso.getSelectedItem();
        aulas[i] = (String) comboBoxAula.getSelectedItem();
    }

    // Realizar el guardado de datos
    try {
        String SQL = "INSERT INTO horario (ID_Docente, hora, lunesCurso, lunesAula, martesCurso, martesAula, miercolesCurso, miercolesAula, juevesCurso, juevesAula, viernesCurso, viernesAula) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement obtener = con.prepareStatement(SQL);
        obtener.setString(1, idDocente);
        obtener.setString(2, hora);
        obtener.setString(3, cursos[0]);
        obtener.setString(4, aulas[0]);
        obtener.setString(5, cursos[1]);
        obtener.setString(6, aulas[1]);
        obtener.setString(7, cursos[2]);
        obtener.setString(8, aulas[2]);
        obtener.setString(9, cursos[3]);
        obtener.setString(10, aulas[3]);
        obtener.setString(11, cursos[4]);
        obtener.setString(12, aulas[4]);

        int resultadoUpdate = obtener.executeUpdate();
        if (resultadoUpdate > 0) {
            contadorExitosos++; // Incrementar contador si el registro fue exitoso
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error de registro: " + e.getMessage());
        return;
    }

    // Mostrar mensaje con el contador de registros exitosos
    if (contadorExitosos > 0) {
        String mensaje = "Se realizaron " + contadorExitosos + " registros exitosos.";
        JOptionPane.showMessageDialog(null, mensaje);
    }}

//MOSTRAR HORARIO
public void mostrarHorarioRegistrado(
    JTextField L1, JTextField M1, JTextField Mi1, JTextField J1, JTextField V1,
    JTextField L2, JTextField M2, JTextField Mi2, JTextField J2, JTextField V2,
    JTextField L3, JTextField M3, JTextField Mi3, JTextField J3, JTextField V3,
    JTextField L4, JTextField M4, JTextField Mi4, JTextField J4, JTextField V4,
    JTextField L5, JTextField M5, JTextField Mi5, JTextField J5, JTextField V5,
    JTextField L6, JTextField M6, JTextField Mi6, JTextField J6, JTextField V6) {
    
    Connection con = conectar();
    String usuarioGuardado = C_Login_TecnoSchool.DatosCompartidos.getUsuario();
    String contraseñaGuardada = C_Login_TecnoSchool.DatosCompartidos.getContraseña();

    try {
        // Obtener el ID del docente
        String idDocente = null;
        PreparedStatement leerDocente = con.prepareStatement(
            "SELECT ID_Docente FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?");
        leerDocente.setString(1, usuarioGuardado);
        leerDocente.setString(2, contraseñaGuardada);
        ResultSet resultadoDocente = leerDocente.executeQuery();

        if (resultadoDocente.next()) {
            idDocente = resultadoDocente.getString("ID_Docente");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el docente correspondiente");
            return;
        }

        // Definir los arrays para almacenar los cursos de cada período de tiempo
        String[] cursosLunes = new String[6];
        String[] cursosMartes = new String[6];
        String[] cursosMiercoles = new String[6];
        String[] cursosJueves = new String[6];
        String[] cursosViernes = new String[6];

        // Consultar y asignar cursos para cada período de tiempo
        consultarYAsignarHorario(con, idDocente, "7:45 - 8:30", cursosLunes, cursosMartes, cursosMiercoles, cursosJueves, cursosViernes, L1, M1, Mi1, J1, V1);
        consultarYAsignarHorario(con, idDocente, "8:30 - 9:15", cursosLunes, cursosMartes, cursosMiercoles, cursosJueves, cursosViernes, L2, M2, Mi2, J2, V2);
        consultarYAsignarHorario(con, idDocente, "9:15 - 10:00", cursosLunes, cursosMartes, cursosMiercoles, cursosJueves, cursosViernes, L3, M3, Mi3, J3, V3);
        consultarYAsignarHorario(con, idDocente, "10:30 - 11:15", cursosLunes, cursosMartes, cursosMiercoles, cursosJueves, cursosViernes, L4, M4, Mi4, J4, V4);
        consultarYAsignarHorario(con, idDocente, "11:15 - 12:00", cursosLunes, cursosMartes, cursosMiercoles, cursosJueves, cursosViernes, L5, M5, Mi5, J5, V5);
        consultarYAsignarHorario(con, idDocente, "12:00 - 12:45", cursosLunes, cursosMartes, cursosMiercoles, cursosJueves, cursosViernes, L6, M6, Mi6, J6, V6);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
    } finally {
        // Cerrar la conexión al finalizar
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // Manejar cualquier error al cerrar la conexión
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }}}}

private void consultarYAsignarHorario(Connection con, String idDocente, String hora,
    String[] cursosLunes, String[] cursosMartes, String[] cursosMiercoles,
    String[] cursosJueves, String[] cursosViernes,
    JTextField L, JTextField M, JTextField Mi, JTextField J, JTextField V) throws SQLException {

    // Consultar el horario para el docente y hora específica
    String SQL = "SELECT lunesCurso, martesCurso, miercolesCurso, juevesCurso, viernesCurso " +
                 "FROM horario " +
                 "WHERE ID_Docente = ? AND hora = ?";
    PreparedStatement obtenerHorario = con.prepareStatement(SQL);
    obtenerHorario.setString(1, idDocente);
    obtenerHorario.setString(2, hora);
    ResultSet resultadoHorario = obtenerHorario.executeQuery();

    // Obtener datos del resultado y asignar a los arrays
    if (resultadoHorario.next()) {
        int indice = obtenerIndiceHora(hora); // Obtener índice correspondiente al array
        cursosLunes[indice] = resultadoHorario.getString("lunesCurso");
        cursosMartes[indice] = resultadoHorario.getString("martesCurso");
        cursosMiercoles[indice] = resultadoHorario.getString("miercolesCurso");
        cursosJueves[indice] = resultadoHorario.getString("juevesCurso");
        cursosViernes[indice] = resultadoHorario.getString("viernesCurso");
        
        // Mostrar los cursos en los JTextFields correspondientes
        L.setText(cursosLunes[indice]);
        M.setText(cursosMartes[indice]);
        Mi.setText(cursosMiercoles[indice]);
        J.setText(cursosJueves[indice]);
        V.setText(cursosViernes[indice]);
    }}

// Método auxiliar para obtener el índice correspondiente al array de cursos
private int obtenerIndiceHora(String hora) {
    switch (hora) {
        case "7:45 - 8:30":
            return 0;
        case "8:30 - 9:15":
            return 1;
        case "9:15 - 10:00":
            return 2;
        case "10:30 - 11:15":
            return 3;
        case "11:15 - 12:00":
            return 4;
        case "12:00 - 12:45":
            return 5;
        default:
            return -1; // En caso de no encontrar coincidencia
    }}

// MOSTRAR HORARIO COMPLETO
public void mostrarHorarioCompleto(DefaultTableModel horario) {
    Connection con = conectar();
    String contraseñaGuardada = C_Login_TecnoSchool.DatosCompartidos.getContraseña();
    String usuarioGuardado = C_Login_TecnoSchool.DatosCompartidos.getUsuario();

    String idDocente = null;

    try {
        // Obtener el ID del docente
        PreparedStatement leerDocente = con.prepareStatement(
            "SELECT ID_Docente FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?");
        leerDocente.setString(1, usuarioGuardado);
        leerDocente.setString(2, contraseñaGuardada);
        ResultSet resultadoDocente = leerDocente.executeQuery();
        if (resultadoDocente.next()) {
            idDocente = resultadoDocente.getString("ID_Docente");
        } else {
            System.out.println("No se encontró ningún docente con esos datos.");
            return;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
        return;
    }

    // Limpiar la tabla
    horario.setRowCount(0);
    horario.setColumnCount(0);

    // Añadir las columnas especificadas
    horario.addColumn("Hora");
    horario.addColumn("Lu_Curso");
    horario.addColumn("Lu_Aula");
    horario.addColumn("Ma_Curso");
    horario.addColumn("Ma_Aula");
    horario.addColumn("Mi_Curso");
    horario.addColumn("Mi_Aula");
    horario.addColumn("Ju_Curso");
    horario.addColumn("Ju_Aula");
    horario.addColumn("Vi_Curso");
    horario.addColumn("Vi_Aula");

    try {
        PreparedStatement leerHorario = con.prepareStatement(
            "SELECT hora, lunesCurso, lunesAula, martesCurso, martesAula, miercolesCurso, miercolesAula, juevesCurso, juevesAula, viernesCurso, viernesAula " +
            "FROM horario WHERE ID_Docente = ?");
        leerHorario.setString(1, idDocente);
        ResultSet resultadoHorario = leerHorario.executeQuery();

        while (resultadoHorario.next()) {
            Object[] fila = new Object[11];
            fila[0] = resultadoHorario.getString("hora");
            fila[1] = resultadoHorario.getString("lunesCurso");
            fila[2] = resultadoHorario.getString("lunesAula");
            fila[3] = resultadoHorario.getString("martesCurso");
            fila[4] = resultadoHorario.getString("martesAula");
            fila[5] = resultadoHorario.getString("miercolesCurso");
            fila[6] = resultadoHorario.getString("miercolesAula");
            fila[7] = resultadoHorario.getString("juevesCurso");
            fila[8] = resultadoHorario.getString("juevesAula");
            fila[9] = resultadoHorario.getString("viernesCurso");
            fila[10] = resultadoHorario.getString("viernesAula");

            horario.addRow(fila);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
    } finally {
        // Cerrar la conexión al finalizar
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }}}}
}
