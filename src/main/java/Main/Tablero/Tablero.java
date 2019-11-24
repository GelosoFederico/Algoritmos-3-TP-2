package Main.Tablero;

import Main.Direccion.Direccion;
import Main.Direccion.Posicion;
import Main.Excepciones.*;
import Main.Juego.Jugador;
import Main.Tablero.Distancia.Distancia;
import Main.Unidad.ConjuntoDeUnidades.ConjuntoDeUnidades;
import Main.Unidad.Unidad;

public class Tablero {
    private static final int MIN_DISTANCIA_CORTA = 1;
    private static final int MAX_DISTANCIA_CORTA = 2;
    private static final int MIN_DISTANCIA_MEDIA = 3;
    private static final int MAX_DISTANCIA_MEDIA = 5;
    private static final int MIN_DISTANCIA_LEJANA = 6;
    // Singleton pattern
    private static Tablero INSTANCE = null;

    int maximaCantidadDeCasilleros = 20;

    Casillero[][] casilleros = new Casillero[maximaCantidadDeCasilleros][maximaCantidadDeCasilleros];

    private Tablero(){
        this.crearCasilleros();
    }
    public static Tablero getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Tablero();
        }
        return INSTANCE;
    }

    public Posicion obtenerPosicionDeUnidad(Unidad unidad) {
        // TODO: Refactorizar maybe
        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                if( unidad == casilleros[i][j].unidad()) {
                    return casilleros[i][j].posicion();
                }
            }
        }
        throw new UnidadNoSeEncuentraEnTablero();
    }
    public void moverUnidadEnDireccion(Unidad unidad, Direccion direccion) {

        Posicion posicionActual = this.obtenerPosicionDeUnidad(unidad);
        Casillero casilleroActual = this.obtenerCasilleroEnPosicion(posicionActual);

        Posicion posicionNueva = posicionActual.sumar(direccion.posicionRelativa());
        Casillero casilleroNuevo = this.obtenerCasilleroEnPosicion(posicionNueva);

        casilleroNuevo.guardarUnidad(unidad);
        casilleroActual.liberar();
    }

    public void colocarUnidadEnPosicionDeJugador(Unidad unidad, Posicion posicion, Jugador jugador) {
        this.obtenerCasilleroEnPosicion(posicion).colocarUnidadDeJugador(unidad,jugador);
    }

    private void crearCasilleros() {
        int numeroDeJugador;
        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            if (i < maximaCantidadDeCasilleros/2)
                numeroDeJugador = 1;
            else
                numeroDeJugador = 2;
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                    casilleros[i][j] = new Casillero(new Posicion(i,j), numeroDeJugador);
            }
        }
    }

    public Casillero obtenerCasilleroEnPosicion(Posicion posicion) {
        Casillero casillero;
        try{
            casillero = casilleros[posicion.posicionEnX()][posicion.posicionEnY()];
        } catch(IndexOutOfBoundsException e) {
            throw new CasilleroFueraDeTableroException();
        }
        return casillero;
    }

    public Distancia calcularDistanciaEntre(Unidad unidad1, Unidad unidad2) {
        Posicion pos1 = this.obtenerPosicionDeUnidad(unidad1);
        Posicion pos2 = this.obtenerPosicionDeUnidad(unidad2);
        return pos1.distanciaA(pos2);
    }

    public ConjuntoDeUnidades obtenerUnidadesAlrededorDe(Unidad unidadCentro, int distanciaMaxima, ConjuntoDeUnidades conjunto) {
        // TODO agregar iterador para que este codigo no se repita
        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                Distancia distancia = this.calcularDistanciaEntre(unidadCentro,this.casilleros[i][j].unidad());
                if( (distancia.distanciaExacta() <= distanciaMaxima) && (distancia.distanciaExacta() > 0) ) {
                    conjunto.agregar(this.casilleros[i][j].unidad());
                }
            }
        }
        return conjunto;
    }

    public void daniarEnDistanciaCorta(Unidad atacante, Unidad victima, int danio) {
        Distancia distancia = this.calcularDistanciaEntre(victima, atacante);
        if (distancia.distanciaExacta() < MIN_DISTANCIA_CORTA || distancia.distanciaExacta() > MAX_DISTANCIA_CORTA) {
            throw new UnidadFueraDeRangoException();
        }
        victima.recibirDanio(danio);
    }

    public void daniarEnDistanciaMedia(Unidad atacante, Unidad victima, int danio) {
        Distancia distancia = this.calcularDistanciaEntre(victima, atacante);
        if (distancia.distanciaExacta() < MIN_DISTANCIA_MEDIA || distancia.distanciaExacta() > MAX_DISTANCIA_MEDIA) {
            throw new UnidadFueraDeRangoException();
        }
        victima.recibirDanio(danio);
    }

    public void daniarEnDistanciaLejana(Unidad atacante, Unidad victima, int danio) {
        Distancia distancia = this.calcularDistanciaEntre(victima, atacante);
        if ( distancia.distanciaExacta() < MIN_DISTANCIA_LEJANA ) {
            throw new UnidadFueraDeRangoException();
        }
        victima.recibirDanio(danio);
    }

    /*
    public void daniarUnidadEnRango(Unidad atacante, Unidad victima, Distancia distanciaPrototipo) {
        Distancia distancia = this.calcularDistanciaEntre(victima, atacante);
        distancia.daniarUnidadEnRango(victima, distanciaPrototipo, danio);
    }
    */
}
