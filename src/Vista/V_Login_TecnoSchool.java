
package Vista;

public class V_Login_TecnoSchool extends javax.swing.JFrame {
    
    public V_Login_TecnoSchool() {
        initComponents();
    }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Jtxt_Usuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        JL_IniciarSesion = new javax.swing.JLabel();
        JL_Usuario = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        JL_Contraseña = new javax.swing.JLabel();
        Jtxt_Contraseña = new javax.swing.JPasswordField();
        jcbx_MostrarContra = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoLogin.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 260, 500));

        Jtxt_Usuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtxt_Usuario.setForeground(new java.awt.Color(204, 204, 204));
        Jtxt_Usuario.setText("Ingrese su nombre de usuario");
        Jtxt_Usuario.setBorder(null);
        Jtxt_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Jtxt_UsuarioMousePressed(evt);
            }
        });
        jPanel1.add(Jtxt_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 380, 50));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 380, 20));

        JL_IniciarSesion.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        JL_IniciarSesion.setText("INICIAR SESIÓN");
        jPanel1.add(JL_IniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 220, 50));

        JL_Usuario.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        JL_Usuario.setText("USUARIO");
        jPanel1.add(JL_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 380, 20));

        JL_Contraseña.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        JL_Contraseña.setText("CONTRASEÑA");
        jPanel1.add(JL_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        Jtxt_Contraseña.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtxt_Contraseña.setForeground(new java.awt.Color(204, 204, 204));
        Jtxt_Contraseña.setText("********");
        Jtxt_Contraseña.setBorder(null);
        Jtxt_Contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Jtxt_ContraseñaMousePressed(evt);
            }
        });
        jPanel1.add(Jtxt_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 380, 50));

        jcbx_MostrarContra.setBackground(new java.awt.Color(255, 255, 255));
        jcbx_MostrarContra.setText("Mostrar");
        jcbx_MostrarContra.setBorder(null);
        jcbx_MostrarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbx_MostrarContraActionPerformed(evt);
            }
        });
        jPanel1.add(jcbx_MostrarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoLogin1.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 330, 90));

        jTextField1.setBorder(null);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        btnEntrar.setBackground(new java.awt.Color(59, 172, 237));
        btnEntrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("ENTRAR");
        btnEntrar.setBorder(null);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 140, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbx_MostrarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbx_MostrarContraActionPerformed
         //Insert code
    }//GEN-LAST:event_jcbx_MostrarContraActionPerformed

    private void Jtxt_UsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtxt_UsuarioMousePressed
        //Insert code
    }//GEN-LAST:event_Jtxt_UsuarioMousePressed

    private void Jtxt_ContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtxt_ContraseñaMousePressed
        //Insert code
    }//GEN-LAST:event_Jtxt_ContraseñaMousePressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V_Login_TecnoSchool().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_Contraseña;
    private javax.swing.JLabel JL_IniciarSesion;
    private javax.swing.JLabel JL_Usuario;
    public javax.swing.JPasswordField Jtxt_Contraseña;
    public javax.swing.JTextField Jtxt_Usuario;
    public javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JCheckBox jcbx_MostrarContra;
    // End of variables declaration//GEN-END:variables
}
