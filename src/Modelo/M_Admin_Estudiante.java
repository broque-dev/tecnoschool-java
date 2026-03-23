
package Modelo;

public class M_Admin_Estudiante {
    private String idEstudiante;
    private String Nombre;
    private String FechaN;
    private String DNI_Estu;
    private String Aula;
    private String Periodo;
    private String Direccion;
    private String Apoderado;
    private String DNI_Apo;
    private String Telefono;
    private String Registro;

    public M_Admin_Estudiante(String idEstudiante, String Nombre, String FechaN, String DNI_Estu, String Aula, String Periodo, String Direccion, String Apoderado, String DNI_Apo, String Telefono, String Registro) {
        this.idEstudiante = idEstudiante;
        this.Nombre = Nombre;
        this.FechaN = FechaN;
        this.DNI_Estu = DNI_Estu;
        this.Aula = Aula;
        this.Periodo = Periodo;
        this.Direccion = Direccion;
        this.Apoderado = Apoderado;
        this.DNI_Apo = DNI_Apo;
        this.Telefono = Telefono;
        this.Registro = Registro;
    }

    public String getIdEstudiante() {return idEstudiante;}

    public void setIdEstudiante(String idEstudiante) {this.idEstudiante = idEstudiante;}

    public String getNombre() {return Nombre;}

    public void setNombre(String Nombre) {this.Nombre = Nombre;}

    public String getFechaN() {return FechaN;}

    public void setFechaN(String FechaN) {this.FechaN = FechaN;}

    public String getDNI_Estu() {return DNI_Estu;}

    public void setDNI_Estu(String DNI_Estu) {this.DNI_Estu = DNI_Estu;}

    public String getAula() {return Aula;}

    public void setAula(String Aula) {this.Aula = Aula;}

    public String getPeriodo() {return Periodo;}

    public void setPeriodo(String Periodo) {this.Periodo = Periodo;}

    public String getDireccion() {return Direccion;}

    public void setDireccion(String Direccion) {this.Direccion = Direccion;}

    public String getApoderado() {return Apoderado;}

    public void setApoderado(String Apoderado) {this.Apoderado = Apoderado;}

    public String getDNI_Apo() {return DNI_Apo;}

    public void setDNI_Apo(String DNI_Apo) {this.DNI_Apo = DNI_Apo;}

    public String getTelefono() {return Telefono;}

    public void setTelefono(String Telefono) {this.Telefono = Telefono;}

    public String getRegistro() {return Registro;}

    public void setRegistro(String Registro) {this.Registro = Registro;}
}
