package ru.geekbrains.lesson1;

// Домашние задание 2 Бянкина Егора
public class SecondHomework {
    public static void main(String[] args) {
        /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0 */
        int[] arr = {1, 0, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        /* 2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21 */
        int[] arr2 = new int[8];
        for (int i = 1, j = 0; i < arr2.length; i++) arr2[i] = j += 3;
        for (int x : arr2) System.out.print(x + " ");
        System.out.println();
        /* 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и
        числа меньшие 6 умножить на 2; */
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами */
        int[][] arr4 = new int[7][7];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0, j2 = arr4[i].length; j < arr4[i].length; j++, j2--) {
                if (i == j || i == (j2 - 1)) arr4[i][j] = 1;
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] arr5 = {10, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = arr5[0], max = arr5[0], indMax = 0, indMin = 0;
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > max) {
                max = arr5[i];
                indMax = i;
            }
            if (arr5[i] < min) {
                min = arr5[i];
                indMin = i;
            }
        }
        System.out.println("Максимальный элемент под номером " + indMax + " в массиве со значением  = " + max);
        System.out.println("Минимальный элемент под номером " + indMin + " в массиве со значением  = " + min);
        System.out.println();
    /* 6.** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть
    true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    граница показана символами ||, эти символы в массив не входят. */
        int[] arr6 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        System.out.println(checkBalance(arr6));
    }

    private static boolean checkBalance(int[] arrParam) {
        int aSum, bSum;

        for (int i = 0; i < arrParam.length + 1; i++) {
            aSum = 0;
            bSum = 0;

            for (int j = 0; j < i; j++) {
                aSum += arrParam[j];
            }

            for (int j = i; j < arrParam.length; j++) {
                bSum += arrParam[j];
            }

            if (aSum == bSum) return true;
        }
        return false;
    }
}


