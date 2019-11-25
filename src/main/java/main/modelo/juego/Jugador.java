package main.modelo.juego;

import main.modelo.direccion.Posicion;
import main.modelo.excepciones.UnidadEstaMuertaException;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;

import java.util.ArrayList;

public class Jugador
{

    public static void reiniciar (){siguiente_numero = 1;} // Este metodo es para reiniciar los tests
    private static Integer siguiente_numero = 1;
    // Atributos
    private String _nombre;
    private ContadorDePuntos _contadorPuntos;
    private ArrayList<Unidad> _unidades;
    private Integer _numero;

    // Metodos
    public Jugador(){
        _contadorPuntos = new ContadorDePuntos();
        _unidades = new ArrayList<Unidad>();
        _numero = siguiente_numero;
        siguiente_numero++;
    }

    public Jugador(String nombre){
        _contadorPuntos = new ContadorDePuntos();
        _nombre = nombre;
        _unidades = new ArrayList<Unidad>();
        _numero = siguiente_numero;
        siguiente_numero++;
    }

    public String nombre() {
        return this._nombre;
    }

    public void nombre(String nombre) {
        this._nombre = nombre;
    }
    
    public Integer numero() {
        return this._numero;
    }

    public Integer puntosRestantes() {
        return this.getContadorPuntos().puntosRestantes();
    }

    public void colocarUnidadEn(Unidad unidad, Posicion posicion) {
        unidad.setJugador(this.nombre());
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(unidad, posicion, this);
        this.getContadorPuntos().contarPuntosDe(unidad);
        this.unidades().add(unidad);

    }

    private ContadorDePuntos getContadorPuntos() {
        return this._contadorPuntos;
    }

    public void pierdeUnidad(Unidad unidad) {
        // TODO: validar que no este, tirar excepcion adecuada, mover esto a una clase de Conjunto de unidades
        this.unidades().remove(unidad);
        if(this.unidades().isEmpty()) {
            Juego.getInstance().jugadorPerdio(this);
        }
    }

    public void atacarConUnidadAUnidad(Unidad unidadAtacante, Unidad unidadDefensora){
        try {
            unidadAtacante.atacar(unidadDefensora);
        }catch (UnidadEstaMuertaException e) {
            Juego.getInstance().murioUnidad(unidadDefensora);
        }

    }

    public ArrayList<Unidad> unidades() {
        return _unidades;
    }
}
