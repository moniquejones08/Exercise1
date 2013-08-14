public class AmountConverter {
	Integer currentDigit = null, lastDigit = null, totalDigits = null, currentNum = null;
	String stringValue = "", dollars = "";
	Boolean isThousand = false, isMillion = false;
	
	public String convertToString(String dollars) {
		
		this.dollars = dollars;
		totalDigits = dollars.length();
		currentDigit = 0;
		lastDigit = totalDigits-1;
		
		while (currentDigit <= lastDigit) {
			//Current number being converted based on the currentDigit iteration
			currentNum = Integer.parseInt(dollars.valueOf(dollars.charAt(currentDigit)));
			
			//Convert single digit number (1-9)
			if (totalDigits == 1) {
				if (currentNum != 0) {
					convertLessThan10();
				}
			}
			//Convert double digit numbers (10-99)
			else if (totalDigits == 2) {
				//Skip leading 0's
				if (currentNum == 0) {
				}
				else {
					//Handle specific numbers (10-19)
					if (currentNum == 1) {
						handleSpecialNumbers();
						currentDigit++;
					}
					convertTensPlace();
				}
			}
			//Convert hundreds (100 - 999)
			else if (totalDigits < 4) {
				if (currentNum != 0) {
					convertLessThan10();
					stringValue += " Hundred ";
				}
			}
			//Convert thousands (1000 - 999,999)
			else if (totalDigits < 7) {
				if (totalDigits == 4) {
					if (currentNum != 0) {
						convertLessThan10();
						isThousand = true;
					}
					checkIsThousand();
				}
				else if (totalDigits == 5) {
					//Skip leading 0's
					if (currentNum == 0) {
					}
					else {
						//Handle specific numbers (10-19)
						if (currentNum == 1) {
							handleSpecialNumbers();
							isThousand = true;
							currentDigit++;
						}
						convertTensPlace();
					}
				}
				else if (totalDigits == 6){
					if (currentNum != 0) {
						convertLessThan10();
						isThousand = true;
						stringValue += " Hundred ";
					}
				}
			}
			//Convert millions (1,000,000 - 999,999,999)
			else if (totalDigits < 10) {
				if (totalDigits == 7) {
					if (currentNum != 0) {
						convertLessThan10();
						isMillion = true;
					}
					checkIsMillion();
				}
				else if (totalDigits == 8) {
					//Skip leading 0's
					if (currentNum == 0) {
					}
					else {
						//Handle specific numbers (10-19)
						if (currentNum == 1) {
							handleSpecialNumbers();
							isMillion = true;
							currentDigit++;
						}
						convertTensPlace();
					}
				}
				else {
					if (currentNum != 0) {
						convertLessThan10();
						isMillion = true;
						stringValue += " Hundred ";
					}
				}
			}
			else {
				System.out.println("Dollar amount is greater than $999,999,999.99");
				totalDigits = 0;
				currentDigit = lastDigit;
				stringValue = "";
			}
			currentDigit++;
			totalDigits--;
		}
		
		return stringValue;
	}
	
	public void checkIsThousand() {
		if (isThousand == true) {
			stringValue += " Thousand ";
		}
	}
	
	public void checkIsMillion() {
		if (isMillion == true) {
			stringValue += " Million ";
		}
	}
	
	public void handleSpecialNumbers() {
		currentNum = Integer.parseInt("1" + dollars.valueOf(dollars.charAt(currentDigit+1)));
	}
	
	public void convertLessThan10() {
		switch (currentNum) {
			case 1: stringValue += "One"; break;
			case 2: stringValue += "Two"; break;
			case 3: stringValue += "Three"; break;
			case 4: stringValue += "Four"; break;
			case 5: stringValue += "Five"; break;
			case 6: stringValue += "Six"; break;
			case 7: stringValue += "Seven"; break;
			case 8: stringValue += "Eight"; break;
			case 9: stringValue += "Nine"; break;
		}
	}
	
	public void convertTensPlace() {
		switch (currentNum) {
			case 2: stringValue += "Twenty-"; break;
			case 3: stringValue += "Thirty-"; break;
			case 4: stringValue += "Fourty-"; break;
			case 5: stringValue += "Fifty-"; break;
			case 6: stringValue += "Sixty-"; break;
			case 7: stringValue += "Seventy-"; break;
			case 8: stringValue += "Eighty-"; break;
			case 9: stringValue += "Ninety-"; break;
			case 10: stringValue += "Ten"; break;
			case 11: stringValue += "Eleven"; break;
			case 12: stringValue += "Twelve"; break;
			case 13: stringValue += "Thirteen"; break;
			case 14: stringValue += "Fourteen"; break;
			case 15: stringValue += "Fifteen"; break;
			case 16: stringValue += "Sixteen"; break;
			case 17: stringValue += "Seventeen"; break;
			case 18: stringValue += "Eighteen"; break;
			case 19: stringValue += "Nineteen"; break;
		}
	}
	
}




