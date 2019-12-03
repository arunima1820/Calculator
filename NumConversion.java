
public class NumConversion {	
	
	public static String convert (String number, String type) {
		switch(type) {
		case "DEC_TO_BIN": return dec2Bin (number);
		case "DEC_TO_HEX": return dec2Hex (number);
		case "DEC_TO_OCT": return dec2Oct (number);
		case "BIN_TO_DEC": return bin2Dec (number);
		case "HEX_TO_DEC": return hex2Dec (number);
		case "OCT_TO_DEC": return oct2Dec (number);
		default: return null;
		}
	}
	
	public static String dec2Hex (String number) {
		int value = getDecFromHex(number);
		
		// loop - if greater than digit value, loop
		if (value > 15) {
			return "" + dec2Hex (value / 16 + "") + getHexFromDec(value % 16); 
		}
		// base case - if single digit, get value
		else if (value <= 15) {
			return getHexFromDec(value);
		}
		return null;
	}

	public static String hex2Dec (String hexString) {
		// recursive loop - if digits > 1
				if (hexString.length() > 1) {
					return (int) Math.pow(16, hexString.length() - 1) * getDecFromHex(hexString.substring(0, 1)) + Integer.parseInt(hex2Dec(hexString.substring(1))) + "";
				}
				// base case - if only one digit
				else if (hexString.length() == 1) {
					return ""+getDecFromHex(hexString);
				}
					return "0";

	}

	public static int getDecFromHex (String hex) {
		switch(hex) {
		case "A": return 10; 
		case "B": return 11; 
		case "C": return 12; 
		case "D": return 13; 
		case "E": return 14; 
		case "F": return 15;
		default: return Integer.parseInt(hex);
		}
	}
	
	public static String getHexFromDec(int value) {
		String num = "";
		switch (value) {
		case 10: num += "A"; break;
		case 11: num += "B"; break;
		case 12: num += "C"; break;
		case 13: num += "D"; break;
		case 14: num += "E"; break;
		case 15: num += "F"; break;
		default: num += value;
		}	
		return num;	
	}

	public static String dec2Bin (String number) {
		int value = Integer.parseInt(number);
		if (value > 1) {
			return dec2Bin (value / 2 + "") + (value % 2); 
		}
		else if (value == 1) {
			return "1";
		}
		else if (value == 0) {
			return "0";
		}
		return null;
	}
	
	public static String bin2Dec(String binaryString) {
		
		// recursive loop - if digits > 1
		if (binaryString.length() > 1) {
			if (binaryString.charAt(0) == '1') {
				return (int) Math.pow(2, binaryString.length() - 1) + Integer.parseInt(bin2Dec(binaryString.substring(1))) + "";
			}
			return bin2Dec (binaryString.substring(1));
		}
		// base case - if only one digit
		else if (binaryString.length() == 1) {
			if (binaryString.charAt(0) == '1') {
				return "1";
			}
			return "0";
		}
		
		return "0";
	}
	
	public static String dec2Oct (String number) {
		// loop - if greater than digit value, loop
		int value = Integer.parseInt(number);
		if (value > 7) {
			return "" + dec2Oct (value / 8 + "") + value % 8; 
		}
		// base case - if single digit, get value
		else if (value <= 7) {
			return "" + value;
		}
		return null;
	}

	public static String oct2Dec (String octString) {
		// recursive loop - if digits > 1
		if (octString.length() > 1) {
			return (int) Math.pow(8, octString.length() - 1) * Integer.parseInt(octString.substring(0, 1)) + Integer.parseInt(oct2Dec(octString.substring(1))) + "";
		}
		// base case - if only one digit
		else if (octString.length() == 1) {
			return "" + octString;
		}
			return "0";
	}
	
	public static int toDec(String num, String numSystem) {
		
		switch (numSystem) {
		case "DEC": return Integer.parseInt(num);
		case "HEX": return Integer.parseInt(NumConversion.hex2Dec(num));
		case "OCT": return Integer.parseInt(NumConversion.oct2Dec(num));
		case "BIN": return Integer.parseInt(NumConversion.bin2Dec(num));
		default: return Integer.parseInt(num);
		}
	}
	
	public static String fromDec(int num, String numSystem) {
		switch (numSystem) {
		case "DEC": return ""+num;
		case "HEX": return NumConversion.dec2Hex(""+num);
		case "OCT": return NumConversion.dec2Oct(""+num);
		case "BIN": return NumConversion.dec2Bin(""+num);
		default: return ""+num;
		}
	}
}
