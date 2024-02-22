import java.util.ArrayList;
import java.util.Scanner;

public class to_do_list {
    private ArrayList<String> tasks;
    private Scanner scanner;

    public to_do_list() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n----- To-Do List Menu -----");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Update Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void addTask() {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("----- Tasks -----");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void updateTask() {
        viewTasks();
        System.out.print("Enter the task number to update: ");
        int taskNumber = Integer.parseInt(scanner.nextLine()) - 1;

        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            System.out.print("Enter the new task: ");
            String newTask = scanner.nextLine();
            tasks.set(taskNumber, newTask);
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void deleteTask() {
        viewTasks();
        System.out.print("Enter the task number to delete: ");
        int taskNumber = Integer.parseInt(scanner.nextLine()) - 1;

        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.remove(taskNumber);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        to_do_list toDoList = new to_do_list();
        int choice;

        do {
            toDoList.displayMenu();
            choice = Integer.parseInt(toDoList.scanner.nextLine());

            switch (choice) {
                case 1:
                    toDoList.addTask();
                    break;
                case 2:
                    toDoList.viewTasks();
                    break;
                case 3:
                    toDoList.updateTask();
                    break;
                case 4:
                    toDoList.deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting the To-Do List application. Bye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
    }
}
