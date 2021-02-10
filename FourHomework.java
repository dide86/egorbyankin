package ru.geekbrains.lesson1;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class FourHomework {
    //поле
    private static char[][] map;
    private static final int SIZE = 3;
    private static final int DOT_TO_WIN = 3;
    //ячейки
    private static final char DOT_EMPTY = '-';
    private static final char DOT_X = 'x';
    private static final char DOT_O = 'O';
    //Сканер
    private static Scanner sc = new Scanner(System.in);

    private static Random rand = new Random();

    public static void main(String[] args) {
        intMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (checkWin(DOT_X)) {
                System.out.println("Вы победили!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            System.out.println();
            if (checkWin(DOT_O)) {
                System.out.println("Победил компьютер!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    private static void intMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    //вывод поля в консоль
    private static final void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");

            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x, y; //координаты
        do {
            System.out.println("Введите координаты в формате x и y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;

        } while (!isCellValid(x, y));

        map[y][x] = DOT_X;

    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

//    public static void trueTurnAi(int y, int x, char sym) {
//        map[y][x] = sym;
//    }

    private static void aiTurn() {
        //4*** задание на ИИ, помогите разобраться в чем проблема, при его включении он начинает удалять мои и свои ходы
//        for (int i = 0; i < SIZE; i++)
//            for (int j = 0; j < SIZE; j++) {
//                if (isCellValid(i, j)) {
//                    trueTurnAi(i, j, DOT_O);
//                    if (checkWin(DOT_O)) return;
//                    trueTurnAi(i, j, DOT_EMPTY);
//                }
//            }
//        for (int i = 0; i < SIZE; i++)
//            for (int j = 0; j < SIZE; j++) {
//                if (isCellValid(i, j)) {
//                    trueTurnAi(i, j, DOT_X);
//                    if (checkWin(DOT_X)) {
//                        trueTurnAi(i, j, DOT_EMPTY);
//                        return;
//                    }
//                    trueTurnAi(i, j, DOT_EMPTY);
//                }
//           }
        int x, y;
        do {
            x = rand.nextInt(SIZE) - 1;
            y = rand.nextInt(SIZE) - 1;
        } while (!isCellValid(x, y));

        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));

        map[x][y] = DOT_O;
    }
    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char symb) {
        //строки,
        int b = 0;//счетчик одинаковых символов
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    b++;
                    if (b == DOT_TO_WIN) return true;
                }
            }
            b = 0;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) {
                    b++;
                    if (b == DOT_TO_WIN) return true;
                }
            }
            b = 0;
        }
        b = 0;
        for (int i = 0, j = 0; i < SIZE; i++, j++) {
            if (map[i][j] == symb) {
                b++;
                if (b == DOT_TO_WIN) return true;
            }
        }
        b = 0;
        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            if (map[i][j] == symb) {
                b++;
                if (b == DOT_TO_WIN) return true;
            }
        }
//        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//        //столбцы
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//        //диагонали
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;

        return false;
    }
}