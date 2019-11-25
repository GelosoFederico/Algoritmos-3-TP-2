package Main.Tablero;

import Main.Juego.Equipo;
import Main.Juego.Jugador;
import Main.Direccion.Posicion;
import Main.Unidad.NullUnidad;
import Main.Unidad.Unidad;

public class Casillero {
    private Posicion posicion;
    private int deJugador; //eliminar de forma segura
    private Equipo equipo;
    private Unidad unidad;

    public Casillero(Posicion posicionAsignada, Equipo equipo) {
        posicion = posicionAsignada;
        this.equipo = equipo;
        unidad = new NullUnidad();
    }

    public Posicion posicion() {
        return posicion;
    }

    public void ocupar(Unidad unaUnidad) {
        this.unidad = this.unidad.ocuparCasillero(unaUnidad);
    }

    public void liberar() {
        this.unidad = new NullUnidad();
    }

    public int deJugador() {
        return deJugador;
    }

    public Equipo equipo(){ return this.equipo; }

    public void colocarUnidadDeJugador(Unidad unidad, Jugador jugador) {
       //Bando bandoUnidad = bandoUnidad.obtenerBando(unidad.equipo(), casillero.equipo());
        this.equipo().colocar(unidad, unidad.equipo(), this);
    }

    // TODO: pensar en un nombre mejor. Este se diferencia del metodo colocarUnidadDeJugador
    // porque no necesita validar si es del aliado o enemigo. Es para usar en
    // TODO: meter este dentro del colocar
    public void guardarUnidad(Unidad unidad) { this.ocupar(unidad); }

    public Unidad unidad() {
        return this.unidad;
    }

    public int calcularDistanciaA(Casillero casillero) {
        return this.posicion().distanciaA(casillero.posicion());
    }

}
