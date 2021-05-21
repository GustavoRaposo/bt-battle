package com.gustavoraposo.btbattle.model.data;

import java.util.Random;

public class Battle {
    private Player player1;
    private Player monster;

    public Battle(Player player1, Player monster) {
        this.player1 = player1;
        this.monster = monster;
    }

    private int damage(int magicPoints, int defense, boolean criticalHit) {
        float damage;
        if (criticalHit) {
            damage = (int) (magicPoints * (100 / (100 + defense)) * 1.75);
        } else damage = magicPoints * ((float)100 / (100 + defense));
        return (int) damage;
    }

    private boolean isHit() {
        Random random = new Random();
        return (random.nextInt(20) + 1) != 1;
    }

    private boolean isCritical() {
        Random random = new Random();
        return (random.nextInt(20) + 1) == 20;
    }

    private int compareSpeed(int speedPlayer1, int speedPlayer2) {
        if (speedPlayer1 > speedPlayer2) {
            return 1;
        } else if (speedPlayer1 < speedPlayer2) {
            return 2;
        } else {
            //flip coin
            Random random = new Random();
            return (random.nextInt(2) + 1);
        }
    }

    private boolean runPvE() {
        int turn = 1;
        boolean player1Turn = true;
        boolean monsterTurn = true;

        while (player1.getHealthPoints() > 0 && monster.getHealthPoints() > 0) {

            if (player1Turn && monsterTurn) {
                player1Turn = false;
                monsterTurn = false;
                turn = compareSpeed(player1.getSpeed(), monster.getSpeed());
            } else {
                if (turn == 1) {
                    if (isHit()) {
                        monster.setHealthPoints(
                                monster.getHealthPoints() - damage(player1.getMagicPoints(), monster.getDefensePoints(), isCritical())
                        );
                        player1Turn = true;
                        turn = 2;
                    }
                } else {
                    if (isHit()) {
                        player1.setHealthPoints(
                                player1.getHealthPoints() - damage(monster.getMagicPoints(), player1.getDefensePoints(), isCritical())
                        );
                        monsterTurn = true;
                        turn = 1;
                    }
                }
            }
        }
        return monster.getHealthPoints() <= 0;
    }

    public boolean battle() {
        boolean win;

        if (runPvE()) {
            win = true;
            player1.setExp(player1.getExp() + monster.getExp());
        } else{
            win = false;
            player1.setExp(0);
        }

        return win;
    }
}
