
package Vista;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class V_Docente_Planificacion extends javax.swing.JPanel {
    private JProgressBar progressBar;
    
    public V_Docente_Planificacion() {
        initComponents();
// Crear barra de progreso
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true); 
    }

private void activarChatbot() {
        ChatbotVentana chatbot = new ChatbotVentana();
        chatbot.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMatematica = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 212, 212));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMatematica.setBackground(new java.awt.Color(255, 255, 204));
        btnMatematica.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        btnMatematica.setForeground(new java.awt.Color(255, 204, 0));
        btnMatematica.setText("INICIANDO CHATBOT");
        btnMatematica.setBorder(null);
        btnMatematica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMatematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatematicaActionPerformed(evt);
            }
        });
        jPanel1.add(btnMatematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 260, 70));

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel1.setText("RECURSOS PARA CLASES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 550, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escribir (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 290, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recur3.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 130, 130));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recur2.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 130, 130));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recur1.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 130, 130));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escribir (1).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMatematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatematicaActionPerformed
    //this.dispose();
    
    // Abrir el chatbot
    SwingUtilities.invokeLater(() -> {
        ChatbotVentana ventanaChatbot = new ChatbotVentana();
        ventanaChatbot.setVisible(true);
    });
    }//GEN-LAST:event_btnMatematicaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMatematica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
