import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {

        // 1. Initialize the custom stack
        MyStack myStack = new MyStack();

        System.out.println("=========================================");
        System.out.println("    CUSTOM DATA STRUCTURE DIAGNOSTICS");
        System.out.println("=========================================\n");

        // 2. Test execution of the push method and dynamic growth triggers
        System.out.println("--- EXECUTING DATA INPUT (PUSH) ---");
        myStack.push("apple");
        myStack.push("banana");
        myStack.push("Coconut");
        myStack.push("Cherry");
        myStack.push("Orange");
        myStack.push("Kiwi");
        System.out.println("Status: 6 elements successfully pushed.\n");

        // 3. Display current metrics and allocation bounds
        System.out.println("--- TRACKING METRICS & MEMORY STATE ---");
        System.out.println("Current Stack Size: " + myStack.size);
        System.out.println("Current Array Capacity: " + myStack.capacity);
        System.out.print("Visual Layout: ");
        myStack.display();
        System.out.println();

        // 4. Test look-ahead functionality
        System.out.println("--- EXECUTING LOOK-AHEAD (PEEK) ---");
        // Peek isn't supposed to return something to the console normally, printing explicitly here:
        System.out.println("The top element is: " + myStack.peek() + "\n");

        // 5. Test data removal and state tracking checks
        System.out.println("--- EXECUTING DATA DELETION (POP) ---");
        System.out.println("Popped: " + myStack.pop());
        System.out.println("Popped: " + myStack.pop());
        System.out.println("Popped: " + myStack.pop());
        System.out.println("Popped: " + myStack.pop());
        System.out.println();

        // 6. Test boundary interceptors and exception safety handles
        System.out.println("--- EXECUTING BOUNDARY SAFETY TESTING ---");
        try {
            System.out.println("Popped: " + myStack.pop());
            System.out.println("Popped: " + myStack.pop());
            System.out.println("Attempting illegal pop on empty stack...");
            System.out.println("Popped: " + myStack.pop());
        } catch (EmptyStackException e) {
            System.out.println("Intercepted State: *STACK UNDERFLOW ERROR CAUGHT SUCCESSFULLY*");
        }

        System.out.println("\n=========================================");
        System.out.println("          DIAGNOSTICS COMPLETE");
        System.out.println("=========================================");
    }
}
