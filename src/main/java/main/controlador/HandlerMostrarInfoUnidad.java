package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.modelo.juego.Juego;
import main.modelo.unidad.NullUnidad;
import main.modelo.unidad.RealUnidad;
import main.modelo.unidad.Unidad;
import main.vista.GridPaneTablero;
import main.vista.VistaAgregarJugador;
import main.vista.VistaCasillero;
import main.vista.VistaInformacionUnidad;

import java.util.ArrayList;

import static main.modelo.tablero.Tablero.getInstance;

public class HandlerMostrarInfoUnidad implements EventHandler<MouseEvent> {
    private Stage stage;
    private VistaCasillero vistaCasillero;
    private GridPaneTablero tablero;
    private static Unidad unidadSeleccionada = null;
    private static ArrayList<String> informacionDeUnidad;


    public HandlerMostrarInfoUnidad(VistaCasillero vistaCasillero, GridPaneTablero tablero, Stage stage){
        this.stage = stage;
        this.vistaCasillero = vistaCasillero;
        this.tablero = tablero;
    }

    public static void setInformacionDeUnidad(Unidad unidad){
        ArrayList<String> informacion = new ArrayList<>();
        informacion.add(unidad.getClass().getSimpleName());
        informacion.add("Jugador: ".concat(unidad.getJugador()));
        informacion.add("Jugador: ".concat(unidad.equipo().getClass().getSimpleName()));
        informacion.add("Vida: ".concat(String.valueOf(unidad.vida())));
        informacionDeUnidad = informacion;
    }

    public static Unidad getUnidad() {
        return unidadSeleccionada;
    }

    public static ArrayList<String> getInformacionDeUnidad() { return informacionDeUnidad; }

    @Override
    public void handle(MouseEvent mouseEvent) {
        unidadSeleccionada =  getInstance().getUnidadEnPosicion(vistaCasillero.getPosicion());
        //Todo: esto esta feo
        if(!unidadSeleccionada.getClass().getSimpleName().equals("NullUnidad")) {
            setInformacionDeUnidad(unidadSeleccionada);
            VistaInformacionUnidad vistaInformacionUnidad = new VistaInformacionUnidad(this.stage);
            vistaInformacionUnidad.dibujarPantalla();
        }

    }
}
