package org.example;
public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] wrongSizeArray = {
                {"1", "2"},
                {"3", "4"}
        };
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "abc", "11", "12"},
                {"13", "14", "15", "16"}
        };
        testArray(correctArray);
        testArray(wrongSizeArray);
        testArray(wrongDataArray);

        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива");
        }
    }

    public static void testArray(String[][] array) {
        try {
            int sum = processArray(array);
            System.out.println("Сумма:" + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера:" + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных:" + e.getMessage());
        }
    }

    public static int processArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4х4");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4х4");
            }
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке [" + i + "] [" + j + "] ");
                }
            }
        }
        return sum;
    }

}
