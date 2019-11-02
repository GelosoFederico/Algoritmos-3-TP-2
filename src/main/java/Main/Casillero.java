package Main;

public class Casillero {

    private boolean estado = true;

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public boolean getEstado(){
        return this.estado;
    }

    public Casillero obtenerSiguienteEnDireccion(String otraPosicion) {
        Casillero unCasillero = new Casillero();
        return unCasillero;

    }

    public boolean estaOcupado() {
        if(this.estado)
            return false;
        return true;
    }

    public boolean estaLibre(){
        if(this.estado)
            return true;
        return false;
    }

    public int calcularDistanciaA(Casillero casillero) {
        return 1;
    }
}
