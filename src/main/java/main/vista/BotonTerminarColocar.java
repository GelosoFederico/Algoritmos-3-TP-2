package main.vista;

import javafx.scene.control.Button;
import main.controlador.HandlerElegirSoldado;
import main.controlador.HandlerTerminarDeColocar;

public class BotonTerminarColocar extends Button {
    public BotonTerminarColocar() {
        super();
        this.setText("Terminar de colocar");
        this.setMinHeight(20);
        this.setOnAction(new HandlerTerminarDeColocar());
    }
}
