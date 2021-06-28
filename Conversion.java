//package com.training;

import java.util.Scanner;

public class Conversion {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		while(true) {
		System.out.print("Enter a number base \n" + "1. Binary \n" + "2. Decimal \n" + "3. Hexa \n"+ "4. Exit \n");
		String base = input.nextLine();
		if (!(base.equals("1") || base.equals("2") || base.equals("3") || base.equals("4"))) {
			System.out.println("Not valid base selected");
			continue;
		}
		if(base.equals("4") || base.equalsIgnoreCase("Exit")) {
			System.out.println("Good bye!!!");
			System.exit(0);
		}
		
		Scanner inputNumber = new Scanner(System.in);
		System.out.println("Enter number");
		String number = inputNumber.nextLine();

		// obj.convertBinary(124); // decimal to binary convertion
		
		Conversion conversion = new Conversion();

		if (base.equals("1") || base.equalsIgnoreCase("Binary")) {
			// check for binary
			if (!isBinary(Integer.parseInt(number))) {
				System.out.println("Number is not binary");
				continue;
			}
			int decimal = conversion.binaryToDecimal(Integer.parseInt(number));
			System.out.println("Decimal number for Binary " + number + " is " + decimal);
			String hexa = conversion.decimalToHexa(decimal);
			System.out.println("Hexa number for Binary " + number + " is " + hexa);
		}
		if (base.equals("2") || base.equalsIgnoreCase("Decimal")) {
			// check for decimal
			if (!isDecimal(number)) {
				System.out.println("Number is not decimal");
				System.exit(0);
			}
			String binary = conversion.decimalToBinary(Integer.parseInt(number));
			System.out.println("Binary number for Decimal " + number + " is " + binary);
			String hexa = conversion.decimalToHexa(Integer.parseInt(number));
			System.out.println("Hexa number for Decimal " + number + " is " + hexa);

		}
		if (base.equals("3") || base.equalsIgnoreCase("Hexa")) {
			// check for hexa
			if (!number.matches("^[0-9A-F]+$")) {
				System.out.println("Number is not Hexa");
				System.exit(0);
			}
			int decimal = conversion.hexadecimalToDecimal(number);
			System.out.println("Decimal number for Hexa " + number + " is " + decimal);
			String binary = conversion.decimalToBinary(decimal);
			System.out.println("Binary number for Hexa " + number + " is " + binary);

		}

		Conversion c = new Conversion();
		c.decimalToBinary(10);
		}
	}

	public int binaryToDecimal(int binaryNumber) {

		int decimal = 0;
		int power = 0;
		while (true) {
			if (binaryNumber == 0) {
				break;
			} else {
				int temp = binaryNumber % 10;
				decimal += temp * Math.pow(2, power);
				binaryNumber = binaryNumber / 10;
				power++;
			}
		}
		return decimal;
	}

	public String decimalToBinary(int num) {
		StringBuffer sb = new StringBuffer();
		int binary[] = new int[40];
		int index = 0;
		if (num == 0)
			return "0";
		while (num > 0) {
			binary[index++] = num % 2;
			num = num / 2;
		}
		for (int i = index - 1; i >= 0; i--) {
			sb = sb.append(binary[i]);
		}
		return sb.toString();
	}

	public int hexadecimalToDecimal(String hexVal) {
		int len = hexVal.length();

		// Initializing base value
		int base = 1;

		int decimalVal = 0;

		// get characters as digits from last value
		for (int i = len - 1; i >= 0; i--) {
			// if character lies in '0'-'9', converting
			// it to integral 0-9 by subtracting 48 from
			// ASCII value
			if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') {
				decimalVal += (hexVal.charAt(i) - 48) * base;

				// incrementing base by power
				base = base * 16;
			}

			// if character lies in 'A'-'F' , converting
			// it to integral 10 - 15 by subtracting 55
			// from ASCII value
			else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') {
				decimalVal += (hexVal.charAt(i) - 55) * base;

				// incrementing base by 16
				base = base * 16;
			}
		}
		return decimalVal;
	}

	public String decimalToHexa(int num) {

		// remainder
		int remainder;

		// storing output
		String hexa = "";

		// hexa number system
		char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		if (num == 0)
			return "0";
		while (num > 0) {
			remainder = num % 16;
			hexa = hex[remainder] + hexa;
			num = num / 16;
		}
		return hexa;
	}

	// validate if number is binary or not
	public static boolean isBinary(int number) {
		int input = number;
		while (input != 0) {
			if (input % 10 > 1) {
				return false;// not binary
			}
			input = input / 10;
		}
		return true;
	}

	// validate if number is decimal or not
	public static boolean isDecimal(String s) {
		try {
			Integer.parseInt(s);// if error then not decimal
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
