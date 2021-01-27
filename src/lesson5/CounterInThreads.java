package lesson5;

public class CounterInThreads implements Runnable {
    private int startIndex;
    private int endIndex;

    public CounterInThreads(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = 0; i < endIndex; i++) {
            Main.arr[i] = (float)(Main.arr[i] * Math.sin(0.2f + (i + startIndex) / 5) * Math.cos(0.2f + (i + startIndex) / 5) * Math.cos(0.4f + (i + startIndex) / 2));
        }
    }
}
