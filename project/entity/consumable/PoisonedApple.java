package entity.consumable;

import entity.Player;
import entity.consumable.Consumable;

public class PoisonedApple extends Consumable {
    private final int diseaseDuration = 5000;
    @Override
    public void applyEffect(Player player) {
        int timer = 0;
        int currentDiseaseLevel = player.getDiseaseLevel();
        while (timer < diseaseDuration){
            player.setDiseaseLevel(currentDiseaseLevel+1);
            System.out.println(player.getDiseaseLevel());
            timer++;
        }
        player.setDiseaseLevel(currentDiseaseLevel);
    }
}
