package main.controlador.sonido;

import java.io.File;

public class HandlerSonidoCurandero {
    private static HandlerSonido sonidoCreacion =
            new HandlerSonido(new File("src/recursos/sonidos/priest_converting2.wav"));

    static public void reproducirSonidoSeleccion(){
        sonidoCreacion.reproducirSonido();
    }
}
