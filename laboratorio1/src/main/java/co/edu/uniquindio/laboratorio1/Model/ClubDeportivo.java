package co.edu.uniquindio.laboratorio1.Model;

import co.edu.uniquindio.laboratorio1.Validacion;

import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

public class ClubDeportivo implements GestionGeneral{
    
    private String nombre;
    private Administrador administrador;
    private LinkedList<Deporte> deportes;
    private LinkedList<Entrenador> entrenadores; 
    private LinkedList<Miembro> miembros;
    private LinkedList<SesionEntrenamiento> sesionesEntrenamiento; 
 
    //Constructor.
    public ClubDeportivo(String nombre) {
        this.nombre = nombre;
        this.deportes = new LinkedList<>();
        this.entrenadores = new LinkedList<>();
        this.miembros = new LinkedList<>();
        this.sesionesEntrenamiento = new LinkedList<>();
    }

    //Métodos de agregar.
    public void agregarDeporte(Deporte deporte){
        deportes.add(deporte);
    }

    public void agregarEntrenador(Entrenador entrenador){
        assert buscarEntrenadorPorNombre(entrenador.getNombre()).isPresent(): "El entrenador ya fue registrado.";
        entrenadores.add(entrenador);
    }

    public void agregarMiembro(Miembro miembro){
        assert buscarPersonaPorNombre(miembro.getNombre()).isPresent();
        this.miembros.add(miembro);
    }

    public void agregarSesionEntrenamiento(SesionEntrenamiento sesionEntrenamiento){
        sesionesEntrenamiento.add(sesionEntrenamiento); 
    }

    //Métodos de buscar.
    public Optional<Deporte> buscarDeportePorNombre(String nombre){
        Predicate<Deporte> condicion = deporte -> deporte.getNombre().equals(nombre);
        return deportes.stream().filter(condicion).findAny();
    }

    public Optional<Entrenador> buscarEntrenadorPorNombre(String nombre){
        Predicate<Entrenador> condicion = entrenador -> entrenador.getNombre().equals(nombre);
        return entrenadores.stream().filter(condicion).findAny(); 
    }

     public Optional<Entrenador> buscarEntrenadorPorIdentificacion(String identificacion){
        Predicate<Entrenador> condicion = entrenador -> entrenador.getIdentificacion().equals(identificacion);
        return entrenadores.stream().filter(condicion).findAny(); 
    }

    public Optional<Persona> buscarPersonaPorNombre(String nombre) {
        Predicate<Persona> condicion = persona -> persona.getNombre().equals(nombre);
        var personas = new LinkedList<Persona>(); personas.addAll(miembros); personas.addAll(entrenadores); 
		return personas.stream().filter(condicion).findAny();
	}

    public Optional<Miembro> buscarMiembroPorNombre(String nombre) {
        Predicate<Miembro> condicion = persona -> persona.getNombre().equals(nombre);
        var miembro = new LinkedList<Persona>(); miembro.addAll(miembros); 
		return miembros.stream().filter(condicion).findAny();
	}

    public Optional<SesionEntrenamiento> buscarEntrenamientoPorCodigo(String codigo){
        
		Predicate<SesionEntrenamiento>condicion = sesionesEntrenamiento -> sesionesEntrenamiento.getCodigo().equals(codigo); 
        return sesionesEntrenamiento.stream().filter(condicion).findAny(); 
    }

    //Métodos para asignar.
    public void asignarEntrenadorADeporte(Entrenador entrenador, Deporte deporte){
        
        deporte.agregarEntrenador(entrenador);
        entrenador.setEspecialidad(deporte.getNombre());
    }

    public void asignarMiembroASesion(Miembro miembro, SesionEntrenamiento sesion){
        sesion.asignarMiembro(miembro);
    }

    //Getters 

    public String getNombre() {
        return nombre;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public LinkedList<Deporte> getDeportes() {
        return deportes;
    }

    public LinkedList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public LinkedList<Miembro> getMiembros() {
        return miembros;
    } 

    //Setters

    public void setAdministrador(Administrador admin) {
        this.administrador = admin;
    }

}
