package DSA;

public class Arrays {

    public static String linearSearch_string(String menu[], String item) {

        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == item) {
                return item;
            }
        }
        return "Not found";
    }

    public static int linearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;

    }

    public static int largestValue(int numbers[]) {
        int largestNum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > largestNum) {
                largestNum = numbers[i];
            }
        }
        return largestNum;

    }

    public static int smallestValue(int numbers[]) {
        int smallestNum = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < smallestNum) {
                smallestNum = numbers[i];

            }
        }
        return smallestNum;

    }

    public static int binarySearch(int numbers[], int key) {
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] == key) {
                return mid;
            }
            if (numbers[mid] < key) {
                start = mid + 1; // right half
            } else {
                end = mid - 1; // left half
            }
        }
        return -1;
    }

    public static void reverse_array(int numbers[]) {
        int first = 0, last = numbers.length - 1;
        while (first < last) {
            int temp = numbers[first];
            numbers[first] = numbers[last];
            numbers[last] = temp;

            first++;
            last--;
        }
    }

    public static void set_of_arrays(int numbers[]) {
        int tp = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print("(" + numbers[i] + ", " + numbers[j] + ")" + " ");
                tp++;
            }
            System.out.println();
        }
        // System.out.println((numbers.length * (numbers.length - 1)) / 2);
        System.out.println("total numbers of pairs: " + tp);
    }

    public static void subArrays(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(numbers[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void maxsum_of_subArrays(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += numbers[k];
                }
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
                System.out.println(currSum);
            }
            System.out.println();
        }
        System.out.println("max sum : " + maxSum);
    }

    public static void prefix_sum_of_subArrays(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        System.out.println("Max Sum: " + maxSum);
    }

    public static void kadane_sum_of_subArrays(int numbers[]) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            currSum += numbers[i];

            if (currSum < 0) {
                currSum = 0;
            }
            if (maxSum <= 0) {
                currSum = 0;
                currSum += numbers[i];
                maxSum = currSum;
            }
            maxSum = Math.max(currSum, maxSum);

        }
        System.out.println("Max Sum: " + maxSum);

    }

    public static int trapping_water(int height[]) {
        // calculate left max of array
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        // calculate right max of array
        int rightMax[] = new int[height.length];
        rightMax[rightMax.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        // Loop
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            // waterLevel = min(left max of array, right max of array) - height[i]
            int waterLevel = Math.min(leftMax[i], rightMax[i]) - height[i];
            trappedWater += waterLevel;
        }
        return trappedWater;
    }

    public static void buy_sell_Stocks(int prices[]) {
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyingPrice < prices[i]) {
                int profit = prices[i] - buyingPrice; // todays profit
                maxProfit = Math.max(maxProfit, profit); // maximum profit
            } else {
                buyingPrice = prices[i];
            }
        }

        System.out.println(maxProfit);
    }

    public static void main(String args[]) {

        // int prices[] = { 7, 1, 5, 3, 6, 4 };
        // int numbers[] = { 1, 3, 4, 6, 8 };
        // int height[] = { 4, 2, 0, 6, 2, 3, 5 };

    }
}
