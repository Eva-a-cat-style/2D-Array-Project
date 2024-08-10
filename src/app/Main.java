package app;

//import java.util.Random;
//
//
//public class Main {
//
//    static int[][] nums;
//    static int sumOddNumbers;
//    static int sumEvenNumbers;
//
//
//    public static void main(String[] args) {
//        nums = new int[4][4];
//        Random random = new Random();
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                nums [i][j] = random.nextInt(1, 51);
//            }
//        }
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(nums [i][j] + "|");
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < nums.length; i += 2) {
//            for (int j = 0; j < nums[i].length; j++) {
//                sumOddNumbers += nums[i][j];
//            }
//        }
//
//        System.out.println("\nSum of elements in even lines: " + sumOddNumbers +
//                "range is : \"0,2\"");
//
//
//        for (int i = 1; i < nums.length; i += 2) {
//            for (int j = 0; j < nums[i].length; j++) {
//                sumEvenNumbers += nums[i][j];
//            }
//        }
//
//          long evenMultiplication =1;
//          long nonEvenMultiplication =1;
//
//        System.out.println("Sum of elements in odd lines: " + sumEvenNumbers +
//                "range is : \"1,3\"" );
//
//        for (int j = 0; j < nums[0].length; j += 2) {
//            for (int[] num : nums) evenMultiplication *= num[j];
//        }
//        System.out.print("Multiplication of \"0,2\" pillar is : " + evenMultiplication + "\n");
//
//        for (int j = 1; j < nums[0].length; j += 2)
//            for (int[] num : nums) {
//                nonEvenMultiplication *= num[j];
//            }
//        System.out.print("Multiplication of \"1,3\" pillar is : " + nonEvenMultiplication);
//        if (magicQuad(nums)) {
//
//            System.out.println("\nIt's a magic quadrate");
//        } else {
//            System.out.println("\nIt's not a magic quadrate.");
//        }
//    }
//
//
//
//    public static boolean magicQuad(int[][] square) {
//        int a = square.length;
//        int magSum = 0;
//
//        for (int j = 0; j < a; j++) {
//            magSum += square[0][j];
//        }
//
//        for (int i = 1; i < a; i++) {
//            int rSum = 0;
//            for (int j = 0; j < a; j++) {
//                rSum += square[i][j];
//            }
//            if (rSum != magSum) {
//                return false;
//            }
//        }
//
//        for (int j = 0; j < a; j++) {
//            int cSum = 0;
//            for (int[] ints : square) {
//                cSum += ints[j];
//            }
//            if (cSum != magSum) {
//                return false;
//            }
//        }
//
//        int dSum = 0;
//        for (int i = 0; i < a; i++) {
//            dSum += square[i][i];
//        }
//        if (dSum != magSum) {
//            return false;
//        }
//
//        int dSum2 = 0;
//        for (int i = 0; i < a; i++) {
//            dSum2 += square[i][a - i - 1];
//        }
//        return dSum2 == magSum;
//    }
//    }

public class Main {

    static int[][] nums;
    static int evenRows;
    static int oddRows;
    final static int a = 4;

    public static void main(String[] args) {

        nums = new int[][]{
                {23, 45, 12, 37},
                {50, 11, 42, 20},
                {33, 27, 19, 48},
                {8, 39, 6, 4}
        };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(nums[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (i % 2 == 0) {
                    evenRows += nums[i][j];
                } else {
                    oddRows += nums[i][j];
                }
            }
        }
        System.out.println("Sum of elements in even lines: " + evenRows + " range is : \"0,2\"");
        System.out.println("Sum of elements in odd lines: " + oddRows + " range is : \"1,3\"");

        long evenMultiplication = 1;
        long nonEvenMultiplication = 1;

        for (int[] num : nums) {
            for (int j = 0; j < num.length; j++) {
                if (j % 2 == 0) {
                    evenMultiplication *= num[j];
                } else {
                    nonEvenMultiplication *= num[j];
                }
            }
        }
        System.out.println("Multiplication of \"0,2\" pillar is :" + evenMultiplication);
        System.out.println("Multiplication of \"1,3\" pillar is :" + nonEvenMultiplication);


        boolean magicQuad = true;

        int sum0 = 0;
        int sum1 = 0;

        for (int i = 0; i < a; i++) {
            sum0 += nums[i][i];
            sum1 += nums[i][a - 1 - i];
        }
        if ( sum0 != sum1) magicQuad = false;

        for (int i = 0; i < a; i++){
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < a; j++) {
                rowSum += nums[i][j];
                colSum += nums[i][j];
            }
            if (rowSum != colSum || colSum != sum0)
                magicQuad = false;
        }
        if (magicQuad)
            System.out.println("\nIt's a magic quadrate");
        else
            System.out.println("\nIt's not a magic quadrate");
    }
}
