package graph;

import java.util.HashMap;

public class AlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {
        var wordsMap = new HashMap<Character, Integer>(order.length());

        for (int i = 0; i < order.length(); i++) {
            wordsMap.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            var word1 = words[i - 1];
            var word2 = words[i];

            for (int j = 0; j < word1.length(); j++) {
                if (j == word2.length()) return false;

                var char1 = word1.charAt(j);
                var char2 = word2.charAt(j);

                // if 1-st letter already sorted we do not need to check other
                if (wordsMap.get(char1) < wordsMap.get(char2)) break;
                if (wordsMap.get(char1) > wordsMap.get(char2)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "world"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
