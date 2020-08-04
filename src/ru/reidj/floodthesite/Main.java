package ru.reidj.floodthesite;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int score = 0;
        int moves;

        while (score != 3) {
            int num = (int) (Math.random() * 10);
            int[] locationsCell = {num, num + 1, num + 2};

            System.out.println("Сделайте ход");
            Scanner scanner = new Scanner(System.in);
            moves = scanner.nextInt();

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
