package Main;

import java.util.Vector;

public class Jugador
{
    private static Integer siguiente_numero = 1;
    // Atributos
    private String _nombre;
    private Tablero _tablero;
    private ContadorDePuntos _contadorPuntos;
    private Vector<Unidad> _unidades;
    private Integer _numero;

    // Metodos
    public Jugador(){
        _contadorPuntos = new ContadorDePuntos();
        _unidades = new Vector<Unidad>();
        _numero = siguiente_numero;
        siguiente_numero++;
    }

    public Jugador(String nombre){
        _contadorPuntos = new ContadorDePuntos();
        _nombre = nombre;
        _unidades = new Vector<Unidad>();
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

    public void set_tablero(Tablero tablero) {
        this._tablero = tablero;
    }

    public void colocarUnidadEn(Unidad unidad, String posicion) {
        Casillero casillero = _tablero.obtenerCasilleroLibreParaJugador(posicion, this.nombre());
        unidad.colocarEn(casillero);
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

    public Vector<Unidad> unidades() {
        return _unidades;
    }
}
