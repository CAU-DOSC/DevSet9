import tester.IntSetArrSimulator;
import tester.IntSetBinsSimulator;
import tester.IntSetBitVectorSimulator;
import tester.IntSetBstSimulator;
import tester.IntSetListSimulator;
import tester.IntSetSimulator;

public class Main {
    public static void main(String[] args) {
    	System.out.println("[[Array Simulator]]");
        IntSetSimulator arrSimulator = new IntSetArrSimulator();
        arrSimulator.simulateAll();
    	System.out.println("[[List Simulator]]");
        IntSetSimulator listSimulator = new IntSetListSimulator();
        listSimulator.simulateAll();
    	System.out.println("[[BST Simulator]]");
        IntSetSimulator bstSimulator = new IntSetBstSimulator();
        bstSimulator.simulateAll();
    	System.out.println("[[BitVector Simulator]]");
        IntSetSimulator bitVectorSimulator = new IntSetBitVectorSimulator();
        bitVectorSimulator.simulateAll();
    	System.out.println("[[Bins Simulator]]");
        IntSetSimulator binsSimulator = new IntSetBinsSimulator();
        binsSimulator.simulateAll();
    }
}
