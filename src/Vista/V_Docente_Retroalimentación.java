
package Vista;

import Controlador.C_Docente_Retroalimentación;
import Controlador.C_Login_TecnoSchool;
import Controlador.C_Login_TecnoSchool.DatosCompartidos;
import DAO.Conexion;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.sql.*;
import java.util.ArrayList;

public class V_Docente_Retroalimentación extends javax.swing.JPanel {
    private C_Docente_Retroalimentación Retro;
    private Conexion conexion = new Conexion();
    private boolean esperandoRespuestaCurso = false;
    private boolean esperandoReforzamiento = false;
    private boolean esperandoOtroCurso = false;
    private String cursoActual = "";
    
    public V_Docente_Retroalimentación() {
        this.Retro = new Controlador.C_Docente_Retroalimentación();
        
        initComponents(); 
        jtxt_EntradaChat.addActionListener(evt -> enviarMensaje());
        mostrarCursos(cursosPermitidos);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Llamar al método adaptado
                mostrarChat();
            }
        });
    }

private boolean esperandoRespuestaTipo = false;
private String tipoContenido = "";
private ArrayList<String> cursosPermitidos = new ArrayList<>();

private void enviarMensaje() {
    String mensajeUsuario = jtxt_EntradaChat.getText().trim().toLowerCase();
    jtxt_EntradaChat.setText("");
    jtxa_Chatbot.append(" Usuario: " + mensajeUsuario + "\n");

    if (esperandoRespuestaTipo) {
        if (mensajeUsuario.contains("ejercicios")) {
            tipoContenido = "ejercicios";
            esperandoRespuestaTipo = false;
            esperandoRespuestaCurso = true;
            jtxa_Chatbot.append(" ChatBot: ¿De qué curso necesitas " + tipoContenido + "?\n");
        } else if (mensajeUsuario.contains("videos")) {
            tipoContenido = "videos";
            esperandoRespuestaTipo = false;
            esperandoRespuestaCurso = true;
            jtxa_Chatbot.append(" ChatBot: ¿De qué curso necesitas " + tipoContenido + "?\n");
        } else {
            jtxa_Chatbot.append(" ChatBot: Por favor responda con 'ejercicios' o 'videos'.\n");
        }
    } else if (esperandoRespuestaCurso) {
        if (abrirContenidoSegunCurso(mensajeUsuario, tipoContenido)) {
            cursoActual = mensajeUsuario;
            esperandoRespuestaCurso = false;
            jtxa_Chatbot.append(" ChatBot: ¿Desea abrir otro curso? (si/no)\n");
            esperandoOtroCurso = true;
        } else {
            jtxa_Chatbot.append(" ChatBot: Por favor verifique el curso.\n");
        }
    } else if (esperandoOtroCurso) {
        if (mensajeUsuario.contains("si")) {
            esperandoRespuestaTipo = true;
            jtxa_Chatbot.append(" ChatBot: ¿Quieres abrir ejercicios o videos?\n");
        } else if (mensajeUsuario.contains("no")) {
            jtxa_Chatbot.append(" ChatBot: ¿Desea abrir los exámenes de reforzamiento? (si/no)\n");
            esperandoReforzamiento = true;
            esperandoOtroCurso = false;
        } else {
            jtxa_Chatbot.append(" ChatBot: Por favor responda 'si' o 'no'.\n");
        }
    } else if (esperandoReforzamiento) {
        if (mensajeUsuario.contains("si")) {
            procesarReforzamiento(mensajeUsuario);
        } else if (mensajeUsuario.contains("no")) {
            jtxa_Chatbot.append(" ChatBot: Entendido, gracias por usar la IA de TecnoSchool.\n");
            jtxt_EntradaChat.setEnabled(false); // Deshabilitar entrada si el usuario decide no abrir más cursos
        } else {
            jtxa_Chatbot.append(" ChatBot: Por favor responda 'si' o 'no'.\n");
        }
    } else {
        if (mensajeUsuario.contains("si")) {
            esperandoRespuestaTipo = true;
            jtxa_Chatbot.append(" ChatBot: ¿Quieres abrir ejercicios o videos?\n");
        } else if (mensajeUsuario.contains("no")) {
            jtxa_Chatbot.append(" ChatBot: Entendido, gracias por usar la IA de TecnoSchool.\n");
            jtxt_EntradaChat.setEnabled(false); // Deshabilitar entrada si el usuario decide no abrir más cursos
        } else {
            jtxa_Chatbot.append(" ChatBot: Por favor responda 'si' o 'no'.\n");
        }
    }
}


// Método adaptado para mostrar el chat
    private void mostrarChat() {
        String contraseñaGuardada = DatosCompartidos.getContraseña();
        String usuarioGuardado = DatosCompartidos.getUsuario();
        SwingUtilities.invokeLater(() -> {
            String aula = obtenerIDAula(usuarioGuardado, contraseñaGuardada);
            System.out.println(aula);
            if (aula == null) {
                JOptionPane.showMessageDialog(null, "No se encontró ningún docente con esos datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String queryNotaProm = "SELECT Nombre, Curso, Promedio FROM nota_prom WHERE ID_Aula = ? AND Promedio < 11";

            try (Connection con = conexion.conectar();
                 PreparedStatement psNotaProm = con.prepareStatement(queryNotaProm)) {

                psNotaProm.setString(1, aula);

                try (ResultSet rsNotaProm = psNotaProm.executeQuery()) {
                    jtxa_Chatbot.setText("");
                    boolean hayResultados = false;
                    while (rsNotaProm.next()) {
                        String nombre = rsNotaProm.getString("Nombre");
                        String curso = rsNotaProm.getString("Curso");
                        float promedio = rsNotaProm.getFloat("Promedio");

                        String mensaje = " ChatBot: El estudiante " + nombre + " tiene de promedio " + promedio + " en el curso " + curso + "\n";
                        jtxa_Chatbot.append(mensaje);
                        hayResultados = true;
                    }
                    if (!hayResultados) {
                        jtxa_Chatbot.append(" ChatBot: No tiene estudiantes que necesiten recuperación\n");
                    }
                    // Preguntar si se desea abrir la carpeta de recuperación
                    jtxa_Chatbot.append(" ChatBot: ¿Quieres abrir ejercicios o videos?\n");
                    esperandoRespuestaTipo = true;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener notas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Método para obtener el ID_Aula del docente
    private String obtenerIDAula(String usuario, String contraseña) {
        String aula = null;
        try {
            // Consulta para obtener el Aula del docente
            Connection con = conexion.conectar();
            PreparedStatement leer = con.prepareStatement(
                "SELECT Aula FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?");
            leer.setString(1, usuario);
            leer.setString(2, contraseña);
            ResultSet resultado = leer.executeQuery();
            if (resultado.next()) {
                aula = resultado.getString("Aula");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún docente con esos datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return aula;
    }
 
// Método para abrir contenido según el curso y el tipo
    private boolean abrirContenidoSegunCurso(String curso, String tipo) {
        String url = null;
        curso = curso.toLowerCase(); // Convertir a minúsculas para comparación

        // Verificar si el curso está en la lista de cursos permitidos
        if (!cursosPermitidos.contains(curso)) {
            jtxa_Chatbot.append(" ChatBot: No tienes acceso al curso " + curso + ".\n");
            return false;
        }

        // Resto del código para abrir el contenido según el curso y tipo
        if (curso.contains("matematica")) {
        if (tipo.equals("ejercicios")) {
            url = "https://drive.google.com/drive/folders/1Zwsv62E2ysWfcRI8xL8JgaAyPmCg59mS";
        } else if (tipo.equals("videos")) {
            url = "https://youtube.com/playlist?list=PLTtGznNXHLupreJBjl7RcVzRBTM8mSOG5&si=g7QVwkZIFR4stmpX";
        }
        } else if (curso.contains("comunicacion")) {
        if (tipo.equals("ejercicios")) {
            url = "https://drive.google.com/drive/folders/1p3xSnQj6Ak130qCwe-PMiOGra9Ld6LU7";
        } else if (tipo.equals("videos")) {
            url = "https://youtube.com/playlist?list=PLTtGznNXHLuoprCxftVdYnhu3XWrj6Z7v&si=QNPz0zxInxNbjCpy";
        }
        } else if (curso.contains("ingles")) {
        if (tipo.equals("ejercicios")) {
            url = "https://drive.google.com/drive/folders/17KI0p-nuUX69lbqfnMdw-ZAvBlBz0ax0";
        } else if (tipo.equals("videos")) {
            url = "https://youtube.com/playlist?list=PLTtGznNXHLur5Zq6fh8Fuw4wzSVPeiut2&si=MQ2pJMLeCuGa-O9_";
        }
        } else if (curso.contains("ed fisica") || curso.contains("educacion fisica")) {
        if (tipo.equals("ejercicios")) {
            url = "https://drive.google.com/drive/folders/1HY9FlFARV165HfnxpGAS4PbJ7m6sSSP6";
        } else if (tipo.equals("videos")) {
            url = "https://youtube.com/playlist?list=PLTtGznNXHLurvfkEtQnf7fK5TWqSKPCEh&si=o-vvJuegJ1eyV3Qt";
        }
        } else if (curso.contains("computacion")) {
        if (tipo.equals("ejercicios")) {
            url = "https://drive.google.com/drive/folders/1R2S2ua2x2sP4rMvwBL0sXcE1hT9tyS0U";
        } else if (tipo.equals("videos")) {
            url = "https://youtube.com/playlist?list=PLTtGznNXHLupH2taDj1H4nOQhyLfDvNCZ&si=iiz5ET6FJ_hM36Br";
        }
        } else {
        return false;
        }
        if (url != null && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            System.err.println("Desktop o browse no soportado");
            return false;
        }
    }

    // Método para mostrar los cursos habilitados para el docente
    public void mostrarCursos(ArrayList<String> cursos) {
        Connection con = conexion.conectar();
        String contraseñaGuardada = C_Login_TecnoSchool.DatosCompartidos.getContraseña();
        String usuarioGuardado = C_Login_TecnoSchool.DatosCompartidos.getUsuario();

        try {
            // Obtener el Aula del docente
            PreparedStatement leer = con.prepareStatement(
                "SELECT Aula FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?");
            leer.setString(1, usuarioGuardado);
            leer.setString(2, contraseñaGuardada);
            ResultSet resultado = leer.executeQuery();
            if (resultado.next()) {
                String aula = resultado.getString("Aula");

                // Obtener el ID_Docente
                PreparedStatement leerDocente = con.prepareStatement(
                    "SELECT ID_Docente FROM administrar_docente WHERE Usuario = ? AND Contraseña = ?");
                leerDocente.setString(1, usuarioGuardado);
                leerDocente.setString(2, contraseñaGuardada);
                ResultSet resultadoDocente = leerDocente.executeQuery();
                if (resultadoDocente.next()) {
                    String idDocente = resultadoDocente.getString("ID_Docente");
                    PreparedStatement leerCursos = con.prepareStatement(
                        "SELECT ID_Curso FROM docente_curso WHERE ID_Docente = ?");
                    leerCursos.setString(1, idDocente);
                    ResultSet resultadoCursos = leerCursos.executeQuery();
                    while (resultadoCursos.next()) {
                        PreparedStatement leerNombreCurso = con.prepareStatement(
                            "SELECT Nombre FROM curso WHERE ID_Curso = ?");
                        leerNombreCurso.setString(1, resultadoCursos.getString("ID_Curso"));
                        ResultSet resultadoNombreCurso = leerNombreCurso.executeQuery();
                        if (resultadoNombreCurso.next()) {
                            String nombreCurso = resultadoNombreCurso.getString("Nombre").toLowerCase(); // Convertir a minúsculas
                            cursos.add(nombreCurso); // Agregar el nombre del curso a la lista permitida
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
        }
    }

    private void abrirEnlace(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            jtxa_Chatbot.append(" ChatBot: No pude abrir el enlace.\n");
        }
    }
        
    private void procesarReforzamiento(String entrada) {
        if (entrada.contains("sí") || entrada.contains("si")) {
            String enlaceExamen = "";
            switch (cursoActual) {
                case "matematica":
                    enlaceExamen = "https://repositorio.perueduca.pe/recursos/c-herramientas-curriculares/primaria/transversal/prueba-diagnostica-2021-6.pdf";
                    break;
                case "comunicacion":
                    enlaceExamen = "https://www.dreapurimac.gob.pe/inicio/images/ARCHIVOS2017/A-REPOSITORIO-PRUEB/2_cuadernillo_comunicacion_primaria.pdf";
                    break;
                case "ingles":
                    enlaceExamen = "https://www.ejerciciosinglesonline.com/examen-primaria-1/";
                    break;
                case "educacion fisica":
                    enlaceExamen = "https://www.youtube.com/watch?v=LUQNjwuY_VU&t=2s&ab_channel=LosgemelosCrisyRafaEducaci%C3%B3nf%C3%ADsica";
                    break;
                case "computacion":
                    enlaceExamen = "https://www.liveworksheets.com/w/es/computacion/781425";
                    break;
                default:
                    jtxa_Chatbot.append(" ChatBot: No tengo un examen de reforzamiento para ese curso.\n");
                    esperandoReforzamiento = false;
                    return;
            }
            abrirEnlace(enlaceExamen);
            jtxa_Chatbot.append(" ChatBot: Aquí tienes el enlace al examen de reforzamiento para el curso de " + cursoActual + ".\n");
            esperandoReforzamiento = false;
            jtxa_Chatbot.append(" ChatBot: ¿Deseas buscar reforzamientos para otro curso? (si/no)\n");
            esperandoOtroCurso = true;
        } else {
            jtxa_Chatbot.append(" ChatBot: Está bien, avísame si necesitas algo más.\n");
            esperandoReforzamiento = false;
            jtxt_EntradaChat.setEnabled(false); // Finalizar el chat
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxa_Chatbot = new javax.swing.JTextArea();
        jtxt_EntradaChat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jbl_DatosPersonales1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxa_Chatbot.setBackground(new java.awt.Color(102, 102, 102));
        jtxa_Chatbot.setColumns(20);
        jtxa_Chatbot.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxa_Chatbot.setForeground(new java.awt.Color(255, 255, 255));
        jtxa_Chatbot.setRows(5);
        jScrollPane2.setViewportView(jtxa_Chatbot);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 660, 300));

        jtxt_EntradaChat.setBackground(new java.awt.Color(102, 102, 102));
        jtxt_EntradaChat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxt_EntradaChat.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jtxt_EntradaChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 660, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/robot.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 50, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 290, 90));

        jbl_DatosPersonales1.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jbl_DatosPersonales1.setText("RETROALIMENTACIÓN");
        jPanel1.add(jbl_DatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 310, 60));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jbl_DatosPersonales1;
    private javax.swing.JTextArea jtxa_Chatbot;
    private javax.swing.JTextField jtxt_EntradaChat;
    // End of variables declaration//GEN-END:variables
}
