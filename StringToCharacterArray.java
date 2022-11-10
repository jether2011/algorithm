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