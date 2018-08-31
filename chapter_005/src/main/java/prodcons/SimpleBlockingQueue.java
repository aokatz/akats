package prodcons;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private final Object lock = new Object();
    private final int LIMIT = 3;

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void offer(T value) {
        synchronized (this.lock) {
            while (queue.size() == LIMIT) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(value);
            lock.notifyAll();
        }
    }

    public T poll() throws InterruptedException {
        T retvalue;
        synchronized (this.lock) {
            while (queue.isEmpty()) {
                lock.wait();
            }
            retvalue = queue.poll();
            lock.notifyAll();
            return retvalue;
        }
    }
}