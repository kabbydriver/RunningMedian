import java.util.Comparator;

public class MaxHeapComparator implements Comparator<Integer> {

	public int compare(Integer left, Integer right) {
		return right - left;
	}
}