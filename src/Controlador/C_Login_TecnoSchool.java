package Controlador;

import DAO.DAO_Login_TecnoSchool;
import Modelo.M_Login_TecnoSchool;
import Vista.V_Login_TecnoSchool;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class C_Login_TecnoSchool implements ActionListener, MouseListener {
    private Propiedades propiedades;
    private V_Login_TecnoSchool vista;
    private DAO_Login_TecnoSchool controladorLogin;

    public C_Login_TecnoSchool(V_Login_TecnoSchool vista, DAO_Login_TecnoSchool controladorLogin) {
        this.vista = vista;
        this.controladorLogin = controladorLogin;

        this.vista.btnEntrar.addActionListener(this);
        this.vista.jcbx_MostrarContra.addActionListener(this);

        this.vista.Jtxt_Usuario.addMouseListener(this);
        this.vista.Jtxt_Contraseña.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.propiedades = new Propiedades();
        if (e.getSource() == vista.btnEntrar) {
            String usuario = vista.Jtxt_Usuario.getText();
            String contraseña = new String(vista.Jtxt_Contraseña.getPassword());
            M_Login_TecnoSchool credenciales = new M_Login_TecnoSchool(usuario, contraseña);

            if (controladorLogin.validarusuario(credenciales)) {
                // Guardar usuario y contraseña en DatosCompartidos
                DatosCompartidos.setUsuario(usuario);
                DatosCompartidos.setContraseña(contraseña);
                
                vista.dispose();
                System.out.println("Usuario validado");
            } else {
                this.propiedades.mostrarMensajeError("Usuario o contraseña incorrectos", "/imagenes/emojiTriste.png", "ALERTA");
            }
        } else if (e.getSource() == vista.jcbx_MostrarContra) {
            char echoChar = vista.jcbx_MostrarContra.isSelected() ? '\u0000' : '*';
            vista.Jtxt_Contraseña.setEchoChar(echoChar);
        }}
    
        
    public class DatosCompartidos {
    private static String contraseña;
    private static String usuario;

    public static String getContraseña() {return contraseña;}
    public static String getUsuario() {return usuario;}
    public static void setContraseña(String nuevaContraseña) {contraseña = nuevaContraseña;}
    public static void setUsuario(String nuevoUsuario) {usuario = nuevoUsuario; }}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == vista.Jtxt_Usuario) {
            if (vista.Jtxt_Usuario.getText().equals("Ingrese su nombre de usuario")) {
                vista.Jtxt_Usuario.setText("");
                vista.Jtxt_Usuario.setForeground(Color.black);
            }
            if (String.valueOf(vista.Jtxt_Contraseña.getPassword()).isEmpty()) {
                vista.Jtxt_Contraseña.setText("********");
                vista.Jtxt_Contraseña.setForeground(Color.lightGray);
            }
        } else if (e.getSource() == vista.Jtxt_Contraseña) {
            if (String.valueOf(vista.Jtxt_Contraseña.getPassword()).equals("********")) {
                vista.Jtxt_Contraseña.setText("");
                vista.Jtxt_Contraseña.setForeground(Color.black);
            }
            if (vista.Jtxt_Usuario.getText().isEmpty()) {
                vista.Jtxt_Usuario.setText("Ingrese su nombre de usuario");
                vista.Jtxt_Usuario.setForeground(Color.lightGray);
            }}}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
