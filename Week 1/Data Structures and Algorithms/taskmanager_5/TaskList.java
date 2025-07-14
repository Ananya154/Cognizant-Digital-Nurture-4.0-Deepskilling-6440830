package taskmanager_5;

import java.util.Scanner;

public class TaskList {
    private TaskNode head = null;

    public static void main(String[] args) {
        TaskList manager = new TaskList();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n-- Task Manager --");
            System.out.println("1. Add Task");
            System.out.println("2. Show All Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    manager.addTask(scanner);
                    break;
                case 2:
                    manager.showTasks();
                    break;
                case 3:
                    manager.searchTask(scanner);
                    break;
                case 4:
                    manager.deleteTask(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Task Manager...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (option != 5);

        scanner.close();
    }

    public void addTask(Scanner scanner) {
        System.out.print("Enter Task ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Task Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Task Status (Pending/Done): ");
        String status = scanner.nextLine();
        Task newTask = new Task(id, name, status);
        TaskNode newNode = new TaskNode(newTask);

        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        System.out.println("Task added successfully.");
    }

    public void showTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n--- Task List ---");
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void searchTask(Scanner scanner) {
        System.out.print("Enter Task ID to search: ");
        int id = scanner.nextInt();
        TaskNode current = head;

        while (current != null) {
            if (current.task.taskId == id) {
                System.out.println("Task Found: " + current.task);
                return;
            }
            current = current.next;
        }

        System.out.println("Task not found.");
    }

    public void deleteTask(Scanner scanner) {
        System.out.print("Enter Task ID to delete: ");
        int id = scanner.nextInt();

        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        TaskNode current = head;
        while (current.next != null) {
            if (current.next.task.taskId == id) {
                current.next = current.next.next;
                System.out.println("Task deleted.");
                return;
            }
            current = current.next;
        }

        System.out.println("Task not found.");
    }
}
