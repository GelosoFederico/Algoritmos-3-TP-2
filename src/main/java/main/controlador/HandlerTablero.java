package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class HandlerTablero implements EventHandler<MouseEvent> {
    GridPane gridPane;

    public HandlerTablero(GridPane gridPane) {
        this.gridPane = gridPane;
    }
    public void handle(MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();
        if (clickedNode != gridPane) {
            Node source = (Node) event.getSource();
            Integer colIndex = gridPane.getColumnIndex(source);
            Integer rowIndex = gridPane.getRowIndex(source);
            System.out.println("Mouse clicked cell: " + colIndex + "And: " + rowIndex);
        }
    }
}
