package lesson5;

public class Counter implements Runnable {
    private  float[] arr;
    private int startIndex;

    public Counter(float[] arr, int startIndex) {
        this.arr = arr;
        this.startIndex = startIndex;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + startIndex) / 5) * Math.cos(0.2f + (i + startIndex) / 5) * Math.cos(0.4f + (i + startIndex) / 2));
        }
    }
}
