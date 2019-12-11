package main.controlador.sonido;

import main.controlador.sonido.HandlerSonido;

import java.io.File;

public class HandlerSonidoCatapulta {
    private static HandlerSonido sonidoCreacion =
            new HandlerSonido(new File("src/sonidos/horseselect1.wav"));

    static public void reproducirSonidoSeleccion(){
         sonidoCreacion.reproducirSonido();
    }
}
