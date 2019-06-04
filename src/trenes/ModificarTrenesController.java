/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenes;

import MisClases.Trenes;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author omar
 */
public class ModificarTrenesController implements Initializable {

    ArrayList<Trenes> recorridos = null;
    int pointer = 0;
    
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtPotencia;
    @FXML
    private TextField txtVagones;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtID;
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnAtras;
    @FXML
    private Button btnFin;
    @FXML
    private Button btnAdelante;
    @FXML
    private Label lblIndice;
    @FXML
    private AnchorPane pane_modlocomotora;

    public void setRecorridos(ArrayList<Trenes> locomotoras) {
        this.recorridos = locomotoras;
        Trenes temp = locomotoras.get(pointer);
        this.txtModelo.setText(temp.getModelo());
        this.txtPotencia.setText(String.valueOf(temp.getPotencia()));
        this.txtVagones.setText(String.valueOf(temp.getVagones()));
        this.txtCiudad.setText(temp.getCiudad());
        this.txtID.setText(temp.getID());
        this.lblIndice.setText((pointer + 1) + "/" + locomotoras.size());

        txtModelo.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char tmp = event.getCharacter().charAt(0);

                if (!Character.isLetter(tmp)) {
                    event.consume();
                }
            }
        });
        
        txtPotencia.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char tmp = event.getCharacter().charAt(0);

                if (!Character.isDigit(tmp)) {
                    event.consume();
                }
            }
        });
        
        txtVagones.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char tmp = event.getCharacter().charAt(0);

                if (!Character.isDigit(tmp)) {
                    event.consume();
                }
            }
        });

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modificar(ActionEvent event) {
        try {
            recorridos.remove(pointer);
            String modelo = txtModelo.getText();
            int potencia = Integer.valueOf(txtPotencia.getText());
            int vagones = Integer.valueOf(txtVagones.getText());


            String ciudad = txtCiudad.getText();
            String ID = txtID.getText();
            Trenes nuevo = new Trenes(modelo, potencia, vagones, ID, ID);
            recorridos.add(this.pointer, nuevo);

            Alert msgC = new Alert(Alert.AlertType.INFORMATION);
            msgC.setTitle("¡ÉXITO!");
            msgC.setHeaderText("Ha modificado un tren correctamente");
            msgC.show();

        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("¡ERROR!");
            msgE.setHeaderText("Error al modificar los trenes :( ");
            msgE.show();
        }
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        this.pane_modlocomotora.setVisible(false);
    }

    @FXML
    private void Borrar(ActionEvent event) {
                try {
            recorridos.remove(pointer);

            txtModelo.setText("");
            txtPotencia.setText("");
            txtVagones.setText("");
            txtCiudad.setText("");
            txtID.setText("");

            Alert msgC = new Alert(Alert.AlertType.INFORMATION);
            msgC.setTitle("¡OBLITERADO!");
            msgC.setHeaderText("El tren seleccionado explotó, ya estarás "
                    + "contento");
            msgC.show();

        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("¡ERROR!");
            msgE.setHeaderText("No se pudo eliminar el tren");
            msgE.show();
        }
    }

    @FXML
    private void moverLista(ActionEvent event) {
        try {
            Trenes temp;
            if (event.getSource() == btnInicio) {
                pointer = 0;

                temp = recorridos.get(pointer);
                this.txtModelo.setText(temp.getModelo());
                this.txtPotencia.setText(String.valueOf(temp.getPotencia()));
                this.txtVagones.setText(String.valueOf(temp.getVagones()));
                this.txtCiudad.setText(temp.getCiudad());
                this.txtID.setText(temp.getID());
                this.lblIndice.setText((pointer + 1) + "/" + recorridos.size());
            }
            if (event.getSource() == btnAtras) {
                if ((pointer - 1) >= 0) {
                    pointer--;

                    temp = recorridos.get(pointer);
                    
                    this.txtModelo
                            .setText(temp.getModelo());
                    
                    this.txtPotencia
                            .setText(String.valueOf(temp.getPotencia()));
                    
                    this.txtVagones
                            .setText(String.valueOf(temp.getVagones()));
                    
                    this.txtCiudad
                            .setText(temp.getCiudad());
                    
                    this.txtID
                            .setText(temp.getID());
                    
                    this.lblIndice
                            .setText((pointer + 1) + "/" + recorridos.size());
                }
            }
            
            if (event.getSource() == btnAdelante) {
                if ((pointer + 1) < recorridos.size()) {
                    pointer++;

                    temp = recorridos.get(pointer);
                    
                    this.txtModelo
                            .setText(temp.getModelo());
                    
                    this.txtPotencia
                            .setText(String.valueOf(temp.getPotencia()));
                    
                    this.txtVagones
                            .setText(String.valueOf(temp.getVagones()));
                    
                    this.txtCiudad
                            .setText(temp.getCiudad());
                    
                    this.txtID
                            .setText(temp.getID());
                    
                    this.lblIndice.setText((pointer + 1) + "/" +
                            recorridos.size());
                }
            }
            
            if (event.getSource() == btnFin) {
                pointer = recorridos.size() - 1;

                temp = recorridos.get(pointer);
                
                this.txtModelo
                        .setText(temp.getModelo());
                
                this.txtPotencia
                        .setText(String.valueOf(temp.getPotencia()));
                
                this.txtVagones
                        .setText(String.valueOf(temp.getVagones()));
                
                this.txtCiudad
                        .setText(temp.getCiudad());
                
                this.txtID
                        .setText(temp.getID());
                
                this.lblIndice.setText((pointer + 1) + "/" + recorridos.size());
            }

        } catch (Exception ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("¡ERROR!");
            msg.setHeaderText("Ocurrió un error en la modificación "
                    + "de los trenes");
            msg.setContentText(ex.getMessage());
            msg.show();
        }
    }
    
}
