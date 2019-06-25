package net.iliabvf.intCollection;

import java.util.ArrayList;
import java.util.Collections;

public class IntCollection {

    private ArrayList<Integer> intList;

    public IntCollection() {
        this.intList = new ArrayList<Integer>();
    }

    public int getSize() {
        return this.intList.size();
    }

    public void add(Integer value) {
        Integer oldValue = 0;
        for (int i = 0; i < this.intList.size(); i++){
            oldValue = this.intList.get(i);
            this.intList.set(i, (oldValue + value));
        }
        this.intList.add(value);
    }

    public void remove(Integer index) {
        this.intList.remove(index);
    }

    public ArrayList<Integer> getIntList() {
        return this.intList;
    }

    public void setIntList(ArrayList<Integer> intList) {
        this.intList = intList;
    }

    public float getMid(){
        float mid = 0;
        for (Integer n:this.intList) {
            mid = mid + n;
        }
        return mid / this.intList.size();

    }

    public int getMax(){
        return Collections.max(this.intList);

    }

    public int getMin(){
        return Collections.min(this.intList);

    }

}
