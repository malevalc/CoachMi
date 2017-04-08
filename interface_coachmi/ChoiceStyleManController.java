/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_coachmi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class ChoiceStyleManController implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML
    private Button collier, bouc, moustache, soigne, restart;
    @FXML
    private Label consigne;

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    /**
     * Change la visibilité des boutons, dépendants de la présence de barbe ou
     * non.
     *
     * @param bool
     */
    private void buttons(boolean bool) {
        collier.setVisible(bool);
        bouc.setVisible(bool);
        moustache.setVisible(bool);
        soigne.setVisible(bool);
        restart.setVisible(!bool);
    }

    /**
     * Initialisation de la fenêtre en fonction de la présence de barbe
     */
    public void restart() {
        if (GlobalVariables.aBarbe) {
            buttons(true);
            consigne.setText("Choisissez un style de barbe");
            consigne.setPrefHeight(153);
            consigne.setStyle("-fx-font-style: Normal");
        } else {
            buttons(false);
            consigne.setText("Votre barbe n'est pas assez longue pour vous permettre de choisir un des looks pré-définis...");
            consigne.setPrefHeight(800);
            consigne.setStyle("-fx-font-style: Italic");
        }
        consigne.setTextAlignment(TextAlignment.CENTER);
    }

    /**
     * Se lance quand l'option "Collier" est choisie. Fixe la variable globale
     * avec le nom du look choisi Change la fenêtre vers la fenêtre de tutoriel.
     *
     * @param event
     */
    @FXML
    private void Collier(ActionEvent event) {
        GlobalVariables.Style_Look = "Collier";
        GlobalVariables.hasBeenChanged = true;
        myController.setScreen(Interface_CoachMi.tutolookwmanID);
    }

    /**
     * Se lance quand l'option "Bouc" est choisie. Fixe la variable globale avec
     * le nom du look choisi Change la fenêtre vers la fenêtre de tutoriel.
     *
     * @param event
     */
    @FXML
    private void Bouc(ActionEvent event) {
        GlobalVariables.Style_Look = "Bouc";
        GlobalVariables.hasBeenChanged = true;
        myController.setScreen(Interface_CoachMi.tutolookwmanID);
    }

    /**
     * Se lance quand l'option "Soigné" est choisie. Fixe la variable globale
     * avec le nom du look choisi Change la fenêtre vers la fenêtre de tutoriel.
     *
     * @param event
     */
    @FXML
    private void Soigne(ActionEvent event) {
        GlobalVariables.Style_Look = "Soigné";
        GlobalVariables.hasBeenChanged = true;
        myController.setScreen(Interface_CoachMi.tutolookwmanID);
    }

    /**
     * Se lance quand l'option "Moustache" est choisie. Fixe la variable globale
     * avec le nom du look choisi Change la fenêtre vers la fenêtre de tutoriel.
     *
     * @param event
     */
    @FXML
    private void Moustache(ActionEvent event) {
        GlobalVariables.Style_Look = "Moustache";
        GlobalVariables.hasBeenChanged = true;
        myController.setScreen(Interface_CoachMi.tutolookwmanID);
    }

    /**
     * Se lance quand l'utilisateur revient au menu. Appelle la fonction
     * globalvariables.restart pour remettre les variables à leur état initial.
     *
     * @param event
     */
    @FXML
    private void Restart(ActionEvent event) {
        GlobalVariables.restart();
        myController.setScreen(Interface_CoachMi.accueilID);
    }

    /**
     * Répéte toutes les secondes la fonction restart().
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(250), (ActionEvent actionEvent) -> {
                    restart();
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
