/*******************************************
 Dhruv N. Patel
 Created: Apr. 1st, 2021
 Updated: Apr. 6th, 2021
 An updated version of the demo class from Lab 8 Q2.
 Additional options have been added to the menu to
 allow multiplication and division of complex numbers
 *********************************************/

import java.util.Scanner;

public class ComplexNumCalculator {
    public static Scanner input = new Scanner(System.in);
    public static ComplexAddSubClass[] recArray = new ComplexAddSubClass[2];
    public static ComplexMultiDivideClass[] polarArray = new ComplexMultiDivideClass[2];
    public static ComplexAddSubClass result = new ComplexAddSubClass();
    public static ComplexMultiDivideClass mdResult = new ComplexMultiDivideClass();
    public static PolarComplexNum pcn = new PolarComplexNum();
    public static void main(String[] args) {

        RecComplexNum recComplexNum;
        PolarComplexNum polarComplexNum;
        double real = 0, imaginary = 0, magnitude = 0, angle = 0;
        int choice = 0;

        while (true) {
            //MENU
            System.out.println("\n**** Complex Number Adder / Subtractor *****");
            System.out.println("*************************************");
            System.out.println("1) Adder");
            System.out.println("2) Subtractor");
            System.out.println("3) Multiplier");
            System.out.println("4) Divider");
            System.out.println("5) Rectangular/Cartesian to Polar");
            System.out.println("6) Polar to Rectangular/Cartesian");
            System.out.println("7) Exit!");
            System.out.println("*************************************");
            //Asking for user's choice
            System.out.print("What operation would you like to perform: ");
            choice = input.nextInt();
            //executing option based on choice
            switch (choice) {
                case 1:
                    dataEntry();
                    result = ComplexAddSubClass.adder(recArray[0], recArray[1]);
                    System.out.println("Here is your Result of (a + b)");
                    System.out.println("--------------------------");
                    System.out.println("a = " + recArray[0]);
                    System.out.println("b = " + recArray[1]);
                    System.out.println("a + b = " + result);
                    break;
                case 2:
                    dataEntry();
                    result = ComplexAddSubClass.subtractor(recArray[0], recArray[1]);
                    System.out.println("Here is your Result of (a - b)");
                    System.out.println("--------------------------");
                    System.out.println("a = " + recArray[0]);
                    System.out.println("b = " + recArray[1]);
                    System.out.println("a - b = " + result);
                    break;
                case 3:
                    dataEntry();
                    //populating polarArray using elements of recArray
                    for (int i = 0; i < recArray.length; i++) {
                        pcn = recArray[i].getPolarFromRec();
                        polarArray[i] = new ComplexMultiDivideClass(pcn.getMagnitude(), pcn.getAngle());
                    }
                    mdResult = ComplexMultiDivideClass.multiply(polarArray[0], polarArray[1]);
                    //OUTPUT
                    /* Important to note that ComplexMultiDivideClass/the polar complex num objects has
                    an overriden toString() method but RecComplexNum/rectangular complex num objects do not */
                    System.out.println("\nHere is your result of (a x b)");
                    System.out.println("------------------------------");
                    System.out.print("a = ");
                    recArray[0].displayRecForm();
                    System.out.println("; In Polar form => " + polarArray[0]);
                    System.out.print("b = ");
                    recArray[1].displayRecForm();
                    System.out.print("; In Polar form => " + polarArray[1]);
                    System.out.println("\na x b = (In Polar) " + mdResult);
                    System.out.print("a x b = (In Rectangle) ");
                    mdResult.getRecFromPolar().displayRecForm();
                    System.out.println(); //formatting
                    break;
                case 4: //very similar to case 3
                    dataEntry();
                    //populating polarArray using elements of recArray
                    for (int i = 0; i < recArray.length; i++) {
                        pcn = recArray[i].getPolarFromRec();
                        polarArray[i] = new ComplexMultiDivideClass(pcn.getMagnitude(), pcn.getAngle());
                    }
                    mdResult = ComplexMultiDivideClass.divide(polarArray[0], polarArray[1]);
                    //OUTPUT
                    /* Important to note that ComplexMultiDivideClass/the polar complex num objects has
                    an overriden toString() method but RecComplexNum/rectangular complex num objects do not */
                    System.out.println("\nHere is your result of (a / b)");
                    System.out.println("------------------------------");
                    System.out.print("a = ");
                    recArray[0].displayRecForm();
                    System.out.println("; In Polar form => " + polarArray[0]);
                    System.out.print("b = ");
                    recArray[1].displayRecForm();
                    System.out.print("; In Polar form => " + polarArray[1]);
                    System.out.println("\na / b = (In Polar) " + mdResult);
                    System.out.print("a / b = (In Rectangle) ");
                    mdResult.getRecFromPolar().displayRecForm();
                    System.out.println(); //formatting
                    break;
                case 5:
                    System.out.println(); //formatting
                    System.out.println("Converting Rectangular/Cartesian To Polar:");
                    System.out.print("Enter real value: ");
                    real = input.nextDouble();
                    System.out.print("Enter imaginary value: ");
                    imaginary = input.nextDouble();
                    recComplexNum = new RecComplexNum(real, imaginary);
                    System.out.println(); //formatting

                    System.out.println("Result in Polar Form");
                    System.out.println("--------------------------");
                    System.out.print("Given Rectangular Form A = ");
                    recComplexNum.displayRecForm();
                    System.out.print("In Polar Form A = ");
                    recComplexNum.getPolarFromRec().displayPolarForm();
                    System.out.println();
                    break;
                case 6:
                    System.out.println(); //formatting
                    System.out.println("Converting Polar to Rectangular/Cartesian form:");
                    System.out.print("Enter magnitude value: ");
                    magnitude = input.nextDouble();
                    System.out.print("Enter angle value in degree: ");
                    angle = input.nextDouble();
                    polarComplexNum = new PolarComplexNum(magnitude, angle);
                    System.out.println();

                    System.out.println("Result in Rectangular Form");
                    System.out.println("--------------------------");
                    System.out.print("Given Polar Form A = ");
                    polarComplexNum.displayPolarForm();
                    System.out.print("In Rectangular Form A = ");
                    polarComplexNum.getRecFromPolar().displayRecForm();
                    System.out.println();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice! Enter any choice between 1 and 3:");
                    break;
            }
            System.out.println();
            if (choice == 7) {
                break;
            }
        }

        MyMethod.printFooter();
    }
    public static void dataEntry() {
        double real = 0, imaginary = 0; //placeholder variables for user input
        for (int i = 0; i < recArray.length; i++) {
            System.out.print("Enter real value " + (i+1) + ": ");
            real = input.nextDouble();
            System.out.print("Enter imaginary value " + (i+1) + ": ");
            imaginary = input.nextDouble();
            recArray[i] = new ComplexAddSubClass(real, imaginary);
        }
    }
}
