package Main;

public class Jugador 
{
    // Atributos
    private String _nombre;
    private Integer _puntosRestantes;
    private Tablero _tablero;

    // Metodos
    public Jugador(){
        _puntosRestantes = 20;
    }

    public Jugador(String nombre){
        _nombre = nombre;
        _puntosRestantes = 20;
    }

    public String nombre() {
        return this._nombre;
    }

    public void nombre(String nombre) {
        this._nombre = nombre;
    }

    public Integer puntosRestantes() {
        return this._puntosRestantes;
    }

    public void set_tablero(Tablero tablero) {
        this._tablero = tablero;
    }

    public void colocarUnidadEn(Unidad unidad, String posicion) {
        Casillero casillero = _tablero.obtenerCasilleroLibreParaJugador(posicion, this.nombre());
        unidad.colocarEn(casillero);
        if (this._puntosRestantes - unidad.coste() < 0) {
            throw new JugadorInsuficientePuntosRestantesAlColocarUnidad();
        }
        this._puntosRestantes -= unidad.coste();
    }
}
