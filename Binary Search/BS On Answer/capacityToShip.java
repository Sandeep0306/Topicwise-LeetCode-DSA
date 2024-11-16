import java.util.Arrays;

// Binary Search on Answer (BSA) is a technique used to find the optimal solution to a problem by searching for the answer in a given range.
// time complexity: O(nlogn)

// . However, more often are the situations where the search space and search target are not so readily available. 
// Sometimes we won't even realize that the problem should be solved with binary search -- we might just turn to dynamic programming or DFS and get stuck for a very long time.

// As for the question "When can we use binary search?", my answer is that, If we can discover some kind of monotonicity,
//  for example, if condition(k) is True then condition(k + 1) is True, then we can consider binary search.
public class capacityToShip {
      public int shipWithinDays(int[] weights, int days) {
            int left = Arrays.stream(weights).max().getAsInt();
            int right =0;
     
             for(int w :weights){
                 right += w;
             }
     
             while(left < right){
                 int mid = left + (right - left)/2;
     
                 if(isFeasible(mid, weights, days)){
                     right = mid;
                 }
                 else{
                     left = mid +1;
                 }
             }
             return left;
         }
     
         private boolean isFeasible(int cap , int [] weigh, int D){
             int curDays = 1;
             int totalWeight =0;
     
             for(int w : weigh){
                 totalWeight +=w;
     
                 if(totalWeight > cap){
                     totalWeight = w;
                     curDays +=1;
                 } 
     
                 if(curDays > D) return false;
             }
     
             return true;
         }
     }