import org.junit.Test;
import static org.junit.Assert.*;


public class StringCalculatorTest {
	
	@Test
	public void shouldBeZeroWhenStringIsEmpty() {
		// Given
		StringCalculator sc = new StringCalculator();
		// When
		int sum = sc.add("");
		// Then
		assertEquals(0, sum);
	}
	
	@Test
	public void shouldBeTwoWhenTwoGiven() {
		// Given
		StringCalculator sc = new StringCalculator();
		// When
		int sum = sc.add("2");
		// Then
		assertEquals(2, sum);
	}
}
