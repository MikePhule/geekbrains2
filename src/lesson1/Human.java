package lesson1;

public class Human implements Competitable {

    static int counter;

    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public Human(int maxRunDistance, int maxJumpHeight) {
        this.name = "Human " + counter;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        counter++;
    }

    @Override
    public boolean jump(int height) {
        System.out.println(name + " jumping...");
        return height <= maxJumpHeight;
    }

    @Override
    public boolean run(int distance) {
        System.out.println(name + " running...");
        return distance <= maxRunDistance;
    }
}
