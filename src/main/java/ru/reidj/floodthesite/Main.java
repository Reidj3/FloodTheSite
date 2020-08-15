package ru.reidj.floodthesite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int score = 0;
        int attempt = 0;
        int moves;
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Sites> sites = new HashMap<>();
        sites.put((int) (Math.random() * 10), new Sites("VK.COM!"));
        sites.put((int) (Math.random() * 8), new Sites("TWITTER.COM!"));
        sites.put((int) (Math.random() * 13), new Sites("MAIL.RU!"));

        try {
            while (score != 3) {
                System.out.println("Сделайте ход:");
                moves = scanner.nextInt();
                attempt++;

                for (Iterator<Map.Entry<Integer, Sites>> it = sites.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<Integer, Sites> name = it.next();
                    for (Integer keys : sites.keySet()) {
                        if (moves == keys) {
                            it.remove();
                            score++;
                            System.out.println("Вы потопили " + name.getValue().getName());
                        }
                        if (sites.isEmpty())
                            System.out.println("Игра окончена! \nВам потребовалось " + attempt + " хода(ов)");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка!" + e +  " .Перезапустите программу");
        }
    }
}
