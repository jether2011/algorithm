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
