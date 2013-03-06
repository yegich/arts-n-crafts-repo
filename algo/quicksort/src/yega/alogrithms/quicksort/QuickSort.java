package yega.alogrithms.quicksort;

import java.math.BigDecimal;
import java.util.List;

public class QuickSort {

	private PivotStrategy pivotStrategy;
	private BigDecimal count = BigDecimal.ZERO;

	public QuickSort(PivotStrategy pivotStrategy) {
		this.pivotStrategy = pivotStrategy;
	}
	
	public void sort(List<Integer> array) {
		sort(array, 0,array.size()-1);
	}
	
	private void sort(List<Integer> array, Integer begin, Integer end) {
		Integer temp;
		if( begin >= end) {
			return;
		}
		switch (pivotStrategy) {
		case FIRST:
			break;
		
		case MEDIAN_OF_THREE:
			Integer middleIndex = (1+end)/2;
			
			if(array.get(middleIndex) >= array.get(begin) && array.get(middleIndex) <= array.get(end)){
				swap(array,begin,middleIndex);
				break;
			} else if (array.get(begin) >= array.get(middleIndex) && array.get(begin) <= array.get(end)){
				break;
			}
		case FINAL:
			swap(array,begin,end);
			break;
		default:
			break;
		}
		
		Integer pivot = array.get(begin);
		Integer i = begin+1;
		Integer j = i;
		
		for(;j<=end;j++){
			if(array.get(j) < pivot) {
				swap(array,i,j);
				i++;
			}
		}
		count = count.add(BigDecimal.valueOf(end-begin));
		swap(array,begin,i-1);
		
		sort(array, begin, i-2);
		sort(array, i, j-1);
	}

	public BigDecimal getComparisonCount() {
		return count;
	}
	
	public static enum PivotStrategy {
		FIRST,
		FINAL,
		MEDIAN_OF_THREE
	}
	
	public void swap(List<Integer> array, Integer indexOne,Integer indexTow) {
		Integer temp = array.get(indexOne);
		array.set(indexOne, array.get(indexTow));
		array.set(indexTow,temp);
	}

}
