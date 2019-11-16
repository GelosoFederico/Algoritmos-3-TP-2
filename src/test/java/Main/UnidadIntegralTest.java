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
    @Test
    public void unidadMovibleSoldadoSePuedeMoverEnTodasLasDirecciones() {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(5,5));

        // Act
        unidad1.avanzar(new Norte());   // (4,5)
        unidad1.avanzar(new Norte());   // (3,5)
        unidad1.avanzar(new Este());    // (3,6)
        unidad1.avanzar(new Sur());     // (4,6)
        unidad1.avanzar(new Noreste()); // (3,7)

        // Assert
        Posicion posicionFinal = Tablero.getInstance().obtenerPosicionDeUnidad(unidad1);
        assertEquals(posicionFinal.posicionEnX(),3);
        assertEquals(posicionFinal.posicionEnY(),7);
    }
    @After
    public void reiniciarTablero()
    {
        Tablero.getInstance().reiniciar();
    }
    @Test (expected = CasilleroOcupadoException.class)
    public void unidadSeMueveACasilleroOcupadoYTiraUnaExcepcion() {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Soldado();
        Unidad unidad2 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(5,5));
        jugador1.colocarUnidadEn(unidad2,new Posicion(6,5));

        // Act & Assert
        unidad2.avanzar(new Norte());
    }

    @Test (expected = UnidadNoPuedeMoverseException.class)
    public void unidadCatapultaSeIntentaMoverYTiraUnaExcepcion() {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Catapulta();

        jugador1.colocarUnidadEn(unidad1,new Posicion(9,9));

        // Act & Assert
        unidad1.avanzar(new Norte());
    }

    @Test
    public void soldadoAtacaAOtroSoldadoDeDistintosEquipoYPierdeVida () {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Soldado();
        Unidad unidad2 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(9,9));
        jugador2.colocarUnidadEn(unidad2,new Posicion(10,10));

        int vidaInicial = unidad2.vida();

        // Act
        unidad1.atacar(unidad2);

        // Assert
        assertEquals(unidad2.vida(),vidaInicial-10);
    }

    @Test
    public void jineteAtacaASoldadoDeDistintoEquipoYPierdeVida () {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

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

    @Test
    public void CatapultaAtacaASoldadoDeDistintoEquipoYPierdeVida () {
        // Arrange
        Juego.getInstance().reiniciar();
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Catapulta();
        Unidad unidad2 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(1,1));
        jugador2.colocarUnidadEn(unidad2,new Posicion(10,10));

        int vidaInicial = unidad2.vida();

        // Act
        unidad1.atacar(unidad2);

        // Assert
        assertEquals(unidad2.vida(),vidaInicial-20);
    }

    @Test
    public void curanderoCuraASoldadoDelMismoEquipoYGanaVida () {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

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
