//to chech given string is Anagram
import java.util.HashMap;

public class AnagramHashMap {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // Count chars in s1
        for (char c : s1.toLowerCase().toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Subtract counts using s2
        for (char c : s2.toLowerCase().toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c); // cleanup
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("java", "avaj"));     // true
        System.out.println(isAnagram("hello", "world"));   // false
    }
}
