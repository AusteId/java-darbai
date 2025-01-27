package lt.techin;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.*;

public class MyNumbers implements Exercises {

    @Override
    public Integer findSmallest(List<Integer> list) {
        return list.stream().min(Integer::compare).get();
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        return list.stream().max(Integer::compare).get();
    }

    @Override
    public boolean isEqual(Object o, Object o1) {
        return o.equals(o1);
    }

    @Override
    public boolean isSameObject(Object o, Object o1) {
        return o == o1;
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {

        List<Integer> integers = new ArrayList();

        while (iterator.hasNext()) {
            integers.add(iterator.next());
        }

        return integers;
    }

    @Override
    public int computeSumOfNumbers(int i) {

        List<Integer> numbers = new ArrayList<>();

        for (int j = 1; j <= i; j++) {
            numbers.add(j);
        }

        return numbers.stream().reduce(Integer::sum).orElse(0);
    }

    @Override
    public int computeSumOfNumbers(int i, NumberFilter numberFilter) {

        List<Integer> numbers = new ArrayList<>();

        for (int j = 1; j <= i; j++) {
            numbers.add(j);
        }

        return numbers.stream().filter(numberFilter::accept).reduce(Integer::sum).orElse(0);
    }

    @Override
    public List<Integer> computeNumbersUpTo(int i) {

        List<Integer> numbers = new ArrayList<>();

        for (int j = 1; j < i; j++) {
            numbers.add(j);
        }

        return numbers;
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {

        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int number : list) {
            if (!occurrences.containsKey(number)) {
                occurrences.put(number, 1);
            } else {
                int initialAmount = occurrences.get(number);
                occurrences.put(number, initialAmount + 1);
            }
        }
        return occurrences;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int i, int i1) {

        return new NewGenerator(i, i1);

    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        return new NewFilteredGenerator(integerGenerator, numberFilter);
    }
}
