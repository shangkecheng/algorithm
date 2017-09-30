package algorithm;

import java.util.*;

/**
 * \* User: lucaskc
 * \* Date: 2017/9/27
 * \* Time: 上午9:25
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        return helper(s, 0, new ArrayList<>());
    }

    public int helper(String s, int pos, List<Character> longgest) {
        if (pos == s.length()) {
            return longgest.size();
        }
        char c = s.charAt(pos);
        if (longgest.isEmpty()) {
            longgest.add(c);
        } else {
            if (longgest.contains(c)) {
                int loc = longgest.indexOf(c);
                for (int i = loc; i >= 0; i--) {
                    longgest.remove(i);
                }
            }
            longgest.add(c);
        }

        int currLen = longgest.size();
        int returnLen = helper(s, pos + 1, longgest);
        return Math.max(currLen, returnLen);

    }
}
