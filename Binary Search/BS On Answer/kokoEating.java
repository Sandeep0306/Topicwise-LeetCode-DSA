// https://leetcode.com/problems/koko-eating-bananas
// approach : binary search
// time complexity : O(nlogn)
// space complexity : O(1)
public class kokoEating {

            public int minEatingSpeed(int[] piles, int h) {
                int left = 1, right =Integer.MIN_VALUE;
        
                for(int v: piles){
                    right = Math.max(right, v);
                }
        
                while(left < right){
                    int mid = left + (right - left)/2;
        
                    if(isValid(mid, piles, h)){ // almost same to 1101 and split array LC
                        right = mid;
                    }
                    else {
                        left = mid +1;
                    }
                }
                return left;
            }
        
            private boolean isValid(int k, int [] piles, int h){
               int curHour=0;
        
               for(int v: piles){
                curHour += (v + k-1)/(k); // calculate ceil hour it would take for particular banana piles if it is less than k than she eats all of them and will not eat any more during this hour
        
                // to calculate ceil value a/b = (a +b -1)/b , for floor value a/b
               }
        
               return curHour <=h;
            }
 } 

