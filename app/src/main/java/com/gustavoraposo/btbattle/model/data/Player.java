package com.gustavoraposo.btbattle.model.data;

import java.util.Random;

public class Player {
    private String name;
    private int playerClass;
    private int level;
    private double expToLevelUp;
    private double exp;
    private int baseHealthPoints;
    private int baseMagicPoints;
    private int baseDefensePoints;
    private int healthPoints;
    private int magicPoints;
    private int defensePoints;
    private int speed;
    private int ivHealthPoints;
    private int iVMagicPoints;
    private int iVDefensePoints;
    private int ivSpeed;

    public Player(String name, int playerClass){
        this.name = name;
        this.playerClass = playerClass;
        this.speed = 100;
        this.level = 1;
        this.exp = 50;
        this.expToLevelUp = this.level * 100 * 1.25;
        setIVs();
        initPlayerValues(playerClass);
    }

    public Player(String name, int playerClass, int level, int healthPoints, int magicPoints, int defensePoints, int speed) {
        this.name = name;
        this.playerClass = playerClass;
        this.level = level;
        this.healthPoints = healthPoints;
        this.magicPoints = magicPoints;
        this.defensePoints = defensePoints;
        this.speed = speed;
    }

    private void setIVs() {
        Random random = new Random();
        int aux;
        this.ivHealthPoints = 0;
        for(int i = 0; i < 3; i++){
            aux = random.nextInt(10) + 1;
            if(aux > this.ivHealthPoints){
                this.ivHealthPoints = aux;
            }
        }

        this.iVMagicPoints = 0;
        for(int i = 0; i < 3; i++){
            aux = random.nextInt(10) + 1;
            if(aux > this.iVMagicPoints){
                this.iVMagicPoints = aux;
            }
        }

        this.iVDefensePoints = 0;
        for(int i = 0; i < 3; i++){
            aux = random.nextInt(10) + 1;
            if(aux > this.iVDefensePoints){
                this.iVDefensePoints = aux;
            }
        }

        this.ivSpeed = 0;
        for(int i = 0; i < 3; i++){
            aux = random.nextInt(10) + 1;
            if(aux > this.ivSpeed){
                this.ivSpeed = aux;
            }
        }
    }

    private void initPlayerValues(int playerClass) {
        switch (playerClass){
            case 0:
                this.baseHealthPoints = 75 + this.ivHealthPoints;
                this.baseMagicPoints = 125 + this.ivHealthPoints;
                this.baseDefensePoints = 100 + this.ivHealthPoints;
                break;
            case 1:
                this.baseHealthPoints = 100 + this.ivHealthPoints;
                this.baseMagicPoints = 100 + this.ivHealthPoints;
                this.baseDefensePoints = 100 + this.ivHealthPoints;
                break;
            case 2:
                this.baseHealthPoints = 120 + this.ivHealthPoints;
                this.baseMagicPoints = 60 + this.ivHealthPoints;
                this.baseDefensePoints = 120 + this.ivHealthPoints;
                break;
        }

        this.healthPoints = this.baseHealthPoints;
        this.magicPoints = this.baseMagicPoints;
        this.defensePoints = this.baseDefensePoints;
    }

    public void levelUp(){
        this.level = this.level + 1;
        this.expToLevelUp = (int) (this.level * 100 * 1.25);
        this.exp = 0;

        Random random = new Random();
        for(int i = 0; i < 3; i++){
            int aux = this.baseHealthPoints + random.nextInt(this.ivHealthPoints) + 1;
            if(aux > this.baseHealthPoints){
                this.baseHealthPoints = aux;
            }
        }

        for(int i = 0; i < 3; i++){
            int aux = this.baseMagicPoints + random.nextInt(this.iVMagicPoints) + 1;
            if(aux > this.baseMagicPoints){
                this.baseMagicPoints = aux;
            }
        }

        for(int i = 0; i < 3; i++){
            int aux = this.baseDefensePoints + random.nextInt(this.iVDefensePoints) + 1;
            if(aux > this.baseDefensePoints){
                this.baseDefensePoints = aux;
            }
        }

        for(int i = 0; i < 3; i++){
            int aux = this.speed + random.nextInt(this.ivSpeed) + 1;
            if(aux > this.speed){
                this.speed = aux;
            }
        }

        this.healthPoints = this.baseHealthPoints;
        this.magicPoints = this.baseMagicPoints;
        this.defensePoints = this.baseDefensePoints;
    }

    public void restoreHealth(){
        this.healthPoints = this.baseHealthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(int playerClass) {
        this.playerClass = playerClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getExpToLevelUp() {
        return expToLevelUp;
    }

    public void setExpToLevelUp(int expToLevelUp) {
        this.expToLevelUp = expToLevelUp;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getBaseHealthPoints() {
        return baseHealthPoints;
    }

    public void setBaseHealthPoints(int baseHealthPoints) {
        this.baseHealthPoints = baseHealthPoints;
    }

    public int getBaseMagicPoints() {
        return baseMagicPoints;
    }

    public void setBaseMagicPoints(int baseMagicPoints) {
        this.baseMagicPoints = baseMagicPoints;
    }

    public int getBaseDefensePoints() {
        return baseDefensePoints;
    }

    public void setBaseDefensePoints(int baseDefensePoints) {
        this.baseDefensePoints = baseDefensePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMagicPoints() {
        return magicPoints;
    }

    public void setMagicPoints(int magicPoints) {
        this.magicPoints = magicPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
