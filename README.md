#  Tortoise and Hare Race – Java Multithreading Example

This project simulates the classic **Tortoise and the Hare** story using Java threads and synchronization. It demonstrates how multiple threads can work together while managing access to shared resources.

---

##  What It Does

- Creates two characters: a **Tortoise** (extends `Thread`) and a **Hare** (implements `Runnable`)
- Both share a common lock object for synchronization
- The Tortoise runs at a consistent pace
- The Hare runs faster but takes a nap on lap 5 (using `wait()`)

---

## Concepts Used

- Java Threads (`Thread`, `Runnable`)
- `synchronized` blocks
- `Thread.sleep()`
- `Object.wait()` for simulating a pause
- Concurrency control

---

##  How to Run the Program

1. Copy or download the file `TortoiseWins.java`
2. Compile it using any Java compiler:
   ```bash
   javac TortoiseWins.java
