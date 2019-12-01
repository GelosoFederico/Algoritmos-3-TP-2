package main.controlador;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;

public class HandlerSonidos {
    private static HandlerSonidos INSTANCE;

    private Dictionary<String, String> diccionarioSonidos;

    private HandlerSonidos() {
        this.diccionarioSonidos = this.crearDiccionario();
    }

    public static HandlerSonidos getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new HandlerSonidos();
        }
        return INSTANCE;
    }


    public void reproducirSonido(String clave) {

        String filename = this.diccionarioSonidos.get(clave);
        File file = new File(filename);
        Media sound = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    private Dictionary crearDiccionario() {
        Dictionary<String, String> diccionario = new Hashtable<String, String>();
        diccionario.put("Agregar Jugador","src/chat.wav");
        diccionario.put("Crear Soldado","src/military_spawn.wav");
        diccionario.put("Crear Jinete","src/horseselect1.wav");
        diccionario.put("Crear Catapulta","src/mangonelselect.wav");
        diccionario.put("Crear Curandero","src/priest_converting2.wav");

        return diccionario;
    }
}
