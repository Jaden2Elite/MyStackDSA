import java.util.EmptyStackException;

public class MyStack {

    int size;
    int capacity;
    Object[] array;
    int top = -1;
    int maxCapacity = 1000000;

    public MyStack() {
        this.capacity = 5;
        this.array = new Object[capacity];
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public void push(Object data) {
        if (size >= capacity) {
            int newCapacity = this.capacity * 2;
            resize(newCapacity);
        }
        array[size] = data;
        size++;
        top++;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        Object poppedData = array[size];
        top--;
        if (size > 0 && size <= capacity / 4) {
            int shrunkCapacity = capacity / 2;
            resize(shrunkCapacity);
        }
        return poppedData;
    }

    private void resize(int newCapacity) {
        if (newCapacity > maxCapacity) {
            throw new IllegalStateException("*STACK OVERFLOW*");
        }
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
        this.capacity = newCapacity;

    }

    public Object peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("[ Empty Stack ]");
        }
        System.out.println(this.toString());
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
       if (size == 0) {
           return "";
       }
       StringBuilder sb = new StringBuilder();
        sb.append("Top -> [");
        for (int i = top; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("] <- Bottom");
        return sb.toString();
    }
}