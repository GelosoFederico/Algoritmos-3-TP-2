package main.vista;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.controlador.HandlerMostrarInfoUnidad;
import main.controlador.HandlerSeleccionarVictima;

import java.util.ArrayList;

public class VistaInformacionUnidad extends Group {
    private final Stage stage;

    public VistaInformacionUnidad(Stage stage) {
        this.stage = stage;
    }

    public void dibujarPantalla() {
        ArrayList<String> informacionDeUnidad = HandlerMostrarInfoUnidad.getInformacionDeUnidad();
        VBox contnedorInfo = new VBox();
        for (String string : informacionDeUnidad) {
            Text info = new Text(string);
            contnedorInfo.getChildren().add(info);
        }
            Scene scene = new Scene(contnedorInfo);
            stage.setTitle("Informacion sobre unidad");
            stage.setScene(scene);
            stage.show();
    }
}
