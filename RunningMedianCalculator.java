import java.util.PriorityQueue;

public class RunningMedianCalculator {
	
	public static final int DEFAULT_START_SIZE = 11;
	private PriorityQueue<Integer> minHeap; //numbers larger than median
	private PriorityQueue<Integer> maxHeap ; //numbers small than median

	public RunningMedianCalculator() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(DEFAULT_START_SIZE, 
												new MaxHeapComparator());
	}

	public void addInt(int num) {
		if (maxHeap.isEmpty() || num < maxHeap.peek()) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}
		balance();
	}

	/*
	 * Returns null if no numbers have been added to the stream
	 */
	public Double getMedian() {

		if (minHeap.size() == 0 && maxHeap.size() == 0) {
			return null;
		}

		if (minHeap.size() == maxHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else if (minHeap.size() > maxHeap.size()) {
			return new Double(minHeap.peek());
		} else {
			return new Double(maxHeap.peek());
		}


	}

	public void clear() {
		minHeap.clear();
		maxHeap.clear();
	}

	private void balance() {
		if (minHeap.size() > maxHeap.size() + 1) {
			maxHeap.add(minHeap.poll());
		} else if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		}
	}

}
