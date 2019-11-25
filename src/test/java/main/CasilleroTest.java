package main;

import main.modelo.direccion.Posicion;
import main.modelo.excepciones.CasilleroOcupadoException;
import main.modelo.unidad.Soldado;
import main.modelo.tablero.Casillero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CasilleroTest {

        @Test (expected = CasilleroOcupadoException.class)
        public void testSeOcupaUnCasilleroYSeVerificaQueEsteOcupado() {
            Casillero unCasillero = new Casillero(new Posicion(1,1), 1);
            Soldado unSoldado = new Soldado();
            unCasillero.ocupar(unSoldado);
            // Para comprobar que esta ocupado, lo ocupo de nuevo y debe lanzar una excepcion
            unCasillero.ocupar(unSoldado);
        }




        @Test
        public void testSeLiberaUnCasilleroYSeVerificaQueEsteLiberado() {
            Casillero unCasillero = new Casillero(new Posicion(1,1), 1);
            Soldado unSoldado = new Soldado();
            unCasillero.ocupar(unSoldado);
            unCasillero.liberar();
            // Para comprobar que esta libre, lo ocupo de nuevo y no deberia pasar nada
            unCasillero.ocupar(unSoldado);
        }


}