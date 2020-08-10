/*
720. Longest Word in Dictionary
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
*/
class Solution {
    String words [];
    HashMap<String,Boolean> map;
    public String longestWord(String[] words) {
        Arrays.sort(words);
        this.words = words;
        map = new HashMap<>();
        String s = "";
        for(String w : words){
            if(intheMap(w) && w.length() > s.length())
                s = w;
        }
        return s;
    }
    public boolean intheMap(String w){
        if(map.get(w) != null){
            return map.get(w);
        }
        boolean out = false;
        if(w.length() < 2)
            out = true;
        else{
            Boolean val = map.get(w.substring(0,w.length() - 1));
            if(val != null && val == true)
                out = true;            
        }            
            map.put(w,out);
            return out;            
    }
}
/*
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String res = "";
        Set<String> set = new HashSet<>();
        for(int i=0; i<words.length; i++) {
            if(words[i].length() == 1 || set.contains(words[i].substring(0, words[i].length() - 1))) {
                if(words[i].length() > res.length())
                    res = words[i];
                set.add(words[i]);
            }
        }
        return res;
    }
}
*/