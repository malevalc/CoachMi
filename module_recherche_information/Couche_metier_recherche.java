/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_recherche_information;

import java.util.ArrayList;
import Classes.*;
import DAO.*;

/**
 *
 * @author Vincent
 */
public class Couche_metier_recherche implements Couche_metier_recherche_interface {

    @Override
    public ArrayList<User> getUsersDepending_IDMirror(String ID_Mirror) {

        UserDAO userdao = new UserDAO();
        ArrayList<User> users;
        ArrayList<User> users2 = new ArrayList<>();

        users = userdao.findAll();

        for (int j = 0; j < users.size(); j++) {
            if (users.get(j).getID_Mirror().equals(ID_Mirror)) {
                users2.add(users.get(j));
            }
        }
        return users2;
    }

    @Override
    public ArrayList<Mirror> getMirrorsDepending_IDMirror(String ID_Mirror) {

        MirrorDAO maladedao = new MirrorDAO();
        ArrayList<Mirror> mirrors;
        ArrayList<Mirror> mirrors2 = new ArrayList<>();

        mirrors = maladedao.findAll();

        for (int j = 0; j < mirrors.size(); j++) {
            if (mirrors.get(j).getID_Mirror().equals(ID_Mirror)) {
                mirrors2.add(mirrors.get(j));
            }
        }
        return mirrors2;
    }
    
    @Override
    public ArrayList<Advice> getStyles(String Code) {

        AdviceDAO advicedao = new AdviceDAO();
        ArrayList<Advice> advices;
        ArrayList<Advice> advices2 = new ArrayList<>();

        advices = advicedao.findAll();

        for (int j = 0; j < advices.size(); j++) {
            if (advices.get(j).getCode().equals(Code)) {
                advices2.add(advices.get(j));
            }
        }
        return advices2;
    }
    
    @Override
    public ArrayList<Advice> getZones(String Style, ArrayList<Advice> advices) {

        ArrayList<Advice> advices2 = new ArrayList<>();

        for (int j = 0; j < advices.size(); j++) {
            if (advices.get(j).getStyle().equals(Style)) {
                advices2.add(advices.get(j));
            }
        }
        return advices2;
    }
    
    @Override
    public ArrayList<Advice> getConseils(String Zone, ArrayList<Advice> advices) {

        ArrayList<Advice> advices2 = new ArrayList<>();

        for (int j = 0; j < advices.size(); j++) {
            if (advices.get(j).getZone().equals(Zone)) {
                advices2.add(advices.get(j));
            }
        }
        return advices2;
    }
}
