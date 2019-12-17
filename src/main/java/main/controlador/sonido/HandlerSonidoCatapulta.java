package main.controlador.sonido;

import java.io.File;

public class HandlerSonidoCatapulta {
    private static HandlerSonido sonidoCreacion =
            new HandlerSonido(new File("src/recursos/sonidos/mangonelselect.wav"));

    static public void reproducirSonidoSeleccion(){
         sonidoCreacion.reproducirSonido();
    }
}
