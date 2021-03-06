package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.*;




public class Controller extends Component {

    public TextArea Text;
    double Fuente  = 14;
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

    public void Ayuda (ActionEvent actionEvent){


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info sobre el programa");
        alert.setHeaderText("Info ");
        alert.setContentText("Para El tamaño de texto se modifica en opciones => Tamaño \n"
                + "El tipo de fuente se modifica en Opciones => Fuente \n"
                +"Para Abrir un nuevo archivo Fitxer => Abrir \n"
                +"Para Guardar Fitxer => Guardar \n ");
        alert.getDialogPane().setPrefSize(480, 320);
        alert.setResizable(true);
        alert.showAndWait();

    }
    public String Abrir(ActionEvent actionEvent) throws IOException{
        String auxiliar="";
        String texto="";
        String marcado = "";


        try
        {

            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);

            File abre=file.getSelectedFile();

            marcado = abre.getName();
            Stage stage = (Stage)Text.getScene().getWindow();
            stage.setTitle(marcado);

            if(abre!=null)
            {
                FileReader archivos=new FileReader(abre);
                BufferedReader lee=new BufferedReader(archivos);
                while((auxiliar=lee.readLine())!=null)
                {
                    texto+= auxiliar+ "\n";
                    Text.setText(texto);

                }
                lee.close();
            }
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,ex+" \nNo s'ha trobat l'arxiu", "Atenció!",JOptionPane.WARNING_MESSAGE);
        }
        return texto;

    }

    public void Guardar(ActionEvent actionEvent) {

        try
        {
            String nombre="";
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(this);
            File guarda =file.getSelectedFile();

            if(guarda !=null)
            {
                FileWriter save=new FileWriter(guarda);
                save.write(Text.getText());
                save.close();
            }

        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "L'arxiu no s'ha guardat", "Atenció",JOptionPane.WARNING_MESSAGE);
        }
    }


}

