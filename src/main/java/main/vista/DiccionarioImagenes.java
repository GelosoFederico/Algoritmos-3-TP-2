package main.vista;

import javafx.scene.image.ImageView;
import main.modelo.unidad.*;

import java.util.Dictionary;
import java.util.Hashtable;

public class DiccionarioImagenes {
    private Dictionary dicc = new Hashtable();

    private static final int ALTURA_UNIDAD = 30;
    private static final int ANCHURA_UNIDAD = 30;

    private static String rutaSoldado = "file:src/recursos/img/soldado.png";
    private static String rutaJinete = "file:src/recursos/img/jinete.gif";
    private static String rutaCurandero = "file:src/recursos/img/curandero.png";
    private static String rutaCatapulta = "file:src/recursos/img/catapulta.gif";

    public DiccionarioImagenes() {
        dicc.put(Soldado.class,rutaSoldado);
        dicc.put(Jinete.class,rutaJinete);
        dicc.put(Curandero.class,rutaCurandero);
        dicc.put(Catapulta.class,rutaCatapulta);
        dicc.put(NullUnidad.class,"");
    }

    public ImageView get(Class className) {
         String ruta = (String)dicc.get(className);
        ImageView img;
         if(ruta.isEmpty()) {
             img = new ImageView();
         } else {
             img = new ImageView(ruta);
         }
         img.setFitHeight(ALTURA_UNIDAD);
         img.setFitWidth(ANCHURA_UNIDAD);
         return img;
    }
}
