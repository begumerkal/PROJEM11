package yio.tro.antiyoy.gameplay.user_levels;

import yio.tro.antiyoy.gameplay.FieldController;
import yio.tro.antiyoy.gameplay.GameController;
import yio.tro.antiyoy.gameplay.Hex;
import yio.tro.antiyoy.gameplay.Province;

public abstract class AbstractUserLevel {


    public abstract String getFullLevelString();


    public abstract String getMapName();


    public abstract String getAuthor();


    public abstract String getKey();


    public int getColorOffset() {
        return 0;
    }


    public boolean getFogOfWar() {
        return false;
    }


    public boolean getDiplomacy() {
        return false;
    }


    public boolean isHistorical() {
        return false;
    }


    public void onLevelLoaded(GameController gameController) {
        // nothing by default
    }


    public boolean isSinglePlayer() {
        String fullLevelString = getFullLevelString();
        if (fullLevelString.length() < 10) return false;

        String playersNumberString = fullLevelString.substring(0, 10).split(" ")[2];
        int playersNumber = Integer.valueOf(playersNumberString);
        return playersNumber == 1;
    }


    public boolean isMultiplayer() {
        String fullLevelString = getFullLevelString();
        if (fullLevelString.length() < 10) return false;

        String playersNumberString = fullLevelString.substring(0, 10).split(" ")[2];
        int playersNumber = Integer.valueOf(playersNumberString);
        return playersNumber > 1;
    }


    protected void setProvinceMoney(GameController gameController, int i, int j, int money) {
        FieldController fieldController = gameController.fieldController;
        Hex hex = fieldController.field[i][j];
        Province provinceByHex = fieldController.getProvinceByHex(hex);
        provinceByHex.money = money;
    }

}
