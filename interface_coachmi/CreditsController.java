/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_coachmi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class CreditsController implements Initializable , ControlledScreen {

    ScreensController myController;
    
    @FXML 
    private Label Number;
    
    /**
     *
     * @param screenParent
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    } 
       
    /**
     * Se lance quand l'utilisateur revient au menu.
     * Appelle la fonction globalvariables.restart pour remettre les variables à leur état initial.
     * @param event
     */
    @FXML
    private void restart(ActionEvent event) {
        myController.setScreen(Interface_CoachMi.accueilID);  
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Number.setText("Miroir N° " + GlobalVariables.Mirror_Number);
    }    
}
