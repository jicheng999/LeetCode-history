package pers.liujicheng.leetcode.easy.niqueorseodeWords;

import java.util.HashSet;

/**
 * @Author: 80002611
 * @Date: 2018/5/18
 * @parm
 * @Description: International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * <p>
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 * <p>
 * Return the number of different transformations among all words we have.
 * <p>
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * There are 2 different transformations, "--...-." and "--...--.".
 * <p>
 * <p>
 * Note:
 * <p>
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 */
public class UniqueMorseCodeWords {
    String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        byte[] arr = null;
        HashSet<String> set=new HashSet<>();
        StringBuilder str;
        for (int i = 0; i < words.length; i++) {
            arr = words[i].getBytes();
            str= new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                str.append(morse[arr[j] - 97]);
            }
            if (!set.contains(str.toString())) {
                set.add(str.toString());
            }
        }
        return set.size();
    }
}
