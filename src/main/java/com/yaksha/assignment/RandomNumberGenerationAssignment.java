package com.yaksha.assignment;

import java.util.Random;

public class RandomNumberGenerationAssignment {

	public static void main(String[] args) {

		// Step 1: Random Decimal Number (0 to 1)
		double randomDecimal = Math.random();
		System.out.println("Random Decimal (0-1): " + randomDecimal);

		// Step 2: Random Integer within Range
		Random random = new Random();
		int randomInt = random.nextInt(100) + 1; // Range: 1 to 100
		System.out.println("Random Integer (1-100): " + randomInt);

		// Step 3: Random Floating Point Number within Range
		double randomFloat = 5.5 + (20.5 - 5.5) * random.nextDouble();
		System.out.println("Random Float (5.5-20.5): " + randomFloat);

		// Step 4: Simulate Coin Toss
		int coinToss = random.nextInt(2); // 0 for Heads, 1 for Tails
		System.out.println("Coin Toss: " + (coinToss == 0 ? "Heads" : "Tails"));

		// Step 5: Random Selection from Array
		String[] colors = { "Red", "Green", "Blue", "Yellow", "Orange" };
		int randomIndex = random.nextInt(colors.length);
		System.out.println("Random Color: " + colors[randomIndex]);
	}
}
