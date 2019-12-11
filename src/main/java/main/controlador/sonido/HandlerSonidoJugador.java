package main.controlador.sonido;

import java.io.File;

public class HandlerSonidoJugador {
    private static HandlerSonido sonidoCreacion =
            new HandlerSonido(new File("src/recursos/sonidos/chat.wav"));

    static public void reproducirSonidoCreacion(){
        sonidoCreacion.reproducirSonido();
    }
}
