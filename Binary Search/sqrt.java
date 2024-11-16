class sqrt {
      public int mySqrt(int x) {
          if(x ==0 || x==1) return x;
          int left = 0, right = x;
  
          while(left < right){
              int mid = left + (right - left)/2;
  
              if((long) mid * mid ==x) return mid;
  
              if((long)mid *mid >x ){
                  right = mid;
              }
              else {
                  left = mid +1;
              }
          }
          return left-1;
      }
  }
  // Time: O(logN) where N is the input number