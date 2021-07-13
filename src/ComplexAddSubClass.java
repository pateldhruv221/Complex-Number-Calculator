/*******************************************
 Dhruv N. Patel
 Apr. 1st, 2021
 Child class of RecComplexNum. Contains additional
 methods and fields for computational purposes.
 *********************************************/

public class ComplexAddSubClass extends RecComplexNum {
    //------FIELDS------
    private static int counter = 0;

    //------CONSTRUCTORS------
    public ComplexAddSubClass()  {
        super();
        counter++;
    }
    public ComplexAddSubClass(double real, double imaginary) {
        super(real, imaginary);
        counter++;
    }

    //------METHODS------
    //discrepancy in lab handout as to whether getCounter() should be member or static method
    //UML on pg. 12 suggests member method
    //Case 3 of swtich statement on pg. 14 suggest static method
    //Since static made the most sense, I went ahead with that definition for the rest of this lab
    public static int getCounter() {
        return counter;
    }
    public static ComplexAddSubClass adder(ComplexAddSubClass a, ComplexAddSubClass b) {
        double realResult = a.getReal() + b.getReal(), imaginaryResult = a.getImaginary() + b.getImaginary();
        return new ComplexAddSubClass(realResult, imaginaryResult);
    }
    public static ComplexAddSubClass subtractor(ComplexAddSubClass a, ComplexAddSubClass b) {
        double realResult = a.getReal() - b.getReal(), imaginaryResult = a.getImaginary() - b.getImaginary();
        return new ComplexAddSubClass(realResult, imaginaryResult);
    }
    public String toString() {
        String toReturn = "";
        toReturn += String.format("%.2f ", this.getReal());
        if (this.getImaginary() >= 0) {
            toReturn += String.format("+ %.2fi", this.getImaginary());
        } else {
            // - cancels out the minus sign
            toReturn += String.format("- %.2fi", -this.getImaginary());
        }
        return toReturn;
    }
}
