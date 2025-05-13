## Reverse String
```java
/**
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 
Example 1:
Input: s = “the sky is blue” Output: “blue is sky the”
 
Example 2:
Input: s = “ hello world “ Output: “world hello” Explanation: Your reversed string should not contain leading or trailing spaces.
 
Example 3:
Input: s = “a good example” Output: “example good a” Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 
Constraints:
1 <= s.length <= 1000
 
s contains English letters (upper-case and lower-case), digits, and spaces ‘ ‘.
*/
import java.io.*;
import java.util.*;
 
class Main {
    public static void main(String[] args) {
        //System.out.println("'" + reverse("the sky is blue") + "'");
        //System.out.println("'" + reverse("a good example 1 4") + "'");
        System.out.println("'" + reverse("hello   world") + "'");
    }
    public static String reverse (String in) {
        final StringBuilder builder = new StringBuilder();
        final String[] arr = in.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
           final String s = arr[i].trim(); 
           if (s.equals("")) continue;  
           builder.append(s);
 
           if (i > 0) {
             builder.append(" ");
           } 
        }    
        return builder.toString().trim();
    }
}
```

## Encode and Decode Strings
```java
class Solution {
    private final String separator = "|";

    public String encode(List<String> strs) {
        final StringBuilder builder = new StringBuilder();

        if (strs.size() == 1 && strs.get(0).isEmpty()) return separator;

        if (strs.isEmpty()) return "";

        for (int i = 0; i < strs.size(); i++) {
            builder.append(strs.get(i));

            if (i < (strs.size() - 1)) builder.append(separator);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        if (str.equals(separator)) {
            return Arrays.asList(getBlankValue());
        }

        if (str.isEmpty()) {
            return Collections.emptyList();
        }

        final String[] words = str.split("\\" + separator);

        return Arrays.asList(words);
    }

    private String[] getBlankValue() {
        return new String[] {""};
    }
}
```

## Grouping Anagrams
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);

            String ordered = new String(letters);
            
            //First, check if the key already exists, if not, create the new list
            //Second, the word is added to the map into the new list created
            map.computeIfAbsent(ordered, k -> new ArrayList<>()).add(word);
        }

        // O(N * Mlog)
        // System.out.println(map.values());
        return new ArrayList<>(map.values()); //[ate = [eat, tea, ate], bat = [bat], nat = [tan, nat]]
    }
}
```

## Valid Anagram
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        final int sLength = s.length();
        final int tLength = t.length();
        
        if (sLength != tLength) return false;
        
        final char[] sChars = s.toCharArray();
        final char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        s = new String(sChars);
        t = new String(tChars);
        
        return s.equals(t);
    }
}
```

## Reverse String
```java
class Solution {
    public void reverseString(char[] s) {
        final List<Character> list = new ArrayList<>();
        
        for (int i = s.length - 1; i >= 0; i--) {
            list.add(new Character(s[i]));
        }
        
        for (int i = 0; i < list.size(); i++) {
            s[i] = list.get(i);
        }
    }
}
```

## Reverse Integer
```java
class Solution {
    public int reverse(int x) {
        final StringBuilder builder = new StringBuilder();
        final String reverse = String.valueOf(x);
        
        for (int i = reverse.length() - 1; i >= 0; i--) {
            char value = reverse.charAt(i);
            
            if (value != '-') {
                builder.append(value); 
            }
        }
        
        try {
            final int result = Integer.valueOf(builder.toString());
            return (x >= 0 ? result : (result * -1));    
        } catch (final Exception ex) {
            return 0;
        }
    }
}
```

## StringToCharacterArray
```java
/**
 * https://www.geeksforgeeks.org/convert-a-string-to-character-array-in-java/
 */
public class StringToCharacterArray {
    public static void main(String[] args) {
        final String value = "Jether";
        
        System.out.println("First way: ");
        convertWayOne(value);

        System.out.println("Second way: ");
        convertWayTwo(value);
    }

    static void convertWayOne(final String toConvert) {
        final char[] ch = new char[toConvert.length()];

        for (int i = 0; i < toConvert.length(); i++) {
            ch[i] = toConvert.charAt(i);
        }

        for (char c : ch) {
            System.out.println(c);
        }
    }

    static void convertWayTwo(final String toConvert) {        
        for (char c : toConvert.toCharArray()) {
            System.out.println(c);
        }
    }
}
```

## SearchExtraCharacterInString
```java
/**
 * https://www.geeksforgeeks.org/find-one-extra-character-string/
 */
public class SearchExtraCharacterInString {
    public static void main(String[] args) {
        final String value1 = "Jether";
        final String value2 = "JetherZ";
        
        System.out.println("First way: ");
        System.out.println(firstWay(value1, value2));

        System.out.println("Second way: ");
        System.out.println(secondWay(value1, value2));

        System.out.println("Third way: ");
        System.out.println(thirdWay(value1, value2));
    }

    static char firstWay(final String v1, final String v2) {
        char result = Character.MIN_VALUE;
        int[] m = new int[256];
        char[] cv1 = getCharArrayFrom(v1);
        char[] cv2 = getCharArrayFrom(v2);

        for (int i = 0; i < cv2.length; i++) m[cv2[i]]++;

        for (int i = 0; i < cv1.length; i++) m[cv1[i]]--;
        
        for (int i = 0; i < m.length; i++) 
            if (m[i] == 1) result = (char) i;

        return result;
    }

    static char secondWay(final String v1, final String v2) {
        char result = Character.MIN_VALUE;

        for (int i = 0; i < v1.length(); i++) result ^= v1.charAt(i);

        for (int i = 0; i < v2.length(); i++) result ^= v2.charAt(i);         

        return result;
    }

    static char thirdWay(final String s1, final String s2) {
        String smallStr;
        String largeStr;
 
        if(s1.length() > s2.length()) {
            smallStr = s2;
            largeStr = s1;
        } else {
            smallStr = s1;
            largeStr = s2;
        }
 
        int smallStrCodeTotal = 0;
        int largeStrCodeTotal = 0;
        int i = 0;

        for(; i < smallStr.length(); i++) {
            smallStrCodeTotal += smallStr.charAt(i);
            largeStrCodeTotal += largeStr.charAt(i);
        }
 
        largeStrCodeTotal += largeStr.charAt(i);

        return (char)(largeStrCodeTotal - smallStrCodeTotal);
    }

    private static char[] getCharArrayFrom(final String value) {
        final char[] ch = new char[value.length()];

        for (int i = 0; i < value.length(); i++) 
            ch[i] = value.charAt(i);

        return ch;
    }
}
```
