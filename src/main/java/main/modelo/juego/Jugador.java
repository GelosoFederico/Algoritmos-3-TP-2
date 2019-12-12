package main.modelo.juego;

import main.modelo.tablero.distancia.Posicion;
import main.modelo.excepciones.UnidadEstaMuertaException;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;

import java.util.ArrayList;

public class Jugador
{

    public static void reiniciar (){
        siguienteNumero = 1;} // Este metodo es para reiniciar los tests
    private static Integer siguienteNumero = 1;
    // Atributos
    private String nombre;
    private ContadorDePuntos contadorDePuntos;
    private ArrayList<Unidad> unidades;
    private Integer numero;
    private Equipo equipo;
    private Jugador siguienteJugador;

    // Metodos
    public Jugador(){
        contadorDePuntos = new ContadorDePuntos();
        unidades = new ArrayList<Unidad>();
        numero = siguienteNumero;
        siguienteNumero++;
    }

    public Jugador(String nombre){
        contadorDePuntos = new ContadorDePuntos();
        this.nombre = nombre;
        unidades = new ArrayList<Unidad>();
        numero = siguienteNumero;
        siguienteNumero++;
    }

    public String nombre() {
        return this.nombre;
    }

    public void nombre(String nombre) {
        this.nombre = nombre;
    }

    public void equipo(Equipo equipo){
        this.equipo = equipo;}

    public Equipo equipo(){ return equipo; }

    public Integer numero() {
        return this.numero;
    }

    public Integer puntosRestantes() {
        return this.getContadorPuntos().puntosRestantes();
    }

    public void colocarUnidadEn(Unidad unidad, Posicion posicion) {
        unidad.setJugador(this.nombre());
        unidad.setEquipo(this.equipo());
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(unidad, posicion, this);
        this.getContadorPuntos().contarPuntosDe(unidad);
        this.unidades().add(unidad);

    }

    private ContadorDePuntos getContadorPuntos() {
        return this.contadorDePuntos;
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

    public Jugador obtenerSiguienteJugador() {
        return this.siguienteJugador;
    }

    public void setSiguienteJugador(Jugador jugador) {
        this.siguienteJugador = jugador;
    }

    public ArrayList<Unidad> unidades() {
        return unidades;
    }

    public void moverUnidadHacia(Unidad soldado1, Posicion posicion) {

    }
}
