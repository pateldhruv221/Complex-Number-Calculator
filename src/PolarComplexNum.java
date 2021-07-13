/*******************************************
 Dhruv N. Patel
 Mar. 13th, 2021
 A class that represents the polar form of a
 complex number
 *********************************************/

public class PolarComplexNum {
    //------FIELDS------
    private double magnitude, angle; //will be in degrees

    //------CONSTRUCTORS------
    public PolarComplexNum () {
        this.magnitude = 0;
        this.angle = 0;
    }
    public PolarComplexNum (double mag, double angle) {
        this.magnitude = mag;
        this.angle = angle;
    }

    //------METHODS------
    public RecComplexNum getRecFromPolar() {
        double real = this.magnitude*MyMethod.myCos(Math.toRadians(this.angle));
        double imaginary = this.magnitude*MyMethod.mySin(Math.toRadians(this.angle));

        return new RecComplexNum(real, imaginary);
    }
    public void displayPolarForm() {
        System.out.printf("Magnitude: %.2f, Angle: %.2f deg", this.magnitude, this.angle);
    }
    //additional getter methods for Lab 7
    public double getMagnitude() {
        return this.magnitude;
    }
    public double getAngle() {
        return this.angle;
    }
}
