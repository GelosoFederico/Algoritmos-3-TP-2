package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import main.modelo.unidad.Unidad;
import main.vista.DiccionarioImagenes;
import main.vista.GridPaneTablero;

// TODO: esto vuela
public class HandlerTablero implements EventHandler<MouseEvent> {
    private static GridPaneTablero gridPaneTablero;
    private static Unidad unidadElegida;
    private DiccionarioImagenes diccionarioImagenes = new DiccionarioImagenes();

    static public void setUnidadElegida(Unidad unidad) {
        unidadElegida = unidad;
    }

    public HandlerTablero(GridPaneTablero gridPaneTablero) {
        this.gridPaneTablero = gridPaneTablero;
    }

    public void handle(MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();
        if (clickedNode != gridPaneTablero) {
            Node source = (Node) event.getSource();
            Integer colIndex = gridPaneTablero.getColumnIndex(clickedNode);
            Integer rowIndex = gridPaneTablero.getRowIndex(clickedNode);
            // TODO: el jugador deberia ser el jugador de turno
            //Juego.getInstance().jugadores().get(0)
            //        .colocarUnidadEn(unidadElegida,new Posicion(rowIndex,colIndex));

            StackPane stackPane = gridPaneTablero.getContenidoEn(rowIndex,colIndex);
            stackPane.getChildren().add(diccionarioImagenes.get("soldado"));
        }
    }
}
