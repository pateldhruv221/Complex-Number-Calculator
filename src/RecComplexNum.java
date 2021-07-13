/*******************************************
 Dhruv N. Patel
 Mar. 13th, 2021
 A class that represents the rectangular form of a
 complex number
 *********************************************/

public class RecComplexNum {
    //------FIELDS------
    private double real,  imaginary;

    //------CONSTRUCTORS------
    public RecComplexNum() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }
    public RecComplexNum(double re, double im) {
        this.real = re;
        this.imaginary = im;
    }

    //------METHODS------
    public PolarComplexNum getPolarFromRec() {
        double magnitude = MyMethod.mySqrt(MyMethod.myPow(this.real, 2) + MyMethod.myPow(this.imaginary, 2));
        double angle = Math.toDegrees(Math.atan(this.imaginary/this.real));
        return new PolarComplexNum(magnitude,  angle);
    }
    public void displayRecForm()  {
        //printing the complex num being mindful of its imaginary part's negative sign
        System.out.printf("%.2f ", this.real);
        if (this.imaginary >= 0) {
            System.out.printf("+ %.2fi", this.imaginary);
        } else {
            // - cancels out the minus sign
            System.out.printf("- %.2fi", -this.imaginary);
        }
    }
    //additional getter methods for Lab 7
    public double getReal() {
        return this.real;
    }
    public double getImaginary() {
        return this.imaginary;
    }

    public static void main(String[] args) {
        new RecComplexNum(1, 1).getPolarFromRec().displayPolarForm();
    }
}
