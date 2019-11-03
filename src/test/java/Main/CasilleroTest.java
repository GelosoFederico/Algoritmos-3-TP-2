package Main;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;

//@RunWith(Arquillian.class)

public class CasilleroTest {
  //  @Deployment
 /*   public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Casillero.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/


        @Test
        public void testSeOcupaUnCasilleroYSeVerificaQueEsteOcupado() {

            Pieza unaPieza = new Pieza();
            Casillero unCasillero = new Casillero(new Posicion(1,1), 1); // TODO: Mockear

            unCasillero.ocuparCasillero(unaPieza);

            assertEquals(unCasillero.estado(),"ocupado");

        }
        @Test
        public void testSeLiberaUnCasilleroYSeVerificaQueEsteLiberado() {

            Pieza unaPieza = new Pieza();
            Casillero unCasillero = new Casillero(new Posicion(1,1), 1); // TODO: Mockear

            unCasillero.ocuparCasillero(unaPieza);
            unCasillero.liberarCasillero();

            assertEquals(unCasillero.estado(),"libre");

        }


}
