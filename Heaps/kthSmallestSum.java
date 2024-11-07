// brute force solution
// Time Complexity: (m*n)log(k)
// Space Complexity: O(k)
import java.util.*;
// class Solution {
//       public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//           List<List<Integer>> res = new ArrayList<>();
  
//           Queue<int []> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
  
//           for(int i=0; i<nums1.length; i++){
//               for(int j=0; j<nums2.length; j++){
//                   int sum = nums1[i]+ nums2[j];
//                   if(pq.size() <k) {
//                       pq.add(new int[]{sum, i, j});
//                   }
//                   else if(sum < pq.peek()[0]){
//                       pq.poll();
//                       pq.add(new int[]{sum, i, j});
//                   }
  
//                   else break;
  
//               }
//           }
  
//           while(!pq.isEmpty()){
//               int i = pq.peek()[1];
//               int j = pq.poll()[2];
//               res.add(List.of(nums1[i], nums2[j]));
//           }
  
//           return res;
//       }
//   }

  // Approach 2: Optimized Solution
//   Time complexity: O(min(k⋅logk,m⋅n⋅log(m⋅n)))

// We iterate O(min(k,m⋅n)) times to get the required number of pairs.
// The visited set and heap both can grow up to a size of O(min(k,m⋅n)) because at each iteration we are inserting at most two pairs and popping one pair. Insertions into a min-heap take an additional log factor. So, to insert O(min(k,m⋅n)) elements into minHeap, we need O(min(k⋅logk,m⋅n⋅log(m⋅n)) time.
// The visited set takes on an average constant time and hence will take O(min(k,m⋅n)) time in major languages like Java and Python except in C++ where it would also take O(min(k⋅logk,m⋅n⋅log(m⋅n))) because we used ordered_set that keeps the values in sorted order.
// Space complexity: O(min(k,m⋅n))

// The visited set and heap can both grow up to a size of O(min(k,m⋅n)) because at each iteration we are inserting at most two pairs and popping one pair.

  class Solution {
      public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
          int m = nums1.length, n= nums2.length;
  
          List<List<Integer>> res = new ArrayList<>();
          PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0] -b[0]);
          Set<Pair<Integer, Integer>> vis = new HashSet<>();
  
          pq.offer(new int[] {nums1[0] + nums2[0], 0, 0});
  
          vis.add(new Pair<Integer, Integer>(0,0));
  
          while(k-->0 && !pq.isEmpty()){
              int i= pq.peek()[1], j= pq.poll()[2];
  
              res.add(List.of(nums1[i], nums2[j]));
  
              if(i+1 <m && !vis.contains(new Pair<Integer, Integer>(i+1, j))){
                  pq.add(new int []{nums1[i+1]+ nums2[j], i+1, j});
                  vis.add(new Pair<Integer, Integer>(i+1, j));
              }
               if(j+1 <n && !vis.contains(new Pair<Integer, Integer>(i, j+1))){
                  pq.add(new int []{nums1[i]+ nums2[j+1], i, j+1});
                  vis.add(new Pair<Integer, Integer>(i, j+1));
              }
          }
  
  return res;
  
      }
  }
class Pair<K, V> {
      private K key;
      private V value;
  
      public Pair(K key, V value) {
          this.key = key;
          this.value = value;
      }
  
      public K getKey() {
          return key;
      }
  
      public V getValue() {
          return value;
      }
  
      // Optionally override equals, hashCode, toString, etc.
  }
  