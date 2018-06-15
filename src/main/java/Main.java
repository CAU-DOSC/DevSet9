import tester.IntSetArraySimulator;
import tester.IntSetListSimulator;
import tester.IntSetSimulator;

public class Main {
    public static void main(String[] args) {
        IntSetSimulator listSimulator = new IntSetListSimulator();
        listSimulator.simulateAll();
        listSimulator = new IntSetArraySimulator();
        listSimulator.simulateAll();
    }
}
