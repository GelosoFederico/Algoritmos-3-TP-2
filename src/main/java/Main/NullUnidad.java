package Main;

public class NullUnidad implements Unidad {
    // TODO: devuelve cualquier cosa. Hay que ver que preferimos que haga
    public void atacar(Unidad unidadVictima){};
    public void avanzar(Direccion direccion){};
    public int coste(){return 0;}
    public void recibirDanio(int danio){};

    public String getJugador(){return "nadie";}
    public void setJugador(String unJugador){};
    public int vida(){return 0;}
    public Posicion posicion(){return new Posicion(0,0);};
    public void setearEstrategiaDeAtaque(AtaqueEstrategia ataqueEstrategia){};
    public void agregarseA(ConjuntoDeSoldados conjuntoDeSoldados) {};
    public Unidad ocuparCasillero(Unidad unidad){
        return unidad;
    };
}
