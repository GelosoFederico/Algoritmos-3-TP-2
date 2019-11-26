package Main.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VistaPartida extends Group {
    private final Stage stage;
    private GridPane tablero;

    private static final int LONGITUD = 20;
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;


    public VistaPartida(Stage stage) {
        super();
        this.stage = stage;
        this.tablero = this.crearTabla();

        Scene scene = new Scene(this.tablero);
        stage.setScene(scene);
        stage.show();
    }

    public GridPane crearTabla() {
        GridPane grid = new GridPane();
        for(int i=0; i< LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++){
                ImageView imagenCasillero;
                grid.add(imagenCasillero = new ImageView("file:src/imagenCasillero.png"), i, j);
                imagenCasillero.setFitHeight(ALTURA_CASILLERO);
                imagenCasillero.setFitWidth(ANCHURA_CASILLERO);
            }
        }

        return grid;
    }

    public HBox crearBotonesDeUnidades() {
        HBox opcionesUnidades = new HBox(5);
        opcionesUnidades.setPadding(new Insets(10));
        opcionesUnidades.setAlignment(Pos.BASELINE_RIGHT);

        opcionesUnidades.getChildren().addAll(new main.vista.BotonElegirSoldado(),
                new main.vista.BotonElegirJinete(),
                new main.vista.BotonElegirCatapulta(),
                new main.vista.BotonElegirCurandero());
        return opcionesUnidades;
    }

    /*
    public void actualizar() {

    }

     */

}
