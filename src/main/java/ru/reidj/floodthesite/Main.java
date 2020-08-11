package ru.reidj.floodthesite;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int score = 0;
        int moves;
        Scanner scanner = new Scanner(System.in);


        while (score != 9) {
            System.out.println("Сделайте ход");
            moves = scanner.nextInt();

            for (Sites sites : Sites.values()) {
                for (double i : sites.getNumList()) {
                    if (moves == i) {
                        int index = sites.getNumList().indexOf(moves);
                        if (index >= 0)
                            sites.getNumList().remove(index);
                        score++;
                        System.out.println("Вы попали в " + sites.getName());

                        if (sites.getNumList().isEmpty())
                            System.out.println("Вы потопили " + sites.getName());
                        break;
                    }
                }
            }
        }
    }
}
