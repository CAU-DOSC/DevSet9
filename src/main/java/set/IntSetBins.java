package set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class IntSetBins extends IntSet {
	HashMap<Integer, ArrayList<Integer>> bucket;
	int maxValue;
	int maxElement;
	int divideNum;
	int size;

	public IntSetBins(int maxElement, int maxValue) {
		super(maxElement, maxValue);
		bucket = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0;i<11;i++) {
			bucket.put(i, new ArrayList<Integer>());
		}
		this.maxElement = maxElement;
		this.maxValue = maxValue;
		this.divideNum = maxValue/10;
		if(divideNum == 0) divideNum=1;
		this.size = 0;
	}

	@Override
	public void insert(int number) {
		if(number > maxValue || size >= maxElement) return;
		ArrayList<Integer> list = bucket.get(number/divideNum);
		if(list.contains(number)) return;
		list.add(number);
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void report(int[] outContainer) {
		for(int i=0;i<11;i++) {
			bucket.get(i).sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer x, Integer y) {
					return x-y;
				}
			});
		}
		for(int i=0, index = 0;i<11;i++) {
			ArrayList<Integer> list = bucket.get(i);
			for(Integer val : list) {
				outContainer[index++] = val;
				if(index == outContainer.length) return;
			}
		}
	}

}
