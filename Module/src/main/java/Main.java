public class Main {
    // add six to a number
    public static int addSix(int a){
        return a + 6;
    }

    static void main(String[] args) {
        int[] sizes = {1000, 100000, 10000000, 50000000};

        for (int size : sizes) {
            BinarySearchTree<Spot> tree = new BinarySearchTree<>();

            // Fill the tree with random spots
            for (int i = 0; i < size; i++) {
                tree.insert(Spot.randomSpot());
            }

            // Create the new spot before starting the timer
            Spot newSpot = Spot.randomSpot();

            long startTime = System.nanoTime();

            tree.insert(newSpot);

            long endTime = System.nanoTime();

            long elapsedTime = endTime - startTime;

            System.out.println("Tree size: " + size + ", insertion time: " + elapsedTime + " nanoseconds");
        }


    }

    public static Spot greatestLowerBound(
            BinarySearchTree<Spot> tree, double longitude) {

        Spot target = new Spot("", 0, longitude);

        return tree.greatestLowerBound(target);
    }
}
