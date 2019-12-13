package main.controlador.sonido;

import java.io.File;

public class HandlerSonidoCatapulta {
    private static HandlerSonido sonidoCreacion =
            new HandlerSonido(new File("file:src/recursos/sonidos/horseselect1.wav"));

    static public void reproducirSonidoSeleccion(){
         sonidoCreacion.reproducirSonido();
    }
}
