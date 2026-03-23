
package Vista;
import Controlador.Botones_OFF;
import Controlador.C_Admin_Cursos;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class V_Admin_Cursos extends javax.swing.JPanel {
    private C_Admin_Cursos AdminCurso;
    private DefaultTableModel tabla;
    Botones_OFF botonesOff = new Botones_OFF();
    Color habilitadoColor = new Color(204,153,255);
    
    public V_Admin_Cursos() {
    this.AdminCurso = new Controlador.C_Admin_Cursos(); 
    initComponents();
    tabla = new DefaultTableModel(); 
    tabla.addColumn("ID");
    tabla.addColumn("Curso");
    tabla.addColumn("Descripción");
    jtbl_ResumenCursos.setModel(tabla);
    AdminCurso.mostrarCursos(tabla); // Llamada al método mostrarCursos
    botonesOff.deshabilitarJPlabel(JL_EditarCurso, JP_EditarCurso);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_Entrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_ResumenCursos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jbl_DatosPersonales1 = new javax.swing.JLabel();
        jtxt_NuevoCurso = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTA_DescripcionCurso = new javax.swing.JTextArea();
        JP_EditarCurso = new javax.swing.JPanel();
        JL_EditarCurso = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JL_BorrarCurso = new javax.swing.JLabel();
        JP_RegistrarCurso = new javax.swing.JPanel();
        JL_RegistrarCurso = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        JL_ConsultarCurso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        JL_Entrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_Entrar.setForeground(new java.awt.Color(255, 255, 255));
        JL_Entrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_Entrar.setText("ENTRAR");
        JL_Entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_Entrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_Entrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_EntrarMouseClicked(evt);
            }
        });

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbl_ResumenCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbl_ResumenCursos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 280));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 290, 90));

        jbl_DatosPersonales1.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jbl_DatosPersonales1.setText("CURSOS DISPONIBLES");
        jPanel1.add(jbl_DatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 310, 60));

        jtxt_NuevoCurso.setBackground(new java.awt.Color(204, 204, 255));
        jtxt_NuevoCurso.setBorder(null);
        jPanel1.add(jtxt_NuevoCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 210, 40));

        jSeparator4.setBackground(new java.awt.Color(204, 204, 255));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 210, 10));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("INGRESE NUEVO CURSO:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 190, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("INGRESE DESCRIPCION:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 190, -1));

        JTA_DescripcionCurso.setBackground(new java.awt.Color(204, 204, 255));
        JTA_DescripcionCurso.setColumns(20);
        JTA_DescripcionCurso.setRows(5);
        JTA_DescripcionCurso.setBorder(null);
        jScrollPane2.setViewportView(JTA_DescripcionCurso);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 210, 130));

        JP_EditarCurso.setBackground(new java.awt.Color(204, 153, 255));

        JL_EditarCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_EditarCurso.setForeground(new java.awt.Color(255, 255, 255));
        JL_EditarCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_EditarCurso.setText("EDITAR");
        JL_EditarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_EditarCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_EditarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_EditarCursoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EditarCursoLayout = new javax.swing.GroupLayout(JP_EditarCurso);
        JP_EditarCurso.setLayout(JP_EditarCursoLayout);
        JP_EditarCursoLayout.setHorizontalGroup(
            JP_EditarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarCursoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_EditarCursoLayout.setVerticalGroup(
            JP_EditarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarCursoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_EditarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, 50));

        jPanel3.setBackground(new java.awt.Color(204, 153, 255));

        JL_BorrarCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_BorrarCurso.setForeground(new java.awt.Color(255, 255, 255));
        JL_BorrarCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_BorrarCurso.setText("BORRAR");
        JL_BorrarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_BorrarCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_BorrarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_BorrarCursoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_BorrarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_BorrarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

        JP_RegistrarCurso.setBackground(new java.awt.Color(204, 153, 255));

        JL_RegistrarCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_RegistrarCurso.setForeground(new java.awt.Color(255, 255, 255));
        JL_RegistrarCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_RegistrarCurso.setText("REGISTRAR");
        JL_RegistrarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_RegistrarCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_RegistrarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_RegistrarCursoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_RegistrarCursoLayout = new javax.swing.GroupLayout(JP_RegistrarCurso);
        JP_RegistrarCurso.setLayout(JP_RegistrarCursoLayout);
        JP_RegistrarCursoLayout.setHorizontalGroup(
            JP_RegistrarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarCursoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_RegistrarCursoLayout.setVerticalGroup(
            JP_RegistrarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarCursoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_RegistrarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, -1, -1));

        jPanel5.setBackground(new java.awt.Color(204, 153, 255));

        JL_ConsultarCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_ConsultarCurso.setForeground(new java.awt.Color(255, 255, 255));
        JL_ConsultarCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_ConsultarCurso.setText("CONSULTAR");
        JL_ConsultarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_ConsultarCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_ConsultarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_ConsultarCursoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/curso.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 80));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void JL_EntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_EntrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JL_EntrarMouseClicked

    private void JL_EditarCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_EditarCursoMouseClicked
       AdminCurso.editarCurso(jtxt_NuevoCurso, JTA_DescripcionCurso);
       tabla.setRowCount(0);
       AdminCurso.mostrarCursos(tabla);
       limpiar();
       botonesOff.habilitarJPlabel(JL_RegistrarCurso, JP_RegistrarCurso, habilitadoColor);
       botonesOff.deshabilitarJPlabel(JL_EditarCurso, JP_EditarCurso);
    }//GEN-LAST:event_JL_EditarCursoMouseClicked

    private void JL_RegistrarCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_RegistrarCursoMouseClicked
       AdminCurso.registrarCurso(jtxt_NuevoCurso, JTA_DescripcionCurso);
       tabla.setRowCount(0);
       AdminCurso.mostrarCursos(tabla);
       limpiar();
    }//GEN-LAST:event_JL_RegistrarCursoMouseClicked

    private void JL_BorrarCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_BorrarCursoMouseClicked
       AdminCurso.eliminarCurso();
       tabla.setRowCount(0);
       AdminCurso.mostrarCursos(tabla);
    }//GEN-LAST:event_JL_BorrarCursoMouseClicked

    private void JL_ConsultarCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_ConsultarCursoMouseClicked
       AdminCurso.consultarCurso(jtxt_NuevoCurso, JTA_DescripcionCurso, tabla);
       botonesOff.habilitarJPlabel(JL_EditarCurso, JP_EditarCurso, habilitadoColor);
       botonesOff.deshabilitarJPlabel(JL_RegistrarCurso, JP_RegistrarCurso);
    }//GEN-LAST:event_JL_ConsultarCursoMouseClicked
    public void limpiar(){
        jtxt_NuevoCurso.setText("");
        JTA_DescripcionCurso.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JL_BorrarCurso;
    public javax.swing.JLabel JL_ConsultarCurso;
    public javax.swing.JLabel JL_EditarCurso;
    private javax.swing.JLabel JL_Entrar;
    public javax.swing.JLabel JL_RegistrarCurso;
    public javax.swing.JPanel JP_EditarCurso;
    public javax.swing.JPanel JP_RegistrarCurso;
    public javax.swing.JTextArea JTA_DescripcionCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel jbl_DatosPersonales1;
    public javax.swing.JTable jtbl_ResumenCursos;
    public javax.swing.JTextField jtxt_NuevoCurso;
    // End of variables declaration//GEN-END:variables
}
