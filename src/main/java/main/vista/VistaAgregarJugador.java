package main.vista;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaAgregarJugador extends VBox {
    private final Stage stage;

    public VistaAgregarJugador(Stage stage) {
        super();
        this.stage = stage;
    }

    public void dibujarPantalla() {
        main.vista.BotonAgregarJugador botonAgregarJugador = new main.vista.BotonAgregarJugador(this.stage);
        this.getChildren().add(botonAgregarJugador);
        Scene scene = new Scene(this);
        this.stage.setScene(scene);
        this.stage.show();
    }


}
