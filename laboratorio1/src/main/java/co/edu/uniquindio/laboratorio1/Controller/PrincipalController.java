package co.edu.uniquindio.laboratorio1.Controller;

import co.edu.uniquindio.laboratorio1.Model.*;

import java.io.IOException;
import co.edu.uniquindio.laboratorio1.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

public class PrincipalController {

    @FXML
    private Button aceptarentrenadorbt;

    @FXML
    private Button aceptarmiembrobt;

    @FXML
    private TextField codigosesiontxt;

    @FXML
    private TextField nombredeportetxt;

    @FXML
    private TextField nombreentrenadortxt;

    @FXML
    private TextField nombremiembrotxt;

    @FXML
    private Button programarsesionbt;

    @FXML
    private Button registrardeportebt;

    @FXML
    private Button registrarentrenadorbt;

    @FXML
    private Button registrarmiembrobt;

    @FXML
    private Button volverbt;

    
    @FXML
    void cambiarLogIn(ActionEvent event) throws IOException {
      App.setRoot("login");
    }

    @FXML
    void cambiarAgregarMiembro(ActionEvent event) throws IOException {
      App.setRoot("agregarMiembro");
    }

    @FXML
    void cambiarAgregarEntrenador(ActionEvent event) throws IOException{
        App.setRoot("agregarEntrenador");
    }

    @FXML
    void cambiarProgramarSesionEntrenamiento(ActionEvent event) throws IOException{
        App.setRoot("programarSesionEntrenamiento");
    }

    @FXML
    void cambiarAgregarDeporte(ActionEvent event) throws IOException{
        App.setRoot("agregarDeporte");
    }

    @FXML
    void cambiarLogin(ActionEvent event) throws IOException{
        App.setRoot("login");
    }

    @FXML
    void asignarEntrenadorDeporte(ActionEvent event) {
        Deporte deporte = registrarDeporte(nombredeportetxt.getText()); 
        Entrenador entrenador = registrarEntrenador(nombreentrenadortxt.getText());
    
        if(entrenador != null && deporte != null){
            App.getClub().asignarEntrenadorADeporte(entrenador, deporte);
            validarEntrenadorDeporte(entrenador, deporte);
            nombredeportetxt.setText(""); nombreentrenadortxt.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "No puede ingresar datos nulos.");
        }
        
    }
    
    private void validarEntrenadorDeporte(Entrenador entrenador, Deporte deporte) {
        if(entrenador.getEspecialidad() == deporte.getNombre()){
            JOptionPane.showMessageDialog(null, "La asignación fue exitosa.");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un error con la signación. Intente nuevamente."); 
        }
    }

    private Deporte registrarDeporte(String nombre) {
        
        Deporte deporte = null; var resultadoBusqueda = App.getClub().buscarDeportePorNombre(nombre);
        
        if(resultadoBusqueda.isPresent()){
            deporte = resultadoBusqueda.get();
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el deporte.");
        }

        return deporte;
    }

    private Entrenador registrarEntrenador(String nombre) {
        
        Entrenador entrenador = null; var resultadoBusqueda = App.getClub().buscarEntrenadorPorNombre(nombre);
        
        if(resultadoBusqueda.isPresent()){
            entrenador = resultadoBusqueda.get();
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el entrenador.");
        }

        return entrenador;
    }

    @FXML
    void asignarMiembroSesion(ActionEvent event) {
        Miembro miembro = registrarMiembro(nombremiembrotxt.getText());
        SesionEntrenamiento sesionEntrenamiento = registrarEntrenamiento(codigosesiontxt.getText());

        if((miembro!=null) && (sesionEntrenamiento != null)){

            App.getClub().asignarMiembroASesion(miembro, sesionEntrenamiento);
            validarMiembroSesion(sesionEntrenamiento, miembro);
            nombremiembrotxt.setText(""); codigosesiontxt.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "No puede ingresar datos nulos.");
        }
    }

    private Miembro registrarMiembro(String nombre){
        
        Miembro miembro = null; var resultadoBusqueda = App.getClub().buscarMiembroPorNombre(nombremiembrotxt.getText());
        
        if(resultadoBusqueda.isPresent()){
            miembro = resultadoBusqueda.get();
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el miembro.");
        }
        return miembro;
    }

    private SesionEntrenamiento registrarEntrenamiento(String codigo) {
        
        SesionEntrenamiento sesionEntrenamiento = null; var resultadoBusqueda = App.getClub().buscarEntrenamientoPorCodigo(codigosesiontxt.getText());
        
        if(resultadoBusqueda.isPresent()){
            sesionEntrenamiento = resultadoBusqueda.get();
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el deporte.");
        }
        return sesionEntrenamiento;
    }
    
    private void validarMiembroSesion(SesionEntrenamiento sesionEntrenamiento, Miembro miembro) {
        if(sesionEntrenamiento.getMiembros().contains(miembro)){
            JOptionPane.showMessageDialog(null, "El registro fue satisfactorio.");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un error con el registro. Intente nuevamente.");
        }
	}
}