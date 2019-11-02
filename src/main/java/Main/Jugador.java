package Main;

public class Jugador
{
    // Atributos
    private String _nombre;
    private Tablero _tablero;
    private ContadorDePuntos _contadorPuntos;

    // Metodos
    public Jugador(){
        _contadorPuntos = new ContadorDePuntos();
    }

    public Jugador(String nombre){
        _contadorPuntos = new ContadorDePuntos();
        _nombre = nombre;
    }

    public String nombre() {
        return this._nombre;
    }

    public void nombre(String nombre) {
        this._nombre = nombre;
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
    }

    private ContadorDePuntos getContadorPuntos() {
        return this._contadorPuntos;
    }
}
