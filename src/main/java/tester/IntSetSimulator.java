package tester;

public abstract class IntSetSimulator {
    private long startMemory = 0;
    private long startTime = 0;

    public void simulateAll() {
        simulateInitialize();
        simulateInsert();
        simulateSize();
        simulateReport();
    }

    public abstract void simulateInitialize();
    public abstract void simulateSize();
    public abstract void simulateInsert();
    public abstract void simulateReport();

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
