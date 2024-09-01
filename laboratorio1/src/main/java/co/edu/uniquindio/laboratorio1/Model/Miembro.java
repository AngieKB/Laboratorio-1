package co.edu.uniquindio.laboratorio1.Model;

public class Miembro extends Persona {
    private String correo;
    private TipoMiembro tipoMiembro;
    private final Deporte deporte;

    public Miembro (String nombre, String identificacion, String correo, TipoMiembro tipoMiembro, Deporte deporte){
        super(nombre, identificacion);
    
        this.correo = correo;
        this.tipoMiembro = tipoMiembro;
        this.deporte = deporte;
    }

    public String getCorreo(){
        return correo;
    }

    public TipoMiembro getTipoMiembro(){
        return tipoMiembro;
    }

    public Deporte getDeporte(){
        return deporte;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    } 
}