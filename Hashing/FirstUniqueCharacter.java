package Hashing;

import java.util.HashMap;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();

        // Step 1: Populate the frequency map
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find the first unique character
        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) == 1) {
                return i;
            }
        }

        // No unique character found
        return -1;
    }

    public static void main(String[] args) {
        String str = "leetcode";

        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        int ans = firstUniqueCharacter.firstUniqChar(str);

        System.out.println("Ans: " + ans); 
    }
}
