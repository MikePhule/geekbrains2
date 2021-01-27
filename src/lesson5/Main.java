package lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static int threadsCount;

    public static void main(String[] args) {

        long start;
        long end;

        Arrays.fill(arr, 1);
        threadsCount = 1;
        start = System.currentTimeMillis();
        doMathCurrentThread(arr);
        end = System.currentTimeMillis();
        System.out.printf("Done with %d threads in %d ms\n", threadsCount, end-start);
        System.out.println("Middle element = " + arr[h]);

        Arrays.fill(arr, 1);
        threadsCount = 2;
        start = System.currentTimeMillis();
        doMathInTwoThreads(threadsCount, arr);
        end = System.currentTimeMillis();
        System.out.printf("Done with %d threads in %d ms\n", threadsCount, end-start);
        System.out.println("Middle element = " + arr[h]);

//        Arrays.fill(arr, 1);
//        threadsCount = 4;
//        start = System.currentTimeMillis();
//        doMathInThreads(threadsCount, arr);
//        end = System.currentTimeMillis();
//        System.out.printf("Done with %d threads in %d ms\n", threadsCount, end-start);
//        System.out.println("Middle element = " + arr[h]);
    }

    private static void doMathInTwoThreads(int threadsCount, float[] arr) {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(new Counter(a1, 0));
        Thread t2 = new Thread(new Counter(a2, h));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
    }

//    private static void doMathInThreads(int threadsCount, float[] arr) {
//        int startPos = 0;
//        int step = arr.length / threadsCount;
//        int endPos = step;
//        List<Thread> threadList = new ArrayList<>();
//        for (int i = 0; i < threadsCount; i++) {
//            threadList.add(new Thread(new CounterInThreads(startPos, endPos)));
//            startPos += step;
//            endPos += step;
//        }
//        for (Thread thread : threadList) {
//            thread.start();
//        }
//        for (Thread thread : threadList) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }


    private static void doMathCurrentThread(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }


}
