package ex05_04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Ex05_04 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int N = 5;

        FutureTask[] futureTasks = new FutureTask[N];

        for (int i = 2; i < N; i++) {
            IsPrimeNumber isPrimeNumber = new IsPrimeNumber(i);
            futureTasks [i] = new FutureTask<Integer>(isPrimeNumber);
            new Thread(futureTasks[i]).start();
            
//            FutureTask<Integer> task = new FutureTask<Integer>(new IsPrimeNumber(i));
//            futureTask[i] = task;
//            Thread t = new Thread(task);
//            t.start();
        }

        int sum = 0;
        
        for (int i = 2; i < N; i++) {
            sum += (Integer) futureTasks[i].get();
            System.out.println(futureTasks[i].get());
        }
        System.out.println("Suma : " + sum);


    }
}

class IsPrimeNumber implements Callable<Integer> {

    private int n;

    public IsPrimeNumber(int n) {
        this.n = n;
    }

    @Override
    public Integer call() {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}