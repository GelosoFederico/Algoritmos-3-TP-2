package Main;

import Main.Direccion.Norte;
import Main.Direccion.Posicion;
import Main.Excepciones.CasilleroEsDeEnemigoException;
import Main.Excepciones.CasilleroOcupadoException;
import Main.Juego.Juego;
import Main.Juego.Jugador;
import Main.Tablero.Tablero;
import Main.Unidad.ConjuntoDeUnidades.ConjuntoDeUnidades;
import Main.Unidad.Soldado;
import Main.Unidad.Unidad;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TableroTest {

    @Before
    @After
    public void reiniciarTablero()
    {
        Tablero.getInstance().reiniciar();
    }
    @Test
    public void testSePuedeColocarUnidadDeJugador1EnCasilleroAliado() {
        Posicion posicion = new Posicion(1,1); // Area del jugador 1
        Jugador mJugador = mock(Jugador.class);
        Soldado mSoldado = mock(Soldado.class);
        when(mJugador.numero()).thenReturn(1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mSoldado,posicion,mJugador);
    }
    @Test(expected = CasilleroOcupadoException.class)
    public void testColocarUnidadEnCasilleroOcupadoTiraExcepcion() {
        Posicion posicion = new Posicion(1,2); // Area del jugador 1
        Jugador mJugador = mock(Jugador.class);
        Soldado soldado = new Soldado();
        when(mJugador.numero()).thenReturn(1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado,posicion,mJugador);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado,posicion,mJugador);
    }

    @Test(expected = CasilleroEsDeEnemigoException.class)
    public void testColocarUnidadDeJugador2EnCasilleroEnemigoTiraExcepcion() {
        Posicion posicion = new Posicion(1,3); // Area del jugador 1
        Jugador mJugador = mock(Jugador.class);
        Soldado mSoldado = mock(Soldado.class);
        when(mJugador.numero()).thenReturn(2);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mSoldado,posicion,mJugador);
    }

    @After
    public void reiniciarJuego()
    {
        Juego.getInstance().reiniciar();
    }
    @Test
    public void testUnidadEn13SeMueveEnUnaDireccionNorte() {
        // Assert
        Posicion posicion = new Posicion(1,3); // Area del jugador 1
        Jugador mJugador = mock(Jugador.class);
        Juego.getInstance().agregarJugador(mJugador);
        Unidad mSoldado = mock(Soldado.class);
        when(mJugador.numero()).thenReturn(1);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(mSoldado, posicion, mJugador);

        // Act
        Tablero.getInstance().moverUnidadEnDireccion(mSoldado,new Norte());
        when(mSoldado.posicion()).thenReturn(Tablero.getInstance().obtenerPosicionDeUnidad(mSoldado));
        when(mSoldado.posicion()).thenReturn(Tablero.getInstance().obtenerPosicionDeUnidad(mSoldado));


        // Assert
        assertEquals(mSoldado.posicion().posicionEnX(),0);
        assertEquals(mSoldado.posicion().posicionEnY(),3);
    }

    @Test
    public void testEncuentraUnidadesAlrededorDeUnaUnidadAUnaDistancia () {
        // Assert
        Jugador mJugador = mock(Jugador.class);
        when(mJugador.numero()).thenReturn(1);
        Juego.getInstance().agregarJugador(mJugador);

        Unidad mUnidad1 = mock(Soldado.class);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mUnidad1, new Posicion(3,3), mJugador);

        Unidad mUnidad2 = mock(Soldado.class);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mUnidad2, new Posicion(3,4), mJugador);

        Unidad mUnidad3 = mock(Soldado.class);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mUnidad3, new Posicion(3,2), mJugador);

        ConjuntoDeUnidades unidadesQueDebeTirar = new ConjuntoDeUnidades();
        unidadesQueDebeTirar.agregar(mUnidad2);
        unidadesQueDebeTirar.agregar(mUnidad3);

        // Act
        ConjuntoDeUnidades unidades = new ConjuntoDeUnidades();
        unidades = Tablero.getInstance().obtenerUnidadesAlrededorDe(mUnidad1,2, unidades);

        // Assert
        assertEquals(true,unidades.equals( unidadesQueDebeTirar));
    }

    @Test
    public void testEncuentraUnidadesAlrededorDeUnaUnidadAUnaDistanciaYExcluyeLasQueNoVan () {
        // Assert
        Jugador mJugador = mock(Jugador.class);
        when(mJugador.numero()).thenReturn(1);
        Juego.getInstance().agregarJugador(mJugador);

        Unidad mUnidad1 = mock(Soldado.class);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mUnidad1, new Posicion(3,3), mJugador);

        Unidad mUnidad2 = mock(Soldado.class);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mUnidad2, new Posicion(3,4), mJugador);

        Unidad mUnidad3 = mock(Soldado.class);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mUnidad3, new Posicion(8,8), mJugador);

        ConjuntoDeUnidades unidadesQueDebeTirar = new ConjuntoDeUnidades();
        unidadesQueDebeTirar.agregar(mUnidad2);

        // Act
        ConjuntoDeUnidades unidades = new ConjuntoDeUnidades();
        unidades = Tablero.getInstance().obtenerUnidadesAlrededorDe(mUnidad1,2, unidades);

        // Assert
        assertEquals(true,unidades.equals( unidadesQueDebeTirar));
    }

}
