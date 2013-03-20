package numbers_with_broken_key;

import java.util.ArrayList;

public class Question1 {

    public int largestLable(int n, int k) {

        if (k != 0)
            return findNoneZero(n, k);
        else
            return findZero(n, k);

    }

    private ArrayList<Integer> getNineInvertedDigits(int value) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (value == 0)
            result.add(0);
        else
            while (value > 0) {
                int digit = value % 9;
                result.add(digit);
                value = value / 9;
            }
        return result;
    }

    private int findNoneZero(int n, int k) {
        int[] arr = new int[10];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (i == k)
                continue;
            arr[index] = i;
            index++;
        }

        ArrayList<Integer> nineBase = getNineInvertedDigits(n);
        int result = 0;
        for (int i = nineBase.size() -1 ; i > -1; i--) {
            index = nineBase.get(i);
            result = result * 10 + arr[index];
        }

        return result;
    }

    private int findZero(int n, int k) {
        ArrayList<Integer> nineBase = getNineInvertedDigits(n);
        for (int i = 0; i < nineBase.size(); i++) {
            int current = nineBase.get(i);

            if (i == nineBase.size() - 1 && current == 0)
                break;

            if (current == -1) {
                nineBase.set(i, 8);
                nineBase.set(i + 1, nineBase.get(i + 1) - 1);
                continue;
            }

            if (nineBase.get(i) == 0) {
                nineBase.set(i, 9);
                nineBase.set(i + 1, nineBase.get(i + 1) - 1);
            }
        }
        int reslut = 0;
        for (int i = nineBase.size() - 1; i > -1; i--) {
            reslut = reslut * 10 + nineBase.get(i);
        }

        return reslut;
    }
}
