package binarysearchtree;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {

    private int nodeCount = 0;

    private Node<T> root = null;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node<T> node, T element) {
        if (node.getData() == null) return false;
        int result = element.compareTo(node.getData());
        if (result < 0) return contains(node.getLeft(), element);
        else if (result > 0) return contains(node.getRight(), element);
        else return true;
    }

    @Override
    public boolean add(T element) {
        if (contains(root, element)) return false;
        root = add(root, element);
        nodeCount++;
        return true;
    }

    private Node<T> add(Node<T> node, T element) {
        if (node == null) {
            node = new Node<>(element, null, null);
        } else {
            int result = element.compareTo(node.getData());
            if (result < 0) {
                node.setLeft(add(node.getLeft(), element));
            } else {
                node.setRight(add(node.getRight(), element));
            }
        }
        return node;
    }

    @Override
    public boolean remove(T element) {
        if (!contains(root, element)) return false;
        root = remove(root, element);
        nodeCount--;
        return true;
    }

    private Node<T> remove(Node<T> node, T element) {
        int result = element.compareTo(node.getData());
        if (result > 0) {
            node.setRight(remove(node.getRight(), element));
        } else if (result < 0) {
            node.setLeft(remove(node.getLeft(), element));
        } else {
            if (node.getLeft() == null) {
                Node<T> rightNote = node.getRight();
                node.setData(null);
                node = null;
                return rightNote;
            } else if (node.getRight() == null) {
                Node<T> leftNote = node.getLeft();
                node.setData(null);
                node = null;
                return leftNote;
            } else {
                T temp = minRight(node.getRight());
                node.setData(temp);
                node.setRight(remove(node.getRight(), temp));
            }
        }

        return node;
    }

    private T minRight(Node<T> right) {
        while (right.getLeft() != null) right = right.getLeft();
        return right.getData();
    }

    private T maxLeft(Node<T> left) {
        while (left.getRight() != null) left = left.getRight();
        return left.getData();
    }

    @Override
    public Iterator<T> traverse(TreeTraverseType type) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
