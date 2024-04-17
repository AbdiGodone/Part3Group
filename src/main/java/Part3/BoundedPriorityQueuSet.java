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
        this.Maxsize = Maxsize;
    }


}
