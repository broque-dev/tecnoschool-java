
package Vista;

import Controlador.C_Docente_Seguimiento;
import javax.swing.table.DefaultTableModel;

public class V_Docente_Seguimiento extends javax.swing.JPanel {
    private C_Docente_Seguimiento segui;
    private DefaultTableModel tabla;
    
    public V_Docente_Seguimiento() {
        this.segui = new Controlador.C_Docente_Seguimiento();
        initComponents();
        tabla = new DefaultTableModel(); 
        tabla.addColumn("Nombre");
        tabla.addColumn("Curso");
        tabla.addColumn("Obervacion");
        tabla.addColumn("Faltas");
        tabla.addColumn("Promedio B1");
        tabla.addColumn("Promedio B2");
        tabla.addColumn("Promedio B3");
        tabla.addColumn("Promedio FINAL");
        jtbl_Resumen.setModel(tabla);
// Asegurarse de que mostrarDatos se ejecute en el Event Dispatch Thread después de la inicialización
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                segui.mostrarSeguimiento(tabla);
                //segui.cargarDatosEnComboBox(jcbxCambioAula);
            }});
        //segui.agregarListenerComboBox(tabla, jcbxCambioAula);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Resumen = new javax.swing.JTable();
        jbl_DatosPersonales1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(203, 247, 247));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbl_Resumen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_Resumen);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 680, 330));

        jbl_DatosPersonales1.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jbl_DatosPersonales1.setText("SEGUIMIENTO Y PROMEDIOS");
        jPanel1.add(jbl_DatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 390, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 290, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/seguim.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 80));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbl_DatosPersonales1;
    private javax.swing.JTable jtbl_Resumen;
    // End of variables declaration//GEN-END:variables
}
