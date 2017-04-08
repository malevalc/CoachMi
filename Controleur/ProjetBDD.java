/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import module_connexion.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjetBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * Connexion
         */
        try {
            super_connexion.my_con = new Connexion("colindev", ",,VIvignivin2", "colindev-rw", "ffUcaWXW", true);// mettre le login de l ece, le mot de passe , l(identifiant de la bdd , son mdp et true/false pour avoir connexion locale
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * Déconnexion
         */
        try {
            super_connexion.my_con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
