/*******************************************
 Dhruv N. Patel
 Apr. 6th, 2021
 Pre-constructed child class of the PolarComplexNum.
 Comments have been added to this given code to
 clarify aspects of its functionality.
 *********************************************/

public class ComplexMultiDivideClass extends PolarComplexNum {
    //------FIELDS------
    public static int polarCounter = 0; //field keeps track of the number of objects created

    //------CONSTRUCTORS------
    //the appropriate super methods are explicitly called within each child constructor
    public ComplexMultiDivideClass(){
        super();
        polarCounter++;
    }
    public ComplexMultiDivideClass(double magnitude, double angle){
        super(magnitude, angle);
        polarCounter++;
    }

    //------METHODS------
    //returns the static field polarCounter
    public static int getPolarCounter() {
        return polarCounter;
    }
    //multiplication and division methods for complex numbers in polar form
    public static ComplexMultiDivideClass multiply(ComplexMultiDivideClass a, ComplexMultiDivideClass b){
        return new ComplexMultiDivideClass((a.getMagnitude()*b.getMagnitude()), (a.getAngle()+b.getAngle()));
    }
    public static ComplexMultiDivideClass divide(ComplexMultiDivideClass a, ComplexMultiDivideClass b){
        return new ComplexMultiDivideClass((a.getMagnitude()/b.getMagnitude()), (a.getAngle()-b.getAngle()));
    }
    //Overriden method of the Object class, similar to the inherited displayPolarForm() method
    public String toString(){
            return String.format("Magnitude: %.2f, Angle: %.2f degrees", getMagnitude(), getAngle());
    }
}

