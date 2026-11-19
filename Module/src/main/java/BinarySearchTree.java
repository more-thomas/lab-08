public class BinarySearchTree<T extends Comparable<T>> {

    private class Node {
        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node insert(Node current, T data) {
        if (current == null) {
            return new Node(data);
        }

        int comparison = data.compareTo(current.data);

        if (comparison < 0) {
            current.left = insert(current.left, data);
        } else if (comparison > 0) {
            current.right = insert(current.right, data);
        }

        return current;
    }

    public boolean search(T data) {
        Node current = root;

        while (current != null) {
            int comparison = data.compareTo(current.data);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private Node delete(Node current, T data) {
        // The value was not found
        if (current == null) {
            return null;
        }

        int comparison = data.compareTo(current.data);

        if (comparison < 0) {
            current.left = delete(current.left, data);
        } else if (comparison > 0) {
            current.right = delete(current.right, data);
        } else {
            // We found the node to delete

            // If there is no left child, return the right child
            if (current.left == null) {
                return current.right;
            }

            // If there is no right child, return the left child
            if (current.right == null) {
                return current.left;
            }

            // The node has two children.
            // Find the smallest value in the right subtree.
            Node smallest = current.right;

            while (smallest.left != null) {
                smallest = smallest.left;
            }

            // Replace the value we are deleting
            current.data = smallest.data;

            // Delete the value from its old location
            current.right = delete(current.right, smallest.data);
        }

        return current;
    }

    public T greatestLowerBound(T target) {
        Node current = root;
        T best = null;

        while (current != null) {
            int comparison = current.data.compareTo(target);

            if (comparison == 0) {
                // We found an exact match
                return current.data;
            } else if (comparison < 0) {
                // This value is below the target, so save it
                best = current.data;

                // Look right for a value that might be closer
                current = current.right;
            } else {
                // This value is too high, so look left
                current = current.left;
            }
        }

        return best;
    }
}

