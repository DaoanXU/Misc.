package numbers_with_broken_key;

public class Question1NumGenerator {

    private int current;
    private int broken;

    public Question1NumGenerator(int start, int broken) {
        this.current = start;
        this.broken = broken;
        while(!valid()){
            current = current + 1;
        }
    }
    
    public int next(){
        int toReturn = current;
        current++;
        while(!valid()){
            current = current + 1;
        }
        return toReturn;
    }

    public boolean valid() {
        int tmp = current;
        while (tmp > 0) {
            int ttmp = tmp % 10;
            if(ttmp == broken)
                return false;
            tmp = tmp / 10;
        }
        return true;
    }

}
