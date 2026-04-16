import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {

    // Max heap for lower half
    private PriorityQueue<Integer> maxHeap;

    // Min heap for upper half
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    // Insert number
    public void addNum(int num) {
        // Step 1: Add to maxHeap
        maxHeap.offer(num);

        // Step 2: Move largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());

        // Step 3: Balance sizes
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Return median
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
public class Median{
    public static void main(String[] args) {
         System.out.println("Created and performed by Ayush Wanjari");
        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        System.out.println(mf.findMedian()); // 1

        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5

        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2

        mf.addNum(4);
        System.out.println(mf.findMedian()); // 2.5
    }
}
