package lesson1;

public class RunningWay implements Challengeable {

    private int distance;

    public RunningWay(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean challenge(Competitable c) {
        return c.run(this.distance);
    }
}
