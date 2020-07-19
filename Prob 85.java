/*
85. Maximal Rectangle
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
Example:
Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
*/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 )
            return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int arr[] = new int[c];
        int max = Integer.MIN_VALUE;
        for(int  i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(matrix[i][j] == '1')
                 arr[j] += 1;
                else
                    arr[j] = 0;
            }
            max = Math.max(max,helper(arr,c));
        }
        return max;        
        
    }
       public int helper(int h[],int n){
        Stack <Integer> sl = new Stack<>();
        Stack<Integer> sr = new Stack<>();
        int left[] = new int[n];
        int right [] = new int[n];
        for(int i = 0;i < n;i++){
            if(sl.isEmpty())
                left[i] = -1;
            else if(h[sl.peek()] >= h[i]){
                while(!sl.isEmpty() && h[sl.peek()] >= h[i])
                    sl.pop();
                if(sl.isEmpty())
                    left[i] = -1;
                else
                    left[i] = sl.peek();
            }
            else
                left[i] = sl.peek();
            sl.push(i);
        }
        for(int i = n - 1;i >= 0; i--){
            if(sr.isEmpty())
                right[i] = n;
            else if(!sr.isEmpty() && h[sr.peek()] >= h[i])
            {
                while(!sr.isEmpty() && h[sr.peek()] >= h[i])
                    sr.pop();
                if(sr.isEmpty())
                    right[i] = n;
                else
                    right[i] = sr.peek();
            }
            else
                right[i] = sr.peek();
            sr.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            max = Math.max(max, (right[i] - left[i] - 1 ) * h[i]);
        }
        return max;
    }
}