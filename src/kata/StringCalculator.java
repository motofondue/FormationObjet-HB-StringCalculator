package kata;

public class StringCalculator {

	private static final String EMPTY_STRING = "";
	private static final String NEW_LINE_STRING = System.getProperty("line.separator");
	private static final String STRING_SEPARATOR = ",";
	
	private static final String STARTING_DELIMITERS = "//";
	private static final String ENDING_DELIMITERS = NEW_LINE_STRING;

	// Sum function from String
	public int add(String numbers) {
		String numbersToProcess = numbers;

		// Check empty string
		if (numbers.equals(EMPTY_STRING)) {
			return 0;
		}
		
		String delimitor = "("+STRING_SEPARATOR+"|"+NEW_LINE_STRING+")";
		// Delimitor detection
		if (numbers.startsWith(STARTING_DELIMITERS)) {
			// Save delimitor
			delimitor = numbers.substring(
					STARTING_DELIMITERS.length(),
					numbers.indexOf(ENDING_DELIMITERS)
			);
			// Update string of numbers
			numbersToProcess = numbers.substring(
					numbers.indexOf(
							ENDING_DELIMITERS)+
					ENDING_DELIMITERS.length()
			);
		}
		
		// Parse string
		String[] nums = numbersToProcess.split(delimitor);
		int total = 0;
		// Loop on length numbers given
		for (String num : nums) {
			total += Integer.valueOf(num);
		}
		
		// Return sum
		return total;
	}
}
