package illich.so;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SearchToMap {

    public static void main(String[] args) {
        Map<Integer, Integer> antiPrimeNumbers = new LinkedHashMap();
        for (int number = 1; number < 100000; number++) {
            boolean shouldPrint = false;
            int deviserCounter = 0;
            for (int deviser = 1; deviser <= number; deviser++) {
                if (number % deviser == 0) {
                    deviserCounter++;
                }
            }
            if (canAddNewAntiPrimeNumber(antiPrimeNumbers, deviserCounter)) {
                antiPrimeNumbers.put(number, deviserCounter);
                shouldPrint = true;
            }
            if (shouldPrint) {
                printLatestPair(antiPrimeNumbers);
            }
        }
        System.out.println("===================");
        antiPrimeNumbers.entrySet().stream()
                .forEach((e) -> System.out.println("Number[" + e.getKey() + "] has + [" + e.getValue() + "] devisers."));

    }

    private static boolean canAddNewAntiPrimeNumber(Map<Integer, Integer> map, int deviserCounter) {
        return map.isEmpty() ||
                (!map.isEmpty() && getValueOfLastPair(map) < deviserCounter);
    }

    private static int getValueOfLastPair(Map<Integer, Integer> map) {
        final Set<Map.Entry<Integer, Integer>> mapValues = map.entrySet();
        final int maplength = mapValues.size();
        final Map.Entry<Integer, Integer>[] array = new Map.Entry[maplength];
        mapValues.toArray(array);

        return array[maplength - 1].getValue();
    }


    private static void printLatestPair(Map<Integer, Integer> map) {
        final Set<Map.Entry<Integer, Integer>> mapValues = map.entrySet();
        final int maplength = mapValues.size();
        final Map.Entry<Integer, Integer>[] array = new Map.Entry[maplength];
        mapValues.toArray(array);

        System.out.println("Number[" + array[maplength - 1].getKey() + "] has + [" + array[maplength - 1].getValue() + "] devisers.");

    }
}
