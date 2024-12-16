import java.util.Stack;

public class CreatureSorter {

    // Inner class to represent a Creature
    static class Creature {
        String name;
        int powerLevel;

        Creature(String name, int powerLevel) {
            this.name = name;
            this.powerLevel = powerLevel;
        }

        @Override
        public String toString() {
            return name + " (Power Level: " + powerLevel + ")";
        }
    }

    public static void main(String[] args) {
        // Fixed input data
        Creature[] creatures = {
            new Creature("Dragon", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85)
        };

        // Bubble Sort in descending order
        System.out.println("Sorted by Bubble Sort (Descending):");
        bubbleSort(creatures, false);
        printCreatures(creatures);

        // Selection Sort in ascending order
        System.out.println("\nSorted by Selection Sort (Ascending):");
        selectionSort(creatures, true);
        printCreatures(creatures);

        // Stack Implementation
        System.out.println("\nStack Implementation (Descending Order):");
        Stack<Creature> stack = new Stack<>();
        bubbleSort(creatures, false); // Ensure descending order
        for (Creature creature : creatures) {
            stack.push(creature);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    // Bubble Sort implementation
    public static void bubbleSort(Creature[] creatures, boolean ascending) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((ascending && creatures[j].powerLevel > creatures[j + 1].powerLevel) ||
                    (!ascending && creatures[j].powerLevel < creatures[j + 1].powerLevel)) {
                    Creature temp = creatures[j]; // Swap the creatures
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort implementation
    public static void selectionSort(Creature[] creatures, boolean ascending) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            int extremumIdx = i;
            for (int j = i + 1; j < n; j++) {
                if ((ascending && creatures[j].powerLevel < creatures[extremumIdx].powerLevel) ||
                    (!ascending && creatures[j].powerLevel > creatures[extremumIdx].powerLevel)) {
                    extremumIdx = j;
                }
            }
            // Swap the creatures
            Creature temp = creatures[extremumIdx];
            creatures[extremumIdx] = creatures[i];
            creatures[i] = temp;
        }
    }

    // Method to print the creatures array
    public static void printCreatures(Creature[] creatures) {
        for (Creature creature : creatures) {
            System.out.println(creature);
        }
    }
}