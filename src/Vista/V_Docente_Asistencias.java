
package Vista;
import Controlador.Botones_OFF;
import Controlador.C_Docente_Asistencia;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class V_Docente_Asistencias extends javax.swing.JPanel {
    private C_Docente_Asistencia asis;
    private DefaultTableModel tabla;
    Botones_OFF botonesOff = new Botones_OFF();
    Color habilitadoColor = new Color(255,102,102);

    public V_Docente_Asistencias() {
        this.asis = new Controlador.C_Docente_Asistencia();
        initComponents();
        tabla = new DefaultTableModel(); 
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        tabla.addColumn("Periodo");
        tabla.addColumn("Estado");
        jtbl_Asistencia.setModel(tabla);
        botonesOff.deshabilitarJPlabel(JL_EditarAsistencia, JP_EditarAsistencia);
// Asegurarse de que mostrarDatos se ejecute en el Event Dispatch Thread después de la inicialización
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                asis.mostrarAsistencia(tabla, jtbl_Asistencia);
                asis.cargarDatosEnComboBox(jcbxCambioAula);
            }});
        asis.agregarListenerComboBox(jcbxCambioAula, tabla, jtbl_Asistencia);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Asistencia = new javax.swing.JTable();
        JP_RegistrarAsistencia = new javax.swing.JPanel();
        JL_RegistrarAsistencia = new javax.swing.JLabel();
        JP_ConsultarAsistencia = new javax.swing.JPanel();
        JL_ConsultarAsistencia = new javax.swing.JLabel();
        JP_EditarAsistencia = new javax.swing.JPanel();
        JL_EditarAsistencia = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jbl_DatosPersonales1 = new javax.swing.JLabel();
        jcbxCambioAula = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbl_Asistencia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_Asistencia);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 520, 330));

        JP_RegistrarAsistencia.setBackground(new java.awt.Color(255, 102, 102));

        JL_RegistrarAsistencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_RegistrarAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        JL_RegistrarAsistencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_RegistrarAsistencia.setText("REGISTRAR");
        JL_RegistrarAsistencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_RegistrarAsistencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_RegistrarAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_RegistrarAsistenciaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_RegistrarAsistenciaLayout = new javax.swing.GroupLayout(JP_RegistrarAsistencia);
        JP_RegistrarAsistencia.setLayout(JP_RegistrarAsistenciaLayout);
        JP_RegistrarAsistenciaLayout.setHorizontalGroup(
            JP_RegistrarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarAsistenciaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_RegistrarAsistenciaLayout.setVerticalGroup(
            JP_RegistrarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarAsistenciaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(JP_RegistrarAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        JP_ConsultarAsistencia.setBackground(new java.awt.Color(255, 102, 102));

        JL_ConsultarAsistencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_ConsultarAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        JL_ConsultarAsistencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_ConsultarAsistencia.setText("CONSULTAR");
        JL_ConsultarAsistencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_ConsultarAsistencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_ConsultarAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_ConsultarAsistenciaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_ConsultarAsistenciaLayout = new javax.swing.GroupLayout(JP_ConsultarAsistencia);
        JP_ConsultarAsistencia.setLayout(JP_ConsultarAsistenciaLayout);
        JP_ConsultarAsistenciaLayout.setHorizontalGroup(
            JP_ConsultarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ConsultarAsistenciaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_ConsultarAsistenciaLayout.setVerticalGroup(
            JP_ConsultarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ConsultarAsistenciaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(JP_ConsultarAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, -1, -1));

        JP_EditarAsistencia.setBackground(new java.awt.Color(255, 102, 102));

        JL_EditarAsistencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_EditarAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        JL_EditarAsistencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_EditarAsistencia.setText("EDITAR");
        JL_EditarAsistencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_EditarAsistencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_EditarAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_EditarAsistenciaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EditarAsistenciaLayout = new javax.swing.GroupLayout(JP_EditarAsistencia);
        JP_EditarAsistencia.setLayout(JP_EditarAsistenciaLayout);
        JP_EditarAsistenciaLayout.setHorizontalGroup(
            JP_EditarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarAsistenciaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_EditarAsistenciaLayout.setVerticalGroup(
            JP_EditarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarAsistenciaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(JP_EditarAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 290, 90));

        jbl_DatosPersonales1.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jbl_DatosPersonales1.setText("REGISTRAR ASISTENCIA");
        jPanel2.add(jbl_DatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 330, 60));

        jcbxCambioAula.setBackground(new java.awt.Color(255, 102, 102));
        jcbxCambioAula.setBorder(null);
        jcbxCambioAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxCambioAulaActionPerformed(evt);
            }
        });
        jPanel2.add(jcbxCambioAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 150, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/asistencia.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void JL_RegistrarAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_RegistrarAsistenciaMouseClicked
      asis.guardarAsistencia(jtbl_Asistencia);
    }//GEN-LAST:event_JL_RegistrarAsistenciaMouseClicked

    private void JL_ConsultarAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_ConsultarAsistenciaMouseClicked
      asis.consultarAsistencia(jtbl_Asistencia);
      botonesOff.habilitarJPlabel(JL_EditarAsistencia, JP_EditarAsistencia, habilitadoColor);
      botonesOff.deshabilitarJPlabel(JL_RegistrarAsistencia, JP_RegistrarAsistencia);
    }//GEN-LAST:event_JL_ConsultarAsistenciaMouseClicked

    private void JL_EditarAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_EditarAsistenciaMouseClicked
      asis.editarAsistencia(jtbl_Asistencia);
    }//GEN-LAST:event_JL_EditarAsistenciaMouseClicked

    private void jcbxCambioAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxCambioAulaActionPerformed
      //Insert code
    }//GEN-LAST:event_jcbxCambioAulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_ConsultarAsistencia;
    private javax.swing.JLabel JL_EditarAsistencia;
    private javax.swing.JLabel JL_RegistrarAsistencia;
    private javax.swing.JPanel JP_ConsultarAsistencia;
    private javax.swing.JPanel JP_EditarAsistencia;
    private javax.swing.JPanel JP_RegistrarAsistencia;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbl_DatosPersonales1;
    private javax.swing.JComboBox<String> jcbxCambioAula;
    private javax.swing.JTable jtbl_Asistencia;
    // End of variables declaration//GEN-END:variables
}
