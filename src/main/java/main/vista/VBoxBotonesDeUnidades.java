package main.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VBoxBotonesDeUnidades extends VBox {
    private static final int SPACING = 5;
    private static final int INSETS_BORDERS = 10;
    public VBoxBotonesDeUnidades() {
        this.setSpacing(SPACING);
        this.setPadding(new Insets(INSETS_BORDERS));
        this.setAlignment(Pos.BASELINE_RIGHT);

        this.getChildren().addAll(new BotonElegirSoldado(),
                new BotonElegirJinete(),
                new BotonElegirCatapulta(),
                new BotonElegirCurandero());

    }
}
