package assgn1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

/**
 * Main testing suite for HW assignment 1, week 6-CSE565
 * 
 * Tests all the functionality of the Bucket sort algorithm via 4 individual unit tests. Each test suite has been defined by its display name.
 *
 * @author Calvin D. Giles III
 * @version 1.0
 */

class BucketSortTest {
	
	float[] inputValues;
	

	public BucketSortTest() {
		generateRandomValues(10);
	}
	
	void generateRandomValues(int size) {
		inputValues = new float[size];
		Random random = new Random();
		float value = 0;
		while (size > 0) {
			value = random.nextFloat();
			if (size % 2 == 1)
				inputValues[size - 1] = -value;
			else
				inputValues[size - 1] = value;
			size--;
		}
	}
	
	//@Disabled
	@Test
	@DisplayName("Test sort routine exception handling")
	void testBucketSortExceptions() {
		
		//Make an illegal array to sort
		float[] inputValuesException = new float[] {(float)1.5};
		
		//Sort method does not throw an exception
		assertAll(() -> BucketSort.sort(inputValues));
		
		//Sort method throws an exception and communicates the exception reason
		Throwable ex = assertThrows(ElementOutOfBoundsException.class, () -> BucketSort.sort(inputValuesException), "Does not throw proper exception as required");
		if (ex != null)
			System.out.printf("%s%s", "Error message received from execution is: ", ex.toString());
		}
	
	@Test
	@DisplayName("Test bucket sort length unchanged")
	void testBucketSortLength() {
		float[] arrayCopy = Arrays.copyOf(inputValues, inputValues.length);
		BucketSort.sort(inputValues);
		//Checks the input arrays length is stable
		assertEquals(arrayCopy.length, inputValues.length);
	}
	
	@Test
	@DisplayName("Test that the input data was sorted")
	void testBucketSortIsSorted() {
		System.out.println(Arrays.toString(inputValues));
		
		BucketSort.sort(inputValues);
		//Checks the sorted array is sorted
		for (int i = 0; i < inputValues.length - 1; i++)
			assertTrue(!(inputValues[i] > inputValues[i + 1]));
		
		System.out.println(Arrays.toString(inputValues) + "\n");
	}
	
	@Test
	@DisplayName("Test all intial input data is still present")
	void testBucketSortValues() {
		float[] arrayCopy = Arrays.copyOf(inputValues, inputValues.length);
		BucketSort.sort(inputValues);
		//Checks presence of each element in the contents of the sorted array
		for (float value : arrayCopy) {
			for (int i = 0; i < inputValues.length; i++) {
				if (value == inputValues[i])
					break;
				if (i == inputValues.length)
					fail(value + " is missing.");
			}
		}
	}
}
