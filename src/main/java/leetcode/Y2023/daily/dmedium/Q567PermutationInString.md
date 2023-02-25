# Q567PermutationInString

If you read any of my post, you would know that I am a big fan trying to break the code for basic problems and beginners level understanding.
So I am going to break down the problem into small pieces and try to understand it.

--- 
I would be honest
---
If this was my early days of leetcode then i would start generating all the permutations of s1 and then check if s2 contains any of the permutations.
But now i know that this is not the right way to solve the problem.
Some questions require just simple brute force and some questions require some smart thinking.
---
<br><hr><br>
So let's start with the problem statement.
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
<br><hr><br>

The most basic thing to understand is that how can i check if the s2 contains the permutation of s1.
Well definitely we can use the sliding window to check if the s2 contains the permutation of s1.

<bold>Then what is sliding window?</bold> It is a window that can slide from left to right or from right to left.
The window size is the length of s1. Why s1? because we just want to check if s2 contains this string s1 (permutation).
<br>
So we can use a map to store the frequency of each character in s1.

```shell
        int n = s1.length();
        int m = s2.length();
        
        Map<Character,Integer> s1Map = new HashMap<>();
        Map<Character,Integer> s2Map = new HashMap<>();
        
        for (Character c : s1.toCharArray()) {
            s1Map.merge(c, 1, Integer::sum);
        }
```

Then we can use a sliding window to check if the s2 contains the permutation of s1.
in the window(substring), we can use another map to store the frequency of each character in the window. 
Then we can compare the two maps to check if the window contains the permutation of s1 i.e(map of s1 is same as s2 substring).

-- How does the frequency helps us to know that is the window contains the permutation of s1?
-- Well, if the two maps are the same,it means this substring(from s2) has same characters as it is in s1.

```java
     for (int i = 0; i <= m-n; i++) {
            String sub = s2.substring(i, i+n);
            for (int j = 0; j < n; j++) {
                s2Map.merge(sub.charAt(j), 1, Integer::sum);
            }
            if(s1Map.equals(s2Map)) return true;
            s2Map.clear();
        }
```

someone might as why do we clear the s2Map frequencies?
Well as mentioned above we just need to check if the substring of length s1 in s2 is equal.

---
Final code
---

```java
 public class Q567PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        Map<Character,Integer> s1Map = new HashMap<>();
        Map<Character,Integer> s2Map = new HashMap<>();

        for (Character c : s1.toCharArray()) {
            s1Map.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i <= m-n; i++) {
            String sub = s2.substring(i, i+n);
            for (int j = 0; j < n; j++) {
                s2Map.merge(sub.charAt(j), 1, Integer::sum);
            }
            if(s1Map.equals(s2Map)) return true;
            s2Map.clear();
        }
        return false;

    }
}
```