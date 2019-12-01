package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import main.modelo.direccion.Posicion;
import main.modelo.juego.Juego;
import main.modelo.unidad.Unidad;

// TODO: esto se va
public class HandlerTablero implements EventHandler<MouseEvent> {
    private static GridPane gridPane;
    private static Unidad unidadElegida;

    static public void setUnidadElegida(Unidad unidad) {
        unidadElegida = unidad;
    }

    static public Unidad getUnidadElegida() {
        return unidadElegida;
    }

    public HandlerTablero(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void handle(MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();
        if (clickedNode != gridPane) {
            Node source = (Node) event.getSource();
            Integer colIndex = gridPane.getColumnIndex(clickedNode);
            Integer rowIndex = gridPane.getRowIndex(clickedNode);
            // TODO: el jugador deberia ser el jugador de turno
            Juego.getInstance().jugadores().get(0)
                    .colocarUnidadEn(unidadElegida,new Posicion(rowIndex,colIndex));
        }
    }

}
