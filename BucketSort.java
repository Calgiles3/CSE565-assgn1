package assgn1;
import java.util.*;

/**
 * Main class for HW assignment 1, week 6-CSE565
 * 
 * Buck sort is an algorithm mainly meant to sort evenly distributed data. Therefore this implementation of bucket sort is meant for sorting values uniformly distributed
 * in between the range of -1.0 and 1.0
 *
 * @author Calvin D. Giles III
 * @version 1.0
 */

public class BucketSort {
	private int index = 0;

	//Ascending value sort routine
	public static void sort(float[] input) throws ElementOutOfBoundsException{//Sorting algorithm for floating point values (i.e. 0.1, 0.45, 0.98...)
		
		@SuppressWarnings("unchecked")
		List<Float>[] buckets = new ArrayList [19];
		BucketSort bs = new BucketSort();
		
		//Add values to buckets
		for (Float value : input) {
			if (value > 1.0f || value < -1.0f)
				throw new ElementOutOfBoundsException(value);
			else if (value < 0)
				addNegValue(value, buckets);
			else
				addPosValue(value, buckets);
		}
		
		//Sort each bucket individually
		for (List<Float> numList : buckets) {
			if(numList != null) {
				Float[] nums = numList.toArray(new Float[numList.size()]);
				InsertionSort.sort(nums);
				
				overwrite(nums, input, bs);
			}
		}
	}
	
	private static void overwrite (Float[] nums, float[] input, BucketSort bs) {
		int i = 0;
		for (float value : nums) {
			input[bs.index + i] = value;
			i++;
		}
		bs.index += i;
	}
	
	private static void addNegValue(Float value, List<Float>[] buckets) {
		List<Float> bucketList;
		
		
		if (buckets[9 - Math.abs((int)(value * 10))] == null) {
			bucketList = new ArrayList<>();
			bucketList.add(value);
			buckets[9 - Math.abs((int)(value * 10))] = bucketList;
		}else
			buckets[9 - Math.abs((int)(value * 10))].add(value);		
	}
	
	private static void addPosValue(Float value, List<Float>[] buckets) {
		List<Float> bucketList;
		
		
		if (buckets[Math.abs((int)(value * 10)) + 9] == null) {
			bucketList = new ArrayList<>();
			bucketList.add(value);
			buckets[Math.abs((int)(value * 10)) + 9] = bucketList;
		}else
			buckets[Math.abs((int)(value * 10)) + 9].add(value);		
	}
	
	//Algorithm test
	public static void main(String[] args) {
		float[] inputValuesB, inputValuesA = new float[] {0.10f, 0.35f, 0.56f, 0.98f, 0.05f, 0.76f, 0.27f, 0.434f, 0.876f, 0.65f, 0.999f, -0.12f, -0.98f};
		inputValuesB = new float[] {0.10f, 0.35f, 0.56f, 0.98f, 0.05f, 0.76f, 0.27f, 0.434f, 0.876f, 0.65f, 0.999f, -0.12f, -0.98f, 0.10f, 0.35f, 0.56f, 0.98f, 0.05f, 0.76f, 0.27f, 0.434f, 0.876f, 0.65f, 0.999f, -0.12f, -0.98f};
		try {
			BucketSort.sort(inputValuesA);
			System.out.println(Arrays.toString(inputValuesA));
			BucketSort.sort(inputValuesB);
			System.out.println("\n" + Arrays.toString(inputValuesB));
			//new BucketSortTest(10);
		}catch (NullPointerException npe) {
			System.err.println("A null data object was passed to the sort method: " + npe);
		}catch (RuntimeException rte) {
			System.err.println("Some other RTE occured: " + rte);
		}
	}
}
