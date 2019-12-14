package main.vista;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.controlador.HandlerTurnos;
import main.modelo.juego.Juego;
import main.modelo.juego.fase.FaseMoverYAtacar;

import java.io.File;

public class VistaPartida extends Group {
    private final Stage stage;
    private GridPaneTablero tablero;
    private VBox infoIzquierda;

    private static final int LONGITUD = 20;
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;


    public VistaPartida(Stage stage) {
        super();
        this.stage = stage;
        this.tablero = new GridPaneTablero();

        Media media = new Media(new File("src/recursos/sonidos/1-Kunio-kunnoNekketsuSoccerLeague.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        HBox root = new HBox(5);
        this.infoIzquierda = new VBox();
        String nombreJugador = Juego.getInstance().getJugadorDeTurno().nombre();
        this.infoIzquierda.getChildren().add(new Text(nombreJugador));
        String textoPuntos = Juego.getInstance().getJugadorDeTurno().puntosRestantes().toString();
        Text puntos = new Text("Puntos: ".concat(textoPuntos));
        this.infoIzquierda.getChildren().add(puntos);
        this.infoIzquierda.getChildren().add(new VBoxBotonesDeUnidades()) ;
        this.infoIzquierda.getChildren().add(new BotonTerminarColocar());
        root.getChildren().addAll( this.tablero, infoIzquierda);
        HandlerTurnos.setVistaPartida(this);

        Scene scene = new Scene(root);
        stage.setTitle("Eleccion de unidades");
        stage.setScene(scene);
        stage.show();
    }

    public void actualizar() {

        String nombreJugador = Juego.getInstance().getJugadorDeTurno().nombre();

        Text nombre = (Text)this.infoIzquierda.getChildren().get(0);
        nombre.setText(nombreJugador);

        String textoPuntos = Juego.getInstance().getJugadorDeTurno().puntosRestantes().toString();

        Text txt = (Text)this.infoIzquierda.getChildren().get(1);
        txt.setText("Puntos: ".concat(textoPuntos));

        if (Juego.getInstance().fase().getClass().equals(FaseMoverYAtacar.class))
            new VistaMoverAtacar(stage, tablero);
    }
}
