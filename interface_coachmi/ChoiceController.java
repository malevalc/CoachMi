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

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class ChoiceController implements Initializable, ControlledScreen {

    ScreensController myController;
    
    /**
     *
     * @param screenParent
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    } 
       
    /**
     * Se lance quand l'option "Styles" est choisie.
     * Change la fenêtre vers la fenêtre de choix des styles.
     * @param event
     */
    @FXML
    private void fais(ActionEvent event) {
        GlobalVariables.choice = "Style";
        myController.setScreen(Interface_CoachMi.choicestylewomanID);   
    }   
    
    /**
     * Se lance quand l'option "Looks" est choisie.
     * Change la fenêtre vers la fenêtre de choix des looks.
     * @param event
     */
    @FXML
    private void looks(ActionEvent event) {
        GlobalVariables.choice = "Look";
        myController.setScreen(Interface_CoachMi.choicelookwomanID);   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
