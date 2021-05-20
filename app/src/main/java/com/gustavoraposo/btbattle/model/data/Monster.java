package com.gustavoraposo.btbattle.model.data;

import java.util.Random;

public class Monster {
    private String monsterName;
    private int monsterClass;
    private int level;
    private int healthPoints;
    private int magicPoints;
    private int defensePoints;
    private int speed;
    private double exp;

    public Monster(String monsterName, int monsterClass, int level) {
        this.monsterName = monsterName;
        this.monsterClass = monsterClass;
        this.level = level;
        this.exp = level * 100 * 0.35;
        initMonsterValues(monsterClass, level);
    }

    private void initMonsterValues(int monsterClass, int level) {
        switch (monsterClass) {
            case 0:
                levelUp(40, 60, 50, 100, level);
                break;
            case 1:
                levelUp(50, 50, 50, 100, level);
                break;
            case 2:
                levelUp(60, 30, 60, 100, level);
                break;
        }
    }

    private void levelUp(
            int healthPoints,
            int magicPoints,
            int defensePoints,
            int speed,
            int level) {

        for (int j = 0; j < level; j++){
            for(int i = 0; i < 3; i++){
                Random random = new Random();
                int aux = healthPoints + random.nextInt(10) + 1;
                if(aux > healthPoints){
                    this.healthPoints = aux;
                }
            }

            for(int i = 0; i < 3; i++){
                Random random = new Random();
                int aux = magicPoints + random.nextInt(10) + 1;
                if(aux > magicPoints){
                    this.magicPoints = aux;
                }
            }

            for(int i = 0; i < 3; i++){
                Random random = new Random();
                int aux = defensePoints + random.nextInt(10) + 1;
                if(aux > defensePoints){
                    this.defensePoints = aux;
                }
            }

            for(int i = 0; i < 3; i++){
                Random random = new Random();
                int aux = speed + random.nextInt(10) + 1;
                if(aux > speed){
                    this.speed = aux;
                }
            }
        }
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterClass() {
        return monsterClass;
    }

    public void setMonsterClass(int monsterClass) {
        this.monsterClass = monsterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }
}
