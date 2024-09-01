package co.edu.uniquindio.laboratorio1.Model;

public abstract class Persona {
    protected String nombre;
    protected String identificacion;

    public Persona(String nombre, String identificacion){
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre(){
        return nombre;
    }

    public String getIdentificacion(){
        return identificacion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion){
        this.identificacion = identificacion;
    }
}
