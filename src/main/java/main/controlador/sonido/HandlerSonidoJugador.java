package main.controlador.sonido;

import main.controlador.sonido.HandlerSonido;

import java.io.File;

public class HandlerSonidoJugador {
    private static HandlerSonido sonidoCreacion =
            new HandlerSonido(new File("src/sonidos/chat.wav"));

    static public void reproducirSonidoCreacion(){
        sonidoCreacion.reproducirSonido();
    }
}
