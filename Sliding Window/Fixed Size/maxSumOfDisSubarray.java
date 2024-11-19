// Approach: Sliding Window using HashSet
// time complexity: O(n) space complexity: O(k)
public class maxSumOfDisSubarray {
      public long maximumSubarraySum(int[] nums, int k) {
            long res = 0;
            long curSum =0;
    
            Set<Integer> set = new HashSet<>();
    
            int i=0;
            for(int j=0;j <nums.length; j++){
                //if set doesn't contain that element
               if(!set.contains(nums[j])){
                curSum += nums[j];
                set.add(nums[j]);
    
                if(j -i +1 ==k){
                    res = Math.max(res, curSum);
                    curSum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
               }
               else {
                // remove till when ith element is not equal to jth element as we have duplicate element in an subarray so try to move window and remove element
                while(nums[i] != nums[j]){
                    curSum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
                // increment ith pointer if the ith element and jth element both are same.
                //  so start fresh new window but don't remove ith element from curSum as they both are same.
                i++;
               }
    
            }
    
            return res;
    
        }
}
// class Solution {
//       public long maximumSubarraySum(int[] nums, int k) {
//           long res = 0;
//           Map<Integer, Integer> count = new HashMap<>();
//           long curSum = 0;
          
//           int l = 0;
//           for (int r = 0; r < nums.length; r++) {
//               curSum += nums[r];
//               count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);
              
//               if (r - l + 1 > k) {
//                   count.put(nums[l], count.get(nums[l]) - 1);
//                   if (count.get(nums[l]) == 0) {
//                       count.remove(nums[l]);
//                   }
//                   curSum -= nums[l];
//                   l++;
//               }
              
//               if (count.size() == r - l + 1 && r - l + 1 == k) {
//                   res = Math.max(res, curSum);
//               }
//           }
          
//           return res;
//       }
//   }

// Approach: Sliding Window using HashMap
// class Solution {
//       public long maximumSubarraySum(int[] nums, int k) {
//           long res = 0;
//           Map<Integer, Integer> prevIdx = new HashMap<>();
//           long curSum = 0;
          
//           int l = 0;
          
//           for (int r = 0; r < nums.length; r++) {
//               curSum += nums[r];
              
//               int i = prevIdx.getOrDefault(nums[r], -1);
              
//               while (l <= i || r - l + 1 > k) {
//                   curSum -= nums[l];
//                   l++;
//               }
              
//               if (r - l + 1 == k) {
//                   res = Math.max(res, curSum);
//               }
              
//               prevIdx.put(nums[r], r);
//           }
          
//           return res;
//       }
//   }