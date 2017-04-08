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
public class ChoiceLookWomanController implements Initializable, ControlledScreen {

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
     * Se lance quand l'option "Maléfique" est choisie. Fixe la variable globale
     * avec le nom du look choisi Change la fenêtre vers la fenêtre de tutoriel.
     *
     * @param event
     */
    @FXML
    private void Malefique(ActionEvent event) {
        GlobalVariables.Style_Look = "Maléfique";
        GlobalVariables.hasBeenChanged = true;
        myController.setScreen(Interface_CoachMi.tutolookwmanID);
    }

    /**
     * Se lance quand l'option "Anti-Fatigue" est choisie. Fixe la variable
     * globale avec le nom du look choisi Change la fenêtre vers la fenêtre de
     * tutoriel.
     *
     * @param event
     */
    @FXML
    private void Fatigue(ActionEvent event) {
        GlobalVariables.Style_Look = "Anti-Fatigue";
        GlobalVariables.hasBeenChanged = true;
        myController.setScreen(Interface_CoachMi.tutolookwmanID);
    }

    /**
     * Se lance quand l'option "Anti-âge" est choisie. Fixe la variable globale
     * avec le nom du look choisi Change la fenêtre vers la fenêtre de tutoriel.
     *
     * @param event
     */
    @FXML
    private void Age(ActionEvent event) {
        GlobalVariables.Style_Look = "Anti-Âge";
        GlobalVariables.hasBeenChanged = true;
        myController.setScreen(Interface_CoachMi.tutolookwmanID);
    }

    /**
     * Se lance quand l'option "Vieilleisse" est choisie. Fixe la variable
     * globale avec le nom du look choisi Change la fenêtre vers la fenêtre de
     * tutoriel.
     *
     * @param event
     */
    @FXML
    private void Vieux(ActionEvent event) {
        GlobalVariables.Style_Look = "Veillissant";
        GlobalVariables.hasBeenChanged = true;
        myController.setScreen(Interface_CoachMi.tutolookwmanID);
    }

    /**
     * Se lance quand l'option "Petite-Fille" est choisie. Fixe la variable
     * globale avec le nom du look choisi Change la fenêtre vers la fenêtre de
     * tutoriel.
     *
     * @param event
     */
    @FXML
    private void Petite(ActionEvent event) {
        GlobalVariables.Style_Look = "Petite Fille";
        GlobalVariables.hasBeenChanged = true;
        myController.setScreen(Interface_CoachMi.tutolookwmanID);
    }

    /**
     * Se lance quand l'option "St Valentin" est choisie. Fixe la variable
     * globale avec le nom du look choisi Change la fenêtre vers la fenêtre de
     * tutoriel.
     *
     * @param event
     */
    @FXML
    private void StVal(ActionEvent event) {
        GlobalVariables.Style_Look = "St Valentin";
        GlobalVariables.hasBeenChanged = true;
        myController.setScreen(Interface_CoachMi.tutolookwmanID);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
