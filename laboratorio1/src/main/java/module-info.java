module co.edu.uniquindio.laboratorio1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;

    opens co.edu.uniquindio.laboratorio1 to javafx.fxml;
    exports co.edu.uniquindio.laboratorio1;
    opens co.edu.uniquindio.laboratorio1.Controller to javafx.fxml;
    exports co.edu.uniquindio.laboratorio1.Controller;
    opens co.edu.uniquindio.laboratorio1.Model to javafx.fxml;
    exports co.edu.uniquindio.laboratorio1.Model;

}
