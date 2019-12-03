package main.controlador;

import main.modelo.juego.Juego;
import main.vista.VistaPartida;

public class HandlerTurnos {
    private static VistaPartida vistaPartida;

    public static void setVistaPartida(VistaPartida vista) {vistaPartida = vista;}

    public static void pasarTurno() {
        Juego.getInstance().ejecutarUnTurno();
        vistaPartida.actualizar();
    }
}
