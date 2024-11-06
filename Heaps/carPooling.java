// Aprroach: Difference Array / Bucket Sort /prefix sum
// Time Complexity: O(max(N,1001))
// Space Complexity: O(1001)=O(1) since we have 1001 buckets.
class Solution {

      public boolean carPooling(int[][] trips, int capacity) {
          int [] road = new int [1001];
  
          for(int i=0; i<trips.length; i++){
              road[trips[i][1]] += trips[i][0];
              road[trips[i][2]] -= trips[i][0];
          }
  
          int curCapacity=0;
          for(int i=0; i<road.length; i++){
              if(curCapacity > capacity){
                  return false;
              }
              curCapacity += road[i];
          }
  
          return true;
          
      }
  }

  // Approach: PriorityQueue
  // Time Complexity: O(nlogn)
  // Space Complexity: O(n)
//   class Solution {
//       public boolean carPooling(int[][] trips, int capacity) {
//           Arrays.sort(trips, (a,b) -> a[1]-b[1]);  // sort array from start time in ascending order
//           PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);  // sort PriorityQueue from end time in ascending order.
          
//           for(int[] trip : trips) {
//               while(!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
//                   capacity += pq.poll()[0];
//               }
//               pq.offer(trip);
//               capacity -= trip[0];
//               if(capacity < 0)
//                   return false;
//           }
          
//           return true;
//       }
//   }