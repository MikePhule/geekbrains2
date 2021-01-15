package lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"a","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
        };

        try {
            System.out.println(sumElementsInArray(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int sumElementsInArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length == 4) {
            for (String[] strings : array) {
                if (strings.length == 4) {
                    for (String string : strings) {
                        try {
                            sum += Integer.parseInt(string);
                        } catch (NumberFormatException e) {
                            throw new MyArrayDataException();
                        }
                    }
                } else {
                    throw new MyArraySizeException();
                }
            }
        } else {
            throw new MyArraySizeException();
        }
        return sum;
    }


}
