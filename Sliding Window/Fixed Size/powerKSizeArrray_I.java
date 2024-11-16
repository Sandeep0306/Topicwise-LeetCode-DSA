package Sliding Window.Fixed Size;

// approach : deque with sliding window
//time complexity : O(n) space complexity : O(k)
public class powerKSizeArrray_I {
      public int[] resultsArray(int[] nums, int k) {
            int n = nums.length;
            int res [] = new int[n - k +1];
            Deque<Integer> dq = new ArrayDeque<>();
      
              for(int i=0; i<n; i++){
                  if(!dq.isEmpty() && dq.peekFirst() < i -k +1){
                      dq.pollFirst();
                  }
      
                  if(!dq.isEmpty() && nums[i] != nums[i-1] +1){
                      dq.clear();
                  }
                  dq.offerLast(i);
      
                  if(i >= k-1){
                      if(dq.size()== k){
                          res[i -k +1] = nums[dq.peekLast()];
                      }
                      else res[i -k +1] = -1;
                  }
              }
              return res;
          }
}

// approach : sliding window
// time complexity : O(n.k) space complexity : O(1)
class Solution {
      public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int res [] = new int[n - k +1];
  
          for(int i=0; i<=n-k; i++){
              boolean flag = true;
              for(int j=i; j <i+k-1; j++){
                  if(nums[j] +1 == nums[j+1]){
                      continue;
                  }
                  else {
                      flag = false;
                      break;
                  }
                  
              }
              if(flag){
                  res[i] = nums[i +k -1];
              }
              else res[i] = -1;
              
          }
          return res;
      }
  }

  // approach : optimized via counter
// time complexity : O(n) space complexity : O(1)
  class Solution {
      public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int res [] = new int[n - k +1];
  
          for(int i=0; i<=n-k; i++){
              boolean flag = true;
              for(int j=i; j <i+k-1; j++){
                  if(nums[j] +1 == nums[j+1]){
                      continue;
                  }
                  else {
                      flag = false;
                      break;
                  }
                  
              }
              if(flag){
                  res[i] = nums[i +k -1];
              }
              else res[i] = -1;
              
          }
          return res;
      }
  }