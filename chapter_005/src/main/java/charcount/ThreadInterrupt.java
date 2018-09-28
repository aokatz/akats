package charcount;

public class ThreadInterrupt {
    int nanoseconds;
    String text;
    private volatile boolean isRunning = true;

    public ThreadInterrupt(int nanoseconds, String text) {
        this.nanoseconds = nanoseconds;
        this.text = text;
    }

    public class CountChar implements Runnable {
        charcount.CountChar countChar = new charcount.CountChar(text);
        @Override
        public void run() {
            while (isRunning) {
                countChar.count();
                break;
            }
        }
    }

    public class Time implements Runnable {
        long currTime;

        @Override
        public void run() {
            currTime = System.nanoTime();
            long elapsedTime = System.nanoTime() - currTime;
            while (elapsedTime < nanoseconds) {
                elapsedTime = System.nanoTime() - currTime;
            }
            isRunning = false;
        }
    }

    public void count() {
        Thread timeThread = new Thread(new Time());
        Thread countThread = new Thread(new CountChar());
        timeThread.start();
        countThread.start();
    }

    public static void main(String[] args) {
        ThreadInterrupt threadInterrupt = new ThreadInterrupt(1, "sdfsdf sdfs 123 123123da asdasd as asd asd asd a");
        threadInterrupt.count();
    }

}
