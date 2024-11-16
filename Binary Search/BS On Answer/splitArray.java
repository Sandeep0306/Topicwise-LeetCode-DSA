class Solution {
      public int splitArray(int[] nums, int k) {
          int left = Integer.MIN_VALUE;
          int right =0;
  
          for(int v: nums) {
              left = Math.max(v, left);
              right +=v;
  
          }
  
          while(left < right){
              int mid = left + (right -left)/2;
  
              if(canSplit(mid, nums, k)){
                  right = mid;
              }
              else {
                  left = mid +1;
              }
          }
          return left;
      }
  
      private boolean canSplit(int sum, int []nums, int k){
          int curSplit =1;
          int totalSum =0;
  
          for(int v: nums){
              totalSum +=v;
  
              if(totalSum > sum){
                  totalSum = v;
                  curSplit++;
              }
  
              if(curSplit >k) return false;
          }
          return true;
      }
  }