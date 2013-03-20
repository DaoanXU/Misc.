package numbers_with_broken_key;

import java.util.ArrayList;

public class NaturalNumberBase {

    private int base;
    private ArrayList<Integer> invertedDigits;

    public NaturalNumberBase(int base) {
        this.base = base;
        this.invertedDigits = new ArrayList<Integer>();
        this.invertedDigits.add(0);
    }

    public NaturalNumberBase(int base, int value) {
        this.base = base;
        this.invertedDigits = new ArrayList<Integer>();
        if (value == 0)
            this.invertedDigits.add(0);
        else
            this.setValue(value);
    }

    public void setValue(int value) {
        while (value > 0) {
            int digit = value % base;
            this.invertedDigits.add(digit);
            value = value / base;
        }
    }

    public int getValue() {
        int value = 0;
        for (int i = this.invertedDigits.size() - 1; i > -1; i--) {
            value = value * base + this.invertedDigits.get(i);
        }
        return value;
    }

    public String getLiteral() {
        StringBuffer sb = new StringBuffer();
        for (int i = this.invertedDigits.size() - 1; i > -1; i--) {
            sb.append(this.invertedDigits.get(i));
        }
        return sb.toString();
    }
    
    public ArrayList<Integer> getCopyInvertedLigits(){
        return new ArrayList<Integer>(this.invertedDigits);
    }

    public void add(int NaturalNumberBase) {

    }

}
