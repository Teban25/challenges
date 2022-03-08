package challenges.interviews;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EpamPractice {

    public static String reverseString(String original) {
        char[] toReverse = original.toCharArray();
        char[] reversed = new char[toReverse.length];
        int size = toReverse.length - 1;

        for (int i = 0; i < toReverse.length; i++) {
            reversed[i] = toReverse[size - i];
        }

        return String.valueOf(reversed);
    }

    public static boolean stringsAreAnagram(String first, String second) {

        if ((first != null && first.length() > 0) && (second != null && second.length() > 0)
                && first.length() == second.length()) {
            for (int i = 0; i < first.length(); i++) {
                char letter = first.charAt(i);
                int index = second.indexOf(letter);

                if (index != -1) {
                    second = second.substring(0, index) + second.substring(index + 1);
                } else {
                    break;
                }
            }
        } else {
            return false;
        }

        return second.isEmpty();
    }

    public static boolean hasAllUniqueCharacters(String original) {
        boolean hasUniqueCharacters = true;
        Set<Character> checkedUnique = new HashSet<>();
        for (int i = 0; i < original.length(); i++) {
            char element = original.charAt(i);

            if (!checkedUnique.add(element)) {
                hasUniqueCharacters = false;
                break;
            }
        }

        return hasUniqueCharacters;
    }

    public static boolean stringIsRotationOfAnother(String first, String second) {
        String str = first + first;
        boolean isRotation = false;

        if (str.contains(second)) {
            isRotation = true;
        }

        return isRotation;
    }

    public static Map<Character, Integer> getCountCharacters(String original) {
        Map<Character, Integer> countCharacters = new HashMap<>();

        for (int i = 0; i < original.length(); i++) {
            char element = original.charAt(i);

            if (countCharacters.containsKey(element)) {
                countCharacters.put(element, countCharacters.get(element) + 1);
            } else {
                countCharacters.put(element, 1);
            }
        }

        return countCharacters.entrySet().stream().filter(i -> i.getValue() > 1)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
    }

    public static void printTransactions() {
        List<Map<String, Integer>> transactions = List.of(Map.of("eur", 100, "usd", 200),
                Map.of("usd", 200, "cop", 400), Map.of("usd", 300, "cop", 500));

       // Map<String, Integer> result = new HashMap<>();

        // Java streams solution
        Map<String, Integer> results2 = transactions.stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));

/*
        Traditional solution
        for (int i = 0; i < transactions.size(); i++) {
            Map<String, Integer> transactions2 = transactions.get(i);
            for (Map.Entry<String, Integer> entry : transactions2.entrySet()) {
                String currency = entry.getKey();
                if (result.containsKey(currency)) {
                    result.put(currency, result.get(currency) + entry.getValue());
                } else {
                    result.put(currency, entry.getValue());
                }
            }
        }
*/
        for (Map.Entry<String, Integer> entry : results2.entrySet()) {
            System.out.println(entry.getValue() + "-" + entry.getKey());
        }

    }


    public static Character getFirstNonRepeatedCharacter(String original) {
        Map<Character, Integer> countCharacters = new LinkedHashMap<>();
        AtomicReference<Character> firstNonRepeatedCharacter = null;

        for (int i = 0; i < original.length(); i++) {
            Character element = original.charAt(i);
            if (!countCharacters.containsKey(element)) {
                countCharacters.put(element, 1);
            } else {
                countCharacters.put(element, countCharacters.get(element) + 1);
            }
        }

        /* another possible solution using java stream api
        countCharacters.entrySet().stream().filter(i -> i.getValue() == 1).findFirst().ifPresentOrElse(j -> firstNonRepeatedCharacter.set(j.getKey()), () -> {
            firstNonRepeatedCharacter.set(null);
        });
        */
        for (Map.Entry<Character, Integer> element: countCharacters.entrySet()) {
            if(element.getValue() == 1) {
                firstNonRepeatedCharacter.set(element.getKey());
            }
        }

        return firstNonRepeatedCharacter.get();
    }

    public String longestNonRepeatSubStringForceBrute(String original) {
        String longestSubStr = "";

        for (int i = 0; i < original.length(); i++) {
            Set<Character> subChars = new LinkedHashSet<>();
            StringBuilder temporalSubChars = new StringBuilder();
            for (int j = i; j < original.length(); j++) {
                char element = original.charAt(j);

                if(subChars.add(element)) {
                    temporalSubChars.append(element);
                } else {
                    break;
                }
            }

            if(longestSubStr.length() < temporalSubChars.length()) {
                longestSubStr = temporalSubChars.toString();
            }

            if(longestSubStr.length() >= (original.length() - i)) {
                break;
            }
        }

        return longestSubStr;
    }

    @Test
    public void testingLongestNonRepeatSubString() {
        assertEquals("", longestNonRepeatSubStringForceBrute(""));
        assertEquals("A", longestNonRepeatSubStringForceBrute("A"));
        assertEquals("ABCDEF", longestNonRepeatSubStringForceBrute("AABCDEF"));
        assertEquals("ABCDEF", longestNonRepeatSubStringForceBrute("ABCDEFF"));
        assertEquals("NGISAWE", longestNonRepeatSubStringForceBrute("CODINGISAWESOME"));
        assertEquals("be coding", longestNonRepeatSubStringForceBrute("always be coding") );
    }

    @Test
    public void testingRepeatedCharacters() {
        String original = "java2blog.com";
        Map<Character, Integer> expected = Map.of('a',2, 'o', 2);

        Map<Character, Integer> actual = getCountCharacters(original);

        assertAll(
                () ->  assertEquals(2, actual.size()),
                () -> expected.keySet().equals(actual.keySet()),
                () -> expected.values().equals(actual.values())
        );
    }

    @Test
    public void testingUniqueCharacters() {
        String original = "index";
        boolean expected = true;

        boolean actual = hasAllUniqueCharacters(original);

        assertEquals(expected, actual);
    }

    @Test
    public void testingAreAnagram() {
        String first = "listen";
        String second = "silent";
        boolean expected = true;

        boolean actual = stringsAreAnagram(first, second);

        assertEquals(expected, actual);
    }

    @Test
    public void testingReverseString() {
        String toReverse = "Hello world";
        String expected = "dlrow olleH";

        String reversed = reverseString(toReverse);

        assertEquals(expected, reversed);
    }
}
