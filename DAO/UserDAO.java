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
 * @author Vincent
 */
public class UserDAO extends DAO<User> {

    @Override
    public User find(int babla) {
        return null;
    }

    public User find(String ID_User) {
        User User = null;
        PreparedStatement stmt;
        ResultSet rset;
        ResultSetMetaData rsetMeta = null;

        try {
            // création d'un ordre SQL (statement)

            stmt = super_connexion.my_con.getConnection().prepareStatement("select * from User WHERE CODE LIKE '?'");
            stmt.setString(1, ID_User);
            rset = stmt.executeQuery();

            if (rset.next()) {
                String ID_User_User = rset.getString(1);
                String Name = rset.getString(2);
                String Gender = rset.getString(3);
                String ID_Mirror = rset.getString(4);

                User = new User();
                User.setID_User(ID_User_User);
                User.setName(Name);
                User.setGender(Gender);
                User.setID_Mirror(ID_Mirror);
            }
            rsetMeta = rset.getMetaData();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return User;
    }

    public ArrayList<User> findAll() {

        PreparedStatement stmt;
        ResultSet rst;
        ArrayList<User> Users = new ArrayList<>();

        try {

            stmt = super_connexion.my_con.getConnection().prepareStatement("SELECT * FROM User");
            rst = stmt.executeQuery();

            while (rst.next()) {

                String ID_User = rst.getString(1);
                String Name = rst.getString(2);
                String Gender = rst.getString(3);
                String ID_Mirror = rst.getString(4);

                User User = new User();
                User.setID_User(ID_User);
                User.setName(Name);
                User.setGender(Gender);
                User.setID_Mirror(ID_Mirror);

                Users.add(User);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Users;
    }
}
