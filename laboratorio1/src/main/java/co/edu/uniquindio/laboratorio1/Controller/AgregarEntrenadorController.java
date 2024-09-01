package co.edu.uniquindio.laboratorio1.Controller;

import co.edu.uniquindio.laboratorio1.*;
import co.edu.uniquindio.laboratorio1.Model.*;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AgregarEntrenadorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aceptarbt;

    @FXML
    private TextField identificaciontxt;

    @FXML
    private TextField nombretxt;

    @FXML
    private Button volverbt;

    @FXML
    void initialize() {

    }

    @FXML
    void volverAPrincipal(ActionEvent event) throws IOException{
        App.setRoot("principal");
    }

    @FXML
    void registrarEntrenador(ActionEvent event) throws IOException {
        
        String nombre = nombretxt.getText();
        String identificacion = identificaciontxt.getText();

        if((nombre!=null && !nombre.isBlank()) && (identificacion != null && !identificacion.isBlank())){
            
            App.getClub().agregarEntrenador(new Entrenador(nombre, identificacion));
            validarRegistro(identificacion);
            nombretxt.setText(""); identificaciontxt.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "No se pueden ingresar datos nulos.");
        }
    }

	private void validarRegistro(String identificacion) {
        if(App.getClub().buscarEntrenadorPorIdentificacion(identificacion).isPresent()){
            JOptionPane.showMessageDialog(null, "El registro fue satisfactorio.");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un error con el registro. Intente nuevamente.");
        }
	}

}
