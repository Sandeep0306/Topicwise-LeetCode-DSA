public class minSubarraySum {
      public int minSubArrayLen(int target, int[] nums) {
            int len =Integer.MAX_VALUE, n =nums.length;
            int curSum =0;
            int i=0 , j=0;
            
            for(j=0; j<n; j++){
                curSum += nums[j];
    
                while(curSum >=target){
                    curSum -= nums[i];
                    len = Math.min(len, j-i+1);
                    i++;
                }
            }
            return len == Integer.MAX_VALUE ? 0 : len;
        }
}
