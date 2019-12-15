package main.vista;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.controlador.*;
import main.modelo.tablero.distancia.Posicion;

public class GridPaneTablero extends GridPane {
    private static final int LONGITUD = 20;
    private Stage ventanaInfoUnidad = new Stage();

    public GridPaneTablero() {
        super();

        for(int i=0; i< LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++){
                VistaCasillero casillero = new VistaCasillero(new Posicion(i, j));
                this.add(casillero, i, j);
            }
        }
    }

    public void setModoSeleccionarMovible() {
        for (Node node : this.getChildren()) {
            VistaCasillero vistaCasillero = (VistaCasillero) node;
            vistaCasillero.setHandler(new HandlerSeleccionarMovible(vistaCasillero, this));
        }
    }

    public void setModoSinReaccion() {
        for (Node node : this.getChildren()) {
            VistaCasillero vistaCasillero = (VistaCasillero) node;
            vistaCasillero.vaciarHandler();
        }
    }

    public void setModoMoverUnidadHaciaAca() {
        for (Node node : this.getChildren()) {
            VistaCasillero vistaCasillero = (VistaCasillero) node;
            vistaCasillero.setHandler(new HandlerMoverUnidadHaciaAca(vistaCasillero, this));
        }
    }

    public void setModoSeleccionarAtacante() {
        for (Node node : this.getChildren()) {
            VistaCasillero vistaCasillero = (VistaCasillero) node;
            vistaCasillero.setHandler(new HandlerSeleccionarAtacante(vistaCasillero, this));
        }
    }

    public void setModoSeleccionarAtacado() {
        for (Node node : this.getChildren()) {
            VistaCasillero vistaCasillero = (VistaCasillero) node;
            vistaCasillero.setHandler(new HandlerSeleccionarVictima(vistaCasillero, this));
        }
    }

    public void setModoMostrarInfoUnidades() {
        for(Node node : this.getChildren()) {
            VistaCasillero vistaCasillero = (VistaCasillero) node;
            vistaCasillero.setHandler(new HandlerMostrarInfoUnidad(vistaCasillero, this, this.ventanaInfoUnidad));
        }
    }
}
