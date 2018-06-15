package tester;

import set.IntSetBitVector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntSetBitVectorSimulator extends IntSetSimulator {
    private static final int MAX_VALUE = 1000000;
    private static final int MAX_ELEMENT = MAX_VALUE / 100;
    private static final int TRY_NUMBER = 35000;

    private static IntSetBitVector cachedList = null;

    private static List<Integer> makeRandomElements() {
        List<Integer> elements = new ArrayList<>();
        Random elementGenerator = new Random();

        for (int i = 0; i < TRY_NUMBER; ++i) {
            elements.add(elementGenerator.nextInt(MAX_VALUE + 1));
        }

        return elements;
    }

    private static IntSetBitVector makeRandomList(Iterable<Integer> elements) {
    	IntSetBitVector list = new IntSetBitVector(MAX_ELEMENT, MAX_VALUE);

        for (int element : elements) {
            list.insert(element);
        }

        return list;
    }

    public void simulateInitialize() {
        startSimulate("Initialize");

        for (int i = 0; i < TRY_NUMBER; ++i) {
            new IntSetBitVector(MAX_ELEMENT, MAX_VALUE);
        }

        endSimulate("Initialize");
    }

    public void simulateInsert() {
        startSimulate("Insert");
        cachedList = makeRandomList(makeRandomElements());
        endSimulate("Insert");
    }

    public void simulateReport() {
        int[] reportedElements = new int[cachedList.size()];

        startSimulate("Report");
        cachedList.report(reportedElements);
        endSimulate("Report");
    }

    public void simulateSize() {
        startSimulate("Size");
        cachedList.size();
        endSimulate("Size");
    }
}
