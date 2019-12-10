package main.controlador.sonido;

import main.controlador.sonido.HandlerSonido;

import java.io.File;

public class HandlerSonidoJinete {
    private static HandlerSonido sonidoCreacion =
            new HandlerSonido(new File("src/sonidos/mangonelselect.wav"));

    static public void reproducirSonidoSeleccion(){
        sonidoCreacion.reproducirSonido();
    }
}
