/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_coachmi;

import Classes.User;
import Controleur.ProjetBDD;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import module_connexion.Connexion;
import module_connexion.super_connexion;
import module_recherche_information.*;

/**
 *
 * @author deathley
 */
public class AccueilController implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML
    public RadioButton User1, abarbe, User2, User3, User4, User5;
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
     * Fonction qui se lance quand l'utilisateur clique sur valider. 1. Récupère
     * les utilisateurs utilisant le miroir. 2. Change la scene vers celle de
     * capture de visage.
     *
     * @param event
     */
    @FXML
    private void next(ActionEvent event) throws IOException, InterruptedException {
        Couche_metier_recherche recherche = new Couche_metier_recherche();
        ArrayList<User> users = recherche.getUsersDepending_IDMirror(GlobalVariables.Mirror_Number);

        if (User1.isSelected()) {
            GlobalVariables.gender = users.get(0).getGender();
            GlobalVariables.name = User1.getText();
            System.out.print("\r" + GlobalVariables.name + " selected! " + GlobalVariables.gender);
        } else if (User2.isSelected()) {
            GlobalVariables.gender = users.get(1).getGender();
            GlobalVariables.name = User2.getText();
            System.out.print("\r" + GlobalVariables.name + " selected! " + GlobalVariables.gender);
        } else if (User3.isSelected()) {
            GlobalVariables.gender = users.get(2).getGender();
            GlobalVariables.name = User3.getText();
            System.out.print("\r" + GlobalVariables.name + " selected! " + GlobalVariables.gender);
        } else if (User4.isSelected()) {
            GlobalVariables.gender = users.get(3).getGender();
            GlobalVariables.name = User4.getText();
            System.out.print("\r" + GlobalVariables.name + " selected! " + GlobalVariables.gender);
        } else if (User5.isSelected()) {
            GlobalVariables.gender = users.get(4).getGender();
            GlobalVariables.name = User5.getText();
            System.out.print("\r" + GlobalVariables.name + " selected! " + GlobalVariables.gender);
        }

        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C:\\Users\\deathley\\Documents\\Traitement_images\\dist\\Traitement_images.jar");
        Process p2 = pb.start();

        myController.setScreen(Interface_CoachMi.visageID);
    }

    /**
     * Fonction qui s'active au lancement de l'application. Lance la connection
     * à la BDD, affiche les utilisateurs.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            super_connexion.my_con = new Connexion("maleval", "KImalbob40;)", "maleval-rw", "CoachMi", false);
            if (super_connexion.my_con.isConnectionEstablished()) {
                System.out.println("Connexion: ok!");
            } else {
                System.out.println("Error in connexion!");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        Number.setText("Miroir N° " + GlobalVariables.Mirror_Number);

        Couche_metier_recherche recherche = new Couche_metier_recherche();
        ArrayList<User> users = recherche.getUsersDepending_IDMirror(GlobalVariables.Mirror_Number);

        switch (users.size()) {
            case 1:
                User1.setVisible(true);
                User1.setText(users.get(0).getName());
                User1.setLayoutY(GlobalVariables.YUser3);
                User2.setVisible(false);
                User3.setVisible(false);
                User4.setVisible(false);
                User5.setVisible(false);
                break;
            case 2:
                User1.setVisible(true);
                User1.setText(users.get(0).getName());
                User1.setLayoutY(GlobalVariables.YUser2);
                User2.setVisible(true);
                User2.setText(users.get(1).getName());
                User2.setLayoutY(GlobalVariables.YUser4);
                User3.setVisible(false);
                User4.setVisible(false);
                User5.setVisible(false);
                break;
            case 3:
                User1.setVisible(true);
                User1.setText(users.get(0).getName());
                User1.setLayoutY(GlobalVariables.YUser1);
                User2.setVisible(true);
                User2.setText(users.get(1).getName());
                User2.setLayoutY(GlobalVariables.YUser3);
                User3.setVisible(true);
                User3.setText(users.get(2).getName());
                User3.setLayoutY(GlobalVariables.YUser5);
                User4.setVisible(false);
                User5.setVisible(false);
                break;
            case 4:
                User1.setVisible(true);
                User1.setText(users.get(0).getName());
                User1.setLayoutY(GlobalVariables.YUser1);
                User2.setVisible(true);
                User2.setText(users.get(1).getName());
                User2.setLayoutY(GlobalVariables.YUser2);
                User3.setVisible(true);
                User3.setText(users.get(2).getName());
                User3.setLayoutY(GlobalVariables.YUser3);
                User4.setVisible(true);
                User4.setText(users.get(3).getName());
                User4.setLayoutY(GlobalVariables.YUser4);
                User5.setVisible(false);
                break;
            case 5:
                User1.setVisible(true);
                User1.setText(users.get(0).getName());
                User1.setLayoutY(GlobalVariables.YUser1);
                User2.setVisible(true);
                User2.setText(users.get(1).getName());
                User2.setLayoutY(GlobalVariables.YUser2);
                User3.setVisible(true);
                User3.setText(users.get(2).getName());
                User3.setLayoutY(GlobalVariables.YUser3);
                User4.setVisible(true);
                User4.setText(users.get(3).getName());
                User4.setLayoutY(GlobalVariables.YUser4);
                User5.setVisible(true);
                User5.setText(users.get(4).getName());
                User5.setLayoutY(GlobalVariables.YUser5);
                break;
            default:;
        }
    }
}
