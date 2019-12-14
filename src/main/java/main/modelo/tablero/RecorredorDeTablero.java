package main.modelo.tablero;

import main.modelo.excepciones.UnidadNoSeEncuentraEnTablero;
import main.modelo.tablero.distancia.Distancia;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;

public class RecorredorDeTablero {

    public Posicion buscarPosicionDeUnidad(Unidad unidad){
        Tablero tablero = Tablero.getInstance();
        Casillero[][] casilleros = tablero.getCasilleros();

        int maximaCantidadDeCasilleros = tablero.getMaximaCantidadDeCasilleros();
        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                if( unidad == casilleros[i][j].unidad()) {
                    return casilleros[i][j].posicion();
                }
            }
        }
        throw new UnidadNoSeEncuentraEnTablero();
    }

    public ConjuntoDeUnidades buscarUnidadesAlRededorDe(Unidad unidadCentro, int distanciaMaxima, ConjuntoDeUnidades conjunto){
        Tablero tablero = Tablero.getInstance();
        Casillero[][] casilleros = tablero.getCasilleros();


        int maximaCantidadDeCasilleros = tablero.getMaximaCantidadDeCasilleros();
        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                Distancia distancia = tablero.calcularDistanciaEntre(unidadCentro, casilleros[i][j].unidad());
                if( (distancia.distanciaExacta() <= distanciaMaxima) && (distancia.distanciaExacta() > 0) ) {
                    conjunto.agregar(casilleros[i][j].unidad());
                }
            }
        }
        return conjunto;

    }
}
