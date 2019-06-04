/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenes;

import MisClases.Maquinistas;
import MisClases.Trenes;
import MisClases.Viajes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author omar
 */
public class FXMLDocumentController implements Initializable {
    
    
    ArrayList<Maquinistas> Maquinistas = new ArrayList<>();
    ArrayList<Trenes> Trenes = new ArrayList<>();
    ArrayList<Viajes> Viajes = new ArrayList<>();
    
    private Label label;
    @FXML
    private BorderPane Border;
    @FXML
    private MenuItem btnGuardarMaquinista;
    @FXML
    private MenuItem btnAbrirMaquinista;
    @FXML
    private MenuItem btnGuardarTrenes;
    @FXML
    private MenuItem btnAbrirTrenes;
    @FXML
    private MenuItem btnAltaMaquinista;
    @FXML
    private MenuItem btnAltaTren;
    @FXML
    private MenuItem btnModMaquinista;
    @FXML
    private MenuItem btnModTrenes;
    @FXML
    private MenuItem btnBusqMaquinista;
    @FXML
    private MenuItem btnBusqTrenes;
    @FXML
    private MenuItem btnViaje;
    @FXML
    private MenuItem btnGuardarViajes;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void alta_maquinista() {
        this.Border.setCenter(null);
        FXMLLoader lectorAlta = new FXMLLoader(getClass()
                .getResource("AltaMaquinista.fxml"));
        Pane paneAltaGuia = null;
        try {
            paneAltaGuia = (Pane) lectorAlta.load();
        } catch (IOException e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("ERROR");
            msgE.setHeaderText("ERROR");
            msgE.show();
        }
        AltaMaquinistaController altaControl = lectorAlta.getController();
        altaControl.setMaquinistas(Maquinistas);
        this.Border.setCenter(paneAltaGuia);
    }

    @FXML
    private void guardar_maquinista() {
        try {
            try {

                FileWriter fw = new FileWriter("MAQUINISTAS.opth");
                PrintWriter escritor = new PrintWriter(fw);
                escritor.println(Maquinistas.size());
                for (int i = 0; i < Maquinistas.size(); i++) {
                    Maquinistas temp = Maquinistas.get(i);
                    escritor.println(temp.getNombre());
                    escritor.println(temp.getApPaterno());
                    escritor.println(temp.getCedula());
                    escritor.println(temp.getApMaterno());
                    escritor.println(temp.getAntiguedad());
                }
                escritor.close();
                Alert msgE = new Alert(Alert.AlertType.INFORMATION);
                msgE.setTitle("¡ÉXITO!");
                msgE.setHeaderText("Se guardo el maquinista correctamente");
                msgE.show();
            } catch (IOException e) {
                Alert msgE = new Alert(Alert.AlertType.ERROR);
                msgE.setTitle("¡ERROR!");
                msgE.setHeaderText("NO ES POSIBLE GUARDAR");
                msgE.show();
            }
        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("No hay registros existentes");
            msgE.setHeaderText("Por favor cree registros antes de picar esto");
            msgE.show();
        }
    }

    @FXML
    private void abrir_maquinista(ActionEvent event) {
                try {
            FileReader fr = new FileReader("MAQUINISTAS.opth");
            BufferedReader lector = new BufferedReader(fr);
            int tam = Integer.valueOf(lector.readLine());
            
            for (int i = 0; i < tam; i++) {
                String Nombre = lector.readLine();
                String ApPaterno = lector.readLine();
                int Cedula = Integer.valueOf(lector.readLine());
                String ApMaterno = lector.readLine();
                int Antiguedad = Integer.valueOf(lector.readLine());
                Maquinistas temp = new Maquinistas(Nombre, ApPaterno, Cedula, 
                        ApMaterno, Antiguedad);
                this.Maquinistas.add(temp);
            }
            
            lector.close();
            Alert msgE = new Alert(Alert.AlertType.INFORMATION);
            msgE.setTitle("¡ARCHIVO ABIERTO!");
            msgE.setHeaderText("Se abrió correctamente el archivo");
            msgE.show();

        } catch (FileNotFoundException e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("ERROR");
            msgE.setHeaderText("No se pudo abrir el archivo");
            msgE.show();
        } catch (IOException e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("ERROR FATAL! D:");
            msgE.setHeaderText("ESTE ERROR ES LO PEOR QUE TE PUEDE PASAR!"
                    + " RESPALDA TUS COSAS Y REVISA TU DISCO QUE LE QUEDA"
                    + " MENOS TIEMPO DE VIDA QUE A JAVA AWT");
            msgE.show();
        }
    }

    @FXML
    private void guardar_trenes(ActionEvent event) {
        try {
            try {

                FileWriter fw = new FileWriter("Trenes.xprss");
                PrintWriter escritor = new PrintWriter(fw);

                escritor.println(Trenes.size());
                for (int i = 0; i < Trenes.size(); i++) {
                    Trenes temp = Trenes.get(i);
                    escritor.println(temp.getModelo());
                    escritor.println(temp.getPotencia());
                    escritor.println(temp.getVagones());
                    escritor.println(temp.getCiudad());
                    escritor.println(temp.getID());
                }
                escritor.close();
                Alert msgE = new Alert(Alert.AlertType.INFORMATION);
                msgE.setTitle("Guardado");
                msgE.setHeaderText("Se guardo correctamente");
                msgE.show();
            } catch (IOException e) {
                Alert msgE = new Alert(Alert.AlertType.ERROR);
                msgE.setTitle("Error");
                msgE.setHeaderText("No es posible guardar");
                msgE.show();
            }
        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("No hay nada");
            msgE.setHeaderText("Por favor cree un archivo");
            msgE.show();
        }
    }

    @FXML
    private void abrir_trenes(ActionEvent event) {
              try {
            FileReader fr = new FileReader("Trenes.xprss");
            BufferedReader lector = new BufferedReader(fr);
            int tam = Integer.valueOf(lector.readLine());
            for (int i = 0; i < tam; i++) {
                String modelo = lector.readLine();
                int potencia = Integer.valueOf(lector.readLine());
                int vagones = Integer.valueOf(lector.readLine());
                String ciudad = lector.readLine();
                String ID = lector.readLine();
                Trenes temp = new Trenes(modelo, potencia, vagones, ciudad, ID);
                this.Trenes.add(temp);
            }
            
            lector.close();
            Alert msgE = new Alert(Alert.AlertType.INFORMATION);
            msgE.setTitle("EXITO");
            msgE.setHeaderText("Se abrió el tren");
            msgE.show();

        } catch (FileNotFoundException e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("ERROR");
            msgE.setHeaderText("No se pudo abrir");
            msgE.show();
        } catch (IOException e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("Error");
            msgE.setHeaderText("ERROR CRÍTICO, REEMPLAZE SU UNIDAD YA");
            msgE.show();
        }
    }

    @FXML
    private void alta_tren(ActionEvent event) {
        this.Border.setCenter(null);
        FXMLLoader lector = new FXMLLoader(getClass()
                .getResource("FXMLAlta_Tren.fxml"));
        Pane paneAltaTren = null;
        try {
            paneAltaTren = (Pane) lector.load();
        } catch (IOException e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("ERROR");
            msgE.setHeaderText("No se pudo abrir el tren");
            msgE.show();
        }
        Alta_TrenController altaRecorrido = lector.getController();
        altaRecorrido.setTrenes(Trenes);
        this.Border.setCenter(paneAltaTren);
    }

    @FXML
    private void mod_maquinista(ActionEvent event) {
                try {
            this.Border.setCenter(null);
            FXMLLoader cargarModMaquinista = new FXMLLoader(getClass()
                    .getResource("FXMLModificar_Maquinista.fxml"));
            Pane pane = null;
            try {
                pane = (Pane) cargarModMaquinista.load();
            } catch (IOException ex) {
                Alert msgE = new Alert(Alert.AlertType.ERROR);
                msgE.setTitle("ERROR");
                msgE.setHeaderText("ERROR");
                msgE.show();
            }
            ModificarMaquinistaController mod_maquinista 
                    = cargarModMaquinista.getController();
            mod_maquinista.setMaquinistas(Maquinistas);
            this.Border.setCenter(pane);
        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("No hay ningún registro");
            msgE.setHeaderText("Cree un registro primero");
            msgE.show();
        }

    }

    @FXML
    private void mod_trenes(ActionEvent event) {
        try {
            this.Border.setCenter(null);
            FXMLLoader cargarModTren = new FXMLLoader(getClass()
                    .getResource("FXMLMod_Tren.fxml"));
            Pane pane = null;
            try {
                pane = (Pane) cargarModTren.load();
            } catch (IOException ex) {
                Alert msgE = new Alert(Alert.AlertType.ERROR);
                msgE.setTitle("Error");
                msgE.setHeaderText("No se pudo abrir");
                msgE.show();
            }
            ModificarTrenesController modMaquinista = 
                    cargarModTren.getController();
            
            modMaquinista.setRecorridos(Trenes);
            this.Border.setCenter(pane);
        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("No hay registros");
            msgE.setHeaderText("Por favor abra un archivo o haga nuevos "
                    + "registros");
            msgE.show();
        }
    }

    @FXML
    private void bus_maquinistas(ActionEvent event) {
        try {
            this.Border.setCenter(null);
            FXMLLoader cargar_BuscarMaquinista = new FXMLLoader(getClass()
                    .getResource("FXMLBuscar_Maquinista.fxml"));
            AnchorPane pane = null;
            try {
                pane = (AnchorPane) cargar_BuscarMaquinista.load();
            } catch (IOException ex) {
                Alert msgE = new Alert(Alert.AlertType.ERROR);
                msgE.setTitle("Error");
                msgE.setHeaderText("No se pudo abrir");
                msgE.show();
            }
            BuscarMaquinistaController BuscarGuia =
                    cargar_BuscarMaquinista.getController();
            BuscarGuia.setMaquinistas(Maquinistas);
            this.Border.setCenter(pane);
        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("No hay registros");
            msgE.setHeaderText("Por favor abra un archivo o "
                    + "haga nuevos registros");
            msgE.show();
        }
    }

    @FXML
    private void bus_trenes(ActionEvent event) {
        try {
            this.Border.setCenter(null);
            FXMLLoader cargar_BuscarTren = new FXMLLoader(getClass()
                    .getResource("FXMLBuscar_Trenes.fxml"));
            AnchorPane pane = null;
            try {
                pane = (AnchorPane) cargar_BuscarTren.load();
            } catch (IOException ex) {
                Alert msgE = new Alert(Alert.AlertType.ERROR);
                msgE.setTitle("Error");
                msgE.setHeaderText("No se pudo abrir");
                msgE.show();
            }
            BuscarTrenesController BuscarTrenes = cargar_BuscarTren
                    .getController();
            BuscarTrenes.setTrenes(Trenes);
            this.Border.setCenter(pane);
        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("No hay nada");
            msgE.setHeaderText("Por favor cree los registros");
            msgE.show();
        }
    }

    @FXML
    private void new_viaje(ActionEvent event) {
                this.Border.setCenter(null);
        FXMLLoader lectorViajes = new FXMLLoader(getClass()
                .getResource("FXMLViajes.fxml"));
        Pane pane = null;
        try {
            pane = (Pane) lectorViajes.load();
        } catch (IOException e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("Error");
            msgE.setHeaderText("No se pudo abrir el archivo");
            msgE.show();
        }
        CrearViajesController Control = lectorViajes.getController();
        Control.setViajes(Viajes);
        Control.setMaquinistas(Maquinistas);
        Control.setTrenes(Trenes);
        this.Border.setCenter(pane);
    }

    @FXML
    private void save_viajes(ActionEvent event) {
                try {
            try {
                FileWriter fw = new FileWriter("ViajesTOTALES" + ".txt");
                PrintWriter escritor = new PrintWriter(fw);

                escritor.println("Total Viajes: " + Viajes.size());
                for (int i = 0; i < Viajes.size(); i++) {
                    Viajes temp = Viajes.get(i);
                    
                    escritor.println("----Viaje número " + (i + 1) + "----");
                    
                    escritor.println("Maquinista: " 
                            + temp.getNombreMaquinista());
                    
                    escritor.println("Locomotora Asignada: " 
                            + temp.getModeloTren());
                    
                    escritor.println();
                }
                escritor.close();
                Alert msgE = new Alert(Alert.AlertType.INFORMATION);
                msgE.setTitle("¡EXITO!");
                msgE.setHeaderText("Se creó un archivo de histórico de viajes");
                msgE.show();
            } catch (IOException e) {
                Alert msgE = new Alert(Alert.AlertType.ERROR);
                msgE.setTitle("¡ERROR!");
                msgE.setHeaderText("C murio :(");
                msgE.show();
            }
        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("ERROR");
            msgE.setHeaderText(">:V NO HAY NADA AQUÍ");
            msgE.show();
        }
    }
        public void habilitarViajes() {
        btnViaje.setDisable(false);
    }

    public void deshabilitarviajes() {
        btnViaje.setDisable(true);
    }
    
    public void habliliar_Trenes() {
        btnModTrenes.setDisable(false);
        btnBusqTrenes.setDisable(false);
        btnGuardarTrenes.setDisable(false);
        btnViaje.setDisable(false);
    }

    public void deshablilitar_Trenes() {
        btnModTrenes.setDisable(true);
        btnBusqTrenes.setDisable(true);
        btnGuardarTrenes.setDisable(true);
        btnViaje.setDisable(true);
    }

    public void habilitar_maquinistas() {
        btnModMaquinista.setDisable(false);
        btnBusqMaquinista.setDisable(false);
        btnGuardarMaquinista.setDisable(false);
    }

    public void deshabilitar_maquinistas() {
        btnModMaquinista.setDisable(true);
        btnBusqMaquinista.setDisable(true);
        btnGuardarMaquinista.setDisable(true);
    }
    
}
