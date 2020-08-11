package ru.reidj.floodthesite;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int score = 0;
        int moves;
        Scanner scanner = new Scanner(System.in);

        while (score != 3) {
            System.out.println("Сделайте ход");
            moves = scanner.nextInt();

            int num = (int) (Math.random() * 10);
            int[] locationsCell = {num, num + 1, num + 2};

            for (int i : locationsCell) {
                if (moves == i) {
                    score++;
                    System.out.println("Вы попали!");
                    break;
                }
            }

            if (score == locationsCell.length) {
                System.out.println("Вы потопили vk.com :(");
            }
        }
    }
}
