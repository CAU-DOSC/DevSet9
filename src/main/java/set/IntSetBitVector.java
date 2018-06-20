package set;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

public class IntSetBitVector extends IntSet {
    private BitSet bits;

    public IntSetBitVector(int maxElement, int maxValue) {
        super(maxElement, maxValue);
        bits = new BitSet();
    }

    @Override
    public void insert(int number) {
        if (bits.get(number) == false && size() < getMaxElement() && number <= getMaxValue()) {
            bits.set(number);
        }
    }

    @Override
    public int size() {
        return bits.cardinality();
    }

    @Override
    public void report(int[] outContainer) {
        List<Integer> listElements = new ArrayList<>();

        for(int index = 0; index <= getMaxValue(); index++) {
            if(bits.get(index) == true) {
                listElements.add(index);
            }
        }

        Collections.sort(listElements);

        for (int index = 0; index < outContainer.length; ++index) {
            outContainer[index] = listElements.get(index);
        }

    }

}
