/*
204. Count Primes
Count the number of prime numbers less than a non-negative number, n.
Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/
class Solution {
    public int countPrimes(int n) {
        if(n == 0)
            return 0;
        int count = 0;
        int arr[] = new int [n + 1];
        arr[0] = -1;
        arr[1] = -1;
        for(int i = 2;i < n;i++)
        {
            if(arr[i] != -1){    
                count ++;
                for(int j = i;j <= n; j = j+i){
                    if(arr[j]!= -1){                        
                        arr[j] = -1;
                }
            }
        }
        }
        return count;        
    }
}