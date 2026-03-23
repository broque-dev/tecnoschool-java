
package Vista;
import Controlador.Botones_OFF;
import Controlador.C_Admin_Aulas;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class V_Admin_Aulas extends javax.swing.JPanel {
    private C_Admin_Aulas AdminAulas;
    private DefaultTableModel tabla;
    Botones_OFF botonesOff = new Botones_OFF();
    Color habilitadoColor = new Color(153,255,153);

    public V_Admin_Aulas() {
        initComponents();
        this.AdminAulas = new Controlador.C_Admin_Aulas();
        tabla = new DefaultTableModel(); 
        tabla.addColumn("ID");
        tabla.addColumn("Grado");
        tabla.addColumn("Sección");
        tabla.addColumn("Horas");
        tabla.addColumn("Disponibilidad");
        jtbl_ResumenCursos.setModel(tabla);
        AdminAulas.mostrarSalones(tabla);
        botonesOff.deshabilitarJPlabel(JL_EditarAula, JP_EditarAula);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_ResumenCursos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jbl_DatosPersonales1 = new javax.swing.JLabel();
        JP_EditarAula = new javax.swing.JPanel();
        JL_EditarAula = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JL_BorrarAula = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        JL_ConsultarAula = new javax.swing.JLabel();
        jtxt_AulaSeccion = new javax.swing.JTextField();
        jtxt_AulaGrado = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtxt_AulaHoras = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        JP_RegistrarAula = new javax.swing.JPanel();
        JL_RegistrarAula = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("INGRESE NUEVO CURSO:");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbl_ResumenCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jtbl_ResumenCursos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 400, 290));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 290, 90));

        jbl_DatosPersonales1.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jbl_DatosPersonales1.setText("AULAS DISPONIBLES");
        jPanel1.add(jbl_DatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 280, 60));

        JP_EditarAula.setBackground(new java.awt.Color(153, 255, 153));

        JL_EditarAula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_EditarAula.setForeground(new java.awt.Color(51, 153, 0));
        JL_EditarAula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_EditarAula.setText("EDITAR");
        JL_EditarAula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_EditarAula.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_EditarAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_EditarAulaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EditarAulaLayout = new javax.swing.GroupLayout(JP_EditarAula);
        JP_EditarAula.setLayout(JP_EditarAulaLayout);
        JP_EditarAulaLayout.setHorizontalGroup(
            JP_EditarAulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarAulaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_EditarAulaLayout.setVerticalGroup(
            JP_EditarAulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarAulaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_EditarAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, 50));

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

        JL_BorrarAula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_BorrarAula.setForeground(new java.awt.Color(51, 153, 0));
        JL_BorrarAula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_BorrarAula.setText("BORRAR");
        JL_BorrarAula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_BorrarAula.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_BorrarAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_BorrarAulaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_BorrarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_BorrarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("SECCION:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 80, -1));

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));

        JL_ConsultarAula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_ConsultarAula.setForeground(new java.awt.Color(51, 153, 0));
        JL_ConsultarAula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_ConsultarAula.setText("CONSULTAR");
        JL_ConsultarAula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_ConsultarAula.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_ConsultarAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_ConsultarAulaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 140, 50));

        jtxt_AulaSeccion.setBackground(new java.awt.Color(204, 255, 204));
        jtxt_AulaSeccion.setBorder(null);
        jPanel1.add(jtxt_AulaSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 90, 40));

        jtxt_AulaGrado.setBackground(new java.awt.Color(204, 255, 204));
        jtxt_AulaGrado.setBorder(null);
        jPanel1.add(jtxt_AulaGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 90, 40));

        jSeparator7.setBackground(new java.awt.Color(204, 255, 204));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 90, 10));

        jSeparator8.setBackground(new java.awt.Color(204, 255, 204));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 90, 10));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("INGRESE NUEVO SALON");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 240, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("GRADO:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 80, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("HORAS:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 80, -1));

        jtxt_AulaHoras.setBackground(new java.awt.Color(204, 255, 204));
        jtxt_AulaHoras.setBorder(null);
        jPanel1.add(jtxt_AulaHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 90, 40));

        jSeparator9.setBackground(new java.awt.Color(204, 255, 204));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 90, 10));

        JP_RegistrarAula.setBackground(new java.awt.Color(153, 255, 153));

        JL_RegistrarAula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_RegistrarAula.setForeground(new java.awt.Color(51, 153, 0));
        JL_RegistrarAula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_RegistrarAula.setText("REGITRAR");
        JL_RegistrarAula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_RegistrarAula.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_RegistrarAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_RegistrarAulaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_RegistrarAulaLayout = new javax.swing.GroupLayout(JP_RegistrarAula);
        JP_RegistrarAula.setLayout(JP_RegistrarAulaLayout);
        JP_RegistrarAulaLayout.setHorizontalGroup(
            JP_RegistrarAulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarAulaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_RegistrarAulaLayout.setVerticalGroup(
            JP_RegistrarAulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarAulaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_RegistrarAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aula.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JL_EditarAulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_EditarAulaMouseClicked
       AdminAulas.editarAula(jtxt_AulaGrado, jtxt_AulaSeccion, jtxt_AulaHoras);
       tabla.setRowCount(0);
       AdminAulas.mostrarSalones(tabla);
       limpiar();
       botonesOff.habilitarJPlabel(JL_RegistrarAula, JP_RegistrarAula, habilitadoColor);
       botonesOff.deshabilitarJPlabel(JL_EditarAula, JP_EditarAula);
    }//GEN-LAST:event_JL_EditarAulaMouseClicked

    private void JL_BorrarAulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_BorrarAulaMouseClicked
       AdminAulas.eliminarAula();
       tabla.setRowCount(0);
       AdminAulas.mostrarSalones(tabla);
    }//GEN-LAST:event_JL_BorrarAulaMouseClicked

    private void JL_ConsultarAulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_ConsultarAulaMouseClicked
       AdminAulas.consultarAula(jtxt_AulaGrado, jtxt_AulaSeccion, jtxt_AulaHoras, tabla);
       botonesOff.habilitarJPlabel(JL_EditarAula, JP_EditarAula, habilitadoColor);
       botonesOff.deshabilitarJPlabel(JL_RegistrarAula, JP_RegistrarAula);
    }//GEN-LAST:event_JL_ConsultarAulaMouseClicked

    private void JL_RegistrarAulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_RegistrarAulaMouseClicked
       AdminAulas.registrarAula(jtxt_AulaGrado, jtxt_AulaSeccion, jtxt_AulaHoras);
       tabla.setRowCount(0);
       AdminAulas.mostrarSalones(tabla);
       limpiar();
    }//GEN-LAST:event_JL_RegistrarAulaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_BorrarAula;
    private javax.swing.JLabel JL_ConsultarAula;
    private javax.swing.JLabel JL_EditarAula;
    private javax.swing.JLabel JL_RegistrarAula;
    private javax.swing.JPanel JP_EditarAula;
    private javax.swing.JPanel JP_RegistrarAula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel jbl_DatosPersonales1;
    private javax.swing.JTable jtbl_ResumenCursos;
    private javax.swing.JTextField jtxt_AulaGrado;
    private javax.swing.JTextField jtxt_AulaHoras;
    private javax.swing.JTextField jtxt_AulaSeccion;
    // End of variables declaration//GEN-END:variables
    public void limpiar(){
        jtxt_AulaGrado.setText("");
        jtxt_AulaSeccion.setText("");
        jtxt_AulaHoras.setText("");
    }
}
