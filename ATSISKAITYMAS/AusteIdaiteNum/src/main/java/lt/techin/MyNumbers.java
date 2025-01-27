package lt.techin;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        return List.of();
    }

    @Override
    public int computeSumOfNumbers(int i) {
        return 0;
    }

    @Override
    public int computeSumOfNumbers(int i, NumberFilter numberFilter) {
        return 0;
    }

    @Override
    public List<Integer> computeNumbersUpTo(int i) {
        return List.of();
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
        return Map.of();
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int i, int i1) {
        return null;
    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        return null;
    }
}
