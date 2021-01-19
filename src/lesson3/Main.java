package lesson3;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Task 1
        String[] words = {
            "Here",
            "We",
            "Have",
            "Some",
            "Words",
            "For",
            "Our",
            "Lesson",
            "We",
            "Have",
            "About",
            "Ten",
            "Words"
        };
        System.out.println("Task 1 output: ");
        System.out.println(getUnique(words));
        System.out.println();

        // Task 2
        PhoneList list = new PhoneList();

        list.add("Иванов", "+79998881111");
        list.add("Петров", "+78887776666");
        list.add("Степанов", "+1112223333");
        list.add("Викторов", "+3335556666");
        list.add("Горшков", "+435435342");
        list.add("Иванов", "+43578732864");
        list.add("Сидоров", "+947846378");
        list.add("Иванов", "+348276828347");
        list.add("Петров", "+42587348993");
        list.add("Иванов", "+345342343");
        list.add("Лапшов", "+4537298798");

        System.out.println("Task 2 output: ");
        System.out.println(list.getPhone("Иванов"));
        System.out.println(list.getPhone("Горшков"));
        System.out.println(list.getPhone("Петров"));

    }

    private static Set<String> getUnique(String[] words) {
        return new LinkedHashSet<>(Arrays.asList(words));
    }
}
