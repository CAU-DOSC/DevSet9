package set;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent an unique integer set implemented through a linked-list.
 */
public class IntSetList extends IntSet {
    /**
     * Initialize a new 'IntSetList' instance.
     * @param maxElement the maximum number of elements.
     * @param maxValue the maximum value of element.
     */
    public IntSetList(int maxElement, int maxValue) {
        super(maxElement, maxValue);
    }

    @Override
    public void insert(int number) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void report(int[] outContainer) {

    }

    private static class LinkedList {
        private Node headNode;

        private LinkedList() {
            // set the head as a dummy node.
            this.headNode = new Node(0);
        }

        private void insertBack(Node newNode) {
            Node tailNode = headNode;
            while (tailNode.nextNode != null) {
                tailNode = tailNode.nextNode;
            }

            tailNode.nextNode = newNode;
        }

        private int find(int number) {
            int count = 0;

            for (Node node = headNode.nextNode; node != null; node = node.nextNode) {
                if (node.value == number) {
                    return count;
                }
                ++count;
            }

            return -1;
        }

        private int size() {
            int count = 0;

            for (Node node = headNode.nextNode; node != null; node = node.nextNode) {
                ++count;
            }

            return count;
        }

        private List<Integer> getElements() {
            List<Integer> elements = new ArrayList<>();
            for (Node node = headNode.nextNode; node != null; node = node.nextNode) {
                elements.add(node.value);
            }

            return elements;
        }
    }

    private static class Node {
        private int value;
        private Node nextNode;

        private Node(int value) {
            this.value = value;
        }
    }
}
