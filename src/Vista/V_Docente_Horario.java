
package Vista;

import Controlador.C_Docente_Horario;
import Controlador.Slide;
import javax.swing.table.DefaultTableModel;

public class V_Docente_Horario extends javax.swing.JPanel {
    private DefaultTableModel horario;
    private C_Docente_Horario hora;
    Slide sslide;


    public V_Docente_Horario() {
        this.hora = new Controlador.C_Docente_Horario();
        initComponents();
        sslide = new Slide();
        horario = new DefaultTableModel(); 
        jtbl_Horario.setModel(horario);
        // Asegurarse de que mostrarDatos se ejecute en el Event Dispatch Thread después de la inicialización
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            mostrar();
            hora.mostrarHorarioCompleto(horario);
            }});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jtblDatosHorario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Horario = new javax.swing.JTable();
        jbl_DatosPersonales2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jbl_DatosPersonales1 = new javax.swing.JLabel();
        jtxt_JU_1 = new javax.swing.JTextField();
        jtxt_MA_1 = new javax.swing.JTextField();
        jtxt_MI_1 = new javax.swing.JTextField();
        jtxt_VI_1 = new javax.swing.JTextField();
        jtxt_LU_1 = new javax.swing.JTextField();
        jtxt_JU_2 = new javax.swing.JTextField();
        jtxt_MA_2 = new javax.swing.JTextField();
        jtxt_MI_2 = new javax.swing.JTextField();
        jtxt_VI_2 = new javax.swing.JTextField();
        jtxt_LU_2 = new javax.swing.JTextField();
        jtxt_LU_3 = new javax.swing.JTextField();
        jtxt_MI_3 = new javax.swing.JTextField();
        jtxt_JU_3 = new javax.swing.JTextField();
        jtxt_MA_3 = new javax.swing.JTextField();
        jtxt_VI_3 = new javax.swing.JTextField();
        jtxt_JU_4 = new javax.swing.JTextField();
        jtxt_MA_4 = new javax.swing.JTextField();
        jtxt_MI_4 = new javax.swing.JTextField();
        jtxt_VI_4 = new javax.swing.JTextField();
        jtxt_LU_4 = new javax.swing.JTextField();
        horas = new javax.swing.JTextField();
        jtxt_MI_5 = new javax.swing.JTextField();
        jtxt_JU_5 = new javax.swing.JTextField();
        jtxt_MA_5 = new javax.swing.JTextField();
        jtxt_VI_5 = new javax.swing.JTextField();
        jueves = new javax.swing.JTextField();
        martes = new javax.swing.JTextField();
        miercoles = new javax.swing.JTextField();
        viernes = new javax.swing.JTextField();
        lunes = new javax.swing.JTextField();
        jtxt_LU_5 = new javax.swing.JTextField();
        horas3 = new javax.swing.JTextField();
        horas1 = new javax.swing.JTextField();
        horas2 = new javax.swing.JTextField();
        horas5 = new javax.swing.JTextField();
        horas4 = new javax.swing.JTextField();
        jtxt_MI_6 = new javax.swing.JTextField();
        jtxt_JU_6 = new javax.swing.JTextField();
        jtxt_MA_6 = new javax.swing.JTextField();
        jtxt_VI_6 = new javax.swing.JTextField();
        jtxt_LU_6 = new javax.swing.JTextField();
        horas6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(229, 200, 170));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblDatosHorario.setBackground(new java.awt.Color(196, 162, 55));
        jtblDatosHorario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("<");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jtblDatosHorario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 195, 20, 40));

        jtbl_Horario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_Horario);

        jtblDatosHorario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 680, 360));

        jbl_DatosPersonales2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbl_DatosPersonales2.setText("DATOS COMPLETOS HORARIO DOCENTE");
        jtblDatosHorario.add(jbl_DatosPersonales2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 500, 60));

        jPanel1.add(jtblDatosHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 730, 460));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 290, 90));

        jbl_DatosPersonales1.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jbl_DatosPersonales1.setText("HORARIO DOCENTE");
        jPanel1.add(jbl_DatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 280, 60));

        jtxt_JU_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_JU_1.setFocusable(false);
        jPanel1.add(jtxt_JU_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 120, 50));

        jtxt_MA_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MA_1.setFocusable(false);
        jPanel1.add(jtxt_MA_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 120, 50));

        jtxt_MI_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MI_1.setFocusable(false);
        jPanel1.add(jtxt_MI_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 120, 50));

        jtxt_VI_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_VI_1.setFocusable(false);
        jPanel1.add(jtxt_VI_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 120, 50));

        jtxt_LU_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_LU_1.setFocusable(false);
        jPanel1.add(jtxt_LU_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 120, 50));

        jtxt_JU_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_JU_2.setFocusable(false);
        jPanel1.add(jtxt_JU_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 120, 50));

        jtxt_MA_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MA_2.setFocusable(false);
        jPanel1.add(jtxt_MA_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 120, 50));

        jtxt_MI_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MI_2.setFocusable(false);
        jPanel1.add(jtxt_MI_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 120, 50));

        jtxt_VI_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_VI_2.setFocusable(false);
        jPanel1.add(jtxt_VI_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 120, 50));

        jtxt_LU_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_LU_2.setFocusable(false);
        jPanel1.add(jtxt_LU_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 120, 50));

        jtxt_LU_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_LU_3.setFocusable(false);
        jPanel1.add(jtxt_LU_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 120, 50));

        jtxt_MI_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MI_3.setFocusable(false);
        jPanel1.add(jtxt_MI_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 120, 50));

        jtxt_JU_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_JU_3.setFocusable(false);
        jPanel1.add(jtxt_JU_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 120, 50));

        jtxt_MA_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MA_3.setFocusable(false);
        jPanel1.add(jtxt_MA_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 120, 50));

        jtxt_VI_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_VI_3.setFocusable(false);
        jPanel1.add(jtxt_VI_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 120, 50));

        jtxt_JU_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_JU_4.setFocusable(false);
        jPanel1.add(jtxt_JU_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 120, 50));

        jtxt_MA_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MA_4.setFocusable(false);
        jPanel1.add(jtxt_MA_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 120, 50));

        jtxt_MI_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MI_4.setFocusable(false);
        jPanel1.add(jtxt_MI_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 120, 50));

        jtxt_VI_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_VI_4.setFocusable(false);
        jPanel1.add(jtxt_VI_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 120, 50));

        jtxt_LU_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_LU_4.setFocusable(false);
        jPanel1.add(jtxt_LU_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 120, 50));

        horas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        horas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        horas.setText("HORAS");
        horas.setFocusable(false);
        jPanel1.add(horas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 50));

        jtxt_MI_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MI_5.setFocusable(false);
        jtxt_MI_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_MI_5ActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_MI_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 120, 50));

        jtxt_JU_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_JU_5.setFocusable(false);
        jPanel1.add(jtxt_JU_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 120, 50));

        jtxt_MA_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MA_5.setFocusable(false);
        jPanel1.add(jtxt_MA_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 120, 50));

        jtxt_VI_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_VI_5.setFocusable(false);
        jPanel1.add(jtxt_VI_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 120, 50));

        jueves.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jueves.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jueves.setText("JUEVES");
        jueves.setFocusable(false);
        jPanel1.add(jueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 120, 50));

        martes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        martes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        martes.setText("MARTES");
        martes.setFocusable(false);
        jPanel1.add(martes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 120, 50));

        miercoles.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        miercoles.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        miercoles.setText("MIERCOLES");
        miercoles.setFocusable(false);
        jPanel1.add(miercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 120, 50));

        viernes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viernes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        viernes.setText("VIERNES");
        viernes.setFocusable(false);
        jPanel1.add(viernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 120, 50));

        lunes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lunes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lunes.setText("LUNES");
        lunes.setFocusable(false);
        jPanel1.add(lunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 120, 50));

        jtxt_LU_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_LU_5.setFocusable(false);
        jtxt_LU_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_LU_5ActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_LU_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 120, 50));

        horas3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        horas3.setText("9:15 - 10:00");
        horas3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horas3.setFocusable(false);
        horas3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horas3MouseClicked(evt);
            }
        });
        jPanel1.add(horas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 80, 50));

        horas1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        horas1.setText("7:45 - 8:30");
        horas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horas1.setFocusable(false);
        horas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horas1MouseClicked(evt);
            }
        });
        horas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horas1ActionPerformed(evt);
            }
        });
        jPanel1.add(horas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 80, 50));

        horas2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        horas2.setText("8:30 - 9:15");
        horas2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horas2.setFocusable(false);
        horas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horas2MouseClicked(evt);
            }
        });
        jPanel1.add(horas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, 50));

        horas5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        horas5.setText("11:15 - 12:00");
        horas5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horas5.setFocusable(false);
        horas5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horas5MouseClicked(evt);
            }
        });
        jPanel1.add(horas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 80, 50));

        horas4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        horas4.setText("10:30 - 11:15");
        horas4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horas4.setFocusable(false);
        horas4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horas4MouseClicked(evt);
            }
        });
        jPanel1.add(horas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 80, 50));

        jtxt_MI_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MI_6.setFocusable(false);
        jtxt_MI_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_MI_6ActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_MI_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 120, 50));

        jtxt_JU_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_JU_6.setFocusable(false);
        jPanel1.add(jtxt_JU_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 120, 50));

        jtxt_MA_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_MA_6.setFocusable(false);
        jPanel1.add(jtxt_MA_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 120, 50));

        jtxt_VI_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_VI_6.setFocusable(false);
        jPanel1.add(jtxt_VI_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 120, 50));

        jtxt_LU_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_LU_6.setFocusable(false);
        jPanel1.add(jtxt_LU_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 120, 50));

        horas6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        horas6.setText("12:00 - 12:40");
        horas6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horas6.setFocusable(false);
        horas6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horas6MouseClicked(evt);
            }
        });
        jPanel1.add(horas6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 80, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/horario.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtxt_MI_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_MI_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_MI_6ActionPerformed

    private void jtxt_MI_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_MI_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_MI_5ActionPerformed

    private void jtxt_LU_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_LU_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_LU_5ActionPerformed

    private void horas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horas1ActionPerformed

    private void horas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horas1MouseClicked
        hora.GuardarHorario(horas1);
    }//GEN-LAST:event_horas1MouseClicked

    private void horas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horas2MouseClicked
        hora.GuardarHorario(horas2);
    }//GEN-LAST:event_horas2MouseClicked

    private void horas3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horas3MouseClicked
        hora.GuardarHorario(horas3);
    }//GEN-LAST:event_horas3MouseClicked

    private void horas4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horas4MouseClicked
        hora.GuardarHorario(horas4);
    }//GEN-LAST:event_horas4MouseClicked

    private void horas5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horas5MouseClicked
        hora.GuardarHorario(horas5);
    }//GEN-LAST:event_horas5MouseClicked

    private void horas6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horas6MouseClicked
        hora.GuardarHorario(horas6);
    }//GEN-LAST:event_horas6MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        sslide.jPanelXIzquierda(700, 0, 10, 5, jtblDatosHorario);
        sslide.jPanelXDerecha(0, 700, 10, 5, jtblDatosHorario);
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField horas;
    public javax.swing.JTextField horas1;
    public javax.swing.JTextField horas2;
    public javax.swing.JTextField horas3;
    public javax.swing.JTextField horas4;
    public javax.swing.JTextField horas5;
    public javax.swing.JTextField horas6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbl_DatosPersonales1;
    private javax.swing.JLabel jbl_DatosPersonales2;
    private javax.swing.JPanel jtblDatosHorario;
    private javax.swing.JTable jtbl_Horario;
    public javax.swing.JTextField jtxt_JU_1;
    public javax.swing.JTextField jtxt_JU_2;
    public javax.swing.JTextField jtxt_JU_3;
    public javax.swing.JTextField jtxt_JU_4;
    public javax.swing.JTextField jtxt_JU_5;
    public javax.swing.JTextField jtxt_JU_6;
    public javax.swing.JTextField jtxt_LU_1;
    public javax.swing.JTextField jtxt_LU_2;
    public javax.swing.JTextField jtxt_LU_3;
    public javax.swing.JTextField jtxt_LU_4;
    public javax.swing.JTextField jtxt_LU_5;
    public javax.swing.JTextField jtxt_LU_6;
    public javax.swing.JTextField jtxt_MA_1;
    public javax.swing.JTextField jtxt_MA_2;
    public javax.swing.JTextField jtxt_MA_3;
    public javax.swing.JTextField jtxt_MA_4;
    public javax.swing.JTextField jtxt_MA_5;
    public javax.swing.JTextField jtxt_MA_6;
    public javax.swing.JTextField jtxt_MI_1;
    public javax.swing.JTextField jtxt_MI_2;
    public javax.swing.JTextField jtxt_MI_3;
    public javax.swing.JTextField jtxt_MI_4;
    public javax.swing.JTextField jtxt_MI_5;
    public javax.swing.JTextField jtxt_MI_6;
    public javax.swing.JTextField jtxt_VI_1;
    public javax.swing.JTextField jtxt_VI_2;
    public javax.swing.JTextField jtxt_VI_3;
    public javax.swing.JTextField jtxt_VI_4;
    public javax.swing.JTextField jtxt_VI_5;
    public javax.swing.JTextField jtxt_VI_6;
    public javax.swing.JTextField jueves;
    public javax.swing.JTextField lunes;
    public javax.swing.JTextField martes;
    public javax.swing.JTextField miercoles;
    public javax.swing.JTextField viernes;
    // End of variables declaration//GEN-END:variables
public void mostrar(){
    hora.mostrarHorarioRegistrado(jtxt_LU_1,jtxt_MA_1,jtxt_MI_1,jtxt_JU_1,jtxt_VI_1,jtxt_LU_2,jtxt_MA_2,jtxt_MI_2,jtxt_JU_2,jtxt_VI_2,jtxt_LU_3,jtxt_MA_3,jtxt_MI_3,jtxt_JU_3,jtxt_VI_3,jtxt_LU_4,jtxt_MA_4,jtxt_MI_4,jtxt_JU_4,jtxt_VI_4,jtxt_LU_5,jtxt_MA_5,jtxt_MI_5,jtxt_JU_5,jtxt_VI_5,jtxt_LU_6,jtxt_MA_6,jtxt_MI_6,jtxt_JU_6,jtxt_VI_6);
}
}
