/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.util.Date;

public class Mirror {

    private String ID_Mirror;
    private Date Buying_Date;
    
    public Mirror(){}
    
    public Mirror(String ID_Mirror, Date Buying_Date, String batiment, int num_directeur) {
        this.ID_Mirror = ID_Mirror;
        this.Buying_Date = Buying_Date;
    }

    public String getID_Mirror() {
        return ID_Mirror;
    }

    public void setID_Mirror(String ID_Mirror) {
        this.ID_Mirror = ID_Mirror;
    }

    public Date getBuying_Date() {
        return Buying_Date;
    }

    public void setBuying_Date(Date a) {
        Buying_Date = a;
    }
    
    @Override
    public String toString() {
        return "ID_Mirror : "+ID_Mirror+" ; Buying_Date : "+Buying_Date;
    }
}
