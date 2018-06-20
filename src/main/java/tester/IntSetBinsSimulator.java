package tester;

import java.util.List;
import set.IntSetBins;

public class IntSetBinsSimulator extends IntSetSimulator {
	@Override
    protected void simulateInitialize() {
        startSimulate("Initialize");
        for (int i = 0; i < TRY_NUMBER; ++i) {
            new IntSetBins(MAX_ELEMENT, MAX_VALUE);
        }
        endSimulate("Initialize");
	}

	@Override
    protected void simulateSize() {
        startSimulate("Size");
        cachedCollection.size();
        endSimulate("Size");
	}

	@Override
    protected void simulateInsert() {
        List<Integer> randomElements = makeRandomElements();

        startSimulate("Insert");
        cachedCollection = makeRandomCollection(randomElements,
                                                IntSetBins.class);
        endSimulate("Insert");
	}

	@Override
    protected void simulateReport() {
        int[] reportedElements = new int[cachedCollection.size()];

        startSimulate("Report");
        cachedCollection.report(reportedElements);
        endSimulate("Report");
	}

}
