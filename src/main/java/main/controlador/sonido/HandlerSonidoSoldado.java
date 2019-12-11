package main.controlador.sonido;

import main.controlador.sonido.HandlerSonido;

import java.io.File;

public class HandlerSonidoSoldado {
    private static HandlerSonido sonidoCreacion =
            new HandlerSonido(new File("src/sonidos/military_spawn.wav"));

    static public void reproducirSonidoSeleccion(){
        sonidoCreacion.reproducirSonido();
    }
}
