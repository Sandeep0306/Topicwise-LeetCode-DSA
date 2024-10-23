// leetcode- 2583 (Amazon, Bloomberg )
class Solution {

      // Approach 1 : BFS  + MaxHeap
      public long kthLargestLevelSum(TreeNode root, int k) {
  
          Queue<TreeNode> que = new LinkedList<>();
  
          // Queue<Long> pq = new PriorityQueue<>((a,b) -> b-a); // can't use this comparator in PQ to make it maxHeap lol , because we can't directly compare Objects like 
          //Long as Integer is Primitive Wrapper class its support direct subtraction, so for Objects and Custom classes we have to use compareTo()
  
          Queue<Long> pq = new PriorityQueue<>((a,b) -> b.compareTo(a));
  
          que.offer(root);
  
          while(!que.isEmpty()){
              int len = que.size();
          
              long sum=0;
  
              for(int i = 0; i < len; i++){
                  TreeNode temp = que.poll();
                  if(temp.left != null) que.offer(temp.left);
                  if(temp.right != null) que.offer(temp.right);
  
                  sum +=(long) temp.val;
  
              }
                  
               pq.add(sum);
          }
  
          if(pq.size() <k) return -1;
  
         int i=0;
         while(i <k-1){
          pq.poll();
          i++;
         }
         return pq.peek();
      }
  }
  
  //  Approach 2: BFS  + Sorting
  // class Solution {
  //     public long kthLargestLevelSum(TreeNode root, int k) {
  //         List<Long> res = new ArrayList<>();
  //         Queue<TreeNode> que = new LinkedList<>();
  
  //         que.offer(root);
  
  //         while(!que.isEmpty()){
  //             int len = que.size();
          
  //             long sum=0;
  
  //             for(int i = 0; i < len; i++){
  //                 TreeNode temp = que.poll();
  //                 if(temp.left != null) que.offer(temp.left);
  //                 if(temp.right != null) que.offer(temp.right);
  
  //                 sum +=(long) temp.val;
  
  //             }
                  
  //              res.add(sum);
  //         }
  
  //         Collections.sort(res);
  
  //         if(res.size() <k) return -1;
  
  //         return res.get(res.size() - k);
  //     }
  // }
  