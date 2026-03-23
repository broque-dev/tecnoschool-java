
package Modelo;

public class M_Docente_Asistencia {
    private String ID;
    private String Nombre;
    private String Perioso;
    private String Estado;
    private String Fecha;

    public M_Docente_Asistencia(String ID, String Nombre, String Perioso, String Estado, String Fecha) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Perioso = Perioso;
        this.Estado = Estado;
        this.Fecha = Fecha;}

    public String getID() {return ID;}

    public void setID(String ID) {this.ID = ID;}

    public String getNombre() {return Nombre;}

    public void setNombre(String Nombre) {this.Nombre = Nombre;}

    public String getPerioso() {return Perioso;}

    public void setPerioso(String Perioso) {this.Perioso = Perioso;}

    public String getEstado() {return Estado;}

    public void setEstado(String Estado) {this.Estado = Estado;}

    public String getFecha() {return Fecha;}

    public void setFecha(String Fecha) {this.Fecha = Fecha;}
}
