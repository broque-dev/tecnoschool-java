
package Vista;
import Controlador.Botones_OFF;
import Controlador.C_Admin_Docente;
import Controlador.Slide;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class V_Admin_Docente extends javax.swing.JPanel {
    private C_Admin_Docente AdminDocen;
    private DefaultTableModel tabla;
    Slide sslide;
    Botones_OFF botonesOff = new Botones_OFF();
    Color habilitadoColor = new Color(215,170,123);

    public V_Admin_Docente() {
        initComponents();
        this.AdminDocen = new Controlador.C_Admin_Docente();
        sslide = new Slide();
        AdminDocen.cargarDatosEnComboBox(jcbx_AulaDocente);
        tabla = new DefaultTableModel(); 
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        tabla.addColumn("Telefono");
        tabla.addColumn("DNI");
        tabla.addColumn("Direccion");
        tabla.addColumn("Nacimiento");
        tabla.addColumn("Aula");
        tabla.addColumn("Usuario");
        tabla.addColumn("Contraseña");
        jtbl_ResumenDocentes.setModel(tabla);
        AdminDocen.mostrarDocentes(tabla);
        botonesOff.deshabilitarJPlabel(JL_EditarDocente, JP_EditarDocente);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbl_DatosDocente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JP_EditarDocente = new javax.swing.JPanel();
        JL_EditarDocente = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        JL_BorrarDocente = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        JL_ConsultarDocente = new javax.swing.JLabel();
        JP_RegistrarDocente = new javax.swing.JPanel();
        JL_RegistrarDocente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_ResumenDocentes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxt_NombreDocente = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jtxt_TelefonoDocente = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jtxt_DNIDocente = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jcbx_AulaDocente = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbl_DatosPersonales = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jtxt_UsuarioDocente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jtxt_AgregarContraseña = new javax.swing.JPasswordField();
        jcbx_MostrarContraAdmin = new javax.swing.JCheckBox();
        jbl_DatosPersonales1 = new javax.swing.JLabel();
        jDateFechaN = new com.toedter.calendar.JDateChooser();
        jtxt_DireccionDocente = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbl_DatosDocente.setBackground(new java.awt.Color(196, 162, 55));
        jtbl_DatosDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("<");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jtbl_DatosDocente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 190, 20, 40));

        JP_EditarDocente.setBackground(new java.awt.Color(215, 170, 123));

        JL_EditarDocente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_EditarDocente.setForeground(new java.awt.Color(102, 87, 0));
        JL_EditarDocente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_EditarDocente.setText("EDITAR");
        JL_EditarDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_EditarDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_EditarDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_EditarDocenteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EditarDocenteLayout = new javax.swing.GroupLayout(JP_EditarDocente);
        JP_EditarDocente.setLayout(JP_EditarDocenteLayout);
        JP_EditarDocenteLayout.setHorizontalGroup(
            JP_EditarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarDocenteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_EditarDocenteLayout.setVerticalGroup(
            JP_EditarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarDocenteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbl_DatosDocente.add(JP_EditarDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, 50));

        jPanel4.setBackground(new java.awt.Color(215, 170, 123));

        JL_BorrarDocente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_BorrarDocente.setForeground(new java.awt.Color(102, 87, 0));
        JL_BorrarDocente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_BorrarDocente.setText("BORRAR");
        JL_BorrarDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_BorrarDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_BorrarDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_BorrarDocenteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_BorrarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_BorrarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbl_DatosDocente.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        jPanel5.setBackground(new java.awt.Color(215, 170, 123));

        JL_ConsultarDocente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_ConsultarDocente.setForeground(new java.awt.Color(102, 87, 0));
        JL_ConsultarDocente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_ConsultarDocente.setText("CONSULTAR");
        JL_ConsultarDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_ConsultarDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_ConsultarDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_ConsultarDocenteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbl_DatosDocente.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 140, 50));

        JP_RegistrarDocente.setBackground(new java.awt.Color(215, 170, 123));

        JL_RegistrarDocente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_RegistrarDocente.setForeground(new java.awt.Color(102, 87, 0));
        JL_RegistrarDocente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_RegistrarDocente.setText("REGITRAR");
        JL_RegistrarDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_RegistrarDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_RegistrarDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_RegistrarDocenteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_RegistrarDocenteLayout = new javax.swing.GroupLayout(JP_RegistrarDocente);
        JP_RegistrarDocente.setLayout(JP_RegistrarDocenteLayout);
        JP_RegistrarDocenteLayout.setHorizontalGroup(
            JP_RegistrarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarDocenteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_RegistrarDocenteLayout.setVerticalGroup(
            JP_RegistrarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarDocenteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbl_DatosDocente.add(JP_RegistrarDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        jtbl_ResumenDocentes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_ResumenDocentes);

        jtbl_DatosDocente.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 20, 650, 350));

        add(jtbl_DatosDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 730, 460));

        jPanel1.setBackground(new java.awt.Color(229, 200, 170));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("FECHA DE NACIMIENTO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 190, -1));

        jtxt_NombreDocente.setBackground(new java.awt.Color(229, 200, 170));
        jtxt_NombreDocente.setBorder(null);
        jPanel1.add(jtxt_NombreDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 210, 40));

        jSeparator4.setBackground(new java.awt.Color(229, 200, 170));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 210, 10));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("AULA:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 120, -1));

        jtxt_TelefonoDocente.setBackground(new java.awt.Color(229, 200, 170));
        jtxt_TelefonoDocente.setBorder(null);
        jPanel1.add(jtxt_TelefonoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 210, 40));

        jSeparator5.setBackground(new java.awt.Color(229, 200, 170));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 10));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("DNI:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 120, -1));

        jtxt_DNIDocente.setBackground(new java.awt.Color(229, 200, 170));
        jtxt_DNIDocente.setBorder(null);
        jPanel1.add(jtxt_DNIDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 210, 40));

        jSeparator6.setBackground(new java.awt.Color(229, 200, 170));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 210, 10));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("DIRECCION:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 120, -1));

        jSeparator7.setBackground(new java.awt.Color(229, 200, 170));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 210, 10));

        jcbx_AulaDocente.setBackground(new java.awt.Color(229, 200, 170));
        jcbx_AulaDocente.setBorder(null);
        jPanel1.add(jcbx_AulaDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("APELLIDOS Y NOMBRES:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 180, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 290, 90));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("TELEFONO:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 120, -1));

        jPanel2.setBackground(new java.awt.Color(215, 170, 123));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbl_DatosPersonales.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbl_DatosPersonales.setText("DATOS DE ACCESO");
        jPanel2.add(jbl_DatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 240, 60));

        jSeparator8.setBackground(new java.awt.Color(215, 170, 123));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 10));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 10));

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 10));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 10));

        jtxt_UsuarioDocente.setBackground(new java.awt.Color(215, 170, 123));
        jtxt_UsuarioDocente.setBorder(null);
        jPanel2.add(jtxt_UsuarioDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 40));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("USUARIO:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, -1));

        jSeparator12.setBackground(new java.awt.Color(215, 170, 123));
        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, 10));

        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, 10));

        jSeparator14.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, 10));

        jSeparator15.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, 10));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("CONTRASEÑA:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, -1));

        jtxt_AgregarContraseña.setBackground(new java.awt.Color(215, 170, 123));
        jtxt_AgregarContraseña.setBorder(null);
        jtxt_AgregarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_AgregarContraseñaActionPerformed(evt);
            }
        });
        jPanel2.add(jtxt_AgregarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, 40));

        jcbx_MostrarContraAdmin.setBackground(new java.awt.Color(215, 170, 123));
        jcbx_MostrarContraAdmin.setText("Mostrar");
        jcbx_MostrarContraAdmin.setBorder(null);
        jcbx_MostrarContraAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbx_MostrarContraAdminActionPerformed(evt);
            }
        });
        jPanel2.add(jcbx_MostrarContraAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 380, 210));

        jbl_DatosPersonales1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbl_DatosPersonales1.setText("DATOS PERSONALES");
        jPanel1.add(jbl_DatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 280, 60));

        jDateFechaN.setBackground(new java.awt.Color(229, 200, 170));
        jPanel1.add(jDateFechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 210, 40));

        jtxt_DireccionDocente.setBackground(new java.awt.Color(229, 200, 170));
        jtxt_DireccionDocente.setBorder(null);
        jPanel1.add(jtxt_DireccionDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 210, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       sslide.jPanelXIzquierda(700, 0, 10, 5, jtbl_DatosDocente);
       sslide.jPanelXDerecha(0, 700, 10, 5, jtbl_DatosDocente);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void JL_EditarDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_EditarDocenteMouseClicked
       this.AdminDocen.editarDocente(jtxt_NombreDocente, jtxt_TelefonoDocente, jtxt_DNIDocente, jtxt_DireccionDocente, jtxt_UsuarioDocente, jtxt_AgregarContraseña, jcbx_AulaDocente, jDateFechaN);
       tabla.setRowCount(0);
       AdminDocen.mostrarDocentes(tabla);
       jcbx_AulaDocente.removeAllItems();
       AdminDocen.cargarDatosEnComboBox(jcbx_AulaDocente);
       limpiar();
       botonesOff.habilitarJPlabel(JL_RegistrarDocente, JP_RegistrarDocente, habilitadoColor);
       botonesOff.deshabilitarJPlabel(JL_EditarDocente, JP_EditarDocente);
    }//GEN-LAST:event_JL_EditarDocenteMouseClicked

    private void JL_BorrarDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_BorrarDocenteMouseClicked
       this.AdminDocen.eliminarDocente();
       tabla.setRowCount(0);
       AdminDocen.mostrarDocentes(tabla);
       jcbx_AulaDocente.removeAllItems();
       AdminDocen.cargarDatosEnComboBox(jcbx_AulaDocente);
    }//GEN-LAST:event_JL_BorrarDocenteMouseClicked

    private void JL_ConsultarDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_ConsultarDocenteMouseClicked
       this.AdminDocen.consultarDNI(tabla, jtxt_NombreDocente, jtxt_TelefonoDocente, jtxt_DNIDocente, jtxt_DireccionDocente, jtxt_UsuarioDocente, jtxt_AgregarContraseña, jDateFechaN, jcbx_AulaDocente);
       jtbl_DatosDocente.setBounds(700, 0, 730, 460);
       botonesOff.habilitarJPlabel(JL_EditarDocente, JP_EditarDocente, habilitadoColor);
       botonesOff.deshabilitarJPlabel(JL_RegistrarDocente, JP_RegistrarDocente);
    }//GEN-LAST:event_JL_ConsultarDocenteMouseClicked

    private void JL_RegistrarDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_RegistrarDocenteMouseClicked
       this.AdminDocen.registrarDocente(jtxt_NombreDocente, jtxt_TelefonoDocente, jtxt_DNIDocente, jtxt_DireccionDocente, jtxt_UsuarioDocente, jtxt_AgregarContraseña, jcbx_AulaDocente, jDateFechaN);
       jtbl_DatosDocente.setBounds(700, 0, 730, 460);
       tabla.setRowCount(0);
       AdminDocen.mostrarDocentes(tabla);
       jcbx_AulaDocente.removeAllItems();
       AdminDocen.cargarDatosEnComboBox(jcbx_AulaDocente);
       limpiar();
    }//GEN-LAST:event_JL_RegistrarDocenteMouseClicked

    private void jtxt_AgregarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_AgregarContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_AgregarContraseñaActionPerformed

    private void jcbx_MostrarContraAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbx_MostrarContraAdminActionPerformed
        char echoChar = jcbx_MostrarContraAdmin.isSelected() ? '\u0000' : '*';
        jtxt_AgregarContraseña.setEchoChar(echoChar);
    }//GEN-LAST:event_jcbx_MostrarContraAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_BorrarDocente;
    private javax.swing.JLabel JL_ConsultarDocente;
    private javax.swing.JLabel JL_EditarDocente;
    private javax.swing.JLabel JL_RegistrarDocente;
    private javax.swing.JPanel JP_EditarDocente;
    private javax.swing.JPanel JP_RegistrarDocente;
    private com.toedter.calendar.JDateChooser jDateFechaN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel jbl_DatosPersonales;
    private javax.swing.JLabel jbl_DatosPersonales1;
    private javax.swing.JComboBox<String> jcbx_AulaDocente;
    private javax.swing.JCheckBox jcbx_MostrarContraAdmin;
    private javax.swing.JPanel jtbl_DatosDocente;
    private javax.swing.JTable jtbl_ResumenDocentes;
    private javax.swing.JPasswordField jtxt_AgregarContraseña;
    private javax.swing.JTextField jtxt_DNIDocente;
    private javax.swing.JTextField jtxt_DireccionDocente;
    private javax.swing.JTextField jtxt_NombreDocente;
    private javax.swing.JTextField jtxt_TelefonoDocente;
    private javax.swing.JTextField jtxt_UsuarioDocente;
    // End of variables declaration//GEN-END:variables
        public void limpiar(){
        jtxt_NombreDocente.setText("");
        jtxt_TelefonoDocente.setText("");
        jtxt_DNIDocente.setText("");
        jtxt_DireccionDocente.setText("");
        jtxt_UsuarioDocente.setText("");
        jtxt_AgregarContraseña.setText("");
    }
}
