package Main;

//TODO: Esta clase deberia ser accesible unicamente desde jugador, pero no se podrian hacer tests unitarios de esa forma.
//TODO: Consultar esto
public class ContadorDePuntos
{
    private static int _puntosIniciales = 20;
    private int _puntosRestantes;

    public ContadorDePuntos() {
        _puntosRestantes = _puntosIniciales;
    }

    public int puntosRestantes() {
        return this._puntosRestantes;
    }

    public void contarPuntosDe(Unidad unidad) {
        if (this.puntosRestantes() - unidad.coste() < 0) {
            throw new InsuficientePuntosRestantesAlColocarUnidad();
        }
        this._puntosRestantes -= unidad.coste();
    }
}
