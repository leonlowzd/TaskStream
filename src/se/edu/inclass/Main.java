package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

        printData(tasksData);
        System.out.println("Printing deadlines");
        printDeadlines(tasksData);

        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));

        printDataUsingStreams(tasksData);
        printDeadlinesUsingStream(tasksData);

        System.out.println("Total number of deadlines using streams: " + countDeadlinesUsingStreams(tasksData));

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlinesUsingStreams(ArrayList<Task> tasksData) {
        System.out.println("Calculating Deaadlings using streams");
        int count;
        count = (int) tasksData.stream()
                .filter((t)-> t instanceof Deadline )
                .count(); // only allow one final action
        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDataUsingStreams(ArrayList<Task> tasksData) {
        System.out.println("Printing Data using Stream ");
        tasksData.stream() //converting into stream
                // Iterate each data inside and calling println as object
                .forEach(System.out::println);

    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        // casting action during the for loop
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlinesUsingStream(ArrayList<Task> tasksData) {
        System.out.println("Printing Deadline using Stream ");
        tasksData.stream() //converting into stream
                // Choose condition for data to filter
                .filter((t) -> t instanceof Deadline)
                .forEach(System.out::println);
    }
}
