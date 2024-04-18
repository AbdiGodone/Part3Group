package Part3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BoundedPriorityQueuSet {
    private LinkedList<Task> BoundedPriorityQueueSet;
    private int Maxsize;


    public BoundedPriorityQueuSet() {
        BoundedPriorityQueueSet = new LinkedList<>();
        this.Maxsize = 10;
    }

    /**
     * a parameterised constructor with a specified maxSize
     * @param Maxsize the maxSize of the queue LinkedList
     * @throws IllegalArgumentException if the maxSize is less than or equal to 0
     */
    public BoundedPriorityQueuSet(int Maxsize) {
        if (Maxsize <= 0) {
            throw new IllegalArgumentException("max size needs to be greater than 0");

        }
        this.BoundedPriorityQueueSet = new LinkedList<>();
        this.Maxsize = Maxsize;
    }

    /**
     * Gets the number of size in the que LinkList, using LikedList method size
     * @return the size of the que
     */
    public int size() {
        return BoundedPriorityQueueSet.size();
    }

    /**
     * checks whether this queue linkedList is full
     * @return true if this queue is full, false otherwise
     */
    public boolean isFull() {
        return size() == Maxsize;
    }

    /**
     * checks whether this queue is empt
     * @return true if this queue linkedList is empty, false otherwise
     */
    public boolean isEmpty(){
        return BoundedPriorityQueueSet.isEmpty();
    }


    /**
     * calculates the position in which the task would be added to the queue LinkedList based on priority
     * @param task task to be inserted
     * @return the position in which it will be added
     * @throws DuplicateElementException if the task specified is already in the queue linkedList
     */
    private int calcPosition(Task task) {
        int position = 0;
        for (Task task1 : BoundedPriorityQueueSet) {
            if (task1.equals(task)) {
                throw new DuplicateElementException("this task already present");
            }
            if (task1.getDeadline().compareTo(task.getDeadline()) > 0) {
                position++;

            }

        }
        return position;
    }

    /**
     *adds the specified task to the queue linkedList
     * @param task the task to be inserted
     * @throws IllegalStateException if boundedQueue LinkedList is full
     * @throws DuplicateElementException if the task already in the boundedQueue LinkedList
     */
        public void add (Task task){
            if (isFull()) {
                throw new IllegalStateException("the queue is full");
            }
            for (Task task1 : BoundedPriorityQueueSet){
                if (task1.equals(task)){
                    throw new DuplicateElementException("this task already exists");

                }
            }

            BoundedPriorityQueueSet.add(calcPosition(task), task);

        }

    /**
     * adds the specified task to the boundedQueue linkedList if queue is not full and isnt
     * @param task the task to be added
     * @return true if the task was added, false otherwise
     */
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


    /**
     * retrieves a copy of the head of the queue linkedList
     * throws an exception if the bounded-queue is empty
     * @return a copy of the first task in the queue
     */
    public Task Element(){
        if (BoundedPriorityQueueSet.isEmpty()){
            throw new NoSuchElementException("the que is empty");
        }
       return BoundedPriorityQueueSet.peek();

        }

    /**
     * Retrieves a copy of the first Task in the que LinkedList
     * @return the head of the queue linkedList
     */
    public Task peek(){
        if (BoundedPriorityQueueSet.isEmpty()){
            return null;
        }
        return BoundedPriorityQueueSet.peek();
        }

        public Task remove(){
        if (BoundedPriorityQueueSet.isEmpty()){
            throw new NoSuchElementException("the que is empty");
        }
        Task deletedValue = BoundedPriorityQueueSet.peek();
        BoundedPriorityQueueSet.remove();
        return deletedValue;
        }

    /**
     *
     * @return the task that was removed
     */
    public Task poll(){
        if (BoundedPriorityQueueSet.isEmpty()){
            return null;
        }
        return BoundedPriorityQueueSet.poll();
        }


    /**
     * writes the tasks in the queue linkedList to the specified file
     * @param filename the name of the file which the tasks will be written to
     */
    public void WriteToFile(String filename){
        try (FileWriter writer = new FileWriter(filename)){
            for (Task task :BoundedPriorityQueueSet){
                writer.write(task.toString());
            }
            System.out.println("writing to file successful");
        } catch (IOException e) {
            System.out.println("error writing to file" + e.getMessage());;
        }
       }





    }

