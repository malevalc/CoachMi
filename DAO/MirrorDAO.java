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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import module_connexion.super_connexion;

/**
 *
 * @author Vincent
 */
public class MirrorDAO extends DAO<Mirror> {

    @Override
    public Mirror find(int babla) {
        return null;
    }

    public Mirror find(String code) {
        Mirror mirror = null;
        PreparedStatement stmt;
        ResultSet rset;
        ResultSetMetaData rsetMeta = null;

        try {
            // création d'un ordre SQL (statement)

            stmt = super_connexion.my_con.getConnection().prepareStatement("select * from Mirror WHERE CODE LIKE '?'");
            stmt.setString(1, code);
            rset = stmt.executeQuery();

            if (rset.next()) {
                String ID_Mirror = rset.getString(1);
                Date Buying_Date = rset.getDate(2);

                mirror = new Mirror();
                mirror.setID_Mirror(ID_Mirror);
                mirror.setBuying_Date(Buying_Date);
            }
            rsetMeta = rset.getMetaData();

        } catch (SQLException ex) {
            Logger.getLogger(MirrorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mirror;
    }

    public ArrayList<Mirror> findAll() {

        PreparedStatement stmt;
        ResultSet rst;
        ArrayList<Mirror> mirrors = new ArrayList<>();

        try {

            stmt = super_connexion.my_con.getConnection().prepareStatement("SELECT * FROM Mirror");
            rst = stmt.executeQuery();

            while (rst.next()) {

                String ID_Mirror = rst.getString(1);
                Date Buying_Date = rst.getDate(2);

                Mirror mirror = new Mirror();
                mirror.setID_Mirror(ID_Mirror);
                mirror.setBuying_Date(Buying_Date);

                mirrors.add(mirror);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return mirrors;
    }
}
