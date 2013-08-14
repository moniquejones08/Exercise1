import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DisplayAmount {

	public static void main(String args[]) {
		String input = null, dollars = "", cents = "";
		
		//Prompt user for Dollar Amount
		input = userPrompt(input);
		
		//Split string into dollars and cents
		String[] values = input.split("\\.");
	
		//Convert dollar amount input to string representation
		AmountConverter convert = new AmountConverter();
		dollars = convert.convertToString(values[0]);
		
		//Store number string for cents
		cents = values[1].valueOf(values[1].charAt(0)) + values[1].valueOf(values[1].charAt(1)) ;
		
		//Display the String representation of the input amount
		if (dollars == "") {
			System.out.println(cents + "/100 dollars");
		}
		else {
			System.out.println( dollars + " and " + cents + "/100 dollars");
		}
		
	}
	
	public static String userPrompt(String input) {
		String value = null;
		
		System.out.print("Please enter the dollar amount to convert. Ex. '2523.04': $");
		while (value == null) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				input = reader.readLine();
				input = input.replaceAll("\\,", "");
				input = input.replaceAll("\\s", "");
				input = input.replaceAll("[a-z]", "");
				input = input.replaceAll("[A-Z]", ""); 
				if (!input.isEmpty()) {
					
					if (!input.contains(".")) {
						input += ".00";
						System.out.println(input);
					}
					value = input;
					
				} 
				else {
					System.out.print("Invalid Format. Please enter the correct dollar amount (Between 0 - 999,999,999) to convert. Ex. 2523.04: $");	
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}
	
}
