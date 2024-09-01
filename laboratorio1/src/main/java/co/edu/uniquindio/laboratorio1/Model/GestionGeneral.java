package co.edu.uniquindio.laboratorio1.Model;

import java.util.Optional;

public interface GestionGeneral {

    public void agregarDeporte(Deporte deporte);
    public void agregarMiembro(Miembro miembro);
    public void agregarSesionEntrenamiento(SesionEntrenamiento sesionEntrenamiento);
    public Optional<Deporte> buscarDeportePorNombre(String nombre);
    public Optional<Miembro> buscarMiembroPorNombre(String nombre);
    public Optional<Persona> buscarPersonaPorNombre(String nombre);
    public Optional<Entrenador> buscarEntrenadorPorNombre(String nombre);
    public Optional<SesionEntrenamiento> buscarEntrenamientoPorCodigo(String codigo);
    public void asignarMiembroASesion(Miembro miembro, SesionEntrenamiento sesion);
    public void asignarEntrenadorADeporte(Entrenador entrenador, Deporte deporte);
}