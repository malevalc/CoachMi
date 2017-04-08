/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_coachmi;

import static interface_coachmi.GlobalVariables.formatTime;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class TutoLookWManController implements Initializable, ControlledScreen {

    ScreensController myController;
    public MediaPlayer mediaPlayer ;
    Image img;

    @FXML
    private Label lookchoisi, timeLabel;
    @FXML
    private ImageView resultat, photo;
    @FXML
    private MediaView mediaView;
    @FXML
    private Button playPause;

    /**
     *
     * @param screenParent
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    /**
     * Met à jour la vidéo et les images à chaque fois qu'elle est appelée
     * Permet de mettre à jour lors d'un changement d'état après un retour en
     * arrière
     */
    private void update() {
        lookchoisi.setText(GlobalVariables.choice + " choisi : " + GlobalVariables.Style_Look);

        if ("Look".equals(GlobalVariables.choice)) {
            resultat.setImage(new Image(getClass().getResourceAsStream(GlobalVariables.Style_Look + ".png")));
        }
        
        img = new Image("file:C:\\Users\\deathley\\Documents\\photo.jpg");
        photo.setImage(img);
        GlobalVariables.centerImage(photo,img);
        
        if (GlobalVariables.hasBeenChanged && GlobalVariables.wantsToPlay) {
            mediaPlayer = new MediaPlayer(new Media((getClass().getResource(GlobalVariables.Style_Look + ".mp4")).toString()));
            mediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.setAutoPlay(false);
            playPause.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("play.png"))));
            playPause.setId("buttonPlay");
            GlobalVariables.wantsToPlay = false;
        }

        if (!GlobalVariables.hasBeenChanged) {
            mediaPlayer.stop();
        }

        timeLabel.setText(formatTime(mediaPlayer.getCurrentTime(), mediaPlayer.getTotalDuration()));
    }

    /**
     * Appelle la fonction globale restart Va à la fenêtre des crédits
     *
     * @param event
     */
    @FXML
    private void terminer(ActionEvent event) {
        GlobalVariables.restart();
        myController.setScreen(Interface_CoachMi.creditsID);
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
