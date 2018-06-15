import tester.IntSetBitVectorSimulator;
import tester.IntSetBstSimulator;
import tester.IntSetListSimulator;
import tester.IntSetSimulator;

public class Main {
    public static void main(String[] args) {
        IntSetSimulator listSimulator = new IntSetListSimulator();
        listSimulator.simulateAll();
        IntSetSimulator bstSimulator = new IntSetBstSimulator();
        bstSimulator.simulateAll();
        IntSetSimulator bitVectorSimulator = new IntSetBitVectorSimulator();
        bitVectorSimulator.simulateAll();
    }
}
