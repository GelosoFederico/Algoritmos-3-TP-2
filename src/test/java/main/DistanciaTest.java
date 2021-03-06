package main;

import main.modelo.tablero.distancia.Posicion;
import main.modelo.juego.*;
import main.modelo.tablero.distancia.Distancia;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.*;
import org.junit.*;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class DistanciaTest {
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
    public void obtengoDistanciaEntre2UnidadesYSeObtieneCorrectamente() {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Soldado();
        Unidad unidad2 = new Jinete();
        unidad1.setEquipo(new EquipoBlanco());
        unidad2.setEquipo(new EquipoNegro());
        // Act
        jugador1.colocarUnidadEn(unidad1,new Posicion(1,2));
        jugador2.colocarUnidadEn(unidad2,new Posicion(10,11));

        Distancia distancia = Tablero.getInstance().calcularDistanciaEntre(unidad1, unidad2);

        // Assert
        assertEquals(distancia.distanciaExacta(),9);

    }
}
