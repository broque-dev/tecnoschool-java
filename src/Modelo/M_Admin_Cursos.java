
package Modelo;

public class M_Admin_Cursos {
    private String ID;
    private String Curso;
    private String Descripción;

    public M_Admin_Cursos(String ID, String Curso, String Descripción) {
        this.ID = ID;
        this.Curso = Curso;
        this.Descripción = Descripción;
    }

    public String getID() {return ID;}

    public void setID(String ID) {this.ID = ID;}

    public String getCurso() {return Curso;}

    public void setCurso(String Curso) {this.Curso = Curso;}

    public String getDescripción() {return Descripción;}

    public void setDescripción(String Descripción) {this.Descripción = Descripción;}
}
