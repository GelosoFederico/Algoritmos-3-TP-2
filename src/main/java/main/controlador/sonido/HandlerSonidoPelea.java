package main.controlador.sonido;

import java.io.File;

public class HandlerSonidoPelea {
    private static HandlerSonido sonidoCreacion =
            new HandlerSonido(new File("src/recursos/sonidos/attackwarning.wav"));
    static public void reproducirSonidoSeleccion(){
        sonidoCreacion.reproducirSonido();
    }
}
