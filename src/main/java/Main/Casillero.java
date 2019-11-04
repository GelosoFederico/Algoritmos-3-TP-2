package Main;

public class Casillero {
    Posicion posicion;
    String estado;
    int deJugador;

    Casillero() {
        estado = "libre";
    }
    Casillero(Posicion posicionAsignada, int numeroDeJugador) {
        posicion = posicionAsignada;
        estado = "libre";
        deJugador = numeroDeJugador;
    }

    public Posicion posicion() {
        return posicion;
    }

    public String estado() {return estado;}

    public void ocupar() {
        estado = "ocupado";
    }

    public void liberar() {
        estado = "libre";
    }

    public int deJugador() {
        return deJugador;
    }

    public Casillero obtenerSiguienteEnDireccion(String direccion) {
        if(direccion.equals("N")) {
            Posicion nuevaPos = new Posicion(this.posicion().posicionEnX() , this.posicion().posicionEnY()+1);
            return new Casillero(nuevaPos,this.deJugador());
        }
        return new Casillero();
    }

    public int calcularDistanciaA(Casillero casillero) {
        return 1;
    }

    public Posicion getPosicion() {
        return posicion;
    }
}
