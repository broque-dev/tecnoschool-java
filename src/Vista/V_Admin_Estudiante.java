
package Vista;
import Controlador.Botones_OFF;
import Controlador.C_Admin_Estudiante;
import Controlador.Slide;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class V_Admin_Estudiante extends javax.swing.JPanel {
    private C_Admin_Estudiante AdminEstu;
    private DefaultTableModel tabla;
    Slide sslide;
    Botones_OFF botonesOff = new Botones_OFF();
    Color habilitadoColor = new Color(102,153,255);

    public V_Admin_Estudiante() {
        initComponents();
        this.AdminEstu = new Controlador.C_Admin_Estudiante();
        sslide = new Slide();
        AdminEstu.cargarDatosEnComboBox(jcbx_AulaEstudiante);
        tabla = new DefaultTableModel(); 
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        tabla.addColumn("Fecha_N");
        tabla.addColumn("DNI_Estu");
        tabla.addColumn("Aula");
        tabla.addColumn("Periodo");
        tabla.addColumn("Direccion");
        tabla.addColumn("Apoderado");
        tabla.addColumn("DNI_Apo");
        tabla.addColumn("Telefono");
        tabla.addColumn("Registro");
        jtbl_ResumenEstudiante.setModel(tabla);
        AdminEstu.mostrarEstudiantes(tabla);
        botonesOff.deshabilitarJPlabel(JL_EditarEstudiante, JP_EditarEstudiante);
    }

//OPCIONES CONSULTAR ESTUDIANTE
public void opcionesConsulta() {
    Object[] opciones = {"DNI", "Año", "Periodo"};
    int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Elige una opción", "CONSULTA", JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE, getIcon("/imagenes/emojiFeliz.png", 50, 50), opciones, opciones[0]);
    switch (opcionSeleccionada) {
        case 0 -> { // DNI
            this.AdminEstu.consultarDNI(tabla, jtxt_NombreEstudiante, jtxt_DNIEstudiante, jtxt_PediodoEstudiante, jtxt_DireccionEstudiante, jtxt_ApoderadoEstudiante, jtxt_DNIApoderado, jtxt_TelefonoApoderado, jtxt_RegistroEstudiante, jDateFechaN, jcbx_AulaEstudiante);
            jtbl_DatosEstudiante.setBounds(700, 0, 730, 460);}
        case 1 -> // Año
            this.AdminEstu.consultarAño(tabla);
        case 2 -> // Periodo
            this.AdminEstu.consultarPeriodo(tabla);
        default -> {
            }}}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbl_DatosEstudiante = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JP_EditarEstudiante = new javax.swing.JPanel();
        JL_EditarEstudiante = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        JL_BorrarEstudiante = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        JL_ConsultarEstudiante = new javax.swing.JLabel();
        JP_RegistrarEstudiante = new javax.swing.JPanel();
        JL_RegistrarEstudiante = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_ResumenEstudiante = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxt_NombreEstudiante = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jtxt_TelefonoApoderado = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jtxt_DNIEstudiante = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jcbx_AulaEstudiante = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jbl_DatosPersonales1 = new javax.swing.JLabel();
        jDateFechaN = new com.toedter.calendar.JDateChooser();
        jtxt_DireccionEstudiante = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtxt_ApoderadoEstudiante = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jtxt_DNIApoderado = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jtxt_PediodoEstudiante = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jtxt_RegistroEstudiante = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbl_DatosEstudiante.setBackground(new java.awt.Color(153, 204, 255));
        jtbl_DatosEstudiante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("<");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jtbl_DatosEstudiante.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 190, 20, 40));

        JP_EditarEstudiante.setBackground(new java.awt.Color(102, 153, 255));

        JL_EditarEstudiante.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_EditarEstudiante.setForeground(new java.awt.Color(102, 255, 255));
        JL_EditarEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_EditarEstudiante.setText("EDITAR");
        JL_EditarEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_EditarEstudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_EditarEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_EditarEstudianteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EditarEstudianteLayout = new javax.swing.GroupLayout(JP_EditarEstudiante);
        JP_EditarEstudiante.setLayout(JP_EditarEstudianteLayout);
        JP_EditarEstudianteLayout.setHorizontalGroup(
            JP_EditarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarEstudianteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_EditarEstudianteLayout.setVerticalGroup(
            JP_EditarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EditarEstudianteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_EditarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbl_DatosEstudiante.add(JP_EditarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, 50));

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));

        JL_BorrarEstudiante.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_BorrarEstudiante.setForeground(new java.awt.Color(102, 255, 255));
        JL_BorrarEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_BorrarEstudiante.setText("BORRAR");
        JL_BorrarEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_BorrarEstudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_BorrarEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_BorrarEstudianteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_BorrarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_BorrarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbl_DatosEstudiante.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));

        JL_ConsultarEstudiante.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_ConsultarEstudiante.setForeground(new java.awt.Color(102, 255, 255));
        JL_ConsultarEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_ConsultarEstudiante.setText("CONSULTAR");
        JL_ConsultarEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_ConsultarEstudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_ConsultarEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_ConsultarEstudianteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_ConsultarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbl_DatosEstudiante.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 140, 50));

        JP_RegistrarEstudiante.setBackground(new java.awt.Color(102, 153, 255));

        JL_RegistrarEstudiante.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JL_RegistrarEstudiante.setForeground(new java.awt.Color(102, 255, 255));
        JL_RegistrarEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_RegistrarEstudiante.setText("REGITRAR");
        JL_RegistrarEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JL_RegistrarEstudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JL_RegistrarEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_RegistrarEstudianteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_RegistrarEstudianteLayout = new javax.swing.GroupLayout(JP_RegistrarEstudiante);
        JP_RegistrarEstudiante.setLayout(JP_RegistrarEstudianteLayout);
        JP_RegistrarEstudianteLayout.setHorizontalGroup(
            JP_RegistrarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarEstudianteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_RegistrarEstudianteLayout.setVerticalGroup(
            JP_RegistrarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_RegistrarEstudianteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JL_RegistrarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbl_DatosEstudiante.add(JP_RegistrarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        jtbl_ResumenEstudiante.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_ResumenEstudiante);

        jtbl_DatosEstudiante.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 20, 650, 350));

        add(jtbl_DatosEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 730, 460));

        jPanel1.setBackground(new java.awt.Color(203, 247, 247));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("FECHA DE NACIMIENTO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 190, -1));

        jtxt_NombreEstudiante.setBackground(new java.awt.Color(203, 247, 247));
        jtxt_NombreEstudiante.setBorder(null);
        jPanel1.add(jtxt_NombreEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 210, 40));

        jSeparator4.setBackground(new java.awt.Color(203, 247, 247));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 210, 10));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("AULA:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 120, -1));

        jtxt_TelefonoApoderado.setBackground(new java.awt.Color(203, 247, 247));
        jtxt_TelefonoApoderado.setBorder(null);
        jPanel1.add(jtxt_TelefonoApoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 210, 40));

        jSeparator5.setBackground(new java.awt.Color(203, 247, 247));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 210, 10));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("DNI ALUMNO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 120, -1));

        jtxt_DNIEstudiante.setBackground(new java.awt.Color(203, 247, 247));
        jtxt_DNIEstudiante.setBorder(null);
        jPanel1.add(jtxt_DNIEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 210, 40));

        jSeparator6.setBackground(new java.awt.Color(203, 247, 247));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 210, 10));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("DIRECCION:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 120, -1));

        jSeparator7.setBackground(new java.awt.Color(203, 247, 247));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 210, 10));

        jcbx_AulaEstudiante.setBackground(new java.awt.Color(203, 247, 247));
        jcbx_AulaEstudiante.setBorder(null);
        jPanel1.add(jcbx_AulaEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("APELLIDOS Y NOMBRES:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 180, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 290, 90));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("TELEFONO APODERADO:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 190, -1));

        jbl_DatosPersonales1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbl_DatosPersonales1.setText("DATOS PERSONALES");
        jPanel1.add(jbl_DatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 280, 60));

        jDateFechaN.setBackground(new java.awt.Color(229, 200, 170));
        jPanel1.add(jDateFechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 210, 40));

        jtxt_DireccionEstudiante.setBackground(new java.awt.Color(203, 247, 247));
        jtxt_DireccionEstudiante.setBorder(null);
        jPanel1.add(jtxt_DireccionEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 210, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("NOMBRE APODERADO:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 180, -1));

        jtxt_ApoderadoEstudiante.setBackground(new java.awt.Color(203, 247, 247));
        jtxt_ApoderadoEstudiante.setBorder(null);
        jPanel1.add(jtxt_ApoderadoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 210, 40));

        jSeparator8.setBackground(new java.awt.Color(203, 247, 247));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 210, 10));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("DNI APODERADO:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 150, -1));

        jtxt_DNIApoderado.setBackground(new java.awt.Color(203, 247, 247));
        jtxt_DNIApoderado.setBorder(null);
        jPanel1.add(jtxt_DNIApoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 210, 40));

        jSeparator9.setBackground(new java.awt.Color(203, 247, 247));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 210, 10));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("PERIODO ESCOLAR:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 190, -1));

        jtxt_PediodoEstudiante.setBackground(new java.awt.Color(203, 247, 247));
        jtxt_PediodoEstudiante.setBorder(null);
        jPanel1.add(jtxt_PediodoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 210, 40));

        jSeparator10.setBackground(new java.awt.Color(203, 247, 247));
        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 210, 10));

        jtxt_RegistroEstudiante.setBackground(new java.awt.Color(203, 247, 247));
        jtxt_RegistroEstudiante.setBorder(null);
        jtxt_RegistroEstudiante.setRequestFocusEnabled(false);
        jPanel1.add(jtxt_RegistroEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 170, 40));

        jSeparator11.setBackground(new java.awt.Color(203, 247, 247));
        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 170, 10));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("REGISTRO:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 140, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estudi.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 130, 130));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        sslide.jPanelXIzquierda(700, 0, 10, 5, jtbl_DatosEstudiante);
        sslide.jPanelXDerecha(0, 700, 10, 5, jtbl_DatosEstudiante);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void JL_EditarEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_EditarEstudianteMouseClicked
       AdminEstu.editarEstudiante(jtxt_NombreEstudiante, jtxt_DNIEstudiante, jtxt_PediodoEstudiante, jtxt_DireccionEstudiante, jtxt_ApoderadoEstudiante, jtxt_DNIApoderado, jtxt_TelefonoApoderado, jcbx_AulaEstudiante, jDateFechaN);
       tabla.setRowCount(0);
       AdminEstu.mostrarEstudiantes(tabla);
       limpiar();
       jtbl_DatosEstudiante.setBounds(700, 0, 730, 460);
       botonesOff.habilitarJPlabel(JL_RegistrarEstudiante, JP_RegistrarEstudiante, habilitadoColor);
       botonesOff.deshabilitarJPlabel(JL_EditarEstudiante, JP_EditarEstudiante);
    }//GEN-LAST:event_JL_EditarEstudianteMouseClicked

    private void JL_BorrarEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_BorrarEstudianteMouseClicked
       this.AdminEstu.eliminarEstudiante();
       tabla.setRowCount(0);
       AdminEstu.mostrarEstudiantes(tabla);
    }//GEN-LAST:event_JL_BorrarEstudianteMouseClicked

    private void JL_ConsultarEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_ConsultarEstudianteMouseClicked
       opcionesConsulta();
       botonesOff.habilitarJPlabel(JL_EditarEstudiante, JP_EditarEstudiante, habilitadoColor);
       botonesOff.deshabilitarJPlabel(JL_RegistrarEstudiante, JP_RegistrarEstudiante);
    }//GEN-LAST:event_JL_ConsultarEstudianteMouseClicked

    private void JL_RegistrarEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_RegistrarEstudianteMouseClicked
       AdminEstu.registrarEstudiante(jtxt_NombreEstudiante, jtxt_DNIEstudiante, jtxt_PediodoEstudiante, jtxt_DireccionEstudiante, jtxt_ApoderadoEstudiante, jtxt_DNIApoderado, jtxt_TelefonoApoderado, jcbx_AulaEstudiante, jDateFechaN);
       jtbl_DatosEstudiante.setBounds(700, 0, 730, 460);
       tabla.setRowCount(0);
       AdminEstu.mostrarEstudiantes(tabla);
    }//GEN-LAST:event_JL_RegistrarEstudianteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_BorrarEstudiante;
    private javax.swing.JLabel JL_ConsultarEstudiante;
    private javax.swing.JLabel JL_EditarEstudiante;
    private javax.swing.JLabel JL_RegistrarEstudiante;
    private javax.swing.JPanel JP_EditarEstudiante;
    private javax.swing.JPanel JP_RegistrarEstudiante;
    private com.toedter.calendar.JDateChooser jDateFechaN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel jbl_DatosPersonales1;
    private javax.swing.JComboBox<String> jcbx_AulaEstudiante;
    private javax.swing.JPanel jtbl_DatosEstudiante;
    private javax.swing.JTable jtbl_ResumenEstudiante;
    private javax.swing.JTextField jtxt_ApoderadoEstudiante;
    private javax.swing.JTextField jtxt_DNIApoderado;
    private javax.swing.JTextField jtxt_DNIEstudiante;
    private javax.swing.JTextField jtxt_DireccionEstudiante;
    private javax.swing.JTextField jtxt_NombreEstudiante;
    private javax.swing.JTextField jtxt_PediodoEstudiante;
    private javax.swing.JTextField jtxt_RegistroEstudiante;
    private javax.swing.JTextField jtxt_TelefonoApoderado;
    // End of variables declaration//GEN-END:variables
    private Icon getIcon(String path, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(path))
                .getImage().getScaledInstance(w, h, 0));
    }
    public void limpiar(){
        jtxt_NombreEstudiante.setText("");
        jtxt_DNIEstudiante.setText("");
        jtxt_PediodoEstudiante.setText("");
        jtxt_DireccionEstudiante.setText("");
        jtxt_ApoderadoEstudiante.setText("");
        jtxt_DNIApoderado.setText("");
        jtxt_TelefonoApoderado.setText("");
        jtxt_RegistroEstudiante.setText("");
    }
}
