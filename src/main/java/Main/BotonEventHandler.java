package Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonEventHandler implements EventHandler<ActionEvent> {

    private TextField textField;

    public BotonEventHandler(TextField textField) {
        this.textField = textField;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.textField.setText("");
        this.textField.requestFocus();
    }
}
