package kata;

public class StringCalculator {

	private static final int MAX_NUMBER = 1000;
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
		
		String[] nums = extractArrayOfStringNumbers(numbers);
		
		int total = sumFromArrayOfStringNumbers(nums);
		
		// Return sum
		return total;
	}

	private int sumFromArrayOfStringNumbers(String[] nums) {
		int total = 0;
		// Loop on length numbers given
		for (String numAsString : nums) {
            int num = Integer.valueOf(numAsString);
            // Throw Exception if number is negative
            if (num < 0) {
                throw new NegNumberException();
            }
            // Ignore number bigger than MAX_NUMBER
            if (num <= MAX_NUMBER) {
            	total += Integer.valueOf(numAsString);
            }
		}
		return total;
	}

	private String[] extractArrayOfStringNumbers(String numbers) {
		String cleanNumbers = numbers;
		String delimitor = "("+STRING_SEPARATOR+"|"+NEW_LINE_STRING+")";
		
		// Delimitor detection
		if (numbers.startsWith(STARTING_DELIMITERS)) {
			// Save delimitor
			delimitor = extractDelimitor(numbers);
			// Update string of numbers
			cleanNumbers = extractNumbers(numbers);
		}
		
		// Parse string
		String[] nums = cleanNumbers.split(delimitor);
		return nums;
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
