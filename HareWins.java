class Tortoise2 extends Thread {
    private final Object lock;

    public Tortoise2(Object lock) {
        this.lock = lock;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (lock) {
                if (i == 5) {
                    try {
                        System.out.println("Tortoise is slowing down...");
                        lock.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
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

class Hare2 implements Runnable {
    private final Object lock;

    public Hare2(Object lock) {
        this.lock = lock;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (lock) {
                System.out.println("Hare running lap " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Hare finished the race!");
    }
}

public class HareWins {
    public static void main(String[] args) {
        Object lock = new Object();
        Tortoise2 tortoise = new Tortoise2(lock);
        Thread hare = new Thread(new Hare2(lock));

        tortoise.start();
        hare.start();
    }
}
