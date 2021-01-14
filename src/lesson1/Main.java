package lesson1;

public class Main {
    public static void main(String[] args) {
        Competitable[] competitableList = new Competitable[] {
            new Cat(200, 4),
            new Robot(500, 5),
            new Human(350, 3)
        };

        Challengeable[] challengeables = new Challengeable[] {
                new Wall(2),
                new Wall(4),
                new RunningWay(150),
                new RunningWay(400)
        };

        for (Competitable competitable : competitableList) {
            for (Challengeable challengeable : challengeables) {
                if (challengeable.challenge(competitable)) {
                    System.out.println("done");
                } else {
                    System.out.println("failed");
                    break;
                }
            }
        }

    }
}
