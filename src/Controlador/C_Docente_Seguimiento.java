
package Controlador;

import Controlador.C_Login_TecnoSchool.DatosCompartidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class C_Docente_Seguimiento extends DAO.Conexion{
    private Propiedades propiedades;
    
// CARGAR COMBOBOX
public void cargarDatosEnComboBox(JComboBox<String> comboBox) {
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

// Método para obtener el ID_Aula del docente
public String obtenerIDAula(String usuario, String contraseña) {
    String aula = null;
    try (Connection con = conectar()) {
        PreparedStatement leer = con.prepareStatement(
            "SELECT Aula FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?");
        leer.setString(1, usuario);
        leer.setString(2, contraseña);
        ResultSet resultado = leer.executeQuery();
        if (resultado.next()) {
            aula = resultado.getString("Aula");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el ID_Aula: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return aula;
}

// Método para mostrar seguimiento
public void mostrarSeguimiento(DefaultTableModel tabla) {
    String aula = obtenerIDAula(DatosCompartidos.getUsuario(), DatosCompartidos.getContraseña());
    if (aula == null) {
        JOptionPane.showMessageDialog(null, "No se encontró ningún docente con esos datos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String queryNotaProm = "SELECT Nombre, Curso, Promedio FROM nota_prom WHERE ID_Aula = ?";
    String queryNotaPromBi = "SELECT Nombre, Curso, Bimestre, Promedio FROM nota_prombi WHERE ID_Aula = ?";
    String queryAsistencia = "SELECT Nombre, Aula, Estado FROM asistencia WHERE Aula = ?";
    Map<String, Map<String, float[]>> bimestreMap = new HashMap<>();
    Map<String, Integer> faltasMap = new HashMap<>();

    try (Connection con = conectar();
         PreparedStatement psNotaProm = con.prepareStatement(queryNotaProm);
         PreparedStatement psNotaPromBi = con.prepareStatement(queryNotaPromBi);
         PreparedStatement psAsistencia = con.prepareStatement(queryAsistencia)) {

        psNotaProm.setString(1, aula);
        psNotaPromBi.setString(1, aula);
        psAsistencia.setString(1, aula);

        try (ResultSet rsNotaProm = psNotaProm.executeQuery();
             ResultSet rsNotaPromBi = psNotaPromBi.executeQuery();
             ResultSet rsAsistencia = psAsistencia.executeQuery()) {

        // Procesar los datos de la tabla nota_prombi
        while (rsNotaPromBi.next()) {
            String nombre = rsNotaPromBi.getString("Nombre");
            String curso = rsNotaPromBi.getString("Curso");
            int bimestre = rsNotaPromBi.getInt("Bimestre");
            float promedio = rsNotaPromBi.getFloat("Promedio");

            bimestreMap.putIfAbsent(nombre, new HashMap<>());
            Map<String, float[]> cursoMap = bimestreMap.get(nombre);
            cursoMap.putIfAbsent(curso, new float[3]);
            float[] promedios = cursoMap.get(curso);

            if (bimestre >= 1 && bimestre <= 3) {
                promedios[bimestre - 1] = promedio;
            }
        }
        
        // Procesar los datos de la tabla asistencia 
        while (rsAsistencia.next()) {
            String nombre = rsAsistencia.getString("Nombre");
            String estado = rsAsistencia.getString("Estado");

            if (estado.equalsIgnoreCase("Ausente")) {
                faltasMap.put(nombre, faltasMap.getOrDefault(nombre, 0) + 1);
            }
        }
        
        // Procesar los datos de la tabla nota_prom y combinarlos con los datos de nota_prombi y asistencia
        while (rsNotaProm.next()) {
            String nombre = rsNotaProm.getString("Nombre");
            String curso = rsNotaProm.getString("Curso");
            float promedioFinal = rsNotaProm.getFloat("Promedio");

            float[] promedios = bimestreMap.getOrDefault(nombre, new HashMap<>()).getOrDefault(curso, new float[3]);
            float promedioB1 = promedios[0];
            float promedioB2 = promedios[1];
            float promedioB3 = promedios[2];

            String observacion = promedioFinal < 11 ? "Debe mejorar " + curso : "Sin observaciones";
            int faltas = faltasMap.getOrDefault(nombre, 0);

            tabla.addRow(new Object[]{nombre, curso, observacion, faltas, promedioB1, promedioB2, promedioB3, promedioFinal});
        }}
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener notas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }}

// Método para mostrar seguimiento específico según lo seleccionado en un JComboBox
public void mostrarSeguimientoEspecifico(DefaultTableModel tabla, JComboBox<String> comboBox) {
    String seleccion = (String) comboBox.getSelectedItem();
    if (seleccion == null || seleccion.isEmpty()) {
        return;
    }

    String[] partes = seleccion.split(" - ");
    String gradoSeleccionado = partes[0];
    String seccionSeleccionada = partes[1];

    String idAula = null;

    // Obtener el ID_Aula correspondiente al Grado y Sección seleccionados
    try (Connection con = conectar();
         PreparedStatement leerAula = con.prepareStatement(
            "SELECT ID_Aula FROM aulas WHERE Grado = ? AND Sección = ?")) {

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
    tabla.setRowCount(0);
    
    // Mostrar datos en la tabla 
    String queryNotaProm = "SELECT Nombre, Curso, Promedio FROM nota_prom WHERE ID_Aula = ?";
    String queryNotaPromBi = "SELECT Nombre, Curso, Bimestre, Promedio FROM nota_prombi WHERE ID_Aula = ?";
    String queryAsistencia = "SELECT Nombre, Aula, Estado FROM asistencia WHERE Aula = ?";
    Map<String, Map<String, float[]>> bimestreMap = new HashMap<>();
    Map<String, Integer> faltasMap = new HashMap<>();

    try (Connection con = conectar();
         PreparedStatement psNotaProm = con.prepareStatement(queryNotaProm);
         PreparedStatement psNotaPromBi = con.prepareStatement(queryNotaPromBi);
         PreparedStatement psAsistencia = con.prepareStatement(queryAsistencia)) {

        psNotaProm.setString(1, idAula);
        psNotaPromBi.setString(1, idAula);
        psAsistencia.setString(1, idAula);

        try (ResultSet rsNotaProm = psNotaProm.executeQuery();
             ResultSet rsNotaPromBi = psNotaPromBi.executeQuery();
             ResultSet rsAsistencia = psAsistencia.executeQuery()) {

        // Procesar los datos de la tabla nota_prombi
        while (rsNotaPromBi.next()) {
            String nombre = rsNotaPromBi.getString("Nombre");
            String curso = rsNotaPromBi.getString("Curso");
            int bimestre = rsNotaPromBi.getInt("Bimestre");
            float promedio = rsNotaPromBi.getFloat("Promedio");

            bimestreMap.putIfAbsent(nombre, new HashMap<>());
            Map<String, float[]> cursoMap = bimestreMap.get(nombre);
            cursoMap.putIfAbsent(curso, new float[3]);
            float[] promedios = cursoMap.get(curso);

            if (bimestre >= 1 && bimestre <= 3) {
                promedios[bimestre - 1] = promedio;
            }
        }
        
        // Procesar los datos de la tabla asistencia 
        while (rsAsistencia.next()) {
            String nombre = rsAsistencia.getString("Nombre");
            String estado = rsAsistencia.getString("Estado");

            if (estado.equalsIgnoreCase("Ausente")) {
                faltasMap.put(nombre, faltasMap.getOrDefault(nombre, 0) + 1);
            }
        }
        
        // Procesar los datos de la tabla nota_prom y combinarlos con los datos de nota_prombi y asistencia
        while (rsNotaProm.next()) {
            String nombre = rsNotaProm.getString("Nombre");
            String curso = rsNotaProm.getString("Curso");
            float promedioFinal = rsNotaProm.getFloat("Promedio");

            float[] promedios = bimestreMap.getOrDefault(nombre, new HashMap<>()).getOrDefault(curso, new float[3]);
            float promedioB1 = promedios[0];
            float promedioB2 = promedios[1];
            float promedioB3 = promedios[2];

            String observacion = promedioFinal < 11 ? "Debe mejorar " + curso : "Sin observaciones";
            int faltas = faltasMap.getOrDefault(nombre, 0);

            tabla.addRow(new Object[]{nombre, curso, observacion, faltas, promedioB1, promedioB2, promedioB3, promedioFinal});
        }}
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener notas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


//ACCION DEL COMBO BOX
public void agregarListenerComboBox(DefaultTableModel tabla, JComboBox<String> comboBox) {
    comboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarSeguimientoEspecifico(tabla, comboBox);
        }
    });}


}
