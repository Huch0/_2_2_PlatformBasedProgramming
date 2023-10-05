package Lab04;

import java.util.Scanner;

enum StringCommand { ADD, REMOVE, CLEAN, QUIT, INVALID}
public class StringSetManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringSet = new String[100];
        while (true) {
            StringCommand command = getCommand(scanner);
            if ( command == StringCommand.QUIT ) {
                System.out.println("BYE!");
                break;
            }
            switch ( command ) {
                case ADD: {
                    String str = getString(scanner);
                    executeAdd(stringSet, str);
                    break;
                }
                case REMOVE: {
                    String str = getString(scanner);
                    executeRemove(stringSet, str);
                    break;
                }
                case CLEAN: {
                    executeClear(stringSet);
                    break;
                }
                default:
                    System.out.println("Unknown Command!");
                    break;
            }
            //executePrint(stringSet);
        }
    }
    // Your code here

    // Get StringCommand from input
    private static StringCommand getCommand(Scanner scanner) {
        final String inputCommand = scanner.next();
        StringCommand command;

        try {
            command = StringCommand.valueOf(inputCommand.toUpperCase());
        } catch(Exception e) {
            // if valueOf("SOMETHING") failed, it is not valid element of ENUM
            return StringCommand.INVALID;
        }

        return command;
    }

    // Get String from input
    public static String getString(Scanner scanner) {
        return scanner.next();
    }

    // Add newString to stringSet
    public static void executeAdd(String[] stringSet, String newString) {
        if (isFull(stringSet)) {
            displaySet(stringSet);
            return;
        }

        // newString already exists in set
        if (findString(stringSet, newString) != -1) {
            displaySet(stringSet);
            return;
        }

        // Find empty cell of the array
        for (int i = 0; i < 100; i++) {
            if (stringSet[i] == null) {
                stringSet[i] = newString;
                break;
            }
        }

        //int index = currentSize(stringSet);
        // Insert newString to the end of the stringSet
        // stringSet[index] = newString;
        // Sort the stringSet
        // sortSet(stringSet);

        displaySet(stringSet);
    }

    // Remove strToFind from stringSet
    public static void executeRemove(String[] stringSet, String strToRemove) {
        int index = findString(stringSet, strToRemove);

        // strToRemove wasn't founded
        if (index == -1) {
            displaySet(stringSet);
            return;
        }

        // Remove strToFind and Move elements from strToRemove's index to the end.
        /*
        for (int i = index; i < currentSize; i++) {
            stringSet[i] = stringSet[i + 1];
        }
        stringSet[currentSize - 1] = null;
        */
        stringSet[index] = null;

        displaySet(stringSet);
    }

    // Remove all elements of stringSet
    public static void executeClear(String[] stringSet) {
        /*
        int index = 0;

        while (stringSet[index] != null) {
            stringSet[index] = null;
            index++;
        }
        */
         for (int i = 0; i < 100; i++) {
             stringSet[i] = null;
         }

        displaySet(stringSet);
    }

    // Utility functions

    // Display contents of stringSet
    public static void displaySet(String[] stringSet) {
        int currentSize = currentSize(stringSet);

        System.out.print("Element Size: " + currentSize + ", Values = ");

        if (currentSize == 0) {
            System.out.println();
            return;
        }

        int index = 0;
        while (stringSet[index] == null) {
            index++;
        }

        System.out.print(stringSet[index]);

        for (int i = index + 1; i < 100; i++) {
            if (stringSet[i] != null)
                System.out.print(", " + stringSet[i]);
        }

        System.out.println();

        /*
        System.out.print(stringSet[0]);

        for (int i = 1; i < currentSize; i++) {
            System.out.print(", " + stringSet[i]);
        }

        System.out.println();

         */
    }

    // Return the number of existing elements of stringSet
    public static int currentSize(String[] stringSet) {
        /*
        int index = 0;

        while (stringSet[index] != null) {
            index++;
        }

        return index;

         */
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (stringSet[i] != null)
                count++;
        }
        return count;
    }

    // Find the index of strToFind from stringSet
    public static int findString(String[] stringSet, String strToFind) {
        int index = 0;

        // Find the index of strToFind from stringSet
        while (index < 100) {
            if (strToFind.equals(stringSet[index]))
                break;
            index++;
        }

        // strToFind wasn't founded
        if (index == 100)
            return -1;

        return index;
    }
    // Sort the stringSet in ascending order with Insertion Sort
    /*
    public static void sortSet(String[] stringSet) {
        int currentSize = currentSize(stringSet);
        for(int i = 1; i < currentSize; i++) {
            String currentStr = stringSet[i];
            int j = i - 1;

            // Move string to the right greater than currentStr
            while (j >= 0 && stringSet[j].compareTo(currentStr) > 0) {
                stringSet[j + 1] = stringSet[j];
                j--;
            }
            // Insert the currentStr in its correct position
            stringSet[j + 1] = currentStr;
        }
    }
    */
    public static boolean isFull(String[] stringSet) {
        return currentSize(stringSet) == 100;
    }
}
