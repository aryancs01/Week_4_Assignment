package BinaryConversion;

import java.util.ArrayList;
import java.util.Scanner;

public class binaryConversion {
    public static void main(String[] args) {
    	
    	//Options for Conversion Binary-Decimal-Octal-Hexa
    	// and Arithmetric Operations + - * /
        Scanner sc = new Scanner(System.in);
        System.out.println(Constants.WELCOME_MSG);
        System.out.println(Constants.OPTIONS_1);
        System.out.println(Constants.OPTIONS_2);
        System.out.println(Constants.OPTIONS_3);
        System.out.println(Constants.OPTIONS_4);
        System.out.println(Constants.OPTIONS_5);
        System.out.println(Constants.OPTIONS_6);
        System.out.println(Constants.OPTIONS_7);
        System.out.println(Constants.OPTIONS_8);
        System.out.println(Constants.OPTIONS_9);
        System.out.println(Constants.OPTIONS_10);
        System.out.println(Constants.OPTIONS_11);
        System.out.println(Constants.OPTIONS_12);
        System.out.println(Constants.OPTIONS_13);
        System.out.println(Constants.OPTIONS_14);
        System.out.println(Constants.OPTIONS_15);
        System.out.println(Constants.OPTIONS_16);
        System.out.print(Constants.RESPONSE);
        
        //Error Handling for correct option input
        try {
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    decimalToBinary();
                    break;
                case 2:
                    decimalToOctal();
                    break;
                case 3:
                    decimalToHexa();
                    break;
                case 4:
                    binaryToDecimal();
                    break;
                case 5:
                    binaryToOctal();
                    break;
                case 6:
                    binaryToHexa();
                    break;
                case 7:
                    octalToDecimal();
                    break;
                case 8:
                    octalToBinary();
                    break;
                case 9:
                    octalToHex();
                    break;
                case 10:
                    hexToDecimal();
                    break;
                case 11:
                    hexToBinary();
                    break;
                case 12:
                    hexToOctal();
                    break;
                case 13:
                	binaryOperations();
                	break;
                case 14:
                	decimalOperations();
                	break;
                case 15:
                	octalOperations();
                	break;
                case 16:
                	hexOperations();
                	break;
                default:
                    System.out.println(Constants.OPTIONS_CORR);
            }
        } catch (Exception e) {
            System.out.println(Constants.OPTIONS_NOT_VALID);
        }
    }
    //Decimal to Binary
    // divide the decimal number by 2 and store remainder 
    static void decimalToBinary() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_DECIMAL);
    	int num = sc.nextInt();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	while(num>0) {
    		int res = num%2;
    		result.add(res);
    		num = num/2;
    	}
    	// reverse the array, to get binary from LSB to MSB
    	System.out.println(reverseArray(result));
    }
    
    // Decimal To Octal
    // divide the decimal number by 8 and store remainder 
    static void decimalToOctal() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_DECIMAL);
    	int num = sc.nextInt();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	while(num>0) {
    		int res = num%8;
    		result.add(res);
    		num = num/8;
    	}
    	// reverse the array, to get binary from LSB to MSB
    	System.out.println(reverseArray(result));
    }
    
    // Decimal To Hexa
    // divide the decimal number by 16 and store remainder 
    // in Hexa we have ABCDEF for 10-11-12-13-14-15
    static void decimalToHexa(){
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_DECIMAL);
    	int num = sc.nextInt();
    	ArrayList<String> result = new ArrayList<String>();
    	String[] hexCode = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    	while(num>0) {
    		int res = num%16;
    		//get the hexcode from res
    		result.add(hexCode[res]);
    		num = num/16;
    	}
    	// reverse the array, to get binary from LSB to MSB
    	System.out.println(reverseArrayOfString(result));
    }
    
    //Binary to Decimal
    // now multiple each bit of binary with 2 increasing power 
    static void binaryToDecimal() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_BINARY);
    	String str = sc.nextLine();
    	int sum =0;
    	
    	for(int i=str.length()-1;i>=0;i--) {
    		// Check if binary is correct or not
    		// each bit should 1 or 0
    		if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                System.out.println(Constants.BINARY_NOT_VALID);
                return; 
            }
    		//typecast string to number
    		int digit = str.charAt(i) - '0'; 
            int position = str.length() - 1 - i;
            sum += digit * powerOftwo(position);
    	}
    	
    	System.out.println(sum);
    }
    
    //Binary to octal
    //first convert Binary to Decimal
    // --- multiple each bit of binary with 2 increasing power 
    // Now convert Decimal to octal
    // divide the decimal number by 8 and store remainder 
    static void binaryToOctal() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_BINARY);
    	String str = sc.nextLine();
    	int sum =0;
    	
    	// Binary to Decimal
    	for(int i=str.length()-1;i>=0;i--) {
    		// Check if binary is correct or not
    		// each bit should 1 or 0
    		if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                System.out.println(Constants.BINARY_NOT_VALID);
                return; 
            }
    		int digit = str.charAt(i) - '0'; 
            int position = str.length() - 1 - i;
            sum += digit * powerOftwo(position);
    	}
    	
    	
    	// Decimal to octal
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	while(sum>0) {
    		int res = sum%8;
    		result.add(res);
    		sum = sum/8;
    	}
    	System.out.println(reverseArray(result));
    }
    
    //Binary to Hexa
    //first convert Binary to Decimal
    // --- multiple each bit of binary with 2 increasing power 
    // Now convert Decimal to Hexa
    // divide the decimal number by 16 and store remainder 
    static void binaryToHexa() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_BINARY);
    	String str = sc.nextLine();
    	int sum =0;
    	
    	// Binary to Decimal
    	for(int i=str.length()-1;i>=0;i--) {
    		if (str.charAt(i) != '0' && str.charAt(i) != '1') {
    			// Check if binary is correct or not
        		// each bit should 1 or 0
                System.out.println(Constants.BINARY_NOT_VALID);
                return; 
            }
    		int digit = str.charAt(i) - '0'; 
            int position = str.length() - 1 - i;
            sum += digit * powerOftwo(position);
    	}
    	
    	//Decimal to Hex
    	ArrayList<String> result = new ArrayList<String>();
    	String[] hexCode = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    	while(sum>0) {
    		int res = sum%16;
    		result.add(hexCode[res]);
    		sum = sum/16;
    	}
    	System.out.println(reverseArrayOfString(result));
    }
    
    //Octal To Decimal
    // Multiply each digit of octal with 8 increasing power
    static void octalToDecimal() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_OCTAL);
    	String str = sc.nextLine();
    	int sum =0;
    	
    	for(int i=str.length()-1;i>=0;i--) {
    		if (str.charAt(i) > '7') {
    			System.out.println(Constants.OCTAL_NOT_VALID);
                return; 
            }
    		int digit = str.charAt(i) - '0'; 
            int position = str.length() - 1 - i;
            sum += digit * powerOfEight(position);
    	}
    	
    	System.out.println(sum);
    }
    
    //Octal To Binary
    // Convert Octal to Decimal 
    // Multiply each digit of octal with 8 increasing power
    // then convert decimal to binary
    // divide decimal number by 2 and store remainder
    static void octalToBinary() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_OCTAL);
    	String str = sc.nextLine();
    	int sum =0;
    	
    	for(int i=str.length()-1;i>=0;i--) {
    		if (str.charAt(i) > '7') {
    			System.out.println(Constants.OCTAL_NOT_VALID);
                return; 
            }
    		int digit = str.charAt(i) - '0'; 
            int position = str.length() - 1 - i;
            sum += digit * powerOfEight(position);
    	}
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	while(sum>0) {
    		int res = sum%2;
    		result.add(res);
    		sum = sum/2;
    	}
    	System.out.println(reverseArray(result));
    }
    
  //Octal To Hex
    // Convert Octal to Decimal 
    // Multiply each digit of octal with 8 increasing power
    // then convert decimal to binary
    // divide decimal number by 16 and store remainder
    static void octalToHex() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_OCTAL);
    	String str = sc.nextLine();
    	int sum =0;
    	
    	for(int i=str.length()-1;i>=0;i--) {
    		if (str.charAt(i) > '7') {
                System.out.println(Constants.OCTAL_NOT_VALID);
                return; 
            }
    		int digit = str.charAt(i) - '0'; 
            int position = str.length() - 1 - i;
            sum += digit * powerOfEight(position);
    	}
    	
    	ArrayList<String> result = new ArrayList<String>();
    	String[] hexCode = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    	while(sum>0) {
    		int res = sum%16;
    		result.add(hexCode[res]);
    		sum = sum/16;
    	}
    	System.out.println(reverseArrayOfString(result));
    }
    
    //Convert Hex to decimal
    //multiple each Hex digit with 16 increasing power
    //Check HexCode array 
    static void hexToDecimal() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_HEX);
    	String str = sc.nextLine();
    	int sum =0;
    	String hexCode = "0123456789ABCDEF";
  
    	for(int i=str.length()-1;i>=0;i--) {
    	
    		char curr = str.charAt(i);
    		if (hexCode.indexOf(curr) == -1) {
                System.out.println(Constants.HEX_NOT_VALID);
                return; 
            }
            int digit = hexCode.indexOf(curr);
            int position = str.length() - 1 - i;
            sum += digit * powerOfSixteen(position);
    	}
    	
    	System.out.println(sum);
    }
    
    //Convert Hex to Binary
    // Hex to decimal
    //multiple each Hex digit with 16 increasing power
    //Check HexCode array 
    // decimal to binary
    static void hexToBinary() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_HEX);
    	String str = sc.nextLine();
    	int sum =0;
    	 String hexCode = "0123456789ABCDEF";
    	for(int i=str.length()-1;i>=0;i--) {
    		char curr = str.charAt(i);
    		if (hexCode.indexOf(curr) == -1) {
                System.out.println(Constants.HEX_NOT_VALID);
                return; 
            }
            int digit = hexCode.indexOf(curr);
            int position = str.length() - 1 - i;
            sum += digit * powerOfSixteen(position);
    	}
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	while(sum>0) {
    		int res = sum%2;
    		result.add(res);
    		sum = sum/2;
    	}
    	System.out.println(reverseArray(result));
    }
    
    //Convert Hex to Octal
    // Hex to decimal
    // multiple each Hex digit with 16 increasing power
    // Check HexCode array 
    // decimal to Octal
    static void hexToOctal() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.ENTER_HEX);
    	String str = sc.nextLine();
    	int sum =0;
    	 String hexCode = "0123456789ABCDEF";
    	for(int i=str.length()-1;i>=0;i--) {
    		char curr = str.charAt(i);
    		if (hexCode.indexOf(curr) == -1) {
                System.out.println(Constants.HEX_NOT_VALID);
                return; 
            }
            int digit = hexCode.indexOf(curr);
            int position = str.length() - 1 - i;
            sum += digit * powerOfSixteen(position);
    	}
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	while(sum>0) {
    		int res = sum%8;
    		result.add(res);
    		sum = sum/8;
    	}
    	System.out.println(reverseArray(result));
    }
    
    // Binary Operations - add subtract multiply divide
    static void binaryOperations() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.OPERATION);
    	char operation = sc.next().charAt(0);
    	
    	// choose operator
    	switch(operation) {
    	case '+':
    		addBinary();
    		break;
    	case '-':
    		subtractBinary();
    		break;	
    	case '*':
    		multiplyBinary();
    		break;	
    	case '/':
    		divideBinary();
    		break;
    	default:
    		System.out.println(Constants.OPERATIONS_NOT_VALID);
    	}
    }
    
    //Add binary Number
    // Convert Binary to Decimal 
    // and then do add operation
    public static void addBinary() {
    	Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_BINARY);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_BINARY);
    	String str2 = sc.nextLine();

    	int num1 = getBinary(str1);
    	int num2 = getBinary(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Your binary is incorrect");
    	}
    	else {
    		int sum = num1 + num2;
        	System.out.println("Add of two binary is "+getDecimal(sum));
    	}
    	
    	
    }
    
    //Subtract binary Number
    // Convert Binary to Decimal 
    // and then do Subtract operation
    public static void subtractBinary() {
    	Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_BINARY);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_BINARY);
    	String str2 = sc.nextLine();

    	int num1 = getBinary(str1);
    	int num2 = getBinary(str2);
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Your binary is incorrect");
    	}
    	else {
    		int sum = 0;
        	if(num1 > num2) {
        		 sum = num1 - num2;
        	}else {
        		 sum = num2 - num1;
        	}
        
        	System.out.println("Subtract of two binary is "+getDecimal(sum));
    	}
    	
    }
    
    //Multiply binary Number
    // Convert Binary to Decimal 
    // and then do Multiply operation
    public static void multiplyBinary() {
    	Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_BINARY);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_BINARY);
    	String str2 = sc.nextLine();

    	int num1 = getBinary(str1);
    	int num2 = getBinary(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Your binary is incorrect");
    	}else {
    		int sum = num1*num2;
        	System.out.println("Multiply of two binary is "+getDecimal(sum));
    	}
    	
    }
    
    //Divide binary Number
    // Convert Binary to Decimal 
    // and then do Divide operation
    public static void divideBinary() {
    	Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_BINARY);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_BINARY);
    	String str2 = sc.nextLine();

    	int num1 = getBinary(str1);
    	int num2 = getBinary(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Your binary is incorrect");
    	}else {
    		int sum = 0;
    		if(num2 == 0) {
    			System.out.println("Denominator is 0");
    		}else {
    			sum = num1/num2;
    			System.out.println("Divide of two binary is "+getDecimal(sum));
    		}
        	
    	}
    	
    }
    
    // Decimal Operations - add subtract multiply divide
    public static void decimalOperations() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.OPERATION);
    	char operation = sc.next().charAt(0);
    	
    	System.out.print(Constants.ENTER_DECIMAL);
    	int num1 = sc.nextInt();
    	System.out.print(Constants.ENTER_DECIMAL);
    	int num2 = sc.nextInt();
    	
    	switch(operation) {
    	case '+':
    		System.out.println("Sum of two Decimal Number: " + num1+num2);
    		break;
    	case '-':
    		System.out.println("Subtract of two Decimal Number: " + num1+num2);
    		break;	
    	case '*':
    		System.out.println("Multiply of two Decimal Number: " + num1*num2);
    		break;	
    	case '/':
    		if(num2 == 0) {
    			System.out.println("Denominator is zero");
    			break;
    		}else {
    			float sum =(float)num1/num2;
        		System.out.println("Divide of two Decimal Number: " + sum);
        		break;
    		}
    		
    	default:
    		System.out.println(Constants.OPERATIONS_NOT_VALID);
    	}
    }
    
    // Octal Operations - add subtract multiply divide
    public static void octalOperations() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.OPERATION);
    	char operation = sc.next().charAt(0);
    	
    	switch(operation) {
    	case '+':
    		addOctal();
    		break;
    	case '-':
    		subtractOctal();
    		break;	
    	case '*':
    		multiplyOctal();
    		break;	
    	case '/':
    		divideOctal();
    		break;
    	default:
    		System.out.println(Constants.OPERATIONS_NOT_VALID);
    	}
     }

    //add Octal Number
    // Convert Octal to Decimal 
    // and then do add operation
	public static void addOctal() {
		Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_OCTAL);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_OCTAL);
    	String str2 = sc.nextLine();

    	int num1 = getOctToDecimal(str1);
    	int num2 = getOctToDecimal(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Incorrect Octal");
    	}else {
    		int sum = num1 + num2;
        	System.out.println("Add of two Octal is "+getOctal(sum));
    	}
    	
	}
	
	//subtract Octal Number
    // Convert Octal to Decimal 
    // and then do subtract operation
	public static void subtractOctal() {
		Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_OCTAL);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_OCTAL);
    	String str2 = sc.nextLine();

    	int num1 = getOctToDecimal(str1);
    	int num2 = getOctToDecimal(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Incorrect Octal");
    	}else {
    		int sum = num1 - num2;
        	System.out.println("Subtract of two Octal is "+getOctal(sum));
    	}
 
	}
	
	//multiply Octal Number
    // Convert Octal to Decimal 
    // and then do multiply operation
	public static void multiplyOctal() {
		Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_OCTAL);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_OCTAL);
    	String str2 = sc.nextLine();

    	int num1 = getOctToDecimal(str1);
    	int num2 = getOctToDecimal(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Incorrect Octal");
    	}else {
    		int sum = num1 * num2;
        	System.out.println("Multiply of two Octal binary is "+getOctal(sum));
    	}
    	
	}
	
	// divide Octal Number
    // Convert Octal to Decimal 
    // and then do divide operation
	public static void divideOctal() {
		Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_OCTAL);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_OCTAL);
    	String str2 = sc.nextLine();

    	int num1 = getOctToDecimal(str1);
    	int num2 = getOctToDecimal(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Incorrect Octal");
    	}else {
    		int sum = 0;
        	if(num2 == 0) {
        		System.out.println("Denominator is zero");
        		return;
        	}else {
        	   sum = num1/num2;
        	   System.out.println("Divide of two Octal number is "+getOctal(sum));
        	}
        	
    	}
    	
	}
	
	// Hexa Operations - add subtract multiply divide
	public static void hexOperations() {
		Scanner sc = new Scanner(System.in);
    	System.out.println(Constants.OPERATION);
    	char operation = sc.next().charAt(0);
    	
    	switch(operation) {
    	case '+':
    		addHex();
    		break;
    	case '-':
    		subtractHex();
    		break;	
    	case '*':
    		multiplyHex();
    		break;	
    	case '/':
    		divideHex();
    		break;
    	default:
    		System.out.println(Constants.OPERATIONS_NOT_VALID);
    	}
	}
	
	// multiply Hex Number
    // Convert Octal to Decimal 
    // and then do multiply operation
	public static void multiplyHex() {
		Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_HEX);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_HEX);
    	String str2 = sc.nextLine();

    	int num1 = getHexToDecimal(str1);
    	int num2 = getHexToDecimal(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Hexa number is not valid");
    	}else {
    		int sum = num1 * num2;
        	System.out.println("Multiply of two Hex is "+getHex(sum));
    	}
    	
	}
	
	// divide Hex Number
    // Convert Octal to Decimal 
    // and then do divide operation
	public static void divideHex() {
		Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_HEX);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_HEX);
    	String str2 = sc.nextLine();

    	int num1 = getHexToDecimal(str1);
    	int num2 = getHexToDecimal(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Hexa number is not valid");
    	}else {
    		int sum = 0;
        	if(num2 == 0) {
        		System.out.println("Denominator is 0");
        	}else {
        		sum = num1/num2;
        	}
        	System.out.println("Divide of two Hex is "+getHex(sum));
    	}
    	
	}
	
	// subtract Hex Number
    // Convert Octal to Decimal 
    // and then do subtract operation
	public static void subtractHex() {
		Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_HEX);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_HEX);
    	String str2 = sc.nextLine();

    	int num1 = getHexToDecimal(str1);
    	int num2 = getHexToDecimal(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Hexa number is not valid");
    	}else {
    		int sum = num1 - num2;
        	System.out.println("Subtract of two Hex is "+getHex(sum));
    	}
    	
	}
	
	// add Hex Number
    // Convert Octal to Decimal 
    // and then do add operation
	public static void addHex() {
		Scanner sc = new Scanner(System.in);
    	System.out.print(Constants.ENTER_HEX);
    	String str1 = sc.nextLine();
    	System.out.print(Constants.ENTER_HEX);
    	String str2 = sc.nextLine();

    	int num1 = getHexToDecimal(str1);
    	int num2 = getHexToDecimal(str2);
    	
    	if(num1 == -1 || num2 == -1) {
    		System.out.println("Hexa number is not valid");
    	}else {
    		int sum = num1 + num2;
        	System.out.println("Add of two Hex is "+getHex(sum));
    	}
	}
	
	//Convert Hex to decimal
	public static int getHexToDecimal(String str) {
		int sum =0;
    	String hexCode = "0123456789ABCDEF";
  
    	for(int i=str.length()-1;i>=0;i--) {
    	
    		char curr = str.charAt(i);
    		if (hexCode.indexOf(curr) == -1) {
                System.out.println(Constants.HEX_NOT_VALID);
                return -1; 
            }
            int digit = hexCode.indexOf(curr);
            int position = str.length() - 1 - i;
            sum += digit * powerOfSixteen(position);
    	}
    	return sum;
	}
	
	// convert decimal to hex
	public static StringBuilder getHex(int num) {
		ArrayList<String> result = new ArrayList<String>();
    	String[] hexCode = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    	while(num>0) {
    		int res = num%16;
    		result.add(hexCode[res]);
    		num = num/16;
    	}
    	return reverseArrayOfString(result);
	}
	
	//convert oct to decimal
	public static int getOctToDecimal(String str) {
		int sum = 0;
    	for(int i=str.length()-1;i>=0;i--) {
    		if (str.charAt(i) > '7') {
    			System.out.println(Constants.OCTAL_NOT_VALID);
                return -1; 
            }
    		int digit = str.charAt(i) - '0'; 
            int position = str.length() - 1 - i;
            sum += digit * powerOfEight(position);
    	}
    	return sum;
	}
	
	//convert decimal to octal
	public static StringBuilder getOctal(int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
    	while(sum>0) {
    		int res = sum%8;
    		result.add(res);
    		sum = sum/8;
    	}
    	return reverseArray(result);
	}
	
	//convert binary to decimal
    public static int getBinary(String str) {
    	int sum = 0;
    	for(int i=str.length()-1;i>=0;i--) {
    		if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                System.out.println(Constants.BINARY_NOT_VALID);
                return -1; 
            }
    		int digit = str.charAt(i) - '0'; 
            int position = str.length() - 1 - i;
            sum += digit * powerOftwo(position);
    	}
    	return sum;
    }
    
  //convert decimal to binary
    public static StringBuilder  getDecimal(int num) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	while(num>0) {
    		int res = num%2;
    		result.add(res);
    		num = num/2;
    	}
    	return reverseArray(result);
    }
    
    //reverse array Integer , to get Binary from msb to lsb
    static StringBuilder reverseArray(ArrayList<Integer> result) {
    	StringBuilder result1 = new StringBuilder();
    	
    	for(int i=result.size()-1;i>=0;i--) {
    		result1.append(result.get(i));
    	}
    	
    	return result1;
    }

  //reverse array String , to get Binary from msb to lsb
    static StringBuilder reverseArrayOfString(ArrayList<String> result) {
    	StringBuilder result1 = new StringBuilder();
    	
    	for(int i=result.size()-1;i>=0;i--) {
    		result1.append(result.get(i));
    	}
    	
    	return result1;
    }
    
    //get power of 2
    static int powerOftwo(int i) {
        int soln = 1;
        for (int j = 0; j < i; j++) {
            soln *= 2; // Multiply soln by 2, i times
        }
        return soln;
    }
    
  //get power of 8
    static int powerOfEight(int i) {
        int soln = 1;
        for (int j = 0; j < i; j++) {
            soln *= 8; // Multiply soln by 2, i times
        }
        return soln;
    }
    
  //get power of 16
    
    static int powerOfSixteen(int i) {
        int soln = 1;
        for (int j = 0; j < i; j++) {
            soln *= 16; // Multiply soln by 2, i times
        }
        return soln;
    }

}