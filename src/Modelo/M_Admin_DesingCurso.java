package Modelo;

public class M_Admin_DesingCurso {
    private int ID_DocenteCurso;
    private int ID_Docente;
    private int ID_Curso;

    public M_Admin_DesingCurso(int ID_DocenteCurso, int ID_Docente, int ID_Curso) {
        this.ID_DocenteCurso = ID_DocenteCurso;
        this.ID_Docente = ID_Docente;
        this.ID_Curso = ID_Curso;
    }

    public int getID_DocenteCurso() {return ID_DocenteCurso;}

    public void setID_DocenteCurso(int ID_DocenteCurso) {this.ID_DocenteCurso = ID_DocenteCurso;}

    public int getID_Docente() {return ID_Docente;}

    public void setID_Docente(int ID_Docente) {this.ID_Docente = ID_Docente;}

    public int getID_Curso() {return ID_Curso;}

    public void setID_Curso(int ID_Curso) {this.ID_Curso = ID_Curso;}
}

