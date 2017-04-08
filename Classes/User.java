/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
public class User {

    private String ID_User;
    private String Name;
    private String Gender;
    private String ID_Mirror;
    

    public User()
    {
    }
    public User(String ID_User, String Name, String Gender, String ID_Mirror) {
        this.ID_User = ID_User;
        this.Name = Name;
        this.Gender = Gender;
        this.ID_Mirror = ID_Mirror;
    }

    public String getID_User() {
        return ID_User;
    }

    public void setID_User(String ID_User) {
        this.ID_User = ID_User;
    }

    public String getName() {
        return Name;
    }

    public void setName(String a) {
        Name = a;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String a) {
        Gender = a;
    }
  
    public String getID_Mirror() {
        return ID_Mirror;
    }
    
    public void setID_Mirror(String ID_Mirror) {
        this.ID_Mirror=ID_Mirror;    
    }
    
    @Override
    public String toString() {
        return "ID_User : "+ID_User+" ; Name : "+Name+" ; Gender : "+Gender + " ; ID_Mirror : " + ID_Mirror;
    }
}
