package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import main.modelo.unidad.Unidad;
import main.vista.DiccionarioImagenes;

public class HandlerColocarUnidad implements EventHandler<MouseEvent> {
    private static Unidad unidadElegida;
    private DiccionarioImagenes dicc = new DiccionarioImagenes();
    private StackPane stackPane;

    static public void setUnidadElegida(Unidad unidad) {
        unidadElegida = unidad;
    }

    public HandlerColocarUnidad(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    public void handle(MouseEvent event) {
        // TODO: pedir al modelo coloca la pieza
        stackPane.getChildren().add(dicc.get("soldado"));
    }
}
