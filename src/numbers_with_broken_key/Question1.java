package numbers_with_broken_key;

import java.util.ArrayList;

public class Question1 {

    public int largestLable(int n, int k) {

        if (k != 0)
            return findNoneZero(n, k);
        else
            return findZero(n, k);

    }

    private int findNoneZero(int n, int k) {
        char[] arr = new char[10];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (i == k)
                continue;
            arr[index] = (char) (i + '0');
            index++;
        }

        String nineBase = new NaturalNumberBase(9, n).getLiteral();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < nineBase.length(); i++) {
            index = nineBase.charAt(i) - '0';
            result.append(arr[index]);
        }

        return Integer.parseInt(result.toString());
    }

    private int findZero(int n, int k) {
        ArrayList<Integer> nineBase = new NaturalNumberBase(9, n).getCopyInvertedLigits();
        for (int i = 0; i < nineBase.size(); i++) {
            int current = nineBase.get(i);
            
            if(i == nineBase.size() - 1 && current == 0)
                break;
            
            if(current == -1){
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
        for (int i = nineBase.size() - 1; i > -1 ; i--) {
            reslut = reslut * 10 + nineBase.get(i);
        }

        return reslut;
    }
}
