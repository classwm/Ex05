package ex05.ex05_02;

import java.util.*;
import java.util.concurrent.locks.*;

public class ReaderWriter {

    static Library c = new Library();

    public static void main(String[] args) {
        Thread[] r = new Thread[5];
        Thread[] w = new Thread[5];
        int i;
        for (i = 0; i < r.length; i++) {
            r[i] = new Reader(i, c);
            w[i] = new Writer(i, c);
        }
        for (i = 0; i < r.length; i++) {
            r[i].start();
            w[i].start();
        }
    }
}

class Reader extends Thread {

    int i;
    Library c;

    Reader(int i, Library c) {
        this.i = i;
        this.c = c;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            c.read(this);
        }
    }
}

class Writer extends Thread {

    int i;
    Library c;

    Writer(int i, Library c) {
        this.i = i;
        this.c = c;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            c.write(this);
        }
    }
}

class Library {

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();
    private final Random random = new Random();

    void randomSleep() {
        try {
            Thread.sleep(100 + random.nextInt(1500));
        } catch (InterruptedException e) {
        }
    }

    public void read(Reader c) {
        
        r.lock();
        try {
            System.out.println("Czytelnik wchodzi, czytelników: " + rNumber +", pisarzy: " + wNumber);
            rNumber++;
            randomSleep();
            rNumber--;
            System.out.println("Czytelnik wychodzi.");
        } finally {
            r.unlock();
        }
    }

    public void write(Writer p) {  
        
        w.lock();
        System.out.println("Pisarz wchodzi.");
        wNumber++;
        randomSleep();
        wNumber--;
        System.out.println("Pisarz wychodzi.");
        w.unlock();
    }
    
    int rNumber = 0;
    int wNumber = 0;
}