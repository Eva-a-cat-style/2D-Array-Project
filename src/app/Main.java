package app;

import java.util.Random;


public class Main {
     static int[][] nums;
    static int sumOddNumbers;
    static int sumEvenNumbers;
    static long evenMultiplication = 1;
    static long nonEvenMultiplication = 1;


    public static void main(String[] args) {
        nums = new int[4][4];
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nums [i][j] = random.nextInt(1, 51);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(nums [i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i].length; j++) {
                sumOddNumbers += nums[i][j];
            }
        }

        System.out.println("\nSum of elements in even lines: " + sumOddNumbers +
                "range is : \"0,2\"");

        for (int i = 1; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i].length; j++) {
                sumEvenNumbers += nums[i][j];
            }
        }

        System.out.println("Sum of elements in odd lines: " + sumEvenNumbers +
                "range is : \"1,3\"" );
        evenMultiplication = 1;
        for (int j = 0; j < nums[0].length; j += 2) {
            for (int[] num : nums) evenMultiplication *= num[j];
        }
        System.out.print("Multiplication of \"0,2\" pillar is : " + evenMultiplication + "\n");
        nonEvenMultiplication = 1;
        for (int j = 1; j < nums[0].length; j += 2)
            for (int[] num : nums) {
                nonEvenMultiplication *= num[j];
            }
        System.out.print("Multiplication of \"1,3\" pillar is : " + nonEvenMultiplication);
        if (magicSquad(nums)) {

            System.out.println("\nIt's a magic quadrate");
        } else {
            System.out.println("\nIt's not a magic quadrate.");
        }
    }



    public static boolean magicSquad(int[][] square) {
        int a = square.length;
        int magSum = 0;

        for (int j = 0; j < a; j++) {
            magSum += square[0][j];
        }

        for (int i = 1; i < a; i++) {
            int rSum = 0;
            for (int j = 0; j < a; j++) {
                rSum += square[i][j];
            }
            if (rSum != magSum) {
                return false;
            }
        }

        for (int j = 0; j < a; j++) {
            int cSum = 0;
            for (int[] ints : square) {
                cSum += ints[j];
            }
            if (cSum != magSum) {
                return false;
            }
        }

        int dSum = 0;
        for (int i = 0; i < a; i++) {
            dSum += square[i][i];
        }
        if (dSum != magSum) {
            return false;
        }

        int dSum2 = 0;
        for (int i = 0; i < a; i++) {
            dSum2 += square[i][a - i - 1];
        }
        return dSum2 == magSum;
    }
    }

