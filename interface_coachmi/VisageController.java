/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_coachmi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class VisageController implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML
    private ImageView photo;

    /**
     *
     * @param screenParent
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    /**
     * Fonction qui met à jour les composants quand elle est appelée Soit elle
     * affiche "veuillez placer votre visage pour prendre la photo" Soit elle
     * affiche "etes vous satisfait ?" si la photo a été prise L'affichage des
     * boutons disponibles est modifié en conséquence
     */
    private void update() {
        photo.setImage(new Image("file:C:\\Users\\deathley\\Documents\\photo.jpg"));
    }

    /**
     * Si l'utilisateur n'est pas satisfait, on revient au menu
     *
     * @param event
     */
    @FXML
    private void back(ActionEvent event) {
        GlobalVariables.restart();
        myController.setScreen(Interface_CoachMi.accueilID);
    }

    /**
     * Dans le cas où il est satisfait, on change de fenêtre et on va proposer
     * les choix pour les hommes ou pour les femmes
     *
     * @param event
     */
    @FXML
    private void next(ActionEvent event) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\deathley\\Documents\\CodeBarre.txt"));
        String line;
        StringBuilder txt = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                txt.append(line);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (GlobalVariables.gender.equals(GlobalVariables.WOMAN)) {
            GlobalVariables.code_personne = txt.toString().substring(0, 3);
            System.out.println(GlobalVariables.code_personne);
            myController.setScreen(Interface_CoachMi.choiceID);
        }
        if (GlobalVariables.gender.equals(GlobalVariables.MAN)) {
            if (txt.toString().substring(3, 4).equals("1")) {
                GlobalVariables.aBarbe = true;
            } else if (txt.toString().substring(3, 4).equals("0")) {
                GlobalVariables.aBarbe = false;
            }
            System.out.println(GlobalVariables.aBarbe);
            myController.setScreen(Interface_CoachMi.choicestylemanID);
            GlobalVariables.choice = "Look";
        }

    }

    /**
     * Répéte toutes les secondes la fonction update().
     *
     * @param url
     * @param rb
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(250), (ActionEvent actionEvent) -> {
                    update();
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
