package DSA;

public class Sorting {
    // Bubble Sort Function
    public static void bubbleSort(int[] arr) {
        // outer loop represents turn
        int numberOfSwap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            // inner loop
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // just change the relational operator to sort the elements in ascending order
                if (arr[j] < arr[j + 1]) {
                    // swaping
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                numberOfSwap++;
            }
        }
        System.out.println(numberOfSwap);
    }

    // Selection Sort Function
    public static void selectionSort(int[] arr) {
        // outer loop
        int numberOfSwap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestNum = i;
            // inner loop
            for (int j = i + 1; j < arr.length; j++) {
                // just change the relational operator to sort the elements in ascending order
                if (arr[j] > arr[smallestNum]) {
                    smallestNum = j;
                }
            }
            // swaping
            int temp = arr[i];
            arr[i] = arr[smallestNum];
            arr[smallestNum] = temp;
            numberOfSwap++;
        }
        System.out.println(numberOfSwap);
    }

    // Insertion Sort Function
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int curr = arr[i + 1];
            int prev = i;

            // just change the relational operator to sort the elements in descending order
            // finding out the correct position to insert the element
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev + 1] = curr;
        }
    }

    // Counting Sort Function for Ascending order
    public static void countingSort(int[] arr) {
        int largestNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largestNum = Math.max(largestNum, arr[i]);
        }
        // creating a new array with the size of original array + 1
        int count[] = new int[largestNum + 1];

        // calculating the frequency
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    // Counting Sort Function for Descending order
    public static void countingSortDescending(int arr[]) {
        int largestNum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            largestNum = Math.max(largestNum, arr[i]);
        }
        int[] count = new int[largestNum + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = count.length;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j--;
                count[i]--;
            }
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        countingSortDescending(arr);
        printArray(arr);
    }
}

// --------- INBUILT SORTS
// Arrays.sort(arr, Collections.reverseOrder());
// Arrays.sort(arr, 0, 2, Collections.reverseOrder());
// Arrays.sort(arr, 0, 3);