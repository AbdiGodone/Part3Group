package Part3;

import java.util.LinkedList;

public class BoundedPriorityQueuSet {
    private LinkedList<Task> BoundedPriorityQueueSet;
    private int Maxsize;


    public BoundedPriorityQueuSet(){
        BoundedPriorityQueueSet = new LinkedList<>();
        this.Maxsize = 10;
    }

    public BoundedPriorityQueuSet(int Maxsize) {
        if (Maxsize <= 0){
            throw new IllegalArgumentException("max size needs to be greater than 0");

        }
       this.BoundedPriorityQueueSet = new LinkedList<>();
        this.Maxsize = Maxsize;
    }

    public int size(){
        return BoundedPriorityQueueSet.size();
    }

    public boolean isFull(){
        return size() == Maxsize;
    }





}
