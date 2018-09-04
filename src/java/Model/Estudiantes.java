
package Model;


public class Estudiantes {
    private int id_estudiante, codigo_carnet, id_nivel_estudio;
    private String nombres,apellidos,correo;

    public Estudiantes() {
    }

    public Estudiantes(int id_estudiante, String nombres, String apellidos, String correo,  int codigo_carnet, int id_nivel_estudio) {
        this.id_estudiante = id_estudiante;
        this.codigo_carnet = codigo_carnet;
        this.id_nivel_estudio = id_nivel_estudio;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getCodigo_carnet() {
        return codigo_carnet;
    }

    public void setCodigo_carnet(int codigo_carnet) {
        this.codigo_carnet = codigo_carnet;
    }

    public int getId_nivel_estudio() {
        return id_nivel_estudio;
    }

    public void setId_nivel_estudio(int id_nivel_estudio) {
        this.id_nivel_estudio = id_nivel_estudio;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

   
    
    
}
