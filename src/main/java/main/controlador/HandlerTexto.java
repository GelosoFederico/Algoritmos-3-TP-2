package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HandlerTexto implements EventHandler<KeyEvent> {
    Button boton;

    public HandlerTexto(Button boton){
        super();
        this.boton = boton;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            this.boton.fire();
        }
    }
}
