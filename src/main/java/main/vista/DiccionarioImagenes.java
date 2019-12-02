package main.vista;

import javafx.scene.image.ImageView;
import main.modelo.unidad.Catapulta;
import main.modelo.unidad.Curandero;
import main.modelo.unidad.Jinete;
import main.modelo.unidad.Soldado;

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

        ImageView imgJinete = new ImageView("file:src/jinete.gif");
        imgJinete.setFitHeight(ALTURA_UNIDAD);
        imgJinete.setFitWidth(ANCHURA_UNIDAD);

        ImageView imgCurandero = new ImageView("file:src/curandero.jpg");
        imgCurandero.setFitHeight(ALTURA_UNIDAD);
        imgCurandero.setFitWidth(ANCHURA_UNIDAD);

        ImageView imgCatapulta = new ImageView("file:src/catapulta.gif");
        imgCatapulta.setFitHeight(ALTURA_UNIDAD);
        imgCatapulta.setFitWidth(ANCHURA_UNIDAD);

        dicc.put(Soldado.class,imgSoldado);
        dicc.put(Jinete.class,imgJinete);
        dicc.put(Curandero.class,imgCurandero);
        dicc.put(Catapulta.class,imgCatapulta);
    }

    public ImageView get(Class className) {
        return  (ImageView)dicc.get(className);
    }
}
