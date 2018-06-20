package tester;

import set.IntSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class IntSetSimulator {
    /**
     * The maximum value of elements in IntSet.
     */
    public static final int MAX_VALUE = 100000000;

    /**
     * The maximum number of elements in IntSet.
     */
    public static final int MAX_ELEMENT = MAX_VALUE / 100;

    /**
     * The simulation number of operation.
     */
    public static final int TRY_NUMBER = 35000;

    protected static List<Integer> makeRandomElements() {
        List<Integer> elements = new ArrayList<>();
        Random elementGenerator = new Random();

        for (int i = 0; i < TRY_NUMBER; ++i) {
            elements.add(elementGenerator.nextInt(MAX_VALUE + 1));
        }

        return elements;
    }

    protected static IntSet makeRandomCollection(Iterable<Integer> elements,
                                                 Class<? extends IntSet> classObject) {
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

    private long startMemory = 0;
    private long startTime = 0;

    protected IntSet cachedCollection = null;

    /**
     * Simulate all operations of IntSet.
     */
    public void simulateAll() {
        simulateInitialize();
        simulateInsert();
        simulateSize();
        simulateReport();
    }

    protected abstract void simulateInitialize();
    protected abstract void simulateSize();
    protected abstract void simulateInsert();
    protected abstract void simulateReport();

    protected void startSimulate(String simulationName) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println(
            String.format("=== %s '%s' complexity test starts ===",
                this.getClass().getSimpleName(),
                simulationName)
        );

        startMemory = runtime.totalMemory() - runtime.freeMemory();
        startTime = System.nanoTime();
    }

    protected void endSimulate(String simulationName) {
        Runtime runtime = Runtime.getRuntime();
        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        double elapsedTime = (double) (endTime - startTime) / 1000000000;

        System.out.println(
            String.format("Used memory = %d bytes.", (endMemory - startMemory))
        );

        System.out.println(String.format("Running time = %.3f seconds.", elapsedTime));

        System.out.println(
            String.format("=== %s '%s' complexity test ends ===",
                this.getClass().getSimpleName(),
                simulationName)
        );
    }
}
