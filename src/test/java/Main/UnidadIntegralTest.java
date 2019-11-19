package Main;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnidadIntegralTest {
    @After
    public void reiniciarJuego()
    {
        Juego.getInstance().reiniciar();
        Tablero.getInstance().reiniciar();
    }
    @Test
    public void unidadMovibleSoldadoSePuedeMoverEnTodasLasDirecciones() {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

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
    @Test (expected = CasilleroOcupadoException.class)
    public void unidadSeMueveACasilleroOcupadoYTiraUnaExcepcion() {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Jinete(); //BUG EXTRAÑO, si pones adelante un soldado este test no pasa
        Unidad unidad2 = new Soldado();

        unidad1.setJugador("Arkantos");
        unidad2.setJugador("Gargarensis");

        jugador1.colocarUnidadEn(unidad1,new Posicion(6,5));
        jugador1.colocarUnidadEn(unidad2,new Posicion(5,5));

        // Act & Assert
        unidad1.avanzar(new Norte());
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

    @Test (expected = CasilleroFueraDeTableroException.class)
    public void unidadSeMueveFueraDeTableroYTiraUnaExcepcion() {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Unidad unidad1 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(0,0));

        // Act & Assert
        unidad1.avanzar(new Norte());   // (4,5)
    }

    @Test (expected = UnidadFueraDeRangoException.class)
    public void jineteAtacaASoldadoADistanciaMediaTeniendoUnoCercanoYTiraExcepcion() {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Jinete();
        Unidad unidad2 = new Soldado();
        Unidad unidad3 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(9,9));
        jugador2.colocarUnidadEn(unidad2,new Posicion(10,10));
        jugador2.colocarUnidadEn(unidad3,new Posicion(12,12));

        // Act & Assert
        unidad1.atacar(unidad3);
    }

    @Test
    public void jineteAtacaASoldadoADistanciaMediaTeniendoEnemigoUnoCercanoYUnoAliadoYAtaca() {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Jinete();
        Unidad unidad2 = new Soldado();
        Unidad unidad3 = new Soldado();
        Unidad unidad4 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(9,9));
        jugador2.colocarUnidadEn(unidad2,new Posicion(10,10));
        jugador2.colocarUnidadEn(unidad3,new Posicion(12,12));
        jugador1.colocarUnidadEn(unidad4,new Posicion(8,9));

        int vidaInicial = unidad2.vida();

        // Act
        unidad1.atacar(unidad3);

        // Assert
        assertEquals(unidad3.vida(),vidaInicial-15);

    }

    @Test (expected = UnidadFueraDeRangoException.class)
    public void jineteAtacaASoldadoADistanciaCercanaTeniendoEnemigoUnoCercanoYUnoAliadoYTiraExcepcion() {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Jinete();
        Unidad unidad2 = new Soldado();
        Unidad unidad3 = new Soldado();
        Unidad unidad4 = new Soldado();

        jugador1.colocarUnidadEn(unidad1,new Posicion(9,9));
        jugador2.colocarUnidadEn(unidad2,new Posicion(10,10));
        jugador2.colocarUnidadEn(unidad3,new Posicion(12,12));
        jugador1.colocarUnidadEn(unidad4,new Posicion(8,9));

        int vidaInicial = unidad2.vida();

        // Act
        unidad1.atacar(unidad2);

    }
}
