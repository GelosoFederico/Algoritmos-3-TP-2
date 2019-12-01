package main.vista;

import javafx.scene.image.ImageView;

import java.util.Dictionary;
import java.util.Hashtable;

public class DiccionarioImagenes {
    Dictionary dicc = new Hashtable();

    private static final int ALTURA_UNIDAD = 30;
    private static final int ANCHURA_UNIDAD = 30;

    public DiccionarioImagenes() {

        ImageView imgSoldado = new ImageView("file:src/soldado.png");
        imgSoldado.setFitHeight(ALTURA_UNIDAD);
        imgSoldado.setFitWidth(ANCHURA_UNIDAD);

        dicc.put("soldado",imgSoldado);
    }

    public ImageView get(String string) {
        return  (ImageView)dicc.get(string);
    }
}
