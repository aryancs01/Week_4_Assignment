/* Main file where user will get Choice to perform operation
 * Date: 26|9|2024
 * Name : Aryan Saxena
 */
package Assignment_task_4_1;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// User will Select following Options
        System.out.println(Constant.WELCOME_MSG);
        System.out.println(Constant.OPTIONS_1);
        System.out.println(Constant.OPTIONS_2);
        System.out.println(Constant.OPTIONS_3);
        System.out.println(Constant.OPTIONS_4);
        System.out.println(Constant.OPTIONS_5);
        System.out.println(Constant.OPTIONS_6);
        System.out.println(Constant.OPTIONS_7);
        System.out.println(Constant.OPTIONS_8);
        System.out.println(Constant.OPTIONS_9);
        System.out.println(Constant.OPTIONS_10);
        System.out.println(Constant.OPTIONS_11);
        System.out.println(Constant.OPTIONS_12);
        System.out.println(Constant.OPTIONS_13);
        System.out.println(Constant.OPTIONS_14);
        System.out.println(Constant.OPTIONS_15);
        System.out.println(Constant.OPTIONS_16);
        System.out.println(Constant.BINARY_CONSTRAINTS);
        System.out.println(Constant.HEXA_OCTAL_CONSTRAINTS);
        System.out.println(Constant.DECIMAL_CONSTRAINTS);
       
        
        // Check if response of user is integer 
        int number = -1;
            while(number!=17) {
            	try {
            	 System.out.print(Constant.RESPONSE);
                	number = input.nextInt();
                    Conversion obj = new Conversion();
                    ArithmeticOperation obj1 = new ArithmeticOperation();
                    switch (number) {
	                    case 1:
	                    	obj.inputDigits();
	                    	obj.decimalToBinary();
	                    	break;
	                    case 2:
	                    	obj.inputDigits();
	                    	obj.decimalToOctal();
	                    	break;
	                    case 3:
	                    	obj.inputDigits();
	                    	obj.decimalToHexa();
	                    	break;
	                    case 4:
	                    	obj.inputString();
	                    	obj.binaryToDecimal();
	                    	break;
	                    case 5:
		                	obj.inputString();
		                    obj.binaryToOctal();
		                    break;
		                case 6:
		                	obj.inputString();
		                    obj.binaryToHexa();
		                    break;
		                case 7:
		                	obj.inputString();
		                    obj.octalToDecimal();
		                    break;
		                case 8:
		                	obj.inputString();
		                    obj.octalToBinary();
		                    break;
		                case 9:
		                	obj.inputString();
		                    obj.octalToHex();
		                    break;
		                case 10:
		                	obj.inputString();
		                    obj.hexToDecimal();
		                    break;
		                case 11:
		                	obj.inputString();
		                    obj.hexToBinary();
		                    break;
		                case 12:
		                	obj.inputString();
		                    obj.hexToOctal();
		                    break;
		                case 13:
		                	obj1.inputNumbers();
		                	obj1.binaryOperations();
		                	break;
		                case 14:
		                	obj1.decimalOperations();
		                	break;
		                case 15:
		                	obj1.inputNumbers();
		                	obj1.octalOperations();
		                	break;
		                case 16:
		                	obj1.inputNumbers();
		                	obj1.hexOperations();
		                	break;
		                case 17:
		                	break;
		                default:
		                	System.out.println(Constant.OPTIONS_CORR);
	                	
                    }
            	}catch(Exception error) {
            		System.out.println("Error in Input");
            		input.nextLine();
            	}
           
            }
            
        } 
	}

