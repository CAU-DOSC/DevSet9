package set;

/**
 * Represent an unique integer set.
 */
public abstract class IntSet {
    private int maxElement;
    private int maxValue;

    protected IntSet(int maxElement, int maxValue) {
        if (maxElement < 0) {
            throw new IllegalArgumentException("the number of elements must be greater than 0.");
        }

        this.maxElement = maxElement;
        this.maxValue = maxValue;
    }

    /**
     * Add a new integer to the set only if it is not already contained.
     * @param number a new integer to add.
     */
    public abstract void insert(int number);

    /**
     * Get the current number of elements.
     * @return the current number of elements.
     */
    public abstract int size();

    /**
     * Store sorted elements in the out container.
     */
    public abstract void report(int[] outContainer);

    /**
     * Get the maximum number of elements.
     * @return the maximum number of elements.
     */
    public int getMaxElement() {
        return maxElement;
    }

    /**
     * Get the maximum value of element.
     * @return the maximum value of element.
     */
    public int getMaxValue() {
        return maxValue;
    }
}
