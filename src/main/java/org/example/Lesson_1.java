package org.example;

public class Lesson_1 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        boolean result = checkSumRange(3, 7);
        System.out.println(result);
        printNumberSign(-99);
        System.out.println(printPositiveOrNegative(10));
        repeatString("Thanks", 5);
        System.out.println(isLeapYear(2026));
        int[] arr = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        invertArray(arr);
        for (int h = 0; h < arr.length; h++) {
            System.out.print(arr[h] + " ");
        }
        int[] arr2 = new int[100];
        fillArray(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i] + " ");
        }
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyLessSix(arr3);
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i] + " ");
        }
        int[][] arr4 = new int[3][3];
        fillMatrix (arr4);
        for (int a = 0; a < arr4.length; a++) {
            for (int b = 0; b < arr4.length; b++) {
                System.out.print(arr4[a][b] + " ");
            }
            System.out.println();
        }
        int [] result1 = createArray(5, 6);
        for (int a = 0; a < result1.length; a++) {
            System.out.print(result1[a] + " ");
        }


    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = -30;
        int b = 10;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor() {
        int value = 30;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println ("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers () {
        int a = 7;
        int b = 15;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    public static boolean checkSumRange (int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }
    public static void printNumberSign (int number) {
        if (number < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }
    public static boolean printPositiveOrNegative (int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void repeatString (String text, int count) {
        for (int g = 0; g < count; g++) {
            System.out.println(text);
        }
    }
    public static boolean isLeapYear (int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void invertArray (int [] arr) {
        for (int h = 0; h < arr.length; h++) {
            if (arr [h] == 0) {
                arr [h] = 1;
            } else {
                arr [h] = 0;
            }
        }
    }
    public static void fillArray (int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr [i] = i + 1;
        }
    }
    public static void multiplyLessSix (int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }
    public static void fillMatrix (int [][] arr) {
        for (int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr.length; b++) {
                if (a == b) {
                    arr [a][b] = 1;
                } else {
                    arr [a][b] = 0;
                }
            }
        }
    }
    public static int[] createArray (int len, int initialValue) {
        int[] arr = new int[len];
        for (int a = 0; a < len; a++) {
            arr [a] = initialValue;
        }
        return arr;
    }

}

