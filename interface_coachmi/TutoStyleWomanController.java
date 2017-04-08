/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_coachmi;

import Classes.Advice;
import static interface_coachmi.GlobalVariables.formatTime;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import module_recherche_information.Couche_metier_recherche;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class TutoStyleWomanController implements Initializable, ControlledScreen {

    ScreensController myController;
    Boolean changedCombo = false;
    public MediaPlayer mediaPlayer;
    Image img;

    @FXML
    private Label lookchoisi, timeLabel;
    @FXML
    private ImageView photo;
    @FXML
    private MediaView mediaView;
    @FXML
    private Button playPause;
    @FXML
    private ComboBox combo;
    @FXML
    private TextArea text;

    /**
     *
     * @param screenParent
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    /**
     * Met à jour les images à chaque fois qu'elle est appelée Permet de mettre
     * à jour lors d'un changement d'état après un retour en arrière
     */
    private void update() {
        if (GlobalVariables.code_personne.equals("123")
                || GlobalVariables.code_personne.equals("124")
                || GlobalVariables.code_personne.equals("133")
                || GlobalVariables.code_personne.equals("134")
                || GlobalVariables.code_personne.equals("223")
                || GlobalVariables.code_personne.equals("224")
                || GlobalVariables.code_personne.equals("233")
                || GlobalVariables.code_personne.equals("234")) {
            GlobalVariables.code_personne = "123";
        }

        if (GlobalVariables.code_personne.equals("423")
                || GlobalVariables.code_personne.equals("424")
                || GlobalVariables.code_personne.equals("433")
                || GlobalVariables.code_personne.equals("434")
                || GlobalVariables.code_personne.equals("523")
                || GlobalVariables.code_personne.equals("524")
                || GlobalVariables.code_personne.equals("533")
                || GlobalVariables.code_personne.equals("534")) {
            GlobalVariables.code_personne = "423";
        }

        lookchoisi.setText(GlobalVariables.choice + " choisi : " + GlobalVariables.Style_Look);

        if (GlobalVariables.hasStyleChanged) {
            playPause.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("play.png"))));
            GlobalVariables.hasStyleChanged = false;
        }

        img = new Image("file:C:\\Users\\deathley\\Documents\\photo.jpg");
        photo.setImage(img);
        GlobalVariables.centerImage(photo, img);

        playPause.setId("buttonPlay");

        timeLabel.setText(formatTime(mediaPlayer.getCurrentTime(), mediaPlayer.getMedia().getDuration()));
    }

    /**
     * Appelle la fonction globale restart Vide la zone de text et réinitialise
     * la sélection de la combobox Va à la fenêtre des crédits
     *
     * @param event
     */
    @FXML
    private void terminer(ActionEvent event) {
        myController.setScreen(Interface_CoachMi.creditsID);
        GlobalVariables.restart();
        mediaPlayer.stop();
        text.clear();
        combo.getSelectionModel().clearSelection();
    }

    /**
     * Récupère l'item sélectionné dans la combobox /!\ /!\ /!\ Renvoie une
     * exception de pointeur nul dont je ne comprends pas la cause... /!\ /!\
     * /!\ Actualise aussi les conseils et la vidéo si il y a un changement dans
     * la liste
     *
     * @param event
     */
    @FXML
    private void zonesel(ActionEvent event) {
        GlobalVariables.Zone = combo.getSelectionModel().getSelectedItem().toString();

        Couche_metier_recherche recherche = new Couche_metier_recherche();
        ArrayList<Advice> advices = recherche.getConseils(GlobalVariables.Zone, recherche.getZones(GlobalVariables.Style_Look, recherche.getStyles(GlobalVariables.code_personne)));
        StringBuilder txt = new StringBuilder();

        for (int i = 0; i < advices.size(); i++) {
            txt.append("- ").append(advices.get(i).getConseil()).append(".\n\n");
        }
        text.setText(txt.toString());

        if (GlobalVariables.Zone.equals("Sourcils")) {
            mediaPlayer = new MediaPlayer(new Media((getClass().getResource("Tout_Tout_Sourcils.mp4")).toString())); 
        } else {
            mediaPlayer = new MediaPlayer(new Media((getClass().getResource(GlobalVariables.code_personne+"_"+GlobalVariables.Style_Look+"_"+GlobalVariables.Zone+".mp4")).toString())); 
        }
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(false);
        playPause.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("play.png"))));
        playPause.setId("buttonPlay");
    }

    /**
     * Fonction qui gère le bouton play/pause. Change un booléen, l'état de la
     * vidéo et l'image du bouton en fonction de l'état de la vidéo au moment du
     * clic.
     *
     * @param event
     */
    @FXML
    private void play_pause(ActionEvent event) {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
            playPause.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("play.png"))));
            playPause.setId("buttonPlay");
        } else {
            mediaPlayer.play();
            playPause.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("pause.png"))));
            playPause.setId("buttonPause");
        }
    }

    /**
     * Répéte toutes les secondes la fonction update().
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(500), (ActionEvent actionEvent) -> {
                    update();
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
