package Main;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CasilleroTest {

        @Test
        public void testSeOcupaUnCasilleroYSeVerificaQueEsteOcupado() {
            Casillero unCasillero = new Casillero(new Posicion(1,1), 1); // TODO: Mockear
            unCasillero.ocupar();
            assertEquals(unCasillero.estado(),"ocupado");
        }
        @Test
        public void testSeLiberaUnCasilleroYSeVerificaQueEsteLiberado() {
            Casillero unCasillero = new Casillero(new Posicion(1,1), 1); // TODO: Mockear
            unCasillero.ocupar();
            unCasillero.liberar();
            assertEquals(unCasillero.estado(),"libre");

        }


}
