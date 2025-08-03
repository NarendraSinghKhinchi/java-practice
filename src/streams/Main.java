package streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = 0; i < (start + 15); i++) {
                bingoPool.add("" + c + i);
                System.out.println("" + c + i);
            }
            start += 15;
        }

        Collections.shuffle(bingoPool);
        List<String> firstOnes = bingoPool.subList(0, 15);
        firstOnes.sort(Comparator.naturalOrder());

        firstOnes.replaceAll(s -> {
            if (s.indexOf('G') == 0 || s.indexOf("0") == 0) {
                return s.charAt(0) + "-" + s.substring(1);
            }
            return s;
        });

        bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf("0") == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted()
                .forEach(s -> System.out.println(s + " "));

        String[] strings = {"one", "two", "three"};
        Arrays.stream(strings)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        int seed = 1;

        var NStream = Stream.iterate(seed, i -> i <= 15, i -> 1 + 1)
                .map(i -> "B" + i);

        seed += 15;
        var IStream = Stream.iterate(seed, i -> i + 1)
                .limit(15).map(i -> "I" + i);

        seed += 15;
        int nSeed = seed;
        String[] oLabels = new String[15];
        Arrays.setAll(oLabels, i -> "G" + (nSeed + i));

        var StreamG = Arrays.stream(oLabels);
        seed += 15;

        var StreamO = Stream.of("G46", "G47");


        Stream.concat(StreamG, IStream).forEach(System.out::println);

//        IntStream.iterate((int)'A', i -> i <= (int)'z', i-> i+1)
//                .filter(Character::isAlphabetic)
//                .map(Character::toUpperCase)
//                .distinct()
//                .takeWhile(i -> i <'a')
//                .dropWhile(i -> i <= 'E')
//                .skip(5)
//                .filter(i -> Character.toUpperCase(i) > 'E')

        int maxSeats = 100;
        int seatsInRow = 10;

        var stream = Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                .map(i -> new Seat((char) ('A' + i / seatsInRow), i % seatsInRow + 1))
                        .map(Seat::price);

//        stream.forEach(System.out::println);

        var result = IntStream.iterate(0, i-> i <=1000, i -> i+1)
                .summaryStatistics();

//        System.out.println();
    }
}



















