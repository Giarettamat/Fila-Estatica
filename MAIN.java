public class MAIN<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public MAIN(int size) {
        this.size = size;
        data = (T[]) new Object[size];
    }

    public void add(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        top = move(top);
        data[top] = item;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = data[base];
        base = move(base);

        // Caso a fila fique vazia após a remoção, resetamos top e base
        if (base == move(top)) {
            top = -1;
            base = 0;
        }

        return item;
    }

    public void clear() {
        top = -1;
        base = 0;
        data = (T[]) new Object[size];
    }

    public boolean isFull() {
        return move(top) == base && data[base] != null;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private int move(int position) {
        return (position + 1) % size;
    }

    public static void main(String[] args) {
        MAIN<Integer> queue = new MAIN<>(5);

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
