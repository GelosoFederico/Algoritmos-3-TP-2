package main.vista;

import main.controlador.HandlerAgregarJugador;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonAgregarJugador extends VBox {

    public BotonAgregarJugador(Stage stage) {
        super();
        TextField texto = new TextField();
        this.getChildren().add(texto);
        Button boton = new Button();
        boton.setOnAction(new HandlerAgregarJugador(texto, stage));
        boton.setText("Agregar jugador");
        this.getChildren().add(boton);
    }
}
