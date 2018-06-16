package set;

public class IntSetArr extends IntSet {

	private int[] array;
	int length, max;
	
	public IntSetArr(int maxElement, int maxValue) {
		super(maxElement, maxValue);
		this.array = new int[maxElement];
		this.max = maxValue;
	}
	
	@Override
	public void insert(int number) {
		if(length == array.length || number > max) return;
		this.array[length] = number;
		length++;
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public void report(int[] outContainer) {
		sort(0, length);

		for (int index = 0; index < length; ++index) {
			outContainer[index] = this.array[index];
		}
	}

	/*
	 * sort element of array in length
	 * the algorithm is quick sort
	 */
	private void sort(int low, int high) {
        if (low < high)
        {
            int pivotIndex = partition(low, high);
 
            // Recursively sort
            sort(low, pivotIndex-1);
            sort(pivotIndex+1, high);
        }
	}
	
	/*
	 * return pivot index after partitioning
	 */
    int partition(int low, int high)
    {
        int pivot = array[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; ++j)
        {
            if (array[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
 
        // swap arr[i+1] and pivot
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
 
        return i+1;
    }

}
