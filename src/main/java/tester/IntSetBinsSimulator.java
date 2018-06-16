package tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import set.IntSet;
import set.IntSetArr;
import set.IntSetBins;

public class IntSetBinsSimulator extends IntSetSimulator {
    private static final int MAX_VALUE = 100000000;
    private static final int MAX_ELEMENT = MAX_VALUE / 100;
    private static final int TRY_NUMBER = 35000;

    private static IntSet cachedCollection = null;

    private static List<Integer> makeRandomElements() {
        List<Integer> elements = new ArrayList<>();
        Random elementGenerator = new Random();

        for (int i = 0; i < TRY_NUMBER; ++i) {
            elements.add(elementGenerator.nextInt(MAX_VALUE + 1));
        }

        return elements;
    }

    private static IntSet makeRandomCollection(Iterable<Integer> elements, Class<? extends IntSet> classObject) {
    	IntSet collection = null;
		try {
			collection = (IntSet) classObject.getConstructors()[0].newInstance(MAX_ELEMENT, MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}

        for (int element : elements) {
        	collection.insert(element);
        }

        return collection;
    }

	@Override
	public void simulateInitialize() {
        startSimulate("Initialize");
        for (int i = 0; i < TRY_NUMBER; ++i) {
            new IntSetBins(MAX_ELEMENT, MAX_VALUE);
        }
        endSimulate("Initialize");
	}

	@Override
	public void simulateSize() {
        startSimulate("Size");
        cachedCollection.size();
        endSimulate("Size");
	}

	@Override
	public void simulateInsert() {
        startSimulate("Insert");
        cachedCollection = makeRandomCollection(makeRandomElements(), IntSetArr.class);
        endSimulate("Insert");
	}

	@Override
	public void simulateReport() {
        int[] reportedElements = new int[cachedCollection.size()];

        startSimulate("Report");
        cachedCollection.report(reportedElements);
        endSimulate("Report");
	}

}
