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
