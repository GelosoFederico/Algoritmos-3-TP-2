package main.modelo.tablero.distancia;

import main.modelo.excepciones.*;
import main.modelo.unidad.Unidad;

public abstract class  Distancia {
    private static final int MIN_DISTANCIA_CORTA = 1;
    private static final int MAX_DISTANCIA_CORTA = 2;
    private static final int MIN_DISTANCIA_MEDIA = 3;
    private static final int MAX_DISTANCIA_MEDIA = 5;
    private static final int MIN_DISTANCIA_LEJANA = 6;

    protected int distanciaExacta;

    // Este metodo es segun el patron factory
    // Se puede hacer una clase aparte pero se recomienda en https://sourcemaking.com/design_patterns/factory_method
    // que se haga directamente como un metodo de clase
    public static Distancia crearDistancia(int distancia) {
        Distancia distCreada = null;
        if(distancia >= MIN_DISTANCIA_CORTA && distancia <= MAX_DISTANCIA_CORTA) {
            distCreada = new DistanciaCercana(distancia);
        }
        if(distancia >= MIN_DISTANCIA_MEDIA && distancia <= MAX_DISTANCIA_MEDIA) {
            distCreada = new DistanciaMedia(distancia);
        }
        if(distancia >= MIN_DISTANCIA_LEJANA ) {
            distCreada = new DistanciaLejana(distancia);
        }
        // Este caso queda por si hay distancias 0 o negativas
        if (distCreada == null) {
            distCreada = new DistanciaNula(distancia);
        }
        return distCreada;
    }

    public Distancia(){}

    public Distancia(int distancia) {
        this.distanciaExacta = distancia;
    }

    public int distanciaExacta() {
        return this.distanciaExacta;
    }

    // Estos metodos deben estar aca para implementar el doble dispatch
    public abstract void daniarUnidadEnRango(Unidad victima, Distancia distanciaPrototipo, int danio);

    public void daniarUnidadCercana(Unidad victima, int danio) {
        throw new UnidadFueraDeRangoException();
    }

    public void daniarUnidadMedia(Unidad victima, int danio) {
        throw new UnidadFueraDeRangoException();
    }

    public void daniarUnidadLejana(Unidad victima, int danio) {
        throw new UnidadFueraDeRangoException();
    }
}
