package Controlador;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import Controlador.C_Login_TecnoSchool.DatosCompartidos;
import javax.swing.SwingUtilities;

public class C_Docente_Retroalimentación extends DAO.Conexion {

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

public void mostrarChatbot(JTextArea chatbot, JTextField entrada) {
    SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
        @Override
        protected Void doInBackground() throws Exception {
            String aula = obtenerIDAula(DatosCompartidos.getUsuario(), DatosCompartidos.getContraseña());
            if (aula == null) {
                throw new SQLException("No se encontró ningún docente con esos datos.");
            }

            String queryNotaProm = "SELECT Nombre, Curso, Promedio FROM nota_prom WHERE ID_Aula = ?";
            StringBuilder mensaje = new StringBuilder();

            try (Connection con = conectar();
                 PreparedStatement psNotaProm = con.prepareStatement(queryNotaProm)) {

                psNotaProm.setString(1, aula);

                try (ResultSet rsNotaProm = psNotaProm.executeQuery()) {

                    while (rsNotaProm.next()) {
                        String nombre = rsNotaProm.getString("Nombre");
                        String curso = rsNotaProm.getString("Curso");
                        float promedioFinal = rsNotaProm.getFloat("Promedio");

                        if (promedioFinal < 11) {
                            mensaje.append("Chatbot: El alumno ").append(nombre)
                                    .append(" tiene un promedio de ").append(promedioFinal)
                                    .append(" en el curso ").append(curso).append(".\n");
                        }
                    }
                }
            } catch (SQLException e) {
                publish("Error al obtener notas: " + e.getMessage());
            }

            publish("Chatbot: Bienvenido al sistema de retroalimentación.\n");
            publish("Chatbot: ¿Desea abrir un curso? (si/no)\n");

            publish(mensaje.toString()); // Publicar el mensaje final después de la consulta

            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            for (String message : chunks) {
                chatbot.append(message + "\n"); // Mostrar cada mensaje en el JTextArea
            }
        }
    };

    worker.execute(); // Ejecutar el SwingWorker
}


// Método para manejar la entrada del usuario
private void handleEntrada(JTextField entrada, JTextArea chatbot) {
    entrada.addActionListener(evt -> {
        String mensajeUsuario = entrada.getText().trim();
        chatbot.append("Tú: " + mensajeUsuario + "\n");

        entrada.setText(""); // Limpiar la entrada inmediatamente

        if (mensajeUsuario.equalsIgnoreCase("si")) {
            chatbot.append("Chatbot: Dígame qué curso desea abrir?\n");
        } else if (mensajeUsuario.equalsIgnoreCase("no")) {
            chatbot.append("Chatbot: Gracias por su consulta.\n");
            entrada.setEnabled(false); // Deshabilitar entrada si el usuario decide no abrir más cursos
        } else {
            abrirCarpetaSegunCurso(mensajeUsuario);
            if (entrada.isEnabled()) { // Verificar si la entrada está habilitada antes de mostrar el mensaje
                chatbot.append("Chatbot: ¿Desea abrir otro curso? (si/no)\n");
            }
        }
    });
}

// Método para abrir carpetas según el curso
private void abrirCarpetaSegunCurso(String curso) {
    String url;
    switch (curso.toLowerCase()) {
        case "matemática":
            url = "https://drive.google.com/drive/folders/1Zwsv62E2ysWfcRI8xL8JgaAyPmCg59mS";
            break;
        case "comunicación":
            url = "https://drive.google.com/drive/folders/1p3xSnQj6Ak130qCwe-PMiOGra9Ld6LU7";
            break;
        case "inglés":
            url = "https://drive.google.com/drive/folders/17KI0p-nuUX69lbqfnMdw-ZAvBlBz0ax0";
            break;
        case "ed física":
            url = "https://drive.google.com/drive/folders/1HY9FlFARV165HfnxpGAS4PbJ7m6sSSP6";
            break;
        case "computación":
            url = "https://drive.google.com/drive/folders/1R2S2ua2x2sP4rMvwBL0sXcE1hT9tyS0U";
            break;
        default:
            return; // En caso de no reconocer el curso, no hacer nada
    }

    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    } else {
        System.err.println("Desktop o browse no soportado");
    }
}

// Método para mostrar datos en el JTextArea
    public void mostrarChat(JTextArea textArea) {
        SwingUtilities.invokeLater(() -> {
            String aula = obtenerIDAula(DatosCompartidos.getUsuario(), DatosCompartidos.getContraseña());
            System.out.println(aula);
            if (aula == null) {
                JOptionPane.showMessageDialog(null, "No se encontró ningún docente con esos datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String queryNotaProm = "SELECT Nombre, Curso, Promedio FROM nota_prom WHERE ID_Aula = ? AND Promedio < 11";

            try (Connection con = conectar();
                 PreparedStatement psNotaProm = con.prepareStatement(queryNotaProm)) {

                psNotaProm.setString(1, aula);

                try (ResultSet rsNotaProm = psNotaProm.executeQuery()) {
                    textArea.setText(""); // Limpiar el TextArea antes de mostrar los nuevos datos
                    while (rsNotaProm.next()) {
                        String nombre = rsNotaProm.getString("Nombre");
                        String curso = rsNotaProm.getString("Curso");
                        float promedio = rsNotaProm.getFloat("Promedio");

                        // Mostrar en el TextArea
                        textArea.append("El estudiante " + nombre + " tiene de promedio " + promedio + " en el curso " + curso + "\n");
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener notas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }


}
