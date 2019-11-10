package Main;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CasilleroTest {

        @Test (expected = CasilleroOcupadoException.class)
        public void testSeOcupaUnCasilleroYSeVerificaQueEsteOcupado() {
            Casillero unCasillero = new Casillero(new Posicion(1,1), 1);
            unCasillero.ocupar();
            // Para comprobar que esta ocupado, lo ocupo de nuevo y debe lanzar una excepcion
            unCasillero.ocupar();
        }
        @Test
        public void testSeLiberaUnCasilleroYSeVerificaQueEsteLiberado() {
            Casillero unCasillero = new Casillero(new Posicion(1,1), 1);
            unCasillero.ocupar();
            unCasillero.liberar();
            // Para comprobar que esta libre, lo ocupo de nuevo y no deberia pasar nada
            unCasillero.ocupar();
        }


}
