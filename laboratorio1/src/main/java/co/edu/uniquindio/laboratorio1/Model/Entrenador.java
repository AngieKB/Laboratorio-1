package co.edu.uniquindio.laboratorio1.Model;

import java.util.LinkedList;

public class Entrenador extends Persona {
    private String especialidad;
    private LinkedList<SesionEntrenamiento> sesionesEntrenamiento;

    public Entrenador(String nombre, String identificacion) {
        super(nombre, identificacion);
        
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.sesionesEntrenamiento = new LinkedList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public LinkedList<SesionEntrenamiento> getSesionesEntrenamientos() {
        return sesionesEntrenamiento;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

	public void agregarSesionEntrenamiento(SesionEntrenamiento sesionEntrenamiento) {
        sesionesEntrenamiento.add(sesionEntrenamiento);
	}
}