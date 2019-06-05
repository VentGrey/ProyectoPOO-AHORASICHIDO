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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author omar
 */
public class ModificarMaquinistaController implements Initializable {

    ArrayList<Maquinistas> maquinistas = null;
    private int count = 0;
    
    @FXML
    private AnchorPane modificar_maquinista;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApPaterno;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtApMaterno;
    @FXML
    private TextField txtAntiguedad;
    @FXML
    private Label lblIndice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

public void setMaquinistas(ArrayList<Maquinistas> maquinistas) {
        this.maquinistas = maquinistas;
      
        Maquinistas temp = maquinistas.get(count);
        
        this.txtNombre.setText(temp.getNombre());
        this.txtApPaterno.setText(temp.getApPaterno());
        this.txtCedula.setText(String.valueOf(temp.getCedula()));
        this.txtApMaterno.setText(temp.getApMaterno());
        this.txtAntiguedad.setText(String.valueOf(temp.getAntiguedad()));
        this.lblIndice.setText((count + 1) + "/" + maquinistas.size());
        
        txtNombre.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);
                
                if (!Character.isLetter(car)){
                    event.consume();
                }
            }
        });
        
        txtApPaterno.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);
                
                if (!Character.isLetter(car)){
                    event.consume();
                }
            }
        });
        
        txtApMaterno.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);
                
                if (!Character.isLetter(car)){
                    event.consume();
                }
            }
        });
        txtCedula.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);
                
                if (!Character.isDigit(car)){
                    event.consume();
                }
            }
        });
        
        txtAntiguedad.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);
                
                if (!Character.isDigit(car)){
                    event.consume();
                }
            }
        });
    }

    
    @FXML
    private void Modificar(ActionEvent event) {
        try {
            maquinistas.remove(count);
            
            // De nuevo el super-hack para mochar cualquier cosa después del 
            // carácter 15. Quiero pensar que no es ilegal usarlo.
            String nombre = txtNombre.getText().substring(0,15);
            String apPaterno = txtApPaterno.getText().substring(0,15);
            String cedula = txtCedula.getText();
            String ApMaterno = txtApMaterno.getText().substring(0,15);
            String antiguedad = txtAntiguedad.getText();
            Maquinistas nuevo = new Maquinistas(nombre, apPaterno, cedula, 
                    ApMaterno, antiguedad);
            maquinistas.add(this.count, nuevo);

            Alert msgC = new Alert(Alert.AlertType.INFORMATION);
            msgC.setTitle("¡MODIFICADO!");
            msgC.setHeaderText("Se ha modificado un maquinista");
            msgC.show();

        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("¡ERROR!");
            msgE.setHeaderText("Ocurrió un error al modificar un maquinista,"
                    + " por favor revise sus datos e inténtelo de nuevo");
            msgE.show();
        }
    }

    @FXML
    private void cerrar_ventana(ActionEvent event) {
        this.modificar_maquinista.setVisible(false);
    }

    @FXML
    private void Eliminar(ActionEvent event) {
        try {
            maquinistas.remove(count);

            txtNombre.setText("");
            txtApPaterno.setText("");
            txtCedula.setText("");
            txtApMaterno.setText("");
            txtAntiguedad.setText("");

            Alert msgC = new Alert(Alert.AlertType.INFORMATION);
            msgC.setTitle("¡OBLITERADO!");
            msgC.setHeaderText("El maquinista se murió y lo borramos de nuestra"
                    + " base de datos.");
            msgC.show();

        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("¡ERROR!");
            msgE.setHeaderText("No se pudo aniquilar al maquinista, algo"
                    + " hiciste mal.");
            msgE.show();
        }
    }

    @FXML
    private void inicio(ActionEvent event) {
        count = 0;
        
        Maquinistas temp = maquinistas.get(count);
        
        this.txtNombre.setText(temp.getNombre());
        this.txtApPaterno.setText(temp.getApPaterno());
        this.txtCedula.setText(String.valueOf(temp.getCedula()));
        this.txtApMaterno.setText(temp.getApMaterno());
        this.txtAntiguedad.setText(String.valueOf(temp.getAntiguedad()));
        this.lblIndice.setText((count + 1) + "°" + maquinistas.size());
    }

    @FXML
    private void retrocede(ActionEvent event) {
        if ((count - 1) >= 0) {
            count--;
            Maquinistas temp = maquinistas.get(count);
            this.txtNombre.setText(temp.getNombre());
            this.txtApPaterno.setText(temp.getApPaterno());
            this.txtCedula.setText(String.valueOf(temp.getCedula()));
            this.txtApMaterno.setText(temp.getApMaterno());
            this.txtAntiguedad.setText(String.valueOf(temp.getAntiguedad()));
            this.lblIndice.setText((count + 1) + "°" + maquinistas.size());
        }
    }

    @FXML
    private void fin(ActionEvent event) {
        count = maquinistas.size() - 1;
        Maquinistas temp = maquinistas.get(count);
        this.txtNombre.setText(temp.getNombre());
        this.txtApPaterno.setText(temp.getApPaterno());
        this.txtCedula.setText(String.valueOf(temp.getCedula()));
        this.txtApMaterno.setText(temp.getApMaterno());
        this.txtAntiguedad.setText(String.valueOf(temp.getAntiguedad()));
        this.lblIndice.setText((count + 1) + "°" + maquinistas.size());
    }

    @FXML
    private void avanza(ActionEvent event) {
        if ((count + 1) < maquinistas.size()) {
            count++;
            Maquinistas temp = maquinistas.get(count);
            this.txtNombre.setText(temp.getNombre());
            this.txtApPaterno.setText(temp.getApPaterno());
            this.txtCedula.setText(String.valueOf(temp.getCedula()));
            this.txtApMaterno.setText(temp.getApMaterno());
            this.txtAntiguedad.setText(String.valueOf(temp.getAntiguedad()));
            this.lblIndice.setText((count + 1) + "°" + maquinistas.size());
        }
    }
    
}
