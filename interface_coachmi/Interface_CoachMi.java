/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_coachmi;

import Controleur.ProjetBDD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import module_connexion.super_connexion;

/**
 *
 * @author deathley
 */
public class Interface_CoachMi extends Application {

    public static String accueilID = "Accueil";
    public static String accueilFile = "Accueil.fxml";
    public static String choiceID = "Choice";
    public static String choiceFile = "Choice.fxml";
    public static String choicelookwomanID = "ChoiceLookWoman";
    public static String choicelookwomanFile = "ChoiceLookWoman.fxml";
    public static String choicestylemanID = "ChoiceStyleMan";
    public static String choicestylemanFile = "ChoiceStyleMan.fxml";
    public static String choicestylewomanID = "ChoiceStyleWoman";
    public static String choicestylewomanFile = "ChoiceStyleWoman.fxml";
    public static String creditsID = "Credis";
    public static String creditsFile = "Credits.fxml";
    public static String tutolookwmanID = "TutoLookWMan";
    public static String tutolookwmanFile = "TutoLookWMan.fxml";
    public static String tutostylewomanID = "TutoStyleWoman";
    public static String tutostylewomanFile = "TutoStyleWoman.fxml";
    public static String visageID = "Visage";
    public static String visageFile = "Visage.fxml";

    /**
     * Se lance quand l'utilisateur ferme l'application On quitte la connection
     * et on ferme la fenêtre.
     *
     * @param mainContainer
     */
    private void close(ScreensController mainContainer) {
        try {
            super_connexion.my_con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainContainer.setScreen(Interface_CoachMi.accueilID);
        Platform.exit();
    }

    /**
     * Effectue tous les réglages sur la fenêtre : 1. Fixe le plein écran 2.
     * Désactive l'affichage de "appuyer sur esc pour quitter le plein écran" 3.
     * Changement de l'icone 4. Changement du titre
     *
     * @param primaryStage
     */
    public void SetStage(Stage primaryStage) {
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        primaryStage.setTitle("CoachMi");
    }

    /**
     * Chargement de toutes les pages en utilisant les fonctions créées par
     * Oracle.
     *
     * @return mainContainer, le conteneur contenant toutes les pages de
     * l'interface
     */
    public ScreensController loadAndSetScreens() {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Interface_CoachMi.accueilID, Interface_CoachMi.accueilFile);
        mainContainer.loadScreen(Interface_CoachMi.choiceID, Interface_CoachMi.choiceFile);
        mainContainer.loadScreen(Interface_CoachMi.choicelookwomanID, Interface_CoachMi.choicelookwomanFile);
        mainContainer.loadScreen(Interface_CoachMi.choicestylemanID, Interface_CoachMi.choicestylemanFile);
        mainContainer.loadScreen(Interface_CoachMi.choicestylewomanID, Interface_CoachMi.choicestylewomanFile);
        mainContainer.loadScreen(Interface_CoachMi.creditsID, Interface_CoachMi.creditsFile);
        mainContainer.loadScreen(Interface_CoachMi.tutolookwmanID, Interface_CoachMi.tutolookwmanFile);
        mainContainer.loadScreen(Interface_CoachMi.tutostylewomanID, Interface_CoachMi.tutostylewomanFile);
        mainContainer.loadScreen(Interface_CoachMi.visageID, Interface_CoachMi.visageFile);
        mainContainer.setScreen(Interface_CoachMi.accueilID);
        return mainContainer;
    }

    /**
     * Fonction de démarrage de l'application : 1. Ajout des pages 2. Appel des
     * fonctions nécessaires 3. Ajout du fichier Cascading Style Sheets (CSS) 4.
     * Changement du curseur de la souris (remplacé par un rouge à lèvre)
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreensController mainContainer = loadAndSetScreens();
        StackPane root = new StackPane();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        SetStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            close(mainContainer);
        });
        scene.getStylesheets().add(Interface_CoachMi.class.getResource("Interface.css").toExternalForm());
        scene.setCursor(new ImageCursor(new Image(getClass().getResourceAsStream("cursor.png"))));
        primaryStage.show();
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
