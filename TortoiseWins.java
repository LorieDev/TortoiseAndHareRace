class Tortoise extends Thread {
    private final Object lock;

    public Tortoise(Object lock) {
        this.lock = lock;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (lock) {
                System.out.println("Tortoise running lap " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Tortoise finished the race!");
    }
}

class Hare implements Runnable {
    private final Object lock;

    public Hare(Object lock) {
        this.lock = lock;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (lock) {
                if (i == 5) {
                    try {
                        System.out.println("Hare is taking a nap...");
                        lock.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Hare running lap " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Hare finished the race!");
    }
}

public class TortoiseWins {
    public static void main(String[] args) {
        Object lock = new Object();
        Tortoise tortoise = new Tortoise(lock);
        Thread hare = new Thread(new Hare(lock));

        tortoise.start();
        hare.start();
    }
}
