package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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

    }
    public String Abrir(ActionEvent actionEvent) throws IOException{
        String aux="";
        String texto="";
        String title= "";

        try
        {

            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);

            File abre=file.getSelectedFile();

            title = abre.getName();
            Stage stage = (Stage)Text.getScene().getWindow();
            stage.setTitle(title);

            if(abre!=null)
            {
                FileReader archivos=new FileReader(abre);
                BufferedReader lee=new BufferedReader(archivos);
                while((aux=lee.readLine())!=null)
                {
                    texto+= aux+ "\n";
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

