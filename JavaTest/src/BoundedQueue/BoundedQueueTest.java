package BoundedQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoundedQueueTest {

    private BoundedQueue queue;

    @BeforeEach
    public void setUp() {
        this.queue = new BoundedQueue(4);
    }

    @Test
    public void testEmptyQueue() {
        Assertions.assertTrue(this.queue.isEmpty());
    }

    @Test
    public void testEnqueue() {
        int number = 0;
        this.queue.enQueue(number);
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    public void testDequeue() {
        int number = 0;
        this.queue.enQueue(number);
        Assertions.assertEquals(number, this.queue.deQueue());
    }

    @Test
    public void testFullQueue() {
        int number_0 = 0, number_1 = 1, number_2 = 2, number_3 = 3;

        this.queue.enQueue(number_0);

        this.queue.enQueue(number_1);
        Assertions.assertFalse(this.queue.isFull());

        this.queue.enQueue(number_2);
        Assertions.assertFalse(this.queue.isFull());

        this.queue.enQueue((number_3));
        Assertions.assertTrue(this.queue.isFull());
    }

    @Test
    public void testToString() {
        int number_0 = 0, number_1 = 1, number_2 = 2, number_3 = 3;

        this.queue.enQueue(number_0);
        this.queue.enQueue(number_1);
        this.queue.enQueue(number_2);
        this.queue.enQueue(number_3);

        Assertions.assertEquals("[0, 1, 2, 3]", this.queue.toString());
    }
}