package merge_two_sorted_array;

import java.util.Arrays;

public class Solution {

    public void merge(int[] arrayA, int[] arrayB, int tailA, int tailB) {
        int lastA = tailA + tailB + 1;
        while (tailA > -1 && tailB > -1) {
            if (arrayA[tailA] > arrayB[tailB]) {
                arrayA[lastA] = arrayA[tailA];
                lastA--;
                tailA--;
            } else {
                arrayA[lastA] = arrayB[tailB];
                lastA--;
                tailB--;
            }
        }

        if (tailA == -1) {
            System.arraycopy(arrayB, 0, arrayA, 0, tailB + 1);
        }
    }
}
