
package Vista;

import Controlador.Botones_OFF;
import Controlador.C_Docente_Nota;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class V_Docente_Notas extends javax.swing.JPanel {
    private C_Docente_Nota nota;
    private DefaultTableModel tabla;
    Botones_OFF botonesOff = new Botones_OFF();
    Color habilitadoColor = new Color(204,153,255); 

    public V_Docente_Notas() {
        this.nota = new Controlador.C_Docente_Nota();
        initComponents();
        tabla = new DefaultTableModel(); 
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        tabla.addColumn("Bimestre");
        tabla.addColumn("Curso");
        tabla.addColumn("Nota");
        jtbl_Notas.setModel(tabla);
        botonesOff.deshabilitarJPlabel(JL_EditarNotas, JP_EditarNotas);
// Asegurarse de que mostrarDatos se ejecute en el Event Dispatch Thread después de la inicialización
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                nota.mostrarNotas(tabla, jtbl_Notas);
                nota.cargarDatosEnComboBox(jcbxCambioAula);
                nota.cargarCurso(jcbxCambioCurso);
            }});
        nota.agregarListenerComboBox(jcbxCambioAula, tabla, jtbl_Notas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Notas = new javax.swing.JTable();
        jbl_DatosPersonales1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JP_RegistrarNotas = new javax.swing.JPanel();
        JL_RegistrarNotas = new javax.swing.JLabel();
        JP_ConsultarNotas = new javax.swing.JPanel();
        JL_ConsultarNotas = new javax.swing.JLabel();
        JP_EditarNotas = new javax.swing.JPanel();
        JL_EditarNotas = new javax.swing.JLabel();
        jcbxCambioAula = new javax.swing.JComboBox<>();
        jcbxCambioCurso = new javax.swing.JComboBox<>();
        jcbxCambioBimestre = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jbtnCerrarCiclo = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbl_Notas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_Notas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 530, 270));

        jbl_DatosPersonales1.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jbl_DatosPersonales1.setText("REGISTRAR NOTAS");
        jPanel1.add(jbl_DatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 280, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 290, 90));

        JP_RegistrarNotas.setBackground(new java.awt.Color(204, 153, 255));

        JL_RegistrarNotas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_RegistrarNotas.setForeground(new java.awt.Color(255, 255, 255));
        JL_RegistrarNotas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_RegistrarNotas.setText("REGISTRAR");
        JL_RegistrarNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_RegistrarNotas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_RegistrarNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_RegistrarNotasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_RegistrarNotasLayout = new javax.swing.GroupLayout(JP_RegistrarNotas);
        JP_RegistrarNotas.setLayout(JP_RegistrarNotasLayout);
        JP_RegistrarNotasLayout.setHorizontalGroup(
            JP_RegistrarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarNotasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_RegistrarNotasLayout.setVerticalGroup(
            JP_RegistrarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarNotasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_RegistrarNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        JP_ConsultarNotas.setBackground(new java.awt.Color(204, 153, 255));

        JL_ConsultarNotas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_ConsultarNotas.setForeground(new java.awt.Color(255, 255, 255));
        JL_ConsultarNotas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_ConsultarNotas.setText("CONSULTAR");
        JL_ConsultarNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_ConsultarNotas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_ConsultarNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_ConsultarNotasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_ConsultarNotasLayout = new javax.swing.GroupLayout(JP_ConsultarNotas);
        JP_ConsultarNotas.setLayout(JP_ConsultarNotasLayout);
        JP_ConsultarNotasLayout.setHorizontalGroup(
            JP_ConsultarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ConsultarNotasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_ConsultarNotasLayout.setVerticalGroup(
            JP_ConsultarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ConsultarNotasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_ConsultarNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

        JP_EditarNotas.setBackground(new java.awt.Color(204, 153, 255));

        JL_EditarNotas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_EditarNotas.setForeground(new java.awt.Color(255, 255, 255));
        JL_EditarNotas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_EditarNotas.setText("EDITAR");
        JL_EditarNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_EditarNotas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_EditarNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_EditarNotasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EditarNotasLayout = new javax.swing.GroupLayout(JP_EditarNotas);
        JP_EditarNotas.setLayout(JP_EditarNotasLayout);
        JP_EditarNotasLayout.setHorizontalGroup(
            JP_EditarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarNotasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_EditarNotasLayout.setVerticalGroup(
            JP_EditarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarNotasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_EditarNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));

        jcbxCambioAula.setBackground(new java.awt.Color(204, 153, 255));
        jcbxCambioAula.setBorder(javax.swing.BorderFactory.createTitledBorder("Aula"));
        jcbxCambioAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxCambioAulaActionPerformed(evt);
            }
        });
        jPanel1.add(jcbxCambioAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 150, 50));

        jcbxCambioCurso.setBackground(new java.awt.Color(204, 153, 255));
        jcbxCambioCurso.setBorder(javax.swing.BorderFactory.createTitledBorder("Curso"));
        jcbxCambioCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxCambioCursoActionPerformed(evt);
            }
        });
        jPanel1.add(jcbxCambioCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 150, 50));

        jcbxCambioBimestre.setBackground(new java.awt.Color(204, 153, 255));
        jcbxCambioBimestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        jcbxCambioBimestre.setBorder(javax.swing.BorderFactory.createTitledBorder("Bimestre"));
        jcbxCambioBimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxCambioBimestreActionPerformed(evt);
            }
        });
        jPanel1.add(jcbxCambioBimestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 150, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nota.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jbtnCerrarCiclo.setBackground(new java.awt.Color(255, 102, 102));
        jbtnCerrarCiclo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtnCerrarCiclo.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCerrarCiclo.setText("CERRAR CICLO");
        jbtnCerrarCiclo.setBorder(null);
        jbtnCerrarCiclo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCerrarCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCerrarCicloActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCerrarCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 120, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void JL_RegistrarNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_RegistrarNotasMouseClicked
         nota.guardarNotas(jtbl_Notas, jcbxCambioBimestre, jcbxCambioCurso);
    }//GEN-LAST:event_JL_RegistrarNotasMouseClicked

    private void JL_ConsultarNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_ConsultarNotasMouseClicked
         nota.consultarNotas(jtbl_Notas);
         botonesOff.habilitarJPlabel(JL_EditarNotas, JP_EditarNotas, habilitadoColor);
         botonesOff.deshabilitarJPlabel(JL_RegistrarNotas, JP_RegistrarNotas);
    }//GEN-LAST:event_JL_ConsultarNotasMouseClicked

    private void JL_EditarNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_EditarNotasMouseClicked
         nota.editarNotas(jtbl_Notas);
    }//GEN-LAST:event_JL_EditarNotasMouseClicked

    private void jcbxCambioAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxCambioAulaActionPerformed
        //Insert code
    }//GEN-LAST:event_jcbxCambioAulaActionPerformed

    private void jcbxCambioCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxCambioCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxCambioCursoActionPerformed

    private void jcbxCambioBimestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxCambioBimestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxCambioBimestreActionPerformed

    private void jbtnCerrarCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarCicloActionPerformed
        nota.cerrarCicloEscolar();
        botonesOff.deshabilitarJPlabel(JL_RegistrarNotas, JP_RegistrarNotas);
    }//GEN-LAST:event_jbtnCerrarCicloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_ConsultarNotas;
    private javax.swing.JLabel JL_EditarNotas;
    private javax.swing.JLabel JL_RegistrarNotas;
    private javax.swing.JPanel JP_ConsultarNotas;
    private javax.swing.JPanel JP_EditarNotas;
    private javax.swing.JPanel JP_RegistrarNotas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbl_DatosPersonales1;
    private javax.swing.JButton jbtnCerrarCiclo;
    private javax.swing.JComboBox<String> jcbxCambioAula;
    private javax.swing.JComboBox<String> jcbxCambioBimestre;
    private javax.swing.JComboBox<String> jcbxCambioCurso;
    private javax.swing.JTable jtbl_Notas;
    // End of variables declaration//GEN-END:variables
}
