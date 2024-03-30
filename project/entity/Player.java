package entity;

public class Player extends Entity {
    private int diseaseLevel = 1;
    private int energyRecoverDuration;
    private int playerEnergy;
    private int playerInvincibilityDuration;
    private int nbLives;

    private int nbKeys;



    public Player(int diseaseLevel, int energyRecoverDuration, int playerEnergy,
                  int playerInvincibilityDuration, int nbLives, int nbKeys){
        this.diseaseLevel = diseaseLevel;
        this.energyRecoverDuration = energyRecoverDuration;
        this.playerEnergy = playerEnergy;
        this.playerInvincibilityDuration = playerInvincibilityDuration;
        this.nbLives = nbLives;
        this.nbKeys = nbKeys;
    }


    public int getDiseaseLevel() {
        return diseaseLevel;
    }

    public void setDiseaseLevel(int newDiseaseLevel){
        this.diseaseLevel = newDiseaseLevel;
    }

    public int getEnergyRecoverDuration() {
        return energyRecoverDuration;
    }

    public int getPlayerEnergy() {
        return playerEnergy;
    }

    public void setPlayerEnergy(int energy){
        this.playerEnergy = energy;
    }

    public int getPlayerInvincibilityDuration() {
        return playerInvincibilityDuration;
    }

    public int getNbLives() {
        return nbLives;
    }

    public void setNbLives(int lives){
        this.nbLives = lives;
    }
}
