package Part3;

import java.time.LocalDate;
import java.util.Scanner;

public class ManageTask {
    public static void main(String[] args) { Scanner sc = new Scanner(System.in);

        System.out.println("enter the max size of the queue");
        int max = sc.nextInt();
        BoundedPriorityQueuSet queue = new BoundedPriorityQueuSet(max);

        int num = 0;
        do {

            System.out.println("1: Add a new Task \n"
                    +"2: View the new Task \n"
                    +"3: Mark the new Task as done\n" +
                    "4: View the number of Tasks remaining\n" +
                    "5: View the space remaining in the queue\n"
                    +"6: Exit the program");
            num = sc.nextInt();

            switch (num){
                case 1:
                    System.out.println("enter Owner");
                    String Owner = sc.next();

                    System.out.println(Owner);
                    System.out.println("enter the description");
                    String description = sc.next();
                    System.out.println(description);

                    System.out.println("enter the deadline follow this format yyyy-mm-dd");
                    String deadline = sc.next();
                    System.out.println(deadline);
                    LocalDate deadLine = LocalDate.parse(deadline);
                    Task newtask = new Task(Owner, description, deadLine);
                    queue.add(newtask);
                    break;

                case 2:
                    System.out.println("The next task " + queue.peek());
                    break;
                case 3:
                   if (!queue.isEmpty()){
                       queue.remove();
                       if (queue.isEmpty()){
                           System.out.println("Congratulation you finished your tasks");
                       }
                   }

                   else {
                       System.out.println("queue is empty");
                   }
                   break;
                case 4:
                    System.out.println("the number of tasks remaining is " + queue.size());
                    break;
                case 5:
                    System.out.println("the space remaining is " + (max - queue.size()));
                    break;

                case 6:
                queue.WriteToFile("src/main/java/Part3/remainingTasks.txt");
                    break;
                default:
                    System.out.println("enter a valid number between 1-6 ");
            }
        }while (num !=6);
    }
}
