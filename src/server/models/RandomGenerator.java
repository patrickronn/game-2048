package server.models;

public class RandomGenerator {

    /**
     * Retrieves a random integer from a specified min to max (inclusive)
     * @param min min int
     * @param max max int
     * @return a random integer from min to max (inclusive)
     */
    public static int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random()*(max-min+1) + min);
    }

    /**
     * Choose between two numbers where the probability of choosing one number is specified
     * @param num1 number 1
     * @param num2 number 2
     * @param probabilityToChooseNum1 probability to choose num1 (must be within 0 to 1)
     * @return num1 if chosen; otherwise, num2
     */
    public static int chooseBetweenTwoNums(int num1, int num2, double probabilityToChooseNum1) {
        if (probabilityToChooseNum1 < 0.0 || probabilityToChooseNum1 > 1.0) {
            throw new IllegalArgumentException("Invalid probability");
        }

        // Get a random decimal between 0 and 1 (exclusive)
        double decimalNum = Math.random();

        // Return num1 if random decimal is within the range of probability to choose it
        if (decimalNum < probabilityToChooseNum1) {
            return num1;
        }
        // Otherwise return num2
        else {
            return num2;
        }
    }
}
