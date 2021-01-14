package lesson1;

public class Wall implements Challengeable {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean challenge(Competitable c) {
        return c.jump(this.height);
    }
}
