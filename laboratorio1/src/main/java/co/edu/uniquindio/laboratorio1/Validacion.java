package co.edu.uniquindio.laboratorio1;

import javax.swing.JOptionPane;

public class Validacion {

    // public static void validarCondicion(boolean condicion, String mensaje){
    //     if(!condicion){
    //         JOptionPane.showMessageDialog(null, mensaje);
    //     }
    // }
    public static boolean validarCondicion(boolean condicion, String mensaje){
        try{
            assert condicion;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, mensaje);
        }

        return condicion;
    }
}