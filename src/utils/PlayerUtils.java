package utils;

import javafx.scene.paint.Color;

public class PlayerUtils {
    public static Color getPlayerColor(String playerNumber){
        if(playerNumber.equals("1")) {
            return Color.RED;
        }else if(playerNumber.equals("2")) {
            return Color.BLUE;
        }else if(playerNumber.equals("3")) {
            return Color.GREEN;
        } else if (playerNumber.equals("4")) {
            return Color.YELLOW;
        } else {
            return Color.WHITE;
        }
    }
}
