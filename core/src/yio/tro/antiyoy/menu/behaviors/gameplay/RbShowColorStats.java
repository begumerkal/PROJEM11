package yio.tro.antiyoy.menu.behaviors.gameplay;

import yio.tro.antiyoy.gameplay.GameController;
import yio.tro.antiyoy.gameplay.Province;
import yio.tro.antiyoy.gameplay.rules.GameRules;
import yio.tro.antiyoy.menu.behaviors.Reaction;
import yio.tro.antiyoy.menu.ButtonYio;
import yio.tro.antiyoy.menu.scenes.Scenes;

/**
 * Created by ivan on 29.12.2015.
 */
public class RbShowColorStats extends Reaction {



    @Override
    public void perform(ButtonYio buttonYio) {
        Scenes.sceneIncomeGraph.create();

        ColorStatsRenderer colorStatsRenderer = new ColorStatsRenderer(buttonYio.menuControllerYio);
        colorStatsRenderer.performRendering(Scenes.sceneIncomeGraph.showPanel, getIncomeArray(getGameController(buttonYio)));
    }


    private int[] getIncomeArray(GameController gameController) {
        int[] array = new int[GameRules.colorNumber];

        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }

        for (Province province : gameController.fieldController.provinces) {
            array[province.getColor()] += province.getIncome();
        }

        return array;
    }
}
