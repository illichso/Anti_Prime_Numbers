package illich.so;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<AntiPrimeNumberSearcher> antiPrimeNumbers = new ArrayList<>();
        long beginSearch;
        for (long number = 1; number < 100000; number++) {
            AntiPrimeNumberSearcher searcher = null;
            long deviserCounter = 0;
            beginSearch = System.nanoTime();
            for (long deviser = 1; deviser <= number; deviser++) {
                if (number % deviser == 0) {
                    deviserCounter++;
                }
            }
            if (canAddNewAntiPrimeNumber(antiPrimeNumbers, deviserCounter)) {
                long endSearch = System.currentTimeMillis();
                searcher = new AntiPrimeNumberSearcher(number, deviserCounter, beginSearch - endSearch );
                antiPrimeNumbers.add(searcher);
            }
            if (searcher != null) {
                searcher.print();
            }
        }
        System.out.println("===================");
        antiPrimeNumbers.stream().forEach(AntiPrimeNumberSearcher::print);

    }

    private static boolean canAddNewAntiPrimeNumber(List<AntiPrimeNumberSearcher> list, long deviserCounter) {
        return list.isEmpty() ||
                (!list.isEmpty() && getValueOfLastElement(list) < deviserCounter);
    }

    private static long getValueOfLastElement(List<AntiPrimeNumberSearcher> list) {
        AntiPrimeNumberSearcher searcher = list.get(list.size() - 1);
        return searcher.getDeviserCount();
    }

}
