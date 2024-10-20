import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
      Queue<Integer> max_heap;
      Queue<Integer> min_heap;
      public MedianFinder() {
          this.max_heap = new PriorityQueue<>(Collections.reverseOrder());
          this.min_heap = new PriorityQueue<>();
      }
      
      public void addNum(int num) {
          if(max_heap.isEmpty() || max_heap.peek() >=num){
              max_heap.add(num);
          }
          else {
              min_heap.add(num);
          }
  
          // balance the heaps
          if(max_heap.size() > min_heap.size() +1){
              min_heap.add(max_heap.poll());
          }
          else if(max_heap.size() < min_heap.size()){
              max_heap.add(min_heap.poll());
          }
      }
      
      public double findMedian() {
          if(max_heap.size() == min_heap.size()){
              return (max_heap.peek()/ 2.0) + (min_heap.peek()/ 2.0);
          }else {
              return max_heap.peek();
          }
      }
  }