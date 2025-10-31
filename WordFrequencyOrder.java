import java.util.*;

class WordFrequencyOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the paragraph input and convert to lowercase
        String input = scanner.nextLine().toLowerCase();

        // Read sorting option (0 - alphabetical, 1 - frequency)
        int option = scanner.nextInt();

        // Use TreeMap to automatically keep keys in alphabetical order
        TreeMap<String, Integer> map = new TreeMap<>();

        String s = ""; // Temporary variable to build each word

        // Iterate through each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Keep letters or numbers as part of a word
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                s += ch;
            } else {
                // If a separator or punctuation is found, store the word
                if (!s.isEmpty()) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    s = "";
                }
            }
        }

        // Handle the last word if string doesn't end with punctuation
        if (!s.isEmpty()) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // Option 0: alphabetical (TreeMap default)
        if (option == 0) {
            for (String key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
        }
        // Option 1: sort by frequency descending manually
        else {
            // Convert map entries to list for sorting by value
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
            entryList.sort((a, b) -> {
                int freqCompare = b.getValue().compareTo(a.getValue());
                if (freqCompare == 0) {
                    return a.getKey().compareTo(b.getKey());
                }
                return freqCompare;
            });

            // Print results
            for (Map.Entry<String, Integer> entry : entryList) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        scanner.close();
    }
}
