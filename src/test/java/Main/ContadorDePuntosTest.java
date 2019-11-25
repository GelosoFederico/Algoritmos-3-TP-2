package Main;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import Main.Modelo.Juego.ContadorDePuntos;
import Main.Modelo.Unidad.Jinete;
import org.junit.Test;

public class ContadorDePuntosTest {
    @Test
    public void creoContadorYTieneTodosLosPuntosIniciales(){
        // Arrange
        ContadorDePuntos contador = new ContadorDePuntos();

        // Act
        // Assert
        assertEquals(contador.puntosRestantes(), 20);
    }

    @Test
    public void creoContadorYCuentaPuntosPorUnaUnidad() {
        // Arrange
        ContadorDePuntos contador = new ContadorDePuntos();
        Jinete jineteMock = mock(Jinete.class);
        when(jineteMock.coste()).thenReturn(3);

        // Act
        contador.contarPuntosDe(jineteMock);
        // Assert
        assertEquals(contador.puntosRestantes(), 17);
    }
}
