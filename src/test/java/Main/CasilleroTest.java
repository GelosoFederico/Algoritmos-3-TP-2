package Main;

import Main.Direccion.Posicion;
import Main.Excepciones.CasilleroOcupadoException;
import Main.Juego.Equipo;
import Main.Juego.EquipoBlanco;
import Main.Unidad.Soldado;
import Main.Tablero.Casillero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CasilleroTest {

        @Test (expected = CasilleroOcupadoException.class)
        public void testSeOcupaUnCasilleroYSeVerificaQueEsteOcupado() {
            Equipo equipo = new EquipoBlanco();
            Casillero unCasillero = new Casillero(new Posicion(1,1), equipo);
            Soldado unSoldado = new Soldado();
            unCasillero.ocupar(unSoldado);
            // Para comprobar que esta ocupado, lo ocupo de nuevo y debe lanzar una excepcion
            unCasillero.ocupar(unSoldado);
        }




        @Test
        public void testSeLiberaUnCasilleroYSeVerificaQueEsteLiberado() {
            Equipo equipo = new EquipoBlanco();
            Casillero unCasillero = new Casillero(new Posicion(1,1), equipo);
            Soldado unSoldado = new Soldado();
            unCasillero.ocupar(unSoldado);
            unCasillero.liberar();
            // Para comprobar que esta libre, lo ocupo de nuevo y no deberia pasar nada
            unCasillero.ocupar(unSoldado);
        }


}
