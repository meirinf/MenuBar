package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;


public class Controller {

    public TextArea Text;
    double Fuente  = 11;
    String TFuente = "FreeMono";

    public void close(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void Copiar(ActionEvent actionEvent) {
        Text.copy();
    }
    public void Pegar(ActionEvent actionEvent) {
        Text.paste();
    }
    public void Cortar(ActionEvent actionEvent) {
        Text.cut();
    }
    public void Deshacer(ActionEvent actionEvent) {
        Text.undo();
    }

    public void on  (ActionEvent actionEvent){
        Text.setFont(Font.font(TFuente,11));
        Fuente = 11;

    }
    public void do2 (ActionEvent actionEvent){
        Text.setFont(Font.font(TFuente,12));
        Fuente = 12;

    }


    public void cat (ActionEvent actionEvent){
            Text.setFont(Font.font(TFuente,14));
            Fuente = 14;

    }

    public void FreeMono (ActionEvent actionEvent) {
        Text.setFont(Font.font("FreeMono", Fuente));
        TFuente = "FreeMono";
    }
    public void Cantarell (ActionEvent actionEvent) {
        Text.setFont(Font.font("Cantarell", Fuente));
        TFuente = "Cantarell";
    }
    public void cmsy10 (ActionEvent actionEvent){
        Text.setFont(Font.font("cmsy10", Fuente));
        TFuente = "cmsy10";
    }



}

