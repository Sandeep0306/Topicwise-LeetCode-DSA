package Bit_Manipulation;


// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
      public int largestCombination(int[] candidates) {
          int res=0;
  
          // today i learned new concept of bit manipulation on how to calculate number of bits at each position of any number
          for(int i=0; i<24; i++){
              int count =0;
              for(int v: candidates){
  
                  if((v & (1 <<i)) !=0){ // if the ith bit is set
                      count++;
                  }
              }
              res = Math.max(res, count);
          }
  
  
          return res;
      }
  }
