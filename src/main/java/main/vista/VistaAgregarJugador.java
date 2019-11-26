package Main.vista;

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
        Main.vista.BotonAgregarJugador botonAgregarJugador = new Main.vista.BotonAgregarJugador(this.stage);
        this.getChildren().add(botonAgregarJugador);
        Scene scene = new Scene(this);
        this.stage.setScene(scene);
        this.stage.show();
    }


}
