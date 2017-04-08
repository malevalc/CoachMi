/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
public class Advice {
    
    private String ID_Advice;
    private String Code;
    private String Style;
    private String Zone;
    private String Conseil;
    
    public Advice(){}
    
    public Advice(String ID_Advice, String Code, String Style, String Zone, String Conseil) {
        this.ID_Advice = ID_Advice;
        this.Code = Code;
        this.Style = Style;
        this.Zone = Zone;
        this.Conseil = Conseil;
    }

    public String getID_Advice() {
        return ID_Advice;
    }

    public void setID_Advice(String ID_Advice) {
        this.ID_Advice = ID_Advice;
    }
    
    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }
    
    public String getStyle() {
        return Style;
    }

    public void setStyle(String Style) {
        this.Style = Style;
    }
    
    public String getZone() {
        return Zone;
    }

    public void setZone(String Zone) {
        this.Zone = Zone;
    }
    
    public String getConseil() {
        return Conseil;
    }

    public void setConseil(String Conseil) {
        this.Conseil = Conseil;
    }
    
    @Override
    public String toString() {
        return "Code : "+Code+" ; Style : "+Style+ " ; Zone : "+Zone+ " ; Conseil : "+Conseil;
    }
}
