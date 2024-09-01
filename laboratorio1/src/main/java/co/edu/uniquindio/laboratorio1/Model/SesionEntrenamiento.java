package co.edu.uniquindio.laboratorio1.Model;

import co.edu.uniquindio.laboratorio1.Validacion;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class SesionEntrenamiento {

    private String codigo;
    private LocalDateTime fechaYHora;
    private Duration duracion;
    private boolean completada;
    private Entrenador entrenador;
    private Deporte deporte;
    private LinkedList<Miembro> miembros;

    public SesionEntrenamiento(String codigo, LocalDateTime fechaYHora, Duration duracion, Entrenador entrenador, Deporte deporte){
        Validacion.validarCondicion(codigo != null && !codigo.isBlank(), "No se pueden ingresar datos nulos.");
        Validacion.validarCondicion(fechaYHora != null, "No se pueden ingresar datos nulos.");
        Validacion.validarCondicion(duracion != null, "No se pueden ingresar datos nulos.");
        Validacion.validarCondicion(entrenador != null, "No se pueden ingresar datos nulos."); 
        Validacion.validarCondicion(deporte != null, "No se pueden ingresar datos nulos.");

        this.codigo = codigo;
        this.fechaYHora = fechaYHora;
        this.duracion = duracion;
        this.entrenador = entrenador;
        this.completada = false;
        this.deporte = deporte;
        this.miembros = new LinkedList<>();

        entrenador.agregarSesionEntrenamiento(this);

    }

    public void asignarMiembro(Miembro miembro){
        assert miembro != null;
        miembros.add(miembro);
    }

    public String getCodigo(){
        return codigo;
    }
    public Duration getDuracion(){
        return duracion;
    }
    public LocalDateTime getFechaYHora(){
        return fechaYHora;
    }
    public boolean getCompletada(){
        return completada;
    }
    public Entrenador getEntrenador(){
        return entrenador; 		
	}
    public Deporte getDeporte(){
        return deporte;
    }
    public LinkedList<Miembro> getMiembros() {
        return miembros;
    }
    public void setDuracion(Duration duracion){
        this.duracion = duracion;
    }
    public void setFechaYHora(LocalDateTime fechaYHora){
        this.fechaYHora = fechaYHora;
    }
    public void completar(){
        this.completada = LocalDateTime.now().isBefore(fechaYHora);
    }

}
