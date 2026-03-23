
package Controlador;

import Controlador.C_Login_TecnoSchool.DatosCompartidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class C_Docente_Nota extends DAO.Conexion{
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

//CARGAR COMBOBOX CURSO
public void cargarCurso(JComboBox<String> comboBox){
    this.propiedades = new Propiedades();
    Connection con = conectar();
    String contraseñaGuardada = DatosCompartidos.getContraseña();
    String usuarioGuardado = DatosCompartidos.getUsuario();
    
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
        return;}
    
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
                    comboBox.addItem(resultadoNombreCurso.getString("Nombre"));
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());}
}

//MOSTRAR NOTAS
public void mostrarNotas(DefaultTableModel nota, JTable jtbl_Nota) {
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
    nota.setRowCount(0);

    
    // Mostrar datos en la tabla de alumnos
    JComboBox<String> comboBox_Nota = new JComboBox<>();
    for (int i = 1; i <= 20; i++) {
        comboBox_Nota.addItem(String.valueOf(i));
    }
    
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
            nota.addRow(new Object[]{
                    resultadoEstudiantes.getString("ID_Estudiante"),
                    resultadoEstudiantes.getString("Nombre"),
                    "" // Deja el estado en blanco para que se muestre el combobox
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
    }
    // Configurar el editor de celdas para las columnas de combobox
    jtbl_Nota.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBox_Nota));}

//MOSTRAR POR AULAS
public void mostrarNotasPorAula(DefaultTableModel nota, JTable jtbl_Nota, JComboBox<String> aulaBox) {
    Connection con = conectar();
    String contraseñaGuardada = DatosCompartidos.getContraseña();
    String usuarioGuardado = DatosCompartidos.getUsuario();
    String seleccionAula = (String) aulaBox.getSelectedItem();
    if (seleccionAula == null || seleccionAula.isEmpty()) {
        return;
    }

    String[] partes = seleccionAula.split(" - ");
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
    nota.setRowCount(0);

    JComboBox<String> notaComboBox = new JComboBox<>();
    for (int i = 1; i <= 20; i++) {
        notaComboBox.addItem(String.valueOf(i));
    }

    try {
        PreparedStatement leerEstudiantes = con.prepareStatement(
            "SELECT * FROM administrar_estudiante WHERE Aula = ? AND SUBSTRING(Periodo, 1, 4) = YEAR(NOW())");
        leerEstudiantes.setString(1, idAula);

        ResultSet resultadoEstudiantes = leerEstudiantes.executeQuery();
        while (resultadoEstudiantes.next()) {
            nota.addRow(new Object[]{
                resultadoEstudiantes.getString("ID_Estudiante"),
                resultadoEstudiantes.getString("Nombre"),
                "" // Deja el estado en blanco para que se muestre el combobox
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
    }
    // Configurar el editor de celdas para las columnas de combobox
    jtbl_Nota.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(notaComboBox));}

//ACCION DEL COMBO BOX
public void agregarListenerComboBox(JComboBox<String> comboBox, DefaultTableModel nota, JTable jtbl_Nota) {
    comboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarNotasPorAula(nota, jtbl_Nota, comboBox);
        }
    });}

// GUARDAR NOTAS
public void guardarNotas(JTable tablaNotas, JComboBox<String> bimestre, JComboBox<String> curso) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    String contraseñaGuardada = DatosCompartidos.getContraseña();
    String usuarioGuardado = DatosCompartidos.getUsuario();
    String seleccionBi = (String) bimestre.getSelectedItem();
    String seleccionCur = (String) curso.getSelectedItem();
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
            return;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
        return;
    }

    // Verificar que la tabla tiene al menos 5 columnas
    if (tablaNotas.getColumnCount() < 5) {
        JOptionPane.showMessageDialog(null, "La tabla debe tener al menos 5 columnas.");
        return;
    }

    // Obtener los valores seleccionados de la tabla y guardarlos en la base de datos
    for (int fila = 0; fila < tablaNotas.getRowCount(); fila++) {
        String nombre = (String) tablaNotas.getValueAt(fila, 1);
        String nota = (String) tablaNotas.getValueAt(fila, 4);
        if (con != null) {
            String SQL = "INSERT INTO nota (Nombre, Curso, Bimestre, Nota, ID_Aula) VALUES (?, ?, ?, ?, ?)";
            try {
                PreparedStatement obtener = con.prepareStatement(SQL);
                obtener.setString(1, nombre);
                obtener.setString(2, seleccionCur);
                obtener.setString(3, seleccionBi);
                obtener.setString(4, nota);
                obtener.setString(5, aula);

                int resultadoUpdate = obtener.executeUpdate();
                if (resultadoUpdate > 0) {
                    contadorExitosos++; // Incrementar contador si el registro fue exitoso
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error de registro: " + e.getMessage());
            } 
        } 
    }

    // Mostrar mensaje con el contador de registros exitosos
    if (contadorExitosos > 0) {
        String mensaje = "Se realizaron " + contadorExitosos + " registros exitosos.";
        this.propiedades.mostrarMensajeError(mensaje, "/imagenes/emojiFeliz.png", "ALERTA");
    }
}



//EDITAR NOTAS
public void editarNotas(JTable tablaNotas) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    int filaSeleccionada = tablaNotas.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.", "Editar Notas", JOptionPane.WARNING_MESSAGE);
        return;
    }
    DefaultTableModel modelo = (DefaultTableModel) tablaNotas.getModel();
    int idNota = (int) modelo.getValueAt(filaSeleccionada, 0);
    String nombre = (String) modelo.getValueAt(filaSeleccionada, 1);
    String curso = (String) modelo.getValueAt(filaSeleccionada, 2);
    String bimestre = (String) modelo.getValueAt(filaSeleccionada, 3);
    BigDecimal notaActual = (BigDecimal) modelo.getValueAt(filaSeleccionada, 4);

    JComboBox<String> comboBox = new JComboBox<>();
    for (int i = 1; i <= 20; i++) {
        comboBox.addItem(String.valueOf(i));
    }
    comboBox.setSelectedItem(notaActual.toString());
    int opcion = JOptionPane.showConfirmDialog(null, comboBox, "Editar Nota", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (opcion == JOptionPane.OK_OPTION) {
        String nuevaNota = (String) comboBox.getSelectedItem();
        modelo.setValueAt(new BigDecimal(nuevaNota), filaSeleccionada, 4);
        try {
            String SQL = "UPDATE nota SET Nota = ? WHERE ID_Nota = ?";
            PreparedStatement actualizar = con.prepareStatement(SQL);
            actualizar.setBigDecimal(1, new BigDecimal(nuevaNota));
            actualizar.setInt(2, idNota);
            actualizar.executeUpdate();
            this.propiedades.mostrarMensajeError("Edición exitosa", "/imagenes/emojiFeliz.png", "ALERTA");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la nota: " + e.getMessage());
        } } }


//CONSULTAR NOTAS
public void consultarNotas(JTable jtbl_Nota) {
    this.propiedades = new Propiedades();
    Connection con = conectar();
    String contraseñaGuardada = DatosCompartidos.getContraseña();
    String usuarioGuardado = DatosCompartidos.getUsuario();

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

    // Obtener datos seleccionados a través de diálogos de entrada
    JComboBox<String> comboBoxCurso = new JComboBox<>();
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
    }

    JComboBox<String> comboBoxBimestre = new JComboBox<>();
    // Llenar comboBoxBimestre con los bimestres
    comboBoxBimestre.addItem("1");
    comboBoxBimestre.addItem("2");
    comboBoxBimestre.addItem("3");

    JComboBox<String> comboBoxAula = new JComboBox<>();
    cargarDatosEnComboBox(comboBoxAula);

    // Mostrar diálogos para seleccionar curso, bimestre y aula
    Object[] message = {
        "Curso:", comboBoxCurso,
        "Bimestre:", comboBoxBimestre,
        "Aula:", comboBoxAula
    };
    int option = JOptionPane.showConfirmDialog(null, message, "Consultar Notas", JOptionPane.OK_CANCEL_OPTION);
    if (option != JOptionPane.OK_OPTION) {
        return; // Cancelar la consulta si se presiona Cancelar
    }

    String cursoSeleccionado = (String) comboBoxCurso.getSelectedItem();
    String bimestreSeleccionado = (String) comboBoxBimestre.getSelectedItem();
    String aulaSeleccionada = (String) comboBoxAula.getSelectedItem();

    // Obtener el ID_Aula correspondiente al aula seleccionada
    String[] partes = aulaSeleccionada.split(" - ");
    String gradoSeleccionado = partes[0];
    String seccionSeleccionada = partes[1];

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

    // Realizar la consulta de notas
    try {
        String SQL = "SELECT * FROM nota WHERE Curso = ? AND Bimestre = ? AND ID_Aula = ?";
        PreparedStatement obtener = con.prepareStatement(SQL);
        obtener.setString(1, cursoSeleccionado);
        obtener.setString(2, bimestreSeleccionado);
        obtener.setString(3, idAula);
        ResultSet resultado = obtener.executeQuery();
        DefaultTableModel notas = new DefaultTableModel();
        notas.addColumn("ID_Nota");
        notas.addColumn("Nombre");
        notas.addColumn("Curso");
        notas.addColumn("Bimestre");
        notas.addColumn("Nota");
        notas.addColumn("Fecha");  

        jtbl_Nota.setModel(notas);
        while (resultado.next()) {
            notas.addRow(new Object[]{
                resultado.getInt("ID_Nota"),
                resultado.getString("Nombre"),
                resultado.getString("Curso"),
                resultado.getString("Bimestre"),
                resultado.getBigDecimal("Nota"),
                resultado.getDate("Fecha")  
            });
        }
        if (notas.getRowCount() == 0) {
            this.propiedades.mostrarMensajeError("No se encontraron notas para el curso, bimestre y aula seleccionados.", "/imagenes/emojiTriste.png", "ALERTA");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener las notas: " + e.getMessage());
    }}

//CERRAR CILO ESCOLAR
public void cerrarCicloEscolar() {
    Connection con = conectar();
    this.propiedades = new Propiedades();
    Map<String, List<Integer>> estudiantePromedios = new HashMap<>();

    // Obtener credenciales guardadas
    String contraseñaGuardada = DatosCompartidos.getContraseña();
    String usuarioGuardado = DatosCompartidos.getUsuario();

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
                System.out.println("ID_Aula: " + idAula);
                System.out.println("Grado: " + grado);
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

    try {
        // Obtener todos los estudiantes y sus promedios del aula específica
        String obtenerPromediosSQL = "SELECT Nombre, Promedio FROM nota_prom WHERE ID_Aula = ?";
        PreparedStatement obtenerPromediosStmt = con.prepareStatement(obtenerPromediosSQL);
        obtenerPromediosStmt.setString(1, idAula);
        ResultSet rsPromedios = obtenerPromediosStmt.executeQuery();

        while (rsPromedios.next()) {
            String nombre = rsPromedios.getString("Nombre");
            int promedio = rsPromedios.getInt("Promedio");

            if (!estudiantePromedios.containsKey(nombre)) {
                estudiantePromedios.put(nombre, new ArrayList<>());
            }
            estudiantePromedios.get(nombre).add(promedio);
        }

        for (Map.Entry<String, List<Integer>> entry : estudiantePromedios.entrySet()) {
            String nombre = entry.getKey();
            List<Integer> promedios = entry.getValue();

            boolean todosMayoresA11 = promedios.stream().allMatch(p -> p > 11);
            if (todosMayoresA11) {
                // Verificar que el primer carácter del grado sea un número
                if (Character.isDigit(grado.charAt(0))) {
                    int numeroGrado = Integer.parseInt(grado.substring(0, 1));
                    int nuevoNumeroGrado = numeroGrado + 1;
                    String nuevoGrado = obtenerNuevoGrado(nuevoNumeroGrado);

                    // Obtener el nuevo ID_Aula
                    String obtenerNuevoAulaSQL = "SELECT ID_Aula FROM aulas WHERE Grado = ? AND Sección = (SELECT Sección FROM aulas WHERE ID_Aula = ?)";
                    PreparedStatement obtenerNuevoAulaStmt = con.prepareStatement(obtenerNuevoAulaSQL);
                    obtenerNuevoAulaStmt.setString(1, nuevoGrado);
                    obtenerNuevoAulaStmt.setString(2, idAula);
                    ResultSet rsNuevoAula = obtenerNuevoAulaStmt.executeQuery();

                    if (rsNuevoAula.next()) {
                        int nuevoIdAula = rsNuevoAula.getInt("ID_Aula");

                        // Actualizar la tabla administrar_estudiante
                        String actualizarEstudianteSQL = "UPDATE administrar_estudiante SET Aula = ? WHERE Nombre = ? AND Aula = ?";
                        PreparedStatement actualizarEstudianteStmt = con.prepareStatement(actualizarEstudianteSQL);
                        actualizarEstudianteStmt.setInt(1, nuevoIdAula);
                        actualizarEstudianteStmt.setString(2, nombre);
                        actualizarEstudianteStmt.setString(3, idAula);
                        actualizarEstudianteStmt.executeUpdate();
                    }
                } else {
                    System.out.println("El grado no tiene el formato esperado: " + grado);
                }
            }
        }

        // Eliminar registros de la tabla nota que tengan la misma ID_Aula
        String eliminarNotasSQL = "DELETE FROM nota WHERE ID_Aula = ?";
        PreparedStatement eliminarNotasStmt = con.prepareStatement(eliminarNotasSQL);
        eliminarNotasStmt.setString(1, idAula);
        eliminarNotasStmt.executeUpdate();

        // Eliminar registros de la tabla asistencia que tengan la misma Aula (ID_Aula)
        String eliminarAsistenciaSQL = "DELETE FROM asistencia WHERE Aula = ?";
        PreparedStatement eliminarAsistenciaStmt = con.prepareStatement(eliminarAsistenciaSQL);
        eliminarAsistenciaStmt.setString(1, idAula);
        eliminarAsistenciaStmt.executeUpdate();

        this.propiedades.mostrarMensajeError("Ciclo escolar cerrado exitosamente", "/imagenes/emojiFeliz.png", "ALERTA");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cerrar el ciclo escolar: " + e.getMessage());
    }
}

private String obtenerNuevoGrado(int numeroGrado) {
    switch (numeroGrado) {
        case 1: return "1ro";
        case 2: return "2do";
        case 3: return "3ro";
        case 4: return "4to";
        case 5: return "5to";
        case 6: return "6to";
        default: return "Invalid";
    }
}

}


