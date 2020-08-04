package ru.reidj.floodthesite;

import java.util.Scanner;

public class Logic {
    private int[] locationsCell = {2, 7, 1};
    private int score = 0;
    private int moves;

    public void checkYourSelf() {
        while (score != 3) {
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
