import java.util.Scanner;

class QueueArray {
    int max;
    int[] queue;
    int front, rear;

    QueueArray(int size) {
        max = size;
        queue = new int[max];
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        return rear == max - 1;
    }

    boolean isEmpty() {
        return front == -1 || front > rear;
    }

    void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1) front = 0;
            queue[++rear] = value;
            System.out.println("Inserted: " + value);
        }
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println("Removed: " + queue[front++]);
        }
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue elements:");
            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}

public class Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        QueueArray q = new QueueArray(size);

        while (true) {
            System.out.println("\n1.Enqueue  2.Dequeue  3.Peek  4.Display  5.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    q.enqueue(val);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}