package BinaryTree;
class Solution {
    
      // BFS One Pass Solution 
     public TreeNode replaceValueInTree(TreeNode root) {
         List<Integer> res = new ArrayList<>();
         Queue<TreeNode> que = new LinkedList<>();
 
         que.offer(root);
         int levelSum = root.val;
 
         while(!que.isEmpty()){
            int n = que.size();
 
            int nextLevSum =0;
            while(n -->0){
             TreeNode cur = que.poll();
 
             cur.val = levelSum - cur.val;
 
             int sibSum = cur.left !=null ? cur.left.val : 0;
             sibSum += cur.right !=null ? cur.right.val : 0;
 
             if(cur.left !=null){
                 nextLevSum += cur.left.val;
                 cur.left.val = sibSum;
                 que.add(cur.left);
             }
             if(cur.right !=null){
                 nextLevSum += cur.right.val;
                 cur.right.val = sibSum;
                 que.add(cur.right);
             }
            }
            // updating level sum after each level
            levelSum = nextLevSum;
         }
         return root;
 
     }
 }
 
 // BFS Two Pass Solution
 // class Solution {
 //     public TreeNode replaceValueInTree(TreeNode root) {
 //          List<Integer> res = new ArrayList<>();
 //         Queue<TreeNode> que = new LinkedList<>();
 //      
 //     Finding Level Sum this is our first step and then store each level sum in a list
 //         que.offer(root);
 
 //         while(!que.isEmpty()){
 //             int len = que.size();
         
 //             int sum=0;
 
 //             for(int i = 0; i < len; i++){
 //                 TreeNode temp = que.poll();
 //                 if(temp.left != null) que.offer(temp.left);
 //                 if(temp.right != null) que.offer(temp.right);
 
 //                 sum +=temp.val;
 
 //             }
                 
 //             res.add(sum);
 //         }
 
 //         // finding sibiling sums and updating the values
 
 //         que.add(root);
 //         root.val =0;
 
 //         int i=1;
 //         while(!que.isEmpty()){
 //             int n = que.size();
 
 //             while(n -->0){
 //                 TreeNode cur = que.poll();
 
 //                 int sibSum = cur.left !=null ? cur.left.val :0;
 
 //                 sibSum += cur.right !=null ? cur.right.val :0;
 
 //                 if(cur.left !=null){
 //                     cur.left.val = res.get(i) - sibSum;
 //                     que.add(cur.left);
 //                 }
 //                 if(cur.right !=null){
 //                     cur.right.val = res.get(i) - sibSum;
 //                     que.add(cur.right);
 //                 }
 //             }
 //             i++;
 //         }
 
 //         return root;
 //     }
 // }
