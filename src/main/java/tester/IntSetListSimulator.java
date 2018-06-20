package tester;

import set.IntSetList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntSetListSimulator extends IntSetSimulator {
    @Override
    protected void simulateInitialize() {
        startSimulate("Initialize");

        for (int i = 0; i < TRY_NUMBER; ++i) {
            new IntSetList(MAX_ELEMENT, MAX_VALUE);
        }

        endSimulate("Initialize");
    }

    @Override
    protected void simulateInsert() {
        List<Integer> randomElements = makeRandomElements();

        startSimulate("Insert");
        cachedCollection = makeRandomCollection(randomElements,
                                                IntSetList.class);
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
