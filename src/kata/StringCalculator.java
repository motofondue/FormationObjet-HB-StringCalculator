package kata;

public class StringCalculator {

	private static final String EMPTY_STRING = "";
	private static final String NEW_LINE_STRING = System.getProperty("line.separator");
	private static final String STRING_SEPARATOR = ",";
	
	private static final String STARTING_DELIMITERS = "//";
	private static final String ENDING_DELIMITERS = NEW_LINE_STRING;

	// Sum function from String
	public int add(String numbers) {
		// Check empty string
		if (numbers.equals(EMPTY_STRING)) {
			return 0;
		}
		
		String[] nums;
		String delimitor = "("+STRING_SEPARATOR+"|"+NEW_LINE_STRING+")";
		// Delimitor detection
		if (numbers.startsWith(STARTING_DELIMITERS)) {
			// Save delimitor
			delimitor = extractDelimitor(numbers);
			// Update string of numbers
			nums = extractNumbers(numbers).split(delimitor);
		}
		else {
			// Parse string
			nums = numbers.split(delimitor);
		}
		
		int total = 0;
		// Loop on length numbers given
		for (String numAsString : nums) {
            int num = Integer.valueOf(numAsString);
            if (num < 0)
                throw new NegNumberException();
			total += Integer.valueOf(numAsString);
		}
		
		// Return sum
		return total;
	}

	// Extract Numbers from String when delimitor is present
	private String extractNumbers(String numbers) {
		return numbers.substring(
				numbers.indexOf(
						ENDING_DELIMITERS)+
						ENDING_DELIMITERS.length()
		);
	}

	// Extract Delimitor from String
	private String extractDelimitor(String numbers) {
		return numbers.substring(
				STARTING_DELIMITERS.length(),
				numbers.indexOf(ENDING_DELIMITERS)
		);
	}
}
