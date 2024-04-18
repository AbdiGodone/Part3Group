package Part3;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BoundedPriorityQueuSet {
    private LinkedList<Task> BoundedPriorityQueueSet;
    private int Maxsize;


    public BoundedPriorityQueuSet() {
        BoundedPriorityQueueSet = new LinkedList<>();
        this.Maxsize = 10;
    }

    public BoundedPriorityQueuSet(int Maxsize) {
        if (Maxsize <= 0) {
            throw new IllegalArgumentException("max size needs to be greater than 0");

        }
        this.BoundedPriorityQueueSet = new LinkedList<>();
        this.Maxsize = Maxsize;
    }

    public int size() {
        return BoundedPriorityQueueSet.size();
    }

    public boolean isFull() {
        return size() == Maxsize;
    }

    private int calcPosition(Task task) {
        int position = 0;
        for (Task task1 : BoundedPriorityQueueSet) {
            if (task1.equals(task)) {
                throw new DuplicateElementException("this task already present");
            }
            if (task1.getDeadline().compareTo(task.getDeadline()) > 0) {
                position++;

            }
            return position;
        }
    }

        public void add (Task task){
            if (isFull()) {
                throw new IllegalStateException("the que is full");
            }
            for (Task task1 : BoundedPriorityQueueSet){
                if (task1.equals(task)){
                    throw new DuplicateElementException("this task already exists");

                }
            }

            BoundedPriorityQueueSet.add(calcPosition(task), task);

        }

        public boolean offer(Task task){

        if (isFull()){
            return false;
        }
        for (Task task1 : BoundedPriorityQueueSet){
            if (task1.equals(task)){
                return false;
            }
        }
        BoundedPriorityQueueSet.add(calcPosition(task), task);

        return true;
        }


        public Task Element(){
        if (BoundedPriorityQueueSet.isEmpty()){
            throw new NoSuchElementException("the que is empty");
        }
       return BoundedPriorityQueueSet.peek();

        }



    }

