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
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aceptarbt;

    @FXML
    private TextField identificaciontxt;

    @FXML
    private TextField usuariotxt;

    @FXML
    void initialize() {

    }

    @FXML
    void loggear(ActionEvent event) throws IOException{
        String nombre = usuariotxt.getText();
        String identificacion = identificaciontxt.getText();

        if((nombre != null && !nombre.isBlank()) && (identificacion != null && !identificacion.isBlank())){
            App.getClub().setAdministrador(new Administrador(nombre, identificacion));
            App.setRoot("principal");
        }else{
            JOptionPane.showMessageDialog(null, "No puede ingresar datos nulos");
        }
    }

}
