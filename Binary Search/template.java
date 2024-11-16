// Suppose we have a search space. It could be an array, a range, etc. Usually it's sorted in ascending order. For most tasks, we can transform the requirement into the following generalized form:

// Minimize k , s.t. condition(k) is True

// The following code is the most generalized binary search template:

public class template {
      public int binarySearch(int[] array) {
          // You need to define the 'condition' function logic based on the problem at hand.
          // For this example, I'm just using a placeholder condition method.
          // In practice, you should implement your specific condition.
  
          int left = getMin(array); // Replace with your actual minimum boundary logic
          int right = getMax(array); // Replace with your actual maximum boundary logic
  
          while (left < right) {
              int mid = left + (right - left) / 2;
  
              if (condition(mid)) {
                  right = mid;
              } else {
                  left = mid + 1;
              }
          }
  
          return left; // 'left' is the minimum k satisfying the condition
      }

        // Placeholder for a custom condition method (implement as needed)
    private boolean condition(int value) {
        // Replace this with your actual condition logic
        return true;
    }
}
// What's really nice of this template is that, for most of the binary search problems, we only need to modify three parts after copy-pasting this template, and never need to worry about corner cases and bugs in code any more:

// Correctly initialize the boundary variables left and right to specify search space. Only one rule: set up the boundary to include all possible elements;
// Decide return value. Is it return left or return left - 1? Remember this: after exiting the while loop, left is the minimal k​ satisfying the condition function;
// Design the condition function. This is the most difficult and most beautiful part. Needs lots of practice.
// Below I'll show you guys how to apply this powerful template to many LeetCode problems.