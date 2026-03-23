
package Modelo;

public class M_DocenteNota {
    private int ID_Nota;
    private String Nombre;
    private String Curso;
    private String Bimestre;
    private double Nota;
    private int ID_Aula;

    public M_DocenteNota(int ID_Nota, String Nombre, String Curso, String Bimestre, double Nota, int ID_Aula) {
        this.ID_Nota = ID_Nota;
        this.Nombre = Nombre;
        this.Curso = Curso;
        this.Bimestre = Bimestre;
        this.Nota = Nota;
        this.ID_Aula = ID_Aula;
    }

    public int getID_Nota() {
        return ID_Nota;
    }

    public void setID_Nota(int ID_Nota) {
        this.ID_Nota = ID_Nota;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public String getBimestre() {
        return Bimestre;
    }

    public void setBimestre(String Bimestre) {
        this.Bimestre = Bimestre;
    }

    public double getNota() {
        return Nota;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }

    public int getID_Aula() {
        return ID_Aula;
    }

    public void setID_Aula(int ID_Aula) {
        this.ID_Aula = ID_Aula;
    }
    
    
}
