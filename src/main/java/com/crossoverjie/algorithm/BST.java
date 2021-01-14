package com.crossoverjie.algorithm;

public class BST<Key extends Comparable<Key>, Value> {
    //二叉树根节点
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        //子节点总数
        private int N;
        private Node left, right;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.N = n;
        }
    }

    public Value get(Node root, Key key) {
        if (null == key) {
            return null;
        }
        int compareTo = root.key.compareTo(key);
        if (compareTo < 0) {
            get(root.right, key);
        } else if (compareTo > 0) {
            get(root.left, key);
        } else {
            return root.value;
        }
        return null;
    }


    public Node put(Node root, Key key, Value value) {
        if (null == key) {
            return null;
        }
        if (null == root) {
            return new Node(key, value, 1);
        }
        int compareTo = root.key.compareTo(key);
        if (compareTo > 0) {
            root.left = put(root.left, key, value);
        } else if (compareTo < 0) {
            root.right = put(root.right, key, value);
        } else {
            //覆盖
            root.value = value;
        }
        return root;
    }

    public Node deleteMin(Node root) {
        if (null == root) {
            return null;
        }
        if (root.left == null) {
            root = null;
            return null;
        }
        root.left = deleteMin(root.left);
        return root;
    }


    public static void main(String[] args) {
        BST<String, String> bst = new BST<>();
        bst.put("z", "2");
        bst.put("x", "2");
        bst.put("s", "2");
        bst.put("b", "2");
        bst.deleteMin();
        System.out.println(bst);

    }

    private void deleteMin() {
        root = deleteMin(root);
    }

    private void put(Key a, Value value) {
        root = put(root, a, value);
    }


}
