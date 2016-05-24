
public class StringCalculator {

	// Sum function from String
	public int add(String numbers) {
		// Check empty string
		if (numbers.equals("")) {
			return 0;
		}
		
		// Parse string
		String[] nums = numbers.split(",");
		if (nums.length == 1) {
			return Integer.valueOf(nums[0]);
		}
		
		// Default return
		return -1;
	}
}
