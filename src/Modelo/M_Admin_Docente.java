
package Modelo;

public class M_Admin_Docente {
    private String idDocente;
    private String nombre;
    private String telefono;
    private String DNI;
    private String Direccion;
    private String Nacimiento;
    private String Aula;
    private String Usuario;
    private String Contraseña;

    public M_Admin_Docente(String idDocente, String nombre, String telefono, String DNI, String Direccion, String Nacimiento, String Aula, String Usuario, String Contraseña) {
        this.idDocente = idDocente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.DNI = DNI;
        this.Direccion = Direccion;
        this.Nacimiento = Nacimiento;
        this.Aula = Aula;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;}

    public String getIdDocente() {return idDocente;}

    public void setIdDocente(String idDocente) {this.idDocente = idDocente;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getDNI() {return DNI;}

    public void setDNI(String DNI) {this.DNI = DNI;}

    public String getDireccion() {return Direccion;}

    public void setDireccion(String Direccion) {this.Direccion = Direccion;}

    public String getNacimiento() {return Nacimiento;}

    public void setNacimiento(String Nacimiento) {this.Nacimiento = Nacimiento;}

    public String getAula() {return Aula;}

    public void setAula(String Aula) {this.Aula = Aula;}

    public String getUsuario() {return Usuario;}

    public void setUsuario(String Usuario) {this.Usuario = Usuario;}

    public String getContraseña() {return Contraseña;}

    public void setContraseña(String Contraseña) {this.Contraseña = Contraseña;} 
}
