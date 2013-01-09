package ex05.co05_02.cyclicbariertest;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class CyclicBarierTest {

    CyclicBarrier barrier;
    Random r = new Random();

    CyclicBarierTest() {
        int N = 5;

        // pierwszy parametr okresla, ile watkow musi dojsc do bariery
        // jesli do bariery dojdzie podana liczba watkow, to zostanie utuchomiony kolejny watek 
        // z wykorzystaniem drugiego parameretru konstruktora
        barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("Przetwarzanie zakonczone!");
            }
        });
        for (int i = 0; i < N; i++) {
            new Particle(i).start();
        }
        System.out.println("Threads started.");
    }

    class Particle extends Thread {

        int n;

        public Particle(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 4; i++) {
                    System.out.println("Przetwarzam czastke " + n + " po raz " + i);
                    Thread.sleep(500 + r.nextInt(3000));
                    barrier.await();
//                    if (barrier.await() == 0) {
//                        System.out.println("Czastka " + n + " zakonczyla przetwarzanie jako pierwsza\n");
//                    }
                }
            } catch (InterruptedException e) {
            } catch (BrokenBarrierException w) {
            }
        }
    }

    public static void main(String[] args) {
        new CyclicBarierTest();
    }
}