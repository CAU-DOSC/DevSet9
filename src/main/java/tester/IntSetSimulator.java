package tester;

public abstract class IntSetSimulator {
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
}
