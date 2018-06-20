package set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntSetBst extends IntSet {
    private BinarySearchTree root;

    public IntSetBst(int maxElement, int maxValue) {
        super(maxElement, maxValue);

        root = new BinarySearchTree();
    }

    @Override
    public void insert(int number) {
        if ((size() < getMaxElement()) && (number <= getMaxValue())) {
            root.insertBST(number);
            }

    }

    @Override
    public int size() {
        return root.size();
    }

    @Override
    public void report(int[] outContainer) {
        List<Integer> listElements = root.getElements();
        Collections.sort(listElements);

        for (int index = 0; index < outContainer.length; ++index) {
            outContainer[index] = listElements.get(index);
        }


    }

    public class BinarySearchTree {
        private TreeNode root;

        private TreeNode insertKey(TreeNode root, int x) {
            TreeNode p = root;
            TreeNode newNode = new TreeNode(x);

            if(p==null){
                return newNode;
            }else if(p.value>newNode.value){
                p.left = insertKey(p.left, x);
                return p;
            }else if(p.value<newNode.value){
                p.right = insertKey(p.right, x);
                return p;
            }else{
                return p;
            }
        }

        private void insertBST(int x){
            root = insertKey(root, x);
        }

        private TreeNode searchBST(int x){
            TreeNode p = root;
            while(p!=null){
                if(x<p.value) p = p.left;
                else if(x>p.value) p = p.right;
                else return p;
            }
            return p;
        }

        private int size() {
            if(root != null) {
                return root.size();
            }
            return 0;
            }

        private List<Integer> getElements() {
            List<Integer> elements = new ArrayList<>();
            return getElement(root, elements);
        }

        private List<Integer> getElement(TreeNode node, List<Integer> elements) {
            if(node!=null) {
                getElement(node.left, elements);
                elements.add(node.getValue());
                getElement(node.right, elements);
            }
            return elements;
        }
    }

    public class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(){
            this.left = null;
            this.right = null;
        }

        public TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        private int size() {
            int size = 1;
            if(left != null) {
                size += left.size();
            }
            if(right != null) {
                size += right.size();
            }
            return size;
        }

        private int getValue(){
            return value;
        }
    }

}
