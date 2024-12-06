## Two Sum 
```java
class Solution {  
    public int[] twoSum(int[] nums, int target) {  
        final Map<Integer, Integer> map = new HashMap<>();  
        for (int i = 0; i < nums.length; i++) {  
            int difference = target - nums[i]; 

            if (map.containsKey(difference)) {  
                return new int[] {i, map.get(difference)}; 
            }

            map.put(nums[i], i);  
        }  

        return null;
    }
} 
```

## Fibonacci 
```java
public interface Calculable {  
    Long calculate(int n);   
}  

class Solution implements Calculable { 
    // Memoization - Optimize the code with a  
    // cache to be hitted first than the calculable result   
    final Map<Integer, Long> cache = new HashMap<>();

    override public Long calculate(int n) {   
        if(n <= 0) return n;  
        if(cache.containsKey(n)) return cache.get(n); 

        final Long result = calculate(n - 1) + calculate(n - 2); 
        cache.put(n, result);
        return result;
    } 
} 
```

## Duplicated Characters 
```java
class Solution {  
    public int validateDuplicates(String input) {  
        final Set<Character> duplicates = new HashSet<>(); 
        final Set<Character> notDuplicates = new HashSet<>();  
        Input = input.toLowerCase(); 

        for (char c: input.toCharArray()) { 
            if (notDuplicated.contains(c)) { 
                duplicated.add(c); 
            } else { 
                notDuplicated.add(c); 
            } 
        }

        return duplicates.size();  
    } 
} 
```

## Remove Duplicates from Sorted Array 
```java
class Solution { 
    public int removeDuplicates(int[] nums) { 
        int k = 0; 

        // 1,1,2 
        for (int x : nums) { 
            if (k == 0 || x != nums[k - 1]) { 
                nums[k++] = x; 
            } 
        } 
        System.out.println(k); 
        return k; 
    } 
} 
```

## Best Time to Buy and Sell Stock II 
```java
class Solution {
    /*
    Input: prices = [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    Total profit is 4 + 3 = 7.
    */
    public int maxProfit(int[] prices) {
        int profit = 0;
        
        final int length = prices.length;
        for (int i = 0; i < length; i++) {
            if ((i + 1) >= length) break;
            
            if (prices[i + 1] > prices[i]) {
                profit += (prices[i + 1] - prices[i]);
            }
        }
        
        return profit;
    }
}
```

## Rotate Array
```java
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k<= 0) return;
            
        k = k % nums.length;
        int start = 0;
        int end = nums.length - 1;
        
        reverse(nums, start, end);
        reverse(nums, start, k - 1);
        reverse(nums, k, end);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

## Contains Duplicate
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        boolean hasDuplicated = false;
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                hasDuplicated = true;
                break;
            }
            
            map.put(nums[i], i);
        }
        
        return hasDuplicated;
    }
}
```

## Single Number
```java
class Solution {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        int result = 0;
        
        for (int i = 0; i < length; i++) {
            result ^= nums[i]; 
        }
        
        return result;
    }
}
```

## Intersection of Two Arrays II
```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        final Map<Integer, Integer> map = new HashMap<>();
        final List<Integer> result = new ArrayList<>();
        
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        return result.stream().mapToInt(value -> value).toArray();
    }
}
```

## Plus One
```java
class Solution {
    public int[] plusOne(int[] digits) {
        final int length = digits.length;
        
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] result = new int[length + 1];
        result[0] = 1;
        
        return result;
    }
}
```

## Move Zeroes
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroes = 0;
        final List<Integer> others = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else {
                others.add(nums[i]);
            }
        }
        
        for (int i = 0; i < zeroes; i++) {
            others.add(0);
        }
        
        for (int i = 0; i < others.size(); i++) {
            nums[i] = others.get(i);
        }
    }
}
```

## Valid Sudoku
```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int BOARD = 9;
        boolean[][] row = new boolean[BOARD][BOARD];
        boolean[][] col = new boolean[BOARD][BOARD];
        boolean[][] sub = new boolean[BOARD][BOARD];
        
        for (int i = 0; i < BOARD; ++i) {
            for (int j = 0; j < BOARD; ++j) {
                char c = board[i][j];
                
                if (c == '.') {
                    continue;
                }
                
                int num = c - '0' - 1;
                int k = i / 3 * 3 + j / 3;
                
                if (row[i][num] || col[j][num] || sub[k][num]) {
                    return false;
                }
                
                row[i][num] = true;
                col[j][num] = true;
                sub[k][num] = true;
            }
        }
        
        return true;
    }
}
```

## Rotate Imagem
```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n >> 1; ++i) {
            for (int j = 0; j < n; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = t;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
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
