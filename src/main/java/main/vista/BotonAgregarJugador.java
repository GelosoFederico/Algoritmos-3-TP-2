package Main.vista;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BotonAgregarJugador extends VBox {
    public BotonAgregarJugador() {
        super();
        this.getChildren().add(new TextField());
        Button boton = new Button();
        boton.setText("Agregar jugador");
        this.getChildren().add(boton);
    }
}
