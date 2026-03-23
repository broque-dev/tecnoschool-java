
package Vista;

import Controlador.Botones_OFF;
import Controlador.C_Admin_DesingCurso;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class V_Admin_DesingCurso extends javax.swing.JPanel {
    private C_Admin_DesingCurso desig;
    private DefaultTableModel tabla;
    Botones_OFF botonesOff = new Botones_OFF();
    Color habilitadoColor = new Color(255,102,102);

    public V_Admin_DesingCurso() {
        this.desig = new Controlador.C_Admin_DesingCurso();
        initComponents();
        desig.cargarDatosEnComboBox(jcbx_CursosNombre);
        tabla = new DefaultTableModel(); 
        tabla.addColumn("ID");
        tabla.addColumn("Docente");
        tabla.addColumn("Curso");
        jtbl_ResumenDesigCur.setModel(tabla);
        desig.mostrarDocenteCurso(tabla); 
        botonesOff.deshabilitarJPlabel(JL_EditarDesigCur, JP_EditarDesigCurs);
    }

//OPCIONES CONSULTAR ESTUDIANTE
public void opcionesConsulta() {
    Object[] opciones = {"CONSULTA-CURSOS", "CONSULTA-EDITAR"};
    int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Elige una opción", "CONSULTA", JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE, getIcon("/imagenes/emojiFeliz.png", 50, 50), opciones, opciones[0]);
    switch (opcionSeleccionada) {
        case 0 -> { // DNI
            this.desig.consultarDesignacion(tabla);}
        case 1 -> {// Año
            this.desig.cargarDatosSeleccionados(jtbl_ResumenDesigCur, jtxt_DNIDocenDesig, jcbx_CursosNombre);
            botonesOff.habilitarJPlabel(JL_EditarDesigCur, JP_EditarDesigCurs, habilitadoColor);
            botonesOff.deshabilitarJPlabel(JL_RegistrarDesigCur, JP_RegistrarDesingCur);}
        default -> {
            }}}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_ResumenDesigCur = new javax.swing.JTable();
        jbl_DatosPersonales1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JP_RegistrarDesingCur = new javax.swing.JPanel();
        JL_RegistrarDesigCur = new javax.swing.JLabel();
        JP_ConsultarDesigCurs = new javax.swing.JPanel();
        JL_ConsultarDesigCur = new javax.swing.JLabel();
        JP_EditarDesigCurs = new javax.swing.JPanel();
        JL_EditarDesigCur = new javax.swing.JLabel();
        JP_EliminarDesigCurs = new javax.swing.JPanel();
        JL_EliminarDesigCur = new javax.swing.JLabel();
        jtxt_DNIDocenDesig = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcbx_CursosNombre = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbl_ResumenDesigCur.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_ResumenDesigCur);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 470, 280));

        jbl_DatosPersonales1.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jbl_DatosPersonales1.setText("DESIGNAR CURSO DOCENTE");
        jPanel1.add(jbl_DatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 390, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 280, 90));

        JP_RegistrarDesingCur.setBackground(new java.awt.Color(255, 102, 102));

        JL_RegistrarDesigCur.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_RegistrarDesigCur.setForeground(new java.awt.Color(255, 255, 255));
        JL_RegistrarDesigCur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_RegistrarDesigCur.setText("REGISTRAR");
        JL_RegistrarDesigCur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_RegistrarDesigCur.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_RegistrarDesigCur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_RegistrarDesigCurMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_RegistrarDesingCurLayout = new javax.swing.GroupLayout(JP_RegistrarDesingCur);
        JP_RegistrarDesingCur.setLayout(JP_RegistrarDesingCurLayout);
        JP_RegistrarDesingCurLayout.setHorizontalGroup(
            JP_RegistrarDesingCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarDesingCurLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarDesigCur, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_RegistrarDesingCurLayout.setVerticalGroup(
            JP_RegistrarDesingCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarDesingCurLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarDesigCur, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_RegistrarDesingCur, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        JP_ConsultarDesigCurs.setBackground(new java.awt.Color(255, 102, 102));

        JL_ConsultarDesigCur.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_ConsultarDesigCur.setForeground(new java.awt.Color(255, 255, 255));
        JL_ConsultarDesigCur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_ConsultarDesigCur.setText("CONSULTAR");
        JL_ConsultarDesigCur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_ConsultarDesigCur.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_ConsultarDesigCur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_ConsultarDesigCurMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_ConsultarDesigCursLayout = new javax.swing.GroupLayout(JP_ConsultarDesigCurs);
        JP_ConsultarDesigCurs.setLayout(JP_ConsultarDesigCursLayout);
        JP_ConsultarDesigCursLayout.setHorizontalGroup(
            JP_ConsultarDesigCursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ConsultarDesigCursLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarDesigCur, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_ConsultarDesigCursLayout.setVerticalGroup(
            JP_ConsultarDesigCursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ConsultarDesigCursLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarDesigCur, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_ConsultarDesigCurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        JP_EditarDesigCurs.setBackground(new java.awt.Color(255, 102, 102));

        JL_EditarDesigCur.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_EditarDesigCur.setForeground(new java.awt.Color(255, 255, 255));
        JL_EditarDesigCur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_EditarDesigCur.setText("EDITAR");
        JL_EditarDesigCur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_EditarDesigCur.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_EditarDesigCur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_EditarDesigCurMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EditarDesigCursLayout = new javax.swing.GroupLayout(JP_EditarDesigCurs);
        JP_EditarDesigCurs.setLayout(JP_EditarDesigCursLayout);
        JP_EditarDesigCursLayout.setHorizontalGroup(
            JP_EditarDesigCursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarDesigCursLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarDesigCur, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_EditarDesigCursLayout.setVerticalGroup(
            JP_EditarDesigCursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarDesigCursLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarDesigCur, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_EditarDesigCurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        JP_EliminarDesigCurs.setBackground(new java.awt.Color(255, 102, 102));

        JL_EliminarDesigCur.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_EliminarDesigCur.setForeground(new java.awt.Color(255, 255, 255));
        JL_EliminarDesigCur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_EliminarDesigCur.setText("ELIMINAR");
        JL_EliminarDesigCur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_EliminarDesigCur.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_EliminarDesigCur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_EliminarDesigCurMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EliminarDesigCursLayout = new javax.swing.GroupLayout(JP_EliminarDesigCurs);
        JP_EliminarDesigCurs.setLayout(JP_EliminarDesigCursLayout);
        JP_EliminarDesigCursLayout.setHorizontalGroup(
            JP_EliminarDesigCursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EliminarDesigCursLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EliminarDesigCur, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_EliminarDesigCursLayout.setVerticalGroup(
            JP_EliminarDesigCursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EliminarDesigCursLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EliminarDesigCur, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(JP_EliminarDesigCurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, -1, -1));

        jtxt_DNIDocenDesig.setBackground(new java.awt.Color(255, 204, 204));
        jtxt_DNIDocenDesig.setBorder(null);
        jPanel1.add(jtxt_DNIDocenDesig, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 200, 40));

        jSeparator4.setBackground(new java.awt.Color(255, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 200, 10));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("DNI DEL DOCENTE:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 210, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("NOMBRE DEL CURSO:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 210, -1));

        jcbx_CursosNombre.setBackground(new java.awt.Color(255, 204, 204));
        jcbx_CursosNombre.setBorder(null);
        jPanel1.add(jcbx_CursosNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 160, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desig.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 80));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void JL_RegistrarDesigCurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_RegistrarDesigCurMouseClicked
        desig.registrarDesignacion(jtxt_DNIDocenDesig, jcbx_CursosNombre);
        tabla.setRowCount(0);
        desig.mostrarDocenteCurso(tabla); 
        jtxt_DNIDocenDesig.setText("");
    }//GEN-LAST:event_JL_RegistrarDesigCurMouseClicked

    private void JL_ConsultarDesigCurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_ConsultarDesigCurMouseClicked
        opcionesConsulta();
    }//GEN-LAST:event_JL_ConsultarDesigCurMouseClicked

    private void JL_EditarDesigCurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_EditarDesigCurMouseClicked
        desig.guardarEdicion(jtbl_ResumenDesigCur, jtxt_DNIDocenDesig, jcbx_CursosNombre);
        tabla.setRowCount(0);
        desig.mostrarDocenteCurso(tabla); 
        jtxt_DNIDocenDesig.setText("");
        botonesOff.habilitarJPlabel(JL_RegistrarDesigCur, JP_RegistrarDesingCur, habilitadoColor);
        botonesOff.deshabilitarJPlabel(JL_EditarDesigCur, JP_EditarDesigCurs);
    }//GEN-LAST:event_JL_EditarDesigCurMouseClicked

    private void JL_EliminarDesigCurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_EliminarDesigCurMouseClicked
        desig.eliminarDesignacion(jtbl_ResumenDesigCur);
        tabla.setRowCount(0);
        desig.mostrarDocenteCurso(tabla); 
    }//GEN-LAST:event_JL_EliminarDesigCurMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_ConsultarDesigCur;
    private javax.swing.JLabel JL_EditarDesigCur;
    private javax.swing.JLabel JL_EliminarDesigCur;
    private javax.swing.JLabel JL_RegistrarDesigCur;
    private javax.swing.JPanel JP_ConsultarDesigCurs;
    private javax.swing.JPanel JP_EditarDesigCurs;
    private javax.swing.JPanel JP_EliminarDesigCurs;
    private javax.swing.JPanel JP_RegistrarDesingCur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel jbl_DatosPersonales1;
    private javax.swing.JComboBox<String> jcbx_CursosNombre;
    private javax.swing.JTable jtbl_ResumenDesigCur;
    public javax.swing.JTextField jtxt_DNIDocenDesig;
    // End of variables declaration//GEN-END:variables
    private Icon getIcon(String path, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(path))
                .getImage().getScaledInstance(w, h, 0));
    }
}
