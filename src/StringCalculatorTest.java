import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {

	private StringCalculator sc;
    private static final String EMPTY_STRING = "";
    private static final String SINGLE_NUMBER_2 = "2";


    @Before
	public void setup(){
		// Given
		sc = new StringCalculator();
	}

	@Test
	public void shouldBeZeroWhenStringIsEmpty() {
		// When
		int sum = sc.add(EMPTY_STRING);
		// Then
		assertEquals(0, sum);
	}

	@Test
	public void shouldBeTwoWhenTwoGiven() {
		// When
		int sum = sc.add(SINGLE_NUMBER_2);
		// Then
		assertEquals(2, sum);
	}
}
