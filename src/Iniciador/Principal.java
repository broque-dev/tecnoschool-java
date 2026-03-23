
package Iniciador;

import Controlador.*;
import DAO.*;
import Vista.*;

public class Principal {
        public static void main(String[] args) {
        V_Login_TecnoSchool vista = new V_Login_TecnoSchool(); // Suponiendo que tienes una clase V_Login_TecnoSchool
        DAO_Login_TecnoSchool daoLogin = new DAO_Login_TecnoSchool(); // Suponiendo que tienes una clase DAO_Login_TecnoSchool
        C_Login_TecnoSchool controlador = new C_Login_TecnoSchool(vista, daoLogin);
        vista.setVisible(true);
}
}