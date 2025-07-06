import java.util.Scanner;

class Task {
    String taskId;
    String taskName;
    String status;

    Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    void display() {
        System.out.println("Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
    }
}

class TaskNode {
    Task data;
    TaskNode next;

    TaskNode(Task data) {
        this.data = data;
        this.next = null;
    }
}

class TaskLinkedList {
    private TaskNode head;

    // Add task at end
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task added.");
    }

    // Traverse all tasks
    public void showAllTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }
        TaskNode temp = head;
        while (temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }

    // Search task by ID
    public Task searchTask(String id) {
        TaskNode temp = head;
        while (temp != null) {
            if (temp.data.taskId.equals(id)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    // Delete task by ID
    public boolean deleteTask(String id) {
        if (head == null) return false;

        if (head.data.taskId.equals(id)) {
            head = head.next;
            return true;
        }

        TaskNode prev = head;
        TaskNode curr = head.next;

        while (curr != null) {
            if (curr.data.taskId.equals(id)) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\n=== Task Management System ===");
            System.out.println("1. Add Task");
            System.out.println("2. Show All Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();
                    list.addTask(new Task(id, name, status));
                    break;

                case 2:
                    list.showAllTasks();
                    break;

                case 3:
                    System.out.print("Enter Task ID to search: ");
                    String searchId = sc.nextLine();
                    Task task = list.searchTask(searchId);
                    if (task != null) task.display();
                    else System.out.println("Task not found.");
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    String delId = sc.nextLine();
                    if (list.deleteTask(delId))
                        System.out.println("Task deleted.");
                    else
                        System.out.println("Task not found.");
                    break;

                case 5:
                    run = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
