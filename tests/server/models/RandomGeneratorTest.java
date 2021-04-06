package server.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomGeneratorTest {

    @Test
    public void getRandomInt() {
        int min = 0;
        int max = 10;

        for (int i = 0; i < 1000000; i ++) {
            int randomNum = RandomGenerator.getRandomInt(min, max);
            assertTrue(randomNum >= 0 && randomNum <= 10);
        }
    }

    @Test
    public void chooseBetweenTwoNumsMinBound() {
        int num1 = 1;
        int num2 = 2;
        double probabilityToChooseNum1 = 0.0;

        int randomNum = RandomGenerator.chooseBetweenTwoNums(num1, num2, probabilityToChooseNum1);

        assertEquals(num2, randomNum);
    }

    @Test
    public void chooseBetweenTwoNumsMaxBound() {
        int num1 = 1;
        int num2 = 2;
        double probabilityToChooseNum1 = 1.0;

        int randomNum = RandomGenerator.chooseBetweenTwoNums(num1, num2, probabilityToChooseNum1);

        assertEquals(num1, randomNum);
    }
}