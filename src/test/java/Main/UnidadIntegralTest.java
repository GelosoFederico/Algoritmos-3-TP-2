package Main;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnidadIntegralTest {
    @After
    public void reiniciarJuego()
    {
        Juego.getInstance().reiniciar();
    }

    /*
    @Test
    public void unidadMovibleSoldadoSePuedeMoverEnTodasLasDirecciones() {
        // Assert
        Unidad unidad = new Soldado();

        // Act
        unidad.avanzar();
    }
    */

    @Test
    public void soldadoAtacaAOtroSoldadoDeDistintosEquipoYPierdeVida () {
        // Arrange
        Juego.getInstance().reiniciar();
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);
        jugador1.set_tablero(tablero);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);
        jugador2.set_tablero(tablero);

        Unidad unidad1 = new Soldado();
        Unidad unidad2 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(9,9));
        jugador2.colocarUnidadEn(unidad2,new Posicion(10,10));

        int vidaInicial = unidad1.vida();

        // Act
        unidad1.atacar(unidad2);

        // Assert
        assertEquals(unidad2.vida(),vidaInicial-10);
    }

    @Test
    public void jineteAtacaASoldadoDeDistintosEquipoYPierdeVida () {
        // Arrange
        Juego.getInstance().reiniciar();
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);
        jugador1.set_tablero(tablero);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);
        jugador2.set_tablero(tablero);

        Unidad unidad1 = new Jinete();
        Unidad unidad2 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(6,6));
        jugador2.colocarUnidadEn(unidad2,new Posicion(10,10));

        int vidaInicial = unidad2.vida();

        // Act
        unidad1.atacar(unidad2);

        // Assert
        assertEquals(unidad2.vida(),vidaInicial-15);
    }

    /*
    @Test
    public void CatapultaAtacaASoldadoDeDistintosEquipoYPierdeVida () {
        // Arrange
        Juego.getInstance().reiniciar();
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);
        jugador1.set_tablero(tablero);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);
        jugador2.set_tablero(tablero);

        Unidad unidad1 = new Catapulta();
        Unidad unidad2 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(1,1));
        jugador2.colocarUnidadEn(unidad2,new Posicion(10,10));

        int vidaInicial = unidad1.vida();

        // Act
        unidad1.atacar(unidad2);

        // Assert
        assertEquals(unidad2.vida(),vidaInicial-20);
    }
    */

    @Test
    public void curanderoCuraASoldadoDelMismoEquipoYGanaVida () {
        // Arrange
        Juego.getInstance().reiniciar();
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);
        jugador1.set_tablero(tablero);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);
        jugador2.set_tablero(tablero);

        Unidad unidad1 = new Curandero();
        Unidad unidad2 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(1,1));
        jugador1.colocarUnidadEn(unidad2,new Posicion(2,2));

        int vidaInicial = unidad2.vida();

        // Act
        unidad1.atacar(unidad2);

        // Assert
        assertEquals(unidad2.vida(),vidaInicial+15);
    }

}
