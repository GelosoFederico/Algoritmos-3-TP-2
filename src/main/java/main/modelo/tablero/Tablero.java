package main.modelo.tablero;

import main.modelo.direccion.Direccion;
import main.modelo.excepciones.CasilleroFueraDeTableroException;
import main.modelo.juego.Equipo;
import main.modelo.juego.EquipoBlanco;
import main.modelo.juego.EquipoNegro;
import main.modelo.juego.Jugador;
import main.modelo.tablero.distancia.Distancia;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;

public class Tablero {
    // Singleton pattern
    private static Tablero INSTANCE = null;

    private final int maximaCantidadDeCasilleros = 20;

    private Casillero[][] casilleros = new Casillero[maximaCantidadDeCasilleros][maximaCantidadDeCasilleros];

    private Tablero(){
        this.crearCasilleros();
    }
    public static Tablero getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Tablero();
        }
        return INSTANCE;
    }

    public Casillero[][] getCasilleros(){
        return this.casilleros;
    }

    public int getMaximaCantidadDeCasilleros(){
        return this.maximaCantidadDeCasilleros;
    }

    public Posicion obtenerPosicionDeUnidad(Unidad unidad) {
        RecorredorDeTablero recorredorDeTablero = new RecorredorDeTablero();
        return recorredorDeTablero.buscarPosicionDeUnidad(unidad);
    }

    public void moverUnidadEnDireccion(Unidad unidad, Direccion direccion) {

        Posicion posicionActual = this.obtenerPosicionDeUnidad(unidad);
        Casillero casilleroActual = this.obtenerCasilleroEnPosicion(posicionActual);

        Posicion posicionNueva = posicionActual.sumar(direccion.posicionRelativa());
        Casillero casilleroNuevo = this.obtenerCasilleroEnPosicion(posicionNueva);

        casilleroNuevo.ocupar(unidad);
        casilleroActual.liberar();
    }

    public void colocarUnidadEnPosicionDeJugador(Unidad unidad, Posicion posicion, Jugador jugador) {
        this.obtenerCasilleroEnPosicion(posicion).colocarUnidadDeJugador(unidad,jugador);
    }

    private void crearCasilleros() {
        Equipo equipo;
        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            if (i < maximaCantidadDeCasilleros/2)
                equipo = new EquipoBlanco();
            else
                equipo = new EquipoNegro();
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                this.casilleros[i][j] = new Casillero(new Posicion(i,j), equipo);
            }
        }
    }

    public Casillero obtenerCasilleroEnPosicion(Posicion posicion) {
        Casillero casillero;
        try{
            casillero = this.casilleros[posicion.posicionEnX()][posicion.posicionEnY()];
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
        RecorredorDeTablero recorredorDeTablero = new RecorredorDeTablero();
        return recorredorDeTablero.buscarUnidadesAlRededorDe(unidadCentro, distanciaMaxima, conjunto);
    }

    public void daniarUnidadEnRango(Unidad atacante, Unidad victima, Distancia distanciaPrototipo, int danio) {
        Distancia distancia = this.calcularDistanciaEntre(victima, atacante);
        distancia.daniarUnidadEnRango(victima, distanciaPrototipo, danio);
    }

    public Unidad getUnidadEnPosicion(Posicion posicion) {
        return casilleros[posicion.posicionEnX()][posicion.posicionEnY()].unidad();
    }

    public void removerUnidad(Unidad unidad) {
        Casillero casilleroAVaciar = this.obtenerCasilleroEnPosicion(unidad.posicion());
        casilleroAVaciar.liberar();
    }
}
