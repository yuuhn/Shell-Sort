package basepackage;

import java.util.Arrays;
import java.util.Scanner;

class ShellSort {
    private int[] sortedArray;

    ShellSort(int[] inArr) {
        sortedArray = sort(inArr);
    }

    private int[] sort(int[] arr) {
        int interval = 1;

        while (interval < arr.length / 3) {
            interval = interval * 3 + 1;
        }

        while (interval > 0) {

            // Through each element
            for (int i = interval; i < arr.length; i++) {
                int position = i;
                int value = arr[i];

                // Look for insertion
                while (position - interval > -1 && value < arr[position - interval]) {
                    arr[position] = arr[position - interval];
                    position -= interval;
                }

                arr[position] = value;
            }

            interval = (interval - 1) / 3;
        }

        return arr;
    }

    public String toString() {
        return Arrays.toString(sortedArray);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrLine = sc.nextLine();
        String[] numbers = arrLine.split(", ");
        int[] inArr = new int[numbers.length];

        for (int i = 0; i < inArr.length; i++) {
            inArr[i] = Integer.parseInt(numbers[i]);
        }

        // int[] inArr = new int[] {6, 5, 3, 6, 5, 3, 1, 8, 7, 2, 4, 1, 8, 6, 5, 3, 1, 8, 7, 2, 4, 14, 4};

        ShellSort sortedArr = new ShellSort(inArr);
        System.out.println(sortedArr.toString());
    }
}
