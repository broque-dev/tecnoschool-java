
package Vista;
import Controlador.Propiedades;
import Controlador.Slide;
import javax.swing.JPanel;

public class Docente_Menu extends javax.swing.JFrame {
    private Propiedades propiedades;
    Slide sslide;

    public Docente_Menu() {
        initComponents();
        sslide = new Slide();
        this.propiedades = new Propiedades();
        V_Docente_Asistencias DoceAsis = new V_Docente_Asistencias();
        showPanel(DoceAsis);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        JP_MenuDocente = new javax.swing.JPanel();
        JL_CerrarDocente = new javax.swing.JLabel();
        JL_DocenteHorario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JL_DocenteAsistencia = new javax.swing.JLabel();
        JL_DocenteNotas = new javax.swing.JLabel();
        JL_DocentePlanificacion = new javax.swing.JLabel();
        JL_ButtonControlMenu = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JL_DocenteSeguimiento1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JL_DocenteRetroalimentacion1 = new javax.swing.JLabel();
        JL_DocenteAntiplagio = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jl_Minimizar = new javax.swing.JLabel();
        jl_Cerrar = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        jTextField1.setBackground(new java.awt.Color(51, 51, 51));
        jTextField1.setBorder(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JP_MenuDocente.setBackground(new java.awt.Color(51, 51, 51));
        JP_MenuDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JL_CerrarDocente.setBackground(new java.awt.Color(51, 51, 51));
        JL_CerrarDocente.setForeground(new java.awt.Color(51, 51, 51));
        JL_CerrarDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminClose.png"))); // NOI18N
        JL_CerrarDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_CerrarDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_CerrarDocenteMouseClicked(evt);
            }
        });
        JP_MenuDocente.add(JL_CerrarDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 50, 50));

        JL_DocenteHorario.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_DocenteHorario.setForeground(new java.awt.Color(255, 255, 255));
        JL_DocenteHorario.setText("GESTION HORARIO");
        JL_DocenteHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_DocenteHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_DocenteHorarioMouseClicked(evt);
            }
        });
        JP_MenuDocente.add(JL_DocenteHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 140, 50));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminDocente.png"))); // NOI18N
        JP_MenuDocente.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 50, 50));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminCurso.png"))); // NOI18N
        JP_MenuDocente.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 50, 50));

        JL_DocenteAsistencia.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_DocenteAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        JL_DocenteAsistencia.setText("REGISTRAR ASISTENCIA");
        JL_DocenteAsistencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_DocenteAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_DocenteAsistenciaMouseClicked(evt);
            }
        });
        JP_MenuDocente.add(JL_DocenteAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 160, 50));

        JL_DocenteNotas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_DocenteNotas.setForeground(new java.awt.Color(255, 255, 255));
        JL_DocenteNotas.setText("REGISTRAR NOTAS");
        JL_DocenteNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_DocenteNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_DocenteNotasMouseClicked(evt);
            }
        });
        JP_MenuDocente.add(JL_DocenteNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 160, 50));

        JL_DocentePlanificacion.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_DocentePlanificacion.setForeground(new java.awt.Color(255, 255, 255));
        JL_DocentePlanificacion.setText("PLANIFICACION");
        JL_DocentePlanificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_DocentePlanificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_DocentePlanificacionMouseClicked(evt);
            }
        });
        JP_MenuDocente.add(JL_DocentePlanificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 150, 50));

        JL_ButtonControlMenu.setForeground(new java.awt.Color(255, 255, 255));
        JL_ButtonControlMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminMenu.png"))); // NOI18N
        JL_ButtonControlMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_ButtonControlMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_ButtonControlMenuMouseClicked(evt);
            }
        });
        JP_MenuDocente.add(JL_ButtonControlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 50, 50));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdmiDesig.png"))); // NOI18N
        JP_MenuDocente.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 50, 50));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminSalon.png"))); // NOI18N
        JP_MenuDocente.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 50, 50));

        JL_DocenteSeguimiento1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_DocenteSeguimiento1.setForeground(new java.awt.Color(255, 255, 255));
        JL_DocenteSeguimiento1.setText("SEGUIMIENTO / PROM");
        JL_DocenteSeguimiento1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_DocenteSeguimiento1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_DocenteSeguimiento1MouseClicked(evt);
            }
        });
        JP_MenuDocente.add(JL_DocenteSeguimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 150, 50));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminEstudiante.png"))); // NOI18N
        JP_MenuDocente.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 50, 50));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminEstudiante.png"))); // NOI18N
        JP_MenuDocente.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 50, 50));

        JL_DocenteRetroalimentacion1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_DocenteRetroalimentacion1.setForeground(new java.awt.Color(255, 255, 255));
        JL_DocenteRetroalimentacion1.setText("RETROALIMENTACION");
        JL_DocenteRetroalimentacion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_DocenteRetroalimentacion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_DocenteRetroalimentacion1MouseClicked(evt);
            }
        });
        JP_MenuDocente.add(JL_DocenteRetroalimentacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, 50));

        JL_DocenteAntiplagio.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_DocenteAntiplagio.setForeground(new java.awt.Color(255, 255, 255));
        JL_DocenteAntiplagio.setText("ANTI-PLAGIO");
        JL_DocenteAntiplagio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_DocenteAntiplagio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_DocenteAntiplagioMouseClicked(evt);
            }
        });
        JP_MenuDocente.add(JL_DocenteAntiplagio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 150, 50));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminSalon.png"))); // NOI18N
        JP_MenuDocente.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 50, 50));

        getContentPane().add(JP_MenuDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 0, 250, 500));

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 730, 460));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jl_Minimizar.setBackground(new java.awt.Color(255, 255, 255));
        jl_Minimizar.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jl_Minimizar.setForeground(new java.awt.Color(255, 255, 255));
        jl_Minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_Minimizar.setText("―");
        jl_Minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jl_Minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_MinimizarMouseClicked(evt);
            }
        });

        jl_Cerrar.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jl_Cerrar.setForeground(new java.awt.Color(255, 255, 255));
        jl_Cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_Cerrar.setText("x");
        jl_Cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jl_Cerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jl_Cerrar.setName(""); // NOI18N
        jl_Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_CerrarMouseClicked(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(51, 51, 51));
        jTextField2.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField2)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_Cerrar)
                        .addComponent(jl_Minimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jl_MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_MinimizarMouseClicked
        this.setState(Admin_Menu.ICONIFIED);
    }//GEN-LAST:event_jl_MinimizarMouseClicked

    private void jl_CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CerrarMouseClicked
       dispose();
       propiedades.mostrarMensajeError("NOS VEMOS LUEGO!!!", "/imagenes/emojiFeliz.png", "Sesión Cerrada");
       System.exit(0);
    }//GEN-LAST:event_jl_CerrarMouseClicked

    private void JL_CerrarDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_CerrarDocenteMouseClicked
       dispose();
       propiedades.mostrarMensajeError("NOS VEMOS LUEGO!!!", "/imagenes/emojiFeliz.png", "Sesión Cerrada");
       System.exit(0);
    }//GEN-LAST:event_JL_CerrarDocenteMouseClicked

    private void JL_DocenteHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_DocenteHorarioMouseClicked
        V_Docente_Horario DocenHor = new V_Docente_Horario();
        showPanel(DocenHor);
    }//GEN-LAST:event_JL_DocenteHorarioMouseClicked

    private void JL_DocenteAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_DocenteAsistenciaMouseClicked
        V_Docente_Asistencias DoceAsis = new V_Docente_Asistencias();
        showPanel(DoceAsis);
    }//GEN-LAST:event_JL_DocenteAsistenciaMouseClicked

    private void JL_DocenteNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_DocenteNotasMouseClicked
        V_Docente_Notas DoceNota = new V_Docente_Notas();
        showPanel(DoceNota);
    }//GEN-LAST:event_JL_DocenteNotasMouseClicked

    private void JL_DocentePlanificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_DocentePlanificacionMouseClicked
        V_Docente_Planificacion DocenPla = new V_Docente_Planificacion();
        showPanel(DocenPla);
    }//GEN-LAST:event_JL_DocentePlanificacionMouseClicked

    private void JL_ButtonControlMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_ButtonControlMenuMouseClicked
        sslide.jPanelXDerecha(-180, 0, 10, 5, JP_MenuDocente);
        sslide.jPanelXIzquierda(0, -180, 10, 5, JP_MenuDocente);
    }//GEN-LAST:event_JL_ButtonControlMenuMouseClicked

    private void JL_DocenteSeguimiento1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_DocenteSeguimiento1MouseClicked
        V_Docente_Seguimiento DoceSegui = new V_Docente_Seguimiento();
        showPanel(DoceSegui);
    }//GEN-LAST:event_JL_DocenteSeguimiento1MouseClicked

    private void JL_DocenteRetroalimentacion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_DocenteRetroalimentacion1MouseClicked
        V_Docente_Retroalimentación DocenRe = new V_Docente_Retroalimentación();
        showPanel(DocenRe);
    }//GEN-LAST:event_JL_DocenteRetroalimentacion1MouseClicked

    private void JL_DocenteAntiplagioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_DocenteAntiplagioMouseClicked
        V_Docente_Plagio plagio = new V_Docente_Plagio();
        showPanel(plagio);
    }//GEN-LAST:event_JL_DocenteAntiplagioMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Docente_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_ButtonControlMenu;
    private javax.swing.JLabel JL_CerrarDocente;
    private javax.swing.JLabel JL_DocenteAntiplagio;
    private javax.swing.JLabel JL_DocenteAsistencia;
    private javax.swing.JLabel JL_DocenteHorario;
    private javax.swing.JLabel JL_DocenteNotas;
    private javax.swing.JLabel JL_DocentePlanificacion;
    private javax.swing.JLabel JL_DocenteRetroalimentacion1;
    private javax.swing.JLabel JL_DocenteSeguimiento1;
    private javax.swing.JPanel JP_MenuDocente;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jl_Cerrar;
    private javax.swing.JLabel jl_Minimizar;
    // End of variables declaration//GEN-END:variables
    private void showPanel(JPanel p){
        p.setSize(460, 420);
        p.setLocation(0, 0);
        contenedor.removeAll();
        contenedor.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        contenedor.revalidate();
        contenedor.repaint();
    }
}
