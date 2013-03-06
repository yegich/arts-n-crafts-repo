package yega.alogrithms.quicksort;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import yega.alogrithms.quicksort.QuickSort.PivotStrategy;

public class QuickSortTest extends Assert {

	public static List<Integer> TEST_ARRAY = new ArrayList<Integer>();
	static {
		TEST_ARRAY.add(1);
		TEST_ARRAY.add(3);
		TEST_ARRAY.add(2);
		TEST_ARRAY.add(5);
		TEST_ARRAY.add(6);
	}
	
	public static BigDecimal COMPARISON_COUNT_WHEN_PIVOT_IS_FIRST_ELEMENT = BigDecimal.valueOf(8);
	public static BigDecimal COMPARISON_COUNT_WHEN_PIVOT_IS_FINAL_ELEMENT = BigDecimal.valueOf(9);
	public static BigDecimal COMPARISON_COUNT_WHEN_PIVOT_IS_MEDIAN_OF_THREE_ELEMENT = BigDecimal.valueOf(6);
	
	@Test
	public void verifyQuickSortAlgorithmWithPivotFirst() {
		QuickSort quickSort = new QuickSort(PivotStrategy.FIRST);
		
		quickSort.sort(TEST_ARRAY);
		System.out.println(TEST_ARRAY);
		assertThat(quickSort.getComparisonCount(), is(COMPARISON_COUNT_WHEN_PIVOT_IS_FIRST_ELEMENT));
	}
	@Test
	public void verifyQuickSortAlgorithmWithFinalPivot() {
		QuickSort quickSort = new QuickSort(PivotStrategy.FINAL);
		
		quickSort.sort(TEST_ARRAY);
		System.out.println(TEST_ARRAY);
		assertThat(quickSort.getComparisonCount(), is(COMPARISON_COUNT_WHEN_PIVOT_IS_FINAL_ELEMENT));
	}
	
	@Test
	public void verifyQuickSortAlgorithmWithMedianOfThreePivot() {
		QuickSort quickSort = new QuickSort(PivotStrategy.MEDIAN_OF_THREE);
		
		quickSort.sort(TEST_ARRAY);
		System.out.println(TEST_ARRAY);
		assertThat(quickSort.getComparisonCount(), is(COMPARISON_COUNT_WHEN_PIVOT_IS_MEDIAN_OF_THREE_ELEMENT));
	}
	
	@Test
	public void verifyProgrammingQuestion() throws IOException{
		//given
		List<Integer> array = new ArrayList<Integer>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(QuickSortTest.class.getResourceAsStream("/QuickSort.txt")));
		while(true) {
			String line = reader.readLine();
			if(line == null) {
				break;
			}
			array.add(Integer.valueOf(line.trim()));
		}
		System.out.println(array.size());
		
		QuickSort quickSort = null;
		
		quickSort = new QuickSort(PivotStrategy.FIRST);
		quickSort.sort(new ArrayList<Integer>(array));
		System.out.println("FIRST: "+quickSort.getComparisonCount());
		
		quickSort = new QuickSort(PivotStrategy.FINAL);
		quickSort.sort(new ArrayList<Integer>(array));
		System.out.println("FINAL: "+quickSort.getComparisonCount());
		
		quickSort = new QuickSort(PivotStrategy.MEDIAN_OF_THREE);
		quickSort.sort(new ArrayList<Integer>(array));
		System.out.println("MEDIAN_OF_THREE: "+quickSort.getComparisonCount());
		
	}
	
}
