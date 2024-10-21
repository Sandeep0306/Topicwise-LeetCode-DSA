import java.util.*;
class Solution {

      // Approach :- Sorting(to sort the array based on enqueue time) + min heap(to get Minimum Processing Time first)

      // Time Complexity :- O(nlogn) (sorting) + O(nlogn) (insertion and deletion) = O(nlogn)
      // Space Complexity :- O(n) (to store the tasks)
      public int[] getOrder(int[][] tasks) {
          int n = tasks.length;
          int[] res = new int[n];
          int[][] idx_task = new int[n][3];
  
          for (int i = 0; i < n; i++) {
              idx_task[i][0] = tasks[i][0]; // Enqueue time
              idx_task[i][1] = tasks[i][1]; // Processing time
              idx_task[i][2] = i; // Original index
          }
  
          Arrays.sort(idx_task, (a, b) -> a[0] - b[0]); // Sort by enqueue time
  
          // PriorityQueue to process tasks based on processing time and index
          Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
  
          int idx = 0; // Index to traverse through the tasks
          int curTime = 0; // Current time
          int resultIdx = 0; // Index to store the result
  
          while (idx < n || !pq.isEmpty()) {
              // If the queue is empty and no task is available, move current time to the next task's enqueue time
              if (pq.isEmpty() && curTime < idx_task[idx][0]) {
                  curTime = idx_task[idx][0];
              }
  
              // Add all tasks that can be processed by the current time
              while (idx < n && idx_task[idx][0] <= curTime) {
                  pq.add(new int[]{idx_task[idx][1], idx_task[idx][2]}); // {processing time, index}
                  idx++; // Increment to process the next task
              }
  
              // Process the next task from the priority queue
              int[] cur_task = pq.poll();
  
              // Update current time with the processing time
              curTime += cur_task[0];
              int task_idx = cur_task[1]; // Get the original index of the task
  
              // Add the original index to the result array
              res[resultIdx++] = task_idx;
          }
          return res;
      }
  }
  