package co.edu.uniquindio.laboratorio1.Controller;

import co.edu.uniquindio.laboratorio1.App;
import co.edu.uniquindio.laboratorio1.Model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AgregarMiembroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> TipoMiembroChoice;

    private String[] tipoMiembro = {"JOVEN", "ADULTO"};

    @FXML
    private Button aceptarBt;

    @FXML
    private TextField correotxt;

    @FXML
    private TextField deportetxt;

    @FXML
    private TextField identificaciontxt;

    @FXML
    private TextField nombretxt;

    @FXML
    private Button volverAPrincipal;

    @FXML
    void regristrarMiembro(ActionEvent event) {

    }

    @FXML
    void initialize() {
        TipoMiembroChoice.getItems().addAll(tipoMiembro);
    }

    @FXML
    void volverAPrincipal(ActionEvent event) throws IOException{
        App.setRoot("principal");
    }
    
    @FXML
    void registrarMiembro(ActionEvent event) throws IOException{
        String nombre = nombretxt.getText();
        String identificacion = identificaciontxt.getText();
        String correo = correotxt.getText();
        Deporte deporte = registrarDeporte(deportetxt.getText());
        TipoMiembro tipoMiembro = registrarTipoMiembro(TipoMiembroChoice.getValue());
        
        if((nombre != null && !nombre.isBlank()) && (identificacion != null && !identificacion.isBlank()) &&
        (deporte != null) && (tipoMiembro != null)){

            if((tipoMiembro == TipoMiembro.JOVEN) && (deporte.getDificultad() == Dificultad.ALTO)){
                JOptionPane.showMessageDialog(null, "Los miembros jóvenes no pueden inscribirse en un deporte con dificultad alta");
            }else{

                App.getClub().agregarMiembro(new Miembro(nombre, identificacion, correo, tipoMiembro, deporte)); 
                validarRegistro(nombre); 
                nombretxt.setText(""); identificaciontxt.setText(""); correotxt.setText(""); deportetxt.setText("");
            } 
        }else{
            JOptionPane.showMessageDialog(null, "Los datos no pueden ser nulos.");
        }
    }

    private void validarRegistro(String nombre) {
        if(App.getClub().buscarPersonaPorNombre(nombre).isPresent()){
            JOptionPane.showMessageDialog(null, "El registro fue satisfactorio.");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un error con el registro. Intente nuevamente.");
        }
	}

     private TipoMiembro registrarTipoMiembro(String tipo) {

        TipoMiembro tipoMiembro = null;

        if(tipo != null){

            switch (tipo){
            case "JOVEN":
                tipoMiembro = TipoMiembro.JOVEN;
                break;
            case "ADULTO":
                tipoMiembro = TipoMiembro.ADULTO;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error inesperado.");
            }
        }

        return tipoMiembro;
    }

    private Deporte registrarDeporte(String nombre) {
        
        Deporte deporte = null; var resultadoBusqueda = App.getClub().buscarDeportePorNombre(deportetxt.getText());
        
        if(resultadoBusqueda.isPresent()){
            deporte = resultadoBusqueda.get();
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el deporte.");
        }

        return deporte;
    }
}



       

