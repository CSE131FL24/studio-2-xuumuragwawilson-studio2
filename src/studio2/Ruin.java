package studio2;

import java.util.Scanner;


public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How much money are you starting with?");
		double startAmount = in.nextDouble();
		System.out.println("What is your win probability? (in decimals)");
		double winChance = in.nextDouble();
		System.out.println("How much money would you say is enough for you to leave?");
		double winLimit = in.nextDouble();
		System.out.println("What are the total number of simulations you want to run?");
		int totalSimulations = in.nextInt();
		 simulateGambling(startAmount, winChance, winLimit, totalSimulations);
    }

    public static void simulateGambling(double startAmount, double winChance, double winLimit, int totalSimulations) {
        int ruinCount = 0;

        for (int sim = 1; sim <= totalSimulations; sim++) {
            int plays = 0;
            double money = startAmount;

            while (money > 0 && money < winLimit) {
                plays++;
                if (Math.random() < winChance) {
                    money++;
                } else {
                    money--;
                }
                if (money == 0) {
                	ruinCount++;
                	System.out.println("Simulation " + sim + ": " + plays + " LOSE");
                } else {
                    System.out.println("Simulation " + sim + ": " + plays + " WIN");
                		}
            		}

            double ruinRate = (double) ruinCount / totalSimulations;
            System.out.println("Losses: " + ruinCount + " Simulations: " + totalSimulations);
            System.out.println("Ruin Rate from Simulation: " + ruinRate);
            	calculateExpectedRuinRate(startAmount, winChance, winLimit);
        		}
            }
        public static void calculateExpectedRuinRate(double startAmount, double winChance, double winLimit) {
            double loseChance = 1 - winChance;
            if (winChance == 0.5) {
                double expectedRuinRate = 1 - ((double) startAmount / winLimit);
                System.out.println("Expected Ruin Rate: " + expectedRuinRate);
            } else {
                double ratio = loseChance / winChance;
                double expectedRuinRate = (Math.pow(ratio, startAmount) - Math.pow(ratio, winLimit)) / (1 - Math.pow(ratio, winLimit));
                System.out.println("Expected Ruin Rate: " + expectedRuinRate);
            }
        }
  	}

