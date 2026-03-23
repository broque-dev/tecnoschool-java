
package Vista;


import Controlador.Propiedades;
import Controlador.Slide;
import javax.swing.JPanel;

public class Admin_Menu extends javax.swing.JFrame {
    private Propiedades propiedades;
    Slide sslide;
    
    public Admin_Menu() {
        initComponents();
        sslide = new Slide();
        this.propiedades = new Propiedades();
        V_Admin_Docente AdDocen = new V_Admin_Docente();
        showPanel(AdDocen);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JP_MenuAdmin = new javax.swing.JPanel();
        JL_CerrarAdmin = new javax.swing.JLabel();
        JL_AdminCurso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JL_AdminDocente = new javax.swing.JLabel();
        JL_AdminAlumno = new javax.swing.JLabel();
        JL_AdminSalon = new javax.swing.JLabel();
        JL_ButtonControlMenu = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JL_DedignarCursos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jl_Minimizar = new javax.swing.JLabel();
        jl_Cerrar = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JP_MenuAdmin.setBackground(new java.awt.Color(51, 51, 51));
        JP_MenuAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JL_CerrarAdmin.setBackground(new java.awt.Color(51, 51, 51));
        JL_CerrarAdmin.setForeground(new java.awt.Color(51, 51, 51));
        JL_CerrarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminClose.png"))); // NOI18N
        JL_CerrarAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_CerrarAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_CerrarAdminMouseClicked(evt);
            }
        });
        JP_MenuAdmin.add(JL_CerrarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 50, 50));

        JL_AdminCurso.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_AdminCurso.setForeground(new java.awt.Color(255, 255, 255));
        JL_AdminCurso.setText("ADMINISTRAR CURSO");
        JL_AdminCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_AdminCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_AdminCursoMouseClicked(evt);
            }
        });
        JP_MenuAdmin.add(JL_AdminCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 140, 50));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdmiDesig.png"))); // NOI18N
        JP_MenuAdmin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 50, 50));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminCurso.png"))); // NOI18N
        JP_MenuAdmin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 50, 50));

        JL_AdminDocente.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_AdminDocente.setForeground(new java.awt.Color(255, 255, 255));
        JL_AdminDocente.setText("ADMINISTRAR DOCENTE");
        JL_AdminDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_AdminDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_AdminDocenteMouseClicked(evt);
            }
        });
        JP_MenuAdmin.add(JL_AdminDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 160, 50));

        JL_AdminAlumno.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_AdminAlumno.setForeground(new java.awt.Color(255, 255, 255));
        JL_AdminAlumno.setText("ADMINISTRAR ALUMNO");
        JL_AdminAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_AdminAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_AdminAlumnoMouseClicked(evt);
            }
        });
        JP_MenuAdmin.add(JL_AdminAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 160, 50));

        JL_AdminSalon.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_AdminSalon.setForeground(new java.awt.Color(255, 255, 255));
        JL_AdminSalon.setText("ADMINISTRAR SALON");
        JL_AdminSalon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_AdminSalon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_AdminSalonMouseClicked(evt);
            }
        });
        JP_MenuAdmin.add(JL_AdminSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 140, 50));

        JL_ButtonControlMenu.setForeground(new java.awt.Color(255, 255, 255));
        JL_ButtonControlMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminMenu.png"))); // NOI18N
        JL_ButtonControlMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_ButtonControlMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_ButtonControlMenuMouseClicked(evt);
            }
        });
        JP_MenuAdmin.add(JL_ButtonControlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 50, 50));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminEstudiante.png"))); // NOI18N
        JP_MenuAdmin.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 50, 50));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminSalon.png"))); // NOI18N
        JP_MenuAdmin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 50, 50));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AdminDocente.png"))); // NOI18N
        JP_MenuAdmin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 50, 50));

        JL_DedignarCursos.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        JL_DedignarCursos.setForeground(new java.awt.Color(255, 255, 255));
        JL_DedignarCursos.setText("DESIGNAR CURSOS");
        JL_DedignarCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_DedignarCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_DedignarCursosMouseClicked(evt);
            }
        });
        JP_MenuAdmin.add(JL_DedignarCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 50));

        getContentPane().add(JP_MenuAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 0, 250, 500));

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

        jTextField1.setBackground(new java.awt.Color(51, 51, 51));
        jTextField1.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_Minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_Cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_Cerrar)
                        .addComponent(jl_Minimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 730, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JL_ButtonControlMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_ButtonControlMenuMouseClicked
       sslide.jPanelXDerecha(-180, 0, 10, 5, JP_MenuAdmin);
       sslide.jPanelXIzquierda(0, -180, 10, 5, JP_MenuAdmin);
    }//GEN-LAST:event_JL_ButtonControlMenuMouseClicked

    private void JL_CerrarAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_CerrarAdminMouseClicked
       dispose();
       propiedades.mostrarMensajeError("NOS VEMOS LUEGO!!!", "/imagenes/emojiFeliz.png", "Sesión Cerrada");
       System.exit(0);
    }//GEN-LAST:event_JL_CerrarAdminMouseClicked

    private void JL_AdminDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_AdminDocenteMouseClicked
       V_Admin_Docente AdDocen = new V_Admin_Docente();
       showPanel(AdDocen);
    }//GEN-LAST:event_JL_AdminDocenteMouseClicked

    private void jl_CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_CerrarMouseClicked
       dispose();
       propiedades.mostrarMensajeError("NOS VEMOS LUEGO!!!", "/imagenes/emojiFeliz.png", "Sesión Cerrada");
       System.exit(0);
    }//GEN-LAST:event_jl_CerrarMouseClicked

    private void jl_MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_MinimizarMouseClicked
        this.setState(Admin_Menu.ICONIFIED);
    }//GEN-LAST:event_jl_MinimizarMouseClicked

    private void JL_AdminCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_AdminCursoMouseClicked
       V_Admin_Cursos cruAdmin = new V_Admin_Cursos();
       showPanel(cruAdmin);
    }//GEN-LAST:event_JL_AdminCursoMouseClicked

    private void JL_AdminSalonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_AdminSalonMouseClicked
       V_Admin_Aulas salones = new V_Admin_Aulas();
       showPanel(salones);
    }//GEN-LAST:event_JL_AdminSalonMouseClicked

    private void JL_AdminAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_AdminAlumnoMouseClicked
       V_Admin_Estudiante AdEstu = new V_Admin_Estudiante();
       showPanel(AdEstu);
    }//GEN-LAST:event_JL_AdminAlumnoMouseClicked

    private void JL_DedignarCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_DedignarCursosMouseClicked
       V_Admin_DesingCurso desingCurso = new V_Admin_DesingCurso();
        showPanel(desingCurso);
    }//GEN-LAST:event_JL_DedignarCursosMouseClicked

private void showPanel(JPanel p){
        p.setSize(460, 420);
        p.setLocation(0, 0);
        contenedor.removeAll();
        contenedor.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        contenedor.revalidate();
        contenedor.repaint();
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_AdminAlumno;
    private javax.swing.JLabel JL_AdminCurso;
    private javax.swing.JLabel JL_AdminDocente;
    private javax.swing.JLabel JL_AdminSalon;
    private javax.swing.JLabel JL_ButtonControlMenu;
    private javax.swing.JLabel JL_CerrarAdmin;
    private javax.swing.JLabel JL_DedignarCursos;
    private javax.swing.JPanel JP_MenuAdmin;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jl_Cerrar;
    private javax.swing.JLabel jl_Minimizar;
    // End of variables declaration//GEN-END:variables
}
