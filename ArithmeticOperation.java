/* Arithmetic Operation like add-subtract-multiply-divide 
 * Date: 26|9|2024
 * Name : Aryan Saxena
 */

package Assignment_task_4_1;

import java.util.Scanner;

//Arithmetic Class to perform add-subtract-divide-multiply
public class ArithmeticOperation {
	Scanner input = new Scanner(System.in);
	private String number1;
	private String number2;
	
	//making instance of class conversion to use methods
	Conversion obj = new Conversion();
	
	//Input the Numbers
	void inputNumbers() {
		System.out.print(Constant.ENTER_NUMBER);
		number1 = input.nextLine();
		System.out.print(Constant.ENTER_NUMBER);
		number2 = input.nextLine();
	}
	
	//Binary-octal-hexadecimal-decimal operations are there, we will check if number 
	// is valid or not 
	void binaryOperations() {
		obj.number2 = number1;
		boolean checkForFirstNumber = obj.checkBinary();
		obj.number2 = number2;
		boolean checkForSecondNumber = obj.checkBinary();
		
		if(checkForFirstNumber || checkForSecondNumber) {
			System.out.println(Constant.RESTART);
		}else {
			optionsForOperator(2);
		}
		
	}
	
	void octalOperations() {
		obj.number2 = number1;
		boolean checkForFirstNumber = obj.checkOctal();
		obj.number2 = number2;
		boolean checkForSecondNumber = obj.checkOctal();
		
		if(checkForFirstNumber || checkForSecondNumber) {
			System.out.println(Constant.RESTART);
		}else {
			optionsForOperator(8);
		}
	}
	
	void hexOperations() {
		obj.number2 = number1;
		boolean checkForFirstNumber = obj.checkHex();
		obj.number2 = number2;
		boolean checkForSecondNumber = obj.checkHex();
		
		if(checkForFirstNumber || checkForSecondNumber) {
			System.out.println(Constant.RESTART);
		}else {
			optionsForOperator(16);
		}
	}
	
	void decimalOperations() {
		System.out.print(Constant.ENTER_NUMBER);
		int first_number = input.nextInt();
		System.out.print(Constant.ENTER_NUMBER);
		int second_number = input.nextInt();
		
		obj.number1 = first_number;
		boolean checkForFirstNumber = obj.checkDecimal();
		obj.number1 = second_number;
		boolean checkForSecondNumber = obj.checkDecimal();
		
		if(checkForFirstNumber || checkForSecondNumber) {
			System.out.println(Constant.RESTART);
		}else {
			System.out.println(Constant.OPERATION_PERFORM);
			char operator = input.next().charAt(0);
			int sum = 0;
			switch(operator) {
			case '+':
				sum = first_number+second_number;
				System.out.println(Constant.RESULT+sum);
				break;
			case '-':
				sum = first_number-second_number;
				System.out.println(Constant.RESULT+sum);
				break;
			case '*':
				sum = first_number*second_number;
				System.out.println(Constant.RESULT+sum);
				break;
			case '/':
				try {
					if(second_number == 0) {
						throw new Exception(Constant.DENOMINATOR_ZERO);
					}
				}catch(Exception e) {
					System.out.println(e);
				}
				sum = first_number/second_number;
				System.out.println(Constant.RESULT+sum);
				break;
			default:
				System.out.println(Constant.CORRECT_OPERATOR);
			}
		}
		
	}
	
	// based upon value 2-8-16
	// particular operations will be performed
	void optionsForOperator(int value) {
		System.out.println(Constant.OPERATION_PERFORM);
		char operator = input.next().charAt(0);
		switch(operator) {
		case '+':
			doOperations(operator,value);
			break;
		case '-':
			doOperations(operator,value);
			break;
		case '*':
			doOperations(operator,value);
			break;
		case '/':
			doOperations(operator,value);
			break;
		default:
			System.out.println(Constant.CORRECT_OPERATOR);
		}
	}
	
	
	// Converting inputs numbers to decimal number
	// and then perform operations on decimal number
	// convert the decimal number to octal-hexa-binary
	void doOperations(char operator,int value) {
		obj.number2 = number1;
		int first_decimal = obj.anthingToDecimal(value);
		
		obj.number2 = number2;
		int second_decimal = obj.anthingToDecimal(value);
		
		int sum = 0;
		if(operator == '+') {
			 sum = first_decimal + second_decimal;
		}else if(operator == '-') {
			 sum = first_decimal - second_decimal;
		}else if(operator == '*') {
			 sum = first_decimal * second_decimal;
		}else if(operator == '/') {
			try {
				if(second_decimal == 0) {
					throw new Exception(Constant.DENOMINATOR_ZERO);
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			 sum = first_decimal / second_decimal;
		}
		
		obj.number1 = sum;
		obj.decimalToAnything(value);
		
	}
	

}
