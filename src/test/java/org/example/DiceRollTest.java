package org.example;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DiceRollTest {

    @Test
    public void testRollDice() {
        DiceRoll roller = new DiceRoll();
        int[] dice = roller.rollDice();
        assertTrue(dice[0] >= 1 && dice[0] <= 6);
        assertTrue(dice[1] >= 1 && dice[1] <= 6);
    }

    @Test
    public void testIsDouble() {
        DiceRoll roller = new DiceRoll();
        assertTrue(roller.isDouble(3, 3));
        assertFalse(roller.isDouble(2, 5));
    }

    @Test
    public void testRollUntilDouble() {
        DiceRoll roller = new DiceRoll();
        int attempts = roller.rollUntilDouble();
        assertTrue(attempts > 0);
    }

    @Test
    public void testMain() {
        // Capture the output of the main method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the main method
        DiceRoll.main(new String[]{});

        // Check if the output contains the expected strings
        String output = outContent.toString();
        assertTrue(output.contains("It took"));
        assertTrue(output.contains("rolls to get a double."));
    }
}

