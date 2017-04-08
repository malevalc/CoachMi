/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_recherche_information;

import Classes.*;
import java.util.ArrayList;

public interface Couche_metier_recherche_interface {

    ArrayList<User> getUsersDepending_IDMirror(String ID_Mirror);

    ArrayList<Mirror> getMirrorsDepending_IDMirror(String ID_Mirror);
    
   ArrayList<Advice> getStyles(String Code);
   
   ArrayList<Advice> getZones(String Style, ArrayList<Advice> advices);
   
   ArrayList<Advice> getConseils(String Conseil, ArrayList<Advice> advices);
}
