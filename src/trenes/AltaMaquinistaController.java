/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenes;

import MisClases.Maquinistas;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author omar
 */
public class AltaMaquinistaController implements Initializable {

    private ArrayList<Maquinistas> maquinistas = null;
    private FXMLDocumentController padre;
    
    @FXML
    private Button btnAceptar;
    @FXML
    private TextField txtApPaterno;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtApMaterno;
    @FXML
    private TextField txtAntiguedad;
    @FXML
    private Button btnCancelar;
    @FXML
    private AnchorPane pane_alta_maquinistas;

    public void setPadre(FXMLDocumentController padre) {
        this.padre = padre;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    // La neta no se que hace esto lejos del handle, créditos a StackOverflow y
    // a Smith por explicarme cómo demonios hacer esto.
    public void setMaquinistas(ArrayList<Maquinistas> maquinistas) {
        this.maquinistas = maquinistas;
        txtNombre.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char key = event.getCharacter().charAt(0);

                if (!Character.isLetter(key)) {
                    event.consume();
                }
            }
        });
        
        txtApPaterno.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char key = event.getCharacter().charAt(0);

                if (!Character.isLetter(key)) {
                    event.consume();
                }
            }
        });
        
        txtApMaterno.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char key = event.getCharacter().charAt(0);

                if (!Character.isLetter(key)) {
                    event.consume();
                }
            }
        });
        
        txtCedula.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char key = event.getCharacter().charAt(0);

                if (!Character.isDigit(key)) {
                    event.consume();
                }
                
                    
            }
        });
        txtAntiguedad.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);

                if (!Character.isDigit(car)) {
                    event.consume();
                }
            }
        });
    }

    public ArrayList<Maquinistas> getMaquinistas() {
        return maquinistas;
    }

    public Button getBtnAceptar() {
        return btnAceptar;
    }
    
    @FXML
    public void alta_maquinistas() {
       
            // Sacar textos de los textfield
            String nombre = txtNombre.getText();   
            String apPaterno = txtApPaterno.getText();
            String cedula = txtCedula.getText();
            String apMaterno = txtApMaterno.getText();
            String antiguedad = txtAntiguedad.getText();

            Boolean Validar = true;
            
             if (!nombre.matches("[A-Za-z]+")){
            Validar = false;
            Alert Message = new Alert (Alert.AlertType.INFORMATION);
            Message.setTitle("Error");
            Message.setHeaderText("Nombre inválido");
            Message.showAndWait();
            //validate = false;
        }

        if (!apPaterno.matches("[A-Za-z]+")){
            Validar = false;
            Alert Message = new Alert (Alert.AlertType.INFORMATION);
            Message.setTitle("Error");
            Message.setHeaderText("Apellido paterno inválido");
            Message.showAndWait();
            //validate = false;
        }

        if (!apMaterno.matches("[A-Za-z]+")){
            Validar = false;
            Alert Message = new Alert (Alert.AlertType.INFORMATION);
            Message.setTitle("Error");
            Message.setHeaderText("Apellido materno inválido");
            Message.showAndWait();
            //validate = false;
        }

        if (!cedula.matches("[0-9]+")){
            Validar = false;
            Alert Message = new Alert (Alert.AlertType.INFORMATION);
            Message.setTitle("Error");
            Message.setHeaderText("Cédula inválida");
            Message.showAndWait();
            //validate = false;
        } else {
        }

        if (!antiguedad.matches("[0-9]+")){
            Validar = false;
            Alert Message = new Alert (Alert.AlertType.INFORMATION);
            Message.setTitle("Error");
            Message.setHeaderText("Antigüedad inválida");
            Message.showAndWait();
            //validate = false;
        }

        if (Validar == true){
            int cedulatmp = Integer.valueOf(cedula);
            int antiguedadtmp = Integer.valueOf(antiguedad);
            
            // Objeto creado
            Maquinistas temporal = new Maquinistas(nombre, apPaterno, 
                    apMaterno, cedula, antiguedad);
            
            this.maquinistas.add(temporal);

        }
            

            txtNombre.setText("");
            txtApPaterno.setText("");
            txtCedula.setText("");
            txtApMaterno.setText("");
            txtAntiguedad.setText("");

            Alert msgC = new Alert(Alert.AlertType.INFORMATION);
            msgC.setTitle("¡Exito!");
            msgC.setHeaderText("Se agregó un maquinista al registro actual");
            msgC.show();
    }

    @FXML
    public void cerrar_ventana() {
                this.pane_alta_maquinistas.setVisible(false);
    }
    
}
