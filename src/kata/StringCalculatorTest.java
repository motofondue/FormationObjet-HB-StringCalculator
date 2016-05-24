package kata;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;
    private static final String EMPTY_STRING = "";
	private static final String NEW_LINE_STRING = System.getProperty("line.separator");
    
	private static final String SINGLE_NUMBER_2 = "2";
    private static final String TWO_NUMBER_GIVEN = "1,2";

    private static final String MULTIPLE_NUMBER_GIVEN_1 = "1,2,3,4,5,6";
    private static final String MULTIPLE_NUMBER_GIVEN_2 = "100,100";
    private static final String MULTIPLE_NUMBER_GIVEN_3 = 
    		"9"+NEW_LINE_STRING+
    		"11"+NEW_LINE_STRING+
    		"1"+NEW_LINE_STRING+
    		"2";

	private static final String STARTING_DELIMITERS = "//";
	private static final String ENDING_DELIMITERS = NEW_LINE_STRING;
	private static final String MULTIPLE_NUMBER_DELIMITER_BANG = STARTING_DELIMITERS + "!" + ENDING_DELIMITERS + "1!2!3!4!5!6";
	private static final String MULTIPLE_NUMBER_DELIMITER_SEMICOLON = STARTING_DELIMITERS + ";" + ENDING_DELIMITERS + "1;2;3;4;5;6";

    private static final String NEG_NUMBER = "1,-2";
    private static final String NEG_NUMBER_DELIMITERS = "//:"+NEW_LINE_STRING+"1:-2";

    @Before
	public void setup(){
		// Given
		stringCalculator = new StringCalculator();
	}

	@Test
	public void shouldBeZeroWhenStringIsEmpty() {
		// When
		int sum = stringCalculator.add(EMPTY_STRING);
		// Then
		assertEquals(0, sum);
	}

	@Test
	public void shouldBeTwoWhenTwoGiven() {
		// When
		int sum = stringCalculator.add(SINGLE_NUMBER_2) ;
		// Then
		assertEquals(2, sum);
	}

	@Test
	public void shouldBeThreeWhenOneAndTwoGiven() {
		// When
		int sum = stringCalculator.add(TWO_NUMBER_GIVEN);
		// Then
		assertEquals(3, sum);
	}

	@Test
	public void shouldBeSumWhenMultipleNumberGiven()  {
		// When
		int sum1 = stringCalculator.add(MULTIPLE_NUMBER_GIVEN_1);
		int sum2 = stringCalculator.add(MULTIPLE_NUMBER_GIVEN_2);
		int sum3 = stringCalculator.add(MULTIPLE_NUMBER_GIVEN_3);
		// Then
		assertEquals(21, sum1);
		assertEquals(200, sum2);
		assertEquals(23, sum3);
	}

	@Test
	public void shouldBeSumWhenMultipleNumberGivenWithDelimiters() {
		// When
		int[] results = new int[]{
				stringCalculator.add(MULTIPLE_NUMBER_DELIMITER_BANG),
				stringCalculator.add(MULTIPLE_NUMBER_DELIMITER_SEMICOLON)
		};
		// Then
		int[] expectedResults = new int[]{21, 21};
		assertArrayEquals(expectedResults, results);
	}

    @Test(expected=NegNumberException.class)
    public void shouldThrowExceptionOnNegNumber(){
        // When
        int[] results = new int[]{
                stringCalculator.add(NEG_NUMBER),
                stringCalculator.add(NEG_NUMBER_DELIMITERS)
        };
        // Then
    }
}
