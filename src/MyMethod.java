/*******************************************
 Dhruv N. Patel
 Created Mar. 9th, 2021
 Updated Apr. 1st, 2021 (mySqrt() method added)
 A class that holds similar methods to java.lang.Math,
 that have been hard-coded by Dhruv N. Patel
 *********************************************/

public class MyMethod {
    public static double myPow (double x, int y) {
        double product = 1;
        //it must be checked whether y is a +ve or -ve integer
        if (y >= 0) //0 case can be grouped with any condition and it would still work the same
            for (int i = 0; i < y; i++)
                product *= x;
        else
            for (int i = 0; i > y; i--)
                product /= x;

        return product;
    }
    //set up to work with doubles rather than integers as the latter causes errors in calculations
    public static double myFactorial (double num) {
        double result = 1;
        for (; num >= 1; num--) {
            result *= num;
        }
        return result;
    }
    public static double mySin (double x) { //x is an angle in radians
        double finalSum = 0, product = 1;
        //for-loop constructed according to the formula in the lab handout
        for (int n = 0; n <= 20; n++) { //N = 20
            //breaking up the formula
            product *= myPow(-1, n);
            product /= myFactorial(2*n + 1);
            product *= myPow(x, 2*n + 1);
            finalSum += product;
            product = 1; //have to re-update this variable every iteration
        }
        return finalSum;
    }
    //very similar to the mySin() method
    public static double myCos (double x) {
        double finalSum = 0, product = 1;
        //for-loop constructed according to the formula in the lab handout
        for (int n = 0; n <= 20; n++) { //N = 20
            //breaking up the formula
            product *= myPow(-1, n);
            product /= myFactorial(2*n);
            product *= myPow(x, 2*n);
            finalSum += product;
            product = 1;
        }
        return finalSum;
    }
    public static double mySqrt (double n) {
        double lastGuess = 1,  nextGuess = 0;
        final double TOLERANCE = 1E-4; //constant value
        /* loop will iterate once since initially the difference between last and
        next guess is greater than the tolerance */
        nextGuess = (lastGuess+(n/lastGuess))/2;
        while (Math.abs(nextGuess-lastGuess) > TOLERANCE) {
            lastGuess = nextGuess;
            nextGuess = (lastGuess+(n/lastGuess))/2;
        }
        return nextGuess;
    }
    public static void printFooter() {
        System.out.println("***Goodbye from Dhruv N. Patel ***");
    }
}
