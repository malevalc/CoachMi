/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Classes.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import module_connexion.super_connexion;

/**
 *
 * @author deathley
 */
public class AdviceDAO extends DAO<Advice> {

    @Override
    public Advice find(int babla) {
        return null;
    }

    public Advice find(String ID_Advice) {
        Advice Advice = null;
        PreparedStatement stmt;
        ResultSet rset;
        ResultSetMetaData rsetMeta = null;

        try {
            // création d'un ordre SQL (statement)

            stmt = super_connexion.my_con.getConnection().prepareStatement("select * from Advice WHERE CODE LIKE '?'");
            stmt.setString(1, ID_Advice);
            rset = stmt.executeQuery();

            if (rset.next()) {
                String ID_Advice_Advice = rset.getString(1);
                String Code = rset.getString(2);
                String Style = rset.getString(3);
                String Zone = rset.getString(4);
                String Conseil = rset.getString(5);

                Advice = new Advice();
                Advice.setID_Advice(ID_Advice);
                Advice.setCode(Code);
                Advice.setStyle(Style);
                Advice.setZone(Zone);
                Advice.setConseil(Conseil);
            }
            rsetMeta = rset.getMetaData();

        } catch (SQLException ex) {
            Logger.getLogger(AdviceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Advice;
    }

    public ArrayList<Advice> findAll() {

        PreparedStatement stmt;
        ResultSet rst;
        ArrayList<Advice> Advices = new ArrayList<>();

        try {

            stmt = super_connexion.my_con.getConnection().prepareStatement("SELECT * FROM Advice");
            rst = stmt.executeQuery();

            while (rst.next()) {

                String ID_Advice = rst.getString(1);
                String Code = rst.getString(2);
                String Style = rst.getString(3);
                String Zone = rst.getString(4);
                String Conseil = rst.getString(5);

                Advice Advice = new Advice();
                Advice.setID_Advice(ID_Advice);
                Advice.setCode(Code);
                Advice.setStyle(Style);
                Advice.setZone(Zone);
                Advice.setConseil(Conseil);

                Advices.add(Advice);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Advices;
    }
}