package co.edu.uniquindio.laboratorio1.Controller;

import co.edu.uniquindio.laboratorio1.*;
import co.edu.uniquindio.laboratorio1.Model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AgregarDeporteTController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aceptarbt;

    @FXML
    private TextArea descripciontxt;

    @FXML
    private ChoiceBox<String> dificultadChoice;

    @FXML
    private TextField nombretxt;

    @FXML
    private Button volverbt;

    private String[] dificultad = {"ALTA", "MEDIA", "BAJA"};

    @FXML
    void initialize() {
        dificultadChoice.getItems().addAll(dificultad);
    }

    @FXML
    void registrarDeporte(ActionEvent event) {
        String nombre = nombretxt.getText();
        String descripcion = descripciontxt.getText();
        Dificultad dificultad = registrarDificultad(dificultadChoice.getValue());

        if((nombre != null && !nombre.isBlank()) && (descripcion != null && !descripcion.isBlank()) && (dificultad != null)){

            App.getClub().agregarDeporte(new Deporte(nombre, descripcion, dificultad));
            validarCondicion(nombre);
            nombretxt.setText(""); descripciontxt.setText(""); dificultadChoice.setValue("");
        }else{
            JOptionPane.showMessageDialog(null, "No se pueden ingresar datos nulos.");
        }

    }

	private void validarCondicion(String nombre) {
        if(App.getClub().buscarDeportePorNombre(nombre).isPresent()){
            JOptionPane.showMessageDialog(null, "El registro fue satisfactorio.");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un error con el registro. Intente nuevamente.");
        }
	}

	@FXML
    void volverAPrincipal(ActionEvent event) throws IOException {
        App.setRoot("principal");
    }

    private Dificultad registrarDificultad(String txt) {
        
        Dificultad dificultad = null;

        if(txt != null){

            switch (txt){
                case "ALTA":
                    dificultad = Dificultad.ALTO;
                    break;
                case "MEDIA":
                    dificultad = Dificultad.MEDIO;
                    break;
                case "BAJA":
                    dificultad = Dificultad.BAJO;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error inesperado.");
            }
        }
        
        return dificultad;
	}
}