package kata;

public class StringCalculator {

	private static final String EMPTY_STRING = "";
	private static final String NEW_LINE_STRING = System.getProperty("line.separator");
	private static final String STRING_SEPARATOR = ",";

	// Sum function from String
	public int add(String numbers) {
		// Check empty string
		if (numbers.equals(EMPTY_STRING)) {
			return 0;
		}
		
		// Parse string
		String[] nums = numbers.split("("+STRING_SEPARATOR+"|"+NEW_LINE_STRING+")");
		int total = 0;
		// Loop on length numbers given
		for (String num : nums) {
			total += Integer.valueOf(num);
		}
		
		// Return sum
		return total;
	}
}
