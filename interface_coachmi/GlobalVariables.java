/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_coachmi;

import static java.lang.StrictMath.floor;
import static java.lang.String.format;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GlobalVariables {

    public static String Mirror_Number = "1254";
    public static String MAN = "Man";
    public static String WOMAN = "Woman";
    public static String gender;
    public static String name  = "photo";
    public static String choice;
    public static String Style_Look = "Bouc";
    public static String code_personne = "434";
    public static String Zone = "Peau";
    public static String video_name;
    public static boolean Visage = true;
    public static boolean aBarbe;
    public static boolean hasBeenChanged = false;
    public static boolean wantsToPlay = true;
    public static boolean hasStyleChanged =true;

    public static double YUser1 = 350;
    public static double YUser2 = 450;
    public static double YUser3 = 550;
    public static double YUser4 = 650;
    public static double YUser5 = 750;

    public static String formatTime(Duration elapsed, Duration duration) {
        int intElapsed = (int) floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) {
            intElapsed -= elapsedHours * 60 * 60;
        }
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60
                - elapsedMinutes * 60;

        if (duration.greaterThan(Duration.ZERO)) {
            int intDuration = (int) floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            if (durationHours > 0) {
                intDuration -= durationHours * 60 * 60;
            }
            int durationMinutes = intDuration / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60
                    - durationMinutes * 60;
            if (durationHours > 0) {
                return format("%d:%02d:%02d / %d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds,
                        durationHours, durationMinutes, durationSeconds);
            } else {
                return format("%02d:%02d / %02d:%02d",
                        elapsedMinutes, elapsedSeconds, durationMinutes,
                        durationSeconds);
            }
        } else if (elapsedHours > 0) {
            return format("%d:%02d:%02d", elapsedHours,
                    elapsedMinutes, elapsedSeconds);
        } else {
            return format("%02d:%02d", elapsedMinutes,
                    elapsedSeconds);
        }
    }
    
    /**
     * Fonction qui centre la photo dans l'imageview
     * @param imageview
     * @param image 
     */
    public static void centerImage(ImageView imageview, Image image) {
        double w = 0;
        double h = 0;
        double ratioX = imageview.getFitWidth() / image.getWidth();
        double ratioY = imageview.getFitHeight() / image.getHeight();
        double reducCoeff = 0;
        if (ratioX >= ratioY) {
            reducCoeff = ratioY;
        } else {
            reducCoeff = ratioX;
        }
        w = image.getWidth() * reducCoeff;
        h = image.getHeight() * reducCoeff;
        imageview.setX((imageview.getFitWidth() - w) / 2);
        imageview.setY((imageview.getFitHeight() - h) / 2);
    }
    
    /**
     * Remise à 0 des variables
     */
    public static void restart() {
        Style_Look = "Bouc";
        hasBeenChanged = false;
        hasStyleChanged = false;
        wantsToPlay = true;
        code_personne = "234";
        Zone = "Peau";
        Visage = true;
        YUser1 = 350;
        YUser2 = 450;
        YUser3 = 550;
        YUser4 = 650;
        YUser5 = 750;
    }
}
