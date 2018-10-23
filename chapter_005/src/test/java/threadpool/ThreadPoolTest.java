package threadpool;

import org.junit.Test;


public class ThreadPoolTest {

    public class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                System.out.println("Executing : " + name);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void whenAddToPoolThenExecute() {
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 3; i++) {
            System.out.println("Created: " + i);
            threadPool.work(new Task(Integer.toString(i)));
        }
    }

}