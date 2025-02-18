import java.util.*;

public class HistoryManagement {
    private static Stack<String> backStack = new Stack<>();
    private static Stack<String> forwardStack = new Stack<>();
    private static ArrayList<String> history = new ArrayList<>();
    private static String current = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to History Management");
            System.out.println("1. Previous");
            System.out.println("2. Next");
            System.out.println("3. Search");
            System.out.println("4. Add Action");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    previous();
                    break;
                case 2:
                    next();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    addAction(sc);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        sc.close();
    }
    private static void previous() {
        if (!backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop(); 
            System.out.println("Previous action: " + current);
        } else {
            System.out.println("No previous actions available.");
        }
    }
    private static void next() {
        if (!forwardStack.isEmpty()) {
            backStack.push(current);   
            current = forwardStack.pop(); 
            System.out.println("Next action: " + current);
        } else {
            System.out.println("No next actions available.");
        }
    }
    private static void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine();
        boolean found = false;

        System.out.println("--- Search Results ---");
        for (String action : history) {
            if (action.contains(keyword)) {
                System.out.println(action);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching history found.");
        }
    }
    private static void addAction(Scanner sc) {
        System.out.print("Enter action details: ");
        String action = sc.nextLine();
        
          forwardStack.clear();
        
        if (current != null) {
            backStack.push(current);
        }
        current = action;
        history.add(action); 

        System.out.println("Action added: " + current);
    }
}