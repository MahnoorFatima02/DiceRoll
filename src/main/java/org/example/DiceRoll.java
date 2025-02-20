package org.example;

import java.util.Random;

public class DiceRoll {
    Random random = new Random();
    int rollCount = 0;

    public int[] rollDice() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        rollCount++;
        return new int[]{die1, die2};
    }

    public boolean isDouble(int die1, int die2) {
        System.out.println("Rolled: " + die1 + " and " + die2);

        return die1 == die2;
    }

    public int rollUntilDouble(){
        rollCount = 0;
        int[] dice;
        do {
            dice = rollDice();
        } while (!isDouble(dice[0], dice[1]));
        return rollCount;
    }


        public static void main(String[] args) {
            DiceRoll roller = new DiceRoll();
            int attempts = roller.rollUntilDouble();
            System.out.println("It took " + attempts + " rolls to get a double.");
        }
    }


