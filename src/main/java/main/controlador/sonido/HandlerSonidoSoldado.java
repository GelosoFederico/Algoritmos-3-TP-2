package main.controlador.sonido;

import java.io.File;

public class HandlerSonidoSoldado {
    private static HandlerSonido sonidoCreacion =
            new HandlerSonido(new File("file:src/recursos/sonidos/military_spawn.wav"));

    static public void reproducirSonidoSeleccion(){
        sonidoCreacion.reproducirSonido();
    }
}
