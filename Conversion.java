/*Convert Binary - Decimal - Hexadecimal - Octal
 * Date: 26|9|2024
 * Name : Aryan Saxena
 */
package Assignment_task_4_1;

import java.util.Scanner;

// Conversion Class is use to convert Convert Binary - Decimal - Hexadecimal - Octal
public class Conversion {
	Scanner input = new Scanner(System.in);
	 int number1; 
	 String number2; 
	
	 void inputDigits() {
		 System.out.print(Constant.ENTER_NUMBER);
		 number1 = input.nextInt();
	 }
	 
	 void inputString() {
		 System.out.print(Constant.ENTER_NUMBER);
		 number2 = input.nextLine();
	 }
	 
	 //Display the result 
	 void displayResult(String result){
		 System.out.print(Constant.RESULT+result);
	 }
	 
	void decimalToBinary(){
		if(checkDecimal()) {
			System.out.println(Constant.RESTART);
		}else {
			decimalToAnything(2);
		}
		
	}
	
	void decimalToOctal() {
		if(checkDecimal()) {
			System.out.println(Constant.RESTART);
		}else {
			decimalToAnything(8);
		}
	}
	
	void decimalToHexa() {
		if(checkDecimal()) {
			System.out.println(Constant.RESTART);
		}else {
			decimalToAnything(16);
		}
	}
	
	void binaryToDecimal() {
		if(checkBinary()) {
			System.out.println(Constant.RESTART);
		}else {
			String result = "" + anthingToDecimal(2);
			displayResult(result);
		}
		
	}
	
	void binaryToOctal() {
		if(checkBinary()) {
			System.out.println(Constant.RESTART);
		}else {
			int decimal = anthingToDecimal(2);
			number1 = decimal;
			decimalToAnything(8);
		}
	}
	
	void binaryToHexa() {
		if(checkBinary()) {
			System.out.println(Constant.RESTART);
		}else {
			int decimal = anthingToDecimal(2);
			number1 = decimal;
			decimalToAnything(16);
		}
	}
	
	void octalToDecimal() {
		if(checkOctal()) {
			System.out.println(Constant.RESTART);
		}else {
			String result = "" +anthingToDecimal(8);
			displayResult(result);
		}
	}
	
	void octalToBinary() {
		if(checkOctal()) {
			System.out.println(Constant.RESTART);
		}else {
			number1 = anthingToDecimal(8);
			decimalToAnything(2);
		}
	}
	
	void octalToHex() {
		if(checkOctal()) {
			System.out.println(Constant.RESTART);
		}else {
			number1 = anthingToDecimal(8);
			decimalToAnything(16);
		}
	}
	
	void hexToDecimal() {
		if(checkHex()) {
			System.out.println(Constant.RESTART);
		}else {
			String result = ""+ anthingToDecimal(16);
			displayResult(result);
		}	
	}
	
	void hexToBinary() {
		if(checkHex()) {
			System.out.println(Constant.RESTART);
		}else {
			number1 = anthingToDecimal(16);
			decimalToAnything(2);
		}
	}
	
	void hexToOctal() {
		if(checkHex()) {
			System.out.println(Constant.RESTART);
		}else {
			number1 = anthingToDecimal(16);
			decimalToAnything(8);
		}
	}
	
	// In this function, a power is passed and this power can be 2-8-16
	// this power will multiple every bit of input number
	int anthingToDecimal(int power) {
		int sum = 0;
		//Array of hexCode from 0 to F 
		char[] hexCode = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		for(int i=0;i<number2.length();i++) {
			// Starting from  least significant bit of input number and storing in currentNumber
			char currentNumber = number2.charAt(number2.length()-i-1);
			//finding index of currentNumber 
			int digit = findIndex(hexCode, currentNumber);
			//updating sum variable 
			sum += power(digit,i,power);
		}
		return sum;
	}
	
	// In this function, we divide decimal number with 2-8-16
	// and store remainder in an array
	// then we reverse a array
	void decimalToAnything(int value){
		int i = 0;
		String[] hexCode = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String[] array = new String[100];
			while(number1>0) {
				int remainder = number1%value;
				array[i] = hexCode[remainder];
				number1 = number1/value;
				i++;
			}
			displayResult(reverseArrayString(array,i));
	}
	
	// Check Binary if each digit is 0 or 1 
	// and length should be less than 10
	boolean checkBinary() {
		for(int i=0;i<number2.length();i++) {
			try {
				if(number2.charAt(i) != '0' && number2.charAt(i) != '1' ) {
					throw new Exception(Constant.NUMBER_isVALID);
				}if(number2.length() > 10) {
					throw new Exception(Constant.NUMBER_isLONG);
				}
			}catch(Exception e) {
				System.out.println(e);
				return true;
			}
		}
		return false;
	}
	
	// Check Octal if each digit should be less than 8
	// and length should be less than 6
	boolean checkOctal() {
		for(int i=0;i<number2.length();i++) {
			try {
				if(number2.charAt(i) > '8' ) {
					throw new Exception(Constant.NUMBER_isVALID);
				}if(number2.length() > 6) {
					throw new Exception(Constant.NUMBER_isLONG);
				}
			}catch(Exception e) {
				System.out.println(e);
				return true;
			}
		}
		return false;
	}
	
	// Check Hex if each digit should be inside of hexCode array
	// and length should be less than 6
	boolean checkHex() {
		char[] hexCode = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		
		for(int i=0;i<number2.length();i++) {
			int index = findIndex(hexCode,number2.charAt(i));
			try {
				if(index == -1) {
					throw new Exception(Constant.NUMBER_isVALID);
				}if(number2.length() > 6) {
					throw new Exception(Constant.NUMBER_isLONG);
				}
			}catch(Exception e) {
				System.out.println(e);
				return true;
			}
		}
		return false;
	}
	
	//Check Decimal, number should be less than 100000
	boolean checkDecimal() {
		try {
			if(number1 > 100000) {
				throw new Exception(Constant.NUMBER_isLONG);
			}
		}catch(Exception e) {
			System.out.println(e);
			return true;
		}
		return false;
	}
	
	// Find the index of current character inside hexCode array
	int findIndex(char[] hexCode,int current) {
		for (int i = 0; i < hexCode.length; i++) {
	        if (hexCode[i] == current) {
	            return i;
	        }
	    }
	    return -1;
	}
	 
	//reverse the array
	String reverseArrayString(String[] array,int length) {
		 String reverseString = "";
		 for(int i=length-1;i>=0;i--) {
			 reverseString += array[i];
		 }
		 return reverseString;
	 }
	 
	// multiple the digit with increasing power of 2-8-16
	 int power(int digit,int count,int power) {
		 int soln = 1;
		 for(int i=0;i<count;i++) {
			 soln*=power;
		 }
		 return digit*soln;
	 }
}
