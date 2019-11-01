package Main;

public class Soldado {

    private String posicion = "";
    private int vida;
    private Casillero casillero = new Casillero();

    public  Soldado(){
        posicion = null;
        vida = 100;
        casillero = new Casillero();
    }
    public Soldado(int vidaInicial) {
        vida = vidaInicial;
    }

    public String getPosicion() {
        return this.posicion;
    }

    public void setPosicion(String unaPosicion) {
        this.posicion = unaPosicion;
    }

    public void setCasillero(Casillero unCasillero){ this.casillero = unCasillero;}

    public int vida() { return this.vida; }

    public void avanzar(String otraPosicion) {
       Casillero nuevoCasillero =  this.casillero.obtenerSiguienteEnDireccion(otraPosicion);
       this.casillero = nuevoCasillero;
       this.posicion = otraPosicion; /* REFACTOR pedir posicion a casillero */
    }

    public void atacar(Soldado soldadoEnemigo) {
        int danioCortaDistancia = 10;
        final int DISTANCIA_MAX_CORTA = 2 ;

        int distancia = casillero.calcularDistanciaA(soldadoEnemigo.getCasillero());
        if(distancia >= DISTANCIA_MAX_CORTA){
            throw new UnidadFueraDeRangoException();
        }
        soldadoEnemigo.recibirDanio(danioCortaDistancia); }

    public Casillero getCasillero() { return casillero; }

    public void recibirDanio(int unDanio) {
        this.vida = this.vida - unDanio;
    }


}
