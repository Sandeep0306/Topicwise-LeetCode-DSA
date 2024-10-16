import java.util.PriorityQueue;

// Approach 1: Priority Queue
class Pair {
     int count;
     char letter;
 
     Pair(int count, char letter){
         this.count = count;
         this.letter = letter;
     }
 }
 
 class Solution {
     public String longestDiverseString(int a, int b, int c) {
       PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.count - x.count); // MAX HEAP 
 
      if (a > 0) {
             pq.add(new Pair(a, 'a'));
         }
 
         if (b > 0) {
             pq.add(new Pair(b, 'b'));
         }
 
         if (c > 0) {
             pq.add(new Pair(c, 'c'));
         }
 
       StringBuilder sb = new StringBuilder();
       while(!pq.isEmpty()){
         Pair p = pq.poll();
          int count = p.count;
          char ch = p.letter;
 
          if(sb.length() >= 2 && sb.charAt(sb.length()-1)== ch && sb.charAt(sb.length()-2)==ch){
 
             if(pq.isEmpty()) break;
 
             Pair temp = pq.poll();
             sb.append(temp.letter);
             if(temp.count -1 >0){
                 pq.add(new Pair(temp.count -1, temp.letter));
             }
 
          }
          else {
             count --;
             sb.append(ch);
          }
          if(count >0){
             pq.add(new Pair(count, ch));
          }
       }
 
       return  sb.toString();
     }
 }
// Time Complexity : O(a + b+ c) Space Complexity is O(1)

// Approach 2: Greedy Approach
// class Solution {
//     public String longestDiverseString(int a, int b, int c) {
//         StringBuilder sb = new StringBuilder();

//         int n = a +b +c;
//         int curA =0, curB =0, curC =0;

//         for(int i=0; i<n; i++){
//             if((a>=b && a>=c && curA !=2) || (a>0 && (curB==2 || curC ==2))){
//                 sb.append('a');
//                 a--;
//                 curA++;
//                 curB =0;
//                 curC =0;
//             }
//             else if((b>=a && b>=c && curB !=2) || (b>0 && (curA==2 || curC==2))){
//                 sb.append('b');
//                 b--;
//                 curB++;
//                 curC =0;
//                 curA =0;
//             }

//             else if((c>=a && c>=b && curC !=2) || (c>0 && (curA==2 || curB ==2))){
//                 sb.append('c');
//                 c--;
//                 curC++;
//                 curA=0;
//                 curB =0;
//             }
//         }
//         return sb.toString();
//     }
// }
 
 
