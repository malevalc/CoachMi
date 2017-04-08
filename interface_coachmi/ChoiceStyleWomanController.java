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
public class ChoiceStyleWomanController implements Initializable, ControlledScreen {

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
     * Se lance quand l'option "Nude" est choisie. Fixe la variable globale avec
     * le nom du look choisi Change la fenêtre vers la fenêtre de tutoriel.
     *
     * @param event
     */
    @FXML
    private void Nude(ActionEvent event) {
        GlobalVariables.Style_Look = "Nude";
        GlobalVariables.hasStyleChanged = true;
        myController.setScreen(Interface_CoachMi.tutostylewomanID);
    }

    /**
     * Se lance quand l'option "Sophistiqué" est choisie. Fixe la variable
     * globale avec le nom du look choisi Change la fenêtre vers la fenêtre de
     * tutoriel.
     *
     * @param event
     */
    @FXML
    private void Sophi(ActionEvent event) {
        GlobalVariables.Style_Look = "Sophistiqué";
        GlobalVariables.hasStyleChanged = true;
        myController.setScreen(Interface_CoachMi.tutostylewomanID);
    }

    /**
     * Se lance quand l'option "Hiver" est choisie. Fixe la variable globale
     * avec le nom du look choisi Change la fenêtre vers la fenêtre de tutoriel.
     *
     * @param event
     */
    @FXML
    private void Hiver(ActionEvent event) {
        GlobalVariables.Style_Look = "Hiver";
        GlobalVariables.hasStyleChanged = true;
        myController.setScreen(Interface_CoachMi.tutostylewomanID);
    }

    /**
     * Se lance quand l'option "Eté" est choisie. Fixe la variable globale avec
     * le nom du look choisi Change la fenêtre vers la fenêtre de tutoriel.
     *
     * @param event
     */
    @FXML
    private void Ete(ActionEvent event) {
        GlobalVariables.Style_Look = "Été";
        GlobalVariables.hasStyleChanged = true;
        myController.setScreen(Interface_CoachMi.tutostylewomanID);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
