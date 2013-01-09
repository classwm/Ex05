package ex05.ex05_01;

import java.util.Random;

public class ProducerConsumer {

    Random r = new Random();
    Integer order = null;
    ProducerConsumer.Consumer k = new ProducerConsumer.Consumer();
    ProducerConsumer.Producent p = new ProducerConsumer.Producent();

    class Consumer extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (k) {
                        if (order == null) {
                            wait();
                        }
                        System.out.println("Skonsumowalem " + order);
                        Thread.sleep(r.nextInt(500));
                        order = null;
                    }
                }
            } catch (InterruptedException e) {
            }
        }
    }

    class Producent extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (k) {
                        if (order == null) {
                            order = new Integer(r.nextInt(500));
                            System.out.println("Wyprodukowalem: " + order);
                            Thread.sleep(r.nextInt(500));
                            k.notify();
                        }
                    }
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer app = new ProducerConsumer();
        app.k.start();
        app.p.start();
    }
}