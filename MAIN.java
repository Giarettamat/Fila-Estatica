import java.util.LinkedList;
import java.util.Queue;

public class MAIN {
    private Queue<Integer> queue;
    private int maxSize;

    public MAIN(int size) {
        this.queue = new LinkedList<>();
        this.maxSize = size;
    }

    public void add(int item) {
        if (queue.size() == maxSize) {
            throw new IllegalStateException("Queue is full");
        }
        queue.add(item);
    }

    public int remove() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.poll();
    }

    public void clear() {
        queue.clear();
    }

    public boolean isFull() {
        return queue.size() == maxSize;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        // Exemplo de uso
        MAIN queue = new MAIN(5);
        
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.remove()); // Deve imprimir 1
        System.out.println(queue.remove()); // Deve imprimir 2

        queue.add(6);
        queue.add(7);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove()); // Deve imprimir os valores restantes na fila
        }
    }
}
