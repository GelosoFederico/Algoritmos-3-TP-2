package main;

import main.modelo.excepciones.*;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.juego.EquipoBlanco;
import main.modelo.juego.EquipoNegro;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeSoldados;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;
import main.modelo.unidad.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntegralTest {
    @Before
    @After
    public void reiniciarJuegoYTablero() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Juego.class.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        instance.set(null, null);
        Field instance2 = Tablero.class.getDeclaredField("INSTANCE");
        instance2.setAccessible(true);
        instance2.set(null, null);
        Jugador.reiniciar();
    }
    @Test
    public void seColocaUnidadDeUnJugadorEnSuCampoYEstaAhi()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        jugador1.equipo(new EquipoBlanco());
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.equipo(new EquipoNegro());
         jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad = new Soldado();
        unidad.setEquipo(new EquipoBlanco());

        // Act
        jugador1.colocarUnidadEn(unidad,new Posicion(1,2));

        // Assert
        Posicion posicionFinal = Tablero.getInstance().obtenerPosicionDeUnidad(unidad);
        assertEquals(posicionFinal.posicionEnX(),1);
        assertEquals(posicionFinal.posicionEnY(),2);
        assertEquals(unidad.getJugador(),jugador1.nombre());
    }

    @Test (expected = CasilleroEsDeEnemigoException.class)
    public void seColocaUnidadDeUnJugadorEnCampoContrarioYDaUnaExcepcion()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        jugador1.equipo(new EquipoBlanco());
        Juego.getInstance().agregarJugador(jugador1);

        Unidad unidad = new Soldado();
        unidad.setEquipo(new EquipoBlanco());
        // Act & Assert
        jugador1.colocarUnidadEn(unidad,new Posicion(11,2));
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void seColocaUnidadDeUnJugadorEnLaMismaPosicionQueOtraYDaUnaExcepcion()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        jugador1.equipo(new EquipoBlanco());
        Juego.getInstance().agregarJugador(jugador1);

        Unidad unidad1 = new Soldado();
        Unidad unidad2 = new Jinete();
        unidad1.setEquipo(new EquipoBlanco());
        unidad2.setEquipo(new EquipoBlanco());

        // Act & Assert
        jugador1.colocarUnidadEn(unidad1,new Posicion(1,2));
        jugador1.colocarUnidadEn(unidad2,new Posicion(1,2));

    }

    @Test (expected = InsuficientePuntosRestantesAlColocarUnidadException.class)
    public void jugadorNoPuedeTomarMasUnidadesQueLoQueSusPuntosLePermiten ()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        jugador1.equipo(new EquipoBlanco());
        Juego.getInstance().agregarJugador(jugador1);

        // Act & Assert
        for(int i=0; i<7; i++){
            Unidad unidad = new Jinete();
            unidad.setEquipo(new EquipoBlanco());
            jugador1.colocarUnidadEn(unidad,new Posicion(1,i));
        }
    }

    @Test
    public void jugadorPierdeTodasSusUnidadesYElOtroJugadorGana()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        jugador1.equipo(new EquipoBlanco());
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        jugador2.equipo(new EquipoNegro());
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidadJ1 = new Soldado();
        Unidad unidadJ2 = new Jinete();
        unidadJ1.setEquipo(new EquipoBlanco());
        unidadJ2.setEquipo(new EquipoNegro());
        jugador1.colocarUnidadEn(unidadJ1,new Posicion(7,7));
        jugador2.colocarUnidadEn(unidadJ2,new Posicion(11,11));

        // Act
        try {
            for (int i = 0; i < 20; i++) {
                jugador2.atacarConUnidadAUnidad(unidadJ2, unidadJ1);
            }
        }catch (JugadorGanoLaPartida e) {
            assertEquals(e.jugadorGanador(),jugador2);
        }
    }

    @Test
    public void testEncuentraUnidadesAlrededorDeUnaUnidadYLasAgregaSoloSoldadosAlConjuntoDeSoldados () {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.equipo(new EquipoBlanco());
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.equipo(new EquipoBlanco());
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Soldado();
        Unidad unidad2 = new Jinete();
        Unidad unidad3 = new Soldado();
        Unidad unidad4 = new Curandero();
        unidad1.setEquipo(new EquipoBlanco());
        unidad2.setEquipo(new EquipoBlanco());
        unidad3.setEquipo(new EquipoBlanco());
        unidad4.setEquipo(new EquipoBlanco());
        jugador1.colocarUnidadEn(unidad1,new Posicion(7,7));
        jugador1.colocarUnidadEn(unidad2,new Posicion(6,7));
        jugador1.colocarUnidadEn(unidad3,new Posicion(8,7));
        jugador1.colocarUnidadEn(unidad4,new Posicion(7,8));

        ConjuntoDeUnidades unidadesQueDebeTirar = new ConjuntoDeUnidades();
        unidadesQueDebeTirar.agregar(unidad1);
        unidadesQueDebeTirar.agregar(unidad3);

        // Act
        ConjuntoDeUnidades soldados = new ConjuntoDeSoldados();
        soldados = Tablero.getInstance().obtenerUnidadesAlrededorDe(unidad4,5, soldados);

        // Assert
        assertEquals(true,soldados.equals( unidadesQueDebeTirar));
    }

    @Test
    public void jugadorMueveUnidadDuranteElJuegoPrincipalYPuedeHacerlo () {
        // Arrange
        Juego.getInstance().agregarJugador(new Jugador("Arkantos"));
        Juego.getInstance().agregarJugador(new Jugador("Gargarensis"));
        Jugador jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado1 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado1,new Posicion(7,7));
        Juego.getInstance().terminarTurno();
        jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        jugadorDeTurno.colocarUnidadEn(new Soldado(),new Posicion(11,11));
        Juego.getInstance().terminarDeColocarParaJugador();
        Juego.getInstance().terminarDeColocarParaJugador();


        // Act
        Juego.getInstance().moverUnidadHacia(soldado1, new Posicion (7,8 ));

        // Assert
        Posicion posicionFinal = Tablero.getInstance().obtenerPosicionDeUnidad(soldado1);
        assertEquals(posicionFinal.posicionEnX(),7);
        assertEquals(posicionFinal.posicionEnY(),8);
    }

    @Test(expected = JugadorYaMovioException.class)
    public void jugadorMueveUnidadDosVecesDuranteElJuegoPrincipalYTiraExcepcion () {
        // Arrange
        Juego.getInstance().agregarJugador(new Jugador("Arkantos"));
        Juego.getInstance().agregarJugador(new Jugador("Gargarensis"));
        Jugador jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado1 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado1,new Posicion(7,7));
        Juego.getInstance().terminarTurno();
        jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        jugadorDeTurno.colocarUnidadEn(new Soldado(),new Posicion(11,11));
        Juego.getInstance().terminarDeColocarParaJugador();
        Juego.getInstance().terminarDeColocarParaJugador();


        // Act & Assert
        Juego.getInstance().moverUnidadHacia(soldado1, new Posicion (7,8 ));
        Juego.getInstance().moverUnidadHacia(soldado1, new Posicion (8,8 ));
    }

    @Test
    public void jugadorAtacaDuranteElJuegoPrincipalYPuedeHacerlo () {
        // Arrange
        Juego.getInstance().agregarJugador(new Jugador("Arkantos"));
        Juego.getInstance().agregarJugador(new Jugador("Gargarensis"));
        Jugador jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado1 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado1,new Posicion(9,9));
        Juego.getInstance().terminarTurno();
        jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado2 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado2,new Posicion(11,11));
        Juego.getInstance().terminarDeColocarParaJugador();
        Juego.getInstance().terminarDeColocarParaJugador();

        // Act
        Juego.getInstance().atacarConUnidadAUnidad(soldado1, soldado2);

        // Assert
        assertEquals(soldado2.vida(), 90);
    }

    @Test (expected = JugadorYaAtacoException.class)
    public void jugadorAtacaDosVecesDuranteElJuegoPrincipalYTiraExcepcion () {
        // Arrange
        Juego.getInstance().agregarJugador(new Jugador("Arkantos"));
        Juego.getInstance().agregarJugador(new Jugador("Gargarensis"));
        Jugador jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado1 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado1,new Posicion(9,9));
        Juego.getInstance().terminarTurno();
        jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado2 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado2,new Posicion(11,11));
        Juego.getInstance().terminarDeColocarParaJugador();
        Juego.getInstance().terminarDeColocarParaJugador();

        // Act
        Juego.getInstance().atacarConUnidadAUnidad(soldado1, soldado2);
        Juego.getInstance().atacarConUnidadAUnidad(soldado1, soldado2);
    }

    @Test
    public void jugadorMueveYAtacaDuranteElJuegoPrincipalYPuedeHacerlo () {
        // Arrange
        Juego.getInstance().agregarJugador(new Jugador("Arkantos"));
        Juego.getInstance().agregarJugador(new Jugador("Gargarensis"));
        Jugador jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado1 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado1,new Posicion(9,9));
        Juego.getInstance().terminarTurno();
        jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado2 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado2,new Posicion(11,11));
        Juego.getInstance().terminarDeColocarParaJugador();
        Juego.getInstance().terminarDeColocarParaJugador();

        // Act
        Juego.getInstance().moverUnidadHacia(soldado1, new Posicion (10,10 ));
        Juego.getInstance().atacarConUnidadAUnidad(soldado1, soldado2);

        // Assert
        Posicion posicionFinal = soldado1.posicion();
        assertEquals(posicionFinal.posicionEnX(),10);
        assertEquals(posicionFinal.posicionEnY(),10);
        assertEquals(soldado2.vida(), 90);
    }

    @Test (expected = UnidadNoPerteneceAJugadorException.class)
    public void jugadorMueveUnidadDeOponenteYTiraExcepcion() {
        // Arrange
        Juego.getInstance().agregarJugador(new Jugador("Arkantos"));
        Juego.getInstance().agregarJugador(new Jugador("Gargarensis"));
        Jugador jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado1 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado1,new Posicion(9,9));
        Juego.getInstance().terminarTurno();
        jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado2 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado2,new Posicion(11,11));
        Juego.getInstance().terminarDeColocarParaJugador();
        Juego.getInstance().terminarDeColocarParaJugador();

        // Act
        Juego.getInstance().moverUnidadHacia(soldado2, new Posicion (10,10 ));

    }

    @Test
    public void jugadorMueveDondeUnaUnidadEstabaYPuedeHacerlo () {
        // Arrange
        Juego.getInstance().agregarJugador(new Jugador("Arkantos"));
        Juego.getInstance().agregarJugador(new Jugador("Gargarensis"));
        Jugador jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado1 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado1,new Posicion(9,9));
        Juego.getInstance().terminarTurno();
        jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad soldado2 =  new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldado2,new Posicion(10,10));
        Juego.getInstance().terminarDeColocarParaJugador();
        Juego.getInstance().terminarDeColocarParaJugador();

        // Act

        Juego.getInstance().moverUnidadHacia(soldado1, new Posicion (8,8 ));
        Juego.getInstance().terminarTurno();
        Juego.getInstance().moverUnidadHacia(soldado2, new Posicion (9,9 ));

        // Assert
        Posicion posicionFinal = soldado1.posicion();
        assertEquals(posicionFinal.posicionEnX(),8);
        assertEquals(posicionFinal.posicionEnY(),8);
        posicionFinal = soldado2.posicion();
        assertEquals(posicionFinal.posicionEnX(),9);
        assertEquals(posicionFinal.posicionEnY(),9);
    }

    @Test
    public void testCatapultaAliadaAtacaAUnidadEnemigaCon10PuntosDeVidaEnDistanciaLejanaLaMataYaNoEstaEnElTableroYLeQuita20PuntosDeVidaAUnidadesDeAlrededor() {
        //Arrange
        Juego.getInstance().agregarJugador(new Jugador("samid"));
        Juego.getInstance().agregarJugador(new Jugador("mauro viale"));

        Unidad unJinete = new Jinete();

        Posicion otraPosicion = new Posicion(11,11);
        Posicion posicionSoldado = new Posicion(12,11);
        Posicion posicionJinete = new Posicion(12,12);

        Jugador jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad catapultaAliada = new Catapulta();
        jugadorDeTurno.colocarUnidadEn(catapultaAliada, new Posicion(2,2));
        Juego.getInstance().terminarDeColocarParaJugador();
        jugadorDeTurno = Juego.getInstance().getJugadorDeTurno();
        Unidad catapultaEnemiga = new Catapulta();
        jugadorDeTurno.colocarUnidadEn(catapultaEnemiga, new Posicion(11,11));
        Juego.getInstance().terminarTurno();
        Unidad soldadoEnemigo = new Soldado();
        jugadorDeTurno.colocarUnidadEn(soldadoEnemigo, new Posicion(12,11));
        Juego.getInstance().terminarTurno();
        Juego.getInstance().terminarDeColocarParaJugador();

        //Act
        for(int i = 0; i <3; i++) {
            Juego.getInstance().atacarConUnidadAUnidad(catapultaAliada, catapultaEnemiga);
            Juego.getInstance().terminarTurno();
            Juego.getInstance().terminarTurno();
         }
        //Assert
        assertEquals(catapultaEnemiga.vida(), -10);
        assertEquals(soldadoEnemigo.vida(), 40);
    }

}
