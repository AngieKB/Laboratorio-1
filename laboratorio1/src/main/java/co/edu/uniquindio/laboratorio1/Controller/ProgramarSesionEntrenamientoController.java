package co.edu.uniquindio.laboratorio1.Controller;

import co.edu.uniquindio.laboratorio1.App;
import co.edu.uniquindio.laboratorio1.Model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ProgramarSesionEntrenamientoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aceptarbt;

    @FXML
    private TextField codigotxt;

    @FXML
    private TextField deportetxt;

    @FXML
    private TextField duraciontxt;

    @FXML
    private DatePicker fechapicker;

    @FXML
    private TextField horatxt;

    @FXML
    private TextField nombreentrenadortxt;

    @FXML
    private Button volverbt;

    @FXML
    void cambiarPrincipal(ActionEvent event) throws IOException{
        App.setRoot("principal");
    }

    @FXML
    void initialize() {
        fechapicker.setValue(LocalDate.now());
    }

    @FXML
    void programarSesion(ActionEvent event) throws IOException{
        String codigo = codigotxt.getText();
        LocalDate fecha = fechapicker.getValue(); LocalTime hora = LocalTime.parse(horatxt.getText());
        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        Duration duracion = Duration.ofMinutes(Long.parseLong(duraciontxt.getText()));
        String entrenadorNombre = nombreentrenadortxt.getText();
        String deporteNombre = deportetxt.getText();

        if((codigo != null && !codigo.isBlank()) && (fecha != null) && (hora != null) && (duracion != null)
        && (entrenadorNombre != null && !entrenadorNombre.isBlank()) && (deporteNombre != null && !deporteNombre.isBlank())){

            Entrenador entrenador = registrarEntrenador(entrenadorNombre.toLowerCase());
            Deporte deporte = registrarDeporte(deporteNombre.toLowerCase());
            if((entrenador != null) && (deporte != null)){

                if(!App.getClub().buscarEntrenamientoPorCodigo(codigo).isPresent()){
                
                    if(!(buscarMismaFechaYHora(entrenador, fechaYHora).isPresent())){
                        App.getClub().agregarSesionEntrenamiento(new SesionEntrenamiento(codigo, fechaYHora, duracion, entrenador, deporte));
                        validarRegistro(codigo);
                        codigotxt.setText(""); fechapicker.setValue(LocalDate.now()); horatxt.setText(""); duraciontxt.setText(""); nombreentrenadortxt.setText(""); deportetxt.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se puede registrar a esta hora, ya hay una pendiente.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El código de la sesión ya está siendo usado.");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se pueden ingresar datos nulos.");
        }
    }

    private Optional<SesionEntrenamiento> buscarMismaFechaYHora(Entrenador entrenador, LocalDateTime fechaYHora) {
        Predicate<SesionEntrenamiento> condicion = sesion -> sesion.getFechaYHora().equals(fechaYHora);
        return entrenador.getSesionesEntrenamientos().stream().filter(condicion).findAny();
    }

    private Entrenador registrarEntrenador(String nombre) {
        
        Entrenador entrenador = null; var resultadoBusqueda = App.getClub().buscarEntrenadorPorNombre(nombre);
        
        if(nombre != null && !nombre.isBlank()) {
        
             if(resultadoBusqueda.isPresent()){
            entrenador = resultadoBusqueda.get();
            }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el entrenador.");
             }
             
        }else{
            JOptionPane.showMessageDialog(null, "No se pueden ingresar datos nulos");
        }

        return entrenador;
    }

    private Deporte registrarDeporte(String nombre) {
        
        Deporte deporte = null; var resultadoBusqueda = App.getClub().buscarDeportePorNombre(nombre);

        if(nombre != null && !nombre.isBlank()){
        
            if(resultadoBusqueda.isPresent()){
                deporte = resultadoBusqueda.get();
            }else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado el deporte.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se pueden ingresar datos nulos");
        }

        return deporte;
    }

    private void validarRegistro(String codigo) {
        if(App.getClub().buscarEntrenamientoPorCodigo(codigo).isPresent()){
            JOptionPane.showMessageDialog(null, "El registro fue exitoso.");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un error con el registro. Intente nuevamente."); 
        }
    }
}
