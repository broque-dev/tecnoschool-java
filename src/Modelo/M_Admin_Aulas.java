
package Modelo;

public class M_Admin_Aulas {
    private String idAula;
    private String Grado;
    private String Seccion;
    private String Horas;
    private String disponible;

    public M_Admin_Aulas(String idAula, String Grado, String Seccion, String Horas, String disponible) {
        this.idAula = idAula;
        this.Grado = Grado;
        this.Seccion = Seccion;
        this.Horas = Horas;
        this.disponible = disponible;}

    public String getIdAula() {return idAula;}

    public void setIdAula(String idAula) {this.idAula = idAula;}

    public String getGrado() {return Grado;}

    public void setGrado(String Grado) {this.Grado = Grado;}

    public String getSeccion() {return Seccion;}

    public void setSeccion(String Seccion) {this.Seccion = Seccion;}

    public String getHoras() {return Horas;}

    public void setHoras(String Horas) {this.Horas = Horas;}

    public String getDisponible() {return disponible;}

    public void setDisponible(String disponible) {this.disponible = disponible;}
}
