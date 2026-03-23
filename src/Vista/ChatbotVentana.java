
package Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ChatbotVentana extends javax.swing.JFrame {
    private JTextArea chatArea;
    private JTextField entradaCampo;
    private int etapaConversacion;
    private boolean esperandoCurso;
    private String tipoAyuda;
    private String curso;
    public ChatbotVentana() {
        initComponents1();
        mostrarMensajeInicial();
        etapaConversacion = 0;
        esperandoCurso = false;
    }

    private void initComponents1() {
      setTitle("Chatbot");
        setSize(500, 400); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Cargar y redimensionar la imagen del robot desde el paquete imagenes
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/imagenes/robot.png"));
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel robotLabel = new JLabel(resizedIcon);
        robotLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Área de texto para mostrar el chat
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("SansSerif", Font.PLAIN, 14)); // Aumentar tamaño de fuente


        JScrollPane scrollPane = new JScrollPane(chatArea);
        
        // Campo de entrada para escribir mensajes
        entradaCampo = new JTextField();
        entradaCampo.setFont(new Font("SansSerif", Font.PLAIN, 14)); // Aumentar tamaño de fuente
        entradaCampo.addActionListener(enviarMensaje());

        // Añadir componentes al panel principal
        panelPrincipal.add(robotLabel, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(entradaCampo, BorderLayout.SOUTH);

        // Añadir el panel principal al frame
        add(panelPrincipal);
    }
  private Action enviarMensaje() {
        return new AbstractAction("Enviar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensajeUsuario = entradaCampo.getText().trim();
                if (!mensajeUsuario.isEmpty()) {
                    mostrarMensajeUsuario(mensajeUsuario);
                    manejarRespuestaDelBot(mensajeUsuario);
                }
            }
        };
    }

    private void mostrarMensajeUsuario(String mensaje) {
        chatArea.append("Tú: " + mensaje + "\n");
        entradaCampo.setText("");
    }


  private void manejarRespuestaDelBot(String mensajeUsuario) {
    String respuesta = generarRespuestaDelBot(mensajeUsuario);
    mostrarRespuestaDelBot(respuesta);

    if (esperandoCurso) {
        if (curso == null) {
            curso = mensajeUsuario; // Guardar el curso ingresado
            if (tipoAyuda.equalsIgnoreCase("ejercicios")) {
                abrirCarpetaSegunCurso(curso);
            } else if (tipoAyuda.equalsIgnoreCase("videos")) {
                abrirVideoSegunCurso(curso);
            }
            esperandoCurso = false;
        }
    }
}

private String generarRespuestaDelBot(String mensajeUsuario) {
    String respuesta;

    switch (etapaConversacion) {
        case 0:
            etapaConversacion++;
            respuesta = "Bot: Claro, yo puedo ayudarte. ¿Necesitas ayuda con ejercicios o videos?";
            break;

        case 1:
            if (mensajeUsuario.equalsIgnoreCase("ejercicios") || mensajeUsuario.equalsIgnoreCase("videos")) {
                tipoAyuda = mensajeUsuario.toLowerCase(); // Guardar el tipo de ayuda
                etapaConversacion++; // Avanzar a la siguiente etapa
                respuesta = "Bot: Perfecto ¿En qué curso necesitas ayuda hoy?";
            } else if (mensajeUsuario.equalsIgnoreCase("no")) {
                etapaConversacion = 0; // Reiniciar la conversación si el usuario dice "no"
                respuesta = "Bot: Descuida, yo seguiré aquí para ayudarte más adelante.";
            } else {
                respuesta = "Bot: No entendí tu respuesta. ¿Necesitas ayuda con ejercicios o videos?";
            }
            break;

        case 2:
            // Convertir mensajeUsuario a minúsculas para comparación sin importar mayúsculas/minúsculas
            String cursoIngresado = mensajeUsuario.toLowerCase();
            
            // Aquí se espera que el usuario responda con el nombre de un curso específico
            if (cursoIngresado.equals("matemática") || cursoIngresado.equals("comunicación") ||
                cursoIngresado.equals("inglés") || cursoIngresado.equals("ed física") ||
                cursoIngresado.equals("computación")) {
                curso = mensajeUsuario; // Actualizar el curso con el nombre ingresado
                if (tipoAyuda.equals("ejercicios")) {
                    abrirCarpetaSegunCurso(curso); // Llamar al método para abrir la carpeta en Google Drive
                } else if (tipoAyuda.equals("videos")) {
                    abrirVideoSegunCurso(curso); // Llamar al método para abrir el video en YouTube
                }
                respuesta = "Bot: Abriendo " + tipoAyuda + " de " + curso + "...";

                // Cerrar la ventana actual
                dispose();

                // Mostrar la nueva ventana secundaria
                mostrarVentanaSecundaria(curso);

                // Reiniciar la conversación para estar listo para nuevos comandos
                etapaConversacion = 0;
            } else {
                respuesta = "Bot: No reconozco ese curso. Por favor, intenta con otro curso.";
            }
            break;

        default:
            respuesta = "Bot: ¿Hay algo más en lo que pueda ayudarte?";
            break;
    }

    return respuesta;
}

private void abrirVideoSegunCurso(String curso) {
    String url;
    switch (curso.toLowerCase()) {
        case "matemática":
            url = "https://youtube.com/playlist?list=PLTtGznNXHLupreJBjl7RcVzRBTM8mSOG5&si=g7QVwkZIFR4stmpX";
            break;
        case "comunicación":
            url = "https://youtube.com/playlist?list=PLTtGznNXHLuoprCxftVdYnhu3XWrj6Z7v&si=QNPz0zxInxNbjCpy";
            break;
        case "inglés":
            url = "https://youtube.com/playlist?list=PLTtGznNXHLur5Zq6fh8Fuw4wzSVPeiut2&si=MQ2pJMLeCuGa-O9_";
            break;
        case "ed física":
            url = "https://youtube.com/playlist?list=PLTtGznNXHLurvfkEtQnf7fK5TWqSKPCEh&si=o-vvJuegJ1eyV3Qt";
            break;
        case "computación":
            url = "https://youtube.com/playlist?list=PLTtGznNXHLupH2taDj1H4nOQhyLfDvNCZ&si=iiz5ET6FJ_hM36Br";
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

  private void mostrarRespuestaDelBot(String respuesta) {
        chatArea.append(respuesta + "\n");
    }

    private void mostrarMensajeInicial() {
        // Mensaje inicial del chatbot
        chatArea.append("Bot: Hola, ¿cómo puedo ayudarte hoy?\n");
    }

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


    private void mostrarVentanaSecundaria(String curso) {
        // Cerrar la ventana actual
        SwingUtilities.invokeLater(() -> {
            dispose();

            // Abrir una nueva ventana de chatbot más pequeña
            JFrame ventanaSecundaria = new JFrame("Chatbot");
            ventanaSecundaria.setSize(400, 200);
            ventanaSecundaria.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaSecundaria.setLocationRelativeTo(null);

            // Panel principal de la ventana secundaria
            JPanel panelSecundario = new JPanel(new BorderLayout());

            // Cargar y redimensionar la imagen del robot desde el paquete imagenes
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/imagenes/robot.png"));
            Image originalImage = originalIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel robotLabelSecundario = new JLabel(resizedIcon);
            robotLabelSecundario.setHorizontalAlignment(SwingConstants.CENTER);

            // Área de texto para mostrar el chat
            JTextArea chatAreaSecundaria = new JTextArea();
            chatAreaSecundaria.setEditable(false);
            chatAreaSecundaria.setFont(new Font("SansSerif", Font.PLAIN, 14)); // Fuente más pequeña


            JScrollPane scrollPaneSecundario = new JScrollPane(chatAreaSecundaria);

            // Campo de entrada para escribir mensajes
            JTextField entradaCampoSecundario = new JTextField();
            entradaCampoSecundario.setFont(new Font("SansSerif", Font.PLAIN, 14)); // Fuente más pequeña
            entradaCampoSecundario.addActionListener(new AbstractAction("Enviar") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String mensajeUsuario = entradaCampoSecundario.getText().trim();
                    if (!mensajeUsuario.isEmpty()) {
                        chatAreaSecundaria.append("Tú: " + mensajeUsuario + "\n");
                        manejarRespuestaDelBotSecundario(mensajeUsuario, chatAreaSecundaria);
                        entradaCampoSecundario.setText("");
                    }
                }
            });

            // Añadir componentes al panel secundario
            panelSecundario.add(robotLabelSecundario, BorderLayout.NORTH);
            panelSecundario.add(scrollPaneSecundario, BorderLayout.CENTER);
            panelSecundario.add(entradaCampoSecundario, BorderLayout.SOUTH);

            // Añadir el panel secundario a la ventana secundaria
            ventanaSecundaria.add(panelSecundario);

            ventanaSecundaria.setVisible(true);

            chatAreaSecundaria.append("Bot: Esto es lo que pude recopilar de " + curso + ".\n¿Necesitas ayuda con otro curso?.\n");
        });
    }
private void manejarRespuestaDelBotSecundario(String mensajeUsuario, JTextArea chatAreaSecundaria) {
    String respuesta = "";

    switch (etapaConversacion) {
        case 0:
            if (mensajeUsuario.equalsIgnoreCase("sí") || mensajeUsuario.equalsIgnoreCase("si")) {
                etapaConversacion = 1;
                respuesta = "Bot: ¿Necesitas ayuda con ejercicios o videos?";
            } else if (mensajeUsuario.equalsIgnoreCase("no")) {
                respuesta = "Bot: Descuida, yo estaré aquí si me necesitas más adelante.";
            } else {
                respuesta = "Bot: Por favor, responde sí o no.";
            }
            break;

        case 1:
            if (mensajeUsuario.equalsIgnoreCase("ejercicios") || mensajeUsuario.equalsIgnoreCase("videos")) {
                tipoAyuda = mensajeUsuario.toLowerCase();
                etapaConversacion = 2;
                respuesta = "Bot: ¿En qué curso necesitas ayuda hoy? Matemática, Comunicación, Inglés, Ed Física, Computación.";
            } else {
                respuesta = "Bot: No entendí tu respuesta. ¿Necesitas ayuda con ejercicios o videos?";
            }
            break;

        case 2:
            // Convertir mensajeUsuario a minúsculas para comparación sin importar mayúsculas/minúsculas
            String cursoIngresado = mensajeUsuario.toLowerCase();

            if (cursoIngresado.equals("matemática") || cursoIngresado.equals("comunicación") ||
                cursoIngresado.equals("inglés") || cursoIngresado.equals("ed física") ||
                cursoIngresado.equals("computación")) {
                curso = mensajeUsuario;

                if (tipoAyuda.equals("ejercicios")) {
                    abrirCarpetaSegunCurso(curso);
                } else if (tipoAyuda.equals("videos")) {
                    abrirVideoSegunCurso(curso);
                }

                respuesta = "Bot: Abriendo " + tipoAyuda + " de " + curso + "...";
                chatAreaSecundaria.append(respuesta + "\n");

                respuesta = "Bot: ¿Necesitas ayuda con otro curso? Sí o No.";
                etapaConversacion = 0;
            } else {
                respuesta = "Bot: No reconozco ese curso. Por favor, intenta con otro curso.";
            }
            break;

        default:
            respuesta = "Bot: No entendí tu respuesta.";
            break;
    }

    chatAreaSecundaria.append(respuesta + "\n");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatbotVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatbotVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatbotVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatbotVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatbotVentana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
