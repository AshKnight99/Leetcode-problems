/*
744. Find Smallest Letter Greater Than Target
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"
Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"
Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"
Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"
Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"
Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
*/
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int s = 0, e = n - 1;
        int mid = 0;
        int ans = 0;
        while(s <= e){
            mid = s + (e - s) / 2;            
            if(target == letters[mid]){
                ans = mid + 1;
                s = mid + 1;
            }
            else if(target <= letters[mid]){
                ans = mid;
                e = mid - 1;
            }
            else{
                ans = mid + 1; 
                s = mid + 1;
            }
        }
        return letters[(ans) % n];        
    }
}