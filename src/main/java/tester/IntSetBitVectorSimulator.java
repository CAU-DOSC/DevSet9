package tester;

import set.IntSetBitVector;

import java.util.List;

public class IntSetBitVectorSimulator extends IntSetSimulator {
    @Override
    protected void simulateInitialize() {
        startSimulate("Initialize");

        for (int i = 0; i < TRY_NUMBER; ++i) {
            new IntSetBitVector(MAX_ELEMENT, MAX_VALUE);
        }

        endSimulate("Initialize");
    }

    @Override
    protected void simulateInsert() {
        List<Integer> randomElements = makeRandomElements();

        startSimulate("Insert");
        cachedCollection = makeRandomCollection(randomElements,
                                                IntSetBitVector.class);
        endSimulate("Insert");
    }

    @Override
    protected void simulateReport() {
        int[] reportedElements = new int[cachedCollection.size()];

        startSimulate("Report");
        cachedCollection.report(reportedElements);
        endSimulate("Report");
    }

    @Override
    protected void simulateSize() {
        startSimulate("Size");
        cachedCollection.size();
        endSimulate("Size");
    }
}
